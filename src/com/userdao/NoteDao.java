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
    public ArrayList<Note>selectAllNotes(){

        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        Note note = null;
        ArrayList<Note> list = new ArrayList<Note>();


        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM notetable";
            rs=sta.executeQuery(sql);

            while (rs.next()) {

                note = new Note();

                note.setNoteId(rs.getInt("note_id"));
                note.setNoteTitle(rs.getString("note_title"));
                note.setNoteNumberOfPages(rs.getInt("number_of_pages"));
                note.setNoteType(rs.getString("note_type"));
                note.setNoteSubmitter(rs.getString("note_submitter"));
                note.setNoteDownloadTimes(rs.getInt("download_times"));
                note.setNoteSubmittingTime(rs.getTimestamp("submitting_time"));

                list.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Note queryDownloadTimes(int noteId){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs=null;
        Note note =null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql="SELECT download_times FROM notetable WHERE note_id  = '" + noteId + "'";
            rs = sta.executeQuery(sql);
            System.out.println(sql);
            while(rs.next()){
                note =new Note();
                note.setNoteDownloadTimes(rs.getInt("download_times"));
                note.setNoteId(noteId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return note;
    }

    public void updateDownloadTimes(Note note){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            int newDownloadTimes =note.getNoteDownloadTimes()+1;

            String sql2="UPDATE notetable SET download_times='" + newDownloadTimes + "' WHERE note_id = '" + note.getNoteId() + "'";
            System.out.println(sql2);
            sta.executeUpdate(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
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

    public void deleteUserList(String[] noteId){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            int Id = 0;
            for (int i = 0; i<noteId.length; i++) {

                Id = Integer.parseInt(noteId[i]);

                String sql = "DELETE FROM noteTable WHERE note_id ="
                        + Id;

                sta.executeUpdate(sql);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            dbmanage.closeDB(sta, conn);
        }

    }
}
