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
    <title>Upload Notes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style>
        .button {
            background-color: teal;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
        p {
            font-family: "Times New Roman", Times, serif;
            font-size: 20px;
        }
        h2{
            font-family: "Times New Roman", Times, serif;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div class="w3-top">
    <div class="w3-bar w3-dark-grey w3-wide w3-padding w3-card ">
        <a href="dashboard.jsp" class="w3-bar-item  w3-button fa fa-home" style="font-size: 25px">Home</a>
        <a href="#" class="w3-bar-item  w3-button">${welcome}</a>
        <div class="w3-right w3-hide-small">
            <a href="#" class="w3-bar-item w3-button">Upload</a>
            <a href="UserNoteList" class="w3-bar-item w3-button">My Notes</a>
            <a href="#" class="w3-bar-item w3-button material-icons">menu</a>

        </div>
    </div>
</div>
<div class="w3-content " style="max-width:1000px;padding-top: 140px">
    <section class="w3-container" >

        <form action="NoteUpload" method="post" enctype="multipart/form-data">
            <table class="w3-table w3-bordered w3-card-4" width="300px" bgcolor="#f2f2f2">
                <thead>
                <tr class="w3-teal">
                    <th  height="100px" style="text-align: center"  > <h2>File Upload to Database Demo </h2></th>
                </tr>
                </thead>
                <tr>
                    <td ><p >Title </p> <input style="padding-right: 10px" type="text" name="noteTitle" size="100"/></td>
                </tr>
                <tr>
                    <td ><p >How many Pages? </p> <input style="padding-right: 10px" type="text" name="noteNumberOfPages" size="100"/></td>
                </tr>
                <tr>
                    <td >
                        <p >Please write a short description about your note: </p>
                        <input type="textarea" name="noteDescription" size="100" style="height: 200px; padding-right: 10px;"/>
                    </td>
                </tr>

                <tr>
                    <td ><p>Upload your notes </p> <input style="padding-right: 10px" type="file" name="noteFile" size="100"/></td>
                </tr>
                <tr>
                    <td ><p>Peanuts you want </p> <input style="padding-right: 10px" type="text" name="downloadPeanuts" size="100"/></td>
                </tr>
                <tr>
                    <td ><input type="submit" class="button" align="right"  value="Upload"></td>
                </tr>
            </table>
            <br>
            <br>
        </form>
        <br>
        <br>
    </section>
</div>
</body>
</html>
