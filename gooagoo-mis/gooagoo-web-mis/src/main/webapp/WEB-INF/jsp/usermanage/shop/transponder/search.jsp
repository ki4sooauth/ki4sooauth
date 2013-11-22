<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>商家Transpc列表</title>
<script type="text/javascript">
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	var data = "&pageIndex="+index+"&shopEntityId="+$("#sel").val()+"&isDel="+$("#isDel").val();
	ajaxToPageByData("shopTranspc.do?method=queryTranspcList","resultlist",data);
}

//查询
function queryTranspcList(){
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
<div style="display:none;">
	<input id="shopId" type="hidden" value="${shopId }" />
</div>
<div class="div_but" >
	<h2 style = "margin: 0;padding: 10;text-align:center;">商家转发器查询</h2>
	<ul style = "margin: 0;padding: 5;text-align:center;">
		<li>&nbsp;&nbsp;&nbsp;请选择实体店：
		    <select id="sel" onClick="">
			    <c:forEach var="item" items="${mShopEntityInfoList }" varStatus="im" >
					<option value="${ item.shopEntityId}">${item.shopEntityName }</option>
			    </c:forEach>
		    </select>
		    <span>是否删除：</span>
			<select id="isDel" name="isDel">
				<option value="">--请选择--</option>
				<option value="N" selected="selected">否</option>
				<option value="Y">是</option>
			</select>  
		    <input type="button" value="查询" onclick="queryTranspcList();" /> 
	    </li>
	</ul>
  
</div>
<div class="big_box" id="resultlist">
</div>
</body>
</html>