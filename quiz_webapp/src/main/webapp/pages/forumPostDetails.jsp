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
            <c:if test="${item.userId == sessionScope.userId}">
            <td>
                <input id="commentIdEdit" type="hidden" value="${item.id}">
                <button type="button" class="btn btn-secondary d-flex mb-2 mb-lg-0 me-2" data-bs-toggle="modal" data-bs-target="#modifyCommentModal">
                    Edit
                </button>
            </td>
            <td>
                <input id="commentId" type="hidden" value="${item.id}">
                <button id="deleteComment" type="submit" class="btn btn-danger">Delete</button>
            </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<c:if test="${sessionScope.loggedIn}">
<form>
    <div class="mb-3 mt-3 form-floating">
        <input type="text" class="form-control" name="comment" placeholder="Comment" id="comment">
        <label for="comment">Comment</label>
    </div>

    <button id="postComment" type="submit" class="btn btn-primary">Post</button>
</form>
</c:if>
<div class="modal fade" id="modifyCommentModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel">Login/Registration</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3 mt-3 form-floating">
                        <input type="text" class="form-control" name="comment" placeholder="Comment" id="modifyComment">
                        <label for="modifyComment">Comment</label>
                    </div>

                    <button id="modifyCommentBtn" type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
    </div>
</div>
</div>
</body>
</html>
