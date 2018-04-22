import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@WebServlet(name = "checkLogin")
public class checkLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username= request.getParameter("name");
        String password= request.getParameter("password");
        String info="";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = null;
        try {
            doc = db.parse("/WEB-INF/users.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }

        NodeList id = doc.getElementsByTagName("id");
        NodeList UserName = doc.getElementsByTagName("username");
        NodeList Password = doc.getElementsByTagName("password");

        int i;
        for(i=0;i<=id.getLength()-1;i++)
        {
            if((UserName.equals(username))&& Password.equals(password))
            {
                info="Welcome"+" "+username+"!";
                request.setAttribute("info1", info);

            }
            else{

            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
