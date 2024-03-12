package transport;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/adminServlet")
public class AdminPage extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   res.setContentType("text/html");
	 String usernameString=getServletContext().getInitParameter("adminusername");
	 String passString=getServletContext().getInitParameter("adminpassword");
	 if(usernameString.equals(req.getParameter("username")) && passString.equals(req.getParameter("password")) ) {
		 System.out.println("Admin login"); 
		 res.sendRedirect("admintask.html");		 
		
	 }else {  System.out.println("wrong pass id login");	 
              res.sendRedirect("admin.html?error=incorrect"); 
              
              
	}
}
}
