package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientMain extends JFrame {

	private JPanel contentPane;
	private static String GuahaoNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientMain frame = new PatientMain();
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
	public PatientMain() {
		setTitle("患者");
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
	}

}
