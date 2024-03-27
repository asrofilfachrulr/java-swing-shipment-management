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
    protected boolean isAdmin = false;
   

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
        
        homeBtn.addActionListener(e -> homeAction());

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
        		.addGroup(Alignment.TRAILING, gl_navPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_navPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(homeBtn, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        				.addComponent(backBtn, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        			.addGap(5))
        );
        navPane.setLayout(gl_navPane);
        add(contentPane);
    }
	
    public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	private void homeAction() {
		if(isAdmin)
			mainFrame.changeContentPaneToAdminHome();
		else mainFrame.changeContentPaneToHome();
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
