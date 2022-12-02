var flag;
function tu1(){
    var file = document.getElementById("gh1").files[0];
    var fm = new FormData();
    fm.append('file', file);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if (this.readyState===4 && this.status===200){
            // document.getElementById("photo").innerHTML = this.responseText
            var obj = document.getElementById("tp1");
            /*设置图片中src的属性为发回来的值*/
            obj.setAttribute("src",this.responseText)
            document.getElementById("gh11").value = this.responseText
        }
    }
    xhr.open('POST', '/PhotoUp');
    xhr.send(fm);
}

function tu2(){
    var file = document.getElementById("gh2").files[0];
    var fm = new FormData();
    fm.append('file', file);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if (this.readyState===4 && this.status===200){
            // document.getElementById("photo").innerHTML = this.responseText
            var obj = document.getElementById("tp2");
            /*设置图片中src的属性为发回来的值*/
            obj.setAttribute("src",this.responseText)
            document.getElementById("gh22").value = this.responseText
        }
    }
    xhr.open('POST', '/PhotoUp');
    xhr.send(fm);
}

function tu3(){
    var file = document.getElementById("gh3").files[0];
    var fm = new FormData();
    fm.append('file', file);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if (this.readyState===4 && this.status===200){
            // document.getElementById("photo").innerHTML = this.responseText
            var obj = document.getElementById("tp3");
            /*设置图片中src的属性为发回来的值*/
            obj.setAttribute("src",this.responseText)
            document.getElementById("gh33").value = this.responseText
        }
    }
    xhr.open('POST', '/PhotoUp');
    xhr.send(fm);
}
function tu4(){
    var file = document.getElementById("gh4").files[0];
    var fm = new FormData();
    fm.append('file', file);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if (this.readyState===4 && this.status===200){
            // document.getElementById("photo").innerHTML = this.responseText
            var obj = document.getElementById("tp4");
            /*设置图片中src的属性为发回来的值*/
            obj.setAttribute("src",this.responseText)
            document.getElementById("gh44").value = this.responseText
        }
    }
    xhr.open('POST', '/PhotoUp');
    xhr.send(fm);
}

function tu5(){
    var file = document.getElementById("gh5").files[0];
    var fm = new FormData();
    fm.append('file', file);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if (this.readyState===4 && this.status===200){
            // document.getElementById("photo").innerHTML = this.responseText
            var obj = document.getElementById("tp5");
            /*设置图片中src的属性为发回来的值*/
            obj.setAttribute("src",this.responseText)
            document.getElementById("gh55").value = this.responseText
        }
    }
    xhr.open('POST', '/PhotoUp');
    xhr.send(fm);
}

function goodsname(){
    var goodsName = document.myForm.goodsName.value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("goodsName",goodsName)
    if (document.getElementById("hiName").value === goodsName){
        flag = true
        alert(23)

    }else {
        xhr.onreadystatechange = function (){
            if (this.responseText === "1"){
                document.getElementById("em1").innerHTML = ""
                flag = false
                document.getElementById("em1").innerHTML = "商品的名称已经存在！"
            }else if (this.responseText === "2"){
                var pattern = /(^[A-Za-z0-9_\-\u4e00-\u9fa5]{1,16}$)+/
                var ok = pattern.test(goodsName);
                console.log(goodsName)
                if (!ok){
                    document.getElementById("em1").innerHTML = ""
                    flag = false
                    document.getElementById("em1").innerHTML = "商品的名称格式不正确！"

                }else {
                    flag = true
                }
            }
        }
    }
    xhr.open("POST","/goodsCF",true)
    xhr.send(fm)
}

function goodsname2(){
    document.getElementById("em1").innerHTML = ""
}


function gp(){
    var goodsPrice = document.myForm.goodsPrice.value;
    var pattern = /(?:^[1-9]([0-9]+)?(?:\.[0-9]{1,2})?$)|(?:^(?:0){1}$)|(?:^[0-9]\.[0-9](?:[0-9])?$)/
    var ok = pattern.test(goodsPrice);
    if (ok){

    }else {

    }
}

function gp2(){
    document.getElementById("em2").innerHTML = ""
}

/*描述进行检查*/
/*
function d1(){
    var gd1 = document.getElementById("gd1").value;
    if (gd1 === null || gd1 === ""){
        flag = false
        document.getElementById("gd11").innerHTML = "内容不正确！"
    }else {
        flag = true
    }
}

function d11(){
    document.getElementById("gd11").innerHTML = ""
}

function d2(){
    var gd1 = document.getElementById("gd2").value;
    if (gd1 === null || gd1 === ""){
        flag = false
        document.getElementById("gd22").innerHTML = "内容不正确！"
    }else {
        flag = true
    }
}

function d22(){
    document.getElementById("gd22").innerHTML = ""
}

function d3(){
    var gd1 = document.getElementById("gd3").value;
    if (gd1 === null || gd1 === ""){
        flag = false
        document.getElementById("gd33").innerHTML = "内容不正确！"
    }else {
        flag = true
    }
}

function d33(){
    document.getElementById("gd33").innerHTML = ""
}

function d4(){
    var gd1 = document.getElementById("gd4").value;
    if (gd1 === null || gd1 === ""){
        flag = false
        document.getElementById("gd44").innerHTML = "内容不正确！"
    }else {
        flag = true
    }
}

function d44(){
    document.getElementById("gd44").innerHTML = ""
}

function d5(){
    var gd1 = document.getElementById("gd5").value;
    if (gd1 === null || gd1 === ""){
        flag = false
        document.getElementById("gd55").innerHTML = "内容不正确！"
    }else {
        flag = true
    }
}

function d55(){
    document.getElementById("gd55").innerHTML = ""
}
*/


function sub(){
/*    goodsname2()
    goodsname()*/
/*    if (flag){*/
        var myFrom = document.getElementById("myForm1");
    console.log(123)
    try {
        if (document.getElementById("goodsX").value==='' || document.getElementById("goodsX").value===null ){
            document.getElementById("goodsX").value=0
        }
        if (document.getElementById("goodsS").value==='' || document.getElementById("goodsS").value===null ){
            document.getElementById("goodsS").value=0
        }
        if (document.getElementById("goodsM").value==='' || document.getElementById("goodsM").value===null ){
            document.getElementById("goodsM").value=0
        }
    }catch (e){
        myFrom.submit();
        alert("修改成功")
    }


/*    }else {
        alert(flag)
        alert("格式有误，请检查")
    }*/

}

