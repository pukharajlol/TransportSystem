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

@WebServlet("/showmanager")
public class ShowManager extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
		Connection con=(Connection)req.getServletContext().getAttribute("connection");
		String tab1="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "<title>Login Page</title><style>body {"
				+ "background-image: url(\"image/compnay.jpg\");"  
				+ "background-size:contain;"
				+ "font-family: Arial, sans-serif;background-color: #f2f2f2;margin: 0;padding: 0;display: flex;justify-content: "
				+ "center;align-items: center;height: 100vh;}.login-container {"
				+ "background-image: url(\"image/compnay.jpg\");"  
				+ "background-size:contain;"
				  +"opacity: 1;"
		           +"width: 70%;"
		           +"height: 70%;"
				+ "background-color: #fff;padding: 20px;border-radius: 8px;box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);"
				+  "}h2 {text-align: center;}form {text-align: center;}label {display: block;margin-bottom: 5px;}select, input[type=\"text\"],"
				+ " input[type=\"password\"], input[type=\"submit\"],button  {width: 100%;padding: 10px;margin-bottom: 15px;border: 1px solid #ccc;border-radius:"
				+ " 5px;box-sizing: border-box;}input[type=\"submit\"],button  {background-color: #4CAF50;color: white;cursor: pointer;}input[type=\"submit\"]:hover,button "
				+ " {background-color: #45a049;}p {text-align: center;}a {color: #007bff;text-decoration: none;}a:hover {text-decoration: underline;}</style></head>"
				+ "<body><n class=\"login-container\">"
				+ "<h2>Admin Desk</h2>"
				+ "<lable style='padding-right: 20px;'><a href='showmanager'>Manager</a></lable>"
				+ "<lable style='padding-right: 20px;'><a href='createmanager.html'>Create New Manager</a></lable>" 
				+ "<lable style='padding-right: 20px;'><a href='installtruck.html'>Install New Service</a></lable>"   
				+ "<lable style='padding-right: 20px;'><a href='showruck'>Show Service</a></lable>"
				+ "<lable style='padding-right: 20px;'><a href='adminservice'>Service</a></lable>"
				+ " <lable style='padding: 5px;'><a href='user.html' style='color: red;'>LOGOUT</a></lable><br><br>"
				+ "<table border=\"2\" style=\"text-align:center;width:"
				+ " 100%;\"><tr><th>ID</th><th>MANAGER NAME</th><th>DATE OF JOINING</th>"
				+ "<th>DATE OF BRITH</th><th> MOBILE NO</th><th> SALARY</th><th>PASSWORD</th><th>BRANCH</th><th>EDIT</th><th>DELETE</th></tr>";
		  String tab2="</table><br> </body></html>";  
	      res.getWriter().print(tab1);  
	      try { 
				PreparedStatement stet1= con.prepareStatement("select * from managerData"); 
				ResultSet rSet=	stet1.executeQuery();
				 while(rSet.next()) { 
					 res.getWriter().print("<tr>\r\n"
						  		+ "				<td>"+rSet.getString("id")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("managername")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("doj")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("dob")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("mobile")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("salary")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("passkey")+"</td>\r\n"
						  		+ "				<td>"+rSet.getString("branch")+"</td>\r\n" 
						  		+ "				<td><form action='editmanager'><input type='hidden' name='id' value="+rSet.getString("id")+"><input type='hidden' name='name' value="+rSet.getString("managername")+">"
						  				+ "<input type='hidden' name='doj' value="+rSet.getString("doj")+"><input type='hidden' name='dob' value="+rSet.getString("dob")+"><input type='hidden' name='salary' value="+rSet.getString("salary")+">"
						  						+ " <input type='hidden' name='mobile' value="+rSet.getString("mobile")+"><input type='hidden' name='branch' value="+rSet.getString("branch")+"><button type='submit' style=\"width: 100%;\">Edit</button></form></td>\r\n"
						  	    + "				<td><form action='deletemanager'><input type='hidden' name='id' value="+rSet.getString("id")+"><button type='submit' style=\"width: 100%;background-color:red\">Delete</button></form> </td>"
						  		+ "			</tr>  "); 
				 } 
					 
	      } catch (Exception e) {
	  		e.printStackTrace();
	  	}
	  res.getWriter().print(tab2);
	}
}
