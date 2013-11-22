<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>实体店LID分配页面</title>
</head>

<body>
<div class="popMsg">
	<h2>商家LID分配</h2>
	<div>
		<br/>
		<ul>
			<li style = "text-align:center;">请选择实体店：
			<select id="sel" onClick="">
				<c:forEach var="item" items="${mShopEntityInfoList }" varStatus="im" >
					<option value="${ item.shopEntityId}">${item.shopEntityName }</option>
				</c:forEach>
		    </select>  
			</li>
		</ul>
		<br/>
		<ul>
			<li style = "text-align:center;">请输入LID：<input type="text" value=""  id ="inLid" name="inLid" maxlength="6"/></li>
		</ul>
	</div>
	<div class="popBtn">
		<input type ="button" class="perMsg_btn" value="确定" class="left" onclick="javascript:save();"/>
		<input type ="button" class="perMsg_btn" value="取消" onclick="javascript:closefbox();"/>
	</div>
</div>
<script type="text/javascript">

//保存lid信息
function save(){
	var lid = $(inLid).val();
	if("" == lid || null == lid || undefined == lid){
		alert("请填写lid信息。");
	}else{
		var p = /^[0-9a-fA-F]{6,6}$/;
		if(p.exec(lid)){
			var shopEntityId = $("#sel").val();	
			var shopId = "${shopId}";
			var url = "shopLid.do?method=saveLid";
			var data = "&lid=" + lid + "&shopEntityId=" + shopEntityId + "&shopId=" + shopId;
			var result = ajaxJsonVoByData(url,data);
			alert(result);
			if(!"Lid值不允许重复分配" == result){
				closefbox();
			}
		}else{
			alert("请输入6位十六进制的lid码值");
		}
	}
}

//关闭窗口
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</body>
</html>