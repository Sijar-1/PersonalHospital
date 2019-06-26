package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfirmPaydao {
	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
	public ConfirmPaydao() {

	}
	public void boughtguahao(String pno) {
	
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "update T_Registration set bought=1 where PatientNo='"+pno+"' and bought=0";
     System.out.println("缴费挂号费的用户名"+pno);
     PreparedStatement stat = conn.prepareStatement(sql);
      stat.executeUpdate();
		}
     catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
          
          }
	}
	
	
	public void boughtyao(String pno) {
		
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "update T_Prescription set bought=1 from T_Prescription a, T_DiagnosisCard b"
     		+ " where PatientNo='"+pno+"' and bought=0 and a.DiagnosisNo=b.DiagnosisNo";
     PreparedStatement stat = conn.prepareStatement(sql);
      stat.executeUpdate();
		}
     catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
          
          }
	}
	
public void boughtcheck(String pno) {
		
		try {
    		Connection conn= db.getSQLConnection();
     String sql = "update T_GetExamination set bought=1 from T_GetExamination a, T_DiagnosisCard b"
     		+ " where PatientNo='"+pno+"' and bought=0 and a.DiagnosisNo=b.DiagnosisNo";
     PreparedStatement stat = conn.prepareStatement(sql);
      stat.executeUpdate();
		}
     catch (SQLException e)  {
              e.printStackTrace();
              System.out.println(e);
          
          }
	}

}
