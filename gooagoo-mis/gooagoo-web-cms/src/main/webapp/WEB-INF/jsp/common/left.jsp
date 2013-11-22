<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<link rel="stylesheet" href="${imgPath}/cms/css/demo.css" type="text/css">
<link rel="stylesheet" href="${imgPath}/cms/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${imgPath}/cms/js/jquery.ztree.core-3.0.js"></script>
<script type="text/javascript" src="${imgPath}/cms/js/jquery.ztree.excheck-3.0.js"></script>
<script type="text/javascript" src="${imgPath}/cms/js/jquery.ztree.exedit-3.0.js"></script>
<script type="text/javascript"> 
	$(document).ready(function(){
		$(".rootSpan i").click(function(){
			$(this).toggleClass("curr").parent().next("ul").stop().slideToggle();
		})
		initTree();
	})
	var zNodes;        	
	var setting = {
		edit: {
			drag: {
					prev: true,
					inner: false,
					next: true
				},
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeDrop: beforeDrop
		}
	};
	function initTree(){
		id = "${initCode}";
		
		$.ajax({
			type  : "post",
			async : false,
			cache : false,
			dataType: "json",
			url   : "${basePath}cmsContent.do?method=list&cmsContentId=${cmsContent.cmsContentId}&cmsContentType=C",
			success : function(result) {
				zNodes = result;
			}
		});
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		//选择项的样式更改
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		if(id!=null && id!=undefined && id!=""){
			var nodeList = zTree.getNodesByParam("id", id);
			zTree.selectNode(nodeList[0],false);
			eval(nodeList[0].click);
		}else{
			$(".treelist").find("ul").find("li").eq(0).find("a").eq(0).click();
		}
	}
	function beforeDrop(treeId, treeNodes, targetNode, moveType) {
		if(targetNode.pId==null){
			return false;
		}
		return treeNodes[0].pId==targetNode.pId;
	}
</script>
<div class="M_left">
	<div class="treelist">
      	<span class="rootSpan">栏目</span>
       	<ul id="treeDemo" class="ztree"></ul>
	</div>	
</div>
