import java.sql.*;
import java.io.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class inbox extends HttpServlet 
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
		int count=0;
		String id="";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			}

		catch(ClassNotFoundException E)
		{
			System.out.println("Driver not Loaded");
		}

		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailapp", "root", "");
			System.out.println("Connection Established");
			}
			
		catch(SQLException E)
		{
			System.out.println("Connection not Established");
		}
		
		try
		{
		/*
		pw.println("<html> \n"+ 
			"<head> \n"+
    "<script type=\"text/javascript\" src=\"main.js\"></script>" +
	"<script>"+
	"function showComposeBox()"+
	"{"+
    
    var appendComposeContent="<br /><br /><div id=\"newMail\"> <form action=\"comp\" name=\"compose\">    <input type=\"submit\" id=\"send1\" name=\"send1\" value=\"send\"/><br /> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" id=\"newSender\" name=\"newSender\" />                       To&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" id=\"newReceiver\" name=\"newReceiver\"/>";
    appendComposeContent+="<br /><br />Subject&nbsp&nbsp&nbsp<input type=\"text\" id=\"newSubject\" name=\"newSubject\"/>";
    appendComposeContent+="<hr /><br />Message&nbsp&nbsp&nbsp<br /><textarea id=\"newMessage\" name=\"newMessage\" rows=\"20\" cols=\"100\"></textarea></form></div>";
	       
	
    document.getElementById("mainDiv").innerHTML=appendComposeContent;
	//document.getElementById('newSender').style.display="none";
	
	}
	*/
	
	
	
	
	
	pw.println("<html> \n"+ 
			"<head> \n"+
			"<script>"+ "function display(body) { document.getElementById(\"msgbody\").innerHTML=body; document.getElementById('mbody').style.visibility = 'visible';}</script>" +
   " <link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\" />" +
   "<style> \n"+
   "#msgbody{" + "position:absolute;" + "top:300px;" + "left:900px; color:black; background-color:grey;padding:150px;border-radius:20px;opacity:0.3;} \n" +
   "#mbody{" + "visibility:'hidden';}" +
   "#content{" +
   "position:absolute;" +
   "top:200px;" +
   "left:300px;}" +

   "</style>"+
   "</head>"+
 " <body>"+
    "<div id=\"heading\">"+
     " <img src=\"juno-1.png\" id=\"title\" />"+
    "</div>"+ "<div id=\"msgbody\"></div>" +
	"<div id=\"sideBar\">"+
      "<ul id=\"actions\">"+
	"<li class=\"mailAction\" id=\"compose\" onclick=\"location.href='main.html'\">Compose Mail</li>"+
	"<li class=\"mailAction\" id=\"inbox\" onclick=\"location.href='in'\">Inbox</li>"+
	"<li class=\"mailAction\" id=\"drafts\" onclick=\"showDrafts()\">Drafts</li>"+
	"<li class=\"mailAction\" id=\"sent\" onclick=\"location.href='sent'\">Sent</li>"+
      "</ul> "+
	  
    "</div>"

	);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		        /*pw.println("<html> \n"+
				"<style>"+
				"div.one {"+
				"position:absolute;"+
				"top:500;"+
				"left:500;"+
				"}"+
				"div.two {"+
				"position:absolute;"+
				"top:200;"+
				"left:50;"+
				"}"+
				"div.three {"+
				"position:absolute;"+
				"top:30;"+
				"left:50;"+
				"}"+
				"div.four {"+
				"position:absolute;"+
				"top:60;"+
				"left:400;"+
				"}"+
				"div.five {"+
				"position:absolute;"+
				"top:70;"+
				"left:1000;"+
				"}"+
				"</style>"+
				"<body bgcolor=\"WHITE\"> \n"+
				"<div class=\"one\">"+
				"<table border=1>"
				);	*/	
				String sql="select * from compose where recepient='"+session.getAttribute("username")+"'";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				
				String dummy="";
				pw.println("<div id=\"content\">");
				pw.println("<table border=\"0\" cellspacing=\"50\"><tbody>" + "<tr><td></td>" + "<td><label><b>FROM</b></label></td>"+
				"<td><label><b>SUBJECT</b></label></td>" + "<td><label><b>BODY</b></label></td></tr>");
				while(rs.next())
				{
				count++;
				dummy=rs.getString(4);
				System.out.println("name : "+dummy);
				pw.println("<tr><td>"+
				"<input type=\"checkbox\" >"+
				"</td><td>"+
				"<label>"+rs.getString(1)+"</label>"+
				"</td><td>"+
			    "<label><b>"+rs.getString(3)+"</b></label>"+
				"</td><td>"+
				"<label><div id=\"mbody\" style=\"visibility:'visible'\">"+rs.getString(4)+"</div></label>"+ "</td><td>" + "<input type=\"button\" value=\"expand\" onclick=\"display('"+dummy+"')\"></input>" +
				"</td></tr>"
				);
			
				/*pw.println(
				"<a href='http://localhost:8080/pradeep/read?id="+ String.valueOf(rs.getString(1))+"'" + "target='_parent' >"+"Read more"+"</a>"+
				"</td></tr>"
				);*/
				}
				pw.println("</tbody></table>");
				pw.println("</div>");
				//pw.println(rs.getString(1) + " " + rs.getString(2));	
				/*pw.println(
				"</table>"+
				"</div>"+
				"<div class=\"two\">"+
				"<table>"+
				"<tr><td>"+
				"<form action='http://localhost:8080/pradeep/compose.html'> \n"+
				"<input type=\"image\" src=\"http://localhost:8080/pradeep/icons/compose.jpg\" width='100' height='70'>"+
				"</form>"+
				"</td>"+
				"<td>"+
				"<form action='http://localhost:8080/pradeep/compose.html'> \n"+
				"<input type=\"submit\" style=\"font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: white; border: 3pt ridge lightgrey\" value=\" Compose \">"+
				"</form>"+
				"</td></tr>"+
				"<tr><td>"+
				"<form action='null3'> \n"+
				"<input type=\"image\" src=\"http://localhost:8080/pradeep/icons/inbox.jpg\" width='100' height='70'>"+
				"</form>"+
				"</td>"+
				"<td>"+
				"<form action='null3'> \n"+
				"<input type=\"submit\" style=\"font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: white; border: 3pt ridge lightgrey\" value=\" Inbox \">"+"("+count+")"+
				"</form>"+
				"</td></tr>"+
				"<tr><td>"+
				"<form action='null4'> \n"+
				"<input type=\"image\" src=\"http://localhost:8080/pradeep/icons/send.jpg\" width='100' height='70'>"+
				"</form>"+
				"</td>"+
				"<td>"+
				"<form action='null4'> \n"+
				"<input type=\"submit\" style=\"font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: white; border: 3pt ridge lightgrey\" value=\" Sent mails \">"+
                "</form>"+
				"</td></tr>"+
				"<tr><td>"+
				"<form action='http://localhost:8080/pradeep/starred-mail.html'> \n"+
				"<input type=\"image\" src=\"http://localhost:8080/pradeep/icons/star.jpg\" width='100' height='70'>"+
				"</form>"+
				"</td>"+
				"<td>"+
				"<form action='http://localhost:8080/pradeep/starred-mail.html'> \n"+
			    "<input type=\"submit\" style=\"font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: white; border: 3pt ridge lightgrey\" value=\" Starred \">"+
				"</form>"+
				"</td></tr>"+
				"<tr><td>"+
				"<form action='http://localhost:8080/pradeep/trash-mail.html'> \n"+
				"<input type=\"image\" src=\"http://localhost:8080/pradeep/icons/trashbag.jpg\" width='100' height='70'>"+
				"</form>"+
				"</td>"+
				"<td>"+
				"<form action='http://localhost:8080/pradeep/trash-mail.html'> \n"+
				"<input type=\"submit\" style=\"font-face: 'Comic Sans MS'; font-size: larger; color: black; background-color: white; border: 3pt ridge lightgrey\" value=\" Trash \">"+
				"</form>"+
				"</td></tr>"+
				"</table>"+
				"</div>"+
				"<div class=\"three\">"+
				"<form action='http://localhost:8080/pradeep/imagemap.html'>"+
				"<input type=\"image\" src=\"http://localhost:8080/pradeep/images/webpage.jpg\" width=204 height=100>"+
				"</form>"+
				"</div>"+
				"<div class=\"four\">"+
				"<form action='search'>"+
				"<lable><font face='Verdana' color='red'>Search</font></lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				"<input type=\"text\" name=\"search\" style=\"width:200;height:30\" >"+
				"&nbsp;&nbsp;&nbsp;"+
			    "<input type=\"submit\" style=\"font-face: 'Comic Sans MS'; font-size: larger; color: white; background-color: blue; border: 3pt ridge lightgrey\" value=\" Search \">"+
				"</form>"+
				"</div>"+
				"<div class=\"five\">"+
				"<a href='http://localhost:8080/pradeep/index.html' target='_parent'>Sign out</a>"+
				"</div>"+*/
				pw.println("</body> \n"+
				"</html> \n");
			
        }		
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}
