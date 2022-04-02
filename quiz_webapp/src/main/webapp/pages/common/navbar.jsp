<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 30.
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <%@ include file="common-header.jsp" %>

    <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker({
                format: 'yyyy-mm-dd'
            });
        });
    </script>
    <script src="../js/userLogic.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="main.jsp">Quiz</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("main")){out.print("active");} %>" aria-current="page" href="main.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("users")){out.print("active");} %>" aria-current="page" href="users.jsp">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("forum")){out.print("active");} %>" aria-current="page" href="forum.jsp">Forum</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("kerdes")){out.print("active");} %>" aria-current="page" href="kerdes.jsp">Kérdések/Válaszok</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("versenyek")){out.print("active");} %>" aria-current="page" href="versenyek.jsp">Versenyek</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("IQ")){out.print("active");} %>" aria-current="page" href="iq.jsp">IQ Teszt</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("scoreboard")){out.print("active");} %>" aria-current="page" href="scoreboard.jsp">Scoreboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <% if(currentPage.equals("reguserverseny")){out.print("active");} %>" aria-current="page" href="reguserverseny.jsp">Reg User Verseny</a>
                </li>
            </ul>
            <c:if test="${not sessionScope.get('loggedIn')}">
                <button type="button" class="btn btn-secondary d-flex mb-2 mb-lg-0 me-2" data-bs-toggle="modal" data-bs-target="#loginModal">
                    Login / Register
                </button>
            </c:if>
            <c:if test="${sessionScope.get('loggedIn')}">
                <div class="dropdown dropdown-lg d-inline-block d-flex mb-2 mb-lg-0 me-2" id="navbarNavDarkDropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <c:out value="${sessionScope.get('userEmail')}" />
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <hr />
                        <li><a class="dropdown-item" href="#" id="logoutBtn">Logout</a></li>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="Login/Register" aria-hidden="true">
    <div class="modal-dialog z">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Login/Registration</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="login-tab" data-bs-toggle="tab" data-bs-target="#login" type="button" role="tab" aria-controls="userLogic" aria-selected="true">Login</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="register-tab" data-bs-toggle="tab" data-bs-target="#register" type="button" role="tab" aria-controls="register" aria-selected="false">Registration</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="login" role="tabpanel" aria-labelledby="login-tab">
                        <form class="requires-validation" novalidate>
                            <div class="mb-3 mt-3 form-floating">
                                <input type="email" class="form-control" name="loginEmail" id="loginEmail" aria-describedby="emailHelp" placeholder="Email Address" required>
                                <label for="loginEmail">Email address</label>
                                <div class="valid-feedback">
                                    Email looks good!
                                </div>
                                <div class="invalid-feedback">
                                    Email is required!
                                </div>
                            </div>

                            <div class="mb-3 mt-3 form-floating">
                                <input type="password" class="form-control" name="loginPwd" id="loginPwd" placeholder="Password" required>
                                <label for="loginPwd">Password</label>
                                <div class="valid-feedback">
                                    Password looks good!
                                </div>
                                <div class="invalid-feedback">
                                    Password is required!
                                </div>
                            </div>

                            <button id="loginBtn" type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">
                        <form>
                            <div class="mb-3 mt-3 form-floating">
                                <input type="text" class="form-control" name="regUsname" placeholder="Username" id="regUsname">
                                <label for="regUsname">Username</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="email" class="form-control" name="regEmail" id="regEmail" placeholder="Email Address" aria-describedby="emailHelp">
                                <label for="regEmail">Email address</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="password" class="form-control" name="regPwd" placeholder="Password" id="regPwd">
                                <label for="regPwd">Password</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="password" class="form-control" name="regPwdRe" placeholder="Password Again" id="regRePwd">
                                <label for="regRePwd">Password Again</label>
                            </div>

                            <div class="mb-3">
                                <div class="d-flex flex-row">
                                    <div class="input-group date form-floating" id="datepicker">
                                        <input type="text" id="date" name="regBirthDate" placeholder="Birthdate" class="form-control">
                                        <label for="date">Birthdate</label>
                                        <span class="input-group-append">
                                            <span class="input-group-text bg-white h-100">
                                                <i class="fa fa-calendar"></i>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <button id="regBtn" type="submit" class="btn btn-primary">Register</button>

                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
