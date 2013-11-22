<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
request.setAttribute("basePath", request.getContextPath());//relative 
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内测版</title>
</head>

<script>  
clickType = "" ;
cw = "" ;
xPx = -100 ;
yPx = -100 ;
xPxTemp = 0 ;
yPxTemp = 0 ;
function recordPark(){
	clickType="park" ;
};
function parkOver(){
	clickType="" ;
};
function confirmRecord() {
	xPx = xPxTemp ;
	yPx = yPxTemp ;
};
function concelRecord(){
	showPark(xPx,yPx) ;
};
function showPark(x,y) {
	var objectPerson = document.getElementById('carModule');
	objectPerson.setAttribute('transform', 'matrix(0.07,0,0,0.06,' + x + ',' + y + ')');
	objectPerson.style.display = "block" ;
};
function parkInfo(cw,x,y) {
    var sUrl = '#localcmd:fun=parkInfo&cwName=' + cw   + '&x=' + x + '&y=' + y + '&rnd=' + Math.round(Math.random() * 1800);
    document.location = sUrl;
};


function showPerson(x,y) {
	x = x - 50 ;
	y = y + 50 ;
	var objectPerson = document.getElementById('personModule');
	objectPerson.setAttribute('transform', 'matrix(0.5,0,0,-0.5,' + x + ',' + y + ')');
	objectPerson.style.display = "block" ;
	
};
function hideOrShowTag(className,flag) {
	var displayStr = "none" ;
	if(flag)
		displayStr = "block" ;
	var tagArr = document.getElementsByClassName(className) ;
	for(var i=0;i<tagArr.length;i++) {
		tagArr[i].style.display = displayStr ;
	}
};
function showLid() {
	hideOrShowTag("tag_lid",true) ;
};
function hideLid() {
	hideOrShowTag("tag_lid",false) ;
};
function showWifi() {
	hideOrShowTag("tag_wifi",true) ;
};
function hideWifi() {
	hideOrShowTag("tag_wifi",false) ;
};

function hideElementsOfClass(className) {
	var tagArr = document.getElementsByClassName(className) ;
	for(var i=0;i<tagArr.length;i++){
		tagArr[i].style.display= "none" ;
	}
};
function showTip(evt) {
	var obj = evt.target ;
	if(clickType == "") {
		var idStr = obj.getAttribute("id") ;
		var divTip = document.getElementById("tip_" + idStr) ; 
		if(divTip != null) { 
			if(divTip.style.display == "block") {
				divTip.style.display = "none" ;
			} else {
				hideElementsOfClass("tip") ;
				var Left = evt.pageX;
			    var Top = evt.pageY;
			    var ssss = divTip.style ;
				divTip.style.left= (Left+10) + "px";
				divTip.style.top = (Top-30) + "px";
			    divTip.style.display= "block" ;
			}
		} else {
			hideElementsOfClass("tip") ;
		}
	} 
};

function showShopArea(svgId,px,py) {
	
	var divTip = document.getElementById("tip_" + svgId) ; 
	if(divTip != null) { 
		if(divTip.style.display == "block") {
			divTip.style.display = "none" ;
		} else {
			hideElementsOfClass("tip") ;
			var Left = px;
		    var Top = py;
		    var ssss = divTip.style ;
			divTip.style.left= (Left+10) + "px";
			divTip.style.top = (Top-30) + "px";
		    divTip.style.display= "block" ;
		}
	} else {
		hideElementsOfClass("tip") ;
	}
}

function cwClick(evt) {
	var obj = evt.target ;
	if(clickType=="park") {
		var x = obj.getAttribute("x")  ;
    	var y = obj.getAttribute("y")  ;
    	xPxTemp = parseFloat(x) - 5 ;
    	yPxTemp = parseFloat(y)-28 ;
    	showPark(xPxTemp,yPxTemp) ;
    	cw = obj.getAttribute("id") ;
    	parkInfo(cw,xPxTemp,yPxTemp) ;
	} else if(clickType == "") {
		showTip(evt) ;
	}
};
function cwMousemove(obj) {  
	obj.setAttribute("fill","#00ffaa")
};
function cwMouseout(obj) {
	obj.setAttribute("fill","#727171")
};

function showLines(line) {
	
    var obj = document.getElementsByTagName("svg") ;
	
	var paths = obj[0].getElementsByTagName("path") ;
	var temp = paths[0] ;
	
	var protory = temp.cloneNode(true) ;
	protory.setAttribute("stroke-width","5") ;
	protory.setAttribute("stroke","#ff0000") ;
	protory.setAttribute("fill","none" ) ;
	protory.setAttribute("onclick","") ;
	protory.setAttribute("class","line_class") ;
	var dLine = line.split(",") ;
    for(var a=0;a<dLine.length;a++) {
    	var path = protory.cloneNode(true) ;
    	path.setAttribute("d",dLine[a]) ;
        obj[0].appendChild(path);
    }
};

