package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
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
	private JTextField recipientPhoneTF;
	private JTextField recipientNameTF;
	private JTextField weightTF;
	private JTextField descTF;
	
	public AddRequestPanel(MainFrame mainFrame, JPanel prevJPanel) {
		super(mainFrame, prevJPanel);
		contentPane.setBounds(0, 50, 600, 550);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Delivery Request");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 14, 132, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 40, 569, 500);
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
		
		JTextArea senderAddressTA = new JTextArea();
		senderAddressTA.setWrapStyleWord(true);
		senderAddressTA.setRows(3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Recipient Information");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Address");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Phone");
		
		JLabel lblNewLabel_2_2 = new JLabel("Name");
		
		JTextArea recipientAddressTA = new JTextArea();
		
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
		
		JTextArea tariffTA = new JTextArea();
		tariffTA.setText("Rp. ");
		tariffTA.setFont(new Font("Arial", Font.BOLD, 13));
		tariffTA.setEditable(false);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnCalculate = new JButton("Calculate");
		
		JButton btnReset = new JButton("Reset");
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
		
		JComboBox originCBx = new JComboBox();
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Origin");
		
		JLabel lblNewLabel_2_3_2_1_1 = new JLabel("Destination");
		
		JComboBox destCBx = new JComboBox();
		
		JCheckBox fragileChBx = new JCheckBox("   Fragile");
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

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
