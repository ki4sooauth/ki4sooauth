<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<style>
#print{
background:url(${imgPath}/gms/shopinfo/images/dayinji.png) no-repeat left center;
position:absolute;left:20px;bottom:9px;display:block;height:20px;
line-height:20px;padding-left:25px;color:#666;
text-decoration:underline;
}
</style>
 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
              <tr>
                <th width="20%">${shopVo.wordNames['gmsg332']}</th>
                <th width="18%">${shopVo.wordNames['gmsg333']}</th>
                <th width="24%">${shopVo.wordNames['gmsg334']}</th>
                <th width="20%">${shopVo.wordNames['gmsg335']}</th>
            	<th width="12%">${shopVo.wordNames['gmsg061']}</th>
              </tr>
              <c:forEach items="${pageModel.result}" var="table" varStatus="status" >
	              <tr>
	              	<td>${table.tableNo}</td>
	                <td>${table.roomName}</td>
	                <td>${table.shopEntityName}</td>
	                <td>${table.remark}</td>
	                <td><check:hasAuthority authorityID="1403070201"><a href="javascript:edit('${table.id}')" class="handle pencil"></a></check:hasAuthority>
                    <check:hasAuthority authorityID="1403070202"><a href="javascript:deleteTableInfo('${pm.pageIndex}','${table.id}')" class="handle del"></a></check:hasAuthority></td>
	              </tr>
              </c:forEach>
               <c:if test="${fn:length(pageModel.result)<=0}">
	              <tr>
	              	<td colspan="6">${shopVo.wordNames['gmsg339']}</td>
	              </tr>
              </c:if>
              <tr>
                <td colspan="6">
                	<div style="position:relative;">
                    <%@include file="/WEB-INF/jsp/common/page.jsp" %>
                    </div>
                </td>
          </tr>
  </table>
 