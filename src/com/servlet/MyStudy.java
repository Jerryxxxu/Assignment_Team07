package com.servlet;

import com.user.Event;
import com.user.User;
import com.userdao.StudyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyStudy")
public class MyStudy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");

        StudyDao studydao=new StudyDao();

        ArrayList<Event> list=studydao.selectUserEvents(user.getUserName());
        request.setAttribute("user",user);
        request.setAttribute("list", list);
        request.getRequestDispatcher("ShowMyEvents.jsp").forward(request,response);
    }
}
