<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<table class="goodsList_table" cellpadding="0" cellspacing="1" border="0" style="width: 100%;">
             <tr>
                <th width="5%">${shopVo.wordNames['gmsd018']}</th>
                <th width="25%">${shopVo.wordNames['gmsd019']}</th>
            	<th width="10%">发布渠道</th>
            	<th width="10%">${shopVo.wordNames['gmsd021']}</th>
                <th width="12%">${shopVo.wordNames['gmsd022']}</th>
 		        <th width="12%">${shopVo.wordNames['gmsd023']}</th>
 		        <th width="7%">${shopVo.wordNames['gmsd055']}</th>	 
            	<th width="36%" colspan="5">${shopVo.wordNames['gmsd056']}</th>          
            </tr>
          <c:if test="${not empty pm.result}"> 
       			<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
    				<tr>
		                <td>${xh.count+(page_cur-1)*pm.pageSize}</td>
		                <td>
		                <c:if test="${empty itemChild.webVisitUrl}"><span style="width:73px;height:65px;border: 1px;"><img width="73" height="65" src="${itemChild.couponUrl}"/></span><span>${itemChild.couponName}</span></c:if>
	            		<c:if test="${not empty itemChild.webVisitUrl}">
	            			<a href="javascript:void(0);" onclick="preview('${itemChild.webVisitUrl}');" title="预览"><span style="width:73px;height:65px;border: 1px;"><img width="73" height="65" src="${itemChild.couponUrl}"/></span><span>${itemChild.couponName}</span></a>
	            		</c:if>		                
		                </td>
		           <td>
	                    <c:if test="${itemChild.couponChannle=='0'}">积分商城</c:if>
		                <c:if test="${itemChild.couponChannle=='1'}">收藏广场</c:if>
		                <c:if test="${itemChild.couponChannle=='2'}">精确投放</c:if>    
              	   </td>
		           		<td>
		           			${itemChild.couponValue}
		           			${itemChild.couponType=="C" ? "元" : ""}
		           		</td>
		                <td><fmt:formatDate  value="${itemChild.useStartTime}" type="both" pattern="yyyy-MM-dd" /></td>
		                <td><fmt:formatDate  value="${itemChild.useEndTime}" type="both" pattern="yyyy-MM-dd" /></td>
		                <td>${itemChild.status=="W" ? "-待审核-" : (itemChild.status=="A" ? "-已审核-" : (itemChild.status=="B" ? "-未通过-" :(itemChild.status=="P" ? "已发布" : "未知状态")))}</td>
                        <td colspan="5">
                        <c:if test="${itemChild.status=='W'|| itemChild.status=='B'}">
                           <check:hasAuthority authorityID='13010201'>
		                     <a href="javascript:updateCoupon('${itemChild.couponId}');" title="${empty shopVo.wordNames['gmsd024'] ? '编辑' : shopVo.wordNames['gmsd024']}" class="handle pencil"></a>
		                	</check:hasAuthority>
		                </c:if>
                        <c:if test="${itemChild.couponMode=='2' and itemChild.status!='P'}">                   	                     
                          <a href="javascript:void(0)" onclick="importExcel('${itemChild.couponId}');" title="导入号段号码excel" style="background-image:url('${imgPath}/gms/common/images/upload.png'); " class="handle"></a>                      	
                        </c:if>		                
                        <c:if test="${itemChild.status=='W'}">
                        	<check:hasAuthority authorityID='13010203'>
                             <a href="javascript:formCheckCoupon('${itemChild.couponId}');" title="${empty shopVo.wordNames['gmsd026'] ? '审核' : shopVo.wordNames['gmsd026']}" class="handle book" ></a>
                        	</check:hasAuthority>
                        </c:if>
                        <c:if test="${itemChild.status=='A'}">
                        	<check:hasAuthority authorityID='13010204'>
                             <a href="javascript:releaseCoupon('${itemChild.couponId}');" title="${empty shopVo.wordNames['gmsd027'] ? '发布' : shopVo.wordNames['gmsd027']}" class="handle issue"></a>
                        	</check:hasAuthority>
                        </c:if>
                         <a href="javascript:void(0)" onclick="detail('${itemChild.couponId}');" title="${shopVo.wordNames['gmsc015']}" class="detailMark" ></a>     
                       <check:hasAuthority authorityID='13010202'>
                        <a href="javascript:deleteCoupon('${itemChild.couponId}');" title="${empty shopVo.wordNames['gmsd025'] ? '删除' : shopVo.wordNames['gmsd025']}" class="handle del"></a>
                       </check:hasAuthority>       
                        </td>              
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
				<td colspan="11"><strong>${shopVo.wordNames['gmsd057']}</strong></td>
		    </tr>
		</c:if>
</table>