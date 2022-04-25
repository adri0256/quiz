$(document).ready(function (){
    $('#loginBtn').click(function (e) {
        login(e);
    });
    $('#regBtn').click(function (e) {
        reg(e);
    });
    $('#logoutBtn').click(function (e) {
        logout(e);
    });
    $('#modifyUsernameBtn').click(function (e) {
        modify(e, "username");
    });
    $('#modifyEmailBtn').click(function (e) {
        modify(e, "email");
    });
    $('#modifyPasswordBtn').click(function (e) {
        modify(e, "password");
    });
    $('#deleteAccountBtn').click(function (e) {
        deleteAccount(e);
    });
});

function login(e){
    e.preventDefault();

    const loginEmailText = document.getElementById("loginEmail").value;
    const loginPwdText = document.getElementById("loginPwd").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../UsersController",
        data: {
            type: "Login",
            loginEmail: loginEmailText,
            loginPwd: loginPwdText
        },
        success: function (result){
            if (result.loginSuccess === "yes"){
                location.reload();
            }

        },
        error: function (result){
        }
    });
}

function reg(e) {
    e.preventDefault();

    const regUsnameText = document.getElementById("regUsname").value;
    const regEmailText = document.getElementById("regEmail").value;
    const regPwdText = document.getElementById("regPwd").value;
    const regPwd2Text = document.getElementById("regRePwd").value;
    const birthDate = document.getElementById("date").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../UsersController",
        data: {
            type: "Registration",
            regUsname: regUsnameText,
            regEmail: regEmailText,
            regPwd: regPwdText,
            regBirthDate: birthDate
        },
        success: function (result){
            if (result.regSuccess === "yes"){
            } else if (result.regSuccess === "no"){
            }

        },
        error: function (result){
        }
    });
}

function logout(e) {
    e.preventDefault();

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../UsersController",
        data: {
            type: "Logout"
        },
        success: function (result) {
            location.reload();
        },
        error: function (result){
            alert("Failed");
        }
    });
}

function deleteAccount(e) {
    e.preventDefault();

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../UsersController",
        data: {
            type: "DeleteAccount"
        },
        success: function (result) {
            window.location.replace("main.jsp");
        },
        error: function (result){
            alert("Failed");
        }
    });
}

function modify(e, s){
    e.preventDefault();

    let passData;

    switch (s) {
        case "username": passData = document.getElementById("modifyUsername").value;
            break;
        case "email": passData = document.getElementById("modifyEmail").value;
            break;
        case "password": passData = document.getElementById("modifyPassword").value;
            break;
        default:
            console.log("Nem megfelelő function hívás!")
            return;
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../UsersController",
        data: {
            type: "Modify",
            req: s,
            newData: passData
        },
        success: function (result) {
            location.reload();
        },
        error: function (result){
            alert("Failed");
        }
    });
}