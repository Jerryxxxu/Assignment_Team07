package com.userdao;

import com.user.Booking;
import com.user.Event;
import com.userdao.Dbmanage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudyDao {
    public int bookEvent(int eventID, String username) {
        int flag = -1;
        Dbmanage dbmanage=new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs = null;
        try {
            conn=dbmanage.initDB();
            sta = conn.createStatement();
            //check user's booking
            String query = "SELECT eventid FROM booking where username='" + username +"';";
            rs = sta.executeQuery(query);

            List<Integer> list = new ArrayList<Integer>();

            // checking if ResultSet is empty
            if (rs.next() == false)
            {
                flag = bookAndUpdateTable(username,eventID);
                System.out.println("This is first time booking of this user" );
                return flag;

            }else{
                do{
                    int qResult = Integer.parseInt(rs.getString("eventid"));
                    System.out.println("qresult: " + qResult + "event id: " + eventID);
                    list.add(qResult);
                } while (rs.next());
            }

            if(!list.contains(eventID)){
                System.out.println(eventID + ", Event is not exist" );
                flag = bookAndUpdateTable(username,eventID);
            }else{
                flag = 1;
                System.out.println(eventID + ", Event is exist" );
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
    public int bookAndUpdateTable(String username, int eventID){
        int flag = -1;
        Dbmanage dbmanage=new Dbmanage();
        Connection conn = null;
        Statement sta=null;

        try{
            conn=dbmanage.initDB();
            sta= conn.createStatement();
            //get user data from users table
            String query = "SELECT user_peanut FROM usertable where user_name='" + username +"';";
            ResultSet rs = sta.executeQuery(query);
            rs.next();
            int peanut = rs.getInt("user_peanut");

            //get event data from events table
            query = "SELECT eventName,place,date,time,peopleToAttend,price FROM events where id='" + eventID +"';";
            rs = sta.executeQuery(query);
            rs.next();
            String ename = rs.getString("eventName");
            String people2Attend = rs.getString("peopleToAttend");
            String place = rs.getString("place");
            String date = rs.getString("date");
            String time = rs.getString("time");
            String price = rs.getString("price");

            boolean priceSuitable = false;
            boolean peopleSuitable = false;

            //Check people to attend
            if(Integer.parseInt(people2Attend) > 0){
                peopleSuitable = true;
            }else{
                return 3;
            }

            //check amount of peanut
            if(peanut >=5){
                priceSuitable = true;
            }else{
                return 2;
            }

            if(priceSuitable && peopleSuitable){

                //Update events table to peopleToAttend col
                int result = Integer.parseInt(people2Attend)-1;
                query = "UPDATE events " + "SET peopleToAttend ="+String.valueOf(result)+" WHERE id in ("+eventID+")";
                sta.executeUpdate(query);

                //make payment
//                if(PaymentSystem.doPayment(userID,price,peanut,userType,AppNames.EventStudy,session)){
//                    flag = 0;
//
//                }

                //Insert into booking table
                query = "insert into booking (username,eventid,eventname,place,date,time) " +
                        "Values ('" + username + "','" + eventID + "',  '" + ename + "','"+place+"','"+date+"','"+time+"');";
                sta.executeUpdate(query);
                flag = 0;
            }

        }catch (Exception e){
        }
        return flag;
    }

    public ArrayList<Booking> selectMyBooking(String username){
        Dbmanage dbmanage=new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        ResultSet rs = null;
        Booking booking =new Booking();
        ArrayList<Booking> list = new ArrayList<Booking>();
        try {
            conn=dbmanage.initDB();
            sta = conn.createStatement();
            String query = "select * from booking where username='" + username+"';";
            rs=sta.executeQuery(query);

            while (rs.next()){
                booking=new Booking();

                booking.setEventId(rs.getInt("eventid"));
                booking.setId(rs.getInt("id"));
                booking.setEventName(rs.getString("eventname"));
                booking.setPlace(rs.getString("place"));
                booking.setTime(rs.getString("time"));
                booking.setDate(rs.getString("date"));
                booking.setUsername(rs.getString("username"));

                list.add(booking);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return list;
    }
    public void deleteEvent(int eventID) {

        Dbmanage dbmanage=new Dbmanage();
        Connection conn = null;
        Statement sta=null;
        try {
            conn=dbmanage.initDB();
            sta = conn.createStatement();
            String query = "DELETE FROM events where id = '" + eventID +"';";
            sta.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }
    }
    public ArrayList<Event> selectEvents(){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        Event event = null;
        ArrayList<Event> list = new ArrayList<Event>();

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM events";
            rs=sta.executeQuery(sql);
            while (rs.next()){
                event=new Event();

                event.setEventId(rs.getInt("id"));
                event.setEventName(rs.getString("eventName"));
                event.setPlace(rs.getString("place"));
                event.setDate(rs.getString("date"));
                event.setTime(rs.getString("time"));
                event.setPeopleToAttend(rs.getString("peopleToAttend"));
                event.setPrice(rs.getString("price"));
                event.setOrganizer(rs.getString("organiser"));
                list.add(event);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return list;

    }
    public ArrayList<Event> selectUserEvents(String organiser){
        Dbmanage dbmanage = new Dbmanage();
        Connection conn = null;
        Statement sta = null;
        ResultSet rs = null;
        Event event = null;
        ArrayList<Event> list = new ArrayList<Event>();

        try {
            conn=dbmanage.initDB();
            sta=conn.createStatement();
            String sql = "SELECT * FROM events where organiser='" + organiser +"';";
            rs=sta.executeQuery(sql);
            while (rs.next()){
                event=new Event();

                event.setEventId(rs.getInt("id"));
                event.setEventName(rs.getString("eventName"));
                event.setPlace(rs.getString("place"));
                event.setDate(rs.getString("date"));
                event.setTime(rs.getString("time"));
                event.setPeopleToAttend(rs.getString("peopleToAttend"));
                event.setPrice(rs.getString("price"));
                event.setOrganizer(rs.getString("organiser"));
                list.add(event);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(rs,sta,conn);
        }
        return list;

    }
    public boolean insertEvent(String eventName, String eventPlace, String eventDate, String eventPrice
            , String eventTime, String people, String username) {

        boolean flag=false;
        Dbmanage dbmanage=new Dbmanage();
        Connection conn = null;
        Statement sta=null;

        try {
            conn=dbmanage.initDB();
            sta = conn.createStatement();
            String query2 = "SELECT user_peanut FROM usertable where user_name='" + username +"';";
            ResultSet rs = sta.executeQuery(query2);
            rs.next();
            int peanut = rs.getInt("user_peanut");

            if(peanut>=5) {
                String query = "insert into events (eventName, place, date, time, peopleToAttend, price,organiser) " +
                        "Values ('" + eventName + "','" + eventPlace + "','" + eventDate + "', '" +
                        eventTime + "',  '" + people + "', '" + eventPrice + "' , " +
                        "'" + username + "');";
                sta.executeUpdate(query);

//                PaymentSystem.doPayment(userID,"",peanut,userType,AppNames.EventStudy,session);
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(sta,conn);
        }

        return flag;
    }
}
