package ChangePinGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Change_Pin {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_Pin window = new Change_Pin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Change_Pin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 876, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePin = new JLabel("Change Pin");
		lblChangePin.setBounds(345, 13, 170, 37);
		lblChangePin.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblChangePin);
		
		JLabel lblCurrentPin = new JLabel("Current Pin");
		lblCurrentPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCurrentPin.setBounds(234, 143, 106, 20);
		frame.getContentPane().add(lblCurrentPin);
		
		JLabel lblNewPin = new JLabel("New Pin");
		lblNewPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewPin.setBounds(233, 202, 76, 16);
		frame.getContentPane().add(lblNewPin);
		
		JLabel label_1_1 = new JLabel("Confrim Pin");
		label_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1_1.setBounds(232, 257, 108, 20);
		frame.getContentPane().add(label_1_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(385, 370, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(232, 170, 387, 28);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField_1.setBounds(233, 224, 387, 28);
		frame.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField_2.setBounds(229, 288, 387, 28);
		frame.getContentPane().add(passwordField_2);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(16, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
