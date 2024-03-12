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

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {  
		Connection con=(Connection)req.getServletContext().getAttribute("connection");
		String email=req.getParameter("email").toUpperCase(); 
		String pass=req.getParameter("password");
		String query="select * from userData where email='"+email+"' AND password='"+pass+"'";
		try {
			PreparedStatement stet1= con.prepareStatement(query); 
			ResultSet set=stet1.executeQuery();
			 if(set.next()) { 
				 System.out.println("login user");
				 req.getSession().setAttribute("name",set.getString("name"));
				 req.getSession().setAttribute("email",email);
				 res.sendRedirect("userlogindesk");
			 }else {
				 System.out.println("dont login user");
				 res.sendRedirect("user.html");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}   
}
}