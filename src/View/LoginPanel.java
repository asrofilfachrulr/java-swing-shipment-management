package View;

import Model.Customer;
import Model.Guest;
import Model.LoggedAccount;
import Model.Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginPanel extends NavContentPanel {
    JButton loginButton;
    JRadioButton customerRB, staffRB;
    JTextField usernameField;
    JPasswordField passwordField;

    public LoginPanel(MainFrame mainFrame, JPanel prevPanel) {
        super(mainFrame, prevPanel);

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        contentPane.add(usernameLabel, gbc);
        gbc.gridx = 1;
        contentPane.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(passwordLabel, gbc);
        gbc.gridx = 1;
        contentPane.add(passwordField, gbc);

        JLabel loginAs = new JLabel("Login As: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(loginAs, gbc);

        customerRB = new JRadioButton("Customer", true);
        staffRB = new JRadioButton("Staff");
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(customerRB);
        btnGroup.add(staffRB);

        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(customerRB, gbc);

        gbc.gridx = 1;
        contentPane.add(staffRB, gbc);

        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        contentPane.add(loginButton, gbc);

        setupBtnListener();
    }

    private void setupBtnListener() {
        loginButton.addActionListener(e -> loginButtonListener());

        KeyListener enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButtonListener();
                }
            }
        };

        usernameField.addKeyListener(enterKeyListener);
        passwordField.addKeyListener(enterKeyListener);
    }

    private void loginButtonListener() {
        String username, password;
        int accountType;

        username = usernameField.getText();
        password = new String(passwordField.getPassword());

        if(username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill username and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(staffRB.isSelected()){
            accountType = Guest.ACCOUNT_STAFF;
        } else {
            accountType = Guest.ACCOUNT_CUSTOMER;
        }

        Guest guest = new Guest();
        LoadingDialog loadingDialog = new LoadingDialog();

        loadingDialog.showDialogAndRun("Logging In...", () -> {
            try {
                LoggedAccount account = guest.login(username, password, accountType);
                this.mainFrame.store.setAccount(account);
                this.mainFrame.store.setAccountType(accountType);

                System.out.println("Login succeed");
                System.out.println("User data is retrieved");

                if(accountType == Guest.ACCOUNT_STAFF){
                    System.out.println(((Staff) account).toString());
                } else {
                    System.out.println(((Customer) account).toString());
                }

                mainFrame.changeContentPaneToHome();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}
