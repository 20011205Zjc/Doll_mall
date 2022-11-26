window.onload = function(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        const address = JSON.parse(xhr.responseText);
        let html=""
        for (let i = 0;i<=34;i++){
            html += "<option>"+address[i].name+"</option>"
            document.getElementById("province").innerHTML = html
        }
    }
    xhr.open("GET","/getProvince",true)
    xhr.send()
}

/*根据省份的名字查询省份下面的市*/
function pe(){
    var xhr = new XMLHttpRequest();
    document.getElementById("city").innerHTML = "<option>--市--</option>"
    document.getElementById("area").innerHTML = "<option>--区--</option>"
    var province = document.getElementById("province").value;
    var fm = new FormData;
    fm.append("name",province)
    xhr.onreadystatechange = function (){
        console.log(xhr.responseText)
        const address = JSON.parse(xhr.responseText);
        let html=""
        for (let i = 0;i<=34;i++){
            html += "<option>"+address[i].cityName+"</option>"
            console.log(html)
            document.getElementById("city").innerHTML = html
        }
    }
    xhr.open("POST","/city",true)
    console.log(fm)
    xhr.send(fm)
}

/*根据市查询市下的区*/
function cy(){
    document.getElementById("area").innerHTML = "<option>--区--</option>"
    var xhr = new XMLHttpRequest();
    var province = document.getElementById("city").value;
    var fm = new FormData;
    fm.append("name",province)
    xhr.onreadystatechange = function (){
        console.log(xhr.responseText)
        const address = JSON.parse(xhr.responseText);
        let html=""
        for (let i = 0;i<=34;i++){
            html += "<option>"+address[i].areaName+"</option>"
            console.log(html)
            document.getElementById("area").innerHTML = html
        }
    }
    xhr.open("POST","/area",true)
    console.log(fm)
    xhr.send(fm)
}

/*修改*/
var update;
function updateAddress(){
    update = false;
}

/*地址验证{如果没有地址的话}*/
function userAddress(){
    try {
        var pr = document.getElementById("province").value;
        var city = document.getElementById("city").value;
        var area = document.getElementById("area").value;
        var ar = document.getElementById("ar").value;
        var address = document.getElementById("address").value;
        var getAddress = document.getElementById("getAddress").value;
        if (pr === "--省份--" || pr === null||city==="--市--"||city==null||area==="--区--"||area===null){
            document.getElementById("error").innerHTML = ""
            document.getElementById("error").innerHTML = "地址格式错误"
        }else {
            if (address === "" || address ===null) {
                document.getElementById("error").innerHTML = ""
                document.getElementById("error").innerHTML = "详细地址不可为空！"
            }else {
                if (area ===ar && address ===getAddress){
                    document.getElementById("error").innerHTML = ""
                    document.getElementById("error").innerHTML = "地址已存在！"
                }else {
                    var addForm = document.getElementById("addForm");
                    console.log(update)
                    if (update !==false ){
                        addForm.action = "/userAddress"
                        addForm.submit();
                    }else {
                        var userAreaId = document.getElementById("xgId").value;
                        addForm.action = "/updateAddress?userAreaId="+userAreaId+""
                        addForm.submit();
                    }

                }
            }
        }
    }catch (e) {
        var addForm2 = document.getElementById("addForm");
        addForm2.action = "/userAddress"
        addForm2.submit();
    }

}

/*function scQ(){
    document.getElementById("userAreaId").value  = document.getElementById("Uid").value
    document.getElementById("userId").value  = document.getElementById("ui").value

    alert("log1:"+document.getElementById("userAreaId").value)
    alert("log2:"+document.getElementById("userId").value)


}*/
