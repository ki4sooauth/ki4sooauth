<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
              <tr>
               <td colspan="6" class="behaviorSearch">
<!--                   <input type="text" class="behaviorInput" /><a href="javascript:void(0)" class="search orangeBtn">查询</a> -->
               </td>
              </tr>
              <tr>
                 <th width="30%">${shopVo.wordNames['cpmf085']}</th>
                 <th width="20%">${shopVo.wordNames['cpmf086']}</th>
                 <th width="30%">${shopVo.wordNames['cpmf087']}</th>
                 <th width="20%">${shopVo.wordNames['cpmf088']}</th>
              </tr>
              <c:forEach items="${pageModel.result}" var="integral">
              <tr>
                <td>${integral.userName}</td>
                <td>${integral.integralNumber}</td>
                <td>${integral.integralSource}</td>
                <td><fmt:formatDate value="${integral.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
              </tr>
              </c:forEach>
              <c:if test="${empty pageModel.result}">
                 <tr>
                <td colspan="5">暂无信息</td>
              </tr>
              </c:if>
              <tr>
                <td colspan="5">
                  <%@include file="/WEB-INF/jsp/common/page.jsp"%> 
                </td>
 </tr>
</table>
