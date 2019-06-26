package view;
import DAO.Sqlcon;
import DAO.PatienGuahaodao;
import DAO.SelectDepartment;
import DAO.SelectDoctor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PatientGuahao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldaddress;
	private String keshi;
	private static ButtonGroup bg;
	private static JRadioButton radios[]=new JRadioButton[10];
	private static Object ddd[][]=new Object[10][9];
	private JTextField textFieldbianhao;
	private static String GuahaoNo;
	private static String JobNoo;
	PatienGuahaodao pghdao=new PatienGuahaodao();
	Login login=new Login();
	private static String _date1;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientGuahao frame = new PatientGuahao();
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
	public PatientGuahao() {
		Calendar calen = Calendar.getInstance();//可以对每个时间域单独修改
		int year = calen.get(Calendar.YEAR);
		int month = calen.get(Calendar.MONTH);
		int date = calen.get(Calendar.DATE);
	
		_date1=String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(date);
		System.out.println("now:"+_date1);
		GuahaoNo=pghdao.chaguahao(login.NoId, _date1);
		setTitle("挂号");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		JButton btnNewButton = new JButton("挂号");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
			}
		});
		btnNewButton.setBounds(10, 25, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取药");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuahaoNo=pghdao.chaguahao(login.NoId, _date1);
				System.out.println("取药guahaode"+GuahaoNo);
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
				GuahaoNo=pghdao.chaguahao(login.NoId, _date1);
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
			/*	if(GuahaoNo==null) {
					GuahaoNo=pghdao.chaguahao(login.NoId, _date1);
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
		
		JLabel lblNewLabel = new JLabel("请选择挂号科室：");
		lblNewLabel.setBounds(10, 20, 107, 15);
		panel.add(lblNewLabel);
		
		//科室下拉框
		SelectDepartment a=new SelectDepartment("select * from T_Department");
		Object[][] b=a.GetBody();
		String c[]=new String[b.length];
		String d[]=new String[b.length];
		String e[]=new String[b.length];
		//名字
		for(int j=0;j<b.length;j++) {
			c[j]=String.valueOf(b[j][1]);
		}
		//地点
		for(int j=0;j<b.length;j++) {
			d[j]=String.valueOf(b[j][2]);
		}
		//编号
		for(int j=0;j<b.length;j++) {
			e[j]=String.valueOf(b[j][0]);
		}
		JComboBox comboBox = new JComboBox(c);
		comboBox.setBounds(112, 17, 107, 21);
		panel.add(comboBox);
		
		//科室
		textFieldaddress = new JTextField();
		textFieldaddress.setBounds(210, 57, 66, 21);
		panel.add(textFieldaddress);
		textFieldaddress.setColumns(10);
		textFieldaddress.setVisible(false);
		textFieldaddress.setEditable(false);
		
		//挂号编号
		textFieldbianhao = new JTextField();
		textFieldbianhao.setBounds(69, 57, 66, 21);
		panel.add(textFieldbianhao);
		textFieldbianhao.setEditable(false);
		textFieldbianhao.setColumns(10);
		textFieldbianhao.setVisible(false);;
		
		JLabel lblNewLabel_1 = new JLabel("科室地点：");
		lblNewLabel_1.setBounds(145, 60, 74, 15);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel Labeldoctor = new JLabel("选择医生：");
		Labeldoctor.setBounds(49, 99, 74, 15);
		panel.add(Labeldoctor);
		Labeldoctor.setVisible(false);
		
		JButton Buttonguahao = new JButton("挂号");
		Buttonguahao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				keshi=String.valueOf(comboBox.getSelectedItem());
				bg=new ButtonGroup();
				//显示科室
				int k=0;
				for(;k<c.length;k++) {
					if(keshi.equals(c[k]))break;
					continue;
				}
				lblNewLabel_1.setVisible(true);
				textFieldaddress.setVisible(true);
				textFieldaddress.setText(d[k]);
				
				//显示挂号编号
			//	textFieldbianhao.setVisible(true);
				
			//	pghdao.pghghuahao(login.NoId);
				//GuahaoNo=pghdao.pghbianhao(login.NoId);
			//	System.out.println("挂号编号呀"+GuahaoNo);
				//textFieldbianhao.setText(GuahaoNo);
			
				//显示医生
				Labeldoctor.setVisible(true);
				SelectDoctor dd=new SelectDoctor("select * from T_doctor where DepartmentNo='"+e[k]+"'");
				
				ddd=dd.GetBody();
				int v=0;
				int initalD=95;//初始位置
				
				for(;v<ddd.length;v++) {
					if(ddd[v][0]!=null) {
						//显示复选框
						radios[v]= new JRadioButton((String)ddd[v][1]);
						radios[v].setActionCommand((String)ddd[v][0]);
						System.out.println("radios"+radios[v].getActionCommand());
						radios[v].setBounds(112, initalD, 121, 23);
						panel.add(radios[v]);
						radios[v].setBackground(null);
						bg.add(radios[v]);
						
						initalD=initalD+20;
						
					}
				}
				
				
				
			}
			
			
		
			
		});
		Buttonguahao.setBounds(229, 16, 69, 23);
		panel.add(Buttonguahao);
		
		
	
		

		
		
		JLabel lblNewLabel_3 = new JLabel("挂号编号：");
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setBounds(10, 60, 66, 15);
		panel.add(lblNewLabel_3);
		

		
		JButton confirm = new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			
				Enumeration<AbstractButton> radioBtns=bg.getElements();
				int i=0;
				while (radioBtns.hasMoreElements()) {
					AbstractButton btn = radioBtns.nextElement();
						if(btn.isSelected()){
						//	JobNoo=btn.getText();
						//System.out.println("jobnooojianting:"+JobNoo);		
						JobNoo=(String)ddd[i][0];
						System.out.println("j::::"+JobNoo);
						break;
						}
						i++;				
				}
				/*for(int i=0;i<ddd.length;i++) {
				if(radios[i].isSelected()) {
					JobNoo=(String)ddd[i][0];
					System.out.println("j::::"+JobNoo);
					}
				}
				*/
				GuahaoNo=pghdao.pghbianhao(login.NoId);
				System.out.println("gggghao"+GuahaoNo);			
				pghdao.pghjobnodao(GuahaoNo, JobNoo);
				 JOptionPane.showMessageDialog(null, "挂号成功！挂号编号为"+GuahaoNo, "alert", JOptionPane.ERROR_MESSAGE); 
				PatientMain mm=new PatientMain();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		confirm.setBounds(229, 187, 69, 23);
		panel.add(confirm);
		
		JButton shanchu = new JButton("删除");
		shanchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pghdao.pghshanchu(login.NoId);
				 JOptionPane.showMessageDialog(null, "挂号删除成功！", "alert", JOptionPane.ERROR_MESSAGE); 
			}
		});
		shanchu.setBounds(79, 187, 93, 23);
		panel.add(shanchu);
		
		
		
	
		
	}//PatientMain
	
	
	public String getGuahaoNo() {
		GuahaoNo=pghdao.chaguahao(login.NoId, _date1);
		System.out.println("得到挂号"+GuahaoNo);
		return GuahaoNo;
	}
}
