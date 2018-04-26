<%@ page import="com.user.User" %><%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/26
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getAttribute("user"); %>
<html>
<title>My Account</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
    <div class="w3-bar w3-dark-grey w3-wide w3-padding w3-card">
        <a href="#home" class="w3-bar-item w3-button">CloudBase</a>
        <a href="#" class="w3-bar-item w3-button">${info}</a>
        <!-- Float links to the right. Hide them on small screens -->
        <div class="w3-right w3-hide-small">
            <a href="UserLogout" class="w3-bar-item w3-button">Logout</a>
            <a href="UserAccount" class="w3-bar-item w3-button">Account</a>
            <a href="#" class="w3-bar-item w3-button">Contact Us</a>
        </div>
    </div>
</div>

<div class="w3-padding-64"><h1>your current balance:<%=user.getUserPeanuts()%></h1></div>

<button class="w3-button w3-red" onclick="window.location.href='peanutTopUp.jsp'">Top Up</button>


</body>
</html>