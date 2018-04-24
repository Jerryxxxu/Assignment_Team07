<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/21
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SharingNotes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
    <div class="w3-bar w3-dark-grey w3-wide w3-padding w3-card ">
        <a href="dashboard.jsp" class="w3-bar-item  w3-button fa fa-home" style="font-size: 25px">Home</a>
        <a href="#" class="w3-bar-item  w3-button">${welcome}</a>
        <div class="w3-right w3-hide-small">
            <a href="#" class="w3-bar-item w3-button">Upload</a>
            <a href="#" class="w3-bar-item w3-button">My Notes</a>
            <a href="#" class="w3-bar-item w3-button material-icons">menu</a>

        </div>
    </div>
</div>

<!-- header -->
<div class="w3-container ">
    <div class="w3-display-container w3-text-ligth-grey w3-tangerine" align="center">
        <img src="https://www.affairscloud.com/assets/uploads/2015/11/Note-Sharing.jpg" class="w3-rectangle" alt="SharingNotes" align="w3-display-middle" style="margin-top: 100px;margin-bottom: 50px">
        <div class="w3-display-middle w3-jumbo"></div>
    </div>
</div>
<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
    <section class="w3-container">

        <table class="w3-table w3-striped w3-bordered w3-card-4">
            <thead>
            <tr class="w3-teal">
                <th>Type</th>
                <th>Title </th>
                <th>Number of Pages</th>
                <th>Submitter</th>
                <th>Download Times</th>
                <th>Time</th>
            </tr>
            </thead>
            <tr>
                <td><img src="https://optionalpha.com/wp-content/uploads/2015/05/filetype_documents-011.png" style="width: 50px;height: 50px"></td>
                <td><a href="#">Intelligent Web</a></td>
                <td>5</td>
                <td>Sakine</td>
                <td>20</td>
                <td>2 minutes ago</td>
            </tr>
            <tr>
                <td><img src="https://optionalpha.com/wp-content/uploads/2015/05/filetype_documents-011.png" style="width: 50px;height: 50px"></td>
                <td><a href="#">Cloud Computing</a></td>
                <td>10</td>
                <td>Jerry</td>
                <td>100</td>
                <td>3 minutes ago</td>
            </tr>
            <tr>
                <td><img src="https://i1.wp.com/ectdtips.com/wp-content/uploads/2011/04/word.jpg" style="width: 50px;height: 50px"></td>
                <td><a href="#">Genesys</a></td>
                <td>5</td>
                <td>Lucky</td>
                <td>20</td>
                <td>4 minutes ago</td>
            </tr>
            <tr>
                <td><img src="https://i1.wp.com/ectdtips.com/wp-content/uploads/2011/04/word.jpg" style="width: 50px;height: 50px"></td>
                <td><a href="#">Hardware and Software Verification</a></td>
                <td>5</td>
                <td>Stefan</td>
                <td>20</td>
                <td>5 minutes ago</td>
            </tr>
        </table>
        <br>
        <br>

        <button class="w3-button w3-red" style="margin-left: 20px;" onclick="window.location.href='uploadNotes.jsp'">Upload</button>
        <br>
        <br>
    </section>
</div>

</body>
</html>
