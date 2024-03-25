package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Model.Account;
import Model.City;
import Model.DeliveryRequest;
import Model.Dao.CityDao;
import Model.Dao.DeliveryRequestDao;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class AddRequestPanel extends NavContentPanel {
	private JTextField senderPhoneTF;
	private JTextField senderNameTF;
	private JTextArea senderAddressTA;
	private JTextField recipientPhoneTF;
	private JTextField recipientNameTF;
	private JTextArea recipientAddressTA;
	private JTextField weightTF;
	private JTextField descTF;
	private JComboBox originCBx;
	private JComboBox destCBx;
	private JCheckBox fragileChBx;
	private JTextArea tariffTA;
	
	private HashMap<String, City> nameCityHashMap = new HashMap<String, City>();
	
	public AddRequestPanel(MainFrame mainFrame, JPanel prevJPanel) {
		super(mainFrame, prevJPanel);
		contentPane.setBounds(0, 50, 600, 554);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Delivery Request");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 14, 132, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 40, 569, 488);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Personal Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_1 = new JLabel("Sender Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Address");
		
		senderPhoneTF = new JTextField();
		senderPhoneTF.setColumns(10);
		
		senderNameTF = new JTextField();
		senderNameTF.setColumns(10);
		
		senderAddressTA = new JTextArea();
		senderAddressTA.setWrapStyleWord(true);
		senderAddressTA.setRows(3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Recipient Information");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Address");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Phone");
		
		JLabel lblNewLabel_2_2 = new JLabel("Name");
		
		recipientAddressTA = new JTextArea();
		
		recipientPhoneTF = new JTextField();
		recipientPhoneTF.setColumns(10);
		
		recipientNameTF = new JTextField();
		recipientNameTF.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_2_1)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(senderPhoneTF, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
								.addComponent(senderNameTF, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
								.addComponent(senderAddressTA, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_2_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
							.addGap(25)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(recipientAddressTA, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
								.addComponent(recipientPhoneTF, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
								.addComponent(recipientNameTF, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
							.addGap(0, 0, Short.MAX_VALUE)))
					.addGap(86))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(senderNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(senderPhoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1)
						.addComponent(senderAddressTA, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1_1)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2)
						.addComponent(recipientNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_2)
						.addComponent(recipientPhoneTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1_1)
						.addComponent(recipientAddressTA, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(90))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Package Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_3 = new JLabel("Tariff: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tariffTA = new JTextArea();
		tariffTA.setText("Rp. ");
		tariffTA.setFont(new Font("Arial", Font.BOLD, 13));
		tariffTA.setEditable(false);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.addActionListener(e -> submit());
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(e -> calculateAndSet());
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(e -> resetFields());
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tariffTA, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(56, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(209, Short.MAX_VALUE)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSubmit)
					.addGap(71))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(tariffTA, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2_3 = new JLabel("Weight");
		
		weightTF = new JTextField();
		weightTF.setColumns(10);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Kg");
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Description");
		
		descTF = new JTextField();
		descTF.setColumns(10);
		
		originCBx = new JComboBox();
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Origin");
		
		JLabel lblNewLabel_2_3_2_1_1 = new JLabel("Destination");
		
		destCBx = new JComboBox();
		
		fragileChBx = new JCheckBox("   Fragile");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(fragileChBx, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2_3_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3_2_1_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(weightTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_3_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addComponent(originCBx, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(destCBx, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(descTF, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
							.addGap(87))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_3)
						.addComponent(weightTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_3_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_3_2)
						.addComponent(descTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(originCBx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_3_2_1))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_3_2_1_1)
						.addComponent(destCBx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(fragileChBx)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
	}

	private void submit() {
		if(!checkFields()) {
			JOptionPane.showMessageDialog(null, "All Fields Must Be Filled!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		float cost = calculateCost();
		tariffTA.setText(String.format("Rp. %.2f", cost));
		
		String msg = String.format("Your request has cost: Rp. %.2f.\nDo you want to proceed?", cost);
		
		int choice = JOptionPane.showConfirmDialog(null, msg, "Submit Confirmation", JOptionPane.YES_NO_OPTION);
		
		if(choice == JOptionPane.NO_OPTION) {
			return;
		}
		
		String senderName, senderPhone, senderAddress;
		String recipientName, recipientPhone, recipientAddress;
		String description;
		boolean isFragile;
		City cityOrigin, cityDest;
		float weight;
		
		senderName = senderNameTF.getText();
		senderPhone = senderPhoneTF.getText();
		senderAddress = senderAddressTA.getText();
		recipientName = recipientNameTF.getText();
		recipientPhone = recipientPhoneTF.getText();
		recipientAddress = recipientAddressTA.getText();
		weight = Float.parseFloat(weightTF.getText());
		isFragile = fragileChBx.isSelected();
		description = descTF.getText();
		
		cityOrigin = nameCityHashMap.get((String)originCBx.getSelectedItem());
		cityDest = nameCityHashMap.get((String)destCBx.getSelectedItem());
		
		DeliveryRequest request = new DeliveryRequest(
			senderName, senderPhone, senderAddress,
			recipientName, recipientPhone, recipientAddress,
			weight, isFragile, description, cost, new Date(),
			cityOrigin, cityDest
		);
		
		request.setCustomerId(mainFrame.getStore().getAccount().getId());
		System.out.println(request.toString());
		
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Submitting", "Submitting Your Deliver Request...", () ->{
			DeliveryRequestDao dao = new DeliveryRequestDao();
			try {
				dao.add(request);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(null, "Your request have been submitted successfully.\nNow back to Home", "Success",  JOptionPane.INFORMATION_MESSAGE);
			mainFrame.changeContentPaneToHome();
		});
	}

	@Override
	public void init() {
		nameCityHashMap = new HashMap<String, City>();
		LoadingDialog loadingDialog = new LoadingDialog();
		loadingDialog.showDialogAndRun("Loading Cities", "Retrieving data from Database", () -> {
			CityDao cityDao = new CityDao();
			List<City> cities;
			try {
				cities = cityDao.getCitiesAndId();
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				JOptionPane.showMessageDialog(null, "Failed to retrieved data from database", "Error",  JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(cities.size() < 1) {
				JOptionPane.showMessageDialog(null, "City data is empty!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			for(City c: cities) {
				nameCityHashMap.put(c.getName(), c);
			}
			
			Set<String> cityNames = nameCityHashMap.keySet();
			
			DefaultComboBoxModel<String> originComboBoxModel = new DefaultComboBoxModel<>();
			DefaultComboBoxModel<String> destComboBoxModel = new DefaultComboBoxModel<>();
			
			originComboBoxModel.addAll(cityNames);
			destComboBoxModel.addAll(cityNames);
			
			originCBx.setModel(originComboBoxModel);
			destCBx.setModel(destComboBoxModel);
		
			resetFields();
		});
	}
	
	private void resetFields() {
		senderPhoneTF.setText("");
		senderNameTF.setText("");
		senderAddressTA.setText("");
		recipientPhoneTF.setText("");
		recipientNameTF.setText("");
		recipientAddressTA.setText("");
		weightTF.setText("");
		descTF.setText("");
		fragileChBx.setSelected(false);
		tariffTA.setText("Rp. ");
		
		originCBx.setSelectedIndex(0);
		destCBx.setSelectedIndex(1);
	}
	
	private float calculateCost() {
		try {
			if(!checkCalculateFields()) {
				JOptionPane.showMessageDialog(null, "All Fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
				return 0f;
			}
		
		} catch (Exception ignored) {
			JOptionPane.showMessageDialog(null, "Weight must be a number!", "Type Error", JOptionPane.ERROR_MESSAGE);
			return 0f;
		}
			
		City origCity = nameCityHashMap.get((String)originCBx.getSelectedItem());
		City destCity = nameCityHashMap.get((String)destCBx.getSelectedItem());
		
		float weight = Float.parseFloat(weightTF.getText());
		
		float cost = Account.tariffCheck(origCity.getMetric(), destCity.getMetric(), weight, fragileChBx.isSelected());
		
		return cost;
	}
	
	private void calculateAndSet() {
		float cost = calculateCost();
		tariffTA.setText(String.format("Rp. %.2f", cost));
	}
	
	private boolean checkFields() {
		try {
			if(checkCalculateFields()) {
				if(
					senderNameTF.getText().isBlank() ||
					senderAddressTA.getText().isBlank() ||
					senderPhoneTF.getText().isBlank() ||
					recipientNameTF.getText().isBlank() ||
					recipientPhoneTF.getText().isBlank() ||
					recipientAddressTA.getText().isBlank() ||
					descTF.getText().isBlank() 
				)
					return false;
			}
			else
				return false;
				
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	private boolean checkCalculateFields() throws Exception {
		String weight = weightTF.getText();
		
		if(weight.isBlank()) {
			return false;
		}
		
		try {
			Float.parseFloat(weight);	
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		return true;
		
	}
}
