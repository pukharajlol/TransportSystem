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

@WebServlet("/status")
public class StatusUpdate extends HttpServlet {  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		Connection con=(Connection)req.getServletContext().getAttribute("connection");
		String branchString=(String)req.getSession().getAttribute("branch");
        
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
				+ "<body><n class=\"login-container\">   <h2><strong>Manager Desk : "+branchString+"</strong></h2> <br> "
				+ "			   <lable style='padding-right: 20px;'><a href='commingtruck'>Comming Service</a></lable> "
				+ "				  <lable style='padding-right: 20px;'><a href='avilable'>Avilable Service</a></lable> "
				+ "				   <lable style='padding-right: 20px;'><a href='status?reqid=status1'>Status</a></lable> "
				+ "				 <lable style='padding-right: 20px;'><a href='searchservice'>Search Service</a></lable> "
				+ "				 <lable style='padding-right: 20px;'><a href='managerservice'> Service</a></lable> "
				+ "			   <lable style='padding: 5px;'><a href='user.html' style='color: red;'>LOGOUT</a></lable><br><br><table border=\"2\" style=\"text-align:center;width:"
				+ " 100%;\"><tr><th>TRUCK NO.</th><th>RC NO.</th> <th> OWNER </th><th>MOBILE NO.</th><th>FROM</th><th>TO</th><th>STATUS</th></tr>";
		  String tab2="</table><br>  </body></html>";  
	      res.getWriter().print(tab1); 
	      
	      try { 
				PreparedStatement stet1= con.prepareStatement("select * from truckData "); 
				ResultSet rSet=	stet1.executeQuery();
				 while(rSet.next()) { 
					 res.getWriter().print("<tr>\r\n" 
						  		+ "				<td>"+rSet.getString("tnumber")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("rcnumber")+"</td>\r\n" 
						  		+ "				<td>"+rSet.getString("ownername")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("mobileno")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("rfrom")+"</td>\r\n" 
						  		+ "				<td>"+rSet.getString("rto")+"</td>\r\n" 
						  		+ "				<td><form action='status' method='post'><input type='hidden' value='"+rSet.getString("tnumber")+"' name='tnumber'><button type='submit'>"+rSet.getString("status")+"</button></form></td>" 
						  		 + "			</tr>  "); 
				 } 
					 
	      } catch (Exception e) {
	  		e.printStackTrace();
	  	}
	  res.getWriter().print(tab2);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con=(Connection)req.getServletContext().getAttribute("connection");
		String branchString=(String)req.getSession().getAttribute("branch");
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
				+ "<body><n class=\"login-container\"><h2><strong>Manager Desk : "+branchString+"</strong></h2> <br>"
				+ "			   <lable style='padding-right: 20px;'><a href='commingtruck'>Comming Service</a></lable>"
				+ "				 <lable style='padding-right: 20px;'><a href='avilable'>Avilable Service</a></lable> "
				+ "			  <lable style='padding-right: 20px;'><a href='status?reqid=status1'>Status</a></lable> "
				+ "				 <lable style='padding-right: 20px;'><a href='searchservice'>Search Service</a></lable>  "
				+ "				 <lable style='padding-right: 20px;'><a href='managerservice'> Service</a></lable>  "
				+ "			  <lable style='padding: 5px;'><a href='user.html' style='color: red;'>LOGOUT</a></lable><br><br> "
				+ " <form action='updatetruckstatus'> "
				+ "<label style='text-align: left;'>Enter Status Update:</label> <input type=\"text\" list='branch' name=\"status\"> "
				+ "<datalist id='branch'><option value=\"Jaipur\">Jaipur</option><option value=\"Delhi\">Delhi</option> <option value=\"Mumbai\">Mumbai</option> <option value=\"Channi\">Channi</option>"
				+ " <option value=\"Kanpur\">Kanpur</option> <option value=\"Hariyana\">Hariyana</option> </datalist> "
				+"<input type='hidden' value='"+req.getParameter("tnumber")+"' name='tnumber'>"
				+ "<button type=\"submit\">Update Truck Status</button> </form>";;
		  String tab2="<br>  </body></html>";  
	      res.getWriter().print(tab1); 
	      
	      
	  res.getWriter().print(tab2);
	}
	 
}
