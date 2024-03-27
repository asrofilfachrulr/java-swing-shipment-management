package View;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminPackageDeliveryPanel extends NavContentPanel {
	private JTextField tfPackageId;
	private JTable table;
	public AdminPackageDeliveryPanel(MainFrame mainFrame, JPanel prevPanel) {
		super(mainFrame, prevPanel);
		
		JLabel lblNewLabel = new JLabel("Package Delivery Discovery");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Search Package");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfPackageId = new JTextField();
		tfPackageId.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblNewLabel_1_1 = new JLabel("Result and Control");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnDetail = new JButton("Detail >>");
		btnDetail.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(201)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(235))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
								.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(tfPackageId, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton))
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(33)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfPackageId, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		
		JScrollPane historyTab = new JScrollPane();
		tabbedPane.addTab("History", null, historyTab, null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		historyTab.setViewportView(table);
		
		JPanel changeTab = new JPanel();
		changeTab.setBackground(SystemColor.control);
		tabbedPane.addTab("Change", null, changeTab, null);
		GroupLayout gl_changeTab = new GroupLayout(changeTab);
		gl_changeTab.setHorizontalGroup(
			gl_changeTab.createParallelGroup(Alignment.LEADING)
				.addGap(0, 521, Short.MAX_VALUE)
		);
		gl_changeTab.setVerticalGroup(
			gl_changeTab.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE)
		);
		changeTab.setLayout(gl_changeTab);
		contentPane.setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}
}
