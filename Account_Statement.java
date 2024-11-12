package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import GUI.Home;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Account_Statement {

	private JFrame frmAccountStatement;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_Statement window = new Account_Statement();
					window.frmAccountStatement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account_Statement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccountStatement = new JFrame();
		frmAccountStatement.getContentPane().setBackground(new Color(230, 245, 255));
		frmAccountStatement.setTitle("Account Statement\r\n");
		frmAccountStatement.setBounds(100, 100, 876, 540);
		frmAccountStatement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountStatement.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 75, 719, 355);
		frmAccountStatement.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Balance", "Deposit", "Withdrawal", "Date"
			}
		));
		String[] options = {"Sort by Date" , "Sort by Amount"};
		comboBox = new JComboBox(options);
		comboBox.setBackground(new Color(252, 183, 21));
		comboBox.setForeground(new Color(0, 78, 168));
		comboBox.setBounds(197, 438, 179, 22);
		frmAccountStatement.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Generate Account Statement");
		btnNewButton.setForeground(new Color(0, 78, 168));
		btnNewButton.setBackground(new Color(252, 183, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(442, 438, 205, 23);
		frmAccountStatement.getContentPane().add(btnNewButton);
		
		JLabel lblAccountStatement = new JLabel("Account Statement");
		lblAccountStatement.setForeground(new Color(8, 76, 172));
		lblAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAccountStatement.setBounds(286, 0, 294, 80);
		frmAccountStatement.getContentPane().add(lblAccountStatement);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(new Color(8, 76, 172));
		btnNewButton_1.setBackground(new Color(252, 183, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Home home = new Home();
			        home.setVisible(true); 
			        frmAccountStatement.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(56, 37, 89, 23);
		frmAccountStatement.getContentPane().add(btnNewButton_1);
	}
}
