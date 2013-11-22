<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<table class="fileTable" cellpadding="0" cellspacing="1" border="0" style="width: 100%;">
             <tr>
                <th width="5%">${shopVo.wordNames['gmsd018']}</th>
                <th width="26%">优惠凭证号段号码</th>
            </tr>
          <c:if test="${not empty pm.result}"> 
       			<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
    				<tr>
		                <td>${xh.count+(page_cur-1)*pm.pageSize}</td>
		                 <td>${itemChild.couponNo}</td>       
					</tr>
				</c:forEach>	
		   	 <tr>
				<td colspan="11">
				 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
				</td>
			</tr>
				</c:if>
		<c:if test="${empty pm.result}">
			<tr>
				<td colspan="11"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		    </tr>
		</c:if>
</table>