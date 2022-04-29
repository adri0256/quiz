<%--
  Created by IntelliJ IDEA.
  User: Feke
  Date: 2022. 03. 21.
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "kerdes"; %>

<jsp:include page="/KerdesController" />
<html>
<head>
    <title>Kérdés/Válasz/Témakör</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>
    <div style="display: flow-root" class="container-fluid bg-dark overflow-auto main-box-height text-white">
        <h3>Kérdés</h3>
        <table class="table table-borderless text-white">
    <thead>
    <th>ID</th>
    <th>kerdesName</th>
    <th>Difficulty</th>
    </thead>
    <c:forEach var="item" items="${requestScope.kerdes}">
        <tr style="cursor: pointer" class="tabletr">
            <td class='clickable-kerdes' data-href='${item.id}'>${item.id}</td>
            <td class='clickable-kerdes' data-href='${item.id}'>${item.kerdesName}</td>
            <td class='clickable-kerdes' data-href='${item.id}'>${item.difficulty}</td>
            <td class="tabledelete" data-href='${item.id}' data-type="k"><button class="deletebtn" id="btn1"><i class="bi bi-trash3-fill text-white"></i></button></td>
        </tr>
    </c:forEach>
</table>
        <h3>Válasz</h3>
<table class="table table-borderless text-white">
    <thead>
    <th>ID</th>
    <th>kerdesID</th>
    <th>valaszName</th>
    </thead>
    <c:forEach var="item" items="${requestScope.valasz}">
        <tr style="cursor: pointer" class="tabletr">
            <td class='clickable-valasz' data-href='${item.id}'>${item.id}</td>
            <td class='clickable-valasz' data-href='${item.id}'>${item.kerdesID}</td>
            <td class='clickable-valasz' data-href='${item.id}'>${item.valaszName}</td>
            <td class="tabledelete" data-href='${item.id}' data-type="v"><button class="deletebtn" id="btn2" ><i class="bi bi-trash3-fill text-white"></i></button></td>
        </tr>
    </c:forEach>
</table>
        <h3>Témakör</h3>
<table class="table table-borderless text-white">
    <thead>
    <th>ID</th>
    <th>name</th>
    </thead>
    <c:forEach var="item" items="${requestScope.temakor}">
        <tr style="cursor: pointer" class="tabletr">
            <td class='clickable-temakor' id="temakorIDtable" data-href='${item.id}'>${item.id}</td>
            <td class='clickable-temakor' id="temakorNametable" data-href='${item.id}'>${item.name}</td>
            <td class="tabledelete" data-href='${item.id}' data-type="t"><button class="deletebtn" id="btn3"><i class="bi bi-trash3-fill text-white"></i></button></td>
        </tr>
    </c:forEach>

</table>
    <button id="addKVT" type="submit" class="btn btn-primary">Add new</button>
    </div>
</body>
</html>
