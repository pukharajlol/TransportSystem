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
@WebServlet("/declinerequest")
public class DeclineRequest extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		Connection con=(Connection)req.getServletContext().getAttribute("connection"); 
		 String query="UPDATE serviceData SET userstatus ='Decline',adminstatus='Decline',managerstatus='Request Decline By Admin',massageforuser='Decline! Your Request Sorry For The Inconvenience' WHERE serviceId='"+req.getParameter("sid")+"'";
		 try {
			PreparedStatement stet= con.prepareStatement(query);
			stet.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		System.out.println("Admin Decline service from user");
		req.getRequestDispatcher("adminservice").forward(req, res); 
	}
}
