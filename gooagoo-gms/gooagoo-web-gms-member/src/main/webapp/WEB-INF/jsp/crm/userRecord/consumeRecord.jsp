<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
 behaviorSelect();
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
              <tr>
                <td colspan="3" class="behaviorSearch">
          <!--  <input type="text" class="behaviorInput" /><a href="javascript:void(0)" class="search orangeBtn">查询</a> -->
                </td>
              </tr>
              <tr>
                <th width="20%">${shopVo.wordNames['cpmf078']}</th>
                <th width="40%">${shopVo.wordNames['cpmf079']}</th>
                <th width="40%">${shopVo.wordNames['cpmf080']}</th>
              </tr>
              <c:forEach items="${pageModel.result}" var="con">
              <tr>
                <td>${con.orderNo}</td>
                <td>${con.payMoney}</td>
                <td class="behaviorPosition"><span class="behaviorSelect"><span class="square"></span></span>
                <label class="moneyNum"><fmt:formatDate value="${con.payTime}" pattern="yyyy-MM-dd HH:mm:ss" /></label></td>
              </tr>
              <tr class="hide">
                <td colspan="3" class="hideTab">
                  <u><img src="${con.billImg}" width="135"/></u>
                      <table border="0" cellspacing="1" cellpadding="0" class="moneyTab">
                      <tr>
                        <td width="40%" class="title">${shopVo.wordNames['cpmf081']}</td>
                        <td width="20%" class="title">${shopVo.wordNames['cpmf082']}</td>
                        <td width="20%" class="title">${shopVo.wordNames['cpmf083']}</td>
                        <td width="20%" class="title">${shopVo.wordNames['cpmf084']}</td>
                      </tr>
                      <c:forEach items="${con.consumeRecordDetailList}" var="detail">
                      <tr>
                        <td>${detail.goodsName}</td>
                        <td>${detail.goodsPrice}</td>
                        <td>${detail.goodsNum}</td>
                        <td>${detail.totalPrice}</td>
                      </tr>
                     </c:forEach>
                 </table>
                </td>
              </tr>
             </c:forEach >
             <c:if test="${empty pageModel.result}">
	            <tr>  
	             <td colspan="3">
	                                            暂无记录
	              </td>
	            </tr> 
            </c:if>    
            <tr>  
             <td colspan="3">
                <%@include file="/WEB-INF/jsp/common/page.jsp"%> 
              </td>
            </tr>
            </table>
