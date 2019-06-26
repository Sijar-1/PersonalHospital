package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.Sign1;
public class Signdao {
	private static final String Statment = null;
	Sqlcon db=new Sqlcon();	
	java.sql.Statement ps=null;  
	private ResultSet rs;
	Sign1 ss1=new Sign1();
	public Signdao() {		
	}
	public String Signinsertp(String name,String ID,String sex,String pwd,String phone) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			int id=0;
			Connection conn= db.getSQLConnection();
	    	String sql = "insert into T_Patient (PatientName,IDNo,sex,Pwd,Tel) values ('"+name+"','"+ID+"','"+sex+"','"+pwd+"','"+phone+"') Select SCOPE_IDENTITY() as '"+id+"'";
	    	ps=conn.createStatement();
	        rs =ps.executeQuery(sql);
	        if (rs.next()) {  
                id = rs.getInt(1);  
                System.out.println ("生成记录的key为 ：" + id);  
                result=String.valueOf(id);
            } 
	     conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	              result += "查询数据异常!" + e.getMessage();
	          }       
		return result;
	}
	
	public String Signinsertd(String name,String ID,String sex,String pwd,String phone) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			int id=0;
			Connection conn= db.getSQLConnection();
	    	String sql = "insert into T_Doctor (DoctorName,IDNo,Sex,Pwd,Tel) values ('"+name+"','"+ID+"','"+sex+"','"+pwd+"','"+phone+"') Select SCOPE_IDENTITY() as '"+id+"'";
	    	ps=conn.createStatement();
	        rs =ps.executeQuery(sql);
	        if (rs.next()) {  
                id = rs.getInt(1);  
                System.out.println ("生成记录的key2为 ：" + id);  
                result=String.valueOf(id);
            } 
	        ps.close();
	     conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	              result += "查询数据异常!" + e.getMessage();
	          }
	        return result;
	}
	
	public void Signinserta(String s1) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			System.out.println(s1);
			Connection conn= db.getSQLConnection();
	    	String sql = "update T_Patient set Address='"+s1+"' where PatientNo='"+ss1.No+"'";
	    	ps=conn.createStatement();
	        ps.executeUpdate(sql);
	        ps.close();
	     conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	              result += "查询数据异常!" + e.getMessage();
	          }
	        
	}
	
	public void Signinsertad(String s1) {
		// TODO Auto-generated method stub
		String result = "";
		try {
		
			Connection conn= db.getSQLConnection();
	    	String sql = "update T_Doctor set Address='"+s1+"' where JobNo='"+ss1.No+"'";
	    	ps=conn.createStatement();
	        ps.executeUpdate(sql);
	        ps.close();
	     conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	              result += "查询数据异常!" + e.getMessage();
	          }
	        
	}
	
	public void Signinsertd2(int Department ) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			Connection conn= db.getSQLConnection();
	    	String sql = "update T_Doctor set DepartmentNo ='"+Department+"' where JobNo='"+ss1.No+"'";
	    	ps=conn.createStatement();
	        ps.executeUpdate(sql);
	        ps.close();
	     conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	              result += "查询数据异常!" + e.getMessage();
	          }
	        
	}
}
