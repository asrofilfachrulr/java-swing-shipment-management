package View;
import Helper.GlobalStore;
import Helper.Session;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    SigninPanel signinPane;
    HomePanel homePanel;

    GlobalStore store;

    public MainFrame(){
        store = new GlobalStore();

        signinPane = new SigninPanel(this);
        homePanel = new HomePanel(this);

        ImageIcon icon = new ImageIcon("logo.png");

        setSize(600, 600);
        setTitle("Shipment Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setContentPane(signinPane);
        setIconImage(icon.getImage());
    }

    public void changeContentPane(Container pane) {
        this.setContentPane(pane);
        this.revalidate();
        this.repaint();
    }

    public void changeContentPaneToSignIn() {
        if(signinPane != null) {
            this.setContentPane(signinPane);
            this.revalidate();
            this.repaint();
        }
    }
    public void changeContentPaneToHome() {
        if(homePanel != null) {
            if(store.getAccount() == null) {
                changeContentPaneToSignIn();
                return;
            }
            homePanel.loadComponent();
            this.setContentPane(homePanel);
            this.revalidate();
            this.repaint();
        }
    }

    public GlobalStore getStore() {
        return store;
    }

    public void setStore(GlobalStore store) {
        this.store = store;
    }
}
