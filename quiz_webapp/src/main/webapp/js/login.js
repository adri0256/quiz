$(document).ready(function (){
    $('#loginBtn').click(function (e) {
        login(e);
    });
    $('#regBtn').click(function (e) {
        reg(e);
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
                alert("loginSuccess");
            } else if (result.loginSuccess === "no"){
                alert("loginFailed");
            }

        },
        error: function (result){
            alert("Failed");
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
                alert("regSuccess");
            } else if (result.regSuccess === "no"){
                alert("regFailed");
            }

        },
        error: function (result){
            alert("Failed");
        }
    });
}