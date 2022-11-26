/*ajax上传图片*/
function upload() {
    /*var headPhoto = document.from.userId.value;*/
    var file = document.myForm1.file.files[0];
    var fm = new FormData();
    /*fm.append('headPhoto', headPhoto);*/
    fm.append('file', file);
    var xhr = new XMLHttpRequest();
    console.log(2233);
    xhr.onreadystatechange = function (){
        if (this.readyState===4 && this.status===200){
            // document.getElementById("photo").innerHTML = this.responseText
            var obj = document.getElementById("imgg");
            /*设置图片中src的属性为发回来的值*/
            obj.setAttribute("src",this.responseText)
            document.getElementById("headP").value = this.responseText
        }
    }
    xhr.open('POST', '/PhotoUp',true);
    xhr.send(fm);
}

var upUser;
function user11(){
    var user1 = document.getElementById("user1").value;
    var userC = document.getElementById("userC").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("username",user1)
    xhr.onreadystatechange = function (){

        /*得到后端的返回值*/
        var rp = this.responseText;
        if (userC === user1){
            /*没有改名字*/
            upUser = true
            document.getElementById("user3").innerHTML =""
            document.getElementById("user2").innerHTML = "✅"
        }else {
            if (rp === "1"){
                var pattern = /(^[A-Za-z0-9_\-\u4e00-\u9fa5]{2,16}$)+/
                var ok = pattern.test(user1);

                if (ok){
                    //匹配
                    console.log("正则匹配")
                    document.getElementById("user3").innerHTML =""
                    upUser = true
                    document.getElementById("user2").innerHTML = "✅"
                }else {
                    //不匹配
                        upUser = false
                    console.log("正则不匹配")
                        document.getElementById("user3").innerHTML =""
                        document.getElementById("user2").innerHTML = "用户名格式不正确！"

                }
            }else {
                if (rp !== ""){
                    console.log("用户名已存在："+rp)
                    document.getElementById("user3").innerHTML =""
                    upUser = false
                    document.getElementById("user2").innerHTML = "用户名已存在"
                }
                }
        }
    }
    xhr.open("POST","/repeat",true)
    xhr.send(fm)
}

function user3(){
    document.getElementById("user2").innerHTML =""
    document.getElementById("user3").innerHTML = "用户名可以是[2~16]位汉字、英文字母、数字或_"
}

/*修改的提交*/
function sub(){
    user3()
    user11()
    console.log("true/false:"+upUser)
    if (upUser){
        var myForm = document.getElementById("myForm");
        myForm.submit();
    }

}