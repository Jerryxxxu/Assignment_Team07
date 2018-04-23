<%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 22/04/2018
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>File Upload to Database Demo</h1>
    <form method="post" action="NoteUpload" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>Note Title: </td>
                <td><input type="text" name="noteTitle" size="50"/></td>
            </tr>
            <tr>
                <td>Notes: </td>
                <td><input type="file" name="noteFile" size="50"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
