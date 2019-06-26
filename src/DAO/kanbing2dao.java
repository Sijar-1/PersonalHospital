package DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.Kanbing2;

public class kanbing2dao {

	Sqlcon db=new Sqlcon();	
	Statement ps=null;
    Connection ct=null;
     ResultSet rs=null;
  
	public kanbing2dao() {		
	}
/*public String k2namedao(String _sss) {
		  String result = null;
	    	try {
	    		Connection conn= db.getSQLConnection();
	     String sql = "select PatientName from T_Registration a,T_Patient b "
	     		+ " where RegistrationNo=? and a.PatientNo=b.PatientNo ";
	     PreparedStatement stat = conn.prepareStatement(sql);
	     stat.setString(1,_sss);
	      rs = stat.executeQuery();
	      while (rs.next())
	      {
	    	 result=rs.getString("PatientName");   }
	         rs.close();
	         conn.close();
	    	  } catch (SQLException e)  {
	              e.printStackTrace();
	              System.out.println(e);
	              result += "查询数据异常!" + e.getMessage();
	          }
	    	return result;
	    	
	}
	
	/*public String k2sexdao(String _sss) {
		   String result = null;
    	try {
    		Connection conn= db.getSQLConnection();
     String sql = "select Sex from T_Registration a,T_Patient b "
     		+ " where RegistrationNo=? and a.PatientNo=b.PatientNo ";
     PreparedStatement stat = conn.prepareStatement(sql);
     stat.setString(1,_sss);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result=rs.getString("Sex");   }
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
	
	
	
	public String k2agedao(String _sss) {
		   String result = null;
    	try {
    		Connection conn= db.getSQLConnection();
     String sql = "select IDNo from T_Registration a,T_Patient b "
     		+ " where RegistrationNo=? and a.PatientNo=b.PatientNo ";
     PreparedStatement stat = conn.prepareStatement(sql);
     stat.setString(1,_sss);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result=rs.getString(1);   
    	System.out.println("result:"+result); 
 
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
	
public String k2age2dao(String _sss) {
	  String result = null;
	String _rr=k2agedao(_sss);
		String _rrr=_rr.substring(6,14);
		try {
		} catch (Exception ex) {

		System.out.println(ex.getMessage());

		}
    	try {
    		Connection conn= db.getSQLConnection();
        String sql = "SELECT datediff(year,'"+_rrr+"',getdate())";
     PreparedStatement stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while (rs.next())
      {
    	 result=rs.getString(1);   
    	System.out.println("result1:"+result); 
 
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

public String k2youguomindao(String _sss) {
	   String result = null;
	try {
		Connection conn= db.getSQLConnection();
String sql = "select DrugAllergy from T_Registration a,T_Patient b "
		+ " where RegistrationNo=? and a.PatientNo=b.PatientNo ";
PreparedStatement stat = conn.prepareStatement(sql);
stat.setString(1,_sss);
rs = stat.executeQuery();
while (rs.next())
{
	 result=rs.getString(1);   
	System.out.println("resultdr:"+result); 

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

public void k2guomindao(String _sss,String drugallergy) {
	 
	try {
		Connection conn= db.getSQLConnection();
String sql = "update T_Patient set DrugAllergy='"+drugallergy+"' from T_Patient a, T_Registration b"
		+ " where a.PatientNo=b.PatientNo and RegistrationNo='"+_sss+"'";
ps=conn.createStatement();
ps.executeUpdate(sql);
ps.close();
conn.close();
	  } catch (SQLException e)  {
       e.printStackTrace();
       System.out.println(e);
      }	
	}

public String k2symptomdao(String _sss,String symptom,String cause,String JobNo) {
	 String result=null;
	 int id=0;
	try {
		Connection conn= db.getSQLConnection();
String sql = "insert into T_DiagnosisCard (Symptom,Cause,JobNo,F_Date,RegistrationNo)values "
		+ "('"+symptom+"','"+cause+"','"+JobNo+"',getdate(),'"+_sss+"') Select SCOPE_IDENTITY() as '"+id+"'";
ps=conn.createStatement();
rs =ps.executeQuery(sql);
if (rs.next()) {  
    id = rs.getInt(1);  
    System.out.println ("生成记录的key5为 ：" + id);  
    result=String.valueOf(id);
} 
ps.close();
conn.close();
	  } catch (SQLException e)  {
       e.printStackTrace();
       System.out.println(e);
      }	
	return result;
	}

public void k2symptom2dao(String _sss,String symptom,String cause,String JobNo,String id) {
	 String result=null;

	try {
		Connection conn= db.getSQLConnection();
String sql = "update T_DiagnosisCard set Symptom='"+symptom+"',Cause='"+cause+"',JobNo="+JobNo+"',"
		+ "F_Date=getdate(),RegistrationNo='"+_sss+"' "
		+ " where DiagnosisNo='"+id+"'";
ps=conn.createStatement();
ps.executeUpdate(sql);
ps.close();
conn.close();
	  } catch (SQLException e)  {
      e.printStackTrace();
      System.out.println(e);
     }	

	}

public void k2causedao(String id) {
	 
	try {
		Connection conn= db.getSQLConnection();
String sql = "update T_DiagnosisCard set PatientNo=b.PatientNo from T_DiagNosisCard a, T_Registration b"
		+ " where a.RegistrationNo=b.RegistrationNo and DiagnosisNo='"+id+"'";
ps=conn.createStatement();
ps.executeUpdate(sql);
ps.close();
conn.close();
	  } catch (SQLException e)  {
       e.printStackTrace();
       System.out.println(e);
      }	
	}

public void k2yikandao(String _sss) {
	 
	try {
		Connection conn= db.getSQLConnection();
String sql = "update T_Registration set _Delete=1  where RegistrationNo='"+_sss+"'";
System.out.println("看完病后医生删一删此病人号"+_sss);
ps=conn.createStatement();
ps.executeUpdate(sql);
ps.close();
conn.close();
	  } catch (SQLException e)  {
       e.printStackTrace();
       System.out.println(e);
      }	
	}
*/

public Object[][] k2checkdao() {
	Object body[][]=new Object[9][3];//检查

	   for(int x=0;x<body.length;x++){
           body[x][0]=3;
           body[x][1]=null;
           body[x][2]=null;
       }
       int i=0;
	try {
		Connection conn= db.getSQLConnection();
String sql = "select * from T_Examination";
ps=conn.createStatement();
rs=ps.executeQuery(sql);
while (rs.next())
{
	 body[i][0]=rs.getString("ExaminationNo");
     body[i][1]=rs.getString("ExaminationName");
     i++;
}
rs.close();
conn.close();
	  } catch (SQLException e)  {
    e.printStackTrace();
    System.out.println(e);
   
}
	return body;
	}



public Object[][] k2medicinedao() {
	Object body[][]=new Object[100][3];//检查
	   for(int x=0;x<body.length;x++){
           body[x][0]=3;
           body[x][1]=null;
           body[x][2]=null;
       }
       int i=0;
	try {
		Connection conn= db.getSQLConnection();
     String sql = "select MedicineNo,MedicineName,Inventory from T_Medicine";
     ps=conn.createStatement();
     rs=ps.executeQuery(sql);
    while (rs.next())
    {
	 body[i][0]=rs.getString(1);
     body[i][1]=rs.getString(2);
     body[i][2]=rs.getString(3);
     i++;
     }
     rs.close();
    conn.close();
	  } catch (SQLException e)  {
    e.printStackTrace();
    System.out.println(e);
	  }
	return body;
	}

public void k2addcheckdao(String id,String en) {
	 String result=null;

	try {
		Connection conn= db.getSQLConnection();
		 String sql = "select EINo  from T_ExaminationItem where ExaminationNo='"+en+"'";
	     ps=conn.createStatement();
	     rs=ps.executeQuery(sql);
	    while (rs.next())
	    {
     k2addcheck1dao(id,rs.getString(1));
     System.out.println("eino:"+rs.getString(1));
	     }
	     rs.close();
	    conn.close();
	  } catch (SQLException e)  {
      e.printStackTrace();
      System.out.println(e);
      }
	}

public void k2addcheck1dao(String id,String ei) {
	 String result=null;

	try {
		Connection conn= db.getSQLConnection();
      String sql = "insert into T_GetExamination (DiagnosisNo,EINo)values ('"+id+"','"+ei+"') ";
       ps=conn.createStatement();
       ps.executeUpdate(sql);
       ps.close();
       conn.close();
	  } catch (SQLException e)  {
     e.printStackTrace();
     System.out.println(e);
     }
	}

public void k2kucundao(String yao,String liang) {
	 String result=null;

	try {
		Connection conn= db.getSQLConnection();
    String sql = "update ";
     ps=conn.createStatement();
     ps.executeUpdate(sql);
     ps.close();
     conn.close();
	  } catch (SQLException e)  {
   e.printStackTrace();
   System.out.println(e);
   }
	}

public void k2addyaodao(String id,String yao,String liang) {
	 String result=null;

	try {
		Connection conn= db.getSQLConnection();
     String sql = "insert into T_Prescription (DiagnosisNo,MedicineNo,quantity)values ('"+id+"','"+yao+"','"+liang+"') ";
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
