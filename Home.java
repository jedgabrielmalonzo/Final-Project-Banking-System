package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

import CheckBalanceGUI.Account_Statement;
import DepositGUI.Deposit;
import WithdrawGUI.Withdraw;

public class Home extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
                    window.setVisible(true);  // Set the visibility of this JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Home() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Initialize this JFrame directly
        setTitle("Home");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // "Deposit" button to open Deposit window
        JButton btnNewButton = new JButton("Deposit");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Deposit.main(new String[0]);  
                dispose();  
            }
        });
        btnNewButton.setBounds(498, 154, 204, 54);
        getContentPane().add(btnNewButton);

        // "Withdraw" button
        JButton btnNewButton_1 = new JButton("Withdraw");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
               Withdraw.main(new String[0]);  
                dispose();  
            }
        });
        btnNewButton_1.setBounds(498, 221, 201, 54);
        getContentPane().add(btnNewButton_1);

        // "Account Statement" button
        JButton btnAccountStatement = new JButton("Check Balance");
        btnAccountStatement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Account_Statement.main(new String[0]);  
                 dispose();  
             }
        });
        btnAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAccountStatement.setBounds(498, 286, 204, 54);
        getContentPane().add(btnAccountStatement);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 345, 501);
        getContentPane().add(panel);
        panel.setLayout(null);
                
                JLabel lblNewLabel_2_1 = new JLabel("What would you ");
                lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2_1.setForeground(Color.WHITE);
                lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
                lblNewLabel_2_1.setBounds(39, 220, 283, 60);
                panel.add(lblNewLabel_2_1);
                
                JLabel lblNewLabel_2_1_1 = new JLabel("like to do?");
                lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2_1_1.setForeground(Color.WHITE);
                lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
                lblNewLabel_2_1_1.setBounds(75, 255, 195, 60);
                panel.add(lblNewLabel_2_1_1);
        
        JButton btnChangePin = new JButton("Change Pin");
        btnChangePin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnChangePin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnChangePin.setBounds(498, 352, 204, 54);
        getContentPane().add(btnChangePin);
        
        JLabel lblNewLabel_2 = new JLabel("Welcome to PotsBank");
        lblNewLabel_2.setBounds(441, 26, 331, 37);
        getContentPane().add(lblNewLabel_2);
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        
                JLabel lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
                lblNewLabel_1.setBounds(505, 62, 197, 35);
                getContentPane().add(lblNewLabel_1);
                lblNewLabel_1.setForeground(Color.BLACK);
                lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
                
                JButton btnCreateAccount = new JButton("Create Account");
                btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
                btnCreateAccount.setBounds(498, 417, 204, 54);
                getContentPane().add(btnCreateAccount);
    }
}
