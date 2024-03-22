package View;

import Helper.KeyHelper;
import Model.Dao.CustomerDao;

import javax.swing.*;
import java.awt.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

public class LoginPanel extends NavContentPanel {
    public LoginPanel(MainFrame mainFrame, JPanel prevPanel){
        super(mainFrame, prevPanel);

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        contentPane.add(usernameLabel, gbc);
        gbc.gridx = 1;
        contentPane.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(passwordLabel, gbc);
        gbc.gridx = 1;
        contentPane.add(passwordField, gbc);

        JLabel loginAs = new JLabel("Login As: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(loginAs, gbc);

        JRadioButton customerRB = new JRadioButton("Customer", true);
        JRadioButton staffRB = new JRadioButton("Staff");
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(customerRB);
        btnGroup.add(staffRB);

        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(customerRB, gbc);

        gbc.gridx = 1;
        contentPane.add(staffRB, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        loginButton.addActionListener(e -> {
            String plainPassword = Arrays.toString(passwordField.getPassword());
            System.out.printf("Password: %s%n", plainPassword);
            String hashedPw;
            try {
                hashedPw = KeyHelper.hashSHA256(plainPassword);
            } catch (Exception err) {
                System.out.println(err.toString());
                hashedPw = "";
            }

            System.out.printf("EncryptedPw: %s%n%n", hashedPw);

            try {
                CustomerDao customerDao = new CustomerDao();
                boolean isCorrect = customerDao.verifyLogin(usernameField.getText(), plainPassword);
                if(isCorrect){
                    System.out.println("Password is correct");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        });

        contentPane.add(loginButton, gbc);
    }
}
