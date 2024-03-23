package View;

import Helper.Session;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    MainFrame mainFrame;
    JButton tariffCheckButton, addRequestButton, listDeliveryReqButton, listPackageDeliveryButton;
    HomePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new GridBagLayout());
    }

    public void loadComponent(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 0, 15, 0);

        JLabel label = new JLabel("Shipment Management System");
        add(label, gbc);

        JLabel label1 = new JLabel("Welcome, " + mainFrame.getStore().getAccount().getFullname());
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 1;
        add(label1, gbc);
    }

    public void removeComponent(){
        removeAll();
    }
}
