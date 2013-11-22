<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gooagoo平台管理系统</title>
<script type="text/javascript">
$(document).ready(function(){
	//菜单样式 
	menuCss();	
});  
//顶部菜单点击样式更改
function menuCss(){
	$('#menu ul li a').each(function(){
		  $(this).click(function(){
		  $('#menu ul li a').removeClass();
		  $(this).addClass('a_hover');
		  });
		});	
}

//修改密码弹出框 
function modifyPwd(){
	window.open("login.do?method=showModifyPwd","ChangePwd","top=260,left=300,toolbar=no,resizable=0,width=700,height=350");	
}
//退出
function logout() {
    window.top.location.href = "${passport}/misLogout";
}
   
function init(){
	$('#menu ul li a').eq(0).addClass('a_hover');
}
init();
</script>
</head>

<body>
<!--头部-->
<div class="head">
	<div class="logo">
		<a href="#"><img src="${imgPath}/mis/images/nav/logo2-01.png" /></a>
	</div>
	<div class="wel">
		<span class="span1">欢迎进入GOOAGOO系统管理！</span>
		<span>当前用户：<a href="#" class="a1" style="cursor: default;">${mis_login_id}</a></span>
		<c:if test="${mis_login_id != null }">
			<a href="javascript:void(0)" onclick="modifyPwd()" id="modifypwd" name="modifypwd">修改密码</a>
		</c:if>
		<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
			<c:if test="${item.pId eq parentId2 and item.name eq 'CMS'}">
				<a href="javascript:void(0)" onclick="window.open ('${item.url}') ">进入CMS系统</a>
			</c:if>
		</c:forEach>
		<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
			<c:if test="${item.pId eq parentId2 and item.name eq '模板管理'}">
				<a href="javascript:void(0)" onclick="window.open ('${item.url}') ">进入模板系统</a>
			</c:if>
		</c:forEach>
		<a href="javascript:void(0)" onclick="logout()">退出</a>
	</div>
</div>
<!--menu-->
<div class="big_menu">
	<div class="menu" id="menu">
	   <ul>
	   		<li><a href="login.do?method=loginSuccess" target="_top">首页</a></li>
	   		<c:forEach	var="item" items="${mis_login_auths}" varStatus="im">
	   			<c:if test="${item.pId eq '-1' && item.id != 'C' && item.id != '5'}">
	   				<li><a href="${item.url}" target="frameBody" >${item.name}</a></li>
	   			</c:if>
	   		</c:forEach>
	   </ul>
	</div>
</div>
</body>
</html>