function hideLines() {
	var obj = document.getElementsByClassName("line_class") ;
	var len = obj.length ;
	for(var i=0;i<len;i++) {
		obj[0].setAttribute("class","old_line_class") ;
	}
}

function showLinesTest() {
	
	var d = [{"svgstr":"m 150.0 100.0 L260.75 49.624"},{"svgstr":"m 260.75 49.624 V 152 "},{"svgstr":"m 260.75 152.0 c 0 27.5 0 72.5 0 100 v 375.001 "},{"svgstr":"m 411.869 577.321 c 0 6.875 -5.625 12.5 -12.5 12.5 h -40.302 c -6.875 0 -12.5 5.625 -12.5 12.5 v 12.18 c 0 6.875 -5.625 12.5 -12.5 12.5 H 287 h -26.25 "},{"svgstr":"m 411.869 549.503 v 27.818 "},{"svgstr":"m 588.193 549.503 c -12.344 0 -44.941 0 -72.441 0 h -25 c -27.5 0 -56.498 0 -64.44 0 c -7.941 0 -14.439 0 -14.439 0 "},{"svgstr":"m 565.75 575.751 l 22.442999999999984 -26.247999999999934"}];
	var dLine = "" ;
    for(var a=0;a<d.length;a++) {
    	var str = d[a]["svgstr"] ;
    	dLine += str ;
    	if(a != d.length -1)
    		dLine += ","
    }
    showLines(dLine) ;
};

function showActivity(activitys) {
	activitys = "[{'name':'发布1','py':'442.0','px':'429.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布2','py':'372.0','px':'429.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布3','py':'302.0','px':'429.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布4','py':'138.25','px':'287.26','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布5','py':'139.5','px':'429.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布6','py':'232.0','px':'429.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布7','py':'575.75','px':'544.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布8','py':'575.75','px':'429.51','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布9','py':'370.75','px':'287.26','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布虚拟商家内容','py':'420.75','px':'287.26','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布虚拟商家内容','py':'215.75','px':'287.26','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布虚拟商家内容','py':'278.25','px':'287.26','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'},{'name':'发布虚拟商家内容','py':'0.0','px':'0.0','url':'http://3g.gooagoo.com/mm/info?para=3864f827b74b7621c320f93f2f404391ca5db7bc76bb27223a1920ac6a548bbb547b5e1a192614d4fd52f8f2bb6dab9bfbb1f242cd1e07874879eb905ba7966f2254c17ae0398b36'}]" ;
	var jsonObj = eval(activitys) ;
	var obj = document.getElementById("activity_div") ;
	var activityParent = document.getElementById("activity_parent") ;
	
	var s1 = "<span class='activity_text'>" ;
	var s2 = "<samp class='samp_3'>◆</samp></span>" ;
	
	for(var i=0;i<jsonObj.length;i++) {
		var x = jsonObj[i].px ;
		var y = jsonObj[i].py ;
		var act = obj.cloneNode(true) ;
		act.style.left = x + "px" ;
		act.style.top = y + "px" ;
		act.setAttribute("id","") ;
		act.setAttribute("class","activity_div") ;
		
		act.innerHTML = s1 + jsonObj[i].name + s2 ;
		
		act.setAttribute("onclick","sendActivityUrl('" + jsonObj[i].url + "')") ;
		activityParent.appendChild(act) ;
	}
};

function hideActivity() {
	var objs = document.getElementsByClassName("activity_div") ;
	var len = objs.length ;
	for(var i=0;i<len;i++) {
		objs[0].setAttribute("class","notDisplay") ; 
	}
};

function showShopGoods(goodsX,goodsY,goodsName) {
	
	var obj = document.getElementById("shop_goods") ;
	obj.setAttribute("class","shop_goods") ;
	obj.style.left = goodsX + "px";
	obj.style.top = goodsY + "px";
	
	var s1 = "<span class='goods_text'>" ;
	var s2 = "<samp class='samp_1'>◆</samp><samp class='samp_2'>◆</samp></span>" ;
	
	obj.innerHTML = s1 + goodsName + s2 ;
	
};

function hideShopGoods() {
	var obj = document.getElementById("shop_goods") ;
	obj.setAttribute("class","notDisplay") ;
};

function sendActivityUrl(url) {
    var sUrl = '#localcmd:fun=sendActivityUrl&url=' + url   + '&rnd=' + Math.round(Math.random() * 1800);
    document.location = sUrl;
};

/**显示导航路径***/
function shopNavi(positionName,areaX,areaY) {
	hideElementsOfClass("tip") ;
	var sUrl = '#localcmd:fun=shopNavi&positionName=' + positionName + '&areaX=' + areaX  + '&areaY=' + areaY  + '&rnd=' + Math.round(Math.random() * 1800);
    document.location = sUrl;
}

