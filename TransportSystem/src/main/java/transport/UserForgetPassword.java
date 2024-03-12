package transport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userforgetpassword")
public class UserForgetPassword extends HttpServlet {
	 static String rendomPassword() { 
   	  return String.valueOf(new Random().nextInt(99999,999999));
     } 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 Connection con=(Connection)req.getServletContext().getAttribute("connection");
		 try { 
			PreparedStatement stet1= con.prepareStatement("select * from managerData where email=\""+req.getParameter("email").toUpperCase()+"\""); 
			ResultSet rSet=	stet1.executeQuery();
			if(rSet.next()) {
				try {String userpassword=rendomPassword(); 
					 PreparedStatement stet= con.prepareStatement("UPDATE managerData SET passkey ='"+userpassword+"' WHERE email='"+req.getParameter("email")+"'"); 
					 if(stet.executeUpdate()>0) {
						 System.out.println("manager password is update"); 
						 Mail.sendMail(req.getParameter("email"), "Reset Your Password ","Your Password Is "+userpassword);
					 }else {
						 System.out.println("Something is wrong manager password is not update");
					 }
					 res.sendRedirect("user.html");
				} catch (SQLException e) { 
					e.printStackTrace();
			
				}
			}else {
				 System.out.println("manager Not Exist");
				 Mail.sendMail(req.getParameter("email"), "manager Not Exist ","Your Password  Change Request Is Fail"); 
				res.sendRedirect("user.html"); 
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	}@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 Connection con=(Connection)req.getServletContext().getAttribute("connection");
		 try { 
			PreparedStatement stet1= con.prepareStatement("select * from userData where email=\""+req.getParameter("email").toUpperCase()+"\""); 
			ResultSet rSet=	stet1.executeQuery();
			if(rSet.next()) {
				try {String userpassword=rendomPassword(); 
					 PreparedStatement stet= con.prepareStatement("UPDATE userData SET password ='"+userpassword+"' WHERE email='"+req.getParameter("email")+"'"); 
					 if(stet.executeUpdate()>0) {
						 System.out.println("user password is update"); 
						 Mail.sendMail(req.getParameter("email"), "Reset Your Password ","Your Password Is "+userpassword);
					 }else {
						 System.out.println("Something is wrong user password is not update");
					 }
					 res.sendRedirect("user.html");
				} catch (SQLException e) { 
					e.printStackTrace();
					
				}
			}else {
				 System.out.println("user Not Exist");
				 Mail.sendMail(req.getParameter("email"), "User Not Exist ","Your Password  Change Request Is Fail"); 
				res.sendRedirect("user.html"); 
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	}
}
