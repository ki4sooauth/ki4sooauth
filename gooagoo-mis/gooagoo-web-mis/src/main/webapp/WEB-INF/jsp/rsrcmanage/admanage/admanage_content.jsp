<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",720,580,true);
});

// 增加
function add(){
	var url = "adManage.do?method=addAdManagePage";
	$("#sysuserFancybox2").attr("href",url).click();
}

// 删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的广告位！");
		return;
	}
	if(confirm("是否将此广告位删除？")){
		var data = "pageIndex=1&ids=" + ids;
		ajaxJsonTipByData("adManage.do?method=deleteAdManage",data,true);
		page(1);
	}
}

// 编辑 
function edit(){
	if("" == ids || ids == null){
		alert("请选择要编辑的广告位！");
		return;
	}
	if(checkOnly()){
		if($("#state" + ids.split(",")[0]).val() != "0"){
			alert("只能修改状态为空闲的广告位");
			return;
		}
		showUpdateJsp(ids);
	}
}

// 选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if(ids != null){
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一条数据进行操作！");
			page(1);
			return false;
		} 
		return true;
	} 
	return false;
}

// 展示字典编辑页面
function showUpdateJsp(id){
	var url = "adManage.do?method=queryAdManage&ids="+ id;
	$("#sysuserFancybox2").attr("href",url).click();
}

// 发布
function release(){
	if("" == ids || ids == null){
		alert("请选择要发布的广告位！");
		return;
	}
	if(confirm("是否发布此广告位？")){
		var data = "pageIndex=1&ids=" + ids;
		ajaxJsonTipByData("adManage.do?method=releaseAdManage",data,true);
		page(1);
	}
}

// 提交资料
function submit(){
	if("" == ids || ids == null){
		alert("请选择要提交资料的广告位！");
		return;
	}
	if(checkOnly()){
		if($("#state" + ids.split(",")[0]).val() != "2" && $("#state" + ids.split(",")[0]).val() != "3"){
			alert("只能对状态为已拍或已提交资料的广告位提交资料");
			return;
		}
		var url = "adManage.do?method=submitDatasPage&ids="+ ids;
		$("#sysuserFancybox2").attr("href",url).click();
	}
}

// 审核
function checkedAds(){
	if("" == ids || ids == null){
		alert("请选择要审核的广告位！");
		return;
	}
	if(confirm("是否审核此广告位？")){
		var data = "pageIndex=1&ids=" + ids;
		ajaxJsonTipByData("adManage.do?method=checkedAdManage",data,true);
		page(1);
	}
}

// 收款
function money(){
	if("" == ids || ids == null){
		alert("请选择要收款的广告位！");
		return;
	}
	if(confirm("是否收款此广告位？")){
		var data = "pageIndex=1&ids=" + ids;
		ajaxJsonTipByData("adManage.do?method=moneyReceiptAdManage",data,true);
		page(1);
	}
}

// 卖出
function bear(){
	if("" == ids || ids == null){
		alert("请选择要卖出的广告位！");
		return;
	}
	if(confirm("是否卖出此广告位？")){
		var data = "pageIndex=1&ids=" + ids;
		ajaxJsonTipByData("adManage.do?method=bearPositionAdManage",data,true);
		page(1);
	}
}
</script>

<div style="display:none;">
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '新增'}">
			<input type="button" value="新增" onclick="add()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '编辑'}">
			<input type="button" value="编辑" onclick="edit()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '删除'}">
			<input type="button" value="删除" onclick="del()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '发布'}">
			<input type="button" value="发布" onclick="release()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '提交资料'}">
			<input type="button" value="提交资料" onclick="submit()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '审核'}">
			<input type="button" value="审核" onclick="checkedAds()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '收款'}">
			<input type="button" value="收款" onclick="money()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '卖出'}">
			<input type="button" value="卖出" onclick="bear()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;;overflow-x:auto;width:100%;white-space:nowrap">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th width="20%">广告位名称</th>
			<th width="10%">广告位介绍链接</th>
			<th width="12%">起拍价</th>
			<th width="12%">涨幅</th>
			<th width="12%">状态</th>
			<th width="9%">得标商家名称</th>
			<th width="9%">得标金额</th>
			<th width="9%">竞价起始时间</th>
			<th width="9%">竞价结束时间</th>
			<th width="9%">生效起始日期</th>
			<th width="9%">生效结束日期</th>
			<th width="9%">生效起始时间</th>
			<th width="9%">生效结束时间</th>
			<th width="9%">图片地址</th>
			<th width="9%">链接地址</th>
			<th width="12%">更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.adsManage.bidId }" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.shopAd.adName }</td>
				<td><label title="${item.shopAd.adUrl }"><a href="${item.shopAd.adUrl }" target="_blank">查看</a></label></td>
				<td>${item.adsManage.startingPrice }</td>
				<td>${item.adsManage.increase }</td>
				<td>
				<c:choose>
				<c:when test="${item.adsManage.state eq '0'}">空闲</c:when>
				<c:when test="${item.adsManage.state eq '1'}">发布</c:when>
				<c:when test="${item.adsManage.state eq '2'}">已拍出</c:when>
				<c:when test="${item.adsManage.state eq '3'}">已提交资料</c:when>
				<c:when test="${item.adsManage.state eq '4'}">已审核</c:when>
				<c:when test="${item.adsManage.state eq '5'}">已收款</c:when>
				<c:when test="${item.adsManage.state eq '6'}">已卖出</c:when>
				</c:choose>
				<input type="hidden" id="state${item.adsManage.bidId }" value="${item.adsManage.state }" />
				</td>
				<td>${item.adsManage.winnerShooName }</td>
				<td>${item.adsManage.bidAmount }</td>
				<td><fmt:formatDate value="${item.adsManage.bidStartTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${item.adsManage.bidEndTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${item.adsManage.effectStartDate}" pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${item.adsManage.effectEndDate}" pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${item.adsManage.effectStartTime}" pattern="HH:mm:ss" /></td>
				<td><fmt:formatDate value="${item.adsManage.effectEndTime}" pattern="HH:mm:ss" /></td>
				<td><label title="${item.adsManage.imgUrl }">
				<c:if test="${!'' eq item.adsManage.imgUrl }">
					<a href="${item.adsManage.imgUrl}" target="_blank">查看</a>
				</c:if>-
				</label></td>
				<td><label title="${item.adsManage.linkUrl }">
				<c:if test="${!'' eq item.adsManage.linkUrl }">
					<a href="${item.adsManage.linkUrl }" target="_blank">查看</a>
				</c:if>-
				</label></td>
				<td><fmt:formatDate value="${item.adsManage.cTimeStamp}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="17"><strong>暂无信息</strong></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
<!--分页-->
<c:if test="${!empty pm.result }">
<div class="lasl" id="Pagination" style="border:0;">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</div>
</c:if>