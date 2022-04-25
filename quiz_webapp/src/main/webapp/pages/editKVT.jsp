<%--
  Created by IntelliJ IDEA.
  User: Feke
  Date: 2022. 04. 23.
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/KerdesController" />
<html>
<head>
    <title>Módosítás</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<c:if test ='${requestScope.whichone == "k"}'>
<table>
    <thead>
    <th>ID</th>
    <th>kerdesName</th>
    <th>Difficulty</th>
    </thead>
    <tr>
        <td>${requestScope.currentKerdes.id}</td>
        <td>
                <input>${requestScope.currentKerdes.kerdesName}
        </td>
        <td>${requestScope.currentKerdes.difficulty}</td>
    </tr>
</table>
</c:if>
<c:if test ='${requestScope.whichone == "v"}'>
    <table>
        <thead>
        <th>ID</th>
        <th>Valaszszoveg</th>
        <th>KerdesID</th>
        </thead>
        <tr>
            <td>${requestScope.currentValasz.id}</td>
            <td>${requestScope.currentValasz.valaszName}</td>
            <td>${requestScope.currentValasz.kerdesID}</td>
        </tr>
    </table>
</c:if>
<c:if test ='${requestScope.whichone == "t"}'>
    <table>
        <thead>
        <th>ID</th>
        <th>name</th>
        </thead>
        <tr>
            <td>${requestScope.currentTemakor.id}</td>
            <td>${requestScope.currentTemakor.name}</td>
        </tr>
    </table>
</c:if>
</body>
</html>
