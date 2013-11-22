<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${relateName}</title>

<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common-check.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/member/js/public.js"></script>

<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css" />
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/demo.css" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/ztree-common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/relate.js"></script>
<link rel="stylesheet" type="text/css" href="${imgPath}/common/ztree/css/window/treeWindow.css" media="screen" />
<script type="text/javascript">
	$(document).ready(function() {
		var json = ${dataJson };
		initTree(json,"${ids }","${selectType }");
		if(isEmpty(json)){
			alert("暂无${relateName}信息！");
			parent.$.fancybox.close();
		}
	});		
</script>
</head>
<body>
	<div class="publish">
		<div class="publish_top">
			<p class="publish_top_p1"></p>
			<span>${relateName}</span>
			<p class="publish_top_p2"></p>
		</div>
		<div class="publish_n" style="height: 411px;">
			<div class="publish_n_top_scroll" style="width: auto; height: 382px;">
				<!--内容 -->
				<#if relateType!='F'>
				<#if shopVo.shopAndUserInfo.userShopEntityId!??||shopVo.shopAndUserInfo.userShopEntityId=="">
			<div id="entityDiv" style="padding-bottom:10px;color:#0873B9;font-weight:bold;height:20px;line-height:20px;"> 
          ${shopVo.wordNames['gmse014']}：
	           <select id="entityId" name=entityId onchange="condtionTree();" <#if shopEntityId!??&&shopEntityId!="">disabled='disabled'</#if>>
					<#if shopEntityList??>
					<#list shopEntityList as itemChild>
						<option value="${itemChild.shopEntityId}" <#if itemChild.shopEntityId == entityId!>selected="selected"</#if>>${itemChild.shopEntityName}</option>
					</#list>   
					</#if>
				</select>   
             </div>
             </#if>
             </#if>
				<ul id="nodeTree" class="ztree" style="width: auto; min-height: 340px;height:0px;"></ul>			
				<input type="hidden" id="relateType" value="${relateType }" /> 
				<input type="hidden" value="${ids}" id="ids"/>
                <input type="hidden" value="${dataType}" id="dataType"/>                                         
				<input type="hidden" id="treeObjId" value="nodeTree" />
			</div>
			<div class="publish_n_buttom">&nbsp;
				<#if selectType=='M'>
					<input type="button" style="background: none repeat scroll 0 0 #0873B9; margin: 7px 0 0 82px; display: inline;" value="${shopVo.wordNames['gmsc129']}" onclick="selectMultNode();" />
				</#if>&nbsp;
			</div>
		</div>
	</div>
</body>
</html>