<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!--内容-->
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">       
         <tr>
	         <th width="6%">${empty shopVo.wordNames['gmsd041'] ? '序号' : shopVo.wordNames['gmsd041']}</th>
	         <th width="24%">${empty shopVo.wordNames['gmsd042'] ? '精品类型' : shopVo.wordNames['gmsd042']}</th>
	         <th width="28%">${empty shopVo.wordNames['gmsd043'] ? '推荐精品' : shopVo.wordNames['gmsd043']}</th>
			 <th width="10%">${empty shopVo.wordNames['gmsd044'] ? '创建时间' : shopVo.wordNames['gmsd044']}</th>
			 <th width="12%" colspan="2">${shopVo.wordNames['gmsd056']}</th>
         </tr>
         <c:if test="${not empty pm.result}"> 
       <c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
            <tr>
               <td><span>${xh.count+(page_cur-1)*pm.pageSize}</span></td>
               <td><span>${itemChild.jingpinTypeName}</span></td>
               <td><span>${itemChild.goodsName}</span></td>
               <td><span><fmt:formatDate value="${itemChild.createTime}" type="both" pattern="yyyy-MM-dd" /></span></td>
               <td colspan="2">
                <check:hasAuthority authorityID='13030201'>
                  <a href="javascript:formJingpin('${itemChild.jingpinId}');" title="${empty shopVo.wordNames['gmsd045'] ? '编辑' : shopVo.wordNames['gmsd045']}" class="handle pencil"></a>
             </check:hasAuthority>
			 <check:hasAuthority authorityID='13030202'>
                <a href="javascript:deleteJingpin('${itemChild.jingpinId}');" title="${empty shopVo.wordNames['gmsd046'] ? '删除' : shopVo.wordNames['gmsd046']}" class="handle del"></a>
             </check:hasAuthority>
               </td>
            </tr>
		</c:forEach>
		   	<tr>	   	
		      <td colspan="6">
		 	    <%@include file="/WEB-INF/jsp/common/page.jsp"%>	
		      </td>
	       </tr>
	</c:if>
	<c:if test="${empty pm.result}">
	       <tr>
			  <td colspan="6"><strong>${shopVo.wordNames['gmsd097']}</strong></td>
		   </tr>
	</c:if>	
</table>	