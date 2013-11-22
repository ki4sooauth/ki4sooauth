
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
			<tr>
				<th width="5%">${shopVo.wordNames['gmsg273']}</th>
				<th width="5%">${shopVo.wordNames['gmsg274']}</th>
				<th width="6%">${shopVo.wordNames['gmsg275']}</th>
				<th width="16%">${shopVo.wordNames['gmsg276']}</th>
				<th width="18%">${shopVo.wordNames['gmsg334']}</th>
				<th width="10%">${shopVo.wordNames['gmsg277']}</th>
				<th width="4%">${shopVo.wordNames['gmsg278']}</th>
				<th width="8%">操作系统</th>
				<th width="10%">解析格式</th>
				<th width="10%">功能</th>
				<th width="8%">${shopVo.wordNames['gmsg235']}</th>
<%-- 				<th width="10%">${shopVo.wordNames['gmsg280']}</th> --%>
			</tr>
			<c:if test="${fn:length(pageModel.result) == 0}">
				<c:forEach begin="0" end="${pageModel.pageSize}" varStatus="status">
					<tr class="<c:if test='${status.index % 2 == 1}'>tr2</c:if>">
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td class="td1">&nbsp;</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(pageModel.result) > 0}">
				<c:forEach items="${pageModel.result}" var="transInfo"
					varStatus="var">
					<tr ${var.index%2==0?'':'class="tr2"'}>
						<td>${pm.pageSize*(pm.pageIndex-1)+var.index+1}</td>
						<td><input type="hidden" value="${transInfo.deviceType}"/>${transInfo.typeNameCh}</td>
						<td>${transInfo.deviceSn}</td>
						<td>${transInfo.deviceMac}</td>
						<td>${transInfo.shopEntityName}</td>
						<td><fmt:formatDate value="${transInfo.installDate}"
								pattern="yyyy.MM.dd" /></td>
						<td>${transInfo.status=="0"?shopVo.wordNames['gmsg281']:(transInfo.status=="1"?shopVo.wordNames['gmsg282']:shopVo.wordNames['gmsg283'])}</td>
						<td>${transInfo.systemType}</td>
						<td>${transInfo.billParseName}</td>
						<td>${transInfo.stServiceName}</td>
<%-- 						<td>${transInfo.note}</td> --%>
						<td class="td1">
						<check:hasAuthority authorityID="1403040101"><a  href="javascript:void(0);" class="handle pencil" onclick="edit('${transInfo.deviceTransponderId}')" title="${shopVo.wordNames['gmsg284']}"></a></check:hasAuthority>
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
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</c:forEach>
			</c:if>
			 <c:if test="${fn:length(pageModel.result)<=0}">
	              <tr>
	              	<td colspan="11">${shopVo.wordNames['gmsg285']}</td>
	              </tr>
              </c:if>
              
              <tr>
                <td colspan="11">
                    <%@include file="/WEB-INF/jsp/common/page.jsp" %>
                </td>
               </tr>
		</table>