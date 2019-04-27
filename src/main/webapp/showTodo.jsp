<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/13/2019
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Todolist</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate,no-reload");

    if (httpSession.getAttribute("Name")==null){
        response.sendRedirect("/index.jsp");
    }
   httpSession.getAttribute("todo");
    System.out.println(httpSession.getAttribute("Username"));
    //System.out.println(httpSession.getAttribute("id"));

 //   System.out.println(httpSession.getAttribute("description"));

%>
<div class="w3-container">
    <h2> Your Todo List</h2>


    <table class="w3-table w3-striped">
        <thead>
        <th>S.N</th>
        <th>Todo</th>
        <th>done?</th>
        <th>Due Date</th>
        <th></th>
        <th></th>

        </thead>
        <tbody>
        <c:forEach items="${todo}" var="todo" varStatus="i">
            <tr>
                <td><c:out value="${i.index+1}"></c:out> </td>
                <td><c:out value="${todo.description}"></c:out> </td>
                <td><c:out value="${todo.done}"></c:out> </td>
                <td><c:out value="${todo.duedate}"></c:out> </td>
                <td><a type="button"></a></td>
                <td><a type="button" class="btn btn-success" value="Update" href="UpdateTodo?id=${todo.id}">Update</a></td>
                <td><a type="button" class="btn btn-warning" value="Delete" href="DeleteTodo?id=${todo.id}">Delete</a></td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<a href="AddTodo.jsp">Add Todo</a>
<a href="welcome.jsp">Home</a>

</body>
</html>
