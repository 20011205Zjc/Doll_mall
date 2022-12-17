var zj;
var size;
window.onload = function (){
    document.getElementById("div1").style.display = "none"
    document.getElementById("div2").style.display = "none"
    // setTimeout(function() {yc()}, 1500);  //2秒后将会调用执行remind()函数
    yc();

   zj = document.getElementById("zj").innerHTML;//初始值
    zj = Number(zj)
    console.log(zj)
}

function yc(){
    // alert(document.getElementById("kc").innerHTML)
    if (document.getElementById("kc").innerHTML === "0"){
        document.getElementById("loading").style.display = "none"
        document.getElementById("div1").style.display = "none"
        document.getElementById("div2").style.display = "block"
    }else {
        document.getElementById("div1").style.display = "block"
        document.getElementById("div2").style.display = "none"
        document.getElementById("loading").style.display = "none"

    }
}

function bt11(){
    var bt3 = document.getElementById("bt3").value;
    bt3 = Number(bt3)
    if (bt3 === 1){
        console.log(2233)
        alert("数量已经为1啦~~")
    }else {
        var zj1 = document.getElementById("zj").innerHTML;
        zj1 = Number(zj1)
        zj1 = zj1-zj
        document.getElementById("zj").innerHTML = zj1
        bt3 = bt3 - 1
        document.getElementById("bt3").value = bt3
        document.getElementById("bt3").innerHTML = bt3
    }
}

function btn22(){
    var bt3 = document.getElementById("bt3").value;
    bt3 = Number(bt3)
    var kc = document.getElementById("kc").innerHTML;
    kc = Number(kc)
    console.log(kc===bt3)
    if (bt3===kc || kc === 0 || kc === undefined || kc === null || kc === ""){
        alert("商品的库存不足啦")

    }else {
        bt3 = bt3 + 1
        var zj2 = document.getElementById("zj").innerHTML;
        zj2 = Number(zj2)
        zj2 = zj2 + zj;
        document.getElementById("zj").innerHTML = zj2
        document.getElementById("bt3").value = bt3
        document.getElementById("bt3").innerHTML = bt3
    }
}


function S(){
    size = "S";
    document.getElementById("loading").style.display = "block"
    document.getElementById("div2").style.display = "none"
    document.getElementById("div1").style.display = "none"
    document.getElementById("bt3").value = 1
    document.getElementById("zj").innerHTML = document.getElementById("dj").innerHTML
    document.getElementById("bt3").innerHTML = "1"
    var goodsId = document.getElementById("goodsId").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("size","S")
    fm.append("goodsId",goodsId)
    xhr.onreadystatechange = function (){
        document.getElementById("kc").innerHTML = this.responseText
    }
    xhr.open("POST","/size",true)
    xhr.send(fm)

    setTimeout(function() {yc()}, 2000);
    console.log("zg")

}

function M(){
    size = "M";
    document.getElementById("loading").style.display = "block"
    document.getElementById("div2").style.display = "none"
    document.getElementById("div1").style.display = "none"
    // alert(document.getElementById("kc").innerHTML)
    document.getElementById("bt3").value = 1
    document.getElementById("zj").innerHTML = document.getElementById("dj").innerHTML
    document.getElementById("bt3").innerHTML = "1"
    var goodsId = document.getElementById("goodsId").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("size","M")
    fm.append("goodsId",goodsId)
    xhr.onreadystatechange = function (){
        document.getElementById("kc").innerHTML = this.responseText
    }
    xhr.open("POST","/size",true)
    xhr.send(fm)

    setTimeout(function() {yc()}, 2000);
    console.log("zg")
}

function X(){
    size = "X"
    document.getElementById("loading").style.display = "block"
    document.getElementById("div2").style.display = "none"
    document.getElementById("div1").style.display = "none"
    document.getElementById("bt3").value = 1
    document.getElementById("zj").innerHTML = document.getElementById("dj").innerHTML
    document.getElementById("bt3").innerHTML = "1"
    var goodsId = document.getElementById("goodsId").value;
    var xhr = new XMLHttpRequest();
    var fm = new FormData;
    fm.append("size","X")
    fm.append("goodsId",goodsId)
    xhr.onreadystatechange = function (){
        document.getElementById("kc").innerHTML = this.responseText
    }
    xhr.open("POST","/size",true)
    xhr.send(fm)

    setTimeout(function() {yc()}, 2000);
    console.log("zg")
}


