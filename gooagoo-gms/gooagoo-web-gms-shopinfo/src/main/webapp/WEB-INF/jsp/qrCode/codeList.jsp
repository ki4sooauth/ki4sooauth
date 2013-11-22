<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<table width="100%" border="0" id="printArea">
	<tr>
   <c:forEach items="${pageModel.result}" var="tableInfo" varStatus="i">
   <c:if test="${i.index%4==0}"></tr><tr></c:if>
		<td>
	<a href="#">
	<c:if test="${codeName eq 'Y' }">
		<img src='${basePath}/common.do?method=getTwoCode&content=${tableInfo.id}&size=3' 
			width="120" height="120" title="${tableInfo.id}"/>
	</c:if>
	<c:if test="${codeName eq 'Z' }">
		<img src='${basePath}/common.do?method=getTwoCode&content=["gooagoo","00","${tableInfo.shopEntityId}","${tableInfo.tableNo}","${tableInfo.roomName}"]&size=3' 
			width="120" height="120" title="['gooagoo','00','${tableInfo.shopEntityId}','${tableInfo.tableNo}','${tableInfo.roomName}']"/>
	</c:if>
			</a>
			<br/><br/>
				<span>${shopVo.wordNames['gmsg311']}</span>
				<samp>${tableInfo.tableNo}</samp>
			<br/><br/>
				<span>${shopVo.wordNames['gmsg312']}</span>
				<samp>${tableInfo.roomName}</samp>
			</td>

	</c:forEach>
		</tr>
</table>
             <div class="shopping_Flip">
               <%@ include file="/WEB-INF/jsp/common/page.jsp"%>
          </div>
          <a href="javascript:doPrint();" class="printa">${shopVo.wordNames['gmsg331']}</a>