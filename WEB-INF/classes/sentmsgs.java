import java.sql.*;
import java.io.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sentmsgs extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
	    HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		//String uname = request.getParameter("user");
		//String pass = request.getParameter("pass");	
		int flag=0;
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
		     String sql="select * from compose where sender='"+session.getAttribute("username")+"'";
		     pstmt=con.prepareStatement(sql);
			 //pstmt.setString(1,
			 rs=pstmt.executeQuery();
			 while(rs.next())
			 {
	          	 
             pw.println("<h3><b>From:</b></h3>");
			 pw.println(rs.getString(1));pw.println("<br>");
			 pw.println("<h3><b>To:</b></h3>");
			 pw.println(rs.getString(2));pw.println("<br>");
			 pw.println("<h3><b>Subject:</b></h3>");
			 pw.println(rs.getString(3));pw.println("<br>");
			 pw.println("<h3><b>Msg:</b></h3>");
			 pw.println(rs.getString(4));pw.println("<br>");
			 }
			 }
			 
		
			/*if(uname != "" && pass != "")
			{
				String sql="select * from userlogin where usid='"+uname+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					if(rs.getString(2).equals(pass))
						flag=1;
				}
			}
			else
				flag=2;			
			if(uname.equals("Admin") && pass.equals("admin"))
				flag=3;
			pw.println("<script type=\"text/javascript\">");
			if(flag==0)
				pw.println("alert(\"Invalid username/password...Please try again!!!\")");
			else if(flag==1)
			{
			   
				pw.println("alert(\"Welcome to juno!!!\")");	
				pw.println("location='http://localhost:8084/juno/main.html'");
			}
			else if(flag==2)
				pw.println("alert(\"Username/password fields cannot be empty!!!\")");
			else
				pw.println("location='http://localhost:8084/juno/admin.html'");
			if(flag==0 || flag==2)
				pw.println("location='http://localhost:8084/juno/frame.html'");
			pw.println("</script>");
		}*/
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}