window.alert = function(msg){
    var maskBg = '#0000002b';						//蒙版展示色
    var zIndex = 999999;							//修改弹出层z-index,应为最顶层,避免被覆盖
    var desColor = '#1f0000'						//提示信息字体颜色
    var buttonVal = '确定';							//确定按钮名称
    var btnBgColor = '#f61717';						//确定按钮背景颜色
    var btnColor = '#fff';							//确定按钮字体颜色
    var btnAlign = 'right';							//按钮在水平位置,默认居中,变量值:left,center,right
    var style = `
			<style class="mask-style">
				.box-sizing{
					box-sizing: border-box;
				}
				.alertMask{
					position: fixed;	/*生成绝对定位的元素，相对于浏览器窗口进行定位*/
					display: flex;
					display: webkit-flex;
					flex-direction: row;
					align-items: center;
					justify-content: center;
					width: 100%;
					height: 100%;
					top: 0;
					left: 0;
					z-index: `+zIndex+`;
					background: `+maskBg+`;
				}
				.alertContainer{
					min-width: 240px;	/*容器最小240px*/
					max-width: 320px;	/*容器最大320px*/
					background:#fff;
					border: 1px solid `+maskBg+`;
					border-radius: 3px;
					color: `+desColor+`;
					overflow: hidden;
					border-radius:30px;
				}
				.alertDes{
					padding: 35px 30px;
					text-align: center;
					letter-spacing: 1px;
					font-size: 14px;
					color: `+desColor+`;
				}
				.alertDes img{
					max-width: 100%;
					height: auto;
				}
				.alertConfirmParent{
					width: 100%;
					padding: 20px 30px;
					text-align: `+btnAlign+`;
					box-sizing: border-box;
					background: #f2f2f2;
				}
				.alertConfirmBtn{
					cursor: pointer;
					padding: 8px 10px;
					border: none;
					border-radius: 2px;
					color: `+btnColor+`;
					background-color: `+btnBgColor+`;
					box-shadow: 0 0 2px `+btnBgColor+`;
				}
			</style>
		`;

    var head = document.getElementsByTagName('head')[0];
    head.innerHTML += style		//头部加入样式,注意不可使用document.write()写入文件,否则出错

    const body = document.getElementsByTagName('body')[0];

    var alertMask = document.createElement('div');
    var alertContainer = document.createElement('div');
    var alertDes = document.createElement('div');
    var alertConfirmParent = document.createElement('div');
    var alertConfirmBtn = document.createElement('button');

    body.append(alertMask);
    alertMask.classList.add('alertMask');
    alertMask.classList.add('box-sizing');

    alertMask.append(alertContainer);
    alertContainer.classList.add('alertContainer');
    alertContainer.classList.add('box-sizing');

    alertContainer.append(alertDes);
    alertDes.classList.add('alertDes');
    alertDes.classList.add('box-sizing');

    alertContainer.append(alertConfirmParent);
    alertConfirmParent.classList.add('alertConfirmParent');
    alertConfirmParent.classList.add('box-sizing');

    alertConfirmParent.append(alertConfirmBtn);
    alertConfirmBtn.classList.add('alertConfirmBtn');
    alertConfirmBtn.classList.add('box-sizing');
    alertConfirmBtn.innerText = buttonVal;

    //加载提示信息
    alertDes.innerHTML = msg;
    //关闭当前alert弹窗
    function alertBtnClick(){
        body.removeChild(alertMask);
        maskStyle = head.getElementsByClassName('mask-style')[0];
        head.removeChild(maskStyle);	//移除生成的css样式

    }
    alertConfirmBtn.addEventListener("click", alertBtnClick);
}

/*加入购物车*/
function cart(){
    if (size === null || size ==="" || size === undefined){
        size = "S"
    }else {
        console.log("2233")
    }
    var bts = document.getElementById("bt3").value;
    document.getElementById("count").innerHTML = bts;
    document.getElementById("con").value=bts
    document.getElementById("se").value=size
    document.getElementById("size").innerHTML = size
    document.getElementById("countYuan").innerHTML = document.getElementById("zj").innerHTML
    document.getElementById("total").value = document.getElementById("zj").innerHTML

}

/*立即购买*/
function bty(){
   cart();
   var cartFrom = document.getElementById("CartFrom");
   cartFrom.action = "/checkout"
    cartFrom.submit();
}