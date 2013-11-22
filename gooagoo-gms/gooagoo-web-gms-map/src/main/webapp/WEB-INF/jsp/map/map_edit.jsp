<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "13");
	request.setAttribute("leftMenuCode", "1304");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${shopVo.wordNames['gmsi023']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/gmap/js/ztree_shopEntity.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/relate.js"></script>
<script>
	var imgPath="${imgPath}";
	var basePath = "${basePath}";
	var flag = false;
	var entityId;
	var mapId;
	$(function() {
		initFancyBox("fancybox_rela",240,450,true);//初始化关联信息树型弹出层
		disableBtn(false);
	})
	function disableBtn(flag){
		if(flag){
			$("#submitBtn1").css("display","none");
			$("#submitBtn2").css("display","block");
		}else{
			$("#submitBtn1").css("display","block");
			$("#submitBtn2").css("display","none");
		}
	}
// 	function saveMapInfo() {
// 		if(flag) {
// 			alert("地图数据已经保存，请创建svg文件。");
// 			return false;
// 		}
// 		var mapname = $("input[name='mapname']").val();
// 		if(mapname.length == 0) {
// 			alert("请输入地图名称");
// 			return false;
// 		}
// 		var ispark = $("select[name='ispark']").val();
// 		var shopEntityId = $("#shopEntityId").val();
// 		if(shopEntityId.length == 0) {
// 			alert("请选择实体店");
// 			return false;
// 		}
// 		var ratio = $("input[name='ratio']").val();
// 		if(isNaN(ratio)){
// 			alert("图与现实:比例系数需要输入数字");
// 			return false;
// 		}
// 		var offsetX = $("input[name='offsetX']").val();
// 		if(isNaN(offsetX)){
// 			alert("图与现实:x偏移量需要输入数字");
// 			return false;
// 		}
// 		var offsetY = $("input[name='offsetY']").val();
// 		if(isNaN(offsetY)) {
// 			alert("图与现实:y偏移量需要输入数字");
// 			return false;
// 		}
// 		var ratio2 = $("input[name='ratio2']").val();
// 		if(isNaN(ratio2)){
// 			alert("图与定位:比例系数需要输入数字");
// 			return false;
// 		}
// 		var offsetX2 = $("input[name='offsetX2']").val();
// 		if(isNaN(offsetX2)){
// 			alert("图与定位:x偏移量需要输入数字");
// 			return false;
// 		}
// 		var offsetY2 = $("input[name='offsetY2']").val();
// 		if(isNaN(offsetY2)) {
// 			alert("图与定位:y偏移量需要输入数字");
// 			return false;
// 		}
// 		var data = "&mapName=" + mapname + "&isPark=" + ispark 
// 				  + "&shopEntityId=" + shopEntityId
// 				  + "&ratio=" + ratio
// 				  + "&offsetX=" + offsetX
// 				  + "&offsetY=" + offsetY 
// 				  + "&ratio2=" + ratio2
// 				  + "&offsetX2=" + offsetX2
// 				  + "&offsetY2=" + offsetY2;
// 		$.ajax({
// 			async:false,
// 			type:"POST",
// 			url:basePath + "/map.do?method=addMapDo",
// 			data:data ,
// 			dataType:"json",
// 			success: function(data) {
// 				if(data.success) {
// 					alert("添加成功")
// 					flag = true;
// 					entityId = $("#shopEntityId").val();
// 					mapId = data.extend;
// 					location.href = basePath + "/svg.do?method=addSvg&shopEntityId=" + entityId + "&mapId=" + mapId;
// 				} else {
// 					alert("添加失败");
// 				}
// 			}
// 		});
// 	}
	//提交
	function doSubmit(){
		disableBtn(true);
		var mapId = $("input[name='mapId']").val();
		if(isEmpty(mapId)){
			var url = basePath + "map.do?method=add";
		}else{
			var url = basePath + "map.do?method=update";
		}
		if(checkHasValue()){
			$("#paraform").ajaxSubmit({
				type : "post",
				url : url,
	 			dataType: "json",
				success : function(msg) {
					alert(msg.message);
					if (msg.success) {
						window.location.href = basePath + "map.do?method=index";
					}
					disableBtn(false);
				}
			});
		}else{
			disableBtn(false);
		}
	}
	//校验
	function checkHasValue(){
		var mapId = $("#mapId");
		var shopEntityId = $("#shopEntityId");
		var mapName = $("input[name='mapName']");
		var mapRealHeight = $("input[name='mapRealHeight']");
		var mapRealWidth = $("input[name='mapRealWidth']");
		var ratioLocation = $("input[name='ratioLocation']");
		var ratioGrid = $("input[name='ratioGrid']");
		var isPark = $("select[name='isPark']");
// 		if(!isEmpty(mapId)){
			//判断svg图是否存在
// 		}
		if(isEmpty(shopEntityId.val())) {
			alert("请选择实体店");
			return false;
		}
		if(isEmpty(mapName.val())) {
			alert("请输入地图名称");
			mapName.focus();
			return false;
		}
		if(isEmpty(mapRealHeight.val())) {
			alert("请输入真实地图高度");
			mapRealHeight.focus();
			return false;
		}
		if(isEmpty(mapRealWidth.val())) {
			alert("请输入真实地图宽度");
			mapRealWidth.focus();
			return false;
		}
		if(isEmpty(ratioLocation.val())) {
			alert("请输入定位坐标系比例");
			ratioLocation.focus();
			return false;
		}else if(!isNaN(ratioLocation)){
			alert("定位坐标系比例需要输入数字");
			ratioLocation.focus();
			return false;
		}
		if(isEmpty(ratioGrid.val())) {
			alert("请输入网格坐标系比例");
			ratioGrid.focus();
			return false;
		}else if(!isNaN(ratioGrid)){
			alert("网格坐标系比例需要输入数字");
			ratioGrid.focus();
			return false;
		}
		return true;
	}
	function relateFancybox(){
		var shopEntityId = $("#shopEntityId").val();
		if(isEmpty(shopEntityId)){
			alert("请先选择实体店");
			return ;
		}
		var url = basePath+"relation.do?method=treeRelation";
		var data = "&selectType=S&relateType=I&shopEntityId="+shopEntityId;
 		$("#relaFancybox").attr("href",url+data).click();
	}
	function dealRelations(relations){
		for(var i=0;i<relations.length;i++){
			$("input[name='positionId']").val(relations[i][1]);
			$("input[name='positionName']").val(relations[i][2]);
		}
		$.fancybox.close();
	}
</script>
</head>
<body>
	<div style="display:none;"><!-- 弹出层 -->
		<a href="#" id="relaFancybox" class="fancybox_rela"></a>
	</div>
    <!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
	  	<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle_add">
					<span>${shopVo.wordNames['gmsi009']}</span>
				</div>
	            <div class="productBuild marketingMsg">
	            	<form id="paraform" action="" method="POST" enctype="multipart/form-data" target="myframe">
		            	<ul>
		                	<li>
		                		<span>${shopVo.wordNames['gmsi011']}</span>
		                		<input type="text" class="borderStyle text" id="shop_entity" value="${areaMapInfo.shopEntityName}" onclick="showEntityMenu('shop_entity','${shopId}')" readonly="readonly"/>
		                		<input type="hidden" id="shopEntityId" name="shopEntityId" value="${areaMapInfo.shopEntityId}"/>
		                		<input type="hidden" id="mapId" name="mapId" value="${areaMapInfo.mapId }"/>
		                	</li>
		                	<li>
		                		<span>区域</span>
		                		<input type="text" class="borderStyle text" id="positionName" name="positionName" value="${areaMapInfo.positionName}" onclick="relateFancybox();" readonly="readonly"/>
		                		<input type="hidden" id="positionId" name="positionId" value="${areaMapInfo.positionId }"/>
		                	</li>
		                    <li>
		                    	<span>${ shopVo.wordNames['gmsi012']}</span>
		                    	<input type="text" class="borderStyle text" name="mapName" value="${areaMapInfo.mapName}"/>
		                    </li>
		                    <li>
			                    <span>地图真实高度</span>
			                    <input type="text" class="borderStyle text" name="mapRealHeight" value="${areaMapInfo.mapRealHeight}"/>
		                    </li>
		                    <li>
			                    <span>地图真实宽度</span>
			                    <input type="text" class="borderStyle text" name="mapRealWidth" value="${areaMapInfo.mapRealWidth}"/>
		                    </li>
		                    <li>
			                    <span>定位坐标系比例</span>
			                    <input type="text" class="borderStyle text" name="ratioLocation" value="${areaMapInfo.ratioLocation}"/>
		                    </li>
		                    <li>
			                    <span>网格坐标系比例</span>
			                    <input type="text" class="borderStyle text" name="ratioGrid" value="${areaMapInfo.ratioGrid}"/>
		                    </li>
		                    <li>
		                   	 	<span>是否可停车</span>
		                   	 	<select class="borderStyle text" name="isPark">
		                   	 		<option value="Y">可停车</option>
		                   	 		<option value="N">不能停车</option>
		                   	 	</select>
		                   	 </li>
		                </ul>
		            	<ul>
		                	<li>
		                		<span>svg文件</span>
		                		<input type="file" name="svgFile" value="">
		                		<input type="hidden" name="urlSvg_page" value="${areaMapInfo.urlSvg}">
		                	</li>
		                </ul>
		                <a id="submitBtn1" style="display:block;"  href="javascript:void(0)" onclick="doSubmit();" class="savebtnS blueBtn">${ shopVo.wordNames['gmsi020']}</a>
		                <a id="submitBtn2" style="display:none;cursor: default" href="javascript:void(0)" class="savebtnS blueBtn">${ shopVo.wordNames['gmsi020']}</a>
           			</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 实体店 --> 
	<div id="shop_entity_Content" class="menuContent" style="display:none; position: absolute;">
		<ul id="shop_entity_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
	</div>
</body>
</html>