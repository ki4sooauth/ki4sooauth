<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
//打开商家接口编辑页
function formEdit(id){
	if(isEmpty(id)){
		return false;
	}
	(document.parentWindow || document.defaultView).parent.formEditOpen(id);
}
</script>

<div class="div_but" style="text-align: center;">
	商家接口列表
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th>序号</th>
			<th>接口名称</th>
			<th>接口编码</th>
			<th>接口地址</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td>${im.count + ((page_cur-1) * 10)}</td>
				<td>${item.iName }</td>
				<td>${item.iCode }</td>
				<td>${item.iUrl }</td>
				<td><fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>
					<c:forEach var="item1" items="${mis_login_auths}" varStatus="im1">
						<c:if test="${item1.pId eq parentId3 and item1.name eq '编辑'}">
							<input type="button" value="编辑" onclick="formEdit('${item.id }')" />
						</c:if>
						<!-- 
						<c:if test="${item1.pId eq parentId3 and item1.name eq '删除'}">
							<input type="button" value="删除" onclick="deleteData('${item.id }')" />
						</c:if>
						 -->
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="6"><strong>暂无信息</strong></td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
</div>
<!--分页-->
<c:if test="${!empty pm.result }">
<div class="lasl" style="border:0;">
	<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
</div>
</c:if>