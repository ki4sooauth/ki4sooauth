<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐页面</title>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",970,780,true);
	page(1);
});

// 分页查询 
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	varPageIndex = index;
	var data = $("#searchForm").serialize() + "&pageIndex=" + index;
	ajaxToPageByData("nominateA.do?method=cancelNominateActivityPage","resultlist",data);
}
</script>
</head>
<body>
<!--内容-右边栏-->
<div class="content_right">
	<div class="div_top">
		<div class="div_p">
			<form id="searchForm" name="searchForm">
				<p>
				    <label class="lab1">
					    <span>活动名称：</span>
					    <input type="text" id="activityName" name="activityName" />
				    </label>
					<label class="lab1">
						<span>商家名称：</span>
						<input type="text" id="shopName" name="shopName" />
					</label>
					<label class="lab1">
						<span>起始时间：</span>
						<input id="startTime" name="startTime" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>结束时间：</span>
						<input id="endTime" name="endTime" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
					</label>
				</p>
				<p class="p1">
					<input type="reset" value="重置" />
					<input type="button" value="查询" onclick="javascript:page(1);" />
				</p>
			</form>
		</div>
		<div class="div_in">
			<input type="button" class="in6" />
		</div>
	</div>
	<div>
		<div class="big_box" id="resultlist">
		</div>
	</div>
</div>
<div class="clear"></div>
</body>
</html>