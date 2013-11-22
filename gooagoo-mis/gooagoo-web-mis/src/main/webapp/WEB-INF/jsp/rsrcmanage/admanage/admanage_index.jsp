<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广告位管理</title>
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
	ajaxToPageByData("adManage.do?method=queryAllAdManage","resultlist",data);
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
					    <span>广告位名称：</span>
					    <input type="text" id="adName" name="adName" />
				    </label>
				    <label class="lab1">
					    <span>起拍价：</span>
					    <input type="text" id="startingPrice" name="startingPrice" />
				    </label>
				    <label class="lab1">
					    <span>涨幅：</span>
					    <input type="text" id="increase" name="increase" />
				    </label>
				    <label class="lab1">
					    <span>状态：</span>
					    <select name="state">
					    	<option value="">--请选择--</option>
					    	<option value="0">空闲</option>
					    	<option value="1">发布</option>
					    	<option value="2">已拍</option>
					    	<option value="3">已提交资料</option>
					    	<option value="4">已审核</option>
					    	<option value="5">已收款</option>
					    	<option value="6">已卖出</option>
					    </select>
				    </label>
				</p>
				<p>
				    <label class="lab1">
					    <span>得标商家名称：</span>
					    <input type="text" id="winnerShooName" name="winnerShooName" />
				    </label>
				    <label class="lab1">
					    <span>得标金额：</span>
					    <input type="text" id="bidAmount" name="bidAmount" />
				    </label>
					<label class="lab1">
					    <span>竞价起始时间：</span>
					    <input id="bidStartTime" name="bidStartTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" style="cursor: pointer;" />
				    </label>
				    <label class="lab1">
					    <span>竞价结束时间：</span>
					    <input id="bidEndTime" name="bidEndTime" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" style="cursor: pointer;" />
				    </label>
				</p>
				<p>
				    <label class="lab1">
					    <span>生效起始日期：</span>
					    <input id="effectStartDate" name="effectStartDate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="cursor: pointer;" value="<fmt:formatDate value="${curreDate}" type="both" pattern="yyyy-MM-dd" />"/>
				    </label>
				    <label class="lab1">
					    <span>生效结束日期：</span>
					    <input id="effectEndDate" name="effectEndDate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="cursor: pointer;"/>
				    </label>
					<label class="lab1">
					    <span>生效起始时间：</span>
					    <input id="effectStartTime" name="effectStartTime" type="text" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" class="Wdate" style="cursor: pointer;" />
				    </label>
				    <label class="lab1">
					    <span>生效结束时间：</span>
					    <input id="effectEndTime" name="effectEndTime" type="text" onfocus="WdatePicker({dateFmt:'HH:mm:ss'})" class="Wdate" style="cursor: pointer;" />
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