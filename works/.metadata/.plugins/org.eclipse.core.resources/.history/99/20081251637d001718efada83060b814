package web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import entity.Book;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		new BookDAO().addBook(new Book(
					req.getParameter("bookName"),
					new BigDecimal(req.getParameter("price")),
					req.getParameter("author"),
					req.getParameter("publisher"),
					req.getParameter("publishDate")
				));
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	

}
