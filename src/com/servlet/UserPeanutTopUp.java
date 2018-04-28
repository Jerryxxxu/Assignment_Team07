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
import java.io.PrintWriter;

@WebServlet(name = "UserPeanutTopUp")
public class UserPeanutTopUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number=Integer.parseInt(request.getParameter("numberOfPeanuts"));
        HttpSession session=request.getSession();
        User user = (User)session.getAttribute("user");

        UserDao userdao =new UserDao();
        User currentUser=userdao.queryUserPeanut(user.getUserName());
        userdao.increaseUserPeanut(currentUser,number);


//        request.setAttribute("user",currentUser);
        response.sendRedirect("UserAccount");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
