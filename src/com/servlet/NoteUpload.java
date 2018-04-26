package com.servlet;

import com.user.Note;
import com.user.User;
import com.userdao.NoteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "NoteUpload")
@MultipartConfig(maxFileSize = 16177215)
public class NoteUpload extends HttpServlet {
    private String dbURL = "jdbc:mysql://localhost:3306/userdb";
    private String dbUser = "root";
    private String dbPass = "123";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session =request.getSession();

        String noteTitle = request.getParameter("noteTitle");
        //String noteType = request.getParameter("noteType");
        int noteDownloadPeanuts=Integer.parseInt(request.getParameter("downloadPeanuts"));
        String noteType =null;

        User user=(User)session.getAttribute("user");
        String noteSubmitter=user.getUserName();
        System.out.println(noteSubmitter);

        PrintWriter out=response.getWriter();

        InputStream inputStream = null;
        Part filePart = request.getPart("noteFile");
        long noteSize = 0;
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            noteSize=filePart.getSize();
//            int index=filePart.getContentType().lastIndexOf("/")+1;
//            System.out.println(filePart.getContentType().substring(index));
            noteType=filePart.getContentType();

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        Connection conn = null; // connection to the database
        //String message = null;  // message will be sent back to client


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser,dbPass);
            String sql = "INSERT INTO notetable (note_title, note_type, note_size, note_submitter , download_peanuts , note_file) values (?, ?, ? , ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, noteTitle);
            statement.setString(2, noteType);
            statement.setLong(3,noteSize);
            statement.setString(4,noteSubmitter);
            statement.setInt(5,noteDownloadPeanuts);
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(6, inputStream);
            }
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                //message = "File uploaded and saved into database";
                out.print("<script language='javascript'>alert('File uploaded and saved into database');</script>");
//                NoteDao notedao =new NoteDao();
//
//                ArrayList<Note> list=notedao.selectAllNotes();
//                request.setAttribute("list", list);
//            request.getRequestDispatcher("/sharingNotes.jsp").forward(request, response);
               response.sendRedirect("NoteIndex");
//                request.getRequestDispatcher("sharing").forward(request, response);
                //response.sendRedirect("sharingNotes.jsp");
                //out.print("<script language='javascript'>window.location.href='sharingNotes.jsp';</script>");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //sets the message in request scope
            //request.setAttribute("Message", message);

            // forwards to the message page
            //getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
