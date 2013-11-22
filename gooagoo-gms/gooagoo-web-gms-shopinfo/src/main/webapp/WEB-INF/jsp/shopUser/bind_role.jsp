<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<html>
<head>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("topMenuCode", "14020202");
request.setAttribute("leftMenuCode", "1402020203");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsg153']}</title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form id="roleForm">
<input name="userId" type="hidden" value="${userId}"/>
<!-- <div class="binding_box"> -->
<!-- 		<p class="title">绑定角色选择</p> -->
<!--     <ul class="desk-num-poup"> -->
<%--     <c:forEach items="${fshopRoleList}" var="role"> --%>
<%--      <li><input name="roleIds"  type="checkbox"  <c:forEach items="${roleList}" var="r">${r eq role.roleId ? "checked='checked'":""}</c:forEach>   value="${role.roleId}"/><span>${role.roleName}</span></li> --%>
<%--      <li>${role.note}</li> --%>
<%--     </c:forEach> --%>
<!--     <li class="commitBtn"><input type="submit"  class="inputBtn blueBtn" value="保存"></li> -->
<!--     </ul> -->
<!--     <div class="control"> -->
<!--     	<a href="#" onclick="parent.$.fancybox.close();">取消</a><a href="#" onclick="submit();">确定</a> -->
<!--     </div> -->
<!-- </div> -->
   	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg154']}</span>
          </div>
</div>
 <table width="98%" border="0" cellpadding="0" cellspacing="1" class="fileTable" style="margin: 6px">
              <tr>
                <th width="10%" ><input id="recommendProductTableCheckAll" type="checkbox" onclick="checkAll(this)"></th>
                <th width="45%">${shopVo.wordNames['gmsg155']}</th>
                <th width="45%">${shopVo.wordNames['gmsg156']}</th>
              </tr>
              <c:forEach items="${fshopRoleList}" var="role">
	              <tr>
	              	<td><input name="roleIds"  type="checkbox"  <c:forEach items="${roleList}" var="r">${r eq role.roleId ? "checked='checked'":""}</c:forEach>   value="${role.roleId}"/></td>
	                <td>${role.roleName}</td>
	                <td>${role.note}</td>

	              </tr>
              </c:forEach>
  </table>
  <ul class="desk-num-poup"> 
 <li class="commitBtn"><input type="button"  onclick="submitRole();" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg157']}"></li>
  </ul>
</form>
<script type="text/javascript">
function checkAll(obj) {
	var checkArray = document.getElementsByName("roleIds");
	for (var i = 0; i < checkArray.length; i++) {
	
		checkArray[i].checked = obj.checked;
	}
// 	checkSingleRow();
}
function submitRole(){
var roleName = $("input[name='roleName']").val();
var data =$("#roleForm").serialize();
var url="${basePath}/shopUser.do?method=updateRole";
$.ajax({
	type: "POST",
	async: false,
	url: url,
	data: data,
	dataType: "json",
	success: function(data){
	  if(data.success){	
		  alert(data.message);
		  parent.$.fancybox.close();
		  page(1);
	  }else{
		  alert(data.message);
	  }
	}
});
}
</script>
</body>
</html>