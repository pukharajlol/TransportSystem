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

@WebServlet("/userregister")
public class UserRegister extends HttpServlet {
      static String rendomPassword() { 
    	  return String.valueOf(new Random().nextInt(99999,999999));
      }
      @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 		 Connection con=(Connection)req.getServletContext().getAttribute("connection");
 		 try { 
 			PreparedStatement stet1= con.prepareStatement("select * from userData where email=\""+req.getParameter("email").toUpperCase()+"\""); 
 			ResultSet rSet=	stet1.executeQuery();
 			if(!rSet.next()) {
 				try {String userpassword=rendomPassword();
 					 PreparedStatement stet= con.prepareStatement("insert into userData values(?,?,?,?,?,?)");
 					 stet.setString(2, req.getParameter("name").toUpperCase());
 					 stet.setString(1, req.getParameter("email").toUpperCase());
 					 stet.setString(3, req.getParameter("gender").toUpperCase()); 
 				     stet.setString(5, req.getParameter("address").toUpperCase()); 
 					 stet.setString(4, req.getParameter("mobile"));
 					 stet.setString(6, userpassword ); 
 					 if(!stet.execute()) {
 						 System.out.println("user register data insert in table"); 
 						 Mail.sendMail(req.getParameter("email"), "WelCome Your Account Is Created ","Your Password Is "+userpassword);
 					 }else {
 						 System.out.println("Something is wrong");
 					 }
 					 res.sendRedirect("user.html");
 				} catch (SQLException e) { 
 					e.printStackTrace();
 					
 				}
 			}else {
 				 Mail.sendMail(req.getParameter("email"), "User Already Exist ","Your Password Is "+rSet.getString("password"));
 				System.out.println("user already exist ");
 				res.sendRedirect("user.html"); 
 			}
 		} catch (SQLException e) { 
 			e.printStackTrace();
 		}  
    }
}
