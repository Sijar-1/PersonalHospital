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

import DAO.Paydao;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PatientPay extends JFrame {

	private JPanel contentPane;
	private static String GuahaoNo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Paydao pdao=new Paydao();
	public static float ssumcost=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientPay frame = new PatientPay();
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
	public PatientPay() {
		setTitle("缴费");
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
				PatientGuahao gg=new PatientGuahao();
				GuahaoNo=gg.getGuahaoNo();
				if(GuahaoNo==null) {
					JOptionPane.showMessageDialog(null, "无挂号信息！", "alert", JOptionPane.ERROR_MESSAGE); 
				}
				else {
					PatientPay qq=new PatientPay();
					qq.setVisible(true);
					setVisible(false);
				}
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
		
		JLabel lblNewLabel = new JLabel("挂号需缴费：");
		lblNewLabel.setBounds(55, 31, 83, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(142, 28, 66, 21);
		textField.setText("5元");
		panel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("药品需缴费：");
		lblNewLabel_1.setBounds(55, 61, 83, 15);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 58, 66, 21);
		textField_1.setText("87.5元");
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("检查需缴费：");
		lblNewLabel_2.setBounds(55, 93, 83, 15);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 90, 66, 21);
		textField_2.setText("35元");
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JButton Alipay = new JButton("支付宝支付");
		Alipay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String ssumcost1,ssumcost2,ssumcost3;
				int ssss;
				ssumcost1=pdao.guahaopay(Login.NoId).trim();
				ssumcost2=pdao.yaopay(Login.NoId).trim();
				ssumcost3=pdao.checkpay(Login.NoId).trim();
				ssss=Integer.parseInt(ssumcost1);
				ssumcost+=ssss;
				ssss=Integer.parseInt(ssumcost2);
				ssumcost+=ssss;
				ssss=Integer.parseInt(ssumcost3);
				ssumcost+=ssss;*/
				
				String ssumcost1,ssumcost2,ssumcost3;
				ssumcost1=pdao.guahaopay(Login.NoId).trim();
				ssumcost2=pdao.yaopay(Login.NoId).trim();
				ssumcost3=pdao.checkpay(Login.NoId).trim();
				ssumcost=Float.parseFloat(ssumcost1)+Float.parseFloat(ssumcost2)+Float.parseFloat(ssumcost3);
				pdao.yaonopay(Login.NoId);
				ConfirmPay ff=new ConfirmPay();
				ff.setVisible(true);
				setVisible(false);
			}
		});
		Alipay.setBounds(26, 146, 105, 23);
		panel.add(Alipay);
		
		JButton Wechat = new JButton("微信支付");
		Wechat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssumcost1,ssumcost2,ssumcost3;
				ssumcost1=pdao.guahaopay(Login.NoId).trim();
				ssumcost2=pdao.yaopay(Login.NoId).trim();
				ssumcost3=pdao.checkpay(Login.NoId).trim();
				ssumcost=Float.parseFloat(ssumcost1)+Float.parseFloat(ssumcost2)+Float.parseFloat(ssumcost3);
				pdao.yaonopay(Login.NoId);
				ConfirmPay ff=new ConfirmPay();
				ff.setVisible(true);
				setVisible(false);
			}
		});
		Wechat.setBounds(142, 146, 112, 23);
		panel.add(Wechat);
	}
	

}
