package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//			BookDBAO bookDBAO =
//		          (BookDBAO)getServletContext().getAttribute("bookDBAO");
//			String bookId = request.getParameter("bookId");
//			BookDetails bd = null;
//			try {
//				bd = bookDBAO.getBookDetails(bookId);
//			} catch (BookNotFoundException e) {
//				e.printStackTrace();
//			}	
//			request.setAttribute("selectedbook", bd);
		request.getRequestDispatcher("/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}