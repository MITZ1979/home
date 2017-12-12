package edu.southit.s134.anotherTestProject.web;


import edu.southit.s134.anotherTestProject.test.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("你懂个p");

        Person bijiaochangyongdeyigekuaijiejian = new Person();
        bijiaochangyongdeyigekuaijiejian.sayHello();


    }
}







