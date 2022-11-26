function search(){
    console.log("hi在")
    var goodsName = document.getElementById("goodsName").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("goodsDescribe1",goodsName)
    xhr.onreadystatechange = function (){
        var json = JSON.parse(xhr.responseText);
        console.log(json)
        //便利json数据
        let html=""
        var array = Object.keys(this.responseText);
        console.log(array.length)
        if (array.length === 2){
            console.log("空的")
            document.getElementById("lx").innerHTML = "<em style='font-family: STHupo;margin-left: 200px'>"+"未找到"+"</em>"
        }
        for (let i = 0;i<= 5;i++){
            html += "<p onclick='setInput(\""+json[i].goodsDescribe1+"\")'>"+json[i].goodsDescribe1+"</p>"
            document.getElementById("lx").innerHTML = html
            document.getElementById("lx").style.display = "block"
        }
        if (goodsName === "" || goodsName === null){
            console.log("执行了这个")
            document.getElementById("lx").style.display = "none"
        }

        if (Object.keys(this.responseText).length === 0){
            alert(xhr.responseText)
            console.log("执行了这个")
            document.getElementById("lx").style.display = "none"
        }


    }
    xhr.open("POST","/likeGetGoods",true)
    xhr.send(fm)
}

function setInput(goodsDescribe1){
    document.getElementById("goodsName").value = goodsDescribe1
    document.getElementById("lx").style.display = "none"
}

/*判断输入是否为空*/
function isEmp(){
    var goodsName = document.getElementById("goodsName").value;
    var gn = goodsName.replace(/\s*/g,"");//去除字符串中的空格
    if (gn===null || gn===""){
        alert("搜索框为空！")
    }else {
        var search = document.getElementById("searchForm");
        search.submit()
    }
}