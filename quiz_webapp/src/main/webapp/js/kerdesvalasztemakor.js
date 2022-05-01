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
    $('#postKVT').click(function (e) {
        postKVT(e);
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
$(document).ready(function (){
    $('#modifybtn').click(function (e) {
        update(e);
    });

});
jQuery(document).ready(function($) {
    $(".tabledelete").click(function(e) {
        dfg = $(this).data("type")
        if (dfg == "k"){
            deletex(e, $(this).data("href"), "k");
        }
        else if(dfg == "v"){
            deletex(e, $(this).data("href"), "v");
        }
        else{
            deletex(e, $(this).data("href"), "t");
        }

    });
});

function deletex(e, asd, s) {
 console.log(s+": "+asd);

 $.ajax({
     type: "POST",
     dataType: "json",
     url: "../KerdesController",
     data: {
         type: "delete",
         melyik: s,
         deleteid: asd
     },
     success: function (result){
         window.location.reload();
     },
     error: function (result){
         window.location.reload();
     }
 });
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

function postKVT(e){
    e.preventDefault();
    const kerdesName = document.getElementById("kerdesName").value;
    const diff = document.getElementById("diff").value;
    const selectedTemakor = document.getElementById("tem").value;
    const valaszname = document.getElementById("valasz").value;
    const temakor = document.getElementById("temakor").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../KerdesController",
        data: {
            type: "AddALL",
            temakor: temakor,
            kerdes: kerdesName,
            stem: selectedTemakor,
            difficulty: diff,
            valasz: valaszname
        },
        success: function (result){
            window.location = "kerdes.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function update(e){
    const melyik = document.getElementById("melyik").innerText;
    console.log()
    e.preventDefault();

    if (melyik == "k"){
        var kerdesid = document.getElementById("kerdesID").innerText;
        var kerdesn = document.getElementById("kerdesName").value;
        var diffn = document.getElementById("diff").value;
    }
    else if (melyik == "v"){
        var valaszidn = document.getElementById("valaszID").innerText;
        var valasznamen = document.getElementById("valaszname").value;
    }
    else{
        var temakoridn = document.getElementById("temakorID").innerText;
        var temakorn = document.getElementById("temakorName").value;
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../KerdesController",
        data: {
            type: "update",
            updatemelyik: melyik,
            kerdesID: kerdesid,
            kerdesName: kerdesn,
            difficulty: diffn,
            valaszID: valaszidn,
            valaszName: valasznamen,
            temakorID: temakoridn,
            temakorName: temakorn
        },
        success: function (result){
            window.location = "kerdes.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}