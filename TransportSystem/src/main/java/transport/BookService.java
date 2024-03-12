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

@WebServlet("/bookservice")
public class BookService extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
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
				+ "<body><n class=\"login-container\"> "
				+ "<h2>WelCome :"+req.getSession().getAttribute("name")+"</h2>"  
				+"<marquee style='color: red;'><strong>Our Services in City :  Jaipur   Delhi   Mumbai   Channi   Kanpur   Hariyana</strong> </marquee><br><br>" 
				+ "<lable style='padding-right: 20px;'><a href='bookservice'>Book Service</a></lable>"
				+ "<lable style='padding-right: 20px;'><a href='userservicecheck'>Check Service Status</a></lable>" 
				+ "<lable style='padding-right: 20px;'><a href='contect.html'>Contect Us</a></lable>"   
				+ " <lable style='padding: 5px;text-align: right;'><a href='user.html' style='color: red;'>LOGOUT</a></lable><br><br>"
				+ " <form action='registerservice' method='post'> "
				+ "<label style='text-align: left;'>From:</label>"
				+ " <input type=\"text\" list='branch' name=\"from\"> "
				+ "<datalist id='branch'><option value=\"Jaipur\">Jaipur</option><option value=\"Delhi\">Delhi</option> <option value=\"Mumbai\">Mumbai</option> <option value=\"Channi\">Channi</option>"
				+ " <option value=\"Kanpur\">Kanpur</option> <option value=\"Hariyana\">Hariyana</option> </datalist> "
				+ "<label style='text-align: left;'>Where:</label>"
				+ " <input type=\"text\" list='branch' name=\"where\"> "
				+ "<datalist id='branch'><option value=\"Jaipur\">Jaipur</option><option value=\"Delhi\">Delhi</option> <option value=\"Mumbai\">Mumbai</option> <option value=\"Channi\">Channi</option>"
				+ " <option value=\"Kanpur\">Kanpur</option> <option value=\"Hariyana\">Hariyana</option> </datalist> " 
				+ "<label style='text-align: left;'>Massage:</label>"
				+ " <input type=\"text\" style='height: 100px;' name=\"usermassage\"> "  
				+ "<button type=\"submit\">Book Services</button> </form>";;
		  String tab2="</body></html>";  
	      res.getWriter().print(tab1);  
	      res.getWriter().print(tab2); 
}
}
