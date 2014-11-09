import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class register extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		String yname = request.getParameter("name");
		String umail = request.getParameter("email");
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");	
		String rpass = request.getParameter("rpass");
		
		
		
		
		
		
		try{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Driver Loaded");
			}
		catch(ClassNotFoundException E)
		{
			System.out.println("Driver not Loaded");
		}
		try{
			//con=DriverManager.getConnection("jdbc:odbc:college","system","ashkak");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailapp","root","");
			
			System.out.println("Connection Established");
			}
		catch(SQLException E)
		{
			System.out.println("Connection not Established");
		}
		
		try{
			String sql="insert into userlogin values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.setString(2,pass);
			
			pstmt.executeUpdate();
			}catch(SQLException e)
			{System.out.println(e.getMessage());}
		
		try
		{
			
			String sql="insert into userdetails(uname,email,usid,pass,rpass) values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,yname);
			pstmt.setString(2,umail);
			pstmt.setString(3,uname);
			pstmt.setString(4,pass);
			pstmt.setString(5,rpass);
			
			pstmt.executeUpdate();
			}catch(SQLException e)
			{System.out.println(e.getMessage());}
			
			
			/*try
			{
			
			String sql="insert into compose(usid) values(?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,uname);
			pstmt.executeUpdate();
			}catch(SQLException e)
			{System.out.println(e.getMessage());*/
			
			
			
			
			
			
			
			
			
			
			
		response.sendRedirect("http://localhost:8080/juno/frame.html");
	}
}
