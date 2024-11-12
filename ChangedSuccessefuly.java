package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ChangedSuccessefuly extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangedSuccessefuly frame = new ChangedSuccessefuly();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ChangedSuccessefuly() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 659);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 245, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Make Another\r\n Transaction?");
		btnNewButton.setBackground(new Color(252, 183, 21));
		btnNewButton.setBounds(304, 420, 295, 106);
		btnNewButton.setForeground(new Color(0, 78, 168));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(239, 42, 437, 316);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pin Changed Successfully");
		lblNewLabel.setForeground(new Color(0, 78, 168));
		lblNewLabel.setBackground(new Color(0, 78, 168));
		lblNewLabel.setBounds(62, 244, 320, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(101, 11, 226, 231);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ChangedSuccessefuly.class.getResource("/Images/Check.png")));
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Going back to homepage", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
