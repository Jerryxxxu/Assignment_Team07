import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class ShowUser extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        ServletContext context=getServletContext();
        URL resourceUrl=context.getResource("/WEB-INF/users.xml");
        try {
            document = documentBuilder.parse(String.valueOf(resourceUrl));
        } catch (SAXException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        NodeList idg = document.getElementsByTagName("id");

        Element newServer = document.createElement("user");

        Element id = document.createElement("id");
        id.appendChild(document.createTextNode(String.valueOf(idg.getLength()+1)));
        newServer.appendChild(id);

        Element name = document.createElement("username");
        name.appendChild(document.createTextNode(req.getParameter("name")));
        newServer.appendChild(name);

        Element port = document.createElement("password");
        port.appendChild(document.createTextNode(req.getParameter("password")));
        newServer.appendChild(port);

        root.appendChild(newServer);

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;

        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        StreamResult result = new StreamResult(String.valueOf(resourceUrl));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }
}
