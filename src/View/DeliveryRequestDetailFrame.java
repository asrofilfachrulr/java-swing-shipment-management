package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class DeliveryRequestDetailFrame extends JFrame {
	public DeliveryRequestDetailFrame() {
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Delivery Request Detail");
		setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery Request Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 32, 125, 15);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 72, 532, 624);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Personal Information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_3 = new JLabel("Sender Name");
		
		JLabel lblNewLabel_3_1 = new JLabel("Sender Phone");
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Sender Address");
		
		JLabel lblNewLabel_3_2 = new JLabel("Recipient Name");
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Recipient Phone");
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Recipient Address");
		
		JLabel lblNewLabel_2_1 = new JLabel("Package Information");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_3_3 = new JLabel("Description");
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Fragile");
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Weight");
		
		JLabel lblNewLabel_3_3_1_2 = new JLabel("City Origin");
		
		JLabel lblNewLabel_3_3_1_2_1 = new JLabel("City Destination");
		
		JLabel lblNewLabel_3_3_1_2_1_1 = new JLabel("Created Time");
		
		JLabel lblNewLabel_3_3_1_2_1_1_1 = new JLabel("Pickup Time Est.");
		
		JLabel lblNewLabel_3_3_1_2_1_1_1_1 = new JLabel("Pickup Time");
		
		JLabel lblNewLabel_3_3_1_2_1_1_1_1_1 = new JLabel("Canceled");
		
		JLabel lbSenderNameContent = new JLabel("Sender Name Content");
		lbSenderNameContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblSenderPhoneContent = new JLabel("Sender Phone Content");
		lblSenderPhoneContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblSenderAddressContent = new JLabel("Sender Address Content");
		lblSenderAddressContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblRecipientNameContent = new JLabel("Recipient Name Content");
		lblRecipientNameContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblRecipientPhoneContent = new JLabel("Recipient Phone Content");
		lblRecipientPhoneContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblRecipientAddressContent = new JLabel("Recipient Address Content");
		lblRecipientAddressContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblDescriptionContent = new JLabel("Description Content");
		lblDescriptionContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblFragileContent = new JLabel("Fragile Content");
		lblFragileContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblWeightContent = new JLabel("Weight Content");
		lblWeightContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblCityOriginContent = new JLabel("City Origin Content");
		lblCityOriginContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblCityDestinationContent = new JLabel("City Destination Content");
		lblCityDestinationContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblCreatedTimeContent = new JLabel("Created Time Content");
		lblCreatedTimeContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblPickupTimeEstContent = new JLabel("Pickup Time Est Content");
		lblPickupTimeEstContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblPickupTimeContent = new JLabel("Pickup Time Content");
		lblPickupTimeContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblCanceledContent = new JLabel("Canceled Content");
		lblCanceledContent.setFont(new Font("Monospaced", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_3_1_1_1, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_2_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_2_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_2_1_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_2_1_1_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1_2_1_1_1_1_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescriptionContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecipientAddressContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecipientPhoneContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecipientNameContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenderAddressContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenderPhoneContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbSenderNameContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFragileContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeightContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCityOriginContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCityDestinationContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCreatedTimeContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPickupTimeEstContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPickupTimeContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCanceledContent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_2)
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lbSenderNameContent))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(lblSenderPhoneContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1_1)
						.addComponent(lblSenderAddressContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_2)
						.addComponent(lblRecipientNameContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1_2)
						.addComponent(lblRecipientPhoneContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1_1_1)
						.addComponent(lblRecipientAddressContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblNewLabel_2_1)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3)
						.addComponent(lblDescriptionContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1)
						.addComponent(lblFragileContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_1)
						.addComponent(lblWeightContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_2)
						.addComponent(lblCityOriginContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_2_1)
						.addComponent(lblCityDestinationContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_2_1_1)
						.addComponent(lblCreatedTimeContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_2_1_1_1)
						.addComponent(lblPickupTimeEstContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_2_1_1_1_1)
						.addComponent(lblPickupTimeContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_3_1_2_1_1_1_1_1)
						.addComponent(lblCanceledContent, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(365, 47, 11, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lbIdRequest = new JLabel("REQUEST_ID");
		lbIdRequest.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lbIdRequest.setBounds(397, 47, 157, 14);
		getContentPane().add(lbIdRequest);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tariff");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(354, 720, 34, 16);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblRpXxxXxxx = new JLabel("Rp. xxx, xxxx");
		lblRpXxxXxxx.setFont(new Font("Monospaced", Font.PLAIN, 12));
		lblRpXxxXxxx.setBounds(416, 721, 138, 14);
		getContentPane().add(lblRpXxxXxxx);
		
		JLabel lblNewLabel_1_2 = new JLabel("USERID");
		lblNewLabel_1_2.setBounds(339, 22, 37, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblUserid = new JLabel("USER_ID");
		lblUserid.setFont(new Font("Monospaced", Font.PLAIN, 11));
		lblUserid.setBounds(397, 22, 157, 14);
		getContentPane().add(lblUserid);
		
		setVisible(true);
	}
}
