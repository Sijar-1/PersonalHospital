package view;
import DAO.Signdao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sign2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign2 frame = new Sign2();
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
	public Sign2() {
		setTitle("\u5BB6\u5EAD\u4F4F\u5740");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("\u7701\u4EFD\uFF1A");
		lblNewLabel.setBounds(130, 30, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E02\uFF1A");
		lblNewLabel_1.setBounds(130, 55, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u533A\uFF1A");
		lblNewLabel_2.setBounds(130, 80, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5177\u4F53\u5730\u5740\uFF1A");
		lblNewLabel_3.setBounds(130, 107, 67, 15);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(194, 104, 148, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4E0A\u4E00\u6B65");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign1 s1=new Sign1();
				s1.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(91, 156, 93, 23);
		contentPane.add(btnNewButton);
		
		
		//省份
		String[] province= {"上海市","天津市","北京市","重庆市","河北省","山西省","辽宁省","吉林省",
							"吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省",
							"河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省","云南省",
							"陕西省","甘肃省","青海省","台湾省","内蒙古自治区","广西壮族自治区","西藏自治区",
							"宁夏回族自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区"};
		JComboBox comboBox = new JComboBox(province);
		comboBox.setBounds(194, 27, 77, 21);
		contentPane.add(comboBox);
	
		
		//市
		String[] city= {"上海市"};
		JComboBox comboBox_1 = new JComboBox(city);
		comboBox_1.setBounds(194, 52, 77, 21);
		contentPane.add(comboBox_1);
		
		//区
				String[] qu= {"黄浦区","徐汇区","长宁区","静安区","普陀区","虹口区","杨浦区","浦东新区",
								"闵行区","宝山区","嘉定区","金山区","松江区","青浦区","奉贤区","崇明区"};
				JComboBox comboBox_2 = new JComboBox(qu);
				comboBox_2.setBounds(194, 77, 77, 21);
				contentPane.add(comboBox_2);
	
		//下一步
		JButton btnNewButton_1 = new JButton("\u4E0B\u4E00\u6B65");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=String.valueOf(comboBox.getSelectedItem());
				s1+=String.valueOf(comboBox_1.getSelectedItem());
				s1+=String.valueOf(comboBox_2.getSelectedItem());
				s1+=textField.getText();
				Sign3 sign3=new Sign3();
				Signdao sdao=new Signdao();
				if(sign3.getjob().equals("患者")){		
					sdao.Signinserta(s1);	
				PatientMain mm=new PatientMain();
				mm.setVisible(true);
				setVisible(false);
				}else {
					sdao.Signinsertad(s1);	
					DoctorSign4 kk=new DoctorSign4();
					kk.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(223, 156, 93, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
