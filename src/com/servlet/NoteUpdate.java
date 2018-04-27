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

@WebServlet(name = "NoteUpdate")
public class NoteUpdate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoteDao notedao = new NoteDao();
        int noteId=Integer.parseInt(request.getParameter("noteId"));
        String noteDescription=request.getParameter("noteDescription");
        int noteNumberOfPages=Integer.parseInt(request.getParameter("noteNumberOfPages"));
        int noteDownloadPeanuts=Integer.parseInt(request.getParameter("noteDownloadPeanuts"));
        String noteTitle=request.getParameter("noteTitle");
        HttpSession session = request.getSession();
        User user=(User)session.getAttribute("user");
        String name =user.getUserName();

        Note note =new Note();
        note.setNoteId(noteId);
        note.setNoteTitle(noteTitle);
        note.setNoteNumberOfPages(noteNumberOfPages);
        note.setNoteDescription(noteDescription);
        note.setNoteDownloadPeanuts(noteDownloadPeanuts);

        notedao.updateNote(note);

        ArrayList<Note> list = notedao.selectUserNotes(name);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/myNotes.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        NoteDao notedao = new NoteDao();
        Note note = notedao.selectOneNote(noteId);

        request.setAttribute("note", note);
        request.getRequestDispatcher("/updatingNotes.jsp").forward(request, response);
    }

}
