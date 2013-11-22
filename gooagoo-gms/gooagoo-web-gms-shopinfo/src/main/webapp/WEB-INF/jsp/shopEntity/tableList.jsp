<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
              <tr>
                <th width="20%">${shopVo.wordNames['gmsg056']}</th>
                <th width="18%">${shopVo.wordNames['gmsg057']}
             </th>
                <th width="24%">${shopVo.wordNames['gmsg058']}
               </th>
                <th width="10%">${shopVo.wordNames['gmsg059']}
                </th>
                <th width="10%">${shopVo.wordNames['gmsg060']}
               </th>
                <th width="12%">${shopVo.wordNames['gmsg061']}
               </th>
              </tr>
              <c:forEach items="${pageModel.result}" var="entity" varStatus="status" >
	              <tr>
	               <td>${entity.shopEntityName}</td>
				    <td>${entity.registeredNumber}</td>
				    <td>${entity.enterpriseName}</td>
				    <td>${entity.corporate}</td>
				    <td>${entity.registeredCapital}</td>
	                <td><check:hasAuthority authorityID="1402010201"><a href="javascript:void(0)" class="handle pencil" onclick="edit('${entity.shopEntityId}')" title="${empty shopVo.wordNames['gmsg062'] ? '修改' : shopVo.wordNames['gmsg062']}"></a></check:hasAuthority>
                    <check:hasAuthority authorityID="1402010202"><c:if test="${shopStatus eq 'L'}"><a href="javascript:void(0)" class="handle del" onclick="delShopEntity('${entity.shopEntityId}');" title="${empty shopVo.wordNames['gmsg063'] ? '删除' : shopVo.wordNames['gmsg063']}"></a></c:if></check:hasAuthority></td>
	              </tr>
              </c:forEach>
               <c:if test="${fn:length(pageModel.result)<=0}">
	              <tr>
	              	<td colspan="6">暂无记录</td>
	              </tr>
              </c:if>
              <tr>
                <td colspan="6">
                  <div class="page_box">
                    <ul>
                       <%@include file="/WEB-INF/jsp/common/page.jsp" %>
                    </ul>
                </div>
                </td>
          </tr>
  </table>
<script type="text/javascript">
 $(function(){
   var num = ${fn:length(pageModel.result)};
   var isChain = "${isChain}";	 
   if("N"==isChain && num>0){
	  $(".rightTitle_add a").remove(); 
   }	 
 });
</script>  