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

@WebServlet("/pickupdeliver")
public class PickUpDeliver extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		Connection con=(Connection)req.getServletContext().getAttribute("connection"); 
		 String query="UPDATE serviceData SET userstatus ='Deliverd',adminstatus='Deliverd',managerstatus='Deliverd',massageforuser='Thanks For Give Us Chance Serve.We Waiting For Next Service' WHERE serviceId='"+req.getParameter("sid")+"'";
		 try {
			PreparedStatement stet= con.prepareStatement(query);
			stet.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		System.out.println("Manager Accept service from user");
		req.getRequestDispatcher("managerservice").forward(req, res); 
	}
}
