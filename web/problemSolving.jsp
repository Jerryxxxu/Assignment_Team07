<%@ page import="com.user.User" %>
<%@ page import="com.userdao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/21
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Problem and solving</title>
    <meta charset="utf-8"/>
    <meta  name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <style>
        a.ex1
        {
            margin-left:10cm;
        }
    </style>
    <style>
        .w3-tangerine {
            font-family: "Tangerine", serif;
        }
    </style>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if(user!=null){
        String uname = user.getUserName();
        UserDao ud = new UserDao();
        User user1 = ud.queryUserPeanut(uname);
        session.setAttribute("user1",user1);
    }else{
        response.sendRedirect("login.jsp");
        return;
    }
%>
<div class="">
    <div class="w3-bar w3-light-grey">
        <a href="dashboard.jsp" class="w3-bar-item w3-large w3-button ">Home</a>
        <a class="w3-bar-item w3-text w3-text-pink w3-large w3-tangerine">Welcome ${user.userName}!</a>
        <a class="ex1 w3-bar-item w3-large w3-button"></a>
        <div class="w3-dropdown-hover">
            <button class="w3-button w3-large">Peanuts ${user1.userPeanuts}
            </button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <a class="w3-bar-item w3-button w3-large">My Status</a>
                <a class="w3-bar-item w3-button w3-large">Submitted Problem </a>
                <a class="w3-bar-item w3-button w3-large">Reply Answer</a>
            </div>
        </div>
        <a class="ex2 w3-bar-item w3-button w3-large" href="UserLogout">Logout</a>
    </div>
    <div class="w3-container w3-text-black">
        <div class="w3-display-container w3-text-black w3-tangerine"align="center">
            <img src="http://img3.imgtn.bdimg.com/it/u=3111526370,1353314867&fm=11&gp=0.jpg" class="w3-circle" alt="Norway" align="middle"  style="width:100%;height:6.5cm">
            <div class="w3-display-middle w3-jumbo">Problem and Solving</div>
        </div>
        <div class="w3-large">Question Lists:</div>
    </div>
    <div class="w3-container">
        <div class="w3-panel w3-pale-blue w3-leftbar w3-rightbar w3-border-blue">
            <div class="w3-text w3-large">QUESTION :</div>
            <c:forEach var="ql" items="${questionlist}">
                <div class="w3-text w3-text-red w3-large"><a href="QuestionReply?methodname=queryReply&questionid=${ql.questionId}">${ql.questionInfo }</a></div>
                <div class="w3-text w3-text-brown">Post by ${ql.questionUsername} at ${ql.questiontime }.</div>
            </c:forEach>

        </div>

    </div>
    <form action="QuestionReply" method="post">
        <input type="hidden" name="methodname" value="addQuestion">
        <div class="w3-container">
            <div class="w3-large">Your Question</div>
            <div class="w3-left-align "><p><input type="text" name="questionInfo"/></p></div>
        </div>

        <p>
            <input class="w3-button w3-black w3-round-large" type="submit" value="Submit"/>
    </form>
</div>

</body>
</html>
