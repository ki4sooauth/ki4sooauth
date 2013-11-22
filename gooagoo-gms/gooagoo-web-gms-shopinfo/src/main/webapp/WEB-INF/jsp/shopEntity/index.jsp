<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1402");
request.setAttribute("leftMenuCode", "140201");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${shopVo.wordNames['gmsg008']}</title>
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/shopEntity.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
$(document).ready(function(){
	initFancyBox("fancybox_em",600,350,true);
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
            <check:hasAuthority authorityID="14020101"><c:if test="${shopStatus eq 'L'}"><a href="javascript:add();">${shopVo.wordNames['gmsg009']}</a></c:if></check:hasAuthority>
            <span>${shopVo.wordNames['gmsg008']}</span>
          </div>
          <div id="tableList">
        </div>
</div>
<div style="display: none;">
  <a class="fancybox_em"></a>
</div>
</div>
</div>
</body>
</html>
