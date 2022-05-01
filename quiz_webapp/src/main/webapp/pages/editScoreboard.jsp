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
    <title>Scoreboard Add</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>


<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
    <h1>Scoreboard Módosítása</h1>
    <table class="table table-borderless text-white">
        <tr>
            <td style="font-weight: bold">ID</td>
            <td id="ID">${requestScope.currentScoreboard.id}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">userID</td>
            <td >${requestScope.currentScoreboard.userID}</td>
            <td><input id="userID" class="editinput"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">score</td>
            <td>${requestScope.currentScoreboard.score}</td>
            <td><input id="score" class="editinput"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Difficulty</td>
            <td>${requestScope.currentScoreboard.difficulty}</td>
            <td><select id="difficulty" class="editinput">
                <option selected value="0">EASY</option>
                <option value="1">NORMAL</option>
                <option value="2">HARD</option>
            </select></td>
        </tr>
    </table>
    <button id="updateScoreboard" class="btn btn-primary">Módosítás</button>

</div>

</body>
</html>


