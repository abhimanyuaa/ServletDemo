
import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.PersonModel;
import com.dao.PersonDao;

import java.io.IOException;

/**
 * Servlet implementation class demo
 */
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public demo() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter writer=response.getWriter();;
		PersonModel pm = new PersonModel();
		String username = request.getParameter("Username");
		String pass=request.getParameter("password");
		pm.setUsername(username);
		pm.setPassword(pass);
		PersonDao p= new PersonDao();
		p.Authenticate(pm);
		
		
		 if(username.equals("Admin")&&pass.equals("Admin")) 
		  { RequestDispatcher rd = request.getRequestDispatcher("/home.html");
		  rd.forward(request,response);
		 } 
		  else {
			  RequestDispatcher rd = request.getRequestDispatcher("/login.html"); 
			  rd.include(request, response);
		  }
		 
		
	}
}
