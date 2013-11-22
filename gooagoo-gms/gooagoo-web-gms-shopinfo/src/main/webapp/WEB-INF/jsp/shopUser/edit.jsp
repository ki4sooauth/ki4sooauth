<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<html>
<head>
<style type="text/css">


#navdd {    
    width:320px;
    float:left;       
	overflow-x:scroll;
	overflow-y:hidden;
	margin-left: 95px;
} 
#navdd1 {    
    width:320px;
    float:left;       
	
	overflow-y:hidden;
} 
#navdd ul,#navdd li{ list-style-type:none; margin:0; padding:0;x-overflow:scroll;white-space:nowrap;}
#navdd li{float:Left;padding-right:8px;width:40px;text-align:center;}
#navdd li .curr{border:2px solid red;}
#navdd li a{text-decoration:underline;color:#888;line-height:20px;font-size:12px;}
#navdd li img{cursor: pointer}
</style>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "14020202");
request.setAttribute("leftMenuCode", "1402020201");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/shopUser.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
 $(document).ready(function(){
	 initValidate(${not empty userInfo.userId?'\'update\'':'\'add\''});
 })
</script>
</head>
<body>
   	<form  name="userForm" id="userForm" >
   	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${not empty userInfo.userId?shopVo.wordNames['gmsg128']:shopVo.wordNames['gmsg129']} ${shopVo.wordNames['gmsg130']}</span>
          </div>
</div>

<%-- 			<p class="title">${not empty userInfo.userId?'编辑':'添加'}用户信息</p> --%>
			<ul class="desk-num-poup">
			
				 <li><span>头像</span>&nbsp;
						<div id="navdd1">
						
				 <img class="curr" id="srcId"   src="<c:if test="${not empty userInfo.headImg}">${userInfo.headImg}</c:if><c:if test="${ empty userInfo.headImg}">${imgPath}/gms/shopinfo/images/qs.jpg</c:if>" width="50" height="50" />
				 <a href="#" onclick="headImgColl();">${not empty userInfo.headImg?shopVo.wordNames['gmsg128']:shopVo.wordNames['gmsg129']} </a>
				 <input  type="hidden" name="headImg" value="${userInfo.headImg }" />
				 </div>
					<div id="navdd" style="display: none">
						   <div style="width:500px;" id="sizeImg">
							   <ul>
							        <c:forEach items="${headImg}" var="v" varStatus="i">
							       <li><img src="${v.value}" width="40" height="40" id="img${i.index}" name="nameSrc" onclick="copyHeadImg('${i.index}');" ${v.value eq userInfo.headImg?"class='curr'":"" } /></li>
							   </c:forEach>
							   </ul>
						   </div>
						</div>
				 </li>
				<li><span>${shopVo.wordNames['gmsg131']}</span>&nbsp;<input class="borderStyle text" type="text" name="userId" value="${userInfo.userId}" maxlength="50"/></li>
				<li><span>${shopVo.wordNames['gmsg132']}</span>&nbsp;<input class="borderStyle text"  type="text" name="name" value="${userInfo.name}" maxlength="50"/></li>
				<li><span>${shopVo.wordNames['gmsg133']}</span>&nbsp;
				 <select class="borderStyle select" name="idType" >
				   <option value="">${shopVo.wordNames['gmsg134']}</option>
				   <option value="00" ${userInfo.idType eq '00'?'selected=selected':''}>${shopVo.wordNames['gmsg135']}</option>
				   <option value="01" ${userInfo.idType eq '01'?'selected=selected':''}>${shopVo.wordNames['gmsg136']}</option>
				   <option value="02" ${userInfo.idType eq '02'?'selected=selected':''}>${shopVo.wordNames['gmsg137']}</option>
				   <option value="03" ${userInfo.idType eq '03'?'selected=selected':''}>${shopVo.wordNames['gmsg138']}</option>
				   </select>
				 </li>
				<li><span>${shopVo.wordNames['gmsg140']}</span>&nbsp;<input class="borderStyle text"  type="text" name="idNo" value="${userInfo.idNo}" maxlength="20" onblur="checkNumberInfo()"/>
				<label class="error" style="color: red; margin-left: 5px; font-size: 12px;display: none;"  id="idNoError">${shopVo.wordNames['gmsg139']}</label>
				</li>
				<li><span>${shopVo.wordNames['gmsg141']}</span>&nbsp;<select class="borderStyle select" name="sex" >
				        <option value="">${shopVo.wordNames['gmsg134']}</option>
						<option ${userInfo.sex eq 'F'?'selected=selected':''} value="F">${shopVo.wordNames['gmsg122']}</option>
						<option ${userInfo.sex eq 'M'?'selected=selected':''} value="M">${shopVo.wordNames['gmsg121']}</option></select></li>
				<li><span>${shopVo.wordNames['gmsg142']}</span>&nbsp;<input class="borderStyle text"  type="text" name="birthday" value="<fmt:formatDate value='${userInfo.birthday}' pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'temp.bsMinDate'})"/></li>
<%-- 				<div id="divPwd" ${not empty userInfo.userId?'style="display: none"':'style="display: block"'}> --%>
					<li><span>${shopVo.wordNames['gmsg143']}</span>&nbsp;<input class="borderStyle text"  type="password" name="password"  maxlength="32"/></li>
<!-- 				</div> -->
				
				<li  ${not empty gmsLoginInfo.shopEntityId?'style="display: none"':'style="display: block"'}><span>${shopVo.wordNames['gmsg144']}</span>&nbsp;
				 <select class="borderStyle select"  id="shopEntityId" name="shopEntityId"  onchange="brandlist();" ${not empty loginInfo.shopEntityId?"disabled='disabled'":""}>
				   <option value="">${shopVo.wordNames['gmsg134']}</option>
				   <c:forEach items="${entityList}" var="entity">
				   <option ${userInfo.shopEntityId eq entity.shopEntityId?"selected=selected":""}  ${loginInfo.shopEntityId eq entity.shopEntityId?"selected=selected":""} value="${entity.shopEntityId}">${entity.shopEntityName}</option>
				   </c:forEach>
				 </select>
				 </li>
				
				 <li style="clear: both"><span>${shopVo.wordNames['gmsg145']}</span>&nbsp;
				   <select class="borderStyle select" name="status" >
				        <option value="">${shopVo.wordNames['gmsg134']}</option>
						<option ${userInfo.status eq '0'?'selected=selected':''} value="0">${shopVo.wordNames['gmsg146']}</option>
						<option ${userInfo.status eq '1'?'selected=selected':''} value="1">${shopVo.wordNames['gmsg147']}</option>
				   </select>
				 </li>
				<li><span>${shopVo.wordNames['gmsg148']}</span>&nbsp;
				   <select class="borderStyle select" name="brand"  id="brand">
				     <option value="">${shopVo.wordNames['gmsg134']}</option>
				     <c:forEach items="${brandList}" var="brand">
				       <option ${brand.brandId eq userInfo.brand?'selected=selected':''} value="${brand.brandId}">${brand.brandName}</option>
				     </c:forEach>
				   </select>
<%-- 				   <input type="text" value="${brand.id}" id="brandid">  --%>
				</li>
				
				<li class="commitBtn"><input type="submit" id="idDisable" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg149']}"></li>
			</ul>
		</form>
		
</body>
</html>
