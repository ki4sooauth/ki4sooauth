<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
    request.setAttribute("topMenuCode", "16");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<title>${shopVo.wordNames['gmsf029']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/serveTool.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/serveToolPoup.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="${imgPath}/gms/common/css/markState.css" media="screen" />

<script type="text/javascript"
	src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
</head>

<script type="text/javascript">
/************************************************************************************************************
(C) www.dhtmlgoodies.com, January 2006

This is a script from www.dhtmlgoodies.com. You will find this and a lot of other scripts at our website.

Terms of use:
You are free to use this script as long as the copyright message is kept intact. However, you may not
redistribute, sell or repost it without our permission.

Thank you!

www.dhtmlgoodies.com
Alf Magne Kalleland

************************************************************************************************************/

var rectangleBorderWidth = 2;// Used to set correct size of the rectangle with red dashed border
var useRectangle = false;
var autoScrollSpeed = 4;// Autoscroll speed- Higher = faster

/* The saveData function creates a string containing the ids of your dragable elements. 

The format of this string is as follow

id of item 1;id of item 2;id of item 3

i.e. a semi colon separated list. The id is something you put in as "id" attribute of your dragable elements.

*/

function saveData()
{
var saveString = "";
for(var no=0;no<dragableObjectArray.length;no++){
if(saveString.length>0)saveString = saveString + ';';
ref = dragableObjectArray[no];
saveString = saveString + ref['obj'].id;
}

alert(saveString);// For demo only

/* Put this item into a hidden form field and then submit the form 

example:

document.forms[0].itemOrder.value = saveString;
document.forms[0].submit;

On the server explode the values by use of server side script. Then update your database with the new item order

*/
}

/* Don't change anything below here */


var dragableElementsParentBox;
var opera = navigator.appVersion.indexOf('Opera')>=0?true:false;

var rectangleDiv = false;
var insertionMarkerDiv = false;
var mouse_x;
var mouse_y;

var el_x;
var el_y;

var dragDropTimer = -1;// -1 = no drag, 0-9 = initialization in progress, 10 = dragging
var dragObject = false;
var dragObjectNextObj = false;
var dragableObjectArray = new Array();
var destinationObj = false;
var currentDest = false;
var allowRectangleMove = true;
var insertionMarkerLine;
var dragDropMoveLayer;
var autoScrollActive = false;
var documentHeight = false;
var documentScrollHeight = false;
var dragableAreaWidth = false;

function getTopPos(inputObj)
{
 var returnValue = inputObj.offsetTop;
 while((inputObj = inputObj.offsetParent) != null){
 if(inputObj.tagName!='HTML')returnValue += inputObj.offsetTop;
 }
 return returnValue;
}

function getLeftPos(inputObj)
{
 var returnValue = inputObj.offsetLeft;
 while((inputObj = inputObj.offsetParent) != null){
 if(inputObj.tagName!='HTML')returnValue += inputObj.offsetLeft;
 }
 return returnValue;
}

function cancelSelectionEvent()
{
if(dragDropTimer>=0)return false;
return true;
}

function getObjectFromPosition(x,y)
{
var height = dragObject.offsetHeight;
var width = dragObject.offsetWidth;
var indexCurrentDragObject=-5;
for(var no=0;no<dragableObjectArray.length;no++){
ref = dragableObjectArray[no];
if(ref['obj']==dragObject)indexCurrentDragObject=no;
if(no<dragableObjectArray.length-1 && dragableObjectArray[no+1]['obj']==dragObject)indexCurrentDragObject=no+1;
if(ref['obj']==dragObject && useRectangle)continue;
if(x > ref['left'] && y>ref['top'] && x<(ref['left'] + (ref['width']/2)) && y<(ref['top'] + ref['height'])){
if(!useRectangle && dragableObjectArray[no]['obj']==dragObject)return 'self';
if(indexCurrentDragObject==(no-1))return 'self';
return Array(dragableObjectArray[no],no);
}

if(x > (ref['left'] + (ref['width']/2)) && y>ref['top'] && x<(ref['left'] + ref['width']) && y<(ref['top'] + ref['height'])){
if(no<dragableObjectArray.length-1){
if(no==indexCurrentDragObject || (no==indexCurrentDragObject-1)){
return 'self';
}
if(dragableObjectArray[no]['obj']!=dragObject){
return Array(dragableObjectArray[no+1],no+1);
}else{
if(!useRectangle)return 'self';
if(no<dragableObjectArray.length-2)return Array(dragableObjectArray[no+2],no+2);
}
}else{
if(dragableObjectArray[dragableObjectArray.length-1]['obj']!=dragObject)return 'append';

}
}
if(no<dragableObjectArray.length-1){
if(x > (ref['left'] + ref['width']) && y>ref['top'] && y<(ref['top'] + ref['height']) && y<dragableObjectArray[no+1]['top']){
return Array(dragableObjectArray[no+1],no+1);
}
}
}
if(x>ref['left'] && y>(ref['top'] + ref['height']))return 'append';
return false;
}

function initDrag(e)
{
if(document.all)e = event;
mouse_x = e.clientX;
mouse_y = e.clientY;
if(!documentScrollHeight)documentScrollHeight = document.documentElement.scrollHeight + 100;
el_x = getLeftPos(this)/1;
el_y = getTopPos(this)/1;
dragObject = this;
if(useRectangle){
rectangleDiv.style.width = this.clientWidth - (rectangleBorderWidth*2) +'px';
rectangleDiv.style.height = this.clientHeight - (rectangleBorderWidth*2) +'px';
rectangleDiv.className = this.className;
}else{
insertionMarkerLine.style.width = '6px';
}
dragDropTimer = 0;
dragObjectNextObj = false;
if(this.nextSibling){
dragObjectNextObj = this.nextSibling;
if(!dragObjectNextObj.tagName)dragObjectNextObj = dragObjectNextObj.nextSibling;
}
initDragTimer();
return false;
}

function initDragTimer()
{
if(dragDropTimer>=0 && dragDropTimer<10){
dragDropTimer++;
setTimeout('initDragTimer()',5);
return;
}
if(dragDropTimer==10){

if(useRectangle){
dragObject.style.opacity = 0.5;
dragObject.style.filter = 'alpha(opacity=50)';
dragObject.style.cursor = 'default';
}else{
var newObject = dragObject.cloneNode(true);
dragDropMoveLayer.appendChild(newObject);
}
}
}


function autoScroll(direction,yPos)
{
if(document.documentElement.scrollHeight>documentScrollHeight && direction>0)return;

window.scrollBy(0,direction);

if(direction<0){
if(document.documentElement.scrollTop>0){
mouse_y = mouse_y - direction;
if(useRectangle){
dragObject.style.top = (el_y - mouse_y + yPos) + 'px';
}else{
dragDropMoveLayer.style.top = (el_y - mouse_y + yPos) + 'px';
}
}else{
autoScrollActive = false;
}
}else{
if(yPos>(documentHeight-50)){
mouse_y = mouse_y - direction;
if(useRectangle){
dragObject.style.top = (el_y - mouse_y + yPos) + 'px';
}else{
dragDropMoveLayer.style.top = (el_y - mouse_y + yPos) + 'px';
}
}else{
autoScrollActive = false;
}
}
if(autoScrollActive)setTimeout('autoScroll('+direction+',' + yPos + ')',5);
}

function moveDragableElement(e)
{
if(document.all)e = event;
if(dragDropTimer<10)return;
if(!allowRectangleMove)return false;


if(e.clientY<50 || e.clientY>(documentHeight-50)){
if(e.clientY<50 && !autoScrollActive){
autoScrollActive = true;
autoScroll((autoScrollSpeed*-1),e.clientY);
}

if(e.clientY>(documentHeight-50) && document.documentElement.scrollHeight<=documentScrollHeight && !autoScrollActive){
autoScrollActive = true;
autoScroll(autoScrollSpeed,e.clientY);
}
}else{
autoScrollActive = false;
}
if(useRectangle){
if(dragObject.style.position!='absolute'){
dragObject.style.position = 'absolute';
setTimeout('repositionDragObjectArray()',50);
}
}

if(useRectangle){
rectangleDiv.style.display='block';
}else{
insertionMarkerDiv.style.display='block';
dragDropMoveLayer.style.display='block';
}

if(useRectangle){
dragObject.style.left = (el_x - mouse_x + e.clientX + Math.max(document.body.scrollLeft,document.documentElement.scrollLeft)) + 'px';
dragObject.style.top = (el_y - mouse_y + e.clientY) + 'px';
}else{
dragDropMoveLayer.style.left = (el_x - mouse_x + e.clientX + Math.max(document.body.scrollLeft,document.documentElement.scrollLeft)) + 'px';
dragDropMoveLayer.style.top = (el_y - mouse_y + e.clientY) + 'px';
}
dest = getObjectFromPosition(e.clientX+Math.max(document.body.scrollLeft,document.documentElement.scrollLeft),e.clientY+Math.max(document.body.scrollTop,document.documentElement.scrollTop));

if(dest!==false && dest!='append' && dest!='self'){
destinationObj = dest[0]; 

if(currentDest!==destinationObj){
currentDest = destinationObj;
if(useRectangle){
destinationObj['obj'].parentNode.insertBefore(rectangleDiv,destinationObj['obj']);
repositionDragObjectArray();
}else{
if(dest[1]>0 && (dragableObjectArray[dest[1]-1]['obj'].offsetLeft + dragableObjectArray[dest[1]-1]['width'] + dragObject.offsetWidth) < dragableAreaWidth){
insertionMarkerDiv.style.left = (getLeftPos(dragableObjectArray[dest[1]-1]['obj']) + dragableObjectArray[dest[1]-1]['width'] + 2) + 'px';
insertionMarkerDiv.style.top = (getTopPos(dragableObjectArray[dest[1]-1]['obj']) - 2) + 'px';
insertionMarkerLine.style.height = dragableObjectArray[dest[1]-1]['height'] + 'px';
}else{
insertionMarkerDiv.style.left = (getLeftPos(destinationObj['obj']) - 8) + 'px';
insertionMarkerDiv.style.top = (getTopPos(destinationObj['obj']) - 2) + 'px';
insertionMarkerLine.style.height = destinationObj['height'] + 'px';
}


}
}
}

if(dest=='self' || !dest){
insertionMarkerDiv.style.display='none';
destinationObj = dest;
}

if(dest=='append'){
if(useRectangle){
dragableElementsParentBox.appendChild(rectangleDiv);
dragableElementsParentBox.appendChild(document.getElementById('clear'));
}else{
var tmpRef = dragableObjectArray[dragableObjectArray.length-1];
insertionMarkerDiv.style.left = (getLeftPos(tmpRef['obj']) + 2) + tmpRef['width'] + 'px';
insertionMarkerDiv.style.top = (getTopPos(tmpRef['obj']) - 2) + 'px';
insertionMarkerLine.style.height = tmpRef['height'] + 'px';
}
destinationObj = dest;
repositionDragObjectArray();
}

if(useRectangle && !dest){
destinationObj = currentDest;
}

allowRectangleMove = false;
setTimeout('allowRectangleMove=true',50);
}

function stop_dragDropElement()
{
dragDropTimer = -1;

if(destinationObj && destinationObj!='append' && destinationObj!='self'){
destinationObj['obj'].parentNode.insertBefore(dragObject,destinationObj['obj']);
}
if(destinationObj=='append'){
dragableElementsParentBox.appendChild(dragObject);
dragableElementsParentBox.appendChild(document.getElementById('clear'));
}

if(dragObject && useRectangle){
dragObject.style.opacity = 1;
dragObject.style.filter = 'alpha(opacity=100)';
dragObject.style.cursor = 'move';
dragObject.style.position='static';
}
rectangleDiv.style.display='none';
insertionMarkerDiv.style.display='none';
dragObject = false;
currentDest = false;
resetObjectArray();
destinationObj = false;
if(dragDropMoveLayer){
dragDropMoveLayer.style.display='none';
dragDropMoveLayer.innerHTML='';
}
autoScrollActive = false;
documentScrollHeight = document.documentElement.scrollHeight + 100;
}

function cancelEvent()
{
return false;
}

function repositionDragObjectArray()
{
for(var no=0;no<dragableObjectArray.length;no++){
ref = dragableObjectArray[no];
ref['left'] = getLeftPos(ref['obj']);
ref['top'] = getTopPos(ref['obj']);
}
documentScrollHeight = document.documentElement.scrollHeight + 100;
documentHeight = document.documentElement.clientHeight;
}

function resetObjectArray()
{
dragableObjectArray.length=0;
var subDivs = dragableElementsParentBox.getElementsByTagName('*');
var countEl = 0;
for(var no=0;no<subDivs.length;no++){
var attr = subDivs[no].getAttribute('dragableBox');
if(opera)attr = subDivs[no].dragableBox;
if(attr=='true'){
var index = dragableObjectArray.length;
dragableObjectArray[index] = new Array();
ref = dragableObjectArray[index];
ref['obj'] = subDivs[no];
ref['width'] = subDivs[no].offsetWidth;
ref['height'] = subDivs[no].offsetHeight;
ref['left'] = getLeftPos(subDivs[no]);
ref['top'] = getTopPos(subDivs[no]);
ref['index'] = countEl;
countEl++;
}
}
}


function initdragableElements()
{
dragableElementsParentBox = document.getElementById('dragableElementsParentBox');
insertionMarkerDiv = document.getElementById('insertionMarker');
insertionMarkerLine = document.getElementById('insertionMarkerLine');
dragableAreaWidth = dragableElementsParentBox.offsetWidth;

if(!useRectangle){
dragDropMoveLayer = document.createElement('li');
dragDropMoveLayer.id = 'dragDropMoveLayer';
document.body.appendChild(dragDropMoveLayer);
}

var subDivs = dragableElementsParentBox.getElementsByTagName('*');
var countEl = 0;
for(var no=0;no<subDivs.length;no++){
var attr = subDivs[no].getAttribute('dragableBox');
if(opera)attr = subDivs[no].dragableBox;
if(attr=='true'){
subDivs[no].style.cursor='move';
subDivs[no].onmousedown = initDrag;

var index = dragableObjectArray.length;
dragableObjectArray[index] = new Array();
ref = dragableObjectArray[index];
ref['obj'] = subDivs[no];
ref['width'] = subDivs[no].offsetWidth;
ref['height'] = subDivs[no].offsetHeight;
ref['left'] = getLeftPos(subDivs[no]);
ref['top'] = getTopPos(subDivs[no]);
ref['index'] = countEl;
countEl++;
}
}

/* Creating rectangel indicating where item will be dropped */
rectangleDiv = document.createElement('li');
rectangleDiv.id='rectangle';
rectangleDiv.style.display='none';
dragableElementsParentBox.appendChild(rectangleDiv);


document.body.onmousemove = moveDragableElement;
document.body.onmouseup = stop_dragDropElement;
document.body.onselectstart = cancelSelectionEvent;
document.body.ondragstart = cancelEvent;
window.onresize = repositionDragObjectArray; 

documentHeight = document.documentElement.clientHeight;
}

window.onload = initdragableElements;

</script>

<script>
$(function(){
	$.ajax({
		async:false ,
		url:basePath + '/tools.do?method=getToolSortContent',
		type:'post',
		dataType:  'json',
		success: function(data) {
			var showToolList = $("#showToolList").val() ;
			var addShopTool = $("#addShopTool").val() ;
			var delShopTool = $("#delShopTool").val() ;
			
			if(isEmpty(showToolList)) 
				return ;
			
			// added 已经发布的服务工具和CMS子栏目
			var added = "" ;
			if(!isEmpty(data.added)){	
			for(var i=0;i<data.added.length;i++) {
				var obj = data.added[i] ;
				added += "<li dragableBox='true' onMouseOver=min('" + obj.toolid ;
				added += "') onMouseOut=mout('" + obj.toolid + "')>"
				if(!isEmpty(delShopTool))
// 					added += "<a href=''><b class='cut' onclick=delToolInfo('" + obj.shopToolId + "')></b></a>" ;
// 				added += "<span class='gray'>" + obj.status + "</span>" ;
				added += "<table class='logo' border='0' cellspacing='0' cellpadding='0'>" ;
				added += "<tr valign='middle'>" ;
				added += "<td valign='middle' height='54'><img id='" + obj.toolid + "unfocus' src='" + obj.toolicounfocus + "'  width='140px' height='140px'/> " ;
				added += "<img id='" + obj.toolid + "focus' src='" + obj.toolicofocus + "' style='display: none;' width='140px' height='140px' /></td>" ;
				added += "</tr> </table> <span class='Name'>" + obj.toolname + "</span> " ;
				added += "<input class='shopToolId_class' type='hidden' value='" + obj.toolid + "' /> " ;
				added += "<input class='shopToolType_class' type='hidden' value='" + obj.tooltype + "' /> </li>" ;
			}
			added += "<li class='clear' id='clear'></li>" ;
			$("#dragableElementsParentBox").html(added) ;
			}
        }
	}) ;
	judge();
});

//判断保存顺序列表按钮是否显示
function judge(){ 	
	var shopToolIdClass = $(".shopToolId_class");
	if(shopToolIdClass.size()>0){
		$("#saveBtn").show();
		
	}else{
		$("#btn").html("<div style=\"font-size: 100\"><center><strong>暂无工具信息</strong></center></div>") ;
	
	}
}

//保存顺序列表
function affirm() {
	var shopToolIdClass = $(".shopToolId_class");
	var shopToolType_class= $(".shopToolType_class");
	if(shopToolIdClass.size()>0){
		var str = "" ;
		var types="";
		for(var i=0;i<shopToolIdClass.size();i++) {
			str += shopToolIdClass.get(i).value ;
			types += shopToolType_class.get(i).value ;
			if(i != shopToolIdClass.size() - 1)
				str += "," ;
			    types += "," ;
		}
		var data = "&toolIds=" + str+"&toolTypes="+types ;
		$.ajax({
			async:false ,
			url:basePath + '/tools.do?method=updateShopToolSort',
			type:'post',
			dataType:  'json',
			data:data,
			success: function(data) {
			     if(data.success) {
			    	alert(data.message);
			     } else {
			    	 alert(data.message);
			     }
	        }
		});
	}
}
// 移入
function min(id) {
	$("#" + id + "focus").show();
	$("#" + id + "unfocus").hide();
}
// 移出
function mout(id) {
	$("#" + id + "focus").hide();
	$("#" + id + "unfocus").show();
}

// 服务工具点击方法
function menuClick(num) {
	window.location.href = "${basePath}/tools.do?method=index&num=" + num ;
}

function moveIn(obj) {
	$(obj).css("background-color","#0471C0") ;
}

function moveOut(obj) {
	$(obj).css("background-color","") ;
}

</script>
<style>
.inputA {
	width: 14px;
	height: 14px;
	margin: 0 5px 0 20px;
	vertical-align: middle;
}
</style>
<body>
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<div class="aside">
				<div class="serve_menu">
					<check:hasAuthority authorityID="1601">
						<a href="${basePath }/tools.do?method=addTools"><samp
								class="s1"></samp><span  style="background-color:#0471C0;" > ${shopVo.wordNames['gmsf001']}</span></a>
					</check:hasAuthority>
					</br>
					<a href="${basePath }/tools.do?method=getToolSortData">
					<samp class="s2"></samp><span  onMouseOver="moveIn(this)" onMouseOut="moveOut(this)">工具排序</span></a>
				</div>
				<ul class="left_menu left_menu_tip">
					<check:hasAuthority authorityID="1603">
						<c:forEach var="tool" items="${toolList }" varStatus="s">
							<li><a href="javascript:void(0)"
								onclick="menuClick('${s.index}');">${tool.toolName}</a><b>${tool.status}</b></li>
						</c:forEach>
					</check:hasAuthority>
				</ul>
			</div>

			<div  class="section">
				<div class="serveToolPoup">
					<div class="rightTitle_add">
						<span>工具排序</span>
					</div>
					
					<check:hasAuthority authorityID="160103">
						<input type="hidden" id="showToolList" value="true"/>
					</check:hasAuthority>
					<check:hasAuthority authorityID="160101">
						<input type="hidden" id="addShopTool" value="true"/>
					</check:hasAuthority>
					<check:hasAuthority authorityID="160102">
						<input type="hidden" id="delShopTool" value="true" />
					</check:hasAuthority>

					
					<div class="title">工具列表</div>
					<ul id="dragableElementsParentBox">
					</ul>
				
				<div class="serveToolPoupBtn" id="btn">
					<input type="submit" id="saveBtn" class="serveToolPoupCommit blueBtn"
						onclick="affirm() ;" value="保存顺序列表" />
<%-- 						${ shopVo.wordNames['gmsf011']} --%>
				</div>

				<div id="insertionMarker">
					<span id="insertionMarkerLine"></span>
				</div>

			</div>
		</div>
	</div>
	</div>
</body>
</html>
