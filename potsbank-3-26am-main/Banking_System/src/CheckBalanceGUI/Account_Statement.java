package CheckBalanceGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import GUI.Home;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Account_Statement {

    private JFrame frmAccountStatement;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> comboBox;
    private JTextField textField;
    private TableRowSorter<DefaultTableModel> tableRowSorter; // RowSorter for filtering

    public Account_Statement() {
        initialize();
        loadTransactionsFromDatabase(); // Load transactions on initialization
    }

    private void initialize() {
        frmAccountStatement = new JFrame();
        frmAccountStatement.getContentPane().setBackground(new Color(230, 245, 255));
        frmAccountStatement.setTitle("Account Statement");
        frmAccountStatement.setBounds(100, 100, 1206, 598);
        frmAccountStatement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAccountStatement.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 134, 719, 355);
        frmAccountStatement.getContentPane().add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Balance", "Deposit", "Withdrawal", "Date"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Prevent editing of cells
            }
        };
        table.setModel(tableModel);

        // Initialize the RowSorter
        tableRowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(tableRowSorter);

        scrollPane.setViewportView(table);

        JLabel lblAccountStatement = new JLabel("Account Statement");
        lblAccountStatement.setForeground(new Color(8, 76, 172));
        lblAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblAccountStatement.setBounds(284, 10, 294, 80);
        frmAccountStatement.getContentPane().add(lblAccountStatement);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(819, 0, 363, 559);
        frmAccountStatement.getContentPane().add(panel);

        JLabel lblTheAccountStatement = new JLabel(
            "<html><br>The Account Statement Features</br><br> allows you to sort transactions by date or amount, making it easy to organize and view your account activity<br></html>");
        lblTheAccountStatement.setHorizontalAlignment(SwingConstants.CENTER);
        lblTheAccountStatement.setForeground(Color.WHITE);
        lblTheAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTheAccountStatement.setBounds(64, 88, 271, 306);
        panel.add(lblTheAccountStatement);

        JLabel lblNewLabel_1 = new JLabel("Welcome to PotsBank");
        lblNewLabel_1.setForeground(new Color(230, 245, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(18, 33, 335, 64);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Your Trust, Our Commitment");
        lblNewLabel_1_1.setForeground(new Color(252, 183, 21));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblNewLabel_1_1.setBounds(92, 90, 219, 35);
        panel.add(lblNewLabel_1_1);

        String[] options = {"Sort by Date", "Sort by Deposit Amount", "Sort by Withdrawal Amount"};
        comboBox = new JComboBox<>(options);
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBounds(120, 515, 179, 22);
        frmAccountStatement.getContentPane().add(comboBox);

        JButton btnGenerateStatement = new JButton("Generate Account Statement");
        btnGenerateStatement.setBounds(507, 515, 207, 23);
        btnGenerateStatement.addActionListener(e -> handleGenerateStatement());
        frmAccountStatement.getContentPane().add(btnGenerateStatement);

        JButton btnHome = new JButton("Home");
        btnHome.setForeground(new Color(0, 78, 168));
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnHome.setBackground(new Color(252, 183, 21));
        btnHome.setBounds(10, 11, 100, 30);
        frmAccountStatement.getContentPane().add(btnHome);

        textField = new JTextField();
        textField.setBounds(57, 103, 140, 20);
        frmAccountStatement.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(e -> {
            String searchText = textField.getText();
            if (searchText.isEmpty()) {
                tableRowSorter.setRowFilter(null); // Show all rows if search text is empty
            } else {
                tableRowSorter.setRowFilter(new MyRowFilter(searchText)); // Apply custom filter
            }
        });
        btnSearch.setBounds(210, 101, 89, 23);
        frmAccountStatement.getContentPane().add(btnSearch);

        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home homeWindow = new Home(0); // Use UserSession to get the PIN
                homeWindow.setVisible(true);
                frmAccountStatement.dispose();
            }
        });
    }

    public void loadTransactionsFromDatabase() {
        List<Transaction> transactions = Account_Statement_Database.fetchAllTransactions();

        for (Transaction transaction : transactions) {
            tableModel.addRow(new Object[]{
                transaction.getBalance(),
                transaction.getDeposit(),
                transaction.getWithdrawal(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(transaction.getDate()) // Convert Timestamp to String
            });
        }

        refreshTable();
    }

    private void handleGenerateStatement() {
        String selectedOption = (String) comboBox.getSelectedItem();
        if (selectedOption != null) {
            // Sorting logic...
        }
    }

    public void refreshTable() {
        table.revalidate();
        table.repaint();
    }

    public void show() {
        frmAccountStatement.setVisible(true);
    }

    public static void main(String[] args) {
        Account_Statement accountStatement = new Account_Statement();
        accountStatement.show();
    }
}
