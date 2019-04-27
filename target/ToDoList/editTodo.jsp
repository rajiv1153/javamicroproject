<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/20/2019
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Todo</title>
    <style>
        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
        }
    </style>
</head>
<body>

<h2>Edit Todo</h2>
<a href="/welcome.jsp">Home</a>
<a href="/showTodo">Show Todo</a>

<div class="container">
    <form action="UpdateTodo?id=<c:out value="${todoData.id}"></c:out>" method="post">
        <div class="row">
            <div class="col-25">
                <label>Description</label>
            </div>
            <div class="col-75">
                <input type="text" name="desc" value="<c:out value="${todoData.description}"></c:out> ">
            </div>
        </div>
        <div class="radio">
            <input type="radio" name="isdone"   value="true"  <c:if test="${todoData.done == true }"> checked </c:if> />Done <br />
        </div>
        <div class="radio">
            <input type="radio" name="isdone"   value="false"  <c:if test="${todoData.done == false}" > checked </c:if> />Not-Done <br />
        </div>
        <div class="row">
            <div class="col-25">
                <label>Date</label>
            </div>
            <div class="col-75">
                <input type="date" name="targetdate" value="<c:out value="${todoData.duedate}"></c:out>" / >
            </div>
        </div>

        <div class="row">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
<a href="welcome.jsp">Home</a>


</body>
</html>
