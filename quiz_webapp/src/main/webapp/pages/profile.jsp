<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 04. 21.
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% currentPage = "main"; %>

<jsp:include page="/UsersController" />
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>
    <div class="d-flex flex-column main-box-height justify-content-center align-items-center">
        <div class="w-50">
            <form>
                <div class="row">
                    <div class="mb-3 form-floating col">
                        <input type="text" class="form-control" id="modifyUsername" aria-describedby="modifyUsername" placeholder="Username" value="${sessionScope.get("userData").getUsername()}">
                        <label class="form-label" for="modifyUsername">Username</label>
                    </div>
                    <div class="col-md-auto mt-2">
                        <button id="modifyUsernameBtn" type="submit" class="btn btn-primary">Modify</button>
                    </div>
                </div>
            </form>
            <form>
                <div class="row">
                    <div class="mb-3 form-floating col">
                        <input type="email" class="form-control" id="modifyEmail" aria-describedby="modifyEmail" placeholder="Email Address" value="${sessionScope.get("userData").getEmail()}">
                        <label for="modifyEmail" class="form-label">Email address</label>
                    </div>
                    <div class="col-md-auto mt-2">
                        <button id="modifyEmailBtn" type="submit" class="btn btn-primary">Modify</button>
                    </div>
                </div>

            </form>
            <form>
                <div class="row">
                    <div class="mb-3 form-floating col">
                        <input type="password" class="form-control" id="modifyPassword" placeholder="Password">
                        <label for="modifyPassword" class="form-label">Password</label>
                    </div>
                    <div class="col-md-auto mt-2">
                        <button id="modifyPasswordBtn" type="submit" class="btn btn-primary">Modify</button>
                    </div>
                </div>
            </form>
            <form>
                <button id="deleteAccountBtn" type="submit" class="btn btn-danger">Delete Account</button>
            </form>
        </div>
    </div>
</body>
</html>
