<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>规则配置</title>
<script>
$(function(){
	page(1);
});
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	var data = $("#searchForm").serialize() + "&pageIndex=" + index;
	ajaxToPageByData("ruleConfig.do?method=queryAllShop","resultlist",data);
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
						<span>商家名称：</span>
						<input type="text" id="shopName" name="shopName" />
					</label>
					<label class="lab1">
						<span>邮箱地址：</span>
						<input type="text" id="email" name="email" />
					</label>
					<label class="lab1">
						<span>商家状态：</span>
						<select id="shopStatus"name="shopStatus">
							<option value="">--请选择--</option>
							<c:forEach items="${shop_status }" var="shop">
								<option value="${shop.englishName }">${shop.chineseName }</option>
							</c:forEach>
						</select>
					</label>
					<label class="lab1">
						<span>是否连锁：</span>
						<select id="isChain" name="isChain">
								<option value="">--请选择--</option>
								<option value="Y">连锁</option>
								<option value="N">非连锁</option>
						</select>
					</label>
				</p>
				<p>
					<label class="lab1">
						<span>部署模式：</span>
						<select id="serviceStyle" name="serviceStyle">
							<option value="">--请选择--</option>
							<c:forEach items="${service_style }" var="service">
								<option value="${service.englishName }">${service.chineseName }</option>
							</c:forEach>
						</select>
					</label>
				</p>
				<p class="p1">
					<input type="reset" value="重置" /><input type="button" value="查询" onclick="javascript:page(1);" />
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