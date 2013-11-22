<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${imgPath}/gms/status/js/InStoreStatus.js"></script>
<script type="text/javascript">
	var basePath="${basePath}";
	$(document).ready(function(){
		page(1)
	});
</script>
<style type="text/css">
	.voucher_list{margin-bottom: 20px; margin-left: 20px; margin-right: 20px; margin-top: 20px;}
</style>
<div id="table" class="voucher_list" style="width: 96%">
</div>

