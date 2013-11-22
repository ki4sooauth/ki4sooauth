<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${shopVo.wordNames['gmsj01']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
	request.setAttribute("topMenuCode", "18");
	request.setAttribute("top2MenuCode", "1801");
	request.setAttribute("leftMenuCode", "");
%>
<script type='text/javascript' src='${basePath}/gresource/dwr/engine.js'></script>
<script type='text/javascript' src='${basePath}/gresource/dwr/util.js'></script>
<script type="text/javascript" src="${imgPath}/gms/resource/js/hisBidRecord.js"></script>
<script type="text/javascript" src="${imgPath}/gms/resource/js/bid.js"></script>
<script type="text/javascript">
var adInfos;
var isRefresh =false;
	$(document).ready(function() {
		<%--开启dwr数据推送--%>
		dwr.engine.setActiveReverseAjax(true);
		<%--获取广告信息--%>
		adInfos = finAllAd();
		<%--给左侧菜单绑定点击事件--%>
		$(".col_left .subNav li").live("click",function() {
		  $(this).addClass("cur").siblings("li").removeClass("cur");
		  var adType=[];adType.push($(this).val());intAdByTypes(adType);getAdInfo();
		  if(!isRefresh){
			 findAdBidInfo();pageWinBidR(1);pageShopBidR(1);
			 saveValue();
		  }
		})
		<%--给广告选项卡绑定点击事件--%>
		$(".col_right .subNav li").live("click",function() {
		  $(this).addClass("cur").siblings("li").removeClass("cur");getAdInfo();findAdBidInfo();pageWinBidR(1);pageShopBidR(1);
		  saveValue();
		})
		getSaveValue();
	});
</script>
</head>
<body>
	<%--以下是头部--%>
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
			<div class="col_1">
	<div class="tit">
		<h4>${shopVo.wordNames['gmsj01']}</h4>
	</div>
	<div class="col_left">
		<ul class="subNav">
			<li class="cur" value="1">${shopVo.wordNames['gmsj02']}</li>
			<li value="5">${shopVo.wordNames['gmsj03']}</li>
			<li value="2">${shopVo.wordNames['gmsj04']}</li>
			<li value="3">${shopVo.wordNames['gmsj05']}</li>
			<li value="4">${shopVo.wordNames['gmsj06']}</li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="col_right">
		<div class="ab_1">
			<img width="723" height="629" src="${imgPath}/gms/resource/images/ab.jpg" />
		</div>
		<div class="tip">
			<span class="red">*</span>
			${shopVo.wordNames['gmsj36']}
		</div>
		<ul class="subNav">
		</ul>
		<div class="content">
		<check:hasAuthority authorityID="180101">
			<div class="tit_1">
				<h4>${shopVo.wordNames['gmsj08']}</h4>
			</div>
		</check:hasAuthority>	
			<%--<div class="patch"></div>--%>
			<div id="bidInfos">
			  <%--广告位竞拍信息 --%>
			</div>
			<%--<div class="patch"></div>--%>
			<check:hasAuthority authorityID="180102">
			<div class="tit_1">
				<h4>${shopVo.wordNames['gmsj09']}</h4>
			</div>
            <div id="table_winBid" class="W">
               <%--广告告位历史中标记录 --%>
            </div>
			<div class="clear" style="height: 20px;"></div>
			<div class="tit_1">
				<h4>${shopVo.wordNames['gmsj10']}</h4>
			</div>
	        <div id = "table_shopBidR" class="S">
	           <%--广告位当前商家竞拍历史记录 --%>
	        </div>
	        </check:hasAuthority>
		</div>
	</div>
</div>
</body>
</html>