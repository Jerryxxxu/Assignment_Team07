package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.user.User;
import com.userdao.UserDao;

@WebServlet(name = "UserRegister")
public class UserRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");


        UserDao userDao = new UserDao();
        if (userName !=null){
            if(userDao.userIsExist(userName)){
                User user = new User();
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                userDao.insertUser(user);
                out.print("<script language='javascript'>alert('User has been added to the database');window.location.href='login.jsp';</script>");
            }else {
                out.print("<script language='javascript'>alert('this username has already existed in the database,please choose another username');window.location.href='signup.jsp';</script>");

            }
        }



        //request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
