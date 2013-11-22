<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${imgPath}/gms/member/js/userRecord/userDetail.js"></script>
<script type="text/javascript">
	var basePath = "${basePath}";
	$(document).ready(function() {
		page(1);
	});
function page(pageIndex) {
	$.ajax({
		url : basePath + "marketingState.do?method=tableList",
		type : "post",
		data : {'pageIndex' : pageIndex,'pageSize' : 10},
		dataType : "html",
		success : function(data) {
			$("#table").html(data);
		}
	});
}
</script>
<div id="table"></div>

