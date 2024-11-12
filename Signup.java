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
        frmSignup.getContentPane().setBackground(new Color(229, 245, 255));
        frmSignup.setTitle("Signup\r\n");
        frmSignup.setBounds(100, 100, 705, 467);
        frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSignup.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("SIGNUP");
        lblTitle.setForeground(new Color(0, 78, 168));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(456, 24, 128, 80);
        frmSignup.getContentPane().add(lblTitle);
        
        String[] accountTypes = {"Savings", "Checking"};
        
                JLabel lblUsername = new JLabel("User ID");
                lblUsername.setForeground(new Color(0, 0, 0));
                lblUsername.setBounds(375, 99, 67, 25);
                frmSignup.getContentPane().add(lblUsername);
                lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
                
                        textFieldUsername = new JTextField();
                        textFieldUsername.setBounds(375, 130, 268, 20);
                        frmSignup.getContentPane().add(textFieldUsername);
                        textFieldUsername.setColumns(10);
                        
                                passwordField = new JPasswordField();
                                passwordField.setBounds(375, 190, 268, 20);
                                frmSignup.getContentPane().add(passwordField);
                                
                                        confirmPasswordField = new JPasswordField();
                                        confirmPasswordField.setBounds(375, 250, 268, 20);
                                        frmSignup.getContentPane().add(confirmPasswordField);
                                        
                                                JLabel lblPassword = new JLabel("Password");
                                                lblPassword.setForeground(new Color(0, 0, 0));
                                                lblPassword.setBounds(375, 155, 89, 31);
                                                frmSignup.getContentPane().add(lblPassword);
                                                lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                
                                                        JLabel lblConfirmPassword = new JLabel("Confirm Password");
                                                        lblConfirmPassword.setForeground(new Color(0, 0, 0));
                                                        lblConfirmPassword.setBounds(375, 220, 159, 25);
                                                        frmSignup.getContentPane().add(lblConfirmPassword);
                                                        lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                        
                                                        JLabel lblAccountType = new JLabel("Account Type");
                                                        lblAccountType.setForeground(new Color(0, 0, 0));
                                                        lblAccountType.setBounds(375, 275, 137, 25);
                                                        frmSignup.getContentPane().add(lblAccountType);
                                                        lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                        JComboBox<String> comboAccountType = new JComboBox<>(accountTypes);
                                                        comboAccountType.setBackground(new Color(245, 185, 19));
                                                        comboAccountType.setForeground(new Color(0, 0, 0));
                                                        comboAccountType.setBounds(375, 305, 268, 31);
                                                        frmSignup.getContentPane().add(comboAccountType);
                                                        comboAccountType.setFont(new Font("Tahoma", Font.BOLD, 11));
                                                        
                                                                JButton btnSubmit = new JButton("Signup");
                                                                btnSubmit.setBackground(new Color(245, 185, 19));
                                                                btnSubmit.setBounds(405, 351, 89, 23);
                                                                frmSignup.getContentPane().add(btnSubmit);
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
                                                                
                                                                JPanel panel = new JPanel();
                                                                panel.setLayout(null);
                                                                panel.setBackground(new Color(0, 78, 168));
                                                                panel.setBounds(0, 0, 312, 428);
                                                                frmSignup.getContentPane().add(panel);
                                                                
                                                                JLabel lblWelcome_1 = new JLabel("Welcome to PotsBank");
                                                                lblWelcome_1.setForeground(new Color(255, 255, 255));
                                                                lblWelcome_1.setBackground(new Color(255, 255, 255));
                                                                lblWelcome_1.setFont(new Font("Tahoma", Font.ITALIC, 30));
                                                                lblWelcome_1.setBounds(10, 197, 301, 31);
                                                                panel.add(lblWelcome_1);
                                                                
                                                                JButton btnCancel = new JButton("Cancel\r\n");
                                                                btnCancel.setBackground(new Color(245, 185, 19));
                                                                btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                                btnCancel.setBounds(521, 351, 89, 23);
                                                                frmSignup.getContentPane().add(btnCancel);
                                                                
                                                                JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
                                                                lblAlreadyHaveAn.setForeground(new Color(0, 78, 168));
                                                                lblAlreadyHaveAn.setBackground(new Color(0, 78, 168));
                                                                lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                                                                lblAlreadyHaveAn.setBounds(390, 396, 147, 20);
                                                                frmSignup.getContentPane().add(lblAlreadyHaveAn);
                                                                
                                                                JButton btnLogin = new JButton("Login");
                                                                btnLogin.setBackground(new Color(245, 185, 19));
                                                                btnLogin.addActionListener(new ActionListener() {
                                                                	public void actionPerformed(ActionEvent e) {
                                                                	}
                                                                });
                                                                btnLogin.setBounds(535, 396, 89, 23);
                                                                frmSignup.getContentPane().add(btnLogin);
    }

    public void setVisible(boolean visible) {
        frmSignup.setVisible(visible);
    }
}
