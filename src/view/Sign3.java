package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sign3 extends JFrame {

	private JPanel contentPane;
	private static String job;//患者Or医生
	
	public String getjob() {
		return job;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign3 frame = new Sign3();
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
	public Sign3() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u60A8\u7684\u8EAB\u4EFD\uFF1F");
		lblNewLabel.setBounds(162, 41, 131, 15);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u60A3\u8005");
		rdbtnNewRadioButton.setBounds(129, 79, 73, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(null);

		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u533B\u751F");
		rdbtnNewRadioButton_1.setBounds(237, 79, 82, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(null);
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u6B65");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sign2 s2=new Sign2();
				s2.setVisible(true);
				setVisible(true);
			}
		});
		btnNewButton.setBounds(96, 128, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u6B65");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					job="患者";
					Sign1 s1=new Sign1();
					s1.setVisible(true);
					setVisible(false);
				}
				else if(rdbtnNewRadioButton_1.isSelected()){
					job="医生";
					Sign1 s1=new Sign1();
					s1.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(239, 128, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
