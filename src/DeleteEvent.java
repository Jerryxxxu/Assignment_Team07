import com.user.Event;
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

/**
 * Servlet implementation class createEvent
 */
@WebServlet("/DeleteEvent")
public class DeleteEvent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String String = null;

    public DeleteEvent() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int eventID = Integer.parseInt(request.getParameter("Id"));
        User user = (User)session.getAttribute("user");

        StudyDao studydao=new StudyDao();
        studydao.deleteEvent(eventID);

        ArrayList<Event> list=studydao.selectEvents();
        request.setAttribute("list", list);
        request.setAttribute("user",user);
        request.getRequestDispatcher("ShowMyEvents.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}

