<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
request.setAttribute("topMenuCode", "15");
request.setAttribute("leftMenuCode", "1501");
%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmse073']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/shopBuild_1.css" rel="stylesheet" type="text/css" />
<%-- <script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script> --%>

<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type='text/javascript' src='${imgPath}/common/js/kindeditor/kindeditor-min.js' charset='utf-8'></script>
<link rel="stylesheet" href="${imgPath}/common/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${imgPath}/common/js/kindeditor/lang/zh_CN.js"></script>


<script type="text/javascript" src="${imgPath}/gms/goods/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/addSpecialFancybox.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/updateSpecialFancybox.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/goodsFancybox.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/goods_update.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/upload.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/shopEntityInfo.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/ztree_category.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/ztree_brand.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/ztree_position.js"></script>

<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate-extend.js"></script>

<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/demo.css" type="text/css"/>

<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>

<link href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.js" ></script>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.pack.js" ></script>
<script>
$(function(){
	init('${goodsInfo.goodsId}') ;
	showPic('${marketing.goodsImg}') ;
}) 

//显示图片
function showPic(picUrl) {
	if(picUrl.length == 0) {
		$("#pic_main").attr("src",imgPath + "/gms/goods/images/default_goods.png") ;
	} else {
		var arr = picUrl.split(",") ;
		$("#pic_main").attr("src",arr[0]) ;
		for(var i=1;i<arr.length;i++) {
			var str1 = "<a href='#'><img class='pic_sub_class'	src='" ;
			var str2 = "' width='140' height='140' /><u class='productBuild-del' onclick='" ;
			var str3 = "'></u></a>" ;
			var str = str1 + arr[i] + str2 + "delPic(this)" + str3 ;
			
			$("#pic_sub").append(str) ;
		}
	}
}

goodsId="${goodsInfo.goodsId }" ;
marketingId="${marketing.goodsId}" ;
shopId = "${shopId}" ;

//添加商品特征信息
function saveSpecials(data) {
	data += "&goodsId=" + '${goodsInfo.goodsId}' 
				+ "&goodsName=" + '${goodsInfo.goodsName}'
				+ "&shopId=" + '${shopId}';
	$.fancybox.close();
	
	var url = basePath + '/goodsSpecial.do?method=addSpecialDo'; 
	$.ajax({
		url: url,
		type:'POST',
		dataType:'json',
		data:data,
		success: function(data) {
			if(data.success) {
				alert(data.message) ;
				document.location.reload();
			}
			else alert(data.message) ;
		}
	});
}

//修改商品特征信息 
function updateSpecials(data) {

	data += "&goodsId=" + '${goodsInfo.goodsId}' 
	+ "&goodsName=" + '${goodsInfo.goodsName}'
	+ "&shopId=" + '${shopId}';
	$.fancybox.close();
	
	var url = basePath + '/goodsSpecial.do?method=updateSpecialDo'; 
	$.ajax({
		url: url,
		type:'POST',
		dataType:'json',
		data:data,
		success: function(data) {
			if(data.success) {
				alert(data.message) ;
				document.location.reload();
			}
			else alert(data.message) ;
		}
	});
}
// 删除商品特征
function delSpecial(id){
	
	var data = "&id=" + id ;
	var url = basePath + '/goodsSpecial.do?method=delSpecialDo'; 
	$.ajax({
		url: url,
		type:'POST',
		dataType:'json',
		data:data,
		success: function(data) {
			if(data.success) {
				alert(data.message) ;
				document.location.reload();
			}
			else alert(data.message) ;
		}
	});
}
// ------
$(document).ready(function(){
	initFancyBox("fancybox_category",850,500,true);
	initFancyBox("fancybox_position",240,450,true);
	initFancyBox("fancybox_brand",850,500,true);
});
function relateOne(relateType){
	var entityId = $("#shopEntityId").val();
	var url = "" ;
	// 品类
	if(relateType == "J") {
	    url = "${basePath }/relation.do?method=listRelation&relateType=" + relateType + "&entityId=" + entityId;
		$("#relateCategory").attr("href",url).click();
	} 
	// 品牌
	else if(relateType == "B") {
	    url = "${basePath }/relation.do?method=listRelation&selectType=S&relateType=" + relateType + "&entityId=" + entityId;
		$("#relateBrand").attr("href",url).click();
	} 
	// 位置 
	else if(relateType == "I") {
		entityId = $("#entityId").val() ; 
		var url = "${basePath }/relation.do?method=treeRelation&relateType=" + relateType + "&entityId=" + entityId;
		$("#relatePosition").attr("href",url).click();
	}
}


