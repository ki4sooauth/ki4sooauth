<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${imgPath}/mis/css/mis.css" type="text/css" rel="stylesheet">
<title>编辑渠道节点页面</title>
</head>

<body>
<form id="addForm" method="post">
	<div class="popMsg">
		<h2>编辑渠道</h2>
		<br/>
		<ul>
		    <li>
			    <span >请输入渠道名称：</span>
			    <input type="text" value="${channelName}"  id ="channelName" name="channelName" maxlength="32"/>
				<label class="wrong" id="lbMac" style="width: 105px;display: none;">请输入渠道名称！</label>
		    </li> 	       
		</ul>
	</div>
	<div class="popBtn">
		<input type ="button" value="确定" class="left" onclick="edit();"/>
		<input type ="button" value="取消" onclick="closefbox();"/>
	</div>
</form>
<script type="text/javascript">

//编辑渠数据
function edit(){
    var data = "${channelCode}";
	if(data　!= null && "" != data){
		var url = "channel.do?method=updateChannel";
	    data = $("#addForm").serialize()+"&channelCode="+data;
	    var result = ajaxJsonVoByData(url,data);
	    alert(result);
		closefbox();
	}else{
		alert("请选中要编辑的节点!");
	} 
}

//关闭窗口
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
	(document.parentWindow || document.defaultView).parent.refresh();
}
</script>
</body>
</html>