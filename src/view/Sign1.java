package view;
import DAO.Signdao;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Sign1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	private String name;
	private String ID;
	private String password_1;
	private String password_2;
	private String sex;
	private int[] identity;//���֤����
	public static String No;
	private JTextField textField_2;
	private String phone;
    Login login=new Login();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign1 frame = new Sign1();
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
	public Sign1() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(107, 31, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_1.setBounds(107, 56, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblNewLabel_2.setBounds(107, 107, 75, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(107, 132, 75, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setBounds(107, 157, 75, 15);
		contentPane.add(lblNewLabel_4);
		
		//����
		textField = new JTextField();
		textField.setBounds(171, 28, 115, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 104, 115, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		//��������
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 129, 115, 21);
		contentPane.add(passwordField);
		
		//ȷ������
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(171, 154, 115, 21);
		contentPane.add(passwordField_1);
		
		//�Ա�
		String[] sexchoose= {"男","女"};
		JComboBox Box_in = new JComboBox(sexchoose);
		Box_in.setBounds(171, 51, 54, 25);
		contentPane.add(Box_in);
		
		//手机号
				textField_2 = new JTextField();
				textField_2.setBounds(171, 79, 115, 21);
				contentPane.add(textField_2);
				textField_2.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u6B65");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login ll=new Login();
				ll.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(89, 208, 93, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u6B65");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name=textField.getText();
				ID=textField_1.getText();
				phone=textField_2.getText();
				password_1=String.valueOf(passwordField.getPassword());
				password_2=String.valueOf(passwordField_1.getPassword());
				if(String.valueOf(Box_in.getSelectedItem()).equals("男"))
						{
					sex="M";
				}else {
					sex="F";
				}
			if(name.equals("")||ID.equals("")||password_1.equals("")||phone.equals("")) {
				JOptionPane.showMessageDialog(null, "不可为空！", "alert", JOptionPane.ERROR_MESSAGE); 
			}//if		
			else if(password_1.equals(password_2)) {
					Signdao sdao=new Signdao();
					Sign3 s3=new Sign3();
					String a=s3.getjob();
					System.out.println(a);
					if(a.equals("患者")) {
						No=sdao.Signinsertp(name,ID,sex,password_1,phone);
						login.NoId=No;
					}else {
						No=sdao.Signinsertd(name,ID,sex,password_1,phone);
						login.NoId=No;
					}
					Sign2 s2=new Sign2();
					s2.setVisible(true);
					setVisible(false);
				}//else if
				else {
					ConfiemPass cc=new ConfiemPass();
					cc.setVisible(true);
					setVisible(false);
				}//else //end if
			}
		});
		btnNewButton_1.setBounds(224, 208, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("手机号：");
		lblNewLabel_5.setBounds(107, 82, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		
		
	

	}
}
