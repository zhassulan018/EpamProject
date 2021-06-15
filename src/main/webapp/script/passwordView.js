function myFunction() {
    var x = document.getElementById("password");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function myFunctionConfirm(){
    var y = document.getElementById("confirm_password");
    if (y.type === "password") {
        y.type = "text";
    } else {
        y.type = "password";
    }
}

function myFunctionOld(){
    var y = document.getElementById("old_password");
    if (y.type === "password") {
        y.type = "text";
    } else {
        y.type = "password";
    }
}