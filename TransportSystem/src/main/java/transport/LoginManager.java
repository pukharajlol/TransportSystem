package transport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginmanager")
public class LoginManager extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	Connection con=(Connection)req.getServletContext().getAttribute("connection");
	String branch=req.getParameter("branch");
	String user=req.getParameter("username");
	String pass=req.getParameter("password");
	String query="select * from managerData where branch='"+branch+"' AND email='"+user+"' AND passkey='"+pass+"'";
	try {
		PreparedStatement stet1= con.prepareStatement(query); 
		 if(stet1.executeQuery().next()) {
			 System.out.println("login manager");
			 req.getSession().setAttribute("branch", branch);
			 res.sendRedirect("managertask.html");
		 }else {
			 System.out.println("dont login manager");
			 res.sendRedirect("index.html");
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
