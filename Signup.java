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
        frmSignup.setBounds(100, 100, 800, 530);
        frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSignup.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("SIGNUP");
        lblTitle.setBackground(new Color(204, 51, 51));
        lblTitle.setForeground(new Color(0,78,168));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(535, 21, 128, 80);
        frmSignup.getContentPane().add(lblTitle);
        
        String[] accountTypes = {"Savings", "Checking"};
        
                JLabel lblUsername = new JLabel("User ID");
                lblUsername.setForeground(new Color(0, 0, 0));
                lblUsername.setBounds(427, 88, 67, 25);
                frmSignup.getContentPane().add(lblUsername);
                lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
                
                        textFieldUsername = new JTextField();
                        textFieldUsername.setBounds(426, 124, 320, 20);
                        frmSignup.getContentPane().add(textFieldUsername);
                        textFieldUsername.setColumns(10);
                        
                                passwordField = new JPasswordField();
                                passwordField.setBounds(426, 185, 320, 20);
                                frmSignup.getContentPane().add(passwordField);
                                
                                        confirmPasswordField = new JPasswordField();
                                        confirmPasswordField.setBounds(426, 256, 320, 20);
                                        frmSignup.getContentPane().add(confirmPasswordField);
                                        
                                                JLabel lblPassword = new JLabel("Password");
                                                lblPassword.setForeground(new Color(0, 0, 0));
                                                lblPassword.setBounds(423, 155, 89, 31);
                                                frmSignup.getContentPane().add(lblPassword);
                                                lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                
                                                        JLabel lblConfirmPassword = new JLabel("Confirm Password");
                                                        lblConfirmPassword.setForeground(new Color(0, 0, 0));
                                                        lblConfirmPassword.setBounds(424, 220, 159, 25);
                                                        frmSignup.getContentPane().add(lblConfirmPassword);
                                                        lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                        
                                                        JLabel lblAccountType = new JLabel("Account Type");
                                                        lblAccountType.setForeground(new Color(0, 0, 0));
                                                        lblAccountType.setBounds(427, 284, 137, 25);
                                                        frmSignup.getContentPane().add(lblAccountType);
                                                        lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                        JComboBox<String> comboAccountType = new JComboBox<>(accountTypes);
                                                        comboAccountType.setBackground(Color.WHITE);
                                                        comboAccountType.setForeground(new Color(0, 0, 0));
                                                        comboAccountType.setBounds(426, 320, 320, 31);
                                                        frmSignup.getContentPane().add(comboAccountType);
                                                        comboAccountType.setFont(new Font("Tahoma", Font.BOLD, 11));
                                                        
                                                                JButton btnSubmit = new JButton("Signup");
                                                                btnSubmit.setForeground(new Color(0,78,168));
                                                                btnSubmit.setBackground(Color.WHITE);
                                                                btnSubmit.setBounds(475, 374, 89, 23);
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
                                                                
                                                                JButton btnCancel = new JButton("Cancel\r\n");
                                                                btnCancel.setForeground(new Color(0,78,168));
                                                                btnCancel.addActionListener(new ActionListener() {
                                                                	public void actionPerformed(ActionEvent e) {
                                                                	}
                                                                });
                                                                btnCancel.setBackground(Color.WHITE);
                                                                btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                                btnCancel.setBounds(603, 374, 89, 23);
                                                                frmSignup.getContentPane().add(btnCancel);
                                                                
                                                                JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
                                                                lblAlreadyHaveAn.setForeground(new Color(0, 78, 168));
                                                                lblAlreadyHaveAn.setBackground(new Color(0, 78, 168));
                                                                lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                                                                lblAlreadyHaveAn.setBounds(455, 423, 147, 20);
                                                                frmSignup.getContentPane().add(lblAlreadyHaveAn);
                                                                
                                                                JButton btnLogin = new JButton("Login");
                                                                btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                                btnLogin.setForeground(new Color(0,78,168));
                                                                btnLogin.setBackground(Color.WHITE);
                                                                btnLogin.addActionListener(new ActionListener() {
                                                                	public void actionPerformed(ActionEvent e) {
                                                                	}
                                                                });
                                                                btnLogin.setBounds(603, 421, 89, 23);
                                                                frmSignup.getContentPane().add(btnLogin);
                                                                
                                                                JPanel panel = new JPanel();
                                                                panel.setLayout(null);
                                                                panel.setBackground(new Color(0, 78, 168));
                                                                panel.setBounds(0, 0, 391, 491);
                                                                frmSignup.getContentPane().add(panel);
                                                                
                                                                JLabel lblNewLabel_1 = new JLabel("Welcome to PotsBank");
                                                                lblNewLabel_1.setForeground(new Color(230, 245, 255));
                                                                lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
                                                                lblNewLabel_1.setBounds(28, 64, 335, 64);
                                                                panel.add(lblNewLabel_1);
                                                                
                                                                JLabel lblNewLabel_1_1 = new JLabel("Your Trust, Our Commitment");
                                                                lblNewLabel_1_1.setForeground(new Color(252, 183, 21));
                                                                lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
                                                                lblNewLabel_1_1.setBounds(86, 125, 219, 35);
                                                                panel.add(lblNewLabel_1_1);
                                                                
                                                                JLabel lblsignUpTo = new JLabel("<html>Sign up to create your online bank account and enjoy secure access to manage your finances, check balances, transfer funds, and more convenient banking at your fingertips.</html>");
                                                                lblsignUpTo.setForeground(new Color(230, 245, 254));
                                                                lblsignUpTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                                                lblsignUpTo.setBackground(new Color(230, 245, 254));
                                                                lblsignUpTo.setBounds(38, 222, 314, 84);
                                                                panel.add(lblsignUpTo);
    }

    public void setVisible(boolean visible) {
        frmSignup.setVisible(visible);
    }
}