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
        frmLog.setTitle("Login");
        frmLog.setBounds(100, 100, 705, 467);
        frmLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLog.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("LOGIN");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(462, 24, 102, 78);
        frmLog.getContentPane().add(lblTitle);
        
                JLabel lblUsername = new JLabel("User ID");
                lblUsername.setBounds(375, 134, 102, 20);
                frmLog.getContentPane().add(lblUsername);
                lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
                
                        textField = new JTextField();
                        textField.setBounds(375, 232, 268, 20);
                        frmLog.getContentPane().add(textField);
                        textField.setColumns(10);
                        
                                passwordField = new JPasswordField();
                                passwordField.setBounds(375, 165, 268, 20);
                                frmLog.getContentPane().add(passwordField);
                                
                                        JButton btnLogin = new JButton("Login");
                                        btnLogin.setBounds(388, 274, 89, 23);
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
                                                lblPassword.setBounds(375, 196, 102, 37);
                                                frmLog.getContentPane().add(lblPassword);
                                                lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                
                                                JLabel lblNewLabel = new JLabel("Don't have an account?");
                                                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
                                                lblNewLabel.setBounds(382, 364, 133, 20);
                                                frmLog.getContentPane().add(lblNewLabel);
                                                
                                                JButton btnNewButton = new JButton("Sign Up");
                                                btnNewButton.setBounds(525, 364, 89, 23);
                                                frmLog.getContentPane().add(btnNewButton);
                                                
                                                JPanel panel = new JPanel();
                                                panel.setBackground(Color.LIGHT_GRAY);
                                                panel.setBounds(0, 0, 312, 428);
                                                frmLog.getContentPane().add(panel);
                                                        panel.setLayout(null);
                                                
                                                        JLabel lblWelcome = new JLabel("Welcome to Potsdam Bank");
                                                        lblWelcome.setBounds(26, 199, 256, 31);
                                                        panel.add(lblWelcome);
                                                        lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 23));
                                                
                                                JButton btnCancel = new JButton("Cancel\r\n");
                                                btnCancel.addActionListener(new ActionListener() {
                                                	public void actionPerformed(ActionEvent e) {
                                                	}
                                                });
                                                btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                btnCancel.setBounds(525, 274, 89, 23);
                                                frmLog.getContentPane().add(btnCancel);
    }

    public void setVisible(boolean visible) {
        frmLog.setVisible(visible);
    }
}
