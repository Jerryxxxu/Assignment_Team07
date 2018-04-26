package com.servlet;

import com.user.Note;
import com.user.User;
import com.userdao.NoteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NoteDelete")
public class NoteDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        String name =user.getUserName();

        String noteId[] = request.getParameterValues("num");
        NoteDao notedao = new NoteDao();
        notedao.deleteUserList(noteId) ;

        ArrayList<Note> list=notedao.selectUserNotes(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/myNotes.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        String name =user.getUserName();


        int noteId = Integer.parseInt(request.getParameter("noteId"));
        NoteDao notedao = new NoteDao();
        notedao.deleteOneUser(noteId);
        ArrayList<Note> list = notedao.selectUserNotes(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/myNotes.jsp").forward(request, response);
    }
}
