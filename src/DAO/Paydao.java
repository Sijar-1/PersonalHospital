package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Paydao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public Paydao() {
	}
	public String guahaopay(String pno) {
		String result="0";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select sum(Cost) sumcost from T_Registration where PatientNo='"+pno+"' and bought=0";
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
	
	public String yaopay(String pno) {
		String result="0";
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
	
	
	public String yaonopay(String pno) {
		String result="0";
		String result2="0";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "select MedicineNo,quantity from View_medicinecard  "
      		+ "where  bought=1 and PatientNo='"+pno+"' ";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result=rs.getString("MedicineNo");  
    	 result2=rs.getString("quantity");  
    	 System.out.println("药品编号哟"+result+"  "+result2);
    	 yaokufangpay(result,result2);
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
	
	public void yaokufangpay(String mno,String shuliang) {
		String result="0";
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "update T_Medicine set Inventory=Inventory-'"+shuliang+"' where MedicineNo='"+mno+"'";
     ps=conn.createStatement();
     ps.executeUpdate(sql);
   ps.close();
         conn.close();
    	  } catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
           
          }
	}
	
	
	public String checkpay(String pno) {
		String result="0";
		try {
    		Connection conn= db.getSQLConnection();
     String sql =  "select distinct sum(Cost) sumcost from View_checkcost  where "
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
