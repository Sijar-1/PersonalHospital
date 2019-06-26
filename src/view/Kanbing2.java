package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.SelectDepartment;
import DAO.kanbing2dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kanbing2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldzhengzhuang;
	private JTextField textField_bingyin;
	Kanbing kanbing=new Kanbing();
	kanbing2dao k2dao=new kanbing2dao();
	Login login=new Login();
	private JTextField textFieldguomin;
	public static String _sss;
	private JTextField textFieldyaoliang1;
	private JTextField textFieldyaoliang2;
	private JTextField textFieldyaoliang3;
	private int liang1,liang2,liang3;
	private int flag=0;  //判断是不是第一次点确认按钮提交
	private String id;//新建的病例号
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kanbing2 frame = new Kanbing2();
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
	public Kanbing2() {
		setTitle("诊断");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("挂号编号：");
		label.setBounds(28, 12, 66, 22);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("患者姓名：");
		label_1.setBounds(28, 44, 66, 22);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("患者性别：");
		label_2.setBounds(211, 46, 66, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("患者年龄：");
		label_3.setBounds(28, 76, 66, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("过敏药物：");
		label_4.setBounds(211, 73, 66, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("患者症状：");
		label_5.setBounds(28, 108, 66, 22);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("诊断病因：");
		label_6.setBounds(28, 155, 66, 22);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("是否检查：");
		label_7.setBounds(28, 203, 66, 22);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("处方药品：");
		label_8.setBounds(28, 229, 66, 22);
		contentPane.add(label_8);
		
		JButton past = new JButton("既往病史");
		past.setBounds(119, 353, 93, 23);
		contentPane.add(past);
		
		JLabel guahaobianhao = new JLabel("New label");
		//if(kanbing.sss.indexOf(" ")!=-1) {
		//	_sss=kanbing.sss.substring(0,kanbing.sss.indexOf(" "));
		//}
		//System.out.println("_sss"+_sss);
		guahaobianhao.setText("124");		
		guahaobianhao.setBounds(96, 12, 116, 22);
		contentPane.add(guahaobianhao);
		
		
		
		textFieldguomin = new JTextField();
		textFieldguomin.setBounds(275, 70, 127, 29);
		textFieldguomin.setColumns(10);
		//textFieldguomin.setText(k2dao.k2youguomindao(_sss));
		contentPane.add(textFieldguomin);
		
		
		textFieldzhengzhuang = new JTextField();
		textFieldzhengzhuang.setBounds(97, 103, 317, 47);
		
		contentPane.add(textFieldzhengzhuang);
		textFieldzhengzhuang.setColumns(10);
		
		textField_bingyin = new JTextField();
		textField_bingyin.setColumns(10);
		textField_bingyin.setBounds(97, 158, 317, 43);
		contentPane.add(textField_bingyin);
		
		//检查下拉框
		Object[][] b=k2dao.k2checkdao();
		String c[]=new String[b.length];
		String e[]=new String[b.length];
		//名字
		for(int j=0;j<b.length;j++) {
			c[j]=String.valueOf(b[j][1]);
		}
		//编号
		for(int j=0;j<b.length;j++) {
			e[j]=String.valueOf(b[j][0]);
		}
		JComboBox comboBoxcheck = new JComboBox(c);
		comboBoxcheck.setBounds(96, 204, 85, 20);
		contentPane.add(comboBoxcheck);
		
		//药品
		Object[][] medicine=k2dao.k2medicinedao();
		Object[][] medicine2=k2dao.k2medicinedao();
		Object[][] medicine3=k2dao.k2medicinedao();
		String c1[]=new String[medicine.length];
		String e1[]=new String[medicine.length];
		String d1[]=new String[medicine.length];
		String c2[]=new String[medicine2.length];
		String e2[]=new String[medicine2.length];
		String d2[]=new String[medicine2.length];
		String c3[]=new String[medicine3.length];
		String e3[]=new String[medicine3.length];
		String d3[]=new String[medicine3.length];
		//名字
		for(int j=0;j<medicine.length;j++) {
			c1[j]=String.valueOf(medicine[j][1]);
			c2[j]=String.valueOf(medicine2[j][1]);
			c3[j]=String.valueOf(medicine3[j][1]);
		}
		//编号
		for(int j=0;j<medicine.length;j++) {
			e1[j]=String.valueOf(medicine[j][0]);
			e2[j]=String.valueOf(medicine2[j][0]);
			e3[j]=String.valueOf(medicine3[j][0]);
		}
		//库存
		for(int j=0;j<medicine.length;j++) {
			d1[j]=String.valueOf(medicine[j][2]);
			d2[j]=String.valueOf(medicine2[j][2]);
			d3[j]=String.valueOf(medicine3[j][2]);
	    }
	
		JComboBox comboBox_yao1 = new JComboBox(c1);
		comboBox_yao1.setBounds(96, 230, 116, 20);
		contentPane.add(comboBox_yao1);
		
		JComboBox comboBox_yao2 = new JComboBox(c2);
		comboBox_yao2.setBounds(96, 268, 116, 20);
		contentPane.add(comboBox_yao2);
		
		JComboBox comboBox_yao3 = new JComboBox(c3);
		comboBox_yao3.setBounds(96, 310, 115, 20);
		contentPane.add(comboBox_yao3);
		
		
		
		JLabel LabelName = new JLabel("New label");
		//LabelName.setText(k2dao.k2namedao(_sss));
		LabelName.setText("白亭");
		LabelName.setBounds(95, 48, 106, 22);
		contentPane.add(LabelName);
		
		JLabel LabelSex = new JLabel("男");
		//LabelSex.setText(k2dao.k2sexdao(_sss));
		LabelSex.setBounds(275, 44, 127, 22);
		contentPane.add(LabelSex);
		
		JLabel LabelAge = new JLabel("New label");
		//LabelAge.setText(k2dao.k2age2dao(_sss));
		LabelAge.setText("38");
		LabelAge.setBounds(96, 76, 81, 22);
		contentPane.add(LabelAge);
		
		textFieldyaoliang1 = new JTextField();
		textFieldyaoliang1.setBounds(312, 230, 66, 21);
		
		contentPane.add(textFieldyaoliang1);
		textFieldyaoliang1.setColumns(10);
		
		textFieldyaoliang2 = new JTextField();
		textFieldyaoliang2.setColumns(10);
	
		textFieldyaoliang2.setBounds(312, 268, 66, 21);
		contentPane.add(textFieldyaoliang2);
		
		textFieldyaoliang3 = new JTextField();
		textFieldyaoliang3.setColumns(10);
		
		textFieldyaoliang3.setBounds(312, 310, 66, 21);
		contentPane.add(textFieldyaoliang3);
		
		JLabel label_9 = new JLabel("数量：");
		label_9.setBounds(275, 233, 54, 15);
		contentPane.add(label_9);
		
		JButton tijiao = new JButton("确认提交");
		tijiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1,s2,s3;
				s1=textFieldyaoliang1.getText();
				s2=textFieldyaoliang2.getText();
				s3=textFieldyaoliang3.getText();
				System.out.println("shuliang1:"+s1);
				liang1=Integer.parseInt(s1.trim());
				liang2=Integer.parseInt(s2.trim());
				liang3=Integer.parseInt(s3.trim());
				if(flag==0) {
					  flag=1;
				//k2dao.k2guomindao(_sss, textFieldguomin.getText());
				//id为新建的病历编号
			   // id=k2dao.k2symptomdao(_sss, textFieldzhengzhuang.getText(),
						//textField_bingyin.getText(),login.NoId);
				//k2dao.k2causedao(id);
				
				
				String check=String.valueOf(comboBoxcheck.getSelectedItem());
				String yao1=String.valueOf(comboBox_yao1.getSelectedItem());
				String yao2=String.valueOf(comboBox_yao2.getSelectedItem());
				String yao3=String.valueOf(comboBox_yao3.getSelectedItem());
				int k=0;
				//添加检查元素
				for(;k<c.length;k++) {
					if(check.equals(c[k]))break;
					continue;
				}
				k2dao.k2addcheckdao(id, e[k]);
				//判断药品库存
				int k1=0; int k2=0; int k3=0;
				for(;k1<c1.length;k1++) {
					if(yao1.equals(c1[k1]))break;
					continue;
				}
				if(Integer.parseInt(d1[k1])<liang1) {
					//库存不足
					JOptionPane.showMessageDialog(null, c1[k1]+"库存不足！", "alert", JOptionPane.ERROR_MESSAGE); 
					  flag=1;
				}
				for(;k2<c2.length;k2++) {
					if(yao2.equals(c2[k2]))break;
					continue;
				}
				if(Integer.parseInt(d2[k2])<liang2) {
					//库存不足
					JOptionPane.showMessageDialog(null, c2[k2]+"库存不足！", "alert", JOptionPane.ERROR_MESSAGE); 
					  flag=1;
				}
				for(;k3<c3.length;k3++) {
					if(yao3.equals(c3[k3]))break;
					continue;
				}
				if(Integer.parseInt(d3[k3])<liang3) {
					//库存不足
					JOptionPane.showMessageDialog(null, c3[k3]+"库存不足！", "alert", JOptionPane.ERROR_MESSAGE); 
					  flag=1;
				}
				if(Integer.parseInt(d1[k1])>=liang1&&Integer.parseInt(d2[k2])>=liang2&&Integer.parseInt(d3[k3])>=liang3)
				{
					k2dao.k2addyaodao(id, e1[k1], textFieldyaoliang1.getText());
					k2dao.k2addyaodao(id, e2[k2], textFieldyaoliang2.getText());
					k2dao.k2addyaodao(id, e3[k3], textFieldyaoliang3.getText());
					
					//k2dao.k2yikandao(_sss);
					 Kanbing kan=new Kanbing();
				      kan.setVisible(true);
				      setVisible(false);	
				}
				
				
			    
			     }else {	 
			 		//k2dao.k2guomindao(_sss, textFieldguomin.getText());
					//id为新建的病历编号
				   // k2dao.k2symptom2dao(_sss, textFieldzhengzhuang.getText(),
							//textField_bingyin.getText(),login.NoId,id);
					//k2dao.k2causedao(id);
					
					
					String check=String.valueOf(comboBoxcheck.getSelectedItem());
					String yao1=String.valueOf(comboBox_yao1.getSelectedItem());
					String yao2=String.valueOf(comboBox_yao2.getSelectedItem());
					String yao3=String.valueOf(comboBox_yao3.getSelectedItem());
					int k=0;
					//添加检查元素
					for(;k<c.length;k++) {
						if(check.equals(c[k]))break;
						continue;
					}
					k2dao.k2addcheckdao(id, e[k]);
					//判断药品库存
					int k1=0; int k2=0; int k3=0;
					for(;k1<c1.length;k1++) {
						if(yao1.equals(c1[k1]))break;
						continue;
					}
					if(Integer.parseInt(d1[k1])<liang1) {
						//库存不足
						JOptionPane.showMessageDialog(null, c1[k1]+"库存不足！", "alert", JOptionPane.ERROR_MESSAGE); 
						  flag=1;
					}
					for(;k2<c2.length;k2++) {
						if(yao2.equals(c2[k2]))break;
						continue;
					}
					if(Integer.parseInt(d2[k2])<liang2) {
						//库存不足
						JOptionPane.showMessageDialog(null, c2[k2]+"库存不足！", "alert", JOptionPane.ERROR_MESSAGE); 
						  flag=1;
					}
					for(;k3<c3.length;k3++) {
						if(yao3.equals(c3[k3]))break;
						continue;
					}
					if(Integer.parseInt(d3[k3])<liang3) {
						//库存不足
						JOptionPane.showMessageDialog(null, c3[k3]+"库存不足！", "alert", JOptionPane.ERROR_MESSAGE); 
						  flag=1;
					}
					if(Integer.parseInt(d1[k1])>=liang1&&Integer.parseInt(d2[k2])>=liang2&&Integer.parseInt(d3[k3])>=liang3)
					{
						k2dao.k2addyaodao(id, e1[k1], textFieldyaoliang1.getText());
						k2dao.k2addyaodao(id, e2[k2], textFieldyaoliang2.getText());
						k2dao.k2addyaodao(id, e3[k3], textFieldyaoliang3.getText());
						//k2dao.k2yikandao(_sss);
						 Kanbing kan=new Kanbing();
					      kan.setVisible(true);
					      setVisible(false);	
					}
	  	 
			    	 
			     }
			}
		});
		tijiao.setBounds(248, 353, 93, 23);
		contentPane.add(tijiao);
	}
}
