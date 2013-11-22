<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1404");
request.setAttribute("leftMenuCode", request.getAttribute("flag"));
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames[coding]}${shopVo.wordNames['gmsg338']}</title>
<link type="text/css" rel="stylesheet" href="${imgPath}/gms/common/css/quickMark_list.css" media="screen"/>
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/qrCode.js"></script>
<script type="text/javascript">
var basePath="${basePath}";

</script>
</head>
<body>
   <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">	
      <div class="article">
<!--         <div class="aside"> -->
          <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
<!--         </div> -->
        <div class="section">
          <div class="rightTitle">
            <span>${shopVo.wordNames[coding]}${shopVo.wordNames['gmsg338']}${shopVo.wordNames['gmsg328']}</span>
          </div>
          <div class="print_box">
          <c:if test="${flag eq 140404||flag eq 140401}">
          	<span style="width: 110px;margin-left: -6px">实体店</span>
				   <select class="borderStyle select"  id="shopEntityId" name="shopEntityId" style="margin-left: -6px">
				   <option value="">${shopVo.wordNames['gmsg134']}</option>
				   <c:forEach items="${entityList}" var="entity">
				   <option  value="${entity.shopEntityId}">${entity.shopEntityName}</option>
				   </c:forEach>
				 </select>
			<br/><br/>	
			</c:if>
			<span style="width: 110px;${flag  eq 140402||flag  eq 140403?'margin-left: -6px':''}">打印内容</span>
			<select name="codeName" id="codeName" style="margin-left: -6px">
			<c:if test="${empty detail}">
			<option value="X">详情链接地址</option>
			</c:if>
			<option value="Y">标示码</option>
			<c:if test="${empty coupon}">
			<option value="Z">定制内容</option>
			</c:if>
			</select>
			<br /><br />
			<span style="width: 110px;">每页显示数量</span><input type="text" name="pageSize" value="10"/>
			<br /><br />
			
			<span style="width: 110px;">${shopVo.wordNames['gmsg330']}</span><input type="text" name="picSize" value="120"/>
			<br /><br />
			${shopVo.wordNames['gmsg329']}<br /><br />
			<a href="javascript:printPreview('${flag}');" class="blueBtn">打印预览</a>
          </div>
  </div>
</body>
</html>
