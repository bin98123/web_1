package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfile() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("Wrong at: ").append(request.getContextPath());
//		response.getWriter().append("");
//	}
//		boolean ok = true;
//		String uname = request.getParameter("uname");
//		String upass = request.getParameter("upass");
//		if (uname == null || upass == null) {
//			ok = false;
//		}
//		if (uname == "" || upass == null) {
//			ok = false;
//		}
//		if (uname == null || upass == "") {
//			ok = false;
//		}
//		if (uname == "" || upass == "") {
//			ok = false;
//		}
//		if (ok = false) {
//			getServletContext().getRequestDispatcher("/Regagain.jsp").forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		try {
			Class.forName("org.hsqldb.jdbcDriver");
//			Class.forName("org.hsqldb.jdbc.jdbcDriver");
//			Class.forName("org.hsqldb.jdbc.JDBCDriver");
//			"org.hsqldb.jdbc.jdbcDriver"
//			"org.hsqldb.jdbc.JDBCDriver"
//			"org.hsqldb.jdbcDriver"
//			Connection con = DriverManager.getConnection("jdbc:hsqldb:file:///C:/Users/user/Desktop/data/test", "SA",
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sample", "sa", "");
//			Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\user\\Downloads\\Compressed\\hsqldb-2.5.1\\hsqldb\\data\test", "SA", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select uname,upass from user where uname='" + uname + "' and upass='" + upass + "'");

			if (rs.next()) {
				response.sendRedirect("http://localhost:8080/TypingGame/WelcomeUser.jsp?name=" + rs.getString("uname"));
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);

			} else if (!rs.next()) {
				response.sendRedirect("http://localhost:8080/TypingGame/Regagain.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);

			} else {
				out.println();
				out.println("User Name or Password not Matched");
			}

		} catch (Exception ex) {
			System.out.println("Exception in UserProfile: " + ex);
//			throw new Exception("Couldn't open connection to database: " + ex.getMessage());

		}

	}
}