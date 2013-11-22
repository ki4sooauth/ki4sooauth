<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
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
	initFancyBox("fancybox_category",240,450,true);
	initFancyBox("fancybox_position",240,450,true);
	initFancyBox("fancybox_brand",850,500,true);
}); 

function relateOne(relateType){
	var shopEntityId = $("select[name='entityId']").val() ;
	var url = "" ;
	// 品类
	if(relateType == "J") {
	    url = "${basePath }/relation.do?method=treeRelation&relateType=" + relateType + "&entityId=" + shopEntityId;
		$("#relateCategory").attr("href",url).click();
	} 
	// 品牌
	else if(relateType == "B") {
	    url = "${basePath }/relation.do?method=listRelation&selectType=S&relateType=" + relateType + "&entityId=" + shopEntityId;
		$("#relateBrand").attr("href",url).click();
	} 
	// 位置 
	else if(relateType == "I") {
		shopEntityId = $("#entityId").val() ; 
		var url = "${basePath }/relation.do?method=treeRelation&relateType=" + relateType + "&entityId=" + shopEntityId;
		$("#relatePosition").attr("href",url).click();
	}
}


//商品审核
function goods_reviewed() {
	var status = $("#status").val();
	var note = $("textarea[name='note']").val() ;
	var data = "&status=" + status + "&note=" + note + "&goodsId=" + goodsId ;
	$.ajax({
		type : "post",
		url : basePath + "/goods.do?method=reviewed",
		dataType : 'json',
		data:data,
		success : function(data) {
			alert(data.message);
			(document.parentWindow || document.defaultView).parent.closeCheckFancyBox();
		}
	});
}


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
//审核状态
 function checkStatus(status){
	$("#status").val(status);
	goods_reviewed();
}
</script>
</head>
<body>
	<!--头部-->
<div class="add_actPopBox" style="padding:30px">
	<!--内容-->
				<div class="rightTitle">
					<span class="tit_1">${shopVo.wordNames['gmse098']}</span>
				</div>
				<div class="conditions_content">
					
				    <!-- 商品基本信息 -->
					<%@include file="/WEB-INF/jsp/goods/view/view_goods_base.jsp"%>
					<div class="title">
					  <check:hasAuthority authorityID="15010102">
							${shopVo.wordNames['gmse037']}
					  </check:hasAuthority>
					</div>
					<table class="fileTable productTab" cellpadding="0" cellspacing="1"
						border="0" width="100%">
						<tr>
							<th width="30%">${shopVo.wordNames['gmse038']}</th>
							<th width="40%">${shopVo.wordNames['gmse039']}</th>
							<th width="30%">${shopVo.wordNames['gmse040']}</th>
						</tr>
						<c:forEach items="${specials }" var="item">
						<tr>
							<td>${item.featureCode }</td>
							<td>${item.featureName }</td>
							<td>${item.featureValue }</td>

						</tr>
						</c:forEach>
					</table>
					<!-- 商品营销信息 -->
					<%@include file="/WEB-INF/jsp/goods/view/view_marketing.jsp"%>
					<!-- 状态信息 -->
					<div class="title">${shopVo.wordNames['gmse099']}</div>
					<div class="productBuild">
						<ul>

							<li>
								<span class="tit_1">${shopVo.wordNames['gmse103']}</span>
								<textarea  name="note" cols="92" rows="5"></textarea>
							</li>
						
						<li>
<%-- 						<span class="tit_1">${shopVo.wordNames['gmse100']}</span> --%>
								<input type="hidden" id="status"/>
								<div style="margin-top:8px; text-align:center;">
							<a href="#" onclick="checkStatus('Y');" style="width: 80px; height: 28px;line-height: 28px;" class="inputBtn blueBtn"><strong>${shopVo.wordNames['gmsd081']}</strong></a>								          
							&emsp;&emsp;<a href="#" onclick="checkStatus('N');" style="width: 80px; height: 28px;line-height: 28px;" class="inputBtn blueBtn"><strong>${shopVo.wordNames['gmsd080']}</strong></a>						 									
							</div>
							</li>
							</ul>
<%-- 						<input onclick="this.disabled=true;goods_reviewed()" class="savebtnS blueBtn"  type="submit"	value="${shopVo.wordNames['gmse055']}" /> --%>
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
</html>
