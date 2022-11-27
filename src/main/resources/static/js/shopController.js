function update(){
    var updateGoods = document.getElementById("updateGoods");
    updateGoods.submit();
}

/*刷新页面操作*/
function re(){
    location.reload();
}
/*删除确认*/
function confirm(id){
    var fm = new FormData;
    fm.append("id",id)
    hsycms.confirm('确定要这么做',
        function(res){
        var xhr = new XMLHttpRequest();
        xhr.open("POST","/delGoods",false);
        xhr.send(fm)
            hsycms.success('点击了确定');
            setTimeout(function() {re()}, 1500);  //1.5秒后将会调用执行remind()函数
        },
        function(res){
            hsycms.fail('点击了取消');
        },
    )
}
