package Deposit;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import Bank_Interface.Home;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

    private JTable table;
    private JPanel panel;
    private JTextField textField_1;
    private JLabel lblEnterTheAmount_1;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Deposit window = new Deposit();
                    window.setVisible(true);  // Directly display the Deposit JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Deposit() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Set the title, size, and close operation for the JFrame
        setTitle("DEPOSIT");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Welcome label
        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblDeposit.setBounds(372, 39, 115, 80);
        getContentPane().add(lblDeposit);

        // Potsdam Bank welcome label
        JLabel lblNewLabel_4 = new JLabel("Welcome to Potsdam Bank");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 30));
        lblNewLabel_4.setBounds(249, 0, 361, 64);
        getContentPane().add(lblNewLabel_4);

        // Scroll pane for table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(530, 130, 260, 340);
        getContentPane().add(scrollPane);

        // Create table for account balance and transaction date
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Account Balance", "Date of Transaction"
            }
        ));
        scrollPane.setViewportView(table);

        // Panel for deposit functionality
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(50, 280, 320, 140);
        getContentPane().add(panel);

        // TextField for deposit amount
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(26, 64, 268, 26);
        panel.add(textField_1);

        // Label for entering amount
        lblEnterTheAmount_1 = new JLabel("Enter the Amount to Deposit");
        lblEnterTheAmount_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEnterTheAmount_1.setBounds(66, 28, 187, 19);
        panel.add(lblEnterTheAmount_1);

        // Button to confirm the deposit
        btnNewButton = new JButton("Enter");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(115, 101, 89, 23);
        panel.add(btnNewButton);

        // "Home" button to go back to the home screen
        btnNewButton_1 = new JButton("Home");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home home = new Home();
                home.setVisible(true);  // Open Home screen
                dispose();  // Close the current Deposit window
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(50, 133, 89, 23);
        getContentPane().add(btnNewButton_1);
    }
}
