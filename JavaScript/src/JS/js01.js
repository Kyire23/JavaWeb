/*
alert("Welcome to my JavaScript page!");
if (confirm("Are you sure you want to do that?")) {
    alert("You said yes");
}
else {
    alert("You said no");
}

var ans = prompt("Are you sure you want to do that?","");
if (ans) {
    alert("You said " + ans);
}
else {
    alert("You refused to answer");
}*/

window.onload = initAll;

function initAll(){
    document.getElementById("redirect").onclick = initRedirect;
}

function initRedirect() {
    alert("We are not responsible for the content of pages outside our site");
    window.location = this;
    return false;
}

