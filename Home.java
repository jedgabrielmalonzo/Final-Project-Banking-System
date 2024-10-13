package Bank_Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Account_Statement.Account_Statement;
import Deposit.*;  // Import the Deposit class from the Deposit package
import Withdraw.Withdraw;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        setTitle("HOME");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome to Potsdam Bank");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(225, 11, 406, 64);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblNewLabel_1.setBounds(333, 72, 197, 35);
        getContentPane().add(lblNewLabel_1);

        // "Deposit" button to open Deposit window
        JButton btnNewButton = new JButton("Deposit");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Deposit.main(new String[0]);  
                dispose();  
            }
        });
        btnNewButton.setBounds(75, 334, 165, 54);
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
        btnNewButton_1.setBounds(625, 334, 165, 54);
        getContentPane().add(btnNewButton_1);

        // "Account Statement" button
        JButton btnAccountStatement = new JButton("Account Statement");
        btnAccountStatement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Account_Statement.main(new String[0]);  
                 dispose();  
             }
        });
        btnAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAccountStatement.setBounds(338, 334, 183, 54);
        getContentPane().add(btnAccountStatement);
    }
}
