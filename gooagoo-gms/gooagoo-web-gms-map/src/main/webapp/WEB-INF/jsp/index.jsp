<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1304");
%>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet"
	type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ shopVo.wordNames['gmsi024']}</title>
</head>
<script>
function delMap(mapId) {
	var isdel = window.confirm("确定要删除该地图吗？");
	if(!isdel){
		return;
	}
	var data = "&mapId=" + mapId ;
    $.ajax({
    	async:false ,
    	type:"POST",
    	url:"${basePath}/map.do?method=delMap",
    	data:data,
    	success:function(ret) {
    		if(ret) {
    			alert("删除成功") ;
    			document.location.reload() ;
    		}
    		else alert("删除失败") ;
    	}
    });
}
</script>
<body>
    <!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	
	
	<!--内容-->
	<div class="container">
		<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle_add">
				<check:hasAuthority authorityID="130401">
				<a href="${basePath }/map.do?method=addMap">${ shopVo.wordNames['gmsi002']}</a>
				</check:hasAuthority>
				<span>${ shopVo.wordNames['gmsi001']}</span>
				</div>
			<table class="goodsList_table" cellpadding="0" cellspacing="1" border="0">
				<tr>
					<th width="210">${ shopVo.wordNames['gmsi003']}</th>
					<th width="102">${ shopVo.wordNames['gmsi004']}</th>
					<th width="142">${ shopVo.wordNames['gmsi005']}</th>
					<th width="94">备注</th>
					<th width="99">${ shopVo.wordNames['gmsi006']}</th>
					<th width="94">${ shopVo.wordNames['gmsi007']}</th>
				</tr>
				<check:hasAuthority authorityID="130402">
				<c:forEach items="${maps }" var="item">
					<tr>
						<td><span>${item.mapName }</span></td>
						<td> <c:if test="${fn:length(item.urlHtml) > 0}">有</c:if>
						     <c:if test="${fn:length(item.urlHtml) == 0}">无</c:if>
						</td>
						<td><c:if test="${fn:length(item.urlSvg) > 0}">有</c:if>
						<c:if test="${fn:length(item.urlSvg) == 0}">无</c:if>
						</td>
						<td>${item.note }</td>
						<td>
						<c:if test="${fn:length(item.urlHtml) > 0 }">
						<check:hasAuthority authorityID="13040204">
						<a target="blank" href="${item.urlHtml }">发布版</a>
						</check:hasAuthority>
						<check:hasAuthority authorityID="13040203">
						<a target="blank" href="${basePath }/map.do?method=test&mapId=${item.mapId }">内测版</a>
						</check:hasAuthority>
						</c:if>
						</td>
						<td>
						<check:hasAuthority authorityID="13040201">
						<a title="修改地图" href="${basePath }/map.do?method=updateMap&shopEntityId=${item.shopEntityId}&mapId=${item.mapId}" class="handle pencil"></a>
						</check:hasAuthority>
						<check:hasAuthority authorityID="13040202">
						<a title="删除地图" href="javascript:void(0)"  onclick="delMap('${item.mapId}');" class="handle del"></a>
						</check:hasAuthority>
						</td>
					</tr>
				</c:forEach>
				</check:hasAuthority>
			</table>	
			</div>
		</div>
	</div>
</body>
</html>