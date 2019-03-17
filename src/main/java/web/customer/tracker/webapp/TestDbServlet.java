package web.customer.tracker.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String user = "springstudent";
		String pass = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?serverTimezone=UTC";

		String driver = "com.mysql.jdbc.Driver";


		PrintWriter out = response.getWriter();

		out.println("Connection to database: "+ jdbcUrl);

		try
		{
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Connection successful");
			myConn.close();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
