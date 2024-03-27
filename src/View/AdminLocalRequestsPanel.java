package View;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Helper.DateHelper;

import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

import Model.Customer;
import Model.DeliveryRequest;
import Model.PackageDelivery;
import Model.Staff;

public class AdminLocalRequestsPanel extends NavContentPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnDetail;
	private JButton btnRefresh;
	private JButton btnCancel;
	private JButton btnRemove;
	private List<DeliveryRequest> requests = new ArrayList();
	private int selectedRow;
	private final Font defaultFont = new Font("Tahoma", Font.PLAIN, 11);
	private JButton btnPickupEstimate;
	private JButton btnPickup;

	public AdminLocalRequestsPanel(MainFrame mainFrame, JPanel prevPanel) {
		super(mainFrame, prevPanel);

		JLabel lblNewLabel = new JLabel("Local Delivery Requests");
		lblNewLabel.setBounds(10, 11, 175, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnDetail = new JButton("Detail >>");
		btnDetail.setBounds(454, 36, 106, 39);
		btnDetail.addActionListener(e -> detailAction());
		btnDetail.setFont(defaultFont);

		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(454, 432, 106, 39);
		btnRefresh.addActionListener(e -> refreshAction());
		btnRefresh.setFont(defaultFont);

		contentPane.setLayout(null);
		contentPane.add(btnRefresh);
		contentPane.add(btnDetail);
		contentPane.add(lblNewLabel);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 36, 434, 435);
		contentPane.add(scrollPane);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(defaultFont);
		btnCancel.addActionListener(e -> {
			int choice = JOptionPane.showConfirmDialog(null,
					"Are you sure to cancel this request?\nThis process is irreversible", "Cancel Confirmation",
					JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.NO_OPTION)
				return;

			int id = requests.get(selectedRow).getId();

			LoadingDialog loadingDialog = new LoadingDialog();
			loadingDialog.showDialogAndRun("Processing", "Applying your change...", () -> {
				try {
					((Customer) mainFrame.getStore().getAccount()).getPackageManagement().cancelDeliveryRequest(id);
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			});

			refreshAction();
		});

		btnCancel.setEnabled(false);
		btnCancel.setBounds(454, 89, 106, 39);
		contentPane.add(btnCancel);

		btnRemove = new JButton("Remove");
		btnRemove.setFont(defaultFont);
		btnRemove.addActionListener(e -> {
			int choice = JOptionPane.showConfirmDialog(null,
					"Are you sure to remove this request?\nThis process is irreversible", "Remove Confirmation",
					JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.NO_OPTION)
				return;

			int id = requests.get(selectedRow).getId();

			LoadingDialog loadingDialog = new LoadingDialog();
			loadingDialog.showDialogAndRun("Processing", "Deleting your request...", () -> {
				try {
					((Customer) mainFrame.getStore().getAccount()).getPackageManagement().deleteDeliveryRequest(id);
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			});

			refreshAction();
		});

		btnRemove.setEnabled(false);
		btnRemove.setBounds(454, 139, 106, 39);
		contentPane.add(btnRemove);
		
		btnPickupEstimate = new JButton("Pickup Estimate");
		btnPickupEstimate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPickupEstimate.setEnabled(false);
		btnPickupEstimate.setBounds(454, 263, 106, 39);
		contentPane.add(btnPickupEstimate);
		
		btnPickup = new JButton("Pickup");
		btnPickup.setEnabled(false);
		btnPickup.setBounds(454, 320, 106, 39);
		btnPickup.setFont(defaultFont);
		contentPane.add(btnPickup);
		
		JLabel lblNewLabel_1 = new JLabel("Time Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(454, 216, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Controls");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(454, 228, 106, 14);
		contentPane.add(lblNewLabel_1_1);

		AdminLocalRequestsPanel thisPanel = this;

		ListSelectionListener selectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					thisPanel.setSelectedRow(table.getSelectedRow());

					System.out.println("Selected row: " + selectedRow);

					if (selectedRow < 0 || selectedRow >= requests.size())
						return;

					btnDetail.setEnabled(true);
					btnCancel.setEnabled(false);
					btnRemove.setEnabled(false);
					btnPickup.setEnabled(false);
					btnPickupEstimate.setEnabled(false);

					DeliveryRequest request = requests.get(selectedRow);

					if (request.isCanceled()) {
						btnRemove.setEnabled(true);
					} else {
						if (request.getPickupTimeEst() == null)
							btnCancel.setEnabled(true);
						
						btnPickup.setEnabled(true);
						btnPickupEstimate.setEnabled(true);
					}
				}

			}
		};

		table.getSelectionModel().addListSelectionListener(selectionListener);
	}

	private void initTable() {
		tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Created", "Weight (kg)", "Package Description", "Destination", "Pickup Estimate", "Pickup Time", "Status" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		table.setModel(tableModel);

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(1).setMaxWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setMinWidth(175);
		table.getColumnModel().getColumn(3).setMaxWidth(250);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setMinWidth(120);
		table.getColumnModel().getColumn(5).setMaxWidth(120);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setMinWidth(120);
		table.getColumnModel().getColumn(6).setMaxWidth(120);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setMinWidth(90);
		table.getColumnModel().getColumn(7).setMaxWidth(90);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	private void fetchRequests() {
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Loading", "Retrieving your data...", () -> {
			try {
				Staff acc = ((Staff) mainFrame.getStore().getAccount());
				List<DeliveryRequest> reqs = acc.getPackageManagement()
						.fetchAllDeliveryRequests(acc.getId());
				this.setRequests(reqs);
				loadDataToTable();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
	}
	
	private void forceFetchRequests() {
		fetchRequests();
	}

	@Override
	public void init() {
		fetchRequests();
	}

	private void loadDataToTable() {
		initTable();

		for (DeliveryRequest req : requests) {
			Object[] row = { 
					req.getId(), 
					DateHelper.dateToFormattedString(req.getTime()), 
					String.format("%.2f", req.getWeight()),
					req.getStuffDesc(),
					req.getDestCity().getName(), 
					DateHelper.dateToFormattedString(req.getPickupTimeEst()),
					DateHelper.dateToFormattedString(req.getPickupTime()),
					req.isCanceled() ? "Canceled" : "Submitted"
				};

			tableModel.addRow(row);
		}

		btnDetail.setEnabled(false);
		btnCancel.setEnabled(false);
		btnRemove.setEnabled(false);
		btnPickup.setEnabled(false);
		btnPickupEstimate.setEnabled(false);
	}

	private void setRequests(List<DeliveryRequest> requests) {
		this.requests = requests;
	}

	private void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	private void refreshAction() {
		forceFetchRequests();
	}
	
	private void detailAction() {
		DeliveryRequest request = requests.get(selectedRow);
		
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Loading", "Retrieving package's detail...", () -> {
			try {
				PackageDelivery delivery =((Customer) mainFrame.getStore().getAccount())
					.getPackageManagement().fetchPackageDeliveryByDeliveryRequest(request);
				
				DeliveryRequestDetailFrame detailFrame = new DeliveryRequestDetailFrame(request, delivery);
				detailFrame.init();
				detailFrame.showFrame();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
	}
}
