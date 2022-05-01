<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 04. 29.
  Time: 7:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/Versenyek" />
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
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

    <h1>Időpont</h1>
    <table class="table table-borderless">
        <tbody>
        <tr>
            <td><input type="text" id="Idopont"></td>
        </tr>
        </tbody>
    </table>

    <h1>TémakörID</h1>
    <table class="table table-borderless text-white">
        <tbody>
        <tr>
            <td><input id="temakorID"></td>
        </tr>
        </tbody>
    </table>

    <button id="postVersenyek" class="btn btn-primary">Add</button>
</div>
</body>
</html>
