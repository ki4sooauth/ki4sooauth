<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分配商家用户角色</title>
</head>
<body>
<div class="popMsg">
<h2>分配商家用户角色</h2>
  <ul style="padding: 10px 45px 0px;">
  	<c:if test="${!empty role }">
  	<c:if test="${!empty user.roleId }">
    <li><label><input type="radio" value="clear" name="roleId" class="cBoxN"/>清空</label></li>
    </c:if>
    </c:if>
  </ul>
  <ul>
  	<c:choose>
  	<c:when test="${!empty role }">
  	<c:forEach var="item" items="${role }">
    	<li><label><input type="radio" value="${item.roleId }" name="roleId" class="cBoxN" <c:if test="${user.roleId eq item.roleId }">checked=checked</c:if>/>${item.roleName}</label></li>
    </c:forEach>
    </c:when>
    <c:otherwise>
    	<h3>暂无商家角色</h3>
    </c:otherwise>
    </c:choose>
  </ul>
  <div class="popBtn">
  	<c:if test="${!empty role }">
  	<input type="hidden" id="shopId" name="shopId" value="${shopId }"/>
  	<input class="addbtn517 left" id="save" type="button" value="确定" onclick="javascript:saveUserRole();"/>
  	</c:if>
    <input class="addbtn517" type="button" value="取消" onclick="javascript:closefbox();"/>
  </div>
</div>
<script type="text/javascript">
//保存用户角色 
function saveUserRole(){
	$("#save").hide();
	var shopId = $("#shopId").val();
	var roleId = $("input[name='roleId']:checked").val();
	var url = "shopUserManange.do?method=assignShopUserManange";
	var data = "roleId=" + roleId + "&shopId=" + shopId;
	$.ajax({
		type: "POST",
		async: false,
		url: url,
		data: data,
		dataType:"json",
		success: function(result){
			if(result.success){
				alert(result.message);
				(document.parentWindow || document.defaultView).parent.closeFancyBox();
				(document.parentWindow || document.defaultView).parent.page(1);
			}else{
				alert(result.message);
				$("#save").show();
			}
		}
	});
}
//取消按钮点击
function closefbox(){
	(document.parentWindow || document.defaultView).parent.closeFancyBox();
}
</script>
</body>
</html>