<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath}/gus/calendar/js/calendar.js"></script>
<table width="100%" border="0" cellspacing="3" cellpadding="0">
	<tr>
		<c:forEach begin="1" end="${requestScope.week}" step="1">
			<td></td>
<!-- 			<td><p class="gray"></p></td> -->
		</c:forEach>
			<c:forEach begin="1" end="${requestScope.days}" step="1" varStatus="status">
			<p id="cal_content_<fmt:formatNumber value="${status.index}" pattern="00"/>">
				<c:choose>
					 <c:when test="${isMonth && date==status.index}">
						<td class="curr" onclick="javascript:billListMessage('<fmt:formatNumber value="${status.index}" pattern="00"/>')">
							<p class="today">${status.index}
								<samp>
									<span class="span1" style="display:none" id="csl_<fmt:formatNumber value="${status.index}" pattern="00"/>" ></span>
									<span class="span2" style="display:none" id="cac_<fmt:formatNumber value="${status.index}" pattern="00"/>"></span>
									<span class="span3" style="display:none" id="cbil_<fmt:formatNumber value="${status.index}" pattern="00"/>"></span>
								</samp>
							</p>
						</td>
					</c:when>
					<c:otherwise>
						<td onclick="javascript:billListMessage('<fmt:formatNumber value="${status.index}" pattern="00"/>')"><p>${status.index}
							<samp>
								<span class="span1" style="display:none" id="csl_<fmt:formatNumber value="${status.index}" pattern="00"/>" ></span>
								<span class="span2" style="display:none" id="cac_<fmt:formatNumber value="${status.index}" pattern="00"/>"></span>
								<span class="span3" style="display:none" id="cbil_<fmt:formatNumber value="${status.index}" pattern="00"/>"></span>
							</samp>
						</p></td>
					</c:otherwise>
				</c:choose>
			</p>
			<c:if test="${(status.index+requestScope.week) mod 7==0 }">
				</tr><tr>
			</c:if>
	    </c:forEach>
	    <c:forEach begin="${requestScope.days}" end="35" step="1" >
			<td></td>
		</c:forEach>
	</tr>
</table>
				