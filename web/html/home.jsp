<%--
  Created by IntelliJ IDEA.
  User: ivegotaname
  Date: 10.12.16
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
<link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/telephone.css">
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
                <li ><a href="main.jsp">Main</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="home.jsp">Sign in</a></li>
            </ul>
        </div>
    </nav>
    <form class="form-signin" role="form" action="/AuthorisationServlet" ${sessionScope.ifRegistered} method="post">
        <input type="text" name="login" class="form-control" required placeholder="Login"  autofocus="">
        <input type="password" name="password" class="form-control" placeholder="Password" required="">
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
<form class="form-signin" role="form" action="/html/register.jsp" ${sessionScope.ifRegistered} method="post">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign on</button>
</form>
<%--<p><a href="register.jsp">Sign on</a></p>--%>


</body>
</html>