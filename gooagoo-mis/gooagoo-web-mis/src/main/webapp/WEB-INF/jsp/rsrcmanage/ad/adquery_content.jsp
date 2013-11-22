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
	var url = "shopAd.do?method=addAdQueryPage";
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
		ajaxJsonTipByData("shopAd.do?method=deleteAdQuery",data,true);
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
	var url = "shopAd.do?method=queryAdQueryPage&ids="+ id;
	$("#sysuserFancybox2").attr("href",url).click();
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
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"  />序号</th>
			<th width="9%">广告位编码</th>
			<th width="14%">广告位名称</th>
			<th width="14%">广告位类型</th>
			<th width="18%">广告位描述</th>
			<th width="20%">广告位介绍URL</th>
			<th width="10%">更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.adCode }" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.adCode }</td>
				<td>${item.adName }</td>
				<td>
				<c:forEach items="${ad_type }" var="adtype">
					<c:if test="${adtype.englishName eq item.adType }">${adtype.chineseName }</c:if>
				</c:forEach>
				</td>
				<td>${item.adDescription }</td>
				<td><span title="${item.adUrl }"><a href="${item.adUrl }" target="_blank">查看</a></span></td>
				<td><fmt:formatDate value="${item.cTimeStamp}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="7"><strong>暂无信息</strong></td>
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