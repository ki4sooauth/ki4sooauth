<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/tableInfo.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
 $(document).ready(function(){
	 initValidate();
		initFancyBox("fancybox_relate",535,600,true);
 })
 function relateOne(){
	var shopEntiryId='${gmsLoginInfo.shopEntityId}';
	var entityId=$("#shopEntityId").val();
	if(entityId==""&&shopEntiryId==""){
		alert("请选择实体店");
		return false;
	}
	if(entityId==""||entityId==undefined){
		alert(entityId);
		entityId="";
	}
	var dataType = $("#dataType").val();
	var url = "${basePath }/relation.do?method=listRelation&relateType=L&dataType="+dataType+"&entityId="+entityId;
	$("#relateFancybox").attr("href",url).click();
}
	function dealRelations(relations){
	 	$("#transpcId").val(relations[0][1]);
	 	$("#mac").val(relations[0][2]);
	 	$.fancybox.close();
	}
</script>
<style type="text/css">
.title_d{margin: 6px}
</style>
</head>
<body>
 <form name="tableName" id="tableForm">
           	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg314']}${tableInfo.id==null?shopVo.wordNames['gmsg315']:shopVo.wordNames['gmsg316']}</span>
          </div>
</div>
  <input type="hidden" name="id" value="${tableInfo.id}"/>
  <ul class="desk-num-poup">
    <li><span>${shopVo.wordNames['gmsg317']}</span><input class="borderStyle text" type="text" name="tableName" id="tableName" maxlength="20" value="${tableInfo.tableNo}"/></li>
    <li><span>${shopVo.wordNames['gmsg318']}</span><input class="borderStyle text" type="text" name="roomName" id="roomName" maxlength="100" value="${tableInfo.roomName}"/></li>
    <li ${not empty gmsLoginInfo.shopEntityId?"style='display:none;'":""}><span>${shopVo.wordNames['gmsg322']}</span><select class="borderStyle select"  name="shopEntityId" id="shopEntityId">
           <option value="">${shopVo.wordNames['gmsg134']}</option>
			   <c:forEach items="${entityList}" var="entity">
			   <option ${(tableInfo.shopEntityId eq entity.shopEntityId) or (entity.shopEntityId eq gmsLoginInfo.shopEntityId)?"selected='selected'":""}  value="${entity.shopEntityId}">${entity.shopEntityName}</option>
		 </c:forEach>
    </select></li>
    <li><span>服务转发器</span>
    <input class="borderStyle text"  id="transpcId" type="hidden" />
    <input class="borderStyle text"  id="mac" name="mac" type="text" value="${tableInfo.mac}"  onclick="relateOne();"/>
    </li>
     <li><span>餐桌类型</span><select class="borderStyle select"  name="tableTypeCode">
           <option value="">${shopVo.wordNames['gmsg134']}</option>
			   <c:forEach items="${tableType1}" var="t">
			   <option ${tableInfo.tableType eq t.id?"selected='selected'":""}value="${t.id}">${t.name}</option>
		 </c:forEach>
    </select></li>
    <li><span>${shopVo.wordNames['gmsg321']}</span><input class="borderStyle text" name="remark" type="text" value="${tableInfo.remark}"/></li>
    <li class="commitBtn"><input type="submit"  class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg323']}"></li>
  </ul>
    <div style="display:none;">
	<a href="#" id="relateFancybox" class="fancybox_relate"></a>
</div>
   </form>
</body>
</html>
