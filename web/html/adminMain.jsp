<%--
  Created by IntelliJ IDEA.
  User: ivegotaname
  Date: 14.12.16
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if((session.getAttribute("user")==null) && (!session.getAttribute("userRole").equals("2")))
    {
        response.sendRedirect("home.jsp");
    }
    else
    {
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../libs/Bootstrap/js/bootstrap.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/telephone.css">

</head>
<body>
<form ${sessionScope.ifNotRegistered} action="/LogoutServlet">
    <h3> user: ${sessionScope.user.firstName} ${sessionScope.user.secondName}
        <input type="submit" value="Logout"></h3>
</form>
    <nav role="navigation" class="navbar navbar-default" >
        <!-- Логотип и мобильное меню -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse"  data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- Навигационное меню -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="main.jsp">Main</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <li><a href="html/profile.jsp">Profile</a></li>
                <li><a href="/LogoutServlet">Exit</a></li>
            </ul>
        </div>
    </nav>
<h2> List of users</h2>
<form name="userForm" action="/DeleteUserServlet" method="post">
    <table>
        <tbody>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Login</th>
            <th>Birthday</th>
            <th>Role</th>
            <th>Email</th>
            <th>City</th>
            <th>Del</th>

        </tr>
        <c:forEach items="${sessionScope.userDTOs}" var="userDTO">
            <tr>
                <td><c:out value="${userDTO.id}"></c:out></td>
                <td><c:out value="${userDTO.firstName}"></c:out></td>
                <td><c:out value="${userDTO.secondName}"></c:out></td>
                <td><c:out value="${userDTO.login}"></c:out></td>
                <td><c:out value="${userDTO.birthday}"></c:out></td>
                <td><c:out value="${userDTO.role}"></c:out></td>
                <td><c:out value="${userDTO.email}"></c:out></td>
                <td><c:out value="${userDTO.city}"></c:out></td>
                <td><input type="radio" name="idUserDelete" value="${userDTO.id}"/></td>
            </tr>
            <br>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="submit" value="Delete user"/>
</form>
<br>
<hr>

</body>
</html>
<% } %>