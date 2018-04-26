package com.servlet;

import com.user.User;
import com.userdao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserAccount")
public class UserAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user = (User)session.getAttribute("user");

        String info="";

        UserDao userdao =new UserDao();
        User currentUser=userdao.queryUserPeanut(user.getUserName());
        info="Welcome  "+user.getUserName()+"!";
        request.setAttribute("info",info);
        request.setAttribute("user",currentUser);
        request.getRequestDispatcher("myAccount.jsp").forward(request,response);
    }
}
