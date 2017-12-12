package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StuDAO;

@WebServlet("/stulist")
public class StuListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String condition = req.getParameter("condition");
		String stulist = "";
		
		if(condition == null || condition.isEmpty()) {
			stulist = new Gson().toJson(new StuDAO().listAll());
		} else {
			stulist = new Gson().toJson(new StuDAO().fuzzyQuery(condition));
		}
		resp.getWriter().println(stulist);
	}
}
