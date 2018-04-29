package com.userdao;

import com.user.Transaction;
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
            String sql = "SELECT * FROM usertable WHERE user_name = '"
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
            String sql = "SELECT * FROM usertable WHERE user_name = '"
                    + userName + "' AND user_password= '" + userPassword + "'";
            rs = sta.executeQuery(sql);
            while(rs.next()){
                user=new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserPeanuts(rs.getInt("user_peanut"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return user;
    }

    public User queryUserPeanut(String username){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        User user=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM usertable WHERE user_name = '" + username + "'";
            rs = sta.executeQuery(sql);
            while(rs.next()){
                user=new User();
                user.setUserId(rs.getInt("user_id"));
                user.setRole(rs.getString("user_role"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPeanuts(rs.getInt("user_peanut"));
                System.out.println(user.getUserPeanuts());

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
        Statement sta=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            int newUserPeanut=user.getUserPeanuts()+number;
            String sql = "UPDATE usertable SET user_peanut='" +newUserPeanut + "' WHERE user_name = '" + user.getUserName() + "'";
            System.out.println(sql);
            sta.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
    }
    public void updateUserPeanut(User user,int number){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            //int newUserPeanut=user.getUserPeanuts()+number;
            String sql = "UPDATE usertable SET user_peanut='" +number + "' WHERE user_name = '" + user.getUserName() + "'";
            System.out.println(sql);
            sta.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
    }

    public void updateTransaction(String sender,String receiver,int peanuts,String title){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;


        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "INSERT INTO transactiontable (transaction_sender,transaction_peanuts,transaction_receiver,transaction_content)VALUES('"
                    +sender+"',"
                    +peanuts+",'"
                    +receiver+"','"
                    +title+"')";
            sta.executeUpdate(sql);
            System.out.println(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
    }

    public ArrayList<Transaction> queryAllTransaction(String sender) {
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs=null;
        ArrayList<Transaction> list=new ArrayList<Transaction>();

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM transactiontable WHERE transaction_sender = '"
                    + sender + "'";
            rs=sta.executeQuery(sql);

            while(rs.next()){
                Transaction transaction =new Transaction();

                transaction.setTransactionSender(rs.getString("transaction_sender"));
                transaction.setTransactionPeanuts(rs.getInt("transaction_peanuts"));
                transaction.setTransactionContent(rs.getString("transaction_content"));
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setTransactionReceiver(rs.getString("transaction_receiver"));

                list.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
        return list;
    }


}
