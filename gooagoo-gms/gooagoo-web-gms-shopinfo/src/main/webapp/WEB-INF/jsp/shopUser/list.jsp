<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
              <tr>
                <th width="20%">${shopVo.wordNames['gmsg113']}</th>
                <th width="6%">${shopVo.wordNames['gmsg114']}</th>
                <th width="24%">${shopVo.wordNames['gmsg115']}</th>
                <th width="20%">${shopVo.wordNames['gmsg116']}</th>
                 <th width="18%">${shopVo.wordNames['gmsg061']}</th>
<%--                  <th width="6%">${shopVo.wordNames['gmsg118']}</th> --%>
<%--                <th width="6%">${shopVo.wordNames['gmsg119']}</th> --%>
            	<th width="6%">${shopVo.wordNames['gmsg120']}</th>
              </tr>
              <c:forEach items="${pageModel.result}" var="user">
	              <tr>
	              	<td>${user.name}</td>
	                <td>${user.sex eq 'M'?shopVo.wordNames['gmsg121']:user.sex eq 'F'?shopVo.wordNames['gmsg122']:''}</td>
	                <td>${user.shopEntityName}</td>
	                <td>${user.brandName}</td>
	                <td><check:hasAuthority authorityID="1402020204"><a href="javascript:void(0)" class="detailMark" onclick="detail('${user.userId}')" title="${shopVo.wordNames['gmsg123']}"></a></check:hasAuthority>
	       			&nbsp;<check:hasAuthority authorityID="1402020201"><a href="javascript:void(0)" class="handle pencil" onclick="edit('${user.userId}','${user.shopEntityId}');" title="${shopVo.wordNames['gmsg124']}"></a></check:hasAuthority>
	       			<check:hasAuthority authorityID="1402020202"><a href="javascript:void(0)" class="handle del" onclick="delUser('${user.userId}');" title="${shopVo.wordNames['gmsg125']}"></a></check:hasAuthority></td>
                    <td><check:hasAuthority authorityID="1402020203"><a href="javascript:void(0)" class="select" onclick="bindRole('${user.userId}');">${shopVo.wordNames['gmsg126']}</a></check:hasAuthority></td>
	              </tr>
              </c:forEach>
               <c:if test="${fn:length(pageModel.result)<=0}">
	              <tr>
	              	<td colspan="8">${shopVo.wordNames['gmsg127']}</td>
	              </tr>
              </c:if>
              
              <tr>
                <td colspan="8">
                    <%@include file="/WEB-INF/jsp/common/page.jsp" %>
                </td>
          </tr>
  </table>
