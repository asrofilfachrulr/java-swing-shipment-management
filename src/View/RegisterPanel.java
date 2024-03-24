package View;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPanel extends JPanelInit {
	private JTextField emailField;
	private JTextField usernameField;
	private JTextField fullnameField;
	private JTextField textField;
	private JTextArea returnAddressTextArea;
	private JPasswordField passwordField;
	private JPasswordField repeatPasswordField;
	
	MainFrame mainFrame;
	JPanel prevPanel;
	
	public RegisterPanel(MainFrame mainFrame, JPanel prevJPanel) {
		this.mainFrame = mainFrame;
		this.prevPanel = prevJPanel;
		
		JLabel lblNewLabel = new JLabel("Register For New Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel personalInfoPanel = new JPanel();
		personalInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Personal Info", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		personalInfoPanel.setToolTipText("Register");
		
		JButton btnSave = new JButton("Save");
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetFields();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.changeContentPaneWithoutInit(prevJPanel);
			}
		});
		
		JPanel accountInfoPanel = new JPanel();
		accountInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Account Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(accountInfoPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(personalInfoPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(personalInfoPanel, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(accountInfoPanel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Password");
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Repeat Password");
		
		passwordField = new JPasswordField();
		
		repeatPasswordField = new JPasswordField();
		GroupLayout gl_accountInfoPanel = new GroupLayout(accountInfoPanel);
		gl_accountInfoPanel.setHorizontalGroup(
			gl_accountInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accountInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_accountInfoPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_1_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
					.addGroup(gl_accountInfoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_accountInfoPanel.createSequentialGroup()
							.addGap(18, 18, Short.MAX_VALUE)
							.addGroup(gl_accountInfoPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
							.addGap(111))
						.addGroup(gl_accountInfoPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(repeatPasswordField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(111, Short.MAX_VALUE))))
		);
		gl_accountInfoPanel.setVerticalGroup(
			gl_accountInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accountInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_accountInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_accountInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_accountInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2_1)
						.addComponent(repeatPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		accountInfoPanel.setLayout(gl_accountInfoPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Full Name");
		
		fullnameField = new JTextField();
		fullnameField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Return Address :");
		
		returnAddressTextArea = new JTextArea();
		returnAddressTextArea.setWrapStyleWord(true);
		returnAddressTextArea.setRows(3);
		returnAddressTextArea.setLineWrap(true);
		GroupLayout gl_personalInfoPanel = new GroupLayout(personalInfoPanel);
		gl_personalInfoPanel.setHorizontalGroup(
			gl_personalInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_personalInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_personalInfoPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_personalInfoPanel.createSequentialGroup()
							.addGroup(gl_personalInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_personalInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
								.addComponent(fullnameField, 299, 299, 299)))
						.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(returnAddressTextArea))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_personalInfoPanel.setVerticalGroup(
			gl_personalInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_personalInfoPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_personalInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_personalInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(fullnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_personalInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(returnAddressTextArea, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		personalInfoPanel.setLayout(gl_personalInfoPanel);
		setLayout(groupLayout);
	}

	@Override
	public void init() {
		resetFields();
	}
	
	private void resetFields() {
		emailField.setText("");
		usernameField.setText("");
		fullnameField.setText("");
		textField.setText("");
		returnAddressTextArea.setText("");
		
		passwordField.setText("");
		repeatPasswordField.setText("");
	}
}
