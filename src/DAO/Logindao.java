package DAO;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
import java.sql.SQLException;

import view.Login;
public class Logindao {
	Login login=new Login(); 
	Sqlcon db=new Sqlcon();	
	PreparedStatement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public Logindao(){}
	
    public String loginselect(String pid,String pass) {
        String result = "";
    	try {
    	Connection conn= db.getSQLConnection();
    	String sql = "select * from T_Patient  where IDNo=? and  Pwd=? ";
         PreparedStatement stat = conn.prepareStatement(sql);
         stat.setString(1,pid);
        stat.setString(2, pass);
     ResultSet rs = stat.executeQuery();
     while (rs.next())
     {
         login.NoId=rs.getString("PatientNo");
         result= "1" ;
       
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
    
    
    public String loginselect2(String pid,String pass) {
        String result = "";
    	try {
    		Connection conn= db.getSQLConnection();
     String sql = "select * from T_Doctor  where IDNo=? and  Pwd=? ";
     PreparedStatement stat = conn.prepareStatement(sql);
     stat.setString(1,pid);
    stat.setString(2, pass);
    rs = stat.executeQuery();
     while (rs.next())
     {
    	 login.NoId=rs.getString("JobNo");
     result= "1" ;
   
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
