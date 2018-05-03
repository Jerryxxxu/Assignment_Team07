import com.user.Event;
import com.user.User;
import com.userdao.StudyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class createEvent
 */
@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String String = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");

        String username=user.getUserName();
        StudyDao studydao=new StudyDao();

        String eventName = request.getParameter("Title");
        String eventPlace=request.getParameter("Place");
        String eventDate=request.getParameter("Date");
        String eventPrice= request.getParameter("Price");
        String eventTime= request.getParameter("Time");
        String people= request.getParameter("People to attend");

        //check
        if(studydao.insertEvent(eventName,eventPlace,eventDate,eventPrice, eventTime,people,username)) {

            ArrayList<Event> list=studydao.selectEvents();

            request.setAttribute("user",user);
            request.setAttribute("list", list);
            request.getRequestDispatcher("EventManagement.jsp").forward(request, response);
        }else {
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>" +
                    "alert('You peanuts are not enough for creating Study Group!');" +
                    "window.location.href='EventManagement.jsp';" +
                    "</script>");
        }
    }

}

