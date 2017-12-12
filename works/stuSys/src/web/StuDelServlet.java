package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDAO;

@WebServlet("/studel")
public class StuDelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String items[] = req.getParameterValues("item");
		StuDAO stuDAO = new StuDAO();
		for(String item: items) {
			stuDAO.delete(item);
		}
	}
	
	

}
