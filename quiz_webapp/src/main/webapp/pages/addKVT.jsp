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
<h1>Kérdés</h1>
<table class="table table-borderless text-white">
    <thead>
    <th>kerdesName</th>
    <th>Difficulty</th>
    </thead>
    <tbody>
    <tr>
        <td><input id="kerdesName"></td>
        <td><input id="diff"></td>
    </tr>

    </tbody>
</table>

<h1>Válasz</h1>
    <table class="table table-borderless text-white">
        <thead>
        <th>valaszName</th>
        </thead>
        <tbody>
        <tr>
        <td><input id="valasz"></td>
        </tr>
        </tbody>
    </table>

<h1>Témakör</h1>
<table class="table table-borderless text-white">
    <thead>
    <th>name</th>
    </thead>
    <tbody>
    <tr>
        <td><input id="temakor"></td>
    </tr>
    </tbody>
</table>
    <button id="postKVT" class="btn btn-primary">Add</button>
</div>
</body>
</html>
