/*刷新页面操作*/
function re(){
    location.reload();
}

//删除确认
function confirm(cartId){
    alert(cartId)
    var fm = new FormData;
    fm.append("id",cartId)
    hsycms.confirm('确定要这么做',
        function(res){
        var xhr = new XMLHttpRequest();
        xhr.open("POST","/delCartById",false);
        xhr.send(fm)
            hsycms.success('删除成功！');
            setTimeout(function() {re()}, 1500);  //1.5秒后将会调用执行remind()函数
        },
        function(res){
            hsycms.fail('删除失败！');
        },
    )
}


/*清空购物车*/
function delAll(){
    var userId = document.getElementById("userId").value;
    var fm = new FormData;
    fm.append("id",userId);
    hsycms.confirm('确定要这么做',
        function(res){
        var xhr = new XMLHttpRequest();
        xhr.open("POST","/delAll",false);
        xhr.send(fm)
            hsycms.success('清空购物车成功！');
            setTimeout(function() {re()}, 1500);  //1.5秒后将会调用执行remind()函数
        },
        function(res){
            hsycms.fail('取消');
        },
    )
}

window.onload = function (){
    var checkout = document.getElementById("flexCheckDefault").checked;
    if (checkout){
        document.getElementById("js").style.display = "none"
    }else {
        document.getElementById("js").style.display = "none"
    }
}

/**/
    function hhh(){
        var checkout=false;
        var tr = document.getElementById("table").rows.length;
        for (var i = 1;i<=tr-1;i++){
            if (document.getElementById(i.toString()).checked){
                var id = document.getElementById(i.toString()).value;
                checkout = true
                var xhr = new XMLHttpRequest();
                var fm = new FormData;
                fm.append("id",id)
                xhr.open("POST","/getMiddle",true)
                xhr.send(fm)

                /**/
                xhr.onreadystatechange = function (){
                    if (this.responseText === "1"){
                        var middleForm = document.getElementById("middleForm");
                        middleForm.submit();
                    }
                }


            }else {
                if (!checkout){
                    var txt="请选择结算商品！";
                    // function tips(txt){
                        hsycms.tips(txt,()=>{
                            console.log("请选择结算商品！");
                        },2500)
                    // }
                }
            }
        }
    }



