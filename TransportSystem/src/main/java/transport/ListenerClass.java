package transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class ListenerClass implements ServletContextListener { 
	Connection con=null;
      @Override
    public void contextInitialized(ServletContextEvent sce) {  
    	  
    	       try {
    				Class.forName("com.mysql.cj.jdbc.Driver");
    				System.out.println("driver is load");
    			    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/police","root","cctns@tcg"); 
    				System.out.println("con is done");
    				sce.getServletContext().setAttribute("connection", con);
    				System.out.println("context  Attribute connection Set");
    				} catch (ClassNotFoundException e) { 
    				e.printStackTrace();
    			} catch (SQLException e) { 
						e.printStackTrace();
					}
 
    	       
    	       String tableManager="create table managerData( id int auto_increment primary key, branch"
    	       		+ "		  varchar(100), managername varchar(200), email varchar(200), passkey"
    	       		+ "		  varchar(100), doj date, dob date, salary varchar(100), mobile varchar(100))";
			   String altertable="alter table managerData auto_increment=1001"; 
			   String tableTruck="create table truckData( model"
			   		+ "		  varchar(100),tnumber varchar(200) primary key,rcnumber varchar(100),insnumber"
			   		+ "		 varchar (100), ownername varchar(100),mobileno varchar(100),rfrom"
			   		+ "		  varchar(100),rto varchar(100),status varchar(100) )";
			   String userdata="create table userData("
			   		+ "		 email varchar(200) primary key,name varchar(200),gender varchar(10),mobileno"
			   		+ "		 varchar(100),address varchar (300),password varchar(100) )";
			   String servicedata=" create table"
			   		+ "		  serviceData( serviceId int auto_increment primary key,email"
			   		+ "		  varchar(200),rfrom varchar(200),rto varchar(10),usermassage"
			   		+ "		  varchar(500),userstatus varchar (100),adminstatus varchar (100),managerstatus"
			   		+ "		  varchar (100),massageforuser varchar (200) )";
			   String alterservice ="alter table serviceData auto_increment=100001";
			
			   PreparedStatement stet1;
			   PreparedStatement stet2;
			   PreparedStatement stet3;
			   PreparedStatement stet4;
			   PreparedStatement stet5;
			   PreparedStatement stet6;
			   
			   try {
				   stet1 = con.prepareStatement(tableManager);
					stet1.executeUpdate();
					System.out.println(" manager table create ");
					stet2 = con.prepareStatement(altertable);
					stet2.executeUpdate();
					System.out.println(" manager table alter ");
			} catch (Exception e) {
				 e.printStackTrace();
			}
			finally {  
					 try {
						 stet3 = con.prepareStatement(tableTruck);
							stet3.executeUpdate();
							System.out.println(" truck table create ");
					} catch (Exception e) {
						e.printStackTrace();
					}
					 finally {
						 try {
								stet4 = con.prepareStatement(userdata);
								stet4.executeUpdate();
								System.out.println(" user data table create ");
							} 
							catch (Exception e) {
								 e.printStackTrace();
							} 
							finally {
								try {
									stet5 = con.prepareStatement(servicedata);
									stet5.executeUpdate();
									System.out.println(" servicedata data table create ");
									stet6 = con.prepareStatement(alterservice);
									stet6.executeUpdate();
									System.out.println("alter servicedata data table  ");

								} 
								catch (Exception e) {
									 e.printStackTrace();
								}  
							}
					}
				}
			}  
       @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	 try {
			con.close();
			System.out.println("connection is closed");
		} catch (SQLException e) { 
			e.printStackTrace();
		}
    }
}
