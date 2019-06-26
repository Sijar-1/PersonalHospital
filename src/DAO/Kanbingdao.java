package DAO;

import java.sql.*;
public class Kanbingdao {
	private Sqlcon db=new Sqlcon();	
	private java.sql.Statement ps=null; 
	private ResultSet rs;
	public Kanbingdao() {}
	public int kanbingselect(String[] s1,String jobNo,String date) {
		String rno,pname,psex;
		int i=0;
		try {
			System.out.println(date+"医生挂号日期");
			Connection conn= db.getSQLConnection();
			String sql = "select RegistrationNo,PatientName,Sex from T_Registration a,T_Patient b "
					+ "where a.PatientNo=b.PatientNo and JobNo='"+jobNo+"' and _Delete=0 and bought=1";
			/*String sql = "select RegistrationNo,PatientName,Sex from T_Registration a,T_Patient b "
					+ "where a.PatientNo=b.PatientNo and JobNo='"+jobNo+"' and Date='"+date+"' and _Delete=0 and bought=1";
*/    	   
PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();      
            while (rs.next())
            {
            	s1[i]="";
            	s1[i]+=rs.getString("RegistrationNo");
    	        s1[i]+="    ";
                s1[i]+=rs.getString("PatientName");
                s1[i]+="  ";
                s1[i]+=rs.getString("Sex");
                System.out.println("aaa"+s1[i]);
                i++;
            }
            rs.close();
            conn.close();
            } catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
              }       
		return i;
	}
}
