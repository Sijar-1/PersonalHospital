package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatienGuahaodao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public PatienGuahaodao() {
	}
	
	public String chaguahao(String NoId,String date) {
		String result=null;
		 System.out.println("chaguahaoid:::"+NoId);
		 System.out.println("chaguahadate:::"+date);
		try {
    		Connection conn= db.getSQLConnection();
     String sql ="select top 1 RegistrationNo from T_Registration  where PatientNo='"+NoId+"' "
     		+ " and bought=1 and _Delete=0";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result=rs.getString("RegistrationNo");  
    	 System.out.println("chaguahao:::.................."+result);
    	 }
         rs.close();
         conn.close();
    	  } catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
           //   result += "查询数据异常!" + e.getMessage();
          }
		return result;
	}
	
	public String pghghuahao(String NoId) {
		String result=null;
		int id=0;
	    	try {
	    		Connection conn= db.getSQLConnection();
	     String sql = "insert into T_Registration (PatientNo,Date) values ('"+NoId+"',getdate()) Select SCOPE_IDENTITY() as '"+id+"'";
	     ps=conn.createStatement();
	     rs =ps.executeQuery(sql);
	     if (rs.next()) {  
	         id = rs.getInt(1);  
	         System.out.println ("key为 ：" + id);  
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
	
	
	public String pghbianhao(String NoId) {
		String result=null;
		int id=0;
	    	try {
	    		Connection conn= db.getSQLConnection();
	     String sql = "insert into T_Registration (PatientNo,Date,Time) values ('"+NoId+"',getdate(),getdate()) Select SCOPE_IDENTITY() as '"+id+"'";
	     ps=conn.createStatement();
	     rs =ps.executeQuery(sql);
	     if (rs.next()) {  
	         id = rs.getInt(1);  
	         System.out.println ("key为 ：" + id);  
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
	
	public void pghjobnodao(String id,String jobNo) {
		 
		try {
			Connection conn= db.getSQLConnection();
	String sql = "update T_Registration  set JobNo='"+jobNo+"'where RegistrationNo='"+id+"'";
	ps=conn.createStatement();
	ps.executeUpdate(sql);
	ps.close();
	conn.close();
		  } catch (SQLException e)  {
	       e.printStackTrace();
	       System.out.println(e);
	      }	
		}
	
	
	
	public void pghshanchu(String NoId) {

	
	    	try {
	    		Connection conn= db.getSQLConnection();
	    		System.out.println("删除"+NoId);
	     String sql = "delete from T_Registration  where PatientNo='"+NoId+"' and bought=0";
	   // ps.executeUpdate(sql);
	     ps=conn.createStatement();
	 	ps.executeUpdate(sql);
	     ps.close();
	     conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	           
	          }
		
	}

}
