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

@WebServlet("/createmanager")
public class CreateManager extends HttpServlet {
	  static String rendomPassword() { 
    	  return String.valueOf(new Random().nextInt(99999,999999));
      }
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 Connection con=(Connection)req.getServletContext().getAttribute("connection"); 
	 if(req.getMethod().equals("POST")){
		 try {
			 String queryString ="UPDATE managerData SET branch ='"+req.getParameter("branch")+"',salary ='"+req.getParameter("salary")+"',mobile='"+req.getParameter("mobile")+"' WHERE id="+req.getParameter("id")+"";
			 PreparedStatement stet= con.prepareStatement(queryString);  
			if(stet.executeUpdate()>0) {
				System.out.println(" manager update "); 
			}else {
				System.out.println(" manager data  update problem ");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		 res.sendRedirect("showmanager");
	 }else {  
		 try {
	     PreparedStatement stetm= con.prepareStatement( "select id,passkey from managerData where email='"+req.getParameter("email").toUpperCase()+"'");
	     ResultSet rSet=stetm.executeQuery();
	     if(!rSet.next()){ 
				 String passkey= rendomPassword(); 
				 PreparedStatement stet= con.prepareStatement("insert into managerData (branch,managername,email,passkey,doj,dob,salary,mobile) values(?,?,?,?,?,?,?,?)");
				 stet.setString(1, req.getParameter("branch"));
				 stet.setString(2, req.getParameter("uname"));
				 stet.setString(3, req.getParameter("email").toUpperCase());
				 stet.setString(4, passkey);
				 stet.setString(5, req.getParameter("doj"));
				 stet.setString(6, req.getParameter("dob"));
				 stet.setString(7, req.getParameter("salary"));
				 stet.setString(8, req.getParameter("mobile"));
				 if(!stet.execute()) {
					 System.out.println("data insert in table");
					 Mail.sendMail(req.getParameter("email"), "WelCome Your Account Is Created ","Your Password Is "+passkey);
					 res.sendRedirect("admintask.html?error=createuser");
				 }else {
					 System.out.println("something want wrong ");
				 }
			} else {
				System.out.println("User Already Register ");
				 Mail.sendMail(req.getParameter("email"), "User Already Register ","Your Password Is "+rSet.getString("passkey"));
				 res.sendRedirect("admintask.html?error=useralready");
			}
			  
	     }
	 catch (SQLException e) { 
			e.printStackTrace();
		}
	 } 
}
}
