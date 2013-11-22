<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
		<table id="userShopShoplinklidInfo" width="100%" border="0"
			cellpadding="0" cellspacing="1" class="fileTable">
			<tr class="tr1">
				<th width="6%">NO .</th>
				<th width="10%">${shopVo.wordNames['gmsg352']}</th>
				<th width="18%">${shopVo.wordNames['gmsg360']}</th>
				<th width="20%">${shopVo.wordNames['gmsg334']}</th>
				<th width="20%">${shopVo.wordNames['gmsg353']}</th>
				<th width="8%">${shopVo.wordNames['gmsg354']}</th>
				<th width="12%">${shopVo.wordNames['gmsg361']}</th>
				<th class="td1" width="15%">${shopVo.wordNames['gmsg362']}</th>
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
						<td class="td1">&nbsp;</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(pageModel.result) > 0}">
				<c:forEach items="${pageModel.result }" var="entity"
					varStatus="status">
					<tr class="<c:if test='${status.index % 2 == 1}'>tr2</c:if>">
						<td>${status.count }</td>
						<td>${entity.deviceSn }</td>
						<td>${entity.deviceMac }</td>
						<td>${entity.shopEntityName }</td>
						<td>${entity.positionName }</td>
						<td>${entity.status=='0'?shopVo.wordNames['gmsg356']:(entity.status=='1'?shopVo.wordNames['gmsg357']:(entity.status=='2'?shopVo.wordNames['gmsg358']:shopVo.wordNames['gmsg358']))}</td>
						<td><fmt:formatDate value="${entity.createTime}"
								pattern="yyyy.MM.dd" /></td>
					<td><check:hasAuthority authorityID="1403030101"><a href="javascript:void(0)" class="handle pencil" 
					onclick="edit('${entity.id}','${entity. positionId}')" title="${shopVo.wordNames['gmsg367']}"></a></check:hasAuthority></td>
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
					</tr>
				</c:forEach>
			</c:if>
			   <c:if test="${fn:length(pageModel.result)<=0}">
	              <tr>
	              	<td colspan="8">暂无记录</td>
	              </tr>
              </c:if>
              
              <tr>
                <td colspan="8">
                    <%@include file="/WEB-INF/jsp/common/page.jsp" %>
                </td>
          </tr>
		</table>
		