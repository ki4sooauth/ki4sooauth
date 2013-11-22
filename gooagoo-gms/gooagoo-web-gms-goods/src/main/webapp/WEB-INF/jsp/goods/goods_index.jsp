<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
request.setAttribute("topMenuCode", "15");
request.setAttribute("leftMenuCode", "1501");
%>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmse002']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/public.js"></script>

<script type="text/javascript" src="${imgPath}/gms/goods/js/brandFancybox.js"></script>

<link href="${imgPath}/gms/goods/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.js" ></script>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.pack.js" ></script>

<script>
	$(function() {
		page(1);
		getEntityList("${shopId}") ;
		initFancyBox("fancybox_category",850,500,true);
		initFancyBox("fancybox_brand",850,500,true);
		initFancyBox("fancybox_detail",920,600,true);//审核 详细公用弹出层
	})
	
	var entityList ;
	//获取条件查询中的实体店信息
function getEntityList(sId) {
	var shopId = sId ;

	$.ajax({
		async:false,
		type:"POST",
		url:basePath + "/goods.do?method=getEntityList&shopId=" + sId + "&pageSize=10",
		dataType:"json",
		success: function(data) {
			entityList = data ;
			showEntity() ;
		}
	});
}
	
	// 显示条件查询实体店
	function showEntity() {
		    var str = "<option value=''>${shopVo.wordNames['gmsg241']}</option>";
			for(var i=0;i<entityList.length;i++) {
				var entity = entityList[i] ;
				str += "<option value='" + entity.shopEntityId + "' >" + entity.shopEntityName + "</option>" ;
			}
			$("#entity_id").html(str) ;
	}
	
	function page(pageIndex) {	
		if (pageIndex == undefined) {
			pageIndex = 1;
		}		
		var data = "&pageSize=5&pageIndex=" + pageIndex + "&shopId="+ "${shopId }";
		var goodsName=$("input[name='goodsName']").val();
		var goodsCategoryLeaf=$("input[name='goodsCategoryLeaf']").val();
		var goodsBrand=$("input[name='goodsBrand']").val();
		var goodsSerial=$("input[name='goodsSerial']").val();
		var itemSerial=$("input[name='itemSerial']").val();
		var publishStatus=$("select[name='publishStatus']").val();
		var entityId=$("#entity_id").val();
		if(isEmpty(entityId)){
			entityId="";
		}
       data+="&goodsName="+goodsName+"&goodsCategoryLeaf="+goodsCategoryLeaf+"&goodsBrand="+
		goodsBrand+"&goodsSerial="+goodsSerial+"&itemSerial="+itemSerial+"&publishStatus="+publishStatus
		+"&shopEntityId="+entityId;
		
		$.ajax({
			type : "POST",
			data : data,
			url : basePath + "/goods.do?method=page",
			success : function(ret) {
				$("#goods_list").html(ret);
			}
		})
	}
	//清空查询条件
	function clearArgs(){
		$("input[name='goodsName']").val("");
		$("input[name='goodsCategoryLeaf']").val("");
		$("input[name='goodsBrand']").val("");
	    $("input[name='goodsSerial']").val("");
		$("input[name='itemSerial']").val("");
		$("select[name='publishStatus']").val("");
		$("#entity_id").val("");
		$("#goods_category").val("");
		$("#goods_brand").val("");
		
		page(1);
	}
	function relateOne(relateType){
		var entityId = "${entityId}";
		if(isEmpty(entityId)){
			entityId=$("select[name='entityId']").val();
		}
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
	}
	//选中回调函数
	function dealRelations(relations){
		 if(relations[0][0] == "J" ){
			$("#categoryLeafId").val(relations[0][1]) ;
			$("#goods_category").val(relations[0][2]) ;
			$("#categoryRootId").val(relations[0][3]) ;
		}
		// 品牌
		else if(relations[0][0] == "B"){
			$("#brandId").val(relations[0][1]) ;
			$("#goods_brand").val(relations[0][2]) ;
		}
		
		$.fancybox.close();
	}
	function previewGoods(goodsUrl) {

		window.open(goodsUrl);
		
	}
	// 商品删除
	function goods_delete(id) {
		if (confirm("是否将此商品删除?")) {
			$.ajax({
				type : "post",
				url : basePath + "/goods.do?method=delGoodsDo&goodsId=" + id,
				dataType : 'json',
				success : function(data) {
					if (data.success == true) {
						$("#" + id + "pic").remove();
						$("#" + id + "table").remove();
						page(1); // 重新加载商品页面
					} else {
						alert(data.message);
					}
				}
			})
		}
	}
	
	// 商品审核
	function goods_reviewed(id) {
		if(confirm("是否审核通过？")) {
			$.ajax({
				type : "post",
				url : basePath + "/goods.do?method=reviewed&goodsId=" + id,
				dataType : 'json',
				success : function(data) {
					if (data.success == true) {
						page(1); // 重新加载商品页面
					}
					alert(data.message);
				}
			})
		}
	}
	
	// 商品发布
	function goods_publish(id) {
		if(confirm("是否发布？")) {
			$.ajax({
				type : "post",
				url : basePath + "/goods.do?method=publish&goodsId=" + id,
				dataType : 'json',
				success : function(data) {
					if (data.success == true) {
						page(1); // 重新加载商品页面
					}
					alert(data.message);
				}
			})
		}
	}
	
	function toPage() {
		var index = $("#pageIndex").val() ;
		var page_end = '${page_end}' ;
		if(isNaN(index)){
			index = 1;
		} else {
			if(index > page_end) {
				index = page_end ;
			}
			if(index < 1)
				index = 1 ;
		}
		page(index) ;
	}
	//商品详情
	function detail(id){
		$("#detailFancybox").attr("href","${basePath }/goods.do?method=viewGoods&goodsId="+id).click();
	}
	function check(id){
		$("#detailFancybox").attr("href","${basePath }/goods.do?method=reviewedGoods&goodsId="+id).click();
	}
	//关闭弹出层
	function closeCheckFancyBox(){
		closeFancyBox();
		page(1);
	}
		
