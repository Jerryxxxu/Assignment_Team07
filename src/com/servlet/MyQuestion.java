package com.servlet;

import com.user.Question;
import com.user.User;
import com.userdao.QuestionReplyDao;
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

@WebServlet("/MyQuestion")
public class MyQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String info="";

        UserDao ud=new UserDao();
        QuestionReplyDao qr = new QuestionReplyDao();

        PrintWriter out=response.getWriter();
        if (user==null){
            out.print("<script language='javascript'>alert('You haven't log in,please log in first');window.location.href='login.jsp';</script>");
        }else{
           ArrayList<Question> list =  (ArrayList<Question>) qr.queryAllMyQuestion(user.getUserId());
            request.setAttribute("myQuestionList",list);
            request.getRequestDispatcher("/myProblems.jsp").forward(request, response);
        }

    }
}
