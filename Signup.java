package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class Signup {

    private JFrame frmSignup;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    // HashMap to store username and password (acting as a mock database)
    private static HashMap<String, String> userDatabase = new HashMap<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Signup window = new Signup();
                    window.frmSignup.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Signup() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmSignup = new JFrame();
        frmSignup.setTitle("Signup\r\n");
        frmSignup.setBounds(100, 100, 628, 557);
        frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSignup.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Signup");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(252, 61, 109, 80);
        frmSignup.getContentPane().add(lblTitle);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(75, 145, 460, 350);
        frmSignup.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("User ID");
        lblUsername.setBounds(40, 35, 102, 25);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(40, 66, 390, 20);
        panel.add(textFieldUsername);
        textFieldUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 97, 102, 31);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(40, 128, 390, 20);
        panel.add(passwordField);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(40, 159, 183, 25);
        lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblConfirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(40, 193, 390, 20);
        panel.add(confirmPasswordField);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(186, 308, 89, 23);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Basic validation
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frmSignup, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frmSignup, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

              
                userDatabase.put(username, password);

                JOptionPane.showMessageDialog(frmSignup, "Account created successfully!");
                
               
                Login login = new Login(userDatabase);  
                login.setVisible(true);
                frmSignup.dispose();
            }
        });
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(btnSubmit);
        
        String[] accountTypes = {"Savings", "Checking"};
        JComboBox<String> comboAccountType = new JComboBox<>(accountTypes);
        comboAccountType.setFont(new Font("Tahoma", Font.BOLD, 11));
        comboAccountType.setBounds(40, 259, 390, 31);
        panel.add(comboAccountType);
        
        JLabel lblAccountType = new JLabel("Account Type");
        lblAccountType.setBounds(40, 223, 137, 25);
        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(lblAccountType);

        JLabel lblWelcome = new JLabel("Welcome to PotsBank");
        lblWelcome.setFont(new Font("Tahoma", Font.ITALIC, 30));
        lblWelcome.setBounds(159, 11, 293, 64);
        frmSignup.getContentPane().add(lblWelcome);
    }

    public void setVisible(boolean visible) {
        frmSignup.setVisible(visible);
    }
}
