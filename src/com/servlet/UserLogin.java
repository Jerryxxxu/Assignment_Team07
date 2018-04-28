package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import com.user.*;
import com.userdao.*;

@WebServlet(name = "UserLogin")
public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String info="";

        PrintWriter out=response.getWriter();

        UserDao userDao = new UserDao();
        User user=userDao.judgementUserPassword(userName,userPassword);

        if(user == null){

            out.print("<script language='javascript'>alert('please enter the correct username and password');window.location.href='login.jsp';</script>");

        }else{
            request.getSession().setAttribute("user", user);
            //jump to dashboard if username and password are correct
            userDao.increaseUserPeanut(userDao.queryUserPeanut(user.getUserName()),-5);
            userDao.increaseUserPeanut(userDao.queryUserPeanut("jerry"),2);
            userDao.increaseUserPeanut(userDao.queryUserPeanut("lucky"),3);
            info="Welcome  "+user.getUserName()+"!";
            request.setAttribute("info",info);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