</script>


</head>


<body>
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
		<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle">
					<span>${shopVo.wordNames['gmse074']}</span>
				</div>
				<div class="conditions_content">
				    <!-- 商品基本信息 -->
					<%@include file="/WEB-INF/jsp/goods/update/update_goods_base.jsp"%>
					<div class="title">
					  <check:hasAuthority authorityID="15010102">
						<a href="#" class="addProduct orangeBtn" onclick="addSpecial('${goodsInfo.goodsId}');">${shopVo.wordNames['gmse036']}</a>${shopVo.wordNames['gmse037']}
					  </check:hasAuthority>
					</div>
					<table class="fileTable productTab" cellpadding="0" cellspacing="1"
						border="0" width="100%">
						<tr>
							<th width="20%">${shopVo.wordNames['gmse038']}</th>
							<th width="30%">${shopVo.wordNames['gmse039']}</th>
							<th width="20%">${shopVo.wordNames['gmse040']}</th>
							<th width="20%">操作</th>
						</tr>
						<c:forEach items="${specials }" var="item">
						<tr>
							<td>${item.featureCode }</td>
							<td>${item.featureName }</td>
							<td>${item.featureValue }</td>
							<td>
							<check:hasAuthority authorityID="1501020102">
							<a href="#" onclick="updateSpecial('${item.id}');" class="handle pencil">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
							<a href="#" onclick="delSpecial('${item.id}');" class="handle del">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
							</check:hasAuthority>
							</td>
						</tr>
						</c:forEach>
					</table>
					<!-- 商品营销信息 -->
					<%@include file="/WEB-INF/jsp/goods/update/update_marketing.jsp"%>
				</div>
			</div>
		</div>
		</div>
		
		<!-- 位置弹出层 -->
<div style="display:none;">
	<a href="#" class="brand_fancybox_select"></a>
</div>

<div style="display:none;">
	<a href="#" class="special_fancybox_select"></a>
</div>
	
<!-- 品类 -->
<div style="display:none;">
	<a href="#" id="relateCategory" class="fancybox_category"></a>
</div>
<!-- 品牌 -->
<div style="display:none;">
	<a href="#" id="relateBrand" class="fancybox_brand"></a>
</div>	
<!-- 位置 -->
<div style="display:none;">
	<a href="#" id="relatePosition" class="fancybox_position"></a>
</div>	
</body>
<script type="text/javascript">
//编辑器
var editor = KindEditor.create('.textWeb', {
	allowFileManager : true,
	afterChange : function() {
		this.sync();
		recount(this);
	},
	height : 100,
	width  : 600,
	resizeType : 0,//2或1或0，2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。 
	items : [ 'bold', 'italic', 'underline', 'strikethrough',
			'removeformat', '|', 'insertorderedlist',
			'insertunorderedlist', 'forecolor', 'hilitecolor',
			'fontname', 'fontsize', '|', 'link', 'unlink', 'emoticons',
			'shcode', 'quote', '|', 'about' ]
});
function recount(editor) {
	var maxlen = 140;
	var current = maxlen - editor.text().length;
	$('.counter').html(current);
	if(current<0 || current>maxlen) {
		contCryout = editor.text().substring(0,maxlen);
		editor.html("");
		editor.appendHtml(contCryout);
		$('.counter').css('color', '#D40D12');
		$('input.sub_btn').attr('disabled', 'disabled');
	}else{
		$('input.sub_btn').removeAttr('disabled');
	}
	if(current < 10){
		$('.counter').css('color', '#D40D12');
	}else if (current < 20){
		$('.counter').css('color', '#5C0002');
	}else{
		$('.counter').css('color', '#cccccc');
	}
}
</script>
</html>
