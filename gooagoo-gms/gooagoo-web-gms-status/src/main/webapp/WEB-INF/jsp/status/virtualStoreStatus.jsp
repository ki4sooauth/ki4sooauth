<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${imgPath}/gms/status/js/status.js"></script>
<title>${shopVo.wordNames['gmsb134']}</title>
<%
	request.setAttribute("topMenuCode", "11");
	request.setAttribute("leftMenuCode", "1108");
%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript">
	var shopId = "${gmsLoginInfo.shopId}"
	var statusFlag="vb";
	var cbody=true;
	var basePath = '${basePath}';
	$(document).ready(function(){
	  	initActivityCalendar();
		initFancyBox("tableIndex",850,550,true);
		sourceClick();
		getVbStatus();
	});
</script>
</head>
<body>
	<!--头部-->
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	<!--内容-->
	<div class="container">
	  	<div class="article">
	  		<div class="date_box">
	    		<%@include file="/WEB-INF/jsp/common/datepicker.jsp"%>
			</div>
	        <div class="section">
	           	<div class="rightTitle">
	            	<span>${shopVo.wordNames['gmsb073']}</span>
	          	</div>
	        	<div class="histogram_nav ">
	            	<a href="#" class="curr" id="A">${shopVo.wordNames['gmsb074']}</a><a href="#" id="M">${shopVo.wordNames['gmsb075']}</a><a href="#" id="W">${shopVo.wordNames['gmsb076']}</a>
	            </div>
	         	<div class="marketing_histogram">
	                <div id="obj">
	                </div>
	                <div id="hightCharts" style="display: none;">
	                </div>
	            </div>
	       	</div>
	      	<div class="aside">
	        	<%@include file="/WEB-INF/jsp/common/left2.jsp"%>
	      	</div>
		</div>
	</div>
 	<a id="tableIndex" class="tableIndex" href="#" style="display: none"></a>
</body>
</html>
