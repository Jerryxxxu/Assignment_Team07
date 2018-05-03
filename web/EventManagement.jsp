<%@ page import="java.sql.*" %>
<%@ page import="com.user.User" %>
<%@ page import="com.user.Event" %>
<%@ page import="java.util.ArrayList" %>
<link rel="stylesheet" type="text/css" href="css\eventList.css">
<link rel="stylesheet" type="text/css" href="css\EventListSearch.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<% User user = (User) request.getAttribute("user"); %>

<% ArrayList<Event> list = (ArrayList<Event>)(request.getAttribute("list")); %>

<% if (user.getUserName() == null) { %>
<div id="myDiv" class="w3-top">
	<div class="w3-bar w3-white w3-padding w3-card myDiv2" style="letter-spacing:4px;">
		<!-- Right-sided navbar links. Hide them on small screens -->
		<a href="index.jsp" class="w3-bar-item w3-button">Login</a>
		<div class="w3-right w3-hide-small">
			<a href="login.jsp" class="w3-bar-item w3-button">Applications</a>
			<a href="EventManagement.jsp" class="w3-bar-item w3-button">Event Studies</a>
		</div>
	</div>
</div>
<% } else {%>
<div id="myDiv" class="w3-top">
	<div class="w3-bar w3-white w3-padding w3-card myDiv2" style="letter-spacing:4px;">
		<a href="dashboard.jsp" class="w3-bar-item w3-button">Home</a>
		<a id="homePage"  href="#home" class="w3-bar-item w3-button">Welcome <%=user.getUserName()%></a>
		<!-- Right-sided navbar links. Hide them on small screens -->
		<div class="w3-right w3-hide-small">
			<%--<a href="login.jsp" class="w3-bar-item w3-button">Applications</a>--%>
			<a href="StudyIndex" class="w3-bar-item w3-button">Event Studies</a>
				<a href="#" class="w3-bar-item w3-button">Peanut: ${amountPeanut}</a>
			<a href="UserLogout" class="w3-bar-item w3-button">Log out</a>
		</div>
	</div>
</div>
<% } %>
<body>
<br><br><br>
<form class="example" action="">
	<input type="text" placeholder="Search Study Group.." id="search">
	<!--<button type="submit"><i class="fa fa-search"></i></button>-->
</form>

<section>
	<!--for demo wrap-->
	<h1>Study List</h1>
	<div class="tbl-header">
		<table cellpadding="0" cellspacing="0" border="0">
			<thead>
			<tr>
				<th>Study Title</th>
				<th>Study Place</th>
				<th>Study Date</th>
				<th>Study Time</th>
				<th>People To Attend</th>
				<th>Study Price</th>
				<th>Booking</th>
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
                $.each($("#table tbody").find("tr"), function() {
                    if($(this).find('td').text().toLowerCase().indexOf($(_this).val().toLowerCase()) == -1)
                        $(this).hide();
                    else
                        $(this).show();
                });
            });
		</script>
		<table cellpadding="0" cellspacing="0" border="0" id="table">
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
				<td><%=event.getPrice()%></td>
				<td><a href="BookEventServlet?Id=<%=event.getEventId() %>" class="button2">Book Me!</a></td>
				<%
					}
				%>
			</tr>
			</tbody>
		</table>
	</div>
			<a href="CreateEvent.jsp" class="button" style="vertical-align:middle"><span>Create Study</span></a>
			<a href="MyStudy" class="button" style="vertical-align:middle"><span>My Studies</span></a>
			<a href="MyBooking" class="button" style="vertical-align:middle"><span>My Bookings</span></a>
</section>

</body>