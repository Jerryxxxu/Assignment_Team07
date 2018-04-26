package com.servlet;

import com.user.User;
import com.userdao.NoteDao;
import com.userdao.UserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "NoteDownload")
public class NoteDownload extends HttpServlet {
    // size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;

    private String dbURL = "jdbc:mysql://localhost:3306/userdb";
    private String dbUser = "root";
    private String dbPass = "123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noteId = Integer.parseInt(request.getParameter("id"));

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");


        Connection conn = null; // connection to the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser,dbPass);

            // queries the database
            String sql = "SELECT * FROM notetable WHERE note_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, noteId);

            ResultSet result = statement.executeQuery();
            if(result.next()){
                // gets file name and file blob data
                String noteTitle = result.getString("note_title");
                Blob blob = result.getBlob("note_file");
                InputStream inputStream = blob.getBinaryStream();
                int downloadPeanuts=result.getInt("download_peanuts");
                int fileLength = inputStream.available();

                System.out.println("fileLength = " + fileLength);
//                ServletContext context = getServletContext();
//                String mimeType = context.getMimeType(noteTitle);
                String mimeType=result.getString("note_type");
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                System.out.println(mimeType);
                // set content properties and header attributes for the response
                response.setContentType(mimeType);
                response.setContentLength(fileLength);
                int index=mimeType.lastIndexOf("/")+1;
                System.out.println("."+mimeType.substring(index));
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename="+noteTitle+"."+mimeType.substring(index));
                response.setHeader(headerKey, headerValue);

                // writes the file to the client
                OutputStream outStream = response.getOutputStream();

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outStream.close();

                NoteDao notedao=new NoteDao();
                notedao.updateDownloadTimes(notedao.queryDownloadTimes(noteId));
                UserDao userdao =new UserDao();
                userdao.increaseUserPeanut(userdao.queryUserPeanut(user.getUserName()),-downloadPeanuts);
                userdao.increaseUserPeanut(userdao.queryUserPeanut(notedao.queryNoteSubmitter(noteId).getNoteSubmitter()),downloadPeanuts);


            }else{
                // no file found
                response.getWriter().print("File not found for the id: " + noteId);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