function increaseMaxZoomFactor(initScale) {

   var element = document.createElement('meta');
   element.name = "viewport";
   element.content = "initial-scale=" + initScale;
   var head = document.getElementsByTagName('head')[0];
   head.appendChild(element);
}

function getHeight() {
	var obj = document.getElementsByTagName("svg") ;
	if(obj.length > 0) {
		return obj[0].getAttribute("height") ;
	} else {
		return 0 ;
	}
}

function getWidth() {
	var obj = document.getElementsByTagName("svg") ;
	if(obj.length > 0) {
		return obj[0].getAttribute("width") ;
	} else {
		return 0 ;
	}
}

function showGoodsPosition(x,y) {
	if(typeof(x)=='string'){
		x = parseFloat(x);
	}
	if(typeof(y)=='string'){
		y = parseFloat(y);
	}
	x = x - 50 ;
	y = y + 50 ;
	var objectPerson = document.getElementById('goodsPosition');
	objectPerson.setAttribute('transform', 'matrix(0.5,0,0,-0.5,' + x + ',' + y + ')');
	objectPerson.style.display = "block" ;
};
</script>
<style>
*{padding:0;margin:0;font-size:12px;}
ul li{list-style-type:none;}
.big_div .tip{position:absolute;}
.tip{width:250px;background:#888;padding:15px 0 0 0;}
.tip img{display:inline-block;border:none 0;margin:10px;margin-top:0;}
.tip span{
    color: #FFFFFF;
    float: right;
    line-height: 14px;
    margin-top: 4px;
    padding-right: 30px;
    text-align: left;
    width: 137px;}
.tip .phone_num{clear:both;float:right;padding-right:15px;}
.tip p{line-height:22px;color:#fff;padding:10px;background:#333;clear:both;}
.tag_wifi{display:none}
.tag_lid{display:none}
.notDisplay{display:none}
.old_line_class{display:none}
.goods_text{   background: none repeat scroll 0 0 #FFFFFF;
    border: 2px solid #ccc;
    border-radius: 5px 5px 5px 5px;
    color: #888;
    font-family: microsoft yahei;
    font-size: 16px;
    font-weight: bold;
    padding: 5px;}
.activity_text{   background: none repeat scroll 0 0 green;
    border: 2px solid green;
    border-radius: 5px 5px 5px 5px;
    color: #fff;
    font-family: microsoft yahei;
    font-size: 16px;
    font-weight: bold;
    padding: 5px;}
.samp_1{position:absolute;color:#ccc;left:5px;bottom:-18px;font-size:16px;}
.samp_2{position:absolute;color:#fff;left:5px;font-size:16px;bottom:-15px;}
.samp_3{position:absolute;color:green;left:5px;bottom:-18px;font-size:16px;}
</style>
<body>
<br/>
<div id="id_svg">
${svg}
</div>
<div class="big_div">
${divContent }
</div>
<div style="display:'';font-size:14px;padding-left:30px;x:600px;y:600px">
<input type="button" onclick="recordPark()" value="标记停车位置"/>
<input type="button" onclick="parkOver()" value="完成标记"/><input type="button" value="显示停车位置" onclick="showPark(120,120)"/>
<input type="button" onclick="confirmRecord()" value="确认标记"/><input type="button" value="取消标记" onclick="concelRecord()"/>
<input type="button" value="显示人的位置" onclick="showPerson(395,138)"/><br/><br/>
<input type="button" onclick="showLid()" value="显示lid" />
<input type="button" value="影藏lid" onclick="hideLid()" /> 
<input type="button" value="显示wifi" onclick="showWifi()"/>
<input type="button" value="影藏wifi" onclick="hideWifi()"/><br/>
<input type="button" onclick="showLinesTest()" value="显示导航路径"/>
<input type="button" onclick="showShopArea('area_6',100,100)" value="显示商家提示层"/>
<input type="button" onclick="hideLines()" value="影藏线路"/>
<input type="button" onclick="showShopGoods(200,200,'我的商品33');" value="显示商品提示层"/>
<input type="button" value="显示商品位置" onclick="showGoodsPosition('200','200')"/>
<input type="button" onclick="hideShopGoods();" value="影藏商品提示层"/>
<input type="button" onclick="showActivity('s');" value="显示活动信息" />
<input type="button" onclick="hideActivity() ;" value="影藏活动信息"/>
<input type="button" onclick="testHeightWidth() ;" value="显示长宽"/>
</div>

<div id="activity_div"  style="position:absolute;left:-1000px;top:-1000px;">
</div>

<div id="activity_parent">
</div>

<div id="shop_goods" class="shop_goods" style="position:absolute;left:-1000px;top:-1000px;">
</div>
</body>
</html>