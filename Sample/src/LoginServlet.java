

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException { 
			//from Form
			String Input_userName = request.getParameter("uname");
			String Input_pwd=request.getParameter("psw");
			String Input_codeText= request.getParameter("uc");
			
			try {
			
			
			/*if(Input_userName.equals("") || Input_pwd.equals("") || Input_codeText.contentEquals("")) {
				System.out.println("Invalid Credentials");
				response.sendRedirect("http://localhost:8080/Sample/emptyPage.html");
				
			}*/
			int Input_usrCode = Integer.parseInt(Input_codeText);
			
			
			System.out.println(Input_userName);
			System.out.println(Input_pwd);
			System.out.println(Input_usrCode);
			
			request.setAttribute("data",1);
			response.sendRedirect("http://localhost:8080/Sample/inValid.jsp");
			int flag=-1;
			int uid;
			String username=null;
			String password=null;
			int userCode;
			Class.forName("com.mysql.cj.jdbc.Driver");  
			//Connection con=DriverManager.getConnection(  
			//		"jdbc:mysql://sql.njit.edu:3306/sk2745?useTimezone=true&serverTimezone=UTC","sk2745","CFNN5K5Xa");  
			
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/authSystem?useTimezone=true&serverTimezone=UTC","root","SubhaLisha@26");
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from accountinfo where username = \""+Input_userName + "\"");  
			
			if(rs.next())
			{
				password=rs.getString(3);
			    userCode=rs.getInt(4);
			    System.out.println(password);
				System.out.println(userCode);
				if(Input_pwd.equals(password) && Input_usrCode==userCode)
				{
					System.out.println("Login Successful");
					response.sendRedirect("http://localhost:8080/Sample/loginSuccessful.html");
				}
//				else
//				{
//					System.out.println("Invalid Password");
//					
//					response.sendRedirect("http://localhost:8080/Sample/inValid.jsp");	
//					
//				}
			}
			else
			{
				System.out.println("Invalid Credentials");
				response.sendRedirect("http://localhost:8080/Sample/inValid.jsp");	
			}
			
			
			con.close();  
		}catch(Exception e){ 
			e.printStackTrace();
			if(Input_userName.equals("") || Input_pwd.equals("") || Input_codeText.contentEquals("")) {
				//System.out.println("Invalid Credentials");
			
				response.sendRedirect("http://localhost:8080/Sample/emptyPage.html");
				
			}
			
			//System.out.println(e);
		}
	}  
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
