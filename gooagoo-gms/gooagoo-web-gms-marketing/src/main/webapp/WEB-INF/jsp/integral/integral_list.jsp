<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
  <!--内容-->
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">             
       <tr>
          <th width="4%">${shopVo.wordNames['gmsd031']}</th>
          <th width="18%">${shopVo.wordNames['gmsd032']}</th>
          <th width="18%">${shopVo.wordNames['gmsd033']}</th>
          <th width="10%">${shopVo.wordNames['gmsd034']}</th>                  
          <th width="12%">${shopVo.wordNames['gmsd035']}</th>  
          <th width="18%">${shopVo.wordNames['gmsd036']}</th>
 		  <th width="12%" colspan="2">${shopVo.wordNames['gmsd056']}</th> 
       </tr>
         <c:if test="${not empty pm.result}"> 
        <c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
             <tr>
              	<td>${xh.count+(page_cur-1)*pm.pageSize}</td>
                <td><fmt:formatDate value="${itemChild.convertStartTime}" type="both" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${itemChild.convertEndTime}" type="both" pattern="yyyy-MM-dd" /></td>
                <td>${itemChild.convertValue}</td>
                <td>${itemChild.convertType=="G" ? empty shopVo.wordNames['gmse001']?'商品':shopVo.wordNames['gmse001']: (itemChild.convertType=="C" ? shopVo.wordNames['gmsd082'] : "")}</td>
                <td>${itemChild.convertObjectName}</td>
                <td colspan="2">
                  <check:hasAuthority authorityID='13020201'>
                   <a href="javascript:formIntegral('${itemChild.id}');" title="${empty shopVo.wordNames['gmsd037'] ? '编辑' : shopVo.wordNames['gmsd037']}" class="handle pencil"></a>
	              </check:hasAuthority>
                   <a href="javascript:ToIntegralDeliveRById('${itemChild.id}');" title="积分兑换明细" class="handle" style="background-image: url('${imgPath}/gms/common/images/exchangeDetail.png');"></a>
	              <check:hasAuthority authorityID='13020202'>
	                <a href="javascript:deleteIntegral('${itemChild.id}');" title="${empty shopVo.wordNames['gmsd038'] ? '删除' : shopVo.wordNames['gmsd038']}" class="handle del"></a>
	              </check:hasAuthority>
	            </td>
             </tr>
		</c:forEach>
			 <tr>
				<td colspan="7">		
				 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
				</td>
             </tr>   
             <tr>
            <td colspan="7">
            <a href="${basePath }integralDeliver" style="color: #a0a0a0;text-decoration:underline;padding-left: 10px"><strong>积分发放明细</strong></a></td>
             </tr> 
		</c:if>
		<c:if test="${empty pm.result}">
		    <tr>
				<td colspan="8"><strong>${shopVo.wordNames['gmsd083']}</strong></td>
			</tr>
		</c:if>		
</table>