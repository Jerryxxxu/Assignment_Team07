package com.servlet;

import com.user.Note;
import com.user.User;
import com.userdao.NoteDao;
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

@WebServlet(name = "NoteIndex")
public class NoteIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        String info="";

        UserDao userDao=new UserDao();

        PrintWriter out=response.getWriter();
        if (user==null){
            out.print("<script language='javascript'>alert('You haven't log in,please log in first');window.location.href='login.jsp';</script>");
        }else{
            info="Welcome "+user.getUserName();

            NoteDao notedao =new NoteDao();

            userDao.increaseUserPeanut(userDao.queryUserPeanut(user.getUserName()),-5);
            userDao.increaseUserPeanut(userDao.queryUserPeanut("jerry"),2);
            userDao.increaseUserPeanut(userDao.queryUserPeanut("sakine"),3);
            userDao.updateTransaction(user.getUserName(),"app provider and platform",5,"using sharingNotes app");

            ArrayList<Note> list=notedao.selectAllNotes();
            request.setAttribute("list", list);
            request.setAttribute("welcome",info);
            request.getRequestDispatcher("/sharingNotes.jsp").forward(request, response);
        }

    }
}
