<%@ page import="com.user.Note" %><%--
  Created by IntelliJ IDEA.
  User: sakin
  Date: 26/04/2018
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Note note = (Note) request.getAttribute("note"); %>
<html>

<head>

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

    <title>Note Details</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script>
        function payDownloadPeanuts(downloadPeanuts,noteId){
            if (confirm("Are you sure to pay "+downloadPeanuts+" peanuts to the author for downloading?")){
                window.location.href="NoteDownload?id="+noteId;
            }else {
                return false;
            }
        }
    </script>
</head>
<body>

<!-- Navbar (sit on top) -->
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

<div class="w3-content" style="max-width:1000px;padding-top: 140px">
    <section class="w3-container" >

        <form action="NoteDelete" method="post">
            <table class="w3-table w3-striped w3-bordered w3-card-4" width="300px">
                <thead>
                <tr class="w3-teal">
                    <th  height="100px" style="text-align: center"  > <h2> <%=note.getNoteTitle()%> </h2></th>

                </tr>
                </thead>

                <tr>
                    <td height="500px">
                        <p style="margin: 50px">
                           <%=note.getNoteDescription()%>
                        </p>

                    </td>
                </tr>

                <tr>
                    <td> <p>
                        Page Number : <%=note.getNoteNumberOfPages()%>  &nbsp; &nbsp; &nbsp; Peanut Number : <%=note.getNoteDownloadPeanuts()%> </p>
                    </td>

                </tr>

            </table>

            <br>
            <br>

            <input type="button" class="button"  value="Download" onclick="javascript:payDownloadPeanuts(<%=note.getNoteDownloadPeanuts() %>,<%=note.getNoteId()%>)">
            <input type="button" class="button" value="Back" onclick="window.location.href='NoteIndex'">
        </form>
        <br>
        <br>
    </section>
</div>

</body>
</html>


