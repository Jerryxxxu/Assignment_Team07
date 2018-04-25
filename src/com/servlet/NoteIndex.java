package com.servlet;

import com.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NoteIndex")
public class NoteIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String info="";

        PrintWriter out=response.getWriter();
        if (user==null){
            out.print("<script language='javascript'>alert('You haven't log in,please log in first');window.location.href='login.jsp';</script>");
        }else{
            info="Welcome "+user.getUserName();
            request.setAttribute("welcome",info);
            request.getRequestDispatcher("sharingNotes.jsp").forward(request, response);
        }

    }
}