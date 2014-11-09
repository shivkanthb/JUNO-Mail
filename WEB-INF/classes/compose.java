import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class compose extends HttpServlet 
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
		
		//String from=request.getParameter("newSender");
		String to = request.getParameter("newReceiver");
		String sub = request.getParameter("newSubject");
		String msg = request.getParameter("newMessage");
		
		String sender_name="";
	 String sender="";
	 String pwd="";
		String z="";
		
		
		
		
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
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailapp","root","");
			
			System.out.println("Connection Established");
			}
		catch(SQLException E)
		{
			System.out.println("Connection not Established");
		}
		
		 try
	 {
	 String sql1="select * from userdetails where usid='"+session.getAttribute("username")+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql1);
				while(rs.next())
				{
				    sender_name=rs.getString(3);
					
					pwd=rs.getString(4);
					sender=rs.getString(1);
					pw.println(sender);
				}
	 }
	  catch(SQLException e)
	 {
	 System.out.println(e.getMessage());
	 }
		
		try{
		int val=0;
		String query="select count(*) from compose";
		pstmt=con.prepareStatement(query);
		 rs=pstmt.executeQuery();
	 rs.next();
	 z= rs.getString(1);
	 val=Integer.parseInt(z);
     
		System.out.println(val);
		
		}
		catch(SQLException e)
		{ } 
		
		
		
		
		try{
			String sql="insert into compose values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,sender);
			//pstmt.setString(2,from);
			pstmt.setString(2,to);
			pstmt.setString(3,sub);
			pstmt.setString(4,msg);
			pstmt.setString(5,z);
			
			int i=pstmt.executeUpdate(); 
			if(i!=0)
	  {
	   pw.println("<html>");
	  pw.println(
				"<head> \n"+
				"<script type=\"text/javascript\" src=\"main.js\"> \n"+
				
				"</script> \n"
				);
	  pw.println("<body>");
	  pw.println("</body></html>");
	  }
			
			}catch(SQLException e)
			{System.out.println(e.getMessage());}
		
		
		response.sendRedirect("http://localhost:8080/juno/main.html");
	}
}