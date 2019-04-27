<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/12/2019
  Time: 7:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1 {font-family: "Raleway", Arial, sans-serif}
        h1 {letter-spacing: 6px}
        .w3-row-padding img {margin-bottom: 12px}
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate,no-reload");
    if (httpSession.getAttribute("Name")==null){
        response.sendRedirect("/index.jsp");
    }
%>
<%
  //  System.out.println(httpSession.getAttribute("Username"));
%>

    <%--<h4>welcome ${Username}</h4>--%>
<%--<h4>welcome ${id}</h4>--%>

<%--<h4>welcome ${Name}</h4>--%>

    <%--<br><br>--%>
    <%--<form action="logout" method="get">--%>
        <%--<input type="submit" value="logout">--%>
        <%--<br><br>--%>
        <%--<a href="AddTodo.jsp">Add Todo</a><br>--%>
        <%--<a href="showTodo" >Show todo</a>--%>
    <%--</form>--%>




<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px">

    <!-- Header -->
    <header class="w3-panel w3-center w3-opacity" style="padding:128px 16px">
        <h1 class="w3-xlarge">Welcome</h1>
        <h1> ${Name}</h1>

        <div class="w3-padding-32">
            <div class="w3-bar w3-border">
                <a href="showTodo" class="w3-bar-item w3-button">View Todo</a>
                <a href="AddTodo.jsp" class="w3-bar-item w3-button w3-light-grey">Add Todo</a>
                <a href="logout" class="w3-bar-item w3-button">Logout</a>
            </div>
        </div>
    </header>



</body>
</html>
