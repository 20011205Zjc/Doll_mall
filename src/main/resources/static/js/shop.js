let code;
let flag;

function codeShop(){
    var userEmail = document.getElementById("userEmail").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("email",userEmail)
    xhr.onreadystatechange = function (){
        console.log(this.responseText)
        code = this.responseText
    }
    xhr.open("POST","/getCode",true)
    xhr.send(fm)
}

function ShopFile(){
    var file = document.getElementById("shopPhoto").files[0];
    var fm = new FormData();
    fm.append('file',file)
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        var obj = document.getElementById("tx");
        obj.setAttribute("src",this.responseText)
        document.getElementById("tx1").value = this.responseText
    }
    xhr.open("POST","/PhotoUp")
    xhr.send(fm)
}

/*失去焦点时验证商店名字*/
function shopNameB(){
    var shopName = document.getElementById("shopName").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("shopName",shopName)
    xhr.onreadystatechange = function (){
        if (this.responseText === "1"){
            document.getElementById("shopError").innerHTML = "";
            document.getElementById("shopError").innerHTML = "商店的名称已经存在";
            flag = false
        }else if (this.responseText === "2"){
            var pattern = /(^[A-Za-z0-9_\-\u4e00-\u9fa5]{2,16}$)+/
            var ok = pattern.test(shopName);
            if (ok){
                flag = true
                document.getElementById("shopError").innerHTML = "";
                document.getElementById("shopError").innerHTML = "✅";
            }else {
                flag = false
                document.getElementById("shopError").innerHTML = "";
                document.getElementById("shopError").innerHTML = "商店的名称格式不正确！";
            }
        }
    }
    xhr.open("POST","/shopName",true)
    xhr.send(fm)
}

function shopNameF(){
    document.getElementById("shopError").innerHTML = "";
}
let sd;
function sdB(){
    var shopDescribe = document.getElementById("shopDescribe").value;
    var pattern = /(^[A-Za-z0-9_\-\u4e00-\u9fa5]{5,25}$)+/
    var ok = pattern.test(shopDescribe);
    if (ok){
        document.getElementById("sdError").innerHTML = ""
        document.getElementById("sdError").innerHTML = "✅"
        sd = true
    }else {
        document.getElementById("sdError").innerHTML = ""
        document.getElementById("sdError").innerHTML = "描述的格式不正确！"
        sd = false
    }
}
function sdF(){
    document.getElementById("sdError").innerHTML = ""
}

function tj(){
    shopNameF()
    shopNameB()
    sdB()
    sdB()
    var code1 = document.getElementById("code").value;
    if (code1 === code && flag && sd){
        var shopForm = document.getElementById("shopForm");
        alert("申请成功，请重新登陆！")
        shopForm.submit()
    }else if (code1 !== code){
        alert("验证码错误！")
    }
}