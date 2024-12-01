package CheckBalanceGUI;

import javax.swing.*;
import GUI.Home;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CheckBalance {

    private JFrame frame;

    public CheckBalance() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Check Balance");
        frame.setBounds(100, 100, 996, 562);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to PotsBank");
        lblWelcome.setForeground(new Color(8, 76, 172));
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(300, 94, 350, 30);
        frame.getContentPane().add(lblWelcome);

        JButton btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCheckBalance.setForeground(Color.WHITE);
        btnCheckBalance.setBackground(new Color(0, 78, 168));
        btnCheckBalance.setBounds(221, 258, 185, 61);
        frame.getContentPane().add(btnCheckBalance);

        JButton btnAccountStatement = new JButton("Account Statement");
        btnAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAccountStatement.setForeground(Color.WHITE);
        btnAccountStatement.setBackground(new Color(0, 78, 168));
        btnAccountStatement.setBounds(542, 258, 185, 61);
        frame.getContentPane().add(btnAccountStatement);

        JButton btnHome = new JButton("Home");
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnHome.setForeground(Color.BLACK);
        btnHome.setBackground(new Color(252, 183, 21));
        btnHome.setBounds(10, 10, 100, 30);
        frame.getContentPane().add(btnHome);

        // Action listener for "Check Balance" button
        btnCheckBalance.addActionListener(e -> {
            try {
                double balance = fetchBalance();
                CurrentBalanceGUI balanceWindow = new CurrentBalanceGUI(balance);
                balanceWindow.show();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error fetching balance: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for "Account Statement" button
        btnAccountStatement.addActionListener(e -> {
            try {
                Account_Statement accountStatementWindow = new Account_Statement();
                accountStatementWindow.show();
                frame.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error loading account statement: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for "Home" button
        btnHome.addActionListener(e -> {
            Home homeWindow = new Home(0); // Use UserSession to get the PIN
            homeWindow.setVisible(true);
            frame.dispose();
        });
    }

    private double fetchBalance() {
        // Create an instance of Account_Statement
        Account_Statement accountStatement = new Account_Statement();

        // Calculate and return the current balance
        return accountStatement.calculateCurrentBalance();
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CheckBalance checkBalance = new CheckBalance();
        checkBalance.show();
    }
}
