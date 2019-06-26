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

import DAO.Jianchadao;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PatientJiancha extends JFrame {

	private JPanel contentPane;
	private static String GuahaoNo;
	private JTextField textField;
	private JTextField txtA;
	private JTextField textField_cost;
	Jianchadao jcdao =new Jianchadao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientJiancha frame = new PatientJiancha();
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
	public PatientJiancha() {
		setTitle("检查");
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
			//}
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
		
		JLabel lblNewLabel = new JLabel("检查项目：");
		lblNewLabel.setBounds(56, 39, 81, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 36, 106, 21);
		textField.setText("血常规");
		panel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("检查地点：");
		lblNewLabel_1.setBounds(56, 73, 81, 15);
		panel.add(lblNewLabel_1);
		
		txtA = new JTextField();
		txtA.setBounds(127, 70, 106, 21);
		txtA.setText("A614");
		panel.add(txtA);
		txtA.setColumns(10);
		txtA.setEditable(false);
		
		JLabel label = new JLabel("检查费用：");
		label.setBounds(56, 113, 81, 15);
		panel.add(label);
		
		textField_cost = new JTextField();
		textField_cost.setEditable(false);
		textField_cost.setText("35元");
		textField_cost.setColumns(10);
		textField_cost.setBounds(127, 110, 106, 21);
		panel.add(textField_cost);
	}

}
