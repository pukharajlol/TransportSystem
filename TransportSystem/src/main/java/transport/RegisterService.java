package transport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerservice")
public class RegisterService extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 Connection con=(Connection)req.getServletContext().getAttribute("connection"); 
	 try {
		 PreparedStatement stet= con.prepareStatement("insert into serviceData ( email, rfrom, rto, usermassage, userstatus, adminstatus, managerstatus, massageforuser) values(?,?,?,?,?,?,?,?)");
		 stet.setString(1,  (String)req.getSession().getAttribute("email"));
		 stet.setString(2, req.getParameter("from"));
		 stet.setString(3, req.getParameter("where"));
		 stet.setString(4, req.getParameter("usermassage"));
		 stet.setString(5,  "PANDDING");
		 stet.setString(6, "PANDDING" );
		 stet.setString(7, "PANDDING");
		 stet.setString(8, "THANKS FOR GIVE US CHANCE FOR SERVICE");
		 if(!stet.execute()) {
			 System.out.println("data insert in SERVICE  table");
		 }else {
			 System.out.println("something want wrong SERVICE ");
		 }
	} catch (SQLException e) { 
		e.printStackTrace();
	}
	 res.sendRedirect("userlogindesk");
}
}
