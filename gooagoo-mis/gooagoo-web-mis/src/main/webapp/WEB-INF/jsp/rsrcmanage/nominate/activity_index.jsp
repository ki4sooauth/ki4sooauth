<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动推荐列表</title>
<script type="text/javascript">
var varPageIndex = 1;
$(function(){
	page(varPageIndex);
});

// 分页查询 
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	varPageIndex = index;
	var data = $("#searchForm").serialize() + "&pageIndex=" + index;
	ajaxToPageByData("nominateA.do?method=queryListPage","resultlist",data);
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
					    <span>活动主题：</span>
					    <input type="text" id="title" name="title" />
				    </label>
				</p>
				<p>
					<label class="lab1">
						<span>起始时间：</span>
						<input id="activityStartTime" name="activityStartTime" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>结束时间：</span>
						<input id="activityEndTime" name="activityEndTime" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>是否推荐：</span>
						<select name="isNominate" id="isNominate">
							<option value="">--请选择--</option>
							<option value="Y">是</option>
							<option value="N">否</option>
						</select>
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