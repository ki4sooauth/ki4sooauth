<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript">
	//删除区域地图信息
	function delAreaMap(mapId){
		if(confirm("确定删除区域地图信息？")){
			//如果当前页只剩一条记录，删除操作时当前页改为上一页页码
// 			pIndex=curSize==1 && pIndex!=1? --pIndex:pIndex;
			var url = basePath + "map.do?method=delete";
			var data = "&mapId=" + mapId;
			ajaxJsonTipByData(url,data,true);
			page(pIndex);
		}
	}
</script>
<table class="goodsList_table" cellpadding="0" cellspacing="1" border="0">
	<tr>
		<th width="210">${ shopVo.wordNames['gmsi003']}</th>
		<th width="102">${ shopVo.wordNames['gmsi004']}</th>
		<th width="142">${ shopVo.wordNames['gmsi005']}</th>
		<th width="94">备注</th>
		<th width="99">${ shopVo.wordNames['gmsi006']}</th>
		<th width="94">${ shopVo.wordNames['gmsi007']}</th>
	</tr>
	<c:if test="${not empty pm.result }">
		<check:hasAuthority authorityID="130402">
			<c:forEach items="${pm.result }" var="item">
				<tr>
					<td><span>${item.mapName }</span></td>
					<td>
						<c:if test="${fn:length(item.urlHtml) > 0}">有</c:if>
						<c:if test="${fn:length(item.urlHtml) == 0}">无</c:if>
					</td>
					<td>
						<c:if test="${fn:length(item.urlSvg) > 0}">有</c:if>
						<c:if test="${fn:length(item.urlSvg) == 0}">无</c:if>
					</td>
					<td>${item.note }</td>
					<td>
						<c:if test="${fn:length(item.urlHtml) > 0 }">
							<check:hasAuthority authorityID="13040204">
								<a target="blank" href="${item.urlHtml }">发布版</a>
							</check:hasAuthority>
						</c:if>
						<check:hasAuthority authorityID="13040203">
							<a target="blank" href="${basePath }map.do?method=test&mapId=${item.mapId }">内测版</a>
						</check:hasAuthority>
					</td>
					<td>
						<check:hasAuthority authorityID="13040201">
							<a style="vertical-align:middle;" title="修改地图" href="javascript:void(0);" onclick="formAreaMap('${item.mapId}');" class="handle pencil">
							</a><a title="编辑网格信息" target="_Blank" href="${basePath }grid.do?method=index&mapId=${item.mapId }" style="background: url('${imgPath }/gms/gmap/images/grid.png') no-repeat;height: 19px;width: 22px;display:inline-block;vertical-align: middle;"></a>
						</check:hasAuthority>
						<check:hasAuthority authorityID="13040202">
							<a style="vertical-align:middle;" title="删除地图" href="javascript:void(0);" onclick="delAreaMap('${item.mapId}');" class="handle del"></a>
						</check:hasAuthority>
					</td>
				</tr>
			</c:forEach>
		</check:hasAuthority>
		<tr>
			<td colspan="6">
				<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
			</td>
		</tr>
	</c:if>
	<c:if test="${empty pm.result}">
		<tr><td colspan="6">暂无信息！</td></tr>
	</c:if>
</table>	
