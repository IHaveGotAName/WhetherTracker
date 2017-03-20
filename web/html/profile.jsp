<%--
  Created by IntelliJ IDEA.
  User: ivegotaname
  Date: 13.12.16
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../libs/Bootstrap/js/bootstrap.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/profile.css">
</head>

<body>
    <nav role="navigation" class="navbar navbar-default">
        <!-- Логотип и мобильное меню -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Навигационное меню -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ><a href="mainIN.jsp">Main</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="profile.jsp">Profile</a></li>
            </ul>
        </div>
    </nav>

<h2>Your profile</h2>
<form ${sessionScope.ifNotRegistered} action="/LogoutServlet">
    <h3> user: ${sessionScope.user.firstName} ${sessionScope.user.secondName}
        <input type="submit" value="Logout"></h3>
</form>
<table>
    <tbody>
    <tr>
        <th>Name</th>
        <th>SecondName</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>City</th>
    </tr>


        <tr>
            <td><c:out value="${user.firstName}"></c:out></td>
            <td><c:out value="${user.secondName}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.birthday}"></c:out></td>
            <td><c:out value="${user.city}"></c:out></td>
        </tr>

    </tbody>
</table>


</body>
</html>