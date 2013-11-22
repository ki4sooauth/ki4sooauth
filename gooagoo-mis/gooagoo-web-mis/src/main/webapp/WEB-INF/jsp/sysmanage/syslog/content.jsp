<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';

$(document).ready(function(){
	initFancyBox("fancybox_activity1",870,480,true);
});

//查看详情
function queryMessageInfo(id,type){
	var url = "sysLog.do?method=searchLogInfo&uuid=" + id + "&logType=" + type;
	$("#sysuserFancybox1").attr("href",url).click();
}
</script>
<div style="display:none;">
	<a href="#" id="sysuserFancybox1" class="fancybox_activity1" ></a>
</div>
<div class="div_but">
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th>序号</th>
			<th>消息流水号</th>
			<th>父流水号</th>
			<th>消息来源</th>
			<th>接口编码</th>
			<th>行为类型</th>
			<th>到达服务器</th>
			<th>接收时间</th>
			<th>发送时间</th>
			<th>备注</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach items="${pm.result }" var="item" varStatus="im">
			<c:forEach items="${item.mmessageLog }" var="message_log" varStatus="mes">
			<tr>
				<c:if test="${mes.count == 1 }">
					<td rowspan="${fn:length(item.mmessageLog) }">${im.count + ((page_cur-1) * 10)}</td>
					<td rowspan="${fn:length(item.mmessageLog) }">
					<c:choose>
					<c:when test="${!empty item.puuid }">${item.uuid }</c:when>
					<c:otherwise><a href="javascript:void(0);" onclick="queryMessageInfo('${item.uuid }','${message_log.logType }');">${item.uuid }</a></c:otherwise>
					</c:choose>
					</td>
					<td rowspan="${fn:length(item.mmessageLog) }">${item.puuid }</td>
				</c:if>
				<td>
					<c:forEach items="${behave_source }" var="source">
						<c:if test="${message_log.source == source.englishName }">${source.chineseName }</c:if>
					</c:forEach>
				</td>
				<td>${message_log.behaveCode }</td>
				<td>
					<c:forEach items="${behave_type }" var="type">
						<c:if test="${type.englishName eq message_log.behaveType}">${type.chineseName }</c:if>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${behave_source }" var="server">
						<c:if test="${message_log.server == server.englishName }">${server.chineseName }</c:if>
					</c:forEach>
				</td>
				<td><fmt:formatDate value="${message_log.recetime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${message_log.sendtime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><span class="lengthHide" title='${message_log.exception}'>${message_log.exception}</span></td>
			</tr>
			</c:forEach>
		</c:forEach>
		</c:when>
		<c:otherwise>
			<tr style="height: 40px;">
				<td colspan="10"><strong>暂无信息</strong></td>
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