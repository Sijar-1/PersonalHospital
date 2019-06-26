package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Changepassdao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	String password_1,password_2;
	Changepassdao cpdao=new Changepassdao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePass() {
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新密码：");
		lblNewLabel.setBounds(48, 46, 67, 15);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 43, 99, 21);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("确认密码：");
		lblNewLabel_1.setBounds(48, 83, 77, 15);
		contentPane.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(118, 80, 99, 21);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("上一步");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientBingli bb=new PatientBingli();
				bb.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(48, 122, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				password_1=String.valueOf(passwordField.getPassword());
				password_2=String.valueOf(passwordField_1.getPassword());
				if(password_1==password_2) {
					cpdao.changedao(Login.NoId, password_1);
					JOptionPane.showMessageDialog(null, "密码修改成功！", "alert", JOptionPane.ERROR_MESSAGE);
					PatientBingli bb=new PatientBingli();
					bb.setVisible(true);
					setVisible(false);	
				}
				else {
					JOptionPane.showMessageDialog(null, "密码不一致！", "alert", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(151, 122, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
