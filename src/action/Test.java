package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet
{

	String url = "rm-m5ew6qe9z65b54kq9qo.mysql.rds.aliyuncs.com:3306";
	String user = "Public";
	String password = "Public0011";
	String driver = "com.mysql.jdbc.Driver";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
