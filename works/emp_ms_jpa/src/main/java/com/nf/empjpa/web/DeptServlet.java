package com.nf.empjpa.web;


import com.nf.empjpa.dao.DeptDAO;
import com.nf.empjpa.entity.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/dept")
public class DeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long deptno = Long.parseLong(req.getParameter("deptno"));
        Department dept = new DeptDAO().getById(deptno);
        req.setAttribute("dept", dept);
        req.getRequestDispatcher("/view/dept.jsp").forward(req, resp);
    }
}
