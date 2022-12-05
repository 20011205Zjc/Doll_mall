window.onload = function (){
    var t2 = document.getElementById("t2").innerHTML;
    for (var i = 1;i<=4;i++){
        var li = document.getElementById(i.toString()).innerHTML;
        if (t2 === li){
            document.getElementById(i.toString()).classList.add('text-primary')
        }
    }
}

