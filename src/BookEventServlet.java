import com.user.User;
import com.userdao.Dbmanage;
import com.userdao.StudyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class BookEventServlet
 */
@WebServlet("/BookEventServlet")
public class BookEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String String = null;

    public BookEventServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String username=user.getUserName();

        int eventID = Integer.parseInt(request.getParameter("Id"));

        //try to book event
        StudyDao studydao=new StudyDao();
        int r = studydao.bookEvent(eventID,username);

        if(r == 0){
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>" +
                    "alert('You booked an Study Group and your payment is successful !');" +
                    "window.location.href='StudyIndex';" +
                    "</script>");
        }else if(r == 1){
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>" +
                    "alert('You already booked this Study Group!');" +
                    "window.location.href='StudyIndex';" +
                    "</script>");
        }else if(r == 2){
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>" +
                    "alert('You peanuts are not enough for this Study Group!');" +
                    "window.location.href='StudyIndex';" +
                    "</script>");
        }else if(r == 3){
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>" +
                    "alert('You can not attend this Study Group!');" +
                    "window.location.href='StudyIndex';" +
                    "</script>");
        }else{
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>" +
                    "alert('we could not to service to you, Sorry !!');" +
                    "window.location.href='StudyIndex';" +
                    "</script>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

