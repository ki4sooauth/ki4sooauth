<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity2",670,480,true);
});

//选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if("" == ids || ids == null){
		alert("请选择一条转发器记录操作！");
		return false;
	}else{
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一条转发器记录操作！");
			page(1);
			return false;
		}
	}
	return true;
}

//删除
function del(){
	if("" == ids || ids == null){
		alert("请选择要删除的信息！");
		return;
	} else{
		var flag = true;
		var id = ids.split(",");
		$(id).each(function(index){
			if($("#isDel"+id[index]).text().trim() == "是"){
				alert("只能删除是否删除为‘否’的数据");
				flag = false;
			}
		});
		if(flag){
			if(confirm("确定删除选中信息？")){
				var url = "shopTranspc.do?method=delTranspc";
				var data = "transpcInfoIds=" + ids;
				var result = ajaxJsonVoByData(url,data);
				alert("删除转发器信息成功！");
				page(pIndex);
			}
		}
	}
}

//编辑
function updateTran(){
	if("" == ids || ids == null){
		alert("请选择要编辑的转发器！");
		return;
	} else{
		if(checkOnly()){
			if($("#isDel"+ids.split(",")[0]).text().trim() == "否"){
				alert("只能编辑是否删除为‘是’的数据");
			}else{
				var url = "shopTranspc.do?method=updateTranspcPage&transpcInfoId=" + ids;
				$("#sysuserFancybox2").attr("href",url).click();
			}
		}
	}
}
</script>

<div style="display:none;">
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:choose>
			<c:when test="${isDel eq 'N'}">
				<c:if test="${item.pId eq parentId3 and item.name eq '删除'}">
					<input type="button" value="删除" onclick="del()" />
				</c:if>
			</c:when>
			<c:when test="${isDel eq 'Y'}">
				<c:if test="${item.pId eq parentId3 and item.name eq '编辑'}">
					<input type="button" value="编辑" onclick="updateTran()" />
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${item.pId eq parentId3 and item.name eq '编辑'}">
					<input type="button" value="编辑" onclick="updateTran()" />
				</c:if>
				<c:if test="${item.pId eq parentId3 and item.name eq '删除'}">
					<input type="button" value="删除" onclick="del()" />
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
<div id = "list_box_search" class="list_box_search"  style="overflow-y:scroll;overflow-x:none;">
	<table width="100%"  cellspacing="0" cellpadding="0"class="searchForm" border="1">
		<tr >
			<th><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"/>序号</th>
			<th>设备MAC</th>
			<th>设备序列号</th>
			<th>设备型号</th>
			<th>设备状态</th>
			<th>操作系统</th>
			<th>解析格式</th>
			<th>功能</th>
			<th>安装日期</th>
			<th>是否删除</th>
			<th>创建时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input type="checkbox" name="single" value="${item.deviceTransponderId }"/>&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.deviceMac }</td>
				<td>${item.deviceSn }</td>
				<td>
				<c:choose>
					<c:when test="${item.deviceType == '0'}">普通型</c:when>
					<c:when test="${item.deviceType == '1'}">精简型</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</td>
				<td>
				<c:choose>
					<c:when test="${item.status == '0'}">在用</c:when>
					<c:when test="${item.status == '1'}">停用</c:when>
					<c:when test="${item.status == '2'}">损坏</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</td>
				<td>
					<c:choose>
					<c:when test="${item.systemType == '0'}">DOS</c:when>
					<c:when test="${item.systemType == '1'}">Windows</c:when>
					<c:when test="${item.systemType == '2'}">Linux</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
				</td>
				<td>
					<c:forEach items="${bill_parse }" var="bill">
						<c:if test="${item.billParse == bill.englishName }">${bill.chineseName }</c:if>
		    		</c:forEach>
				</td>
				<td>
					<c:forEach items="${st_service }" var="st">
						<c:if test="${item.stService == st.englishName }">${st.chineseName }</c:if>
		    		</c:forEach>
				</td>
				<td><fmt:formatDate value="${item.installDate }" type="both" pattern="yyyy-MM-dd"/></td>
				<td id="isDel${item.deviceTransponderId}">
				    <c:choose>
						<c:when test="${item.isDel eq 'Y'}">是</c:when>
						<c:when test="${item.isDel eq 'N'}">否</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
			    </td>							
				<td><fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="12"><strong>暂无信息</strong></td>
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