<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
request.setAttribute("topMenuCode", "15");
request.setAttribute("leftMenuCode", "1504");
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
		page(1) ;
	})
	function page(pageIndex) {
		var code=$("input[name='code']").val();
		var goodsSerial=$("input[name='goodsSerial']").val();
		var data = "pageSize=10&pageIndex=" + pageIndex +"&code="+code+"&goodsSerial="+goodsSerial;
		$.ajax({
			type : "POST",
			data : data,
			url : basePath + "/feature.do?method=list",
			success : function(ret) {
				
				$("#feature_list").html(ret);
			}
		});
	}
	function clearArgs(){
		$("input[name='code']").val("");
		$("input[name='goodsSerial']").val("");
		page(1);
	}
	
	// 商品特征项删除
	function feature_delete(id) {
		if (confirm("是否将此商品特征项删除?")) {
			$.ajax({
				type : "post",
				url : basePath + "/feature.do?method=delDo&id=" + id,
				dataType : 'json',
				success : function(data) {
					if (data.success) {
						page(1) ; // 重新加载商品特征项页面
					} else {
						alert(data.message);
					}
				}
			})
		}
	}

</script>
</head>
<body >
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container" style="overflow:hidden;height:100%;">
		<div class="article">
			<%@include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="section">
				<div class="rightTitle_add">
				  <check:hasAuthority authorityID="150101">
				  <a href="${basePath }/feature.do?method=add">${shopVo.wordNames['gmse091']}</a>
				  </check:hasAuthority>
					<span>${shopVo.wordNames['gmse092']}</span>
				</div>
			<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" style="background-color:#F8F7F7; ">
					<tr>
						<td colspan="8" style="padding-top: 0px;padding-bottom: 0px">
							<div class="behaviorSearch" >		
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">${shopVo.wordNames['gmse093']}：</span>
							<input type="text"  name="code" class="behaviorInput"  style="margin-left: 0px;width: 135px" />
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">${shopVo.wordNames['gmse094']}：</span>
							<input type="text" name="goodsSerial"  class="behaviorInput"  style="margin-left: 0px;width: 135px" />
							<a href="javascript:void(0)" style="margin-left: 60px ;margin-top:-2px;" id="select" onclick="page(1)" class="search orangeBtn">${shopVo.wordNames['gmsc006']}</a>
							<a href="javascript:void(0)" style="margin-top:-2px;" onclick="clearArgs();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>													
							</div>
						</td>
	             	</tr>
				</table> 
				<div id="feature_list"></div>
			</div>
		</div>
	</div>
</body>

</html>
