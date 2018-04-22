package com.userdao;

import com.user.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public void insertUser(User user) {

        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "INSERT INTO usertable (user_name,user_password)VALUES('"
                    + user.getUserName()
                    + "','"
                    + user.getUserPassword()
                    + "')";
            sta.executeUpdate(sql);
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            dbmanage.closeDB(sta, conn);
        }
    }

    public Boolean userIsExist(String userName){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs=null;


        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM userTable WHERE user_name = '"
                    + userName + "'";
            rs =sta.executeQuery(sql);
            if(!rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return false;
    }


    public User judgementUserPassword(String userName,String userPassword){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        User user=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM userTable WHERE user_name = '"
                    + userName + "' AND user_password= '" + userPassword + "'";
            rs = sta.executeQuery(sql);
            while(rs.next()){
                user=new User();
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return user;
    }


    public void increaseUserPeanut(User user,int number){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;

        try {
            conn = dbmanage.initDB();
            sta = conn.createStatement();
            String sql = "UPDATE  userTable SET user_peanut= user_peanut+'"
                    + number + "' WHERE user_id= " + user.getUserId();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta, conn);
        }
    }

}
