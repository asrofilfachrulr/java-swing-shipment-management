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

public class HomePanel extends JPanelInit {
    MainFrame mainFrame;
    JLabel lbUsername;

    HomePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        
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
        
        JButton btnTariffCheck = new JButton("Tariff Check");
        sl_panel.putConstraint(SpringLayout.NORTH, btnTariffCheck, 63, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnTariffCheck, 71, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnTariffCheck, 126, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnTariffCheck, 202, SpringLayout.WEST, panel);
        btnTariffCheck.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel.add(btnTariffCheck);
        
        JButton btnAddRequest = new JButton("Add Request");
        sl_panel.putConstraint(SpringLayout.NORTH, btnAddRequest, 63, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnAddRequest, -210, SpringLayout.EAST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnAddRequest, -356, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnAddRequest, -79, SpringLayout.EAST, panel);
        panel.add(btnAddRequest);
        
        JButton btnRequestsList = new JButton("Requests List");
        sl_panel.putConstraint(SpringLayout.SOUTH, btnRequestsList, 146, SpringLayout.SOUTH, btnTariffCheck);
        sl_panel.putConstraint(SpringLayout.EAST, btnRequestsList, 0, SpringLayout.EAST, btnTariffCheck);
        btnRequestsList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        sl_panel.putConstraint(SpringLayout.NORTH, btnRequestsList, 83, SpringLayout.SOUTH, btnTariffCheck);
        sl_panel.putConstraint(SpringLayout.WEST, btnRequestsList, 0, SpringLayout.WEST, btnTariffCheck);
        panel.add(btnRequestsList);
        
        JButton btnDeliveriesList = new JButton("Deliveries List");
        sl_panel.putConstraint(SpringLayout.NORTH, btnDeliveriesList, 0, SpringLayout.NORTH, btnRequestsList);
        sl_panel.putConstraint(SpringLayout.WEST, btnDeliveriesList, 0, SpringLayout.WEST, btnAddRequest);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnDeliveriesList, 0, SpringLayout.SOUTH, btnRequestsList);
        sl_panel.putConstraint(SpringLayout.EAST, btnDeliveriesList, 0, SpringLayout.EAST, btnAddRequest);
        panel.add(btnDeliveriesList);
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mainFrame.store.setAccount(null);
        		mainFrame.changeContentPaneToSignIn();
        	}
        });
        sl_panel.putConstraint(SpringLayout.NORTH, btnLogout, -57, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, btnLogout, -115, SpringLayout.EAST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnLogout, -22, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnLogout, -23, SpringLayout.EAST, panel);
        panel.add(btnLogout);
    }

    public void init(){
    	lbUsername.setText(mainFrame.getStore().getAccount().getFullname());
    }

    public void removeComponent(){
        removeAll();
    }
}
