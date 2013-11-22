<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsb198']}</title>
 <%@include file="/WEB-INF/jsp/common/top.jsp"%>
 <link type="text/css" rel="stylesheet" href="${imgPath}/gms/member/css/voucher_list.css" />
</head>
<body>
<div style="display:none;">
	<a href="#" id="detail" class="fancybox_detail"></a>
</div>
<div class="voucher_list" style="width: 90%;">
	<div class="file_nav" id="relationTabs">
		<div id="relationTabs" class="file_nav">
		<a href="javascript:void(0);" id="tab_E" class="curr">${shopVo.wordNames['gmsb198']}</a>
	</div>
		
	  <table width="750px" border="0" cellpadding="0" cellspacing="1" class="fileTable">
		<tr>
		  	<th>${shopVo.wordNames['gmsb199']}</th>
		  	<th width="20%">${shopVo.wordNames['gmsb200']}</th>
		  	<th width="20%">${shopVo.wordNames['gmsb201']}</th>
		  	<th width="13%">${shopVo.wordNames['gmsb202']}</th>
		  	<th width="13%">${shopVo.wordNames['gmsb203']}</th>
		</tr>
		<c:if test="${not empty list}">
			<c:forEach var="itemChild" items="${list}" varStatus="xh">
				<tr>
					<td>${itemChild.tableName}</td>
					<td>${itemChild.tableStatus=='3' ? shopVo.wordNames['gmsb204'] : itemChild.tableStatus=='2' ? shopVo.wordNames['gmsb205'] : shopVo.wordNames['gmsb206']}</td>
					<td>${itemChild.dishesnum}</td>
					<td>${itemChild.ischecknum}</td>
					<td>${itemChild.notchecknum}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty list}">
			<tr style="height:  30px;">
				<td colspan="6"><strong>${shopVo.wordNames['gmsb207']}</strong></td>
			</tr>
		</c:if>
	</table>
	<div class="commitBnt">
		<a style="float:none;" href="javascript:void(0);" onclick="(document.parentWindow || document.defaultView).parent.closeFancybox(); " class="curr">${shopVo.wordNames['gmsb208']}</a>
	</div>
	<div style="height:20px;">&nbsp;</div>
	</div>
</div>
</body>
</html>