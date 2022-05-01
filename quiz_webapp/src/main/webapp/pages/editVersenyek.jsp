<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 04. 30.
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Versenyek" />
<html>
<head>
    <title>Versenyek Update</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#Idopont" ).datepicker({
                format: 'yyyy-mm-dd',
            });
        } );
    </script>
</head>
<body>
<%@ include file="common/navbar.jsp" %>


<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
    <h1>Versenyek Módosítása</h1>
    <table class="table table-borderless text-white">
        <tr>
            <td style="font-weight: bold">ID</td>
            <td id="ID">${requestScope.currentVersenyek.id}</td>
        </tr>
        <tr>
            <td style="font-weight: bold">Idopont</td>
            <td >${requestScope.currentVersenyek.idopont}</td>
            <td><input id="Idopont" class="editinput"></td>
        </tr>
        <tr>
            <td style="font-weight: bold">TemakorID</td>
            <td>${requestScope.currentVersenyek.temakorID}</td>
            <td><input id="temakorID" class="editinput"></td>
        </tr>
    </table>
    <button id="updateVersenyek" class="btn btn-primary">Módosítás</button>

</div>

</body>
</html>
