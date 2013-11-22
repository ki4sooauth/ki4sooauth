<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${imgPath}/common/ztree/css/window/treeWindow.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/ztree-common.js"></script>
<style type="text/css">
.publish_n_top_scroll{height:430px;}
</style>
<title>查询渠道</title>
<script type="text/javascript">
$(function(){
	initFancyBox("fancybox_addChannel",600,360,true);
	initFancyBox("fancybox_editChannel",600,360,true);
	initFancyBox("fancybox_sortChannel",600,360,true);
});
//查询渠道
function searchChannelList(){
	var selectedvalue = $("input[name='topChannel']:radio:checked").val(); 
	if('' == selectedvalue || selectedvalue == null){
	   	selectedvalue = 1;
	}
	var data = $("#searchForm").serialize()+"&channelCode="+selectedvalue;
	var url = "channel.do?method=searchchannelList";
	var result = ajaxJsonMessageByData(url,data);
	initRadioZtree("positionTree",true,true,result,"all");
}
//刷新
function refresh(){
	searchChannelList();
}
//添加渠道
function showAddChannel(){
	var node = getCheckedNodes("positionTree")[0];
	if(undefined == node || ''==node || node == null){
		alert("请选中需要添加子节点的父节点");	
	}else{
		var channelCode = node.id;
	    var data = "&channelCode=" + channelCode;
		var url = "channel.do?method=showAddChannel"+data;
		$("#addChannel").attr("href",url).click();
	}
	
	
}
//删除渠道
function delChannel(){
	var node = getCheckedNodes("positionTree")[0];
	if(undefined == node || '' == node || node == null){
		alert("请选中需要删除的节点");	
	}else{
		var channelCode = node.id;
	    var data = "&channelCode=" + channelCode;
		var url = "channel.do?method=delChannel"+data;
		var result = ajaxJsonVoByData(url,data);
	    alert(result);
		searchChannelList();
	}
	
	
}

//编辑渠道
function showEditChannel(){
	var node = getCheckedNodes("positionTree")[0];
	if(undefined==node||''==node || node==null){
		alert("请选中需要编辑的节点");	
	}else{
		var channelCode = node.id;
		var channelName = node.name;
	    var data = "&channelCode=" + channelCode+"&channelName=" + channelName;
		var url = "channel.do?method=showEditChannel"+data;
		$("#editChannel").attr("href",url).click();
	}
	
	
}

//渠道排序
function sortChannel(){
	var node = getCheckedNodes("positionTree")[0];
	if(undefined==node||''==node || node==null){
		alert("请选中需要排序的父节点");	
	}else{
		var channelCode = node.id;
		if(node.isParent){
			var data = "&channelCode=" + channelCode;
			var url = "channel.do?method=showSortChannel"+data;
			$("#sortChannel").attr("href",url).click();
		}else{
			alert("请选中需要排序的父节点。");
		}
	}
	
}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="addChannel" class="fancybox_addChannel" ></a>
		<a href="#" id="editChannel" class="fancybox_editChannel" ></a>
		<a href="#" id="sortChannel" class="fancybox_sortChannel" ></a>
	</div>
	<!--内容-右边栏-->
	<div class="content_right">
		<div class="div_top">
			<form id="searchForm" name="searchForm">
				<br/>
				<p>
					<label class="lab3">
						<span>渠道名称：</span>
						<input type="text" id="channelName" name="channelName" />
						<input type="text" style="display: none;"  />
					</label>
<!--  				<label class="lab1">
						<span>是否删除：</span>
						<select id="isDel" name="isDel">
							<option value="">--请选择--</option>
							<option value="N" selected="selected">未删除</option>
							<option value="Y">已删除</option>
						</select>
					</label>
-->					
				</p>
				<p class="p1">
					<input type="reset" value="重置" />
					<input type="button" value="查询" onclick="searchChannelList()" />
				</p>
				<p style="margin-left: 30px;">
				    <c:forEach var="item" items="${mChannelList }" varStatus="im" >
				    	<input type="radio" name="topChannel" value="${item.channelCode }" <c:if test="${im.count eq 1}" >checked="checked"</c:if> />
				    	<span>${item.channelName}</span>
				    </c:forEach>
				</p>
			</form>
		</div>
		<div>
			<div class="big_box" id="resultlist">
				<div class="publish_n">
					<div class="publish_n_top_scroll">
						<!--内容 -->
						<ul id="positionTree" class="ztree"></ul>
					</div>
					<div class="publish_n_buttom" >
						<c:forEach var="item" items="${mis_login_auths}" varStatus="im">
							<c:if test="${item.pId eq parentId2 and item.name eq '新增'}">
								<input type="button" value="新增" onclick="showAddChannel()" style = " display: inline;"/>
							</c:if>
							<c:if test="${item.pId eq parentId2 and item.name eq '编辑'}">
								<input type="button" value="编辑" onclick="showEditChannel()" style = " display: inline;" />
							</c:if>
							<!-- 
							<c:if test="${item.pId eq parentId2 and item.name eq '删除'}">
								<input type="button" value="删除" onclick="delChannel()" style = " display: inline;"/>
							</c:if>
							 -->
							<c:if test="${item.pId eq parentId2 and item.name eq '排序'}">
								<input type="button" value="排序" onclick="sortChannel()" style = " display: inline;"/>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</body>
</html>