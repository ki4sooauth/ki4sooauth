<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>


<table width="100%" border="0" cellspacing="1" cellpadding="0" class="fileTable">
  <tr>
    <th width="20%">${shopVo.wordNames['gmsg211']}</th>
    <th width="20%">${shopVo.wordNames['gmsg212']}</th>
    <th width="20%">${shopVo.wordNames['gmsg213']}</th>
    <th  width="30%">${shopVo.wordNames['gmsg214']}</th>
    <th  width="15%">${shopVo.wordNames['gmsg221']}</th>
  </tr>
  <c:forEach items="${pageModel.result}" var="role">
  <tr>
    <td>${role.roleName}</td>
    <td>${role.note}</td>
    <td><fmt:formatDate value="${role.createTime}" pattern="yyyy-MM-dd"/></td>
    <td><check:hasAuthority authorityID="1402030201"><a href="javascript:void(0)" class="handle pencil"  onclick="edit('${role.roleId}');" title="${shopVo.wordNames['gmsg219']}"></a></check:hasAuthority>
     <check:hasAuthority authorityID="1402030202"><a href="javascript:void(0)" class="handle del" onclick="delRole('${role.roleId}')" title="${shopVo.wordNames['gmsg220']}"></a></check:hasAuthority></td>
      <td><check:hasAuthority authorityID="1402030203"><a href="javascript:void(0)" class="select" onclick="bindAuth('${role.roleId}')">${shopVo.wordNames['gmsg223']}</a></check:hasAuthority></td>
  </tr>
 </c:forEach>
 <c:forEach begin="${fn:length(pageModel.result)}" end="${pageModel.pageSize-1}" step="1">
   <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
  </tr>
 </c:forEach> 
</table>
