package View;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import Helper.DateHelper;
import Model.DeliveryRequest;
import Model.PackageDelivery;
import Model.PackageHistory;
import Model.Staff;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class AdminPackageDeliveryPanel extends NavContentPanel {
	private JTextField tfPackageId;
	private JTable table;
	private	JButton btnSearch;
	private	JButton btnDetail;
	private DeliveryRequest request;
	private PackageDelivery delivery;
	private DefaultTableModel model;
	private JTextField tfTime;
	private JRadioButton rbDepart;
	private JRadioButton rdbtnReceive;
	private JRadioButton rdbtnLocal;
	private JRadioButton rdbtnForeign;
	private JComboBox<String> cbPlaceType;
	private JCheckBox cbRecipient;
	private	JButton btnRefresh;
	
	private final String[] placeName = {"Recipient", "Drop Center", "Warehouse", "Hub"};
	
	public AdminPackageDeliveryPanel(MainFrame mainFrame, JPanel prevPanel) {
		super(mainFrame, prevPanel);
		
		JLabel lblNewLabel = new JLabel("Package Delivery Discovery");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Search Package ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfPackageId = new JTextField();
		tfPackageId.setColumns(10);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(e -> searchAction());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		
		btnDetail = new JButton("Detail >>");
		btnDetail.setEnabled(false);
		btnDetail.addActionListener(e -> detailAction());
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setEnabled(false);
		btnRefresh.addActionListener(e -> refreshAction());
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(202)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(234))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(tfPackageId, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnSearch))
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(33)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfPackageId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		
		JScrollPane historyTab = new JScrollPane();
		historyTab.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("History", null, historyTab, null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		historyTab.setViewportView(table);
		
		JPanel updateTab = new JPanel();
		updateTab.setBackground(SystemColor.control);
		tabbedPane.addTab("Update", null, updateTab, null);
		
		
		JLabel lblNewLabel_2 = new JLabel("New Package History");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		JLabel lblNewLabel_4 = new JLabel("Time");
				
		rbDepart = new JRadioButton("Depart");
		rdbtnReceive = new JRadioButton("Receive");
		
		ButtonGroup historyType = new ButtonGroup();
		historyType.add(rbDepart);
		historyType.add(rdbtnReceive);
		
		tfTime = new JTextField();
		tfTime.setEditable(false);
		tfTime.setColumns(10);
		
		cbPlaceType = new JComboBox<>();
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();
		cbModel.addAll(Arrays.asList(placeName));
		cbPlaceType.setModel(cbModel);
		
		JLabel lblNewLabel_5 = new JLabel("To:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNewLabel_3_1 = new JLabel("Location");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		ButtonGroup locationGroup = new ButtonGroup();

		rdbtnLocal = new JRadioButton("Local");		
		rdbtnForeign = new JRadioButton("Foreign");
		
		locationGroup.add(rdbtnLocal);
		locationGroup.add(rdbtnForeign);
		
		rdbtnReceive.addActionListener(e -> {
			rdbtnLocal.setEnabled(false);
			rdbtnForeign.setEnabled(false);
			cbPlaceType.setEnabled(false);
		});
		
		rbDepart.addActionListener(e -> {
			rdbtnLocal.setEnabled(true);
			rdbtnForeign.setEnabled(true);
			cbPlaceType.setEnabled(true);
		});
		
		JButton btnCommit = new JButton("Commit");
		btnCommit.addActionListener(e -> commitAction());
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(e -> resetAction());
		
		cbRecipient = new JCheckBox("at Recipient?");
		
		GroupLayout gl_updateTab = new GroupLayout(updateTab);
		gl_updateTab.setHorizontalGroup(
			gl_updateTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateTab.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_updateTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_updateTab.createSequentialGroup()
							.addGroup(gl_updateTab.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_updateTab.createSequentialGroup()
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCommit, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_updateTab.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
									.addGroup(gl_updateTab.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_updateTab.createSequentialGroup()
											.addComponent(rbDepart)
											.addGap(18)
											.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(cbPlaceType, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_updateTab.createSequentialGroup()
											.addComponent(rdbtnReceive, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_updateTab.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2)
												.addComponent(cbRecipient)))
										.addGroup(gl_updateTab.createSequentialGroup()
											.addComponent(rdbtnLocal, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnForeign, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addComponent(tfTime, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
									.addGap(161)))
							.addGap(34))
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
		);
		gl_updateTab.setVerticalGroup(
			gl_updateTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_updateTab.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(gl_updateTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(rdbtnReceive)
						.addComponent(cbRecipient))
					.addGap(18)
					.addGroup(gl_updateTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbDepart)
						.addComponent(lblNewLabel_5)
						.addComponent(cbPlaceType, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_updateTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(rdbtnLocal)
						.addComponent(rdbtnForeign))
					.addGap(18)
					.addGroup(gl_updateTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(tfTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_updateTab.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCommit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		updateTab.setLayout(gl_updateTab);
		contentPane.setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		tfPackageId.setText("");
		btnDetail.setEnabled(false);
		btnRefresh.setEnabled(false);
		
		model = getInitModel();
		initTable();
		resetAction();
	}

	private void detailAction() {
		DeliveryRequestDetailFrame frame = new DeliveryRequestDetailFrame(request, delivery);
		frame.init();
		frame.showFrame();
	}
	
	private void refreshAction() {
		searchAction();
	}
	
	private void searchAction() {
		if(tfPackageId.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Staff staff = (Staff) mainFrame.getStore().getAccount();	
		
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Search", "Searching data", () -> {
			try {
				int id = Integer.valueOf(tfPackageId.getText());
				DeliveryRequest req = staff.getPackageManagement().fetchDeliveryRequestByDeliveryId(id);
				
				if(req == null) {
					JOptionPane.showMessageDialog(null, String.format("Package Delivery with id: %d is not found", id), "Not Found", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				PackageDelivery deliv = staff.getPackageManagement().fetchPackageDeliveryByDeliveryRequest(req);
				
				if(deliv == null) {
					JOptionPane.showMessageDialog(null, String.format("Package Delivery with id: %d is not found", id), "Not Found", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				request = req;
				delivery = deliv;
				
				loadDataToTable();
				btnDetail.setEnabled(true);
				btnRefresh.setEnabled(true);
				resetAction();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
	}
	
	private void loadDataToTable() {
		model = getInitModel();
		initTable();
		
		for(PackageHistory history: delivery.getPackageHistories()) {
			Object[] row = {
				DateHelper.dateToFormattedString(history.getTime()),
				history.getLocation(),
				history.getStatus(),
				history.getDescription(),
				history.getStaffId()
			};
			model.addRow(row);
			System.out.println("history row added...");
		}
	}

	private void initTable() {
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setMinWidth(110);
		table.getColumnModel().getColumn(1).setMaxWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMaxWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(280);
		table.getColumnModel().getColumn(3).setMinWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(300);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	
	private DefaultTableModel getInitModel() {
		return new DefaultTableModel(new Object[][] { },
				new String[] { "Time", "Location", "Status", "Description", "Staff ID" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	}
	
	private void resetAction() {
		rdbtnForeign.setSelected(false);
		rbDepart.setSelected(false);
		rdbtnLocal.setSelected(false);
		rdbtnReceive.setSelected(false);
		cbPlaceType.setSelectedIndex(-1);
		cbRecipient.setSelected(false);
		
		cbPlaceType.setEnabled(false);
		rdbtnLocal.setEnabled(false);
		rdbtnForeign.setEnabled(false);
	}
	
	private void commitAction() {
		if(delivery == null) return;
		
		String type, placeDepart = null, location= null;
		final boolean atRecipient = cbRecipient.isSelected();
		
		if(rdbtnReceive.isSelected()) {
			type = "Receive";
		} else if (rbDepart.isSelected()) {
			type = "Depart";
		} else {
			JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(rbDepart.isSelected()) {
			if(cbPlaceType.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if((!rdbtnLocal.isSelected()) && (!rdbtnForeign.isSelected())) {
				JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			placeDepart = (String) cbPlaceType.getSelectedItem();
			location = rdbtnLocal.isSelected() ? "Local" : "Foreign";
		}
		
		Staff staff = (Staff) mainFrame.getStore().getAccount();
		
		final String finalPlaceDepart = placeDepart;
		final String finalLocation = location;
		
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Search", "Searching data", () -> {
			try {
				staff.getPackageManagement().addHistory(
						type, 
						atRecipient, 
						finalPlaceDepart, 
						finalLocation, 
						new Date(), 
						delivery.getId(),
						staff
					);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
	}
}
