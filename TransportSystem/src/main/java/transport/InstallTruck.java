package transport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/installtruck")
public class InstallTruck extends HttpServlet {  
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 Connection con=(Connection)req.getServletContext().getAttribute("connection");
		 try { 
			PreparedStatement stet1= con.prepareStatement("select * from truckData where tnumber=\""+req.getParameter("tnumber").toUpperCase()+"\""); 
			ResultSet rSet=	stet1.executeQuery();
			if(!rSet.next()) {
				try {
					 PreparedStatement stet= con.prepareStatement("insert into truckData values(?,?,?,?,?,?,?,?,?)");
					 stet.setString(1, req.getParameter("model").toUpperCase());
					 stet.setString(2, req.getParameter("tnumber").toUpperCase());
					 stet.setString(3, req.getParameter("rcnumber").toUpperCase());
					 if(req.getParameter("insurance").equals("YES")) {
						 stet.setString(4, req.getParameter("insurance")+"/"+req.getParameter("InsuranceCompany").toUpperCase());
					 }else{
						 stet.setString(4, req.getParameter("insurance"));
					 } 
					 stet.setString(5, req.getParameter("owner").toUpperCase());
					 stet.setString(6, req.getParameter("mobileno"));
					 stet.setString(7, req.getParameter("frombranch").toUpperCase());
					 stet.setString(8, req.getParameter("tobranch").toUpperCase());
					 stet.setString(9, req.getParameter("frombranch").toUpperCase() );
					 if(!stet.execute()) {
						 System.out.println("data insert in table");
						 res.sendRedirect("admintask.html?error=createtruck");
						 
					 }else {
						 System.out.println("Something is wrong");
						 res.sendRedirect("admintask.html");
					 }
					 
				} catch (SQLException e) { 
					e.printStackTrace();
					
				}
			}else {
				res.sendRedirect("installtruck.html?error=alreadytruck"); 
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	} 
}
