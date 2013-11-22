<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1402");
request.setAttribute("leftMenuCode", "140202");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${shopVo.wordNames['gmsg110']}</title>
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/shopUser.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
$(document).ready(function(){
	initFancyBox("fancybox_em",600,550,true);
	page("1");
})
</script>
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
           <check:hasAuthority authorityID="14020201"> <a href="javascript:add();">${shopVo.wordNames['gmsg111']}</a></check:hasAuthority>
            <span>${shopVo.wordNames['gmsg112']}</span>
          </div>
          <div id="userList">
        </div>
</div>
<div style="display: none;">
  <a class="fancybox_em" id="emFancybox"></a>
</div>
</div>
</div>
</body>
</html>
