package View;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class SigninPanel extends JPanelInit {
    MainFrame mainFrame;
    
    SigninPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        LoginPanel loginPanel = new LoginPanel(mainFrame, this);
        RegisterPanel registerPanel = new RegisterPanel(mainFrame, this);
        

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 20, 5);

        JLabel label = new JLabel();
        label.setText("Welcome to Shipment Management System");
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 16));
        label.setBorder(BorderFactory.createEmptyBorder(0,0, 20, 0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(label, gbc);

        // Add login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> mainFrame.changeContentPane(loginPanel));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 10, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        // Add register button
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> mainFrame.changeContentPane(registerPanel));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        JButton checkTariffButton = new JButton("Tariff Check");
        gbc.gridy = 3;
        add(checkTariffButton, gbc);
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
