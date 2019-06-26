package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import DAO.Kanbingdao;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.event.ActionEvent;

public class Kanbing extends JFrame {
    Login login=new Login();
	private JPanel contentPane;
    Kanbingdao kdao=new Kanbingdao();
    static String[] s1= new String[15];
	String _date;
	public static String sss;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kanbing frame = new Kanbing();
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
	public Kanbing() {
		setTitle("挂号病人");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("请选择挂号患者：");
		lblNewLabel.setBounds(57, 10, 118, 27);
		contentPane.add(lblNewLabel);
		
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
	//	int hour = c.get(Calendar.HOUR);
		//int minite= c.get(Calendar.MINUTE);		
		System.out.println("lgoin.NoId:"+login.NoId);
		_date=String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(date);
		System.out.println(_date);
		
		int guahaoshu=kdao.kanbingselect(s1,login.NoId,_date); 
		DefaultListModel dlm = new DefaultListModel();
		for(int i=0;i<guahaoshu;i++)
		{
			System.out.println(s1[i]);
			  dlm.addElement(s1[i]);
		}

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 47, 210, 111);
        contentPane.add(scrollPane);
	    
        //model = new DataModel(); //创建DataModel对象
        JList listpatient = new JList();
        scrollPane.setViewportView(listpatient);
        // 允许可间断的多选
        listpatient.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);      
        // 设置选项数据（内部将自动封装成 ListModel ）
        listpatient.setModel(dlm);
        //listpatient.setBackground(Color.GRAY);
      //  listpatient.setBorder(BorderFactory.createTitledBorder("请选择一种你喜欢的颜色")); //设置列表框标题
        listpatient.addMouseListener(new MouseAdapter() //列表框添加鼠标事件
        {
            public void mousePressed(MouseEvent e) 
            {
              //  int i = listpatient.getSelectedIndex() + 1;
             
System.out.println(listpatient.getSelectedValue());
            }
        });

        
        
        JButton btnNewButton = new JButton("确认");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sss=listpatient.getSelectedValue().toString();      		
        		Kanbing2 kk=new Kanbing2();
        		kk.setVisible(true);
        		setVisible(false);
        	}
        });
        btnNewButton.setBounds(292, 196, 93, 23);
        contentPane.add(btnNewButton);
	}
}
