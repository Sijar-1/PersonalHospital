package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Quyaodao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PatientQuhao extends JFrame {

	private JPanel contentPane;
	private JTextField textField_jiaofei;
	private static String GuahaoNo;
	Quyaodao qydao=new Quyaodao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientQuhao frame = new PatientQuhao();
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
	public PatientQuhao() {
		setTitle("取药");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JButton btnNewButton = new JButton("挂号");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientGuahao hh=new PatientGuahao();
				hh.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 25, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取药");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(10, 68, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("检查");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBounds(10, 110, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("缴费");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setBounds(10, 153, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("个人病历");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					PatientBingli qq=new PatientBingli();
					qq.setVisible(true);
					setVisible(false);
				
			}
		});
		btnNewButton_4.setBounds(10, 196, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(124, 10, 300, 220);
		contentPane.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("取药品：");
		lblNewLabel.setBounds(54, 23, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("需交费：");
		lblNewLabel_1.setBounds(54, 93, 54, 15);
		panel.add(lblNewLabel_1);
		
		textField_jiaofei = new JTextField();
		textField_jiaofei.setText("87.3元");
		textField_jiaofei.setBounds(109, 90, 66, 21);
		panel.add(textField_jiaofei);
		textField_jiaofei.setColumns(10);
		textField_jiaofei.setEditable(false);
		
		JButton confirm = new JButton("确定");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientMain mm=new PatientMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		confirm.setBounds(25, 137, 93, 23);
		panel.add(confirm);
		
		JButton btnNewButton_6 = new JButton("去缴费");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientPay pp=new PatientPay();
				pp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(161, 137, 93, 23);
		panel.add(btnNewButton_6);
		
		JTextArea textAreayaoname = new JTextArea();
		textAreayaoname.setEditable(false);
		textAreayaoname.setText("白云山消炎镇痛膏 *2\n999感冒灵颗粒*1\n一康 清淋颗粒*2");
		textAreayaoname.setBounds(103, 19, 151, 62);
		panel.add(textAreayaoname);
	}
}
