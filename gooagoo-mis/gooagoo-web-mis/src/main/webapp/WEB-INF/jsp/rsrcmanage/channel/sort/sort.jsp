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
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/mis/js/channelTree.js"></script>
<title>渠道排序</title>
<script>
$(function(){
	var zNodes = searchChannelList();
    $.fn.zTree.init($("#channelTree"), setting, zNodes);  
    $("#selectAll").bind("click", selectAll);
});

function searchChannelList(){
	var data = "&channelCode="+"${channelCode}";
	var url = "channel.do?method=searchchannelList";
	var result = ajaxJsonMessageByData(url,data);
	return result;
}

function selectAll() {  
    var zTree = $.fn.zTree.getZTreeObj("channelTree");  
    zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");  
};

</script>
</head>
<body>
	<!--内容-右边栏-->
	<div class="content_right">
		<div>
			<div class="big_box" id="resultlist">
				<div class="publish_n">
					<div class="popMsg">
						<h2>渠道排序</h2>
						<br/>
						<br/>
		            </div>
					<div class="publish_n_top_scroll">
						<!--内容 -->
						<ul id="channelTree" class="ztree"></ul>
					</div>
					<div class="publish_n_buttom" >
						<input type="button" value="确定" onclick="saveNewChannelList();" style = " display: inline;"/>
						<input type="button" value="取消" onclick="closefbox();" style = " display: inline;"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<script type="text/javascript">
	//保存重新排序的渠道
	function saveNewChannelList(){
		var nodeIds = "";
		var nodeNames = "";
		var treeObj = $.fn.zTree.getZTreeObj("channelTree");
		var nodeDatas = treeObj.transformToArray(treeObj.getNodes());
		   for(var i = 0; i < nodeDatas.length; i++){
			   /* var jsonObj = nodeDatas[i]; //获得jsonObj对象
			   alert(jsonObj.id);
			   alert(jsonObj.name);  */
			   nodeIds += nodeDatas[i].id + ",";
			   nodeNames += nodeDatas[i].name + ",";
		   }
		var data = "&nodeIds="+nodeIds+"&nodeNames="+nodeNames;
		var url = "channel.do?method=sortChannel";
		var result = ajaxJsonVoByData(url,data);
	    alert(result);
		closefbox();
	}
	//关闭窗口
	function closefbox(){
		(document.parentWindow || document.defaultView).parent.closeFancyBox();
		(document.parentWindow || document.defaultView).parent.refresh();
	}
	</script>
</body>
</html>