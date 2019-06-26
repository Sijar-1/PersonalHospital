package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Changepassdao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public Changepassdao() {

	}
	public void changedao(String pno,String pwd) {
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "update T_Patient set Pwd='"+pwd+"' where PatientNo='"+pno+"'";
     PreparedStatement stat = conn.prepareStatement(sql);
      stat.executeUpdate();
       rs.close();
         conn.close();
    	  } catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
             
          }
		
	}
}
