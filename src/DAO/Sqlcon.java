package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
public class Sqlcon {
	
	String dbURL = "jdbc:jtds:sqlserver://localhost:1433; DatabaseName=HospitalDB"; //连接服务器和数据库
    String userName = "sa"; //默认用户名
     String userPwd = "123456"; //密码

		public Sqlcon() {}
	public Connection getSQLConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
	    try
	    {
	    	Class.forName("net.sourceforge.jtds.jdbc.Driver");
	        System.out.println("数据库驱动加载成功");
	        con=DriverManager.getConnection(dbURL,userName,userPwd);
	        System.out.println("数据库连接成功");
	     } catch (Exception e)
	     {
	        e.printStackTrace();
	        System.out.println(e);
	      }
	    return con;

	}

}
