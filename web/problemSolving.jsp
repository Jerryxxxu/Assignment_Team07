<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/21
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
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
<div class="w3-top">
    <div class="w3-bar w3-light-grey">
        <a href="dashboard.jsp" class="w3-bar-item w3-large w3-button ">Home</a>
        <a class="w3-bar-item w3-text w3-text-pink w3-large w3-tangerine">Welcome Stefan!</a>
        <a class="ex1 w3-bar-item w3-large w3-button">UserName</a>
        <div class="w3-dropdown-hover">
            <button class="w3-button w3-large">Account</button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
                <a class="w3-bar-item w3-button w3-large">My Status</a>
                <a class="w3-bar-item w3-button w3-large">Submitted Problem </a>
                <a class="w3-bar-item w3-button w3-large">Reply Answer</a>
            </div>
        </div>
        <a class="ex2 w3-bar-item w3-button w3-large">Logout</a>
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
            <div class="w3-text w3-large">QUESTION 1:</div>
            <div class="w3-text w3-text-red w3-large">Hello everyone, do you know how to use the HTML to change the text color?</div>
            <div class="w3-text w3-text-brown">Post by Stefan at 10 March 2018.</div>
            <p>
                <span class="w3-label w3-purple w3-round-xxlarge">Lucky</span>
            </p>
            <p>
                xxxxx
            </p>

            <p>
                <span class="w3-label w3-purple w3-round-xxlarge">Sakine</span>
            </p>
            <p>
                xxxxx
            </p>

        </div>

    </div>
    <div class="w3-container">
        <div class="w3-large">Your Question</div>
        <div class="w3-border w3-left-align "><p>How to learn the cloud computing better?</p></div>
    </div>

    <p><button class="w3-button w3-black w3-round-large">Submit</button></p>
</div>

</body>
</html>
