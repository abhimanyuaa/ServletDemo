
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.PersonModel;
import com.dao.PersonDao;

/**
 * Servlet implementation class home
 */
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter writer = response.getWriter();
		writer.write("<h1>Welcome to home</h1>");
		PersonModel pm = new PersonModel();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String subject = request.getParameter("subject");
		String[] hobbies = request.getParameterValues("hobbies");
		/*
		 * writer.write(username+"<br>"); writer.write(gender+"<br>");
		 * writer.write(password+"<br>"); writer.write(subject+"<br>");
		 */
		pm.setUsername(username);
		pm.setPassword(password);
		pm.setGender(gender);
		pm.setSubject(subject);
		//pm.setHobbies(hobbies);
		/*
		 * for (String hobby : hobbies) { System.out.println(hobby);
		 * writer.write(hobby); }
		 */
		PersonDao dao = new PersonDao();
		boolean t=dao.save(pm);
		/*
		 * if(t==true) { RequestDispatcher rd =
		 * request.getRequestDispatcher("/Welcome.html"); rd.forward(request,response);
		 * } else { RequestDispatcher rd = request.getRequestDispatcher("home");
		 * rd.forward(request,response); }
		 * 
		 */
	}

}
