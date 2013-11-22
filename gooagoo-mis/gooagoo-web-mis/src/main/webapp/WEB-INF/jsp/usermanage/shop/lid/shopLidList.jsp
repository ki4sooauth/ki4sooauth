<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
$(document).ready(function(){
	initFancyBox("fancybox_activity1",610,500,true);
	initFancyBox("fancybox_activity2",610,320,true);
});
</script>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId3 and item.name eq '删除'}">
			<input type="button" value="删除" onclick="del()" />
		</c:if>
	</c:forEach>
</div>

<div id = "list_box_search" class="list_box_search"  style="overflow-y:scroll;overflow-x:none;">
	<table width="100%"  cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr>
			<th><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th>LID基本信息</th>
			<th>商家名称</th>
			<th>是否删除</th>
			<th>创建时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.lidBase }"/>&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.lidBase }</td>
				<td>${pmShop.shopName}</td>
				<td>
					<c:choose>
						<c:when test="${item.isDel == 'Y'}">是</c:when>
						<c:when test="${item.isDel == 'N'}">否</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="5"><strong>暂无信息</strong></td>
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
<script type="text/javascript">
	//删除
	function del(){
		if("" == ids || ids == null){
			alert("请选择要删除的用户！");
			return;
		} else{
			if(confirm("确定删除选中信息？")){
				var url = "shopLid.do?method=delLid";
				var shopId = $("#shopId").val();
				var shopEntityId = "${shopEntityId}";
				var data = "&lids=" + ids+"&shopEntityId="+shopEntityId+"&shopId="+shopId;
				alert(ajaxJsonVoByData(url,data));
				page(pIndex);
			}
		}
	}
		
	//选择一条数据进行操作 
	function checkOnly(){
		var arrayMemberId = null;
		if("" == ids || ids == null){
			alert("请选择一条LID记录操作！");
			return false;
		}else{
			arrayMemberId = ids.split(",");
			if((arrayMemberId.length - 1) > 1){
				alert("只能选择一条LID记录操作！");
				page(1);
				return false;
			}
		}
		return true;
	}
</script>