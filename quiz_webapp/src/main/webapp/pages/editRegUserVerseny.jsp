<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 04. 30.
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/RegUserVerseny" />
<html>
<head>
    <title>RegUserVerseny Update</title>
</head>
<body>

<%@ include file="common/navbar.jsp" %>

<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
    <h1>RegUserVerseny Módosítása</h1>
    <table class="table table-borderless text-white">
        <tr>
            <td style="font-weight: bold">regID</td>
            <td id="regID">${requestScope.currentRegUserVerseny.regID}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">userID</td>
            <td >${requestScope.currentRegUserVerseny.userID}</td>
            <td><input id="RegUserID" class="editinput"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">versenyID</td>
            <td>${requestScope.currentRegUserVerseny.versenyID}</td>
            <td><input id="RegVersenyID" class="editinput"></td>
        </tr>
    </table>
    <button id="updateRUV" class="btn btn-primary">Módosítás</button>

</div>

</body>
</html>
