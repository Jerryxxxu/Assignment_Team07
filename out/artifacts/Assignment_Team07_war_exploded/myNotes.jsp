<%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 25/04/2018
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.user.Note" %>
<%@ page import="java.util.ArrayList" %>

<% ArrayList<Note> list = (ArrayList<Note>)(request.getAttribute("list")); %>

<html>
<head>
    <title>SharingNotes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <script type="text/javascript">

        function checkAll(){
            var checkobj = document.getElementsByName("num");
            for(var i = 0 ; i<checkobj.length ; i++){

                checkobj[i].checked = "checked";
            }

        }
        function Nocheck(){
            var checkobj = document.getElementsByName("num");
            for(var i = 0 ; i<checkobj.length ; i++){

                checkobj[i].checked = !checkobj[i].checked ;
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
    </div>
</div>

<!-- header -->
<div class="w3-container ">
    <div class="w3-display-container w3-text-ligth-grey w3-tangerine" align="center">
        <img src="images/note_sharing.jpg" class="w3-rectangle" alt="SharingNotes" align="w3-display-middle" style="margin-top: 100px;margin-bottom: 50px">
        <div class="w3-display-middle w3-jumbo"></div>
    </div>
</div>
<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">
    <section class="w3-container">
        <form action="NoteDelete" method="post">
        <table class="w3-table w3-striped w3-bordered w3-card-4">
            <thead>
            <tr class="w3-teal">
                <th></th>
                <th>Type</th>
                <th>Title </th>
                <th>Number of Pages</th>
                <th>Submitter</th>
                <th>Download Times</th>
                <th>Time</th>
                <th colspan="2"></th>
            </tr>
            </thead>



            <%for(int i = 0 ; i<list.size();i++) {

                Note note = list.get(i);%>
            <tr align="center" >
                <td><input type = "checkbox"  value ='<%=note.getNoteId() %>' name="num"/></td>
                <td><%=note.getNoteType() %></td>
                <td><%=note.getNoteTitle() %></td>
                <td><%=note.getNoteNumberOfPages() %></td>
                <td><%=note.getNoteSubmitter()%></td>
                <td><%=note.getNoteDownloadTimes()%></td>
                <td><%=note.getNoteSubmittingTime()%></td>
                <td><a href="NoteDelete?noteId=<%=note.getNoteId() %>">delete</a></td>
                <td><a href="NoteUpdate?noteId=<%=note.getNoteId() %>">edit</a></td>
            </tr>
            <%
                }
            %>
        </table>

        <br>
        <br>
            <input type="button" value="checkall" style="margin-left: 20px;" name="checkall" id = "checkall" onclick="checkAll()">
            <input type="button" value="uncheckall" style="margin-left: 20px;" name="nocheck" id = "nocheck" onclick="Nocheck()">
            <<input type="submit" value="delete all">
        </form>
        <br>
        <br>
    </section>
</div>

</body>
</html>
