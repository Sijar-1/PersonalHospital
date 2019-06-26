package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Quyaodao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public  Quyaodao() {
	}
	public String yaoname(String pno) {
		String result="";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select MedicineName from View_medicinecard  where PatientNo='"+pno+"' and bought=0";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result+=rs.getString("MedicineName")+"\n";  
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
	
	
	public String yaocost(String pno) {
		String result="";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select sum(Price*quantity) sumcost,PatientNo from View_medicinecard  "
     		+ "where  bought=0 and PatientNo='"+pno+"' group by PatientNo";
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
