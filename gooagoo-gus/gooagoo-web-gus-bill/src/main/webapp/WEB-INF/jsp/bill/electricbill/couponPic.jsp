<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
$(document).ready(function(){
	var indexName = $("input[name=id]").val();
	var html = "";
	$(parent.document).find("#" + indexName).parent().find("input[name=couImg]").each(function(){
		html = html +　"<li><img width='169' height='169' src='" + $(this).val() + "' /></li>";
	});
	$("#couponlist").html(html);
});
</script>
</head>
<style>
/*以上不复制*/
.picBox{width:547px;padding-left:10px;padding-bottom:10px;padding-top:10px;overflow:hidden;_height:1px;}
.picBox ul li{float:left;margin-right:10px;margin-bottom:10px;}
.picBox ul li img{display:block;border:none 0;}
</style>
<body>
	<input type="hidden" name="id" value="${id }"/>
	<div class="picBox">
    	<ul id="couponlist"></ul>
    </div>
</body>
</html>
