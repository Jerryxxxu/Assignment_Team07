package com.userdao;

import com.user.Note;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NoteDao {

    public ArrayList<Note>selectUserNotes(String name){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        Note note = null;
        ArrayList<Note> list = new ArrayList<Note>();


        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM notetable WHERE note_submitter = '"
                    + name + "'";
            rs=sta.executeQuery(sql);

            while (rs.next()) {

                note = new Note();

                note.setNoteId(rs.getInt("note_id"));
                note.setNoteTitle(rs.getString("note_title"));
                note.setNoteType(rs.getString("note_type"));
                note.setNoteSubmitter(rs.getString("note_submitter"));

                list.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dbmanage.closeDB(rs,sta,conn);
        }
        return list;
    }

    public void deleteOneUser(int noteId) {
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "DELETE FROM noteTable WHERE note_id ="
                    + noteId;

            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            dbmanage.closeDB(sta, conn);
        }

    }
}
