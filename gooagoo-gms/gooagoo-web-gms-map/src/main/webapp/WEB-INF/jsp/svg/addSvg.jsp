<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1304");
%>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/shopBuild.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>

<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/demo.css" type="text/css"/>

<script type="text/javascript" src="${imgPath}/gms/gmap/js/ztree_shopEntity.js"></script>
<script type="text/javascript" src="${imgPath}/gms/gmap/js/ztree_position.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加svg数据</title>
</head>

<body>
    <!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
	  <div class="article">
		<%@include file="/WEB-INF/jsp/common/left.jsp"%>
		<div class="section">
			<div class="rightTitle_add">
			<span>添加svg文件数据</span>
		</div>
		 <form action="${basePath}/svg.do?method=addSvgDo" method="POST" enctype="multipart/form-data">
            <div class="productBuild marketingMsg">
            	<ul>
                	<li><span>svg文件</span>
                	<input type="file" name="svgFile">
                	<input type="hidden" name="mapId" value="${mapId }"/>
                	<input type="hidden" name="shopEntityId" value="${shopEntityId }"/>
                	</li>
                </ul>
                <input type="submit" value="上传文件"  style="color:#fff;background:#0471C0;border:none 0;height:26px;width:66px;"/>
            </div>
           </form>
          </div>
	 </div>
   </div>
  
<!-- 实体店 --> 
<div id="shop_entity_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="shop_entity_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
<div id="position_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="position_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
</body>
</html>