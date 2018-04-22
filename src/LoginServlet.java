import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
}}


//        String info="";
//
//        response.setContentType("text/html");
//        PrintWriter out= response.getWriter();
//
//
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//
//        DocumentBuilder db = null;
//        try {
//            db = dbf.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//
//        Document doc = null;
//        ServletContext context=getServletContext();
//        URL resourceUrl=context.getResource("/WEB-INF/users.xml");
//        try {
//            doc = db.parse(String.valueOf(resourceUrl));
//
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//
//        NodeList id = doc.getElementsByTagName("id");
//        NodeList UserName = doc.getElementsByTagName("username");
//        NodeList Password = doc.getElementsByTagName("password");
//
//        int i;
//        for(i=0;i<=id.getLength()-1;i++)
//        {
//            if((UserName.item(i).getFirstChild().getNodeValue().equals(username))&& Password.item(i).getFirstChild().getNodeValue().equals(password))
//            {
//                info="Welcome"+" "+username+"!";
//                request.setAttribute("info1", info);
//                request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
//            }
//
//        }
//
//        out.println("<html><body><br>");
//        out.println("Sorry!! There is no valid username or password.</br>");
//        out.println("<br>Create New Account</br>");
//        out.println("<form action=\"/Assignment_Team07/show\" method=\"post\" >");
//        out.println("Username: <input type=\"text\" name=\"name\">");
//        out.println("Password: <input type=\"password\" name=\"password\">");
//        out.println("<input type=\"Submit\" value=\"Sign in\">");
//        /*for(i=0;i<=id.getLength()-1;i++)
//        {
//
//            out.println("<p>" + UserName.item(i).getFirstChild().getNodeValue()+ "</p>");
//
//        }*/
//        out.println("</form>");
//        out.println("</body></html>");
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//    }