<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1402");
request.setAttribute("leftMenuCode", "140203");
%>

<html>
<head>
<script>
$(document).ready(function(){
	var basePath="${basePath}";
	initFancyBox("fancybox_em",322,550,true);
	initFancyBox("fancybox_em2",550,500,true);
	page("1");
	 $(".limits tr:even").css("background","#f5f5f5");
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsg210']}</title>
</head>
<body>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
         <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
         <div class="section">
          <div class="rightTitle_add">
              <p class="limits_control">
    <check:hasAuthority authorityID="14020301"><a href="#" onclick="add();">${shopVo.wordNames['gmsg218']}</a></check:hasAuthority>
    </p>
            <span>${shopVo.wordNames['gmsg210']}</span>
          </div>
          
          <div id="userList">
        </div>
</div>
<div style="display: none;">
  <a class="fancybox_em" id="emFancybox"></a>
  <a class="fancybox_em2" id="emFancybox2"></a>
</div>
</div>
</div>

<!-- <div style="display: none;"> -->
<!-- <a href="#" id="emFancybox" class="fancybox_em"></a> -->
<!-- </div> -->
<script type="text/javascript">
function add() {
	$("#emFancybox2").attr("href","${basePath}/shopRole.do?method=addform").click();
}
function edit(roleId) {
	var param="";
	if(roleId!=null && roleId!=""){
		param="&roleId="+roleId;
	}
	$("#emFancybox2").attr("href","${basePath}/shopRole.do?method=updateform"+param).click();
}

function bindAuth(roleId) {
	$("#emFancybox").attr("href","${basePath}/shopRole.do?method=toBindAuth&roleId="+roleId).click();
}
function page(pageIndex) {
	var id = "userList";
	var url = "${basePath}/shopRole.do?method=page";
	$.ajax({
		type : "POST",
		async : false,
		url : url,
		dataType : 'html',
		success : function(html) {
			$("#" + id).html(html);
		},
		error : function() {
			alert("网络连接异常，请检查网络并重新登录");
			cToShopUserInfo();
		}
	});
}

function delRole(roleId) {
	var id = "userList";
	var data="roleId="+roleId;
	var url = "${basePath }/shopRole.do?method=delete";
	$.ajax({
		type : "POST",
		async : false,
		url : url,
		data:data,
		dataType : 'json',
		success : function(data) {
		   if(data.success){
			   alert(data.message);
			   page(1);
		   }else{
			   alert(data.message);
		   }
		},
		error : function() {
			alert("网络连接异常，请检查网络并重新登录");
			cToShopRoleInfo();
		}
	});
}
</script>
</body>
</html>