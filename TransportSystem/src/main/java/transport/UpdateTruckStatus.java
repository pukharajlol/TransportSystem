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

@WebServlet("/updatetruckstatus")
public class UpdateTruckStatus extends HttpServlet {
 @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con=(Connection)req.getServletContext().getAttribute("connection");  
	 String query="UPDATE truckData SET status ='"+req.getParameter("status").toUpperCase()+"' WHERE tnumber='"+req.getParameter("tnumber")+"'";
	 try {
		PreparedStatement stet= con.prepareStatement(query);
		stet.executeUpdate();
	} catch (SQLException e) { 
		e.printStackTrace();
	}
	System.out.println(" update truck status");
	req.getRequestDispatcher("status").forward(req, res); 
}
}
