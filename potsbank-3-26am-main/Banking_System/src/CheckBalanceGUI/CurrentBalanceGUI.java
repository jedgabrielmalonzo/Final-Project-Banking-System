package CheckBalanceGUI;

import javax.swing.*;
import java.awt.*;

public class CurrentBalanceGUI {
    private JFrame frame;
    private double balance;

    public CurrentBalanceGUI(double balance) {
        this.balance = balance;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Current Balance");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblBalance = new JLabel("Your Current Balance:");
        lblBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblBalance.setBounds(50, 50, 300, 30);
        frame.getContentPane().add(lblBalance);

        JLabel lblAmount = new JLabel(String.format("$%.2f", balance));
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAmount.setForeground(new Color(0, 128, 0));
        lblAmount.setBounds(50, 100, 337, 63);
        frame.getContentPane().add(lblAmount);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(50, 200, 100, 30);
        btnClose.addActionListener(e -> frame.dispose());
        frame.getContentPane().add(btnClose);

        // Add button to open Account Statement
        JButton btnAccountStatement = new JButton("View Account Statement");
        btnAccountStatement.setBounds(200, 200, 200, 30);
        btnAccountStatement.addActionListener(e -> {
            Account_Statement accountStatement = new Account_Statement();
            accountStatement.show();
            frame.dispose();
        });
        frame.getContentPane().add(btnAccountStatement);
    }

    public void show() {
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        // Fetch real balance from Account_Statement
        Account_Statement accountStatement = new Account_Statement();

        // Ensure that transactions are loaded before calculating balance
        accountStatement.loadTransactionsFromDatabase();

        // Calculate the real-time balance
        double realBalance = accountStatement.calculateCurrentBalance();

        // Show the current balance in the GUI
        CurrentBalanceGUI balanceGUI = new CurrentBalanceGUI(realBalance);
        balanceGUI.show();
    }
}
