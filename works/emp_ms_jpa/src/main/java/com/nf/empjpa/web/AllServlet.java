package com.nf.empjpa.web;


import com.nf.empjpa.dao.DeptDAO;
import com.nf.empjpa.dao.EmpDAO;
import com.nf.empjpa.entity.Department;
import com.nf.empjpa.entity.Employee;
import com.nf.empjpa.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class AllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> employees = null;

        String ename = req.getParameter("ename1");

        String ename2 = req.getParameter("ename2");
        String lowsal = req.getParameter("lowsal");
        String hisal = req.getParameter("hisal");

        if (CommonUtil.notempty(ename)) {
            employees = new EmpDAO().queryByEname(ename);
        } else if ((CommonUtil.notempty(ename2)) || (CommonUtil.notempty(lowsal)) || (CommonUtil.notempty(hisal))) {
            employees = new EmpDAO().criteriaByConditions(ename2, lowsal, hisal);
        } else {
            employees = new EmpDAO().getAll();
        }

        List<Department> departments = new DeptDAO().getAll();


        req.setAttribute("emps", employees);
        req.setAttribute("depts", departments);

        req.getRequestDispatcher("/view/all.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
