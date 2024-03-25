package View;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import Model.Account;
import Model.City;
import Model.Dao.CityDao;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.security.cert.TrustAnchor;
import java.awt.event.ActionEvent;

public class TariffCheckPanel extends NavContentPanel {
	private HashMap<String, City> nameCityHashMap = new HashMap<String, City>();
	private JPanel panel;
	private JCheckBox fragileCheckbox;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JComboBox originCityCB;
	private JTextField weightTextField;
	private JComboBox destinationCityRB;
	private JLabel lblNewLabel;
	private JButton btnReset;
	private JButton btnCalculate;
	private JTextArea tariffTextArea;
	private JLabel lblNewLabel_2;
	
	public TariffCheckPanel(MainFrame mainFrame, JPanel prevJPanel) {
		super(mainFrame, prevJPanel);
		setLayout(null);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(69, 71, 458, 272);
		panel.setBorder(new TitledBorder(null, "Package Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		
		fragileCheckbox = new JCheckBox("Fragile (Extra Protection)");
		
		lblNewLabel_1 = new JLabel("Weight (Kg rounded)");
		
		lblNewLabel_1_1 = new JLabel("Origin City");
		
		lblNewLabel_1_1_1 = new JLabel("Destination City");
		
		originCityCB = new JComboBox();
		
		weightTextField = new JTextField();
		weightTextField.setColumns(10);
		
		destinationCityRB = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 446, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(fragileCheckbox)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1))
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(originCityCB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(weightTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(destinationCityRB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 250, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(weightTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(originCityCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(destinationCityRB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(fragileCheckbox)
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		
		lblNewLabel = new JLabel("Package Delivery Tariff");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(193, 30, 149, 16);
		contentPane.add(lblNewLabel);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(e -> resetFields());
		btnReset.setBounds(317, 354, 89, 45);
		contentPane.add(btnReset);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(e -> calculate());
		btnCalculate.setBounds(438, 354, 89, 45);
		contentPane.add(btnCalculate);
		
		tariffTextArea = new JTextArea();
		tariffTextArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		tariffTextArea.setEditable(false);
		tariffTextArea.setBounds(69, 425, 458, 67);
		contentPane.add(tariffTextArea);
		
		lblNewLabel_2 = new JLabel("Tariff:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(69, 390, 46, 14);
		contentPane.add(lblNewLabel_2);
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
				JOptionPane.showMessageDialog(null, "Failed to retrieved data from database", "Error", JOptionPane.ERROR_MESSAGE);
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
			
			originCityCB.setModel(originComboBoxModel);
			destinationCityRB.setModel(destComboBoxModel);
			
			resetFields();
		});
	}
	
	private void resetFields() {
		weightTextField.setText("");
		fragileCheckbox.setSelected(false);
		tariffTextArea.setText("");
		originCityCB.setSelectedIndex(0);
		destinationCityRB.setSelectedIndex(1);
	}
	
	private void calculate() {
		try {
			if(!checkFields()) {
				JOptionPane.showMessageDialog(null, "All Fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		
		} catch (Exception ignored) {
			JOptionPane.showMessageDialog(null, "Weight must be a number!", "Type Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		City origCity = nameCityHashMap.get((String)originCityCB.getSelectedItem());
		City destCity = nameCityHashMap.get((String)destinationCityRB.getSelectedItem());
		
		float weight = Float.parseFloat(weightTextField.getText());
		
		float cost = Account.tariffCheck(origCity.getMetric(), destCity.getMetric(), weight, fragileCheckbox.isSelected());
				
		tariffTextArea.setText(String.format("Rp. %.2f", cost));
	}
	
	private boolean checkFields() throws Exception {
		String weight = weightTextField.getText();
		
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
