<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 21.
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "scoreboard"; %>

<jsp:include page="/ScoreboardController" />
<html>
<head>
    <title>Scoreboard</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>

    <div style="display: flow-root" class="container-fluid bg-dark overflow-auto main-box-height text-white">
        <h1>Scoreboard</h1>
        <table class="table table-borderless text-white">
            <thead>
            <th>ID</th>
            <th>userID</th>
            <th>score</th>
            <th>difficulty</th>
            </thead>
            <c:forEach var="item" items="${requestScope.scores}">
                <tr style="cursor: pointer" class="tabletr">
                    <td class='clickable-scoreboard' data-href='${item.id}'>${item.id}</td>
                    <td class='clickable-scoreboard' data-href='${item.id}'>${item.userID}</td>
                    <td class='clickable-scoreboard' data-href='${item.id}'>${item.score}</td>
                    <td class='clickable-scoreboard' data-href='${item.id}'>${item.difficulty}</td>
                    <td class="rowdeleteScoreboard" data-href='${item.id}' ><button class="deletebtn" id="deleteScoreboard" ><i class="bi bi-trash3-fill text-white"></i></button></td>
                </tr>
            </c:forEach>
        </table>

        <button id="addScoreboard" type="submit" class="btn btn-primary">Add new</button>
    </div>
</body>
</html>
