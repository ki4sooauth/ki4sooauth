<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>已选人群</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
</head>
<body>
	<div class="container">
		<div class="article" style="margin-left: 20px; width: 760px;">
			<div class="rightTitle" style="margin-top: 24px; ">
				<span class="peopleSpan"><strong class="peopleCount">0</strong>${shopVo.wordNames['cpmb059']}</span>
			</div>
			<span id="userInfoList"></span>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
	 		page(1);
		});
		function page(index){
			var data="&pageIndex="+index+"&pageSize=10&"+parent.$("#memberSearchForm").serialize();
			var url = "${basePath}rule.do?method=pageUserAccount";
			ajaxToPageByData(url,"userInfoList",data);
		}
	</script>
</body>
</html>
