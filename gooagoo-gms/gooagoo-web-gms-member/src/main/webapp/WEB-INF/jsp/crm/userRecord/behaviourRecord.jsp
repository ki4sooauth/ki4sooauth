<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
              <tr>
                <td colspan="6" class="behaviorSearch">
         <!--   <input type="text" class="behaviorInput" /><a href="javascript:void(0)" class="search orangeBtn">查询</a> -->
                </td>
              </tr>
              <tr>
                 <th width="20%">${shopVo.wordNames['cpmf074']}</th>
                 <th width="20%">${shopVo.wordNames['cpmf075']}</th>
                 <th width="20%">${shopVo.wordNames['cpmf076']}</th>
                 <th width="40%">${shopVo.wordNames['cpmf077']}</th>
              </tr>
              <c:forEach items="${pageModel.result}" var="beh">
              <tr>
                 <td>${beh.actionType}</td>
                 <td><fmt:formatDate value="${beh.actionTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                  <td>${beh.source}</td>
                  <td>${beh.ipAddress}</td>
              </tr>
              </c:forEach>
              <c:if test="${empty pageModel.result}">
                 <tr>
                <td colspan="4">暂无信息</td>
              </tr>
              </c:if>
              <tr>
                <td colspan="6">
                 <%@include file="/WEB-INF/jsp/common/page.jsp"%>
                </td>
 </tr>
</table>
