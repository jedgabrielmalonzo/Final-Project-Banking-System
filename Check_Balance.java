package CheckBalanceGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Check_Balance {

	private JFrame frmCheckBalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check_Balance window = new Check_Balance();
					window.frmCheckBalance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Check_Balance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckBalance = new JFrame();
		frmCheckBalance.setTitle("Check Balance");
		frmCheckBalance.setBounds(100, 100, 876, 540);
		frmCheckBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckBalance.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Check Current Balance");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(319, 196, 221, 50);
		frmCheckBalance.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Bank Statement");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(319, 294, 221, 52);
		frmCheckBalance.getContentPane().add(btnNewButton_1);
		
		JLabel lblCheckBalance = new JLabel("Check Balance");
		lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCheckBalance.setBounds(319, 23, 221, 78);
		frmCheckBalance.getContentPane().add(lblCheckBalance);
		
		JButton btnNewButton_1_1 = new JButton("Home");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(21, 46, 89, 23);
		frmCheckBalance.getContentPane().add(btnNewButton_1_1);
	}

}
