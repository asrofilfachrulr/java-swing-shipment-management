package View;

import Helper.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHomePanel extends JPanelInit {
    MainFrame mainFrame;
    JLabel lbUsername;
    TariffCheckPanel tariffCheckPanel;
    AddRequestPanel addRequestPanel;
    RequestListPanel requestListPanel;

    AdminHomePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        
        tariffCheckPanel = new TariffCheckPanel(mainFrame, this);
        tariffCheckPanel.setAdmin(true);
        
        addRequestPanel = new AddRequestPanel(mainFrame, this);
        addRequestPanel.setAdmin(true);
        
        requestListPanel = new RequestListPanel(mainFrame, this);
        requestListPanel.setAdmin(true);
        
        JLabel lblNewLabel = new JLabel("Welcome,");
        lblNewLabel.setBounds(28, 32, 57, 14);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        add(lblNewLabel);
        
        lbUsername = new JLabel("Username");
        lbUsername.setBounds(28, 49, 265, 19);
        lbUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lbUsername);
        
        JLabel lblNewLabel_2 = new JLabel("Shipment Management \r\nSystem");
        lblNewLabel_2.setBounds(387, 32, 171, 43);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lblNewLabel_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(28, 83, 535, 482);
        add(panel);
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);
        
        Font defFont = new Font("Tahoma", Font.PLAIN, 11);
        
        JButton btnTariffCheck = new JButton("Tariff Check");
        btnTariffCheck.setFont(defFont);
        sl_panel.putConstraint(SpringLayout.NORTH, btnTariffCheck, 63, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnTariffCheck, 71, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnTariffCheck, 126, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnTariffCheck, 202, SpringLayout.WEST, panel);
        btnTariffCheck.addActionListener(e -> mainFrame.changeContentPane(tariffCheckPanel));
        panel.add(btnTariffCheck);
        
        JButton btnLocalRequest = new JButton("Local Requests");
        btnLocalRequest.setFont(defFont);
        sl_panel.putConstraint(SpringLayout.NORTH, btnLocalRequest, 63, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnLocalRequest, -210, SpringLayout.EAST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnLocalRequest, -356, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnLocalRequest, -79, SpringLayout.EAST, panel);
        btnLocalRequest.addActionListener(e -> mainFrame.changeContentPane(addRequestPanel));
        panel.add(btnLocalRequest);
        
        JButton btnRequestsList = new JButton("Package Delivery");
        btnRequestsList.setFont(defFont);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnRequestsList, 146, SpringLayout.SOUTH, btnTariffCheck);
        sl_panel.putConstraint(SpringLayout.EAST, btnRequestsList, 0, SpringLayout.EAST, btnTariffCheck);
        btnRequestsList.addActionListener(e -> mainFrame.changeContentPane(requestListPanel));
        sl_panel.putConstraint(SpringLayout.NORTH, btnRequestsList, 83, SpringLayout.SOUTH, btnTariffCheck);
        sl_panel.putConstraint(SpringLayout.WEST, btnRequestsList, 0, SpringLayout.WEST, btnTariffCheck);
        panel.add(btnRequestsList);
        
        JButton btnLogout = new JButton("Logout");
        sl_panel.putConstraint(SpringLayout.NORTH, btnLogout, -63, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnLogout, -124, SpringLayout.EAST, panel);
        btnLogout.setFont(defFont);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnLogout, -21, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnLogout, -25, SpringLayout.EAST, panel);
        btnLogout.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mainFrame.store.setAccount(null);
        		mainFrame.changeContentPaneToSignIn();
        	}
        });
        panel.add(btnLogout);
        
        JLabel lblNewLabel_1 = new JLabel("<< ADMIN MODE >>");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(387, 21, 171, 14);
        add(lblNewLabel_1);
    }

    public void init(){
    	lbUsername.setText(mainFrame.getStore().getAccount().getFullname());
    }

    public void removeComponent(){
        removeAll();
    }
}
