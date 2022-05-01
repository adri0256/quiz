<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 04. 30.
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/RegUserVerseny" />
<html>
<head>
    <title>Title</title>
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

    <h1>VersenyID</h1>
    <table class="table table-borderless">
        <tbody>
        <tr>
            <td><input id="versenyID"></td>
        </tr>
        </tbody>
    </table>
    <button id="postRegUserVerseny" class="btn btn-primary">Add</button>
</div>


</body>
</html>
