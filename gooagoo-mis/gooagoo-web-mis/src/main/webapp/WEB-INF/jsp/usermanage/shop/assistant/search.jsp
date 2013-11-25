<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>商家Assistant列表</title>
<script type="text/javascript">
/* var varPageIndex = 1;
 //分页查询
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	varPageIndex = index;
	var data = $("#searchForm").serialize() + "&pageIndex="+index;
	ajaxToPageByData("${basePath }/shopAssistant.do?method=searchAssistantList","resultlist",data);
}
//查询
function searchAssistantList(){
	page(varPageIndex);
} */
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	var data = "&pageIndex="+index+"&shopEntityId="+$("#sel").val()+"&shopId="+$("#shopId").val()+"&isDel="+$("#isDel").val();
	ajaxToPageByData("shopAssistant.do?method=searchAssistantList","resultlist",data);
}

//查询
function searchAssistantList(){
	if("" == $("#sel").val() && $("#sel").val() == null && undefined == $("#sel").val()){
		alert("请选择实体店!");
		$("#sel").focus();
	}else{
		page(1);
	}
}
</script>
</head>

<body>
<div class="div_but" >
	<h2 style = "margin: 0;padding: 10;text-align:center;">店员助手查询</h2>
	<form action=""  id="searchForm" name="searchForm" method="post">
	<div style="display:none;">
		<input id="shopId" type="hidden" value="${shopId }" />
	</div>
	<ul style = "margin: 0;padding: 5;text-align:center;">
		<li>
			请选择实体店：
			<select id="sel" onClick="">
		       <c:forEach var="item" items="${mShopEntityInfoList }" varStatus="im" >
					<option value="${ item.shopEntityId}">${item.shopEntityName }</option>
		       </c:forEach>
			</select>
			&nbsp;&nbsp;是否删除
			<select id="isDel" name="isDel">
				<option value="">--请选择--</option>
				<option selected="selected" value="N">否</option>
				<option value="Y">是</option>
			</select> 
			<input type="button" value="查询" onclick="searchAssistantList();" /> 
		</li>
	</ul>
	</form>
</div>
<div class="big_box" id="resultlist">
</div>
</body>
</html>