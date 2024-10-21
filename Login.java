package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Login {

    private JFrame frmLog;
    private JTextField textField;
    private JPasswordField passwordField;

    // Reference to the user database (passed from Signup)
    private HashMap<String, String> userDatabase;

    /**
     * Constructor to pass the user database.
     */
    public Login(HashMap<String, String> userDatabase) {
        this.userDatabase = userDatabase;
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login(new HashMap<>());  // Initialize with an empty database
                    window.frmLog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLog = new JFrame();
        frmLog.setTitle("LOGIN");
        frmLog.setBounds(100, 100, 628, 557);
        frmLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLog.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Login");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(262, 59, 88, 78);
        frmLog.getContentPane().add(lblTitle);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(77, 203, 460, 216);
        frmLog.getContentPane().add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(40, 70, 387, 20);
        panel.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(40, 126, 387, 20);
        panel.add(passwordField);

        JLabel lblUsername = new JLabel("User ID");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUsername.setBounds(40, 35, 102, 20);
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPassword.setBounds(40, 91, 102, 37);
        panel.add(lblPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the username exists and the password matches
                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(frmLog, "Login successful!");
                    // Proceed to the Home window
                    Home home = new Home();
                    home.setVisible(true);
                    frmLog.dispose();
                } else {
                    JOptionPane.showMessageDialog(frmLog, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogin.setBounds(181, 169, 89, 23);
        panel.add(btnLogin);

        JLabel lblWelcome = new JLabel("Welcome to Potsdam Bank");
        lblWelcome.setFont(new Font("Tahoma", Font.ITALIC, 30));
        lblWelcome.setBounds(125, 11, 362, 64);
        frmLog.getContentPane().add(lblWelcome);
    }

    public void setVisible(boolean visible) {
        frmLog.setVisible(visible);
    }
}
