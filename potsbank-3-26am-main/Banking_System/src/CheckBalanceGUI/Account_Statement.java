package CheckBalanceGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import GUI.Home;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.List;

public class Account_Statement {

    private JFrame frmAccountStatement;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> comboBox;
    private JTextField textField;
    private TableRowSorter<DefaultTableModel> tableRowSorter; // RowSorter for filtering

    public double calculateCurrentBalance() {
        double currentBalance = 0.0;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Double deposit = (Double) tableModel.getValueAt(i, 1); // Deposit column
            Double withdrawal = (Double) tableModel.getValueAt(i, 2); // Withdrawal column

            currentBalance += (deposit != null ? deposit : 0);
            currentBalance -= (withdrawal != null ? withdrawal : 0);
        }

        return currentBalance;
    }

    public Account_Statement() {
        initialize();
        loadTransactionsFromDatabase(); // Load transactions dynamically on initialization
    }

    private void initialize() {
        frmAccountStatement = new JFrame();
        frmAccountStatement.getContentPane().setBackground(new Color(230, 245, 255));
        frmAccountStatement.setTitle("Account Statement");
        frmAccountStatement.setBounds(100, 100, 1200, 600);
        frmAccountStatement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAccountStatement.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 130, 720, 350);
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
        tableRowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(tableRowSorter);
        scrollPane.setViewportView(table);

        JLabel lblAccountStatement = new JLabel("Account Statement");
        lblAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblAccountStatement.setBounds(300, 10, 400, 60);
        frmAccountStatement.getContentPane().add(lblAccountStatement);

        comboBox = new JComboBox<>(new String[]{"Sort by Date", "Sort by Deposit Amount", "Sort by Withdrawal Amount"});
        comboBox.setBounds(120, 500, 200, 30);
        frmAccountStatement.getContentPane().add(comboBox);

        JButton btnGenerateStatement = new JButton("Generate");
        btnGenerateStatement.setBounds(350, 500, 120, 30);
        btnGenerateStatement.addActionListener(e -> handleGenerateStatement());
        frmAccountStatement.getContentPane().add(btnGenerateStatement);

        textField = new JTextField();
        textField.setBounds(50, 90, 200, 30);
        frmAccountStatement.getContentPane().add(textField);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(270, 90, 100, 30);
        btnSearch.addActionListener(e -> {
            String searchText = textField.getText();
            if (searchText.isEmpty()) {
                tableRowSorter.setRowFilter(null); // Clear filter
            } else {
                tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // Case-insensitive search
            }
        });
        frmAccountStatement.getContentPane().add(btnSearch);

        JButton btnHome = new JButton("Home");
        btnHome.setBounds(10, 10, 100, 30);
        btnHome.addActionListener(e -> {
            Home homeWindow = new Home(0); // Replace with user PIN session
            homeWindow.setVisible(true);
            frmAccountStatement.dispose();
        });
        frmAccountStatement.getContentPane().add(btnHome);
    }

    public void loadTransactionsFromDatabase() {
        List<Transaction> transactions = Account_Statement_Database.fetchAllTransactions();

        for (Transaction transaction : transactions) {
            tableModel.addRow(new Object[]{
                transaction.getBalance(),
                transaction.getDeposit(),
                transaction.getWithdrawal(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(transaction.getDate())
            });
        }
    }

    private void handleGenerateStatement() {
        String selectedOption = (String) comboBox.getSelectedItem();

        if ("Sort by Date".equals(selectedOption)) {
            tableRowSorter.setSortKeys(List.of(new RowSorter.SortKey(3, SortOrder.ASCENDING))); // Sort by Date
        } else if ("Sort by Deposit Amount".equals(selectedOption)) {
            tableRowSorter.setSortKeys(List.of(new RowSorter.SortKey(1, SortOrder.DESCENDING))); // Sort by Deposit
        } else if ("Sort by Withdrawal Amount".equals(selectedOption)) {
            tableRowSorter.setSortKeys(List.of(new RowSorter.SortKey(2, SortOrder.DESCENDING))); // Sort by Withdrawal
        }
    }

    public void show() {
        frmAccountStatement.setVisible(true);
    }

    public static void main(String[] args) {
        Account_Statement accountStatement = new Account_Statement();
        accountStatement.show();
    }
}
