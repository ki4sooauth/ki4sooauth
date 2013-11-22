<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1302");
%>
<script>
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
function formDeliver(shopIntegralConvertId){
	if(confirm("确认发货？")){
		//如果当前页只剩一条记录，删除操作时当前页改为上一页页码
		pIndex=curSize==1 && pIndex!=1? --pIndex:pIndex;
		var url = "${basePath }integralDeliver.do?method=deliver";
		var data = "&id="+shopIntegralConvertId;
		ajaxJsonTipByData(url,data,true);
		page(pIndex);
	}
}
</script>
<!--内容-->
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">       
          <tr>
          <th width="6%">序号</th>                       
          <th width="12%">${shopVo.wordNames['gmsd035']}</th> 
          <th width="8%">收货人</th>   
          <th width="24%">收货地址</th>
 		  <th width="12%">联系电话</th>
 		  <th width="8%">邮政编码</th>
 		  <th width="6%">状态</th>
 		  <th width="6%">操作</th>
          </tr>
		 <c:if test="${not empty pm.result}"> 
       <c:forEach var="itemChild" items="${pm.result}" varStatus="xh"> 
              <tr height="33" bgcolor=${xh.count%2==0 ? "#f0f0f0" : "#FFFFFF"}>
               <td><span>${xh.count+(page_cur-1)*pm.pageSize}</span></td>
               <td><span>${itemChild.integralTradeType=="C" ? shopVo.wordNames['gmsd082'] : shopVo.wordNames['gmse001']}</span></td>
               <td><span>${itemChild.name}</span></td>
               <td><span>${itemChild.address}</span></td>
               <td><span>${itemChild.telephone}</span></td>
               <td><span>${itemChild.postcode}</span></td>
               <td><span>${itemChild.isDelivery=='Y'?' 已发货' :' 未发货'}</span></td>
               <td>
                  <c:if test="${itemChild.isDelivery!='Y'}">  
                  <a href="javascript:void(0)" onclick="formDeliver('${itemChild.shopIntegralConvertId}');" title="发货" style="background-image:url('${imgPath}/gms/marketing/images/auditing.png'); " class="handle"></a>                      	          

                  </c:if>
		          <c:if test="${itemChild.isDelivery=='Y'}">-</c:if>
                </td>
              </tr>
      </c:forEach>
             <tr>
				<td colspan="9">
				 	<%@include file="/WEB-INF/jsp/common/page.jsp"%>	
				</td>
			</tr>
              </c:if>
        <c:if test="${empty pm.result}">
			<tr>
				<td colspan="9"><strong>暂无积分发放信息</strong></td>
			</tr>
		</c:if>	
</table>      