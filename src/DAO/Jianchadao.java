package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jianchadao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public Jianchadao() {
	}
	public String getjianchadao(String pno) {
		String result="";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select distinct ExaminationName from View_checkcost  where PatientNo='"+pno+"' and bought=0";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result+=rs.getString("ExaminationName")+";";  
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
	
	
	public String jianchashidao(String pno) {
		String result="";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select distinct Office from View_checkcost  where PatientNo='"+pno+"' and bought=0";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result+=rs.getString("Office")+";";  
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
	
	
	public String jianchacostdao(String pno) {
		String result="";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select distinct sum(Cost) sumcost from View_checkcost  where "
     		+ "PatientNo='"+pno+"' and bought=0 group by PatientNo";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result=rs.getString("sumcost");  
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
