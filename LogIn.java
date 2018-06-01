package WorkoutTracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Window.Type;

public class LogIn {

	private JFrame frmWorkoutTracker;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frmWorkoutTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}
	
	/**
	 * Get the frame for this window
	 */
	public JFrame getLoginWindow(){
		return frmWorkoutTracker;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmWorkoutTracker = new JFrame();
		frmWorkoutTracker.setTitle("Workout Tracker");
		frmWorkoutTracker.setResizable(false);
		frmWorkoutTracker.getContentPane().setEnabled(false);
		frmWorkoutTracker.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmWorkoutTracker.setBounds(100, 100, 450, 300);
		frmWorkoutTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWorkoutTracker.getContentPane().setLayout(null);
		frmWorkoutTracker.setLocationRelativeTo(null);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setBackground(Color.LIGHT_GRAY);
		txtrWelcome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtrWelcome.setBounds(0, 0, 444, 89);
		txtrWelcome.setLineWrap(true);
		txtrWelcome.setEditable(false);
		txtrWelcome.setText("\t  \r\n\t  Welcome to the Workout Tacker!\r\n\r\n                 Please log in or create an account to continue.\r\n");
		frmWorkoutTracker.getContentPane().add(txtrWelcome);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(138, 127, 147, 36);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//#TODO set action for the Log In button 
				
			}
		});
		frmWorkoutTracker.getContentPane().add(btnLogIn);
		
		JButton btnCreateAnAccount = new JButton("Create an Account");
		btnCreateAnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//#TODO set action for the create an account button
				try {
					CreateAccount c = new CreateAccount();
					c.getCreateAccountWindow().setVisible(true);
					frmWorkoutTracker.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreateAnAccount.setBounds(138, 184, 147, 36);
		frmWorkoutTracker.getContentPane().add(btnCreateAnAccount);
		frmWorkoutTracker.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLogIn, btnCreateAnAccount}));
		frmWorkoutTracker.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLogIn, btnCreateAnAccount}));
	}

}
