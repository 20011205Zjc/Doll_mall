var ad=true
function checkOut(){
    var myUl = document.getElementById("myUl");
    var li = myUl.getElementsByTagName("li").length-2;
    var address = document.getElementById("address");
    if (address.options.length===0){
        //地址为空
        ad = false

    }else {
        ad = true
    }
    var form = document.getElementById("checkOutForm");
    if (ad){

        var form = document.getElementById("checkOutForm");
        /*================提交订单=====================*/
        for (var i = 1;i<=li;i++){
            var goodsId = document.getElementById("goodsId"+i).value;
            var size = document.getElementById("size"+i).value;
            var count = document.getElementById("count"+i).value;
            var cartId = document.getElementById("cartId"+i).value;
            var xhr = new XMLHttpRequest();
            var fm = new FormData;
            fm.append("goodsId",goodsId)
            fm.append("size",size)
            fm.append("count",count)
            fm.append("cartId",cartId)
            xhr.onreadystatechange= function (){

            }
            xhr.open("POST","/checkOut",true)
            xhr.send(fm)
        }

        /*=======================================*/
        form.submit();
        form.action = "/success"

    }else {
        alert("地址为空，请添加地址！")
    }
    alert("提交成功！")
}
