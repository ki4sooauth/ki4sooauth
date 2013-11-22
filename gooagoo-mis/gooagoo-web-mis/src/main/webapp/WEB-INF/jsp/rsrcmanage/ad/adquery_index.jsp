<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广告位</title>
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
	ajaxToPageByData("shopAd.do?method=queryAllAdQuery","resultlist",data);
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
						<span>广告位编码：</span>
						<input type="text" id="adCode" name="adCode" />
					</label>
				    <label class="lab1">
					    <span>广告位名称：</span>
					    <input type="text" id="adName" name="adName" />
				    </label>
				    <label class="lab1">
					    <span>广告位类型：</span>
					    <select name="ruleType">
					    <option value="">--请选择--</option>
					    <c:forEach items="${ad_type }" var="item">
					    	<option value="${item.englishName}">${item.chineseName}</option>
					    </c:forEach>
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