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

@WebServlet("/deletetruck")
public class DeleteTruck extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 Connection con=(Connection)req.getServletContext().getAttribute("connection");
		 try { 
			 System.out.println(req.getParameter("tnumber"));
			PreparedStatement stet1= con.prepareStatement("delete from truckData where tnumber=\""+req.getParameter("tnumber")+"\""); 
		int roweff=stet1.executeUpdate();
		System.out.println(" row eff "+roweff);
		 }catch (Exception e) {
		e.printStackTrace();
		}
		 res.sendRedirect("showruck");
		 }
}
