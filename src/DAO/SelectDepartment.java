package DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectDepartment {
	
	Object body[][]=new Object[24][3];//科室
	private Connection conn;
	Statement st;
	ResultSet rs;
	String sql;
	
	public SelectDepartment(String sql) {
	
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
		            for(int x=0;x<body.length;x++){
		                body[x][0]=3;
		                body[x][1]=null;
		                body[x][2]=null;
		            }
		            int i=0;
		           // System.out.println("aaaaaa");
		            //Statement st=conn.prepareStatement(str);
		            st=conn.createStatement();
		            rs=st.executeQuery(str);
		            //System.out.println("bbbbbbb");
		            while(rs.next()){
		                body[i][0]=rs.getString("DepartmentNo");
		                body[i][1]=rs.getString("DepartmentName");
		                body[i][2]=rs.getString("Office");
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
