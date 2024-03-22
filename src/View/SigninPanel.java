package View;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SigninPanel extends JPanel {
    MainFrame mainFrame;
    LoginPanel loginPanel;

    SigninPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        loginPanel = new LoginPanel(mainFrame, this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 20, 5);

        JLabel label = new JLabel();
        label.setText("Welcome to Shipment Management System");
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 18));

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
        GridBagConstraints gbc1 = new GridBagConstraints();

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        gbc1.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc1);
    }
}
