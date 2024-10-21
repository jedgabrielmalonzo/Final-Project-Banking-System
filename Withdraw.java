package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Withdraw {

	private JFrame frmWithdraw;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.frmWithdraw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWithdraw = new JFrame();
		frmWithdraw.setTitle("WITHDRAW");
		frmWithdraw.setBounds(100, 100, 876, 540);
		frmWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWithdraw.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome to PotsBank");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_4.setBounds(283, 0, 293, 64);
		frmWithdraw.getContentPane().add(lblNewLabel_4);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWithdraw.setBounds(356, 39, 148, 80);
		frmWithdraw.getContentPane().add(lblWithdraw);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(530, 130, 260, 340);
		frmWithdraw.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account Balance", "Date of Transaction"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(50, 280, 320, 140);
		frmWithdraw.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(26, 64, 268, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheAmount = new JLabel("Enter the Amount to Withdraw");
		lblEnterTheAmount.setBounds(60, 28, 199, 19);
		panel.add(lblEnterTheAmount);
		lblEnterTheAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Enter\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(115, 106, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Home home = new Home();
		        home.setVisible(true); 
		        frmWithdraw.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(50, 133, 89, 23);
		frmWithdraw.getContentPane().add(btnNewButton_1);
	}
}
