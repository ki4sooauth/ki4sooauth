<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/userState.js"></script>
<script type="text/javascript">
var basePath = "${basePath}";
</script>
<div class="natural_quality">
	<p style="height:80px;">
		<span>${shopVo.wordNames['cpmf033']}</span><input type="text" name="groupName" onfocus="$('#nameMsg').html('');" style="width:190px;height:20px;"><br/><label id="nameMsg" style="color: red;clear:both; display:block;padding:5px 0 0 72px;"></label>
		<span>${shopVo.wordNames['cpmf034']}</span><input type="text" name="groupDesc" onfocus="$('#descMsg').html('');" style="width:190px;height:20px;"><br/><label id="descMsg" style="color: red;clear:both; display:block;padding:5px 0 0 72px;"></label>
	</p>
</div>
<a class="blueBtn savebtn" style="cursor: pointer;height: 30px;width: 50px;margin-top:0px;" href="javascript:saveUserCrowd();">${shopVo.wordNames['cpmf035']}</a>	