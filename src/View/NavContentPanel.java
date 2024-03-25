package View;

import Helper.ImageHelper;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NavContentPanel extends JPanelInit {
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

        navPane.setBounds(0, 0, 600, 50);
        contentPane.setBounds(0, 50, 600, 550);

        add(navPane);
        GroupLayout gl_navPane = new GroupLayout(navPane);
        gl_navPane.setHorizontalGroup(
        	gl_navPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_navPane.createSequentialGroup()
        			.addGap(5)
        			.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(homeBtn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        			.addGap(486))
        );
        gl_navPane.setVerticalGroup(
        	gl_navPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_navPane.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_navPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(homeBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        				.addComponent(backBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        navPane.setLayout(gl_navPane);
        add(contentPane);
    }

    protected void setBackBtnAction(){
        if(prevPanel != null) {
            backBtn.addActionListener(e -> mainFrame.changeContentPaneWithoutInit(prevPanel));
        }
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
