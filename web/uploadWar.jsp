<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/5/2
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>UploadWarFile</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script>
        function popUpAlert(){
            alert("Your project has been successfully uploaded! Good to have you in our platform.");
            window.location.href="index.jsp";
        }
    </script>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
    <div class="w3-bar w3-dark-grey w3-wide w3-padding w3-card">
        <a href="index.jsp" class="w3-bar-item w3-button">Home</a>
    </div>
</div>

<div class="w3-content" style="max-width:1564px;padding-top: 140px" >
    <section class="w3-container">

        <table class="w3-table w3-striped w3-bordered w3-card-4" >
            <thead>
            <tr class="w3-teal">
                <th>Choose the project you want upload(must be .war file)</th>
            </tr>
            </thead>
                <tr align="center" >
                    <td><input type="file" name="uploadWar" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button class="w3-button w3-red" onclick="popUpAlert()">Upload</button>
                    </td>
                </tr>
            </form>
        </table>
        <br>
        <br>
    </section>
</div>
</body>
</html>
