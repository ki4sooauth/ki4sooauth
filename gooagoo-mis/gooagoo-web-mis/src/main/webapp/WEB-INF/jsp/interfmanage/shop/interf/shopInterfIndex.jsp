<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>商家接口列表</title>
<script type="text/javascript">
$(function(){
	page(1);
});
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	var data = "&pageIndex="+index+"&shopId=${shopId}";
	ajaxToPageByData("interfshop.do?method=shopInterfList","resultlist",data);
}
</script>
</head>

<body>
<div style="display:none;">
	<input id="shopId1" type="hidden" value="${shopId }" />
</div>
<div class="big_box" id="resultlist">
</div>
</body>
</html>