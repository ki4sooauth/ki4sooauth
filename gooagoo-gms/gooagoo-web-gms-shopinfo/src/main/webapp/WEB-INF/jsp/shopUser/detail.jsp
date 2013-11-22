<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "14020202");
request.setAttribute("leftMenuCode", "1402020204");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/shopUser.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
$(document).ready(function(){
	initFancyBox("fancybox_em",600,550,true);
})
</script>
</head>
<body>
   	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg150']}</span>
          </div>
</div>
<!-- 			<p class="title">详细信息</p> -->
			<ul class="desk-num-poup">
				<c:if test="${not empty userInfo.headImg}"><li><span>头像</span>&nbsp;<img src="${userInfo.headImg}"/></li></c:if>
				<li><span>${shopVo.wordNames['gmsg131']}</span>&nbsp;${userInfo.userId}</li>
				<li><span>${shopVo.wordNames['gmsg132']}</span>&nbsp;${userInfo.name}</li>
				<li><span>${shopVo.wordNames['gmsg141']}</span>&nbsp;${userInfo.sex eq 'M'?shopVo.wordNames['gmsg121']:userInfo.sex eq 'F'?shopVo.wordNames['gmsg122']:''}</li>
				<li><span>${shopVo.wordNames['gmsg142']}</span>&nbsp;<fmt:formatDate value="${userInfo.birthday}" pattern="yyyy-MM-dd"/></li>
				<li><span>${shopVo.wordNames['gmsg133']}</span>&nbsp;${userInfo.idTypeCn}</li>
				<li><span>${shopVo.wordNames['gmsg140']}</span>&nbsp;${userInfo.idNo}</li>
				<li><span>${shopVo.wordNames['gmsg144']}</span>&nbsp;${userInfo.shopEntityName}</li>
				<li><span>${shopVo.wordNames['gmsg148']}</span>&nbsp;${userInfo.brandName}</li>
				 <li><span>${shopVo.wordNames['gmsg145']}</span>${userInfo.status eq '0'?shopVo.wordNames['gmsg146']:userInfo.status eq '1'?shopVo.wordNames['gmsg147']:''}</li>
				 <li class="commitBtn"><input type="button" style="width: 100px;" onclick="parent.edit('${userInfo.userId}');"  class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg151']}">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" style="width: 100px" onclick="parent.$.fancybox.close();"  class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg152']}"></li>
			</ul>
			<div class="control">
<%--     	<a href="#" onclick="edit('${userInfo.userId}');">编辑</a><a href="#" onclick="parent.$.fancybox.close();">关闭</a> --%>
    </div>
</body>
</html>
