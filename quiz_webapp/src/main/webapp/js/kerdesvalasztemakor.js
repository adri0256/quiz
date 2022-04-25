jQuery(document).ready(function($) {
    $(".clickable-kerdes").click(function() {
        window.location = "editKVT.jsp?type=kerdes&id=" + $(this).data("href");
    });
});
jQuery(document).ready(function($) {
    $(".clickable-valasz").click(function() {
        window.location = "editKVT.jsp?type=valasz&id=" + $(this).data("href");
    });
});
jQuery(document).ready(function($) {
    $(".clickable-temakor").click(function() {
        window.location = "editKVT.jsp?type=temakor&id=" + $(this).data("href");
    });
});

jQuery(document).ready(function($) {
    $("#addKVT").click(function() {
        window.location = "addKVT.jsp";
    });
});

$(document).ready(function (){
    $('#postKerdes').click(function (e) {
        postK(e);
    });
});
$(document).ready(function (){
    $('#postValasz').click(function (e) {
        postV(e);
    });
});

$(document).ready(function (){
    $('#postTemakor').click(function (e) {
        postT(e);
    });

});

function addPostT(e) {
console.log("add temakor")
}

function postK(e){
    e.preventDefault();

    const kerdesT = document.getElementById("kerdes").value;
    const difficultyT = document.getElementById("difficulty").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../KerdesController",
        data: {
            type: "Kerdes",
            kerdes: kerdesT,
            difficulty: difficultyT
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}
function postV(e){
    e.preventDefault()
    const valaszT = document.getElementById("kerdes").value;
    const kerdesIDT = document.getElementById("kerdesID").value;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../KerdesController",
        data: {
            type: "Valasz",
            valasz: valaszT,
            kerdesID: kerdesIDT
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}
function postT(e){
    e.preventDefault();
    const temakorT = document.getElementById("temakor").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../KerdesController",
        data: {
            type: "Temakor",
            temakor: temakorT
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}