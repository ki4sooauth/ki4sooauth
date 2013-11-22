<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<title>编辑网格</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/gmap/js/ztree_shopEntity.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/relate.js"></script>
</head>
<script>
$(function(){
	initFancyBox("fancybox_rela",240,450,true);//初始化关联信息树型弹出层
});
function relateFancybox(){
	$("#relaFancybox").click();
}
function dealRelations(relations){
	for(var i=0;i<relations.length;i++){
		$("input[name='positionId']").val(relations[i][1]);
		$("input[name='positionName']").val(relations[i][2]);
	}
	$.fancybox.close();
}
function doSubmit(){
	var positionId = $("#positionId").val();
	var gridProperty = $("select[name='gridProperty']").val();
	var positionName = $("#positionName").val();
	if(isEmpty(positionId)) {
		alert("请选择所属区域");
		return false;
	}
	if(isEmpty(gridProperty)) {
		alert("请选择所属区域属性");
		return false;
	}
	var gridPropertyName = $("select[name='gridProperty'] option[value="+gridProperty+"]").html();
	(document.parentWindow || document.defaultView).parent.freshGridProperty(positionId,gridProperty,positionName,gridPropertyName);
}
</script>
<body>
<div style="display:none;"><!-- 弹出层 -->
	<a href="${basePath}relation.do?method=treeRelation&selectType=S&relateType=I&shopEntityId=${shopEntityId}&rootId=${positionId}" id="relaFancybox" class="fancybox_rela"></a>
</div>
<div class="productBuild marketingMsg">
<div class="rightTitle_add">
	<span>编辑网格信息</span>
</div>
<ul style="margin:50px 0;">
	<li>
		<span>所属区域</span>
		<input type="text" class="borderStyle text" id="positionName" name="positionName" value="" onclick="relateFancybox();" readonly="readonly"/>
		<input type="hidden" id="positionId" name="positionId" value=""/>
	</li>
    <li>
   	 	<span>所属区域属性</span>
   	 	<select class="borderStyle text" name="gridProperty">
   	 		<option value="1">室内</option>
   	 		<option value="0">室外</option>
   	 	</select>
   	 </li>
</ul>
<a id="submitBtn1" style="display:block;"  href="javascript:void(0)" onclick="doSubmit();" class="savebtnS blueBtn">${ shopVo.wordNames['gmsi020']}</a>
</div>
</body>
</html>