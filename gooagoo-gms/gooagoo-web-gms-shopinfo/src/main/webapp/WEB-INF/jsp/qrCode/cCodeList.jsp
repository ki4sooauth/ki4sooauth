<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<table width="100%" border="0" id="printArea">
	<tr>
   <c:forEach items="${pageModel.result}" var="t" varStatus="i">
	<c:if test="${i.index%4==0}"></tr><tr></c:if>
		<td>
	<a href="#">
	<c:if test="${codeName eq 'X' }">
		<img src='${basePath}/common.do?method=getTwoCode&content=${t.webVisitUrl}&size=3' 
			width="120" height="120" title="${t.webVisitUrl}"/>
	</c:if>
	<c:if test="${codeName eq 'Y' }">
		<img src='${basePath}/common.do?method=getTwoCode&content=${t.couponId}&size=3' 
			width="120" height="120" title="${t.couponId}"/>
	</c:if>
			</a><br/><br/>
				<span>${shopVo.wordNames['gmsd063']}：</span>
				<samp>${t.couponName}</samp><br/><br/>
				<span>${shopVo.wordNames['gmsd065']}：</span>
				<samp>${t.couponValue}</samp><br/><br/>
		</td>
	</c:forEach>
</tr>
</table>
<div class="shopping_Flip">
               <%@ include file="/WEB-INF/jsp/common/page.jsp"%>
          </div>
          <a href="javascript:doPrint();" class="printa">${shopVo.wordNames['gmsg331']}</a>