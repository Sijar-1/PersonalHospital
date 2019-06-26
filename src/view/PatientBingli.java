package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.PatientBinglidao;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PatientBingli extends JFrame {

	private static String GuahaoNo;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Login login=new Login();
	PatientBinglidao pbli=new PatientBinglidao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientBingli frame = new PatientBingli();
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
	public PatientBingli() {
		setTitle("个人病历");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JButton Buttonguahao = new JButton("挂号");
		Buttonguahao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientGuahao hh=new PatientGuahao();
				hh.setVisible(true);
				setVisible(false);
			}
		});
		Buttonguahao.setBounds(10, 25, 93, 23);
		contentPane.add(Buttonguahao);
		
		JButton Buttonquyao = new JButton("取药");
		Buttonquyao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientGuahao gg=new PatientGuahao();
				GuahaoNo=gg.getGuahaoNo();
				if(GuahaoNo==null) {
					JOptionPane.showMessageDialog(null, "无挂号信息！", "alert", JOptionPane.ERROR_MESSAGE); 
				}
				else {
					PatientQuhao qq=new PatientQuhao();
					qq.setVisible(true);
					setVisible(false);
				}
			}
		});
		Buttonquyao.setBounds(10, 68, 93, 23);
		contentPane.add(Buttonquyao);
		
		JButton Buttonjiancha = new JButton("检查");
		Buttonjiancha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientGuahao gg=new PatientGuahao();
				GuahaoNo=gg.getGuahaoNo();
				if(GuahaoNo==null) {
					JOptionPane.showMessageDialog(null, "无挂号信息！", "alert", JOptionPane.ERROR_MESSAGE); 
				}
				else {
					PatientJiancha qq=new PatientJiancha();
					qq.setVisible(true);
					setVisible(false);
				}
			}
		});
		Buttonjiancha.setBounds(10, 110, 93, 23);
		contentPane.add(Buttonjiancha);
		
		JButton Buttonjioafei = new JButton("缴费");
		Buttonjioafei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	PatientGuahao gg=new PatientGuahao();
				GuahaoNo=gg.getGuahaoNo();
				if(GuahaoNo==null) {
					JOptionPane.showMessageDialog(null, "无挂号信息！", "alert", JOptionPane.ERROR_MESSAGE); 
				}
				else {*/
					PatientPay qq=new PatientPay();
					qq.setVisible(true);
					setVisible(false);
			//	}
			}
		});
		Buttonjioafei.setBounds(10, 153, 93, 23);
		contentPane.add(Buttonjioafei);
		
		JButton Buttongeren = new JButton("个人中心");
		Buttongeren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					PatientBingli qq=new PatientBingli();
					qq.setVisible(true);
					setVisible(false);
				
			}
		});
		Buttongeren.setBounds(10, 196, 93, 23);
		contentPane.add(Buttongeren);
		
		JPanel panel = new JPanel();
		panel.setBounds(124, -1, 300, 220);
		contentPane.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setBounds(43, 21, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("性别：");
		lblNewLabel_1.setBounds(43, 46, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("过敏史：");
		lblNewLabel_2.setBounds(43, 72, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("历史病历：");
		lblNewLabel_3.setBounds(43, 132, 68, 15);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(107, 18, 66, 21);
		System.out.println(login.NoId);
		textField.setText(pbli.pblname(login.NoId));
		panel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
	
		textField_1 = new JTextField();
		textField_1.setBounds(107, 43, 66, 21);
		textField_1.setText(pbli.pblsex(login.NoId));
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(107, 69, 161, 53);
		textField_2.setText(pbli.pblguomin(login.NoId));
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(107, 129, 161, 53);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton Buttonchangepass = new JButton("修改密码");
		Buttonchangepass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass pp=new ChangePass();
				pp.setVisible(true);
				setVisible(false);
			}
		});
		Buttonchangepass.setBounds(197, 192, 93, 23);
		panel.add(Buttonchangepass);
	}

}
