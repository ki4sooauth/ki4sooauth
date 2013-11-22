<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐优惠凭证列表</title>
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
	ajaxToPageByData("nominateC.do?method=queryListPage","resultlist",data);
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
					    <span>优惠凭证名称：</span>
					    <input type="text" id="couponName" name="couponName" />
				    </label>
				    <label class="lab1">
					    <span>商家名称：</span>
					    <input type="text" id="shopName" name="shopName" />
				    </label>
				    <label class="lab1">
					    <span>优惠凭证类型：</span>
					    <select name="couponType">
					    	<option value="">--请选择--</option>
					    	<option value="C">代金券</option>
					    	<option value="D">折扣券</option>
					    </select>
				    </label>
				</p>
				<p>
					<label class="lab1">
					    <span>是否推荐：</span>
					    <select name="isNominate">
					    	<option value="">--请选择--</option>
					    	<option value="Y">是</option>
					    	<option value="N">否</option>
					    </select>
				    </label>
					<label class="lab1">
						<span>使用生效日期：</span>
						<input id="useStartTime" name="useStartTime" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>使用截止日期：</span>
						<input id="useEndTime" name="useEndTime" class="Wdate" type="text" onfocus="WdatePicker()" value="" style="cursor: pointer;" />
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