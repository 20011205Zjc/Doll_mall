
/*定义全局变量*/

/*注意拦截器要放行ajax请求*/

var namee;
var pwwd;
var ppwd = true;
var emaill;
var codee;
var agee;

/*使用ajax实现邮箱验证码的发送*/
function getCode(){
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
        }
        xhr.open("POST", "/getCode", true)
        console.log("执行了")
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
        var email = document.getElementById("email").value;
        xhr.send("email=" + email)
}

/*失去焦点时，通过ajax查询用户名是否已经存在*/
function username1(){
    console.log("ajax的1")
    var xhr = new XMLHttpRequest();
    var username = document.getElementById("username").value;
    console.log(username)
    username = username.replace(/\s*/g,"");
    var fm = new FormData;
    if (username != null){
        fm.append("username",username)
    }
    xhr.onreadystatechange = function (){
        console.log("ajax的2"+this.responseText)
        if (this.responseText !=="1"){
            document.getElementById("user1").innerHTML =""
            document.getElementById("user").innerHTML = "这个名字太受欢迎了😊"
        }else if (this.responseText === "1"){
            var username = document.getElementById("username").value;
            var pattern = /(^[A-Za-z0-9_\-\u4e00-\u9fa5]{2,16}$)+/
            var ok = pattern.test(username);
            if (ok){
                //合法
                document.getElementById("user1").innerHTML =""
                namee = true
                document.getElementById("user").innerHTML = "✅"
            }else {
                document.getElementById("user1").innerHTML =""
                namee = false
                document.getElementById("user").innerHTML = "用户名格式不正确！"
            }

        }

    }
    xhr.open("POST","/repeat",true)
    console.log(username)
    xhr.send(fm)
}

/*删除提醒，并提醒用户要输入的格式*/
function del(){
    document.getElementById("user").innerHTML =""
    document.getElementById("user1").innerHTML = "用户名可以是[2~16]位汉字、英文字母、数字或_";
}

/*通过ajax查询邮箱是否已经存在*/
function eml(){
    var xhr = new XMLHttpRequest();
    var email = document.getElementById("email").value;
    email = email.replace(/\s*/g,"");
    var fm = new FormData;
    if (email != null){
        fm.append("email",email)
    }

    xhr.onreadystatechange = function (){
        var email = document.getElementById("email").value;
        if (this.responseText === "邮箱已存在，请登录！"){
            document.getElementById("em").innerHTML = this.responseText
        }else if (this.responseText === "1"){
            var pattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/
            var ok = pattern.test(email);
            if (ok){
                //合法
                document.getElementById("em").innerHTML = ""
                emaill = true
                document.getElementById("em").innerHTML = "✅"

            }else {
                //不和法
                document.getElementById("em").innerHTML = ""
                emaill = true;
                document.getElementById("em").innerHTML = "邮箱格式不正确！"
            }

        }


    }
    xhr.open("POST","/eml",true)
    xhr.send(fm)

}

/*删除提醒*/
function del2(){
    document.getElementById("em").innerHTML = "";
}

/*密码的匹配*/
function pwd(){
    var password = document.getElementById("password").value;
    var pattern = /(^[A-Za-z0-9_]{6,16}$)+/
    var ok = pattern.test(password);
    if (ok){
        //合法
        document.getElementById("pwd1").innerHTML = ""
        pwwd = true;
        document.getElementById("pwd").innerHTML = "✅"
    }else {
        //不合法
        document.getElementById("pwd1").innerHTML = ""
        pwwd = false;
        document.getElementById("pwd").innerHTML = "密码格式不正确！"
    }

}
/*提醒密码的格式*/
function pwd2(){
    document.getElementById("pwd").innerHTML = ""
    document.getElementById("pwd1").innerHTML = "密码可以是[6~16]位英文字母、数字或_"
}

/*匹配确认密码*/
function pwd3(){
    var password = document.getElementById("password").value;
    var RP = document.getElementById("RP").value;
    if (password !== RP){
        //不一致
        document.getElementById("Rpwd").innerHTML= ""
        ppwd = false
        document.getElementById("Rpwd").innerHTML = "两次密码不一致！"
    }else {
        //一致但是如果时空的就不提醒
        password = password.replace(/\s*/g,"");
        if (password !== ""){
            ppwd = true
            document.getElementById("Rpwd").innerHTML= ""
            document.getElementById("Rpwd").innerHTML= "✅"
        }
    }
}

/*删除提醒*/
function pwd4(){
    document.getElementById("Rpwd").innerHTML = ""
}

/*验证码删除提醒*/
function coded(){
    document.getElementById("codeError").innerHTML =""
}

/*验证码失去焦点验证*/
function yz(){
    var code = document.getElementById("code").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("getCode",code)
    xhr.onreadystatechange = function (){
        if (this.responseText === "2"){
            codee = false
            document.getElementById("codeError").innerHTML = "验证码错误！"
        }else {
            codee = true
        }
    }
    xhr.open("POST","/YZCode",true)
    xhr.send(fm)
}

function zc(){
    var age = document.getElementById("userage").value;
    if (age === ""){
        agee = false
        document.getElementById("age").innerHTML = "请选择生日！"
    }else {
        agee = true
    }

    console.log(namee)
    console.log(pwwd)
    console.log(1)
    console.log(ppwd)
    console.log(codee)
    console.log(emaill)
    /*点击注册按钮时对所有的文本框进行：获取焦点和失去焦点操作，判断所有的输入是否都正确*/
    del()
    username1()
    pwd2()
    pwd()
    pwd4()
    pwd3()
    del2()
    eml()
    coded()
    yz()
    /*人工都合法就放行提交*/
    if (namee&&pwwd&&ppwd&&codee&&emaill&&agee){
        alert("注册成功！")
        var MyForm = document.getElementById("MyForm");
        MyForm.submit();
        alert("tjiao")
    }

}