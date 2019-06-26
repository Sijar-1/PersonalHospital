package view;

import DAO.SelectDepartment;
import DAO.SelectDoctor;
import DAO.Signdao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.SelectDepartment;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorSign4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int DocNo;
	private String DocKeshi;
	private int DepartmentNo;
	public static String No2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorSign4 frame = new DoctorSign4();
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
	public DoctorSign4() {
		setTitle("医生注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("工号：");
		lblNewLabel.setBounds(115, 54, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("科室：");
		lblNewLabel_1.setBounds(115, 84, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		//工号
		/*SelectDoctor aa=new SelectDoctor("select JobNo from T_Doctor");
		Object[][] bb=aa.GetBody();
		int i=0;
		for(;i<bb.length;i++) {
			if(bb[i][0].equals(null))
				break;
		}
		String no=(String)bb[i-1][0];*/
		textField = new JTextField();
		textField.setBounds(179, 51, 107, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		Sign1 ss1=new Sign1();
		textField.setText(ss1.No);
		textField.setEditable(false);
		
		//选择科室
		SelectDepartment a=new SelectDepartment("select * from T_Department");
		Object[][] b=a.GetBody();
		String c[]=new String[b.length];
		String d[]=new String[b.length];
		for(int j=0;j<b.length;j++) {
			c[j]=String.valueOf(b[j][1]);
		}for(int j=0;j<b.length;j++) {
			d[j]=String.valueOf(b[j][0]);
		}
		JComboBox comboBox = new JComboBox(c);
		comboBox.setBounds(179, 81, 107, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("上一步");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sign2 s2=new Sign2();
				s2.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(111, 136, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("下一步");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//DocNo=Integer.valueOf(textField.getText());
				DocKeshi=String.valueOf(comboBox.getSelectedItem());
				int k=0;
				for(;k<c.length;k++) {
					if(DocKeshi.equals(c[k]))break;
					continue;
				}
				//System.out.println(d[k]);
				DepartmentNo=Integer.parseInt((String)b[k][0]);
				
				Signdao dd=new Signdao();
				dd.Signinsertd2(DepartmentNo);
				
				Kanbing kk=new Kanbing();
				kk.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(224, 136, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
