<%--
  Created by IntelliJ IDEA.
  User: Zeyad
  Date: 4/26/2018
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page import="com.user.User" %>
<%@ page import="com.user.Event" %>
<%@ page import="java.util.ArrayList" %>
<link rel="stylesheet" type="text/css" href="css\eventList.css">
<link rel="stylesheet" type="text/css" href="css\EventListSearch.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<% User user = (User) request.getAttribute("user"); %>
<% ArrayList<Event> list = (ArrayList<Event>)(request.getAttribute("list")); %>

<% if (user.getUserName() == null) { %>
<div id="myDiv" class="w3-top">
    <div class="w3-bar w3-white w3-padding w3-card myDiv2" style="letter-spacing:4px;">
        <a href="index.jsp" class="w3-bar-item w3-button">Login</a>
        <!-- Right-sided navbar links. Hide them on small screens -->
        <div class="w3-right w3-hide-small">
            <a href="login.jsp" class="w3-bar-item w3-button">Applications</a>
            <a href="EventManagement.jsp" class="w3-bar-item w3-button">Event Studies</a>
        </div>
    </div>
</div>
<% } else {%>
<div id="myDiv" class="w3-top">
    <div class="w3-bar w3-white w3-padding w3-card myDiv2" style="letter-spacing:4px;">
        <a id="homePage"  href="StudyIndex" class="w3-bar-item w3-button">Welcome <%=user.getUserName()%></a>
        <!-- Right-sided navbar links. Hide them on small screens -->
        <div class="w3-right w3-hide-small">
            <a href="StudyIndex" class="w3-bar-item w3-button">Event Studies</a>
            <a href="UserLogout" class="w3-bar-item w3-button">Log out</a>
        </div>
    </div>
</div>
<% } %>

<br><br><br>
<body>
<form class="example" action="">
    <input type="text" placeholder="Search Study Group.." id="search">
    <!--<button type="submit"><i class="fa fa-search"></i></button>-->
</form>

<section>
    <!--for demo wrap-->
    <h1><%=user.getUserName()%> Study List</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>Study Title</th>
                <th>Study Place</th>
                <th>Study Date</th>
                <th>Study Time</th>
                <th>People to Attend</th>
                <th>Study Price</th>
                <th>User</th>
                <th>Delete</th>
            </tr>
            </thead>
        </table>
    </div>

    <div class="tbl-content">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            // Write on keyup event of keyword input element
            $("#search").keyup(function(){
                _this = this;
                // Show only matching TR, hide rest of them
                $.each($("#ShowMyEvents tbody").find("tr"), function() {
                   if($(this).find('td').text().toLowerCase().indexOf($(_this).val().toLowerCase()) == -1)
                        $(this).hide();
                    else
                        $(this).show();
                });
            });
        </script>
        <table cellpadding="0" cellspacing="0" border="0" id="ShowMyEvents">
            <tbody>

            <%for(int i = 0 ; i<list.size();i++) {

                Event event = list.get(i);
            %>
            <tr>
                <td><%=event.getEventName()%></td>
                <td><%=event.getPlace()%></td>
                <td><%=event.getDate()%></td>
                <td><%=event.getTime()%></td>
                <td><%=event.getPeopleToAttend()%></td>
                <td><%=event.getPeopleToAttend()%></td>
                <td><%=event.getOrganizer()%></td>
                <td><a href="DeleteEvent?Id=<%=event.getEventId() %>" class="button2">Delete</a></td>
                <%
                    }
                %>
            </tr>
            </tbody>
        </table>
    </div>


</section>
</body>