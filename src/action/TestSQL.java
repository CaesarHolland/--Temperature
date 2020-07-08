package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSQL
{
	static String url = "jdbc:mysql://rm-m5ew6qe9z65b54kq9qo.mysql.rds.aliyuncs.com:3306/db01";
	static String user = "public";
	static String password = "Public0011";
	static String driver = "com.mysql.jdbc.Driver";

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement("select * from test");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String val = rs.getString(2);
				System.out.print(val + "\n");
			}
			System.out.print("success");

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
