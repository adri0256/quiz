<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 05. 01.
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/IQ" />
<html>
<head>
    <title>IQ Add</title>
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

    <button id="postIQ" class="btn btn-primary">Add</button>
</div>
</body>
</html>
