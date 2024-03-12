package transport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AcceptAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/accpetrequest")
public class AccpetRequest extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
	Connection con=(Connection)req.getServletContext().getAttribute("connection"); 
	 String query="UPDATE serviceData SET userstatus ='Accepted/Forword',adminstatus='Accepted/Forword',managerstatus='Request Accepted By Admin',massageforuser='Accept Your Request And Forword To Regional Manager.Please Contect Our Regional Manager' WHERE serviceId='"+req.getParameter("sid")+"'";
	 try {
		PreparedStatement stet= con.prepareStatement(query);
		stet.executeUpdate();
	} catch (SQLException e) { 
		e.printStackTrace();
	}
	System.out.println("Admin Accept service from user");
	req.getRequestDispatcher("adminservice").forward(req, res); 
}
}
