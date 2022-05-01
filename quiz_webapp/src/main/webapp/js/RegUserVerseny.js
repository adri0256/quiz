jQuery(document).ready(function($) {
    $("#addRegUserVerseny").click(function() {
        window.location = "addRegUserVerseny.jsp";
    });
});


$(document).ready(function (){
    $('#postRegUserVerseny').click(function (e) {
        postRegUserVerseny(e);
    });
});

jQuery(document).ready(function($) {
    $(".clickable-reguserverseny").click(function() {
        window.location = "editRegUserVerseny.jsp?regid=" + $(this).data("href");
    });
});

$(document).ready(function (){
    $('#updateRUV').click(function (e) {
        updateRUV(e);
    });

});


jQuery(document).ready(function($) {
    $(".rowdeleteRegUserVerseny").click(function(e) {
        deleteRegUserVerseny(e, $(this).data("href"));

    });
});

function postRegUserVerseny(e){
    e.preventDefault();
    const userID = document.getElementById("userID").value;
    const versenyID = document.getElementById("versenyID").value;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../RegUserVerseny",
        data: {
            type: "AddRUV",
            addUserID: userID,
            addVersenyID: versenyID,
        },
        success: function (result){
            window.location = "reguserverseny.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function updateRUV(e){
    e.preventDefault();

    const updateRegID = document.getElementById("regID").innerText;
    const updateRegUserID = document.getElementById("RegUserID").value;
    const updateRegVersenyID = document.getElementById("RegVersenyID").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../RegUserVerseny",
        data: {
            type: "updateRUV",
            updateRegID: updateRegID,
            updateRegUserID: updateRegUserID,
            updateRegVersenyID: updateRegVersenyID,
        },
        success: function (result){
            window.location = "reguserverseny.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function deleteRegUserVerseny(e, RegUserVerseny) {
    console.log(RegUserVerseny+": bye");

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../RegUserVerseny",
        data: {
            type: "deleteRUV",
            deleteID: RegUserVerseny
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}