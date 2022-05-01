<%--
  Created by IntelliJ IDEA.
  User: Feke
  Date: 2022. 04. 25.
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/KerdesController" />
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="common/navbar.jsp" %>
<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
    <hr>
    <h1>Kérdés</h1>
<table class="table table-borderless text-white">
    <thead>
        <th>kerdesName</th>
        <th>Difficulty</th>
        <th>Temakor</th>
    </thead>
    <tbody>
    <tr>
        <td><input class="addTD" id="kerdesName"></td>
        <td><select class="addTD custom-select" id="diff">
            <option selected value="0">EASY</option>
            <option value="1">NORMAL</option>
            <option value="2">HARD</option>
        </select>
        </td>
        <td>
            <select class="addTemakor custom-select" id="tem">
                <c:forEach var="item" items="${requestScope.temakor}">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
        </td>
    </tr>

    </tbody>
</table>
    <hr>
<h1>Válasz</h1>
    <table class="table table-borderless text-white">
        <thead>
        <th>valaszName</th>
        </thead>
        <tbody>
        <tr>
        <td><input class="addTD"  id="valasz"></td>
        </tr>
        </tbody>
    </table>

<h1>Témakör</h1>
    <hr>
<table class="table table-borderless text-white">
    <thead>
    <th>name</th>
    </thead>
    <tbody>
    <tr>
        <td><input class="addTD"  id="temakor"></td>
    </tr>
    </tbody>
</table>
    <button id="postKVT" class="btn btn-primary">Add</button>
</div>
</body>
</html>
