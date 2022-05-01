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
<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
        <!--
        Kérdés részleg
        !-->
    <c:if test ='${requestScope.whichone == "k"}'>
        <h1>Kérdés Módosítása</h1>
<table class="table table-borderless text-white">
    <tr>
        <td style="font-weight: bold">ID</td>
        <td id="kerdesID">${requestScope.currentKerdes.id}</td>
    </tr>
    <tr>
        <td style="font-weight: bold">kerdesName</td>
        <td >${requestScope.currentKerdes.kerdesName}</td>
        <td><input id="kerdesName" class="editinput"></td>
    </tr>
    <tr>
        <td style="font-weight: bold">Difficulty</td>
        <td>${requestScope.currentKerdes.difficulty}</td>
        <td><select id="diff" class="editinput">
            <option selected value="0">EASY</option>
            <option value="1">NORMAL</option>
            <option value="2">HARD</option>
        </select></td>
    </tr>
    <tr>
        <td style="font-weight: bold">Temakor</td>
        <td>${requestScope.currentKerdes.temakor}</td>
    </tr>
</table>
</c:if>
        <!--
        Válasz részleg
        !-->
<c:if test ='${requestScope.whichone == "v"}'>
    <h1>Válasz Módosítása</h1>
    <table class="table table-borderless text-white">
        <tr>
            <td style="font-weight: bold">ID</td>
            <td id="valaszID">${requestScope.currentValasz.id}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">Valaszszoveg</td>
            <td>${requestScope.currentValasz.valaszName}</td>
            <td><input id="valaszname" class="editinput"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">KerdesID</td>
            <td>${requestScope.currentValasz.kerdesID}</td>
        </tr>
    </table>
</c:if>
    <!--
        Témakör részleg
    !-->
<c:if test ='${requestScope.whichone == "t"}'>
    <h1>Témakör Módosítása</h1>
    <table class="table table-borderless text-white">
        <tr>
            <td style="font-weight: bold">ID</td>
            <td id="temakorID">${requestScope.currentTemakor.id}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">name</td>
            <td>${requestScope.currentTemakor.name}</td>
            <td><input id="temakorName" class="editinput"></td>
        </tr>
    </table>
</c:if>
    <button id="modifybtn" class="btn btn-primary">Módosítás</button>
    <p hidden id="melyik">${requestScope.whichone}</p>
</div>
</body>
</html>
