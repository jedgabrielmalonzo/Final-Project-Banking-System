package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Check_Balance {

    private JFrame frmCheckBalance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Check_Balance window = new Check_Balance();
                    window.frmCheckBalance.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

 
    public Check_Balance() {
        initialize();
    }

  
    private void initialize() {
        frmCheckBalance = new JFrame();
        frmCheckBalance.setTitle("Check Balance");
        frmCheckBalance.setBounds(100, 100, 876, 540);
        frmCheckBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCheckBalance.getContentPane().setLayout(null);

        JButton btnCheckBalance = new JButton("Check Current Balance");
        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPin();
            }
        });
        btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCheckBalance.setBounds(271, 183, 311, 78);
        frmCheckBalance.getContentPane().add(btnCheckBalance);

        JButton btnBankStatement = new JButton("Check Bank Statement");
        btnBankStatement.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBankStatement.setBounds(271, 307, 311, 78);
        frmCheckBalance.getContentPane().add(btnBankStatement);
        

        JLabel lblCheckBalance = new JLabel("Check Balance");
        lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblCheckBalance.setBounds(319, 23, 221, 78);
        frmCheckBalance.getContentPane().add(lblCheckBalance);

        JButton btnHome = new JButton("Home");
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnHome.setBounds(10, 23, 89, 23);
        frmCheckBalance.getContentPane().add(btnHome);
    }

    private void checkPin() {
        
        String pin = JOptionPane.showInputDialog(frmCheckBalance, "Please enter your four-digit PIN:");

        
        if (pin != null) {
            if (pin.length() == 5) {
                JOptionPane.showMessageDialog(frmCheckBalance, "PIN accepted. Please continue.");
            } else {
                JOptionPane.showMessageDialog(frmCheckBalance, "Error: PIN must be 5 digits.", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
