<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/4/21
  Time: 20:39
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



            <%for(int i = 0 ; i<list.size();i++) {

                Note note = list.get(i);
            %>

            <tr align="center" >
                <% if (note.getNoteType().equals("application/pdf") ){
                %>
                <td><a href="javascript:payDownloadPeanuts(<%=note.getNoteDownloadPeanuts() %>,<%=note.getNoteId()%>)"><img src="images/pdf.png" alt="" style="width: 50px;height: 50px"></a></td><%}
            else if(note.getNoteType().equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")){
            %>
                <td><a href="NoteDownload?id=<%=note.getNoteId() %>"><img src="images/word.jpg" alt="" style="width: 50px;height: 50px"></a></td><%
            }
            else if(note.getNoteType().equals("image/jpeg")){
            %>
                <td><a href="NoteDownload?id=<%=note.getNoteId() %>"><img src="images/image.jpeg" alt="" style="width: 50px;height: 50px"></a></td><%
            }

            else if(note.getNoteType().equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")){
            %>
                <td><a href="NoteDownload?id=<%=note.getNoteId() %>"><img src="images/ppt.png" alt="" style="width: 50px;height: 50px"></a></td><%
            }
            else if(note.getNoteType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            %>
                <td><a href="NoteDownload?id=<%=note.getNoteId() %>"><img src="images/xls.jpg" alt="" style="width: 50px;height: 50px"></a></td><%
                }
                else{}
            %>
                <td><a href="NoteView?noteId=<%=note.getNoteId() %>"><%=note.getNoteTitle() %></a></td>
                <td><%=note.getNoteNumberOfPages()%></td>
                <td><%=note.getNoteSubmitter()%></td>
                <td><%=note.getNoteDownloadTimes()%></td>
                <td><%=note.getNoteSubmittingTime()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <br>

        <button class="w3-button w3-red" onclick="window.location.href='uploadNotes.jsp'">Upload</button>
        <br>
        <br>
    </section>
</div>

</body>
</html>
