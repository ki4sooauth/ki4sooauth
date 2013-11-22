<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140305");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>位置批量导入</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/tree-list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/position.js"></script>
<link rel="stylesheet" href="${imgPath}/gms/shopinfo/css/demo.css" type="text/css"/>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
$(document).ready(function(){
	shopEntityPosition();
});
</script>
</head>
<body>
   <!--头部-->
   <%@include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
        <%@include file="/WEB-INF/jsp/common/left.jsp"%>
        <div class="section">
         <form name="imPostion" id="imPostion" method="post" enctype="multipart/form-data" >
          <div class="rightTitle_add">
            <span>位置批量导入</span>
          </div>
          <div  ${not empty gmsLoginInfo.shopEntityId?'style="display: none；height:40px"':'style="display: block；height:40px;"'}>
          <span style="line-height: 30px;color:#0873B9;font-weight: bold;">${shopVo.wordNames['gmsg304']}</span><select  id ="shopEntityId" name="shopEntityId" ${not empty loginInfo.shopEntityId?"disabled='disabled'":""} onchange="init('${gmsLoginInfo.shopId}');">
		   <option value="">${shopVo.wordNames['gmsg134']}</option>
		  </select>
		</div>
		<div class="tree-list">
		<div style="width: 490px;background-color:#F8F7F7;border:0px;margin-top: 200px;margin-right: 100px;" class="location"  >
             <ul>
                <li>选择文件：<input type="file" name="filename"/></li>
                <li class="commitBtn">
                <check:hasAuthority authorityID="14030503"><a  id="addButton" class="blueBtn" href="${imgPath}/gms/shopinfo/template/template_position.xls" style="margin-right: 50px;">下载模版</a>
                <a  class="blueBtn" href="javascript:void(0);" onclick="importPosition();">批量导入</a></check:hasAuthority></li>
             </ul>
           </div>
       </div>
       </form>
      </div>
    </div>
    </div>
</body>
</html>

