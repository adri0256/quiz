<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 05. 01.
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/ScoreboardController" />
<html>
<head>
    <title>Add Scoreboard</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">

    <h1>UserID</h1>
    <table class="table table-borderless">
        <tbody>
        <tr>
            <td><input type="text" id="userID"></td>
        </tr>
        </tbody>
    </table>

    <h1>Score</h1>
    <table class="table table-borderless text-white">
        <tbody>
        <tr>
            <td><input id="score"></td>
        </tr>
        </tbody>
    </table>

    <h1>Difficulty</h1>
    <table class="table table-borderless text-white">
        <tbody>
        <tr>
            <td><select id="difficulty">
                <option selected value="0">EASY</option>
                <option value="1">NORMAL</option>
                <option value="2">HARD</option>
            </select>
            </td>
        </tr>
        </tbody>
    </table>

    <button id="postScoreboard" class="btn btn-primary">Add</button>
</div>
</body>
</html>