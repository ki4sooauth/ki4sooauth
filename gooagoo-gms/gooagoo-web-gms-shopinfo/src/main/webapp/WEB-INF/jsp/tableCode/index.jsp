<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140307");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${shopVo.wordNames['gmsg324']}</title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/tableInfo.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
$(document).ready(function(){
	initFancyBox("fancybox_em",615,460,true);
	page("1");
})
</script>
</head>
<style type="text/css">
.desk-num-poup {
    padding: 0px;
}

.desk-num-poup li.commitBtn {
    margin-right: 80px;
    padding-top: 0px;
    text-align: center;
}
</style>
<body>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
         <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
         <div class="section">
          <div class="rightTitle_add">
            <check:hasAuthority authorityID="14030701"><a href="javascript:add();">${shopVo.wordNames['gmsg302']}</a></check:hasAuthority>
            <span>${shopVo.wordNames['gmsg325']}</span>
          </div>
          <ul class="desk-num-poup" style="width:800px">
				<li style="margin-right: 15px">
				<%@ include file="/WEB-INF/jsp/common/shopEntity.jsp"%>
				<span style="margin-left: 10px">餐桌类型：</span>
				<select name="tableCode" id="tableCode" class="borderStyle select">
						<option value="">${shopVo.wordNames['gmsg241']}</option>
						<c:forEach items="${pageModel}" var="t">
						<option value="${t.id }">${t.name}</option>
						</c:forEach>
				</select></li>
					<li class="commitBtn"><input type="submit" onclick="page(1)" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg230']}"></li>
			</ul>
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
