package View;

import Helper.ImageHelper;

import javax.swing.*;
import java.awt.*;

public class NavContentPanel extends JPanel {
    protected JButton backBtn;
    protected JButton homeBtn;
    protected JPanel navPane = new JPanel();
    protected JPanel contentPane = new JPanel();
    protected JPanel prevPanel;
    protected MainFrame mainFrame;

    public NavContentPanel(MainFrame mainFrame, JPanel prevPanel) {
        this.mainFrame = mainFrame;
        this.prevPanel = prevPanel;

        setLayout(null);

        navPane.setLayout(new FlowLayout(FlowLayout.LEFT));

        ImageIcon backIC = ImageHelper.resizeIcon(new ImageIcon("arrow_back.png"), 12, 12);
        ImageIcon homeIC = ImageHelper.resizeIcon(new ImageIcon("home.png"), 12, 12);


        backBtn = new JButton();
        backBtn.setIcon(backIC);
        backBtn.setFocusable(false);
        setBackBtnAction();

        homeBtn = new JButton();
        homeBtn.setIcon(homeIC);
        homeBtn.setFocusable(false);
        homeBtn.addActionListener(e -> mainFrame.changeContentPaneToHome());

        navPane.add(backBtn);
        navPane.add(homeBtn);

        navPane.setBounds(0, 0, 600, 50);
        contentPane.setBounds(0, 50, 600, 550);

        add(navPane);
        add(contentPane);
    }

    protected void setBackBtnAction(){
        if(prevPanel != null) {
            backBtn.addActionListener(e -> mainFrame.changeContentPane(prevPanel));
        }
    }
}
