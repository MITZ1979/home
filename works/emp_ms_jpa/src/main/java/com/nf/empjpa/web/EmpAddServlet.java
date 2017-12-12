package com.nf.empjpa.web;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// MVC 框架

// 异常处理
@WebServlet("/empadd")
public class EmpAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 0. 设置编码
        req.setCharacterEncoding("UTF-8");


        // 1. 获取参数
        String ename = req.getParameter("ename");
        String deptno = req.getParameter("deptno");
        String sal = req.getParameter("sal");
        String hireDate = req.getParameter("hire_date");


        // 2. 验证输入
        // hireDate 时间类型的字符串，如果写错了话，就不正确
        if (ename == null || ename.trim().isEmpty() || ename.trim().length() > 10) {
            req.setAttribute("empadd_msg", "姓名不能为空，长度要小于10");
            req.getRequestDispatcher("/all").forward(req, resp);
            return;
        }
        if(sal == null || sal.trim().isEmpty() || sal.length() > 5) {
            req.setAttribute("empadd_msg", "工资格式不对");
            req.getRequestDispatcher("/all").forward(req, resp);
            return;
        }
        // .....其他各种验证


        // 3. 封装
        Employee employee = new Employee();
        if (CommonUtil.notempty(ename)) {
            employee.setName(ename);
        }
        if (CommonUtil.notempty(sal)) {
            employee.setSalary(Float.parseFloat(sal));
        }
        if (CommonUtil.notempty(hireDate)) {
            SimpleDateFormat sd = new SimpleDateFormat(hireDate.indexOf("/") > 0 ? "yyyy/MM/dd" : "yyyy-MM-dd");
            Date date = null;
            try {
                date = sd.parse(hireDate);
            } catch (ParseException e) {
                req.setAttribute("empadd_msg", "时间格式不对");
                req.getRequestDispatcher("/all").forward(req, resp);
                return;
            }

            employee.setHireDate(date);
        }
        Department dept = new Department();
        dept.setDeptno(Long.parseLong(deptno));
        employee.setDepartment(dept);


        // 4. 调用，取得数据
        try {
            new EmpDAO().persist(employee);
        } catch (Exception e) { // 需要有异常处理
            req.setAttribute("error", e);
            req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
            return;
        }


        // 5. 跳转，渲染页面
        resp.sendRedirect("/all");
    }
}
