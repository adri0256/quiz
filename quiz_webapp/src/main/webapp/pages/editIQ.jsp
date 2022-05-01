<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 05. 01.
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/IQ" />
<html>
<head>
    <title>Edit IQ</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>

<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
    <h1>IQ Módosítása</h1>
    <table class="table table-borderless text-white">
        <tr>
            <td style="font-weight: bold">ID</td>
            <td id="ID">${requestScope.currentIQ.id}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">userID</td>
            <td >${requestScope.currentIQ.userID}</td>
            <td><input id="userID" class="editinput"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Score</td>
            <td>${requestScope.currentIQ.score}</td>
            <td><input id="score" class="editinput"></td>
        </tr>
    </table>
    <button id="updateIQ" class="btn btn-primary">Módosítás</button>

</div>


</body>
</html>
