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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>


<!-- Navbar (sit on top) -->
<div class="w3-top">
    <div class="w3-bar w3-dark-grey w3-wide w3-padding w3-card">
        <a href="dashboard.jsp" class="w3-bar-item w3-button">Home</a>
        <!-- Float links to the right. Hide them on small screens -->
        <div class="w3-right w3-hide-small">
            <a href="UserLogout" class="w3-bar-item w3-button">Logout</a>
            <a href="UserAccount" class="w3-bar-item w3-button">Account</a>
        </div>
    </div>
</div>

<div class="w3-content" style="max-width:1564px;padding-top: 140px" >
    <section class="w3-container">

        <table class="w3-table w3-striped w3-bordered w3-card-4" >
            <thead>
            <tr class="w3-teal">
                <th>Enter the number of peanuts you want to top up:</th>
            </tr>
            </thead>
            <form action="UserPeanutTopUp" method="post">
            <tr align="center" >
                <td><input type="text" name="numberOfPeanuts" size="50"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" class="w3-red" value="top up">
                </td>
            </tr>
            </form>
        </table>
        <br>
        <br>
    </section>
</div>
</body>
</html>
