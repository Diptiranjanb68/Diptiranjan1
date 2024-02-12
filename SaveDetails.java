package myProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SaveDetails 
{
	
	public static int save(AddEmpDetails e)
	{
		int status=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","2001");
			PreparedStatement ps=con.prepareStatement("insert into EmpDetails values(?,?,?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getAddress());
			ps.setString(5, e.getCity());
			ps.setString(6,e.getCountry());
			
			status=ps.executeUpdate();
			
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return status;
	}
}
