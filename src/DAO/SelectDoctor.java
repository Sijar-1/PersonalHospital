package DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectDoctor {
	
	Object body[][]=new Object[100][9];//科室
	private Connection conn;
	Statement st;
	ResultSet rs;
	String sql;
	
	public SelectDoctor(String sql) {
	
		this.sql=sql;
		
		Sqlcon mycon=new Sqlcon();
		conn=mycon.getSQLConnection();
		select();
		/*for(int i=0;i<body.length;i++) {
			for(int j=0;j<3;j++)
				System.out.print(body[i][j]+" ");
			System.out.println();
		}*/
	}
	
	//数据库查找
	private void select() {
			// TODO Auto-generated method stub
	        //String str = "select * from T_Department";
	        filltable(sql);
		}
	
	private void filltable(String str) {
		        // TODO Auto-generated method stub
		        try {
		            for(int x=0;x<body.length;x++)
		                for(int y=0;y<9;y++) {
		                	body[x][y]=null;
		                }
		                	
		            
		            int i=0;
		           // System.out.println("aaaaaa");
		            //Statement st=conn.prepareStatement(str);
		            st=conn.createStatement();
		            rs=st.executeQuery(str);
		            //System.out.println("bbbbbbb");
		            while(rs.next()){
		                body[i][0]=rs.getString("JobNo");
		                body[i][1]=rs.getString("DoctorName");
		                body[i][2]=rs.getString("IDNo");
		                body[i][3]=rs.getString("Sex");
		                body[i][4]=rs.getString("Address");
		                body[i][5]=rs.getString("Tel");
		                body[i][6]=rs.getString("DepartmentNo");
		                body[i][7]=rs.getString("ExaminationNo");
		                body[i][8]=rs.getString("Pwd");
		                i=i+1;
		            }
		            //this.repaint(i);
		        } catch (Exception ex) {
		            // TODO: handle exception
		            ex.printStackTrace();
		        }
		    }//filltable
	
	public Object[][] GetBody(){
		return body;
	}

}