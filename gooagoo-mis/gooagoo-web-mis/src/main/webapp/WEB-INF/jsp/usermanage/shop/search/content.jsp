<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
$(document).ready(function(){
	initFancyBox("fancybox_allotLid",610,320,true);
	initFancyBox("fancybox_showLidList",610,320,true);
	initFancyBox("fancybox_addTransc",800,420,true);
	initFancyBox("fancybox_showTranscList",950,450,true);
	initFancyBox("fancybox_addAssistant",800,420,true);
	initFancyBox("fancybox_showAssistantList",800,420,true);
	initFancyBox("fancybox_addWifisensor",800,420,true);
	initFancyBox("fancybox_showWifisensorList",800,420,true);
	initFancyBox("fancybox_tool",800,450,true);
	initFancyBox("fancybox_toolEdit",375,200,true);
	initFancyBox("fancybox_audit",590,300,true);
	initFancyBox("fancybox_nominateShop",500,420,true);;
});
</script>
<div style="display:none;">
	<a href="#" id="allotLid" class="fancybox_allotLid" ></a>
	<a href="#" id="showLidList" class="fancybox_showLidList" ></a>
	<a href="#" id="toolFancybox" class="fancybox_tool" ></a>
	<a href="#" id="editToolFancybox" class="fancybox_toolEdit" ></a>
	<a href="#" id="auditFancybox" class="fancybox_audit" ></a>
	<a href="#" id="addTransc" class="fancybox_addTransc" ></a>
	<a href="#" id="showTranscList" class="fancybox_showTranscList" ></a>
	<a href="#" id="addAssistant" class="fancybox_addAssistant" ></a>
	<a href="#" id="showAssistantList" class="fancybox_showAssistantList" ></a>
	<a href="#" id="addWifisensor" class="fancybox_addWifisensor" ></a>
	<a href="#" id="showWifisensorList" class="fancybox_showWifisensorList" ></a>
	<a href="#" id="nominateShop" class="fancybox_nominateShop" ></a>
</div>
<div class="div_but">
	<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
		<c:if test="${item.pId eq parentId2 and item.name eq '商家审核'}">
			<input type="button" value="商家审核" onclick="audit()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '锁定'}">
			<input type="button" value="锁定" onclick="lock()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '分配Lid'}">
			<input type="button" value="分配Lid" onclick="allotLid()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '查询Lid'}">
			<input type="button" value="查询Lid" onclick="showLids()" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '服务工具管理'}">
			<input type="button" value="服务工具管理" onclick="queryShopToolList()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '新增转发器'}">
			<input type="button" value="新增转发器" onclick="addShopTransc()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '查询转发器'}">
			<input type="button" value="查询转发器" onclick="showShopTranscs()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '新增店员助手'}">
			<input type="button" value="新增店员助手" onclick="addShopAssistant()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '查询店员助手'}">
			<input type="button" value="查询店员助手" onclick="showShopAssistant()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '新增wifisensor'}">
			<input type="button" value="新增wifisensor" onclick="addShopWifisensor()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '查询wifisensor'}">
			<input type="button" value="查询wifisensor" onclick="showShopWifisensor()" style="width: 85px;" />
		</c:if>
		<c:if test="${item.pId eq parentId2 and item.name eq '推荐商家'}">
			<input type="button" value="推荐商家" onclick="nominateShop()" style="width: 85px;" />
		</c:if>
	</c:forEach>
