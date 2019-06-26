 package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ConfirmPaydao;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmPay extends JFrame {

	private JPanel contentPane;
	private String PayMoney;
	PatientPay pp=new PatientPay();
	ConfirmPaydao cpdao=new ConfirmPaydao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmPay frame = new ConfirmPay();
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
	public ConfirmPay() {
		setTitle("确认缴费");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 257, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(70, 42, 135, 15);
		contentPane.add(lblNewLabel);
		PayMoney=String.valueOf(pp.ssumcost);
		lblNewLabel.setText("确认支付117.5元");
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpdao.boughtguahao(Login.NoId);
				cpdao.boughtyao(Login.NoId);
				cpdao.boughtcheck(Login.NoId);
				
				PatientMain mm=new PatientMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(66, 75, 93, 23);
		contentPane.add(btnNewButton);
	}

}
