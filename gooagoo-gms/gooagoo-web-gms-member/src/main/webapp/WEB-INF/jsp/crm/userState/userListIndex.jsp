<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/userState.js"></script>
<script type="text/javascript">
 var basePath="${basePath}";
$(document).ready(function(){
  page(1);
});
</script>
<div id = "table">
</div>

