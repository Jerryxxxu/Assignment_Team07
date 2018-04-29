package com.userdao;

import com.user.Question;
import com.user.Reply;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionReplyDao {
    public void insertQuestion(Question question) {

        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "INSERT INTO question (question_info,question_user,questionusername,questiontime)VALUES('"
                    + question.getQuestionInfo()
                    + "',"
                    + question.getQuestionUser()
                    + ",'"
                    + question.getQuestionUsername()
                    + "','"
                    + question.getQuestiontime()
                    + "')";
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            dbmanage.closeDB(sta, conn);
        }
    }
    public void insertReply(Reply reply) {

        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "INSERT INTO reply (reply_info,reply_user,"
                    + "reply_question,reply_time,replyusername)VALUES('"
                    + reply.getReplyInfo()
                    + "',"
                    + reply.getReplyUser()
                    + ",'"
                    + reply.getReplyQuestion()
                    + "','"
                    + reply.getReplyTime()
                    + "','"
                    + reply.getReplyusername()
                    + "')";
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            dbmanage.closeDB(sta, conn);
        }
    }
    public List<Reply> queryReplyByQuestionId(String questionid){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        List<Reply> replylist=new ArrayList<Reply>();
        Reply reply=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM reply WHERE reply_question = " + questionid ;
            rs = sta.executeQuery(sql);
            while(rs.next()){
                reply=new Reply();
                reply.setReplyId(rs.getInt("reply_id"));
                reply.setReplyInfo(rs.getString("reply_info"));
                reply.setReplyQuestion(rs.getInt("reply_question"));
                reply.setReplyUser(rs.getInt("reply_user"));
                reply.setReplyTime(rs.getString("reply_time"));
                reply.setReplyusername(rs.getString("replyusername"));
                replylist.add(reply);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return replylist;
    }
    public Reply queryReplyByReplyId(String replyid){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        Reply reply=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM reply WHERE reply_id = " + replyid ;
            rs = sta.executeQuery(sql);
            while(rs.next()){
                reply=new Reply();
                reply.setReplyId(rs.getInt("reply_id"));
                reply.setReplyInfo(rs.getString("reply_info"));
                reply.setReplyQuestion(rs.getInt("reply_question"));
                reply.setReplyUser(rs.getInt("reply_user"));
                reply.setReplyTime(rs.getString("reply_time"));
                reply.setReplyusername(rs.getString("replyusername"));
                return reply;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return reply;
    }
    public Question queryQuestionByQuestionId(String questionid){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        Question question=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM question WHERE question_id = " + questionid ;
            rs = sta.executeQuery(sql);
            while(rs.next()){
                question=new Question();
                question.setQuestionId(rs.getInt("question_id"));
                question.setQuestionInfo(rs.getString("question_info"));
                question.setQuestionUser(rs.getInt("question_user"));
                question.setQuestionBestReply(rs.getInt("question_bestreply"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return question;
    }
    public List<Question> queryAllQuestion(){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        List<Question> questionlist=new ArrayList<Question>();
        Question question=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM question";
            rs = sta.executeQuery(sql);
            while(rs.next()){
                question=new Question();
                question.setQuestionId(rs.getInt("question_id"));
                question.setQuestionInfo(rs.getString("question_info"));
                question.setQuestionUser(rs.getInt("question_user"));
                question.setQuestionUsername(rs.getString("questionusername"));
                question.setQuestiontime(rs.getString("questiontime"));
                questionlist.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return questionlist;
    }
    //update the besy replay form the customer
    public void updateBestReply(int questionId,int bestreply){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "UPDATE question SET question_bestreply=" +bestreply + " WHERE question_id = " + questionId ;
            System.out.println(sql);
            sta.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
    }
    public void updateUserPeanut(int userid,int peanut){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "UPDATE usertable SET user_peanut=" +peanut + " WHERE user_id = " + userid ;
            System.out.println(sql);
            sta.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
    }


    /*
    find all my problems
     */
    public List<Question> queryAllMyQuestion(int userId){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        List<Question> questionlist=new ArrayList<Question>();
        Question question=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM question WHERE question_user = "+userId;
            rs = sta.executeQuery(sql);
            while(rs.next()){
                question=new Question();
                question.setQuestionId(rs.getInt("question_id"));
                question.setQuestionInfo(rs.getString("question_info"));
                question.setQuestionUser(rs.getInt("question_user"));
                question.setQuestionUsername(rs.getString("questionusername"));
                question.setQuestiontime(rs.getString("questiontime"));
                questionlist.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return questionlist;
    }
}
