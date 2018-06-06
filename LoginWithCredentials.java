package WorkoutTracker;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class LoginWithCredentials {

	private JFrame loginFrame;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWithCredentials window = new LoginWithCredentials();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWithCredentials() {
		initialize();
	}
	
	/**
	 * Get the frame for this window
	 */
	public JFrame getLoginWindowWCred(){
		return loginFrame;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setResizable(false);
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setLocationRelativeTo(null);
		
		JLabel lblCreateAnAccount = new JLabel("Log In\r\n");
		lblCreateAnAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreateAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAnAccount.setBounds(10, 11, 414, 23);
		loginFrame.getContentPane().add(lblCreateAnAccount);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(85, 58, 96, 23);
		loginFrame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(85, 92, 96, 23);
		loginFrame.getContentPane().add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(191, 59, 193, 20);
		loginFrame.getContentPane().add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 92, 193, 22);
		loginFrame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//#TODO make button action
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(142, 150, 137, 43);
		loginFrame.getContentPane().add(btnNewButton);
	}

}
