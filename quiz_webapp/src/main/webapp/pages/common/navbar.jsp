<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 30.
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

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
    <script src="../js/login.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-nav-scroll sticky-top">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="main.jsp">Quiz</a>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
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
            <button type="button" class="btn btn-primary d-flex mb-2 mb-lg-0 me-2" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Login / Register
            </button>
        </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="Login/Register" aria-hidden="true">
    <div class="modal-dialog z">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Login/Registration</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="login-tab" data-bs-toggle="tab" data-bs-target="#login" type="button" role="tab" aria-controls="login" aria-selected="true">Login</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="register-tab" data-bs-toggle="tab" data-bs-target="#register" type="button" role="tab" aria-controls="register" aria-selected="false">Registration</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="login" role="tabpanel" aria-labelledby="login-tab">
                        <form class="requires-validation" novalidate>
                            <div class="mb-3">
                                <input type="email" class="form-control" name="loginEmail" id="loginEmail" aria-describedby="emailHelp" required>
                                <div class="valid-feedback">
                                    Email looks good!
                                </div>
                                <div class="invalid-feedback">
                                    Email is required!
                                </div>
                            </div>

                            <div class="mb-3">
                                <input type="password" class="form-control" name="loginPwd" id="loginPwd" required>
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
                            <div class="mb-3">
                                <label for="regUsname" class="form-label">Username</label>
                                <input type="text" class="form-control" name="regUsname" id="regUsname">
                            </div>

                            <div class="mb-3">
                                <label for="regEmail" class="form-label">Email address</label>
                                <input type="email" class="form-control" name="regEmail" id="regEmail" aria-describedby="emailHelp">
                            </div>

                            <div class="mb-3">
                                <label for="regPwd" class="form-label">Password</label>
                                <input type="password" class="form-control" name="regPwd" id="regPwd">
                            </div>

                            <div class="mb-3">
                                <label for="regRePwd" class="form-label">Re Password</label>
                                <input type="password" class="form-control" name="regPwdRe" id="regRePwd">
                            </div>

                            <div class="mb-3">
                                <label for="date" class="form-label">Birthdate</label>
                                <div class="d-flex flex-row">
                                    <div class="input-group date" id="datepicker">
                                        <input type="text" id="date" name="regBirthDate" class="form-control">
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
