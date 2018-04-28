<%@ page import="com.user.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.user.Transaction" %><%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/26
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getAttribute("user"); %>
<% ArrayList<Transaction> list= (ArrayList<Transaction>) request.getAttribute("list"); %>
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

<div class="w3-content w3-padding" style="max-width:1564px">
    <section class="w3-container">

        <table class="w3-table w3-striped w3-bordered w3-card-4">
            <thead>
            <tr class="w3-teal">
                <th>Receiver</th>
                <th>Content</th>
                <th>Peanuts</th>

            </tr>
            </thead>



            <%for(int i = 0 ; i<list.size();i++) {

                Transaction transaction = list.get(i);%>

            <tr align="center" >
                <td><%=transaction.getTransactionReceiver() %></td>
                <td><%=transaction.getTransactionContent()%></td>
                <td><%=transaction.setTransactionPeanuts()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <br>

        <button class="w3-button w3-red" style="margin-left: 20px;" onclick="window.location.href='peanutTopUp.jsp'">Top up</button>
        <br>
        <br>
    </section>
</div>


</body>
</html>