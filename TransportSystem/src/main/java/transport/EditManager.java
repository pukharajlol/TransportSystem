package transport;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editmanager")
public class EditManager extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		
		String tab1="<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> "
				+ "<title>Login Page</title> <style> body {"
				+ "background-image: url(\"image/compnay.jpg\");"  
				+ "background-size:contain;"
				+ " font-family: Arial, sans-serif; background-color: #f2f2f2; margin: 0; padding: 0; display: flex; "
				+ "justify-content: center; align-items: center; height: 100vh; } .login-container {"
				+ "background-image: url(\"image/compnay.jpg\");"  
				+ "background-size:contain;"
				  +"opacity: 1;"
		           +"width: 70%;"
		           +"height: 70%;"
				+ " background-color: #fff; padding: 20px; border-radius: 8px;"
				+ " box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); } h2 { text-align: center; }"
				+ " form { text-align: center; margin-top: 20px; /* Added margin for separation */ } label { display: block; margin-bottom: 5px; text-align: left; "
				+ "/* Align labels to the left */ } select, input[type=\"text\"], input[type=\"password\"], input[type=\"date\"], input[type=\"submit\"], "
				+ "button { width: 100%; /* Full width for input elements */ padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;"
				+ " box-sizing: border-box; } input[type=\"submit\"], button { background-color: #4CAF50; color: white; cursor: pointer; } input[type=\"submit\"]:hover,"
				+ " button:hover { background-color: #45a049; } p { text-align: center; } a { color: #007bff; text-decoration: none; } a:hover { text-decoration: underline; }"
				+ " </style></head><body> ";
				
		String tab2="<div class=\"login-container\"> <h2>MANAGER INFORMATION EDIT PAGE</h2>  <form action=\"createmanager\" method='post'>  "
				+ "<label>ID:</label> <input type=\"text\" name=\"id\" value='"+req.getParameter("id")+"' required readonly>"
				+ " <label>Select Branch:</label> <select id=\"type\" name=\"branch\"> "
				+ "<option value='"+req.getParameter("branch")+"'>"+req.getParameter("branch")+"</option> <option value=\"Jaipur\">Jaipur</option> "
				+ "<option value=\"Delhi\">Delhi</option> <option value=\"Mumbai\">Mumbai</option> <option value=\"Channi\">Channi</option>"
				+ " <option value=\"Kanpur\">Kanpur</option> <option value=\"Hariyana\">Hariyana</option> </select> "
				+ "<label>User Name:</label> <input type=\"text\" name=\"uname\" value='"+req.getParameter("name")+"' required readonly> "
				+ "<label>Date Of Joining:</label> <input type=\"date\" name=\"doj\" value='"+req.getParameter("doj")+"' required readonly> "
				+ "<label>Date Of Birth:</label> <input type=\"date\" name=\"dob\" value='"+req.getParameter("dob")+"' required readonly> "
				+ "<label>Salary:</label> <input type=\"text\" name=\"salary\" value='"+req.getParameter("salary")+"' required> "
				+ "<label>Mobile No.:</label> <input type=\"text\" name=\"mobile\" value='"+req.getParameter("mobile")+"' required> "
				+ "<button type=\"submit\">Update Manager Info</button> </form> </div></body></html>";
		
		res.getWriter().print(tab1);
		res.getWriter().print(tab2);
		
		
		
	 
	}
}
 