package View;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.util.Date;

import javax.swing.border.TitledBorder;

import Helper.DateHelper;
import Model.DeliveryRequest;
import Model.Staff;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

public class UpdatePickupTimeEstPanel extends NavContentPanel {
	private JTextField tfPrevTime;
	private JTextField tfPrevDate;
	private JTextField tfNewTime;
	private JTextField tfNewDate;
	private JButton btnCommit;
	private JButton btnCancel;
	private JButton btnSetNull;
	private DeliveryRequest request;

	public UpdatePickupTimeEstPanel(MainFrame mainFrame, JPanel prevPanel, DeliveryRequest request) {
		super(mainFrame, prevPanel);
		
		this.request = request;
		
		JLabel lbTitle = new JLabel("Update Pickup Time Estimate");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Previous Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "New Data*", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		
		JLabel lblDate_1 = new JLabel("Date");
		
		tfNewTime = new JTextField();
		tfNewTime.setColumns(10);
		
		tfNewDate = new JTextField();
		tfNewDate.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("HH:MM (ex: 13:24)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("DD/MM/YYYY (ex: 02/12/2024)");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfNewTime, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDate_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfNewDate, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 124, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfNewTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate_1)
						.addComponent(tfNewDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		btnCommit = new JButton("Commit");
		btnCommit.addActionListener(e -> commitAction());
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(e -> mainFrame.changeContentPaneWithoutInit(prevPanel));
		
		btnSetNull = new JButton("SET NULL");
		btnSetNull.addActionListener(e -> setNullAction());
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbTitle)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(355)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSetNull, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCommit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lbTitle)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCommit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSetNull, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Time");
		
		JLabel lblDate = new JLabel("Date");
		
		tfPrevTime = new JTextField();
		tfPrevTime.setEditable(false);
		tfPrevTime.setColumns(10);
		
		tfPrevDate = new JTextField();
		tfPrevDate.setEditable(false);
		tfPrevDate.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfPrevTime, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfPrevDate, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfPrevTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(tfPrevDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}

	private void setNullAction() {
		commit(null);
	}

	private void commitAction() {
		String dateTxt = tfNewDate.getText();
		String timeTxt = tfNewTime.getText();
		
		if(dateTxt.isBlank() || timeTxt.isBlank()) {
			JOptionPane.showMessageDialog(null, "Fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			Date date = DateHelper.parseStringToDate(String.format("%s %s", timeTxt, dateTxt));
			commit(date);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error Parsing Datetime", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void commit(Date date) {
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Updating", "Saving your changes...", () -> {
			try {
				((Staff) mainFrame.getStore().getAccount())
					.getPackageManagement()
					.changePickupTimeEst(request.getId(), date);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
		
		mainFrame.changeContentPaneWithoutInit(prevPanel);
	}

	@Override
	public void init() {
		Date date = request.getPickupTimeEst();
		tfPrevTime.setText(DateHelper.parseDateToHHmm(date));
		tfPrevDate.setText(DateHelper.parseDateToDDMMYYYY(date));
	}
}
