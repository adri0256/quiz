<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 04. 23.
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/ForumController" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>

<table class="table table-borderless">
    <caption class="caption-top">Forum Posts</caption>
    <thead>
    <th>Username</th>
    <th>Title</th>
    <th>Text</th>
    <th>Creation Date</th>
    </thead>
    <tbody>
        <tr>
            <td style="width: 10px">${requestScope.currentPost.userName}</td>
            <td>${requestScope.currentPost.title}</td>
            <td>${requestScope.currentPost.text}</td>
            <td>${requestScope.currentPost.createdDate}</td>
        </tr>
    </tbody>
</table>
<table class="table table-borderless">
    <caption class="caption-top">Comments</caption>
    <thead>
    <th>Username</th>
    <th>createdDate</th>
    <th>text</th>
    </thead>
    <c:forEach var="item" items="${requestScope.currentPostsComments}">
        <tr>
            <td>${item.userName}</td>
            <td>${item.createdDate}</td>
            <td>${item.text}</td>
        </tr>
    </c:forEach>
</table>

<form>
    <div class="mb-3 mt-3 form-floating">
        <input type="text" class="form-control" name="comment" placeholder="Comment" id="comment">
        <label for="comment">Username</label>
    </div>

    <button id="postComment" type="submit" class="btn btn-primary">Post</button>
</form>
</body>
</html>
