

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forgot_pwd_servlet
 */
@WebServlet("/forgot_pwd_servlet")
public class forgot_pwd_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgot_pwd_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Input_userName = request.getParameter("uname");
		System.out.println(Input_userName);
		final String username = "subha.kuty97@gmail.com";
        final String password = "FirstMail";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        PrintWriter out = response.getWriter();  
		response.setContentType("text/html");
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
    				"jdbc:mysql://localhost:3306/authSystem?useTimezone=true&serverTimezone=UTC","root","SubhaLisha@26");  
        	Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select * from accountinfo where username = \""+ Input_userName + "\"");
        	if(rs.next()) {
        		String appPassword=rs.getString(3);
    			int userCode= rs.getInt(4);
        	String toAddress =rs.getString(5);
        	System.out.println(toAddress);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("subha.kuty97@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toAddress)
            );
            message.setSubject("Recover Password");
				/*
				 * message.setText("Dear Mail Crawler," + "\n\n Please do not spam my email!");
				 */
            message.setText("Dear "+Input_userName+" ,"+ "Your Password is "+
            		appPassword+"\n UserCode is: "+ userCode+"\n");
                    
            Transport.send(message);

            System.out.println("Done");
            
            out.println("<html>\n" +
					"<head>"+
					"<style>"+
					"button {\n" + 
					"  background-color: #4CAF50;\n" + 
					"  color: white;\n" + 
					"  padding: 14px 20px;\n" + 
					"  margin: 8px 0;\n" + 
					"  border: none;\n" + 
					"  cursor: pointer;\n" + 
					"  width: auto;\n" + 
					" // width: 100%;\n" + 
					"}\n" + 
					"\n" + 
					"button:hover {\n" + 
					"  opacity: 0.8;\n" + 
					"  padding: 10px 18px;\n" + 
					"  background-color: #f44336;\n" + 
					"}"+
					"</style>"+
					"<title> Processing!!! </title></head>\n" +
					"<body >\n" +
					"<i><h1 align=\"center\"> Password Sent to your email</h1></i>\n"+
					"<center><button  onclick=\"location.href='login.html'\">Try Login</button></center>"+
					"</body></html>");
            
            
            
        	}
        	else {
        		System.out.println("Wrong username");
        		out.println("<html>\n" +
    					"<head>"+
    					"<style>"+
    					"button {\n" + 
    					"  background-color: #4CAF50;\n" + 
    					"  color: white;\n" + 
    					"  padding: 14px 20px;\n" + 
    					"  margin: 8px 0;\n" + 
    					"  border: none;\n" + 
    					"  cursor: pointer;\n" + 
    					"  width: auto;\n" + 
    					" // width: 100%;\n" + 
    					"}\n" + 
    					"\n" + 
    					"button:hover {\n" + 
    					"  opacity: 0.8;\n" + 
    					"  padding: 10px 18px;\n" + 
    					"  background-color: #f44336;\n" + 
    					"}"+
    					"</style>"+
    					"<title> Forgot Password </title></head>\n" +
    					"<body >\n" +
    					"<i><h1 align=\"center\"> Oops!!!! Wrong Username </h1></i>\n"+
    					"<center><button  onclick=\"location.href='Forgot_pwd.html'\">Try Again</button></center>"+
    					"</body></html>");
    		}
    		
    		
           // response.sendRedirect("http://localhost:8080/SQL/loginSuccessful.html");
        } catch (MessagingException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
