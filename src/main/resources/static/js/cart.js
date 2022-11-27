/*刷新页面操作*/
function re(){
    location.reload();
}

//删除确认
function confirm(cartId){
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

/*删除所有的信息*/
/*function delAll(userId){
    var fm = new FormData;
    fm
}*/

function delAll(){
    var userId = document.getElementById("userId").value;
    var fm = new FormData;
    fm.append("id",userId);
    hsycms.confirm('确定要这么做',
        function(res){
        var xhr = new XMLHttpRequest();
        xhr.open("POST","/delCartById",false);
        xhr.send(fm)
            hsycms.success('确定清空购物车！');
            setTimeout(function() {re()}, 1500);  //1.5秒后将会调用执行remind()函数
        },
        function(res){
            hsycms.fail('取消');
        },
    )
}