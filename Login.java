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
        frmLog.getContentPane().setBackground(new Color(230, 245, 254));
        frmLog.setTitle("Login");
        frmLog.setBounds(100, 100, 800, 530);
        frmLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLog.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("LOGIN");
        lblTitle.setForeground(new Color(0, 78, 168));
        lblTitle.setBackground(new Color(0, 78, 168));
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(546, 31, 102, 78);
        frmLog.getContentPane().add(lblTitle);
        
                JLabel lblUsername = new JLabel("User ID");
                lblUsername.setBounds(413, 132, 102, 20);
                frmLog.getContentPane().add(lblUsername);
                lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
                
                        textField = new JTextField();
                        textField.setBounds(413, 232, 341, 20);
                        frmLog.getContentPane().add(textField);
                        textField.setColumns(10);
                        
                                passwordField = new JPasswordField();
                                passwordField.setBounds(413, 163, 341, 20);
                                frmLog.getContentPane().add(passwordField);
                                
                                        JButton btnLogin = new JButton("Login");
                                        btnLogin.setForeground(new Color(0,78,168));
                                        btnLogin.setBackground(Color.WHITE);
                                        btnLogin.setBounds(451, 288, 115, 25);
                                        frmLog.getContentPane().add(btnLogin);
                                        btnLogin.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                String username = textField.getText();
                                                String password = new String(passwordField.getPassword());

                                              
                                                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                                                    JOptionPane.showMessageDialog(frmLog, "Login successful!");
                                                 
                                                    Home home = new Home();
                                                    home.setVisible(true);
                                                    frmLog.dispose();
                                                } else {
                                                    JOptionPane.showMessageDialog(frmLog, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                        });
                                        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
                                        
                                                JLabel lblPassword = new JLabel("Password");
                                                lblPassword.setBounds(413, 196, 102, 37);
                                                frmLog.getContentPane().add(lblPassword);
                                                lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                
                                                JLabel lblNewLabel = new JLabel("Don't have an account?");
                                                lblNewLabel.setForeground(new Color(0,78,168));
                                                lblNewLabel.setBackground(new Color(0, 128, 192));
                                                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                                lblNewLabel.setBounds(440, 363, 161, 20);
                                                frmLog.getContentPane().add(lblNewLabel);
                                                
                                                JButton btnNewButton = new JButton("Sign Up");
                                                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                btnNewButton.setForeground(new Color(0,78,168));
                                                btnNewButton.addActionListener(new ActionListener() {
                                                	public void actionPerformed(ActionEvent e) {
                                                	}
                                                });
                                                btnNewButton.setBackground(Color.WHITE);
                                                btnNewButton.setBounds(603, 357, 120, 37);
                                                frmLog.getContentPane().add(btnNewButton);
                                                
                                                JPanel panel = new JPanel();
                                                panel.setBackground(new Color(0, 78, 168));
                                                panel.setBounds(0, 0, 391, 491);
                                                frmLog.getContentPane().add(panel);
                                                        panel.setLayout(null);
                                                        
                                                        JLabel lblNewLabel_1 = new JLabel("Welcome to PotsBank");
                                                        lblNewLabel_1.setForeground(new Color(230,245,255));
                                                        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
                                                        lblNewLabel_1.setBounds(28, 64, 335, 64);
                                                        panel.add(lblNewLabel_1);
                                                        
                                                        JLabel lblNewLabel_1_1 = new JLabel("Your Trust, Our Commitment");
                                                        lblNewLabel_1_1.setForeground(new Color(252, 183, 21));
                                                        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
                                                        lblNewLabel_1_1.setBounds(86, 125, 219, 35);
                                                        panel.add(lblNewLabel_1_1);
                                                        
                                                        JLabel lbllogInTo = new JLabel("<html>Log in to securely access your online bank account, manage your finances, check your balance, make transactions, and stay in control of your banking needs anytime, anywhere.</html>");
                                                        lbllogInTo.setForeground(new Color(230, 245, 254));
                                                        lbllogInTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                                        lbllogInTo.setBackground(new Color(230, 245, 254));
                                                        lbllogInTo.setBounds(24, 222, 342, 84);
                                                        panel.add(lbllogInTo);
                                                
                                                JButton btnCancel = new JButton("Cancel\r\n");
                                                btnCancel.setForeground(new Color(0,78,168));
                                                btnCancel.setBackground(Color.WHITE);
                                                btnCancel.addActionListener(new ActionListener() {
                                                	public void actionPerformed(ActionEvent e) {
                                                	}
                                                });
                                                btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                btnCancel.setBounds(592, 288, 115, 25);
                                                frmLog.getContentPane().add(btnCancel);
    }

    public void setVisible(boolean visible) {
        frmLog.setVisible(visible);
    }
}