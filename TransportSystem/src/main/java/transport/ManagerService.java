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

@WebServlet("/managerservice")
public class ManagerService extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		String branchString=(String)req.getSession().getAttribute("branch");
			Connection con=(Connection)req.getServletContext().getAttribute("connection");
			String tab1="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
					+ "<title>Login Page</title><style>body {"
					+ "background-image: url(\"image/compnay.jpg\");"  
					+ "background-size:contain;"
					+ "font-family: Arial, sans-serif;background-color: #f2f2f2;margin: 0;padding: 0;display: flex;justify-content: "
					+ "center;align-items: center;height: 100vh;}.login-container {background-image: url(\"image/compnay.jpg\"); "
					+ "background-size:contain;background-color: #fff;padding: 20px;border-radius: 8px;box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);"
					+ "width: 70%;height: 70%;opacity: 1;}h2 {text-align: center;}form {text-align: center;}label {display: block;margin-bottom: 5px;}select, input[type=\"text\"],"
					+ " input[type=\"password\"], input[type=\"submit\"],button  {width: 100%;padding: 10px;margin-bottom: 15px;border: 1px solid #ccc;border-radius:"
					+ " 5px;box-sizing: border-box;}input[type=\"submit\"],button  {background-color: #4CAF50;color: white;cursor: pointer;}input[type=\"submit\"]:hover,button "
					+ " {background-color: #45a049;}p {text-align: center;}a {color: #007bff;text-decoration: none;}a:hover {text-decoration: underline;}</style></head>"
					+ "<body><n class=\"login-container\"> <h2><strong>Manager Desk : "+branchString+"</strong></h2> <br>"
					+ "				  <lable style='padding-right: 20px;'><a href='commingtruck'>Comming Service</a></lable> "
					+ "				  <lable style='padding-right: 20px;'><a href='avilable'>Avilable Service</a></lable> "
					+ "				  <lable style='padding-right: 20px;'><a href='status?reqid=status1'>Status</a></lable> "
					+ "				 <lable style='padding-right: 20px;'><a href='searchservice'>Search Service</a></lable>  "
					+ "				 <lable style='padding-right: 20px;'><a href='managerservice'>Service</a></lable>  "
					+ "			   <lable style='padding: 5px;'><a href='user.html' style='color: red;'>LOGOUT</a></lable><br><br><table border=\"2\" style=\"text-align:center;width:"
					+ " 100%;\"><tr><th>ServiceId</th><th>From</th><th>TO</th><th>User Massage</th><th>PICK/DELIVER</th></tr>";
			  String tab2="</table><br>   </body></html>";  
		      res.getWriter().print(tab1); 
		      
		      try {  
					PreparedStatement stet1= con.prepareStatement("select * from serviceData where adminstatus='Accepted/Forword' AND rfrom='"+branchString+"'"); 
					ResultSet rSet=	stet1.executeQuery();
					 while(rSet.next()) { 
						 res.getWriter().print("<tr>\r\n"
							  		+ "				<td>"+rSet.getString("serviceId")+"</td>\r\n"
							  		+ "				<td>"+rSet.getString("rfrom")+"</td>\r\n"
							  		+ "				<td>"+rSet.getString("rto")+"</td>\r\n"
							  		+ "				<td>"+rSet.getString("usermassage")+"</td>\r\n" 
							  		+ "				<td><form action='pickupdeliver'><input type='hidden' name='sid' value="+rSet.getString("serviceId")+">"
							  				 	 +"<button type='submit' style='width: 100%;'>PickUp/Deliver</button></form></td>"
							  	    + "			</tr>  "); 
					 } 
						 
		      } catch (Exception e) {
		  		e.printStackTrace();
		  	}
		  res.getWriter().print(tab2);
		}
}
