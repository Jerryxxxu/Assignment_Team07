package com.servlet;

import com.user.Event;
import com.user.User;
import com.userdao.StudyDao;
import com.userdao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "StudyIndex")
public class StudyIndex extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String email="";

        UserDao userDao=new UserDao();

        User currentUser=userDao.queryUserPeanut(user.getUserName());

        PrintWriter out=response.getWriter();
        if (user==null){
            out.print("<script language='javascript'>alert('You haven't log in,please log in first');window.location.href='login.jsp';</script>");
        }else{
            email=user.getUserName();

            userDao.increaseUserPeanut(userDao.queryUserPeanut(user.getUserName()),-5);
            userDao.increaseUserPeanut(userDao.queryUserPeanut("jerry"),2);
            userDao.increaseUserPeanut(userDao.queryUserPeanut("zeyad"),3);
            userDao.updateTransaction(user.getUserName(),"app provider and platform",5,"using EventsStudy app");


            StudyDao studydao=new StudyDao();
            ArrayList<Event> list=studydao.selectEvents();
            request.setAttribute("list", list);
            request.setAttribute("email",email);
            request.setAttribute("user",user);
            request.setAttribute("amountPeanut",currentUser.getUserPeanuts());
            request.getRequestDispatcher("EventManagement.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
