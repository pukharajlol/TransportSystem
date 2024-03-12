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

@WebServlet("/deletemanager")
public class DeleteManager extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con=(Connection)req.getServletContext().getAttribute("connection");
		try { 
			PreparedStatement stet1= con.prepareStatement("delete from managerData where id="+req.getParameter("id")+"");  
			if(stet1.executeUpdate()>0) {
				System.out.println("delete manager ");
				
			}else {
				System.out.println(" not delete manager ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 res.sendRedirect("showmanager");
		
	}
}
