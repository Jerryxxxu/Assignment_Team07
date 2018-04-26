<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/26
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Top Up</title>
</head>
<body>
<h1>Enter the number of peanuts you want to top up</h1>
<form method="post" action="UserPeanutTopUp">
    <table border="0">
        <tr>
            <td>Enter the nubmer:</td>
            <td><input type="text" name="numberOfPeanuts" size="50"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Top Up">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
