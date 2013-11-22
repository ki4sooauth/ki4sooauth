<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<script type="text/javascript" src="${imgPath}/gus/bill/js/bill.js"></script>
<script type="text/javascript" src="${imgPath}/gus/bill/js/billFunction.js"></script>
<script type="text/javascript">
$(function(){
	$(".date").datepicker({
		changeMonth: true,
		changeYear: true,
		maxDate: new Date(),
	});
	initSelect();
})
</script>
<c:if test="${data != null && fn:length(data) > 0 }">
<table  class="title" cellspacing="0" cellpadding="0" width="100%">
  	<tr>
      	<td width="200">单号</td><td width="200">商家名称</td><td width="200">类别</td><td width="150">金额</td><td width="80">消费时间</td><td width="130" class="lastTd">其他</td>
	</tr>
</table>
<ul>
   	<li>
		<input type="hidden" name="count" value="${count}"/>
       	<table cellpadding="0" cellspacing="1">
			<c:forEach var="bill" items="${data}">
	               <tr class="list_msg" id="mtr1_${bill.billId}">
	               	<td width="200" class="remark">${bill.billNo}<!-- <p>dfsdfsdf</p> --></td>
	                   <td width="200">${bill.shopName}</td>
	                   <td width="200">${bill.billType}</td>
	                   <td width="150" class="money">￥${bill.fee}</td>
	                    <td width="80">${bill.requestTime}</td>
	                   <td width="130" class="control"><a class="edit" href="javascript:manualBillDis('${bill.billId}')" title="编辑"></a>
	                   <a href="javascript:deleteManualBill('${bill.billId}')" title="删除"></a></td>
	               </tr>
	               <tr class="hide_tr" id="mtr2_${bill.billId}">
	                       <td colspan="6">
	                           <div class="new_bill">
	                           <form>
	                               <ul>
	                               <li>
	                                   <span>单号：</span>
	                                   <input type="text" name="billNo" value="${bill.billNo}" maxlength="30"/>
	                                   <span>类别：</span>
	                                   <input type="text" name="billType" maxlength="50" value="${bill.billType}">
	                                   <span>金额：</span>
	                                   <input type="text" name="fee" value="${bill.fee}" maxlength="11" onkeyup="validatePices(this);" onblur="validatePices(this);"/>
	                               </li>
	                               <li>
	                                   <span>时间：</span>
	                                   <input class="date" type="text" name="requestTime" readonly="readonly" value="${bill.requestTime}"/>
	                                   <span>商家：</span>
	                                   <input type="text" name="shopName" value="${bill.shopName}" maxlength="30"/>
	                                   </li>
	                               <li>
	                                   <span>备注：</span>
	                                   <input class="bz" type="text" name="note" value="${bill.note}" maxlength="50"/>
	                               </li>
	                               </ul>
	                               <p class="btn_box">
	                                   <a class="btn" href="javascript:editManualBill('${bill.billId}')">提交</a>
	                                   <input class="btn" style="border:none 0;width:60px;height:22px;display:block;float:left;cursor:pointer;" type="reset" value="重置" />
	                               </p>
	                              </form>
	                           </div>
	                       </td>
	               </tr>
               	</c:forEach>
           </table>
       </li>
</ul>
<%@include file="/WEB-INF/jsp/common/page.jsp"%>
</c:if>
<c:if test="${data == null || fn:length(data) <= 0 }">
		<div class="sorryPrompt_1" align="center">
			<samp>${message}</samp>
		</div>
</c:if>
