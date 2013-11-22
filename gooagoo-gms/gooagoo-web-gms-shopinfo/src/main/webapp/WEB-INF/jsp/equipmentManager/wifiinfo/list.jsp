<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
				<table  width="100%"   border="0" cellpadding="0" cellspacing="1" style="margin:0px" class="fileTable">
					<tr class="tr1">
						<th width="10%">${shopVo.wordNames['gmsg265']}</th>
						<th width="25%">${shopVo.wordNames['gmsg266']}</th>
						<th width="25%">${shopVo.wordNames['gmsg267']}</th>
						<th width="20%">${shopVo.wordNames['gmsg334']}</th>
						 <th width="15%">${shopVo.wordNames['gmsg061']}</th>
<%--                			<th width="15%">${shopVo.wordNames['gmsg269']}</th> --%>
					</tr>
					
					<c:if test="${fn:length(pageModel.result) > 0}">
						<c:forEach items="${pageModel.result}" var="wifi" varStatus="var">
							<tr ${var.index%2==0?'':'class="tr2"'}>
								<td >${var.count}</td>
								<td >${wifi.wifiSsid}</td>
								<td>${wifi.wifiMac}</td>
								<td>${wifi.shopEntityName }</td>
								<td>
								<check:hasAuthority authorityID="1403020101"><a  href="javascript:void(0);" class="handle pencil" title="${shopVo.wordNames['gmsg270']}"
									onclick="edit('${wifi.wifiInfoId}')"></a> </check:hasAuthority>
<!-- 								</td> -->
<!-- 								<td> -->
								<check:hasAuthority authorityID="1403020103"><a href="javascript:void(0);"  class="handle del" onclick="deleteWifi('${wifi.wifiInfoId}')"   title="${shopVo.wordNames['gmsg271']}" ></a></check:hasAuthority>
								</td>
							</tr>
						</c:forEach>
						<c:forEach begin="${fn:length(pageModel.result) }"
							end="${pageModel.pageSize-1}" varStatus="status">
							<tr class="<c:if test='${status.index % 2 == 1}'>tr2</c:if>">
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
<!-- 								<td>&nbsp;</td> -->
							</tr>
						</c:forEach>
					</c:if>
				   <c:if test="${fn:length(pageModel.result)<=0}">
	              <tr>
	              	<td colspan="8">${shopVo.wordNames['gmsg272']}</td>
	              </tr>
              </c:if>
              <c:if test="${fn:length(pageModel.result) >0}">
	              <tr>
	                <td colspan="8">
	                    <%@include file="/WEB-INF/jsp/common/page.jsp" %>
	                </td>
	               </tr>
               </c:if>
</table>
