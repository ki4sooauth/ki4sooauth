<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
 <table class="bill_table" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th width="40%">${shopVo.wordNames['gmsg096']}</th>
                    <th width="40%">${shopVo.wordNames['gmsg097']}</th>
                    <th width="20%">${shopVo.wordNames['gmsg061']}</th>
                </tr>
                <c:forEach items="${invoiceList}" var="inv" varStatus="i">
                <tr id="trInvo${i.index}">
                    <td id="${inv.invoiceType}">${inv.invoiceType eq '1' ? shopVo.wordNames['gmsg098']: shopVo.wordNames['gmsg099']}</td>
                    <td>${inv.invoiceName}</td>
                    <td>
		                <input type="hidden" name="invoName${inv.invoiceType eq '1' ? 1: 2}" value="${inv.invoiceName}" />
                    <a href="#tableForm" class="handle pencil add_btn" name="${i.index}" clazz="${inv.invoiceType eq '1' ? 1: 2}" id='edit' title="${shopVo.wordNames['gmsg118']}"></a>
                    <a href="javascript:void(0)" class="handle del" onclick="delInv('${inv.invoiceType eq '1' ? 1: 2}',this);" title="${shopVo.wordNames['gmsg119']}"></a>
                    </td>
                </tr>
               </c:forEach>
               <c:if test="${empty invoiceList}">
               <tr>
                    <td colspan="4">暂无记录</td>
                </tr>
               </c:if>
 </table>
 <script>
 initFancyBoxHtml();
 </script>