package View;
import Helper.GlobalStore;
import Helper.Session;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    SigninPanel signinPane;
    HomePanel homePanel;

    GlobalStore store;

    public MainFrame(){
        store = new GlobalStore();

        signinPane = new SigninPanel(this);
        homePanel = new HomePanel(this);

        ImageIcon icon = new ImageIcon("logo.png");
        setIconImage(icon.getImage());

        setSize(600, 600);
        setTitle("Shipment Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setContentPane(signinPane);
        setMinimumSize(new Dimension(600, 600));
    }

    public void changeContentPane(JPanelInit pane) {
    	pane.init();
        this.setContentPane(pane);
        reloadFrame();
    }
    
    public void changeContentPaneWithoutInit(JPanel pane) {
    	this.setContentPane(pane);
    	reloadFrame();
    }

    public void changeContentPaneToSignIn() {
        if(signinPane == null) {
        	signinPane = new SigninPanel(this);
        }
        changeContentPaneWithoutInit(signinPane);
    }
    
    public void changeContentPaneToHome() {
        if(homePanel != null) {
            if(store.getAccount() == null) {
                changeContentPaneToSignIn();
                return;
            }
            if(homePanel == null)
            	homePanel = new HomePanel(this);
            changeContentPane(homePanel);
        }
    }
    
    public void reloadFrame() {
    	this.revalidate();
        this.repaint();
    }

    public GlobalStore getStore() {
        return store;
    }

    public void setStore(GlobalStore store) {
        this.store = store;
    }
}
