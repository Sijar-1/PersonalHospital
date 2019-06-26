package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Logindao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public static String UserId;
	public static String NoId;
	private String UserPassword;
	private JButton btnNewButton_1;
	String ret;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("PersonalHospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("身份证号：");
		lblNewLabel.setBounds(159, 78, 71, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(159, 110, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		//�û���
		textField = new JTextField();
		textField.setBounds(240, 75, 108, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//����
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 107, 108, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserId=textField.getText();
				UserPassword=passwordField.getText();
				//System.out.println(UserId+" "+UserPassword);
				Sign3 s3=new Sign3();
				s3.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(140, 173, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u767B\u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserId=textField.getText();
				UserPassword=passwordField.getText();
				//System.out.println(UserId+" "+UserPassword);
			int test=0;
			Logindao ldao=new Logindao();
			ret=ldao.loginselect(UserId,UserPassword);
			System.out.println(ret);
			   if(ret.equals("1")) {
				   PatientMain p=new PatientMain();
				   p.setVisible(true);
				   setVisible(false);		
			       }
			   else  {
				   ret=ldao.loginselect2(UserId,UserPassword);
				   if(ret.equals("1")) {
				      Kanbing k=new Kanbing();
				      k.setVisible(true);
				      setVisible(false);		
				      test=1;
				     }
				   else{
					    JOptionPane.showMessageDialog(null, "用户密码不匹配！", "alert", JOptionPane.ERROR_MESSAGE); 
				       }
				}	
			
				
			}
		});
		btnNewButton_2.setBounds(255, 173, 93, 23);
		contentPane.add(btnNewButton_2);
		
		//图片
		btnNewButton_1 = new JButton(" ");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setIcon(new ImageIcon("D:\\Users\\eclipse\\eclipse-workspace\\PersonalHospital\\src\\Image\\yiyuan.png"));
		btnNewButton_1.setBounds(10, 39, 117, 134);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
	}
}