</script>

</head>


<body >
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div  class="container" style="overflow:hidden;height:100%;">
		<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle_add">
				  <check:hasAuthority authorityID="150101">
				  <a href="${basePath }/goods.do?method=form">${shopVo.wordNames['gmse003']}</a>
				  </check:hasAuthority>
					<span>${shopVo.wordNames['gmse002']}</span>
				</div>
		<div style="padding-bottom:10px;color:#0873B9;font-weight:bold;height:20px;line-height:20px;"> 
          ${shopVo.wordNames['gmse014']}：
          <select style="padding:1px;border:1px solid #ccc;width:180px;vertical-align:middle;background-color: white;"  class="borderStyle select" onchange="" name="entityId" id="entity_id">
          </select>
          </div>
			 	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" style="background-color:#F8F7F7; ">
					<tr>
						<td colspan="8" style="padding-top: 0px;padding-bottom: 0px">
							<div class="behaviorSearch"  style="float:left; height:20px;">		
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 0px;margin-left: 0px;width: 80px">${shopVo.wordNames['gmse004']}：</span>
								<input type="text" name="goodsName" class="behaviorInput" style="margin-left: 0px;width: 160px" id="lid" value=""/>
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 0px;width: 80px">${shopVo.wordNames['gmse005']}：</span>
								<input type="text" class="behaviorInput" style="margin-left: 0px;width: 160px"  readonly  onclick="relateOne('J');" name="categoryLeafName" id="goods_category" />
								<input id="categoryRootId"  type="hidden" name="categoryRootId"/>
								<input id="categoryLeafId" type="hidden" name="goodsCategoryLeaf"/>
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 0px;width: 80px"">${shopVo.wordNames['gmse006']}：</span>
								<input type="text"  class="behaviorInput" onclick="relateOne('B');" style="margin-left: 0px;width: 160px"  id="goods_brand" />
			                 	<input  id="brandId" type="hidden" name="goodsBrand" /> 
							</div>
						</td>
	             	</tr>
	             	<tr>
						<td colspan="8" style="padding-top: 0px;padding-bottom: 0px">
							<div class="behaviorSearch"  style="float:left; height:20px;">		
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 0px;width: 80px"">${shopVo.wordNames['gmse085']}：</span>
									<input type="text" class="behaviorInput" style="margin-left: 0px;width: 160px" name="goodsSerial" />
									<span style="float: left; height: 20px; line-height: 24px; padding-left:0px;width: 80px"">${shopVo.wordNames['gmse045']}：</span>
									<input type="text" class="behaviorInput" style="margin-left: 0px;width: 160px" name="itemSerial" />
									<span style="float: left; height: 20px; line-height: 24px; padding-left: 0px;width: 80px"">${shopVo.wordNames['gmse100']}：</span>
									<select name="publishStatus" id="publishStatus" class="behaviorInput" style="margin-left: 0px;width: 160px">
											<option value="">${shopVo.wordNames['gmsg241']}</option>
											<option value="W" >待审核</option>
											<option value="A" >已通过审核</option>
											<option value="B" >审核未通过</option>
											<option value="P" >已发布</option>					
									</select>
							</div>
						</td>
	             	</tr>
					<tr>
						<td colspan="8" style="padding-top: 0px;padding-bottom: 0px">
							<div class="behaviorSearch"  style="float:left; height:20px;">		
								<a href="javascript:void(0)" style="margin-left:600px ;margin-top:-6px;" id="select" onclick="page(1)" class="search orangeBtn" style="margin-left: 35px;">${shopVo.wordNames['gmsc006']}</a>
								<a href="javascript:void(0)" style="margin-top:-6px;" onclick="clearArgs();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>												
							</div>
						</td>
	             	</tr>
				</table> 
	

				<div id="goods_list"></div>
			</div>
		</div>
	</div>
	<!-- 品类 -->
	<div style="display:none;">
		<a href="#" id="relateCategory" class="fancybox_category"></a>
	</div>
	<!-- 品牌 -->
	<div style="display:none;">
		<a href="#" id="relateBrand" class="fancybox_brand"></a>
	</div>
	<div style="display: none;">
	  <a class="fancybox_detail" id="detailFancybox"></a>
	</div>
</body>


</html>
