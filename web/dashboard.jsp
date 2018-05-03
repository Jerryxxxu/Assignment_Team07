<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Dashboard</title>
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
<!-- header -->
<header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
    <img class="w3-image" src="images/cloud.jpg" alt="cloud"height="500px" style="padding-top: 90px;padding-left: 120px;width: 50%;">
    <div class="w3-display-middle w3-margin-top w3-center" style="width: 50%;margin-left: 300px">
        <h1 class="w3-xxlarge w3-text-white"><span class="w3-padding w3-black w3-opacity-min"><b>Cloud</b></span> <span class="w3-hide-small w3-text-light-grey" >Base</span></h1>
    </div>
</header>

<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

    <!-- Project Section -->
    <div class="w3-container w3-padding-32" id="apps">
        <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Apps</h3>
    </div>

    <div class="w3-row-padding">
        <div class="w3-col l3 m6 w3-margin-bottom">
            <div class="w3-display-container">
                <div class="w3-display-topleft w3-black w3-padding">
                    <a href="QuestionIndex" class="w3-bar-item w3-button">QuestionSolver</a></div>
                <img  src="images/questionSolver.png" alt="QuestionSolver" style="width: 200px;height:200px;margin: 20px;">
            </div>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <div class="w3-display-container">
                <div class="w3-display-topleft w3-black w3-padding">
                    <a href="NoteIndex" class="w3-bar-item w3-button">SharingNotes</a></div>
                <img src="images/sharingNotes.png" alt="SharingNotes" style="width:200px;height:200px;margin: 20px;">
            </div>
        </div>
        <div class="w3-col l3 m6 w3-margin-bottom">
            <div class="w3-display-container">
                <div class="w3-display-topleft w3-black w3-padding">
                    <a href="StudyIndex" class="w3-bar-item w3-button">EventStudy</a></div>
                <img src="images/study.jpg" alt="EventStudy" style="width:200px;height:200px;margin: 20px;">
            </div>
        </div>

    </div>
</div>

</body>
</html>