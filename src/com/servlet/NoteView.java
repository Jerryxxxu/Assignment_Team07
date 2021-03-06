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

@WebServlet(name = "NoteView")
public class NoteView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        NoteDao notedao = new NoteDao();
        Note note =notedao.selectOneNote(noteId);
        String welcome="";

        HttpSession session=request.getSession();
        User user = (User)session.getAttribute("user");

        welcome="Welcome "+user.getUserName();
        request.setAttribute("note", note);
        request.setAttribute("welcome",welcome);
        request.getRequestDispatcher("/showNoteDetails.jsp").forward(request, response);
    }
}
