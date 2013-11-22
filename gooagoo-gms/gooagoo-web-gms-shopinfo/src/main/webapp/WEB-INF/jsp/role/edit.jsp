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
<script type="text/javascript">
function checkForm(flag) {
	var roleName = $("input[name='roleName']").val();
	if(roleName==""){
	 alert("角色名称不能为空");
	 return;
	}
	var data =$("#roleForm").serialize();
	var url="${basePath}/shopRole.do?method="+flag;
	$("#idDisable").attr("disabled",true);
	$.ajax({
		type: "POST",
		async: false,
		url: url,
		data: data,
		dataType: "json",
		success: function(data){
		  if(data.success){	
			  $("#idDisable").attr("disabled",false);
			  alert(data.message);
			  parent.$.fancybox.close();
			  parent.page(1);
		  }else{
			  $("#idDisable").attr("disabled",false);
			  alert(data.message);
		  }
		},
		error:function(){
			$("#idDisable").attr("disabled",false);
		}
	});
}
</script>
</head>
<body>
<div class="limits_case">
   <form id="roleForm">
      	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${not empty fshopRole.roleId?shopVo.wordNames['gmsg128']:shopVo.wordNames['gmsg129']} </span>
          </div>
</div>
	<ul class="desk-num-poup">
		
		<li>
	    <span>${shopVo.wordNames['gmsg211']}</span><input type="hidden" name="roleId" value="${fshopRole.roleId}"/>
	    <input  id="roleName" name="roleName" class="borderStyle text" value="${fshopRole.roleName}"/>
		</li>
		<li>
	     <span>${shopVo.wordNames['gmsg212']}</span><textarea name="note" style="width:355px;height:155px" class="borderStyle select">${fshopRole.note}</textarea>
		</li>
	    <li class="commitBtn"><a href="#" class="inputBtn blueBtn" style="width: 150px" onclick="parent.$.fancybox.close();">${shopVo.wordNames['gmsg217']}</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"  class="inputBtn blueBtn" style="width: 150px" id="idDisable" onclick="checkForm(${not empty fshopRole.roleId?'\'update\'':'\'add\''});">${shopVo.wordNames['gmsg216']}</a>
	    </li>
	</ul>
    </form>
</div>
</body>
</html>