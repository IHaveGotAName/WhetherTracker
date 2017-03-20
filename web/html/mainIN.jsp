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
    <link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../libs/Bootstrap/js/bootstrap.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/telephone.css">

</head>
<body>

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
                <li class="active"><a href="mainIN.jsp">Main</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="/LogoutServlet">Exit</a></li>
            </ul>
        </div>
    </nav>
    <body>
<%--    <form class="form-weather_link" role="form" action="https://openweathermap.org/city/${city.id}" method="post">
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Weather in your city "link"</button>

    </form>--%>

    <div style="font-size: medium; font-weight: bold; margin-bottom: 0px;">${city.city}</div>
    <div style="float: left; width: 130px;">
        <div style="display: block; clear: left;">
            <div style="float: left;" title="Titel">
                <img height="45" width="45" style="border: medium none; width: 45px; height: 45px; background: url(&quot;http://openweathermap.org/img/w/${weather.icon}.png&quot;) repeat scroll 0% 0% transparent;" alt="title" src="http://openweathermap.org/images/transparent.png"/>
            </div>
            <div style="float: left;">
                <div style="display: block; clear: left; font-size: medium; font-weight: bold; padding: 0pt 3pt;" title="Current Temperature">${weather.temp} °C</div>
                <div style="display: block; width: 85px; overflow: visible;"></div>
            </div>
        </div>
        <div style="display: block; clear: left; font-size: small;">Clouds: ${weather.clouds} %</div>
        <div style="display: block; clear: left; color: gray; font-size: x-small;" >Humidity: ${weather.humidity} %</div>
        <div style="display: block; clear: left; color: gray; font-size: x-small;" >Wind: ${weather.wind_speed} m/s</div>
        <div style="display: block; clear: left; color: gray; font-size: x-small;" >Pressure: ${weather.pressure} hpa</div>
    </div>
    <div style="display: block; clear: left; color: gray; font-size: x-small;">
        <a href="http://openweathermap.org/city/${city.id}?utm_source=openweathermap&utm_medium=widget&utm_campaign=html_old" target="_blank">More..</a>
    </div>
    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-31601618-9', 'auto');ga('send', 'pageview');</script>


    </body>

</body>
</html>