</div>
<div class="list_box_search">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="searchForm" border="1">
		<tr bgcolor="red">
			<th><input type="checkbox" name="Seleted_all" style="margin-right: 3px;"  />勾选</th>
			<th>商家名称</th>
			<th>电子邮箱</th>
			<th>商家状态</th>
			<th>是否连锁</th>
			<th>部署模式</th>
			<th>创建时间</th>
		</tr>
		<c:choose>
		<c:when test="${!empty pm.result}">
		<c:forEach var="item" items="${pm.result }" varStatus="im" >
			<tr>
				<td><input id="cb${im.count}" type="checkbox" name="single" value="${item.shopId}" sShopStatus="${item.shopStatus}"/>&nbsp;${im.count + ((page_cur-1) * 10)}</td>
				<td id="shopName${im.count }">${item.shopName }</td>
				<td>${item.email }</td>
				<td>
					<c:choose>
						<c:when test="${item.shopStatus eq 'L'}">锁定</c:when>
						<c:when test="${item.shopStatus eq 'P'}">待营业</c:when>
						<c:when test="${item.shopStatus eq 'U'}">正常营业</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.isChain eq 'Y'}">连锁</c:when>
						<c:when test="${item.isChain eq 'N'}">非连锁</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${item.serviceStyle eq 'A'}">gooagoo代理</c:when>
						<c:when test="${item.serviceStyle eq 'S'}">商家独享</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
				<td><fmt:formatDate value="${item.createTime}" type="both" pattern="yyyy-MM-dd" /></td>
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
<script type="text/javascript">
//选择一条数据进行操作 
function checkOnly(){
	var arrayMemberId = null;
	if("" == ids || ids == null){
		alert("请选择一个商家！");
		return false;
	}else{
		arrayMemberId = ids.split(",");
		if((arrayMemberId.length - 1) > 1){
			alert("只能选择一个商家进行操作！");
			page(1);
			return false;
		}
	}
	return true;
}
//审核商家 
function audit(){
	if(checkOnly()){
		if($("input[name='single']:checkbox:checked").attr("sShopStatus") != 'L'){
			alert("非[商家状态:锁定]无法进行此操作");
			return false;	
		}
		
		var url = "shop.do?method=examineShop&id="+ids;
		$("#auditFancybox").attr("href",url).click();
	}
}
//锁定商家
function lock(){
	if(checkOnly()){
		if($("input[name='single']:checkbox:checked").attr("sShopStatus") != 'U'){
			alert("非[商家状态:正常营业]无法进行此操作");
			return false;	
		}
		if(confirm("确定锁定选中商家？")){
			var url = "shop.do?method=lockShop";
			var data = "&id=" + ids;
			ajaxJsonTipByData(url,data,true);
			page(pIndex);
		}
	}
}
//显示商家LID
function showLids(){
	if(checkOnly()){
		var url = "shopLid.do?method=showLidList&shopId="+ids.substr(0,ids.length-1);
		$("#showLidList").attr("href",url).click();
	} 
}
//分配LID
function allotLid(){
	if(checkOnly()){
		var url = "shopLid.do?method=allotLid&shopId="+ids.substr(0,ids.length-1);
		$("#allotLid").attr("href",url).click();
	}  
}
//查询服务工具列表
function queryShopToolList(){
	if(checkOnly()){
		if($("input[name='single']:checkbox:checked").attr("sShopStatus") == 'U'){
			searchShopToolList(ids.substr(0,ids.length-1));
		}else{
			alert("商家非正常营业状态不能进行此操作");
		}
	}
}
function searchShopToolList(id){
	var url = "shoptool.do?method=searchShopToolListIndex&shopId="+id;
	$("#toolFancybox").attr("href",url).click();
};
function formToolCheckOpen(id,shopId){
	var url = "shoptool.do?method=toolCheckForm&id="+id+"&shopId="+shopId;
	$("#editToolFancybox").attr("href",url).click();
}
//显示转发器列表
function showShopTranscs(){
	if(checkOnly()){
		var url = "shopTranspc.do?method=showTranspcList&shopId="+ids.substr(0,ids.length-1);
		$("#showTranscList").attr("href",url).click();
	} 
}
//添加转发器设备
function addShopTransc(){
	if(checkOnly()){
		var url = "shopTranspc.do?method=showSetTranspc&shopId="+ids.substr(0,ids.length-1);
		$("#addTransc").attr("href",url).click();
	}  
}
//显示店员助理列表
function showShopAssistant(){
	if(checkOnly()){
		var url = "shopAssistant.do?method=showAssistantpcList&shopId="+ids.substr(0,ids.length-1);
		$("#showAssistantList").attr("href",url).click();
	} 
}
//添加商家店员助理设备
function addShopAssistant(){
	if(checkOnly()){
		var url = "shopAssistant.do?method=showSetAssistant&shopId="+ids.substr(0,ids.length-1);
		$("#addAssistant").attr("href",url).click();
	}  	 
}


//显示Wifisensor列表
function showShopWifisensor(){
	if(checkOnly()){
		var url = "shopWifisensor.do?method=showWifisensorpcList&shopId="+ids.substr(0,ids.length-1);
		$("#showWifisensorList").attr("href",url).click();
	} 
}
//添加Wifisensor
function addShopWifisensor(){
	if(checkOnly()){
		var url = "shopWifisensor.do?method=showSetWifisensor&shopId="+ids.substr(0,ids.length-1);
		$("#addWifisensor").attr("href",url).click();
	}  	 
}
//推荐商家
function nominateShop(){
	if(checkOnly()){
		var chid = $("input[name='single']:checkbox:checked").attr("id");
		/* if($("input[name='single']:checkbox:checked").attr("sShopStatus") != 'U'){
			alert("非正常营业商家不能进行推荐操作");
			return false;	
		} */
		var num = chid.substr(chid.length-1,chid.length);
		var shopName = $("#shopName"+num).text();
		var shopLogo = $("#shopLogo"+num).attr("src");
		var data = "&shopId="+ids.substr(0,ids.length-1)+"&shopName="+shopName+"&shopLogo="+shopLogo;
		data = encodeURI(encodeURI(data));
		var url = "shopNominate.do?method=shopNominate"+data;
		$("#nominateShop").attr("href",url).click();
	}  	 
}
</script>