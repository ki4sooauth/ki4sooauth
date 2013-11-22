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
	var url = "ruleConfig.do?method=addRuleConfigPage";
	$("#sysuserFancybox2").attr("href",url).click();
}

// 删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的规则配置！");
		return;
	}
	if(confirm("是否将此规则配置删除？")){
		var data = "pageIndex=1&ids=" + ids;
		ajaxJsonTipByData("ruleConfig.do?method=deleteRuleConfig",data,true);
		page(1);
	}
}

// 编辑 
function edit(){
	if("" == ids || ids == null){
		alert("请选择要编辑的规则配置！");
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
	var url = "ruleConfig.do?method=queryConfig&ids="+ id;
	$("#sysuserFancybox2").attr("href",url).click();
}
</script>

<div style="display:none;">
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '编辑'}">
			<input type="button" value="编辑" onclick="edit()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '删除'}">
			<input type="button" value="删除" onclick="del()" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search" style="padding:0 0 0 1px;overflow-x:auto;width:100%;white-space:nowrap">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th width="5%"><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"  />序号</th>
			<th width="20%">行为类型</th>
			<th width="20%">显示日期段</th>
			<th width="20%">显示星期段</th>
			<th width="20%">显示时间段</th>
			<th width="20%">显示会员等级</th>
			<th width="20%">显示行为来源</th>
			<th width="20%">显示当天次数</th>
			<th width="20%">显示累计次数</th>
			<th width="20%">显示品类</th>
			<th width="20%">显示品牌</th>
			<th width="20%">显示商品</th>
			<th width="20%">显示活动</th>
			<th width="20%">显示优惠凭证</th>
			<th width="20%">显示事件</th>
			<th width="20%">显示服务工具</th>
			<th width="20%">显示区域</th>
			<th width="20%">显示时长</th>
			<th width="20%">显示消费金额</th>
			<th width="20%">显示虚拟商家店面</th>
			<th width="12%">创建时间</th>
			<th width="12%">更新时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.id}" />&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>
				<c:forEach items="${behave_type }" var="rulet">
					<c:if test="${rulet.englishName eq item.behaveType }">${rulet.chineseName }</c:if>
				</c:forEach>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowDateScope eq 'Y' }">是</c:when>
				<c:when test="${item.isShowDateScope eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowWeekScope eq 'Y' }">是</c:when>
				<c:when test="${item.isShowWeekScope eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowTimeScope eq 'Y' }">是</c:when>
				<c:when test="${item.isShowTimeScope eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowVipGrade eq 'Y' }">是</c:when>
				<c:when test="${item.isShowVipGrade eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowActionSource eq 'Y' }">是</c:when>
				<c:when test="${item.isShowActionSource eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowTime eq 'Y' }">是</c:when>
				<c:when test="${item.isShowTime eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowTotalTime eq 'Y' }">是</c:when>
				<c:when test="${item.isShowTotalTime eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowMarketingGoodsCategory eq 'Y' }">是</c:when>
				<c:when test="${item.isShowMarketingGoodsCategory eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowMarketingGoodsBrand eq 'Y' }">是</c:when>
				<c:when test="${item.isShowMarketingGoodsBrand eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowMarketingGoods eq 'Y' }">是</c:when>
				<c:when test="${item.isShowMarketingGoods eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowMarketingAction eq 'Y' }">是</c:when>
				<c:when test="${item.isShowMarketingAction eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowMarketingCoupon eq 'Y' }">是</c:when>
				<c:when test="${item.isShowMarketingCoupon eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowMarketingEvent eq 'Y' }">是</c:when>
				<c:when test="${item.isShowMarketingEvent eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowServerTools eq 'Y' }">是</c:when>
				<c:when test="${item.isShowServerTools eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowPosition eq 'Y' }">是</c:when>
				<c:when test="${item.isShowPosition eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowDuration eq 'Y' }">是</c:when>
				<c:when test="${item.isShowDuration eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowConsumeMoney eq 'Y' }">是</c:when>
				<c:when test="${item.isShowConsumeMoney eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td>
				<c:choose>
				<c:when test="${item.isShowVb eq 'Y' }">是</c:when>
				<c:when test="${item.isShowVb eq 'N' }">否</c:when>
				</c:choose>
				</td>
				<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd" /></td>
				<td><fmt:formatDate value="${item.cTimeStamp}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="23"><strong>暂无信息</strong></td>
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