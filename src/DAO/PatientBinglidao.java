package DAO;

import java.sql.Connection;
import java.sql.*;

public class PatientBinglidao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public PatientBinglidao() {}
	public String pblname(String noId) {
		// TODO Auto-generated method stub
		String result=null;
		try {
			Connection conn= db.getSQLConnection();
		String sql = "select PatientName from T_Patient where PatientNo='"+noId+"'";
		PreparedStatement stat = conn.prepareStatement(sql);
		
		rs = stat.executeQuery();
		while (rs.next())
		{
			 result=rs.getString(1);   
		}
		  rs.close();
		  conn.close();
			  } catch (SQLException e)  {
		       e.printStackTrace();
		       System.out.println(e);
		       result += "查询数据异常!" + e.getMessage();
		   }
		
		return result;
	}
	
	public String pblsex(String noId) {
		// TODO Auto-generated method stub
		String result=null;
		try {
			Connection conn= db.getSQLConnection();
		String sql = "select Sex from T_Patient where PatientNo='"+noId+"'";
		PreparedStatement stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
		while (rs.next())
		{
			 result=rs.getString(1);   
		}
		  rs.close();
		  conn.close();
			  } catch (SQLException e)  {
		       e.printStackTrace();
		       System.out.println(e);
		       result += "查询数据异常!" + e.getMessage();
		   }
		if(result.equals("F"))
			result="女";
		else
			result="男";
		return result;
	}
	
	public String pblguomin(String noId) {
		// TODO Auto-generated method stub
		String result=null;
		try {
			Connection conn= db.getSQLConnection();
		String sql = "select DrugAllergy from T_Patient where PatientNo='"+noId+"'";
		PreparedStatement stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
		while (rs.next())
		{
			 result=rs.getString(1);   
		}
		  rs.close();
		  conn.close();
			  } catch (SQLException e)  {
		       e.printStackTrace();
		       System.out.println(e);
		       result += "查询数据异常!" + e.getMessage();
		   }
		return result;
	}
}
