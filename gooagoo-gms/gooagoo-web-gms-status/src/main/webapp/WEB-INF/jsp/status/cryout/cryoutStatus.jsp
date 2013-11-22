<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	request.setAttribute("topMenuCode", "11");
	request.setAttribute("leftMenuCode", "1110");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsb095']}</title>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/status/js/status.js"></script>
<script type="text/javascript">
	var statusFlag="cryout";
   	var cbody=true;
   	var basePath = '${basePath}';
   	$(document).ready(function(){
	  	initActivityCalendar();
		sourceClick();
	  	initFancyBox("fancybox_relate",800,600,true);
		initFancyBox("tableIndex",900,500,true);
   	});
   	
   	function selectParent(){
	  	var url = "${basePath}relation.do?method=listRelation&relateType=M&activityId=";
	  	$("#fancybox_relate").attr("href",url).click();
   	}
   	
   	function dealRelations(relations){
	   	var type = "";
	   	
	   	if(relations[0][0] == "A") {
	   		type = "parent" ;
	   	} else if(relations[0][0] == "M") {
	   		type = "child" ;
	   	} else return ;
	   	
		$("#"+type+"Id").val(relations[0][1]);
		$("#"+type+"Name").html(relations[0][2]);
		$("#chartName").val(relations[0][2]) ;
		getStatus();
		$.fancybox.close();
	}
  	
  	function changeTimeType() {
  		var type = $("#timeTypeSelect").val() ;
  		if(type == "C") {
  			$(".cur").show() ;
  			$(".his").hide() ;
  		} else {
  			$(".cur").hide() ;
  			$(".his").show() ;
  		}
  		getStatus();
  	}
</script>
</head>
<body>
   	<!--头部-->
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
   	<!--内容-->
   	<div style="display:none;">
   		<a id="fancybox_relate" class="fancybox_relate" href="#"></a>
   	</div>
    <div class="container">
      	<div class="article">
	    	<div class="date_box">
	       		<%@include file="/WEB-INF/jsp/common/datepicker.jsp"%>
	       	</div>
	        <div class="section">
	           	<div class="rightTitle">
	            	<span>吆喝状态</span>
	           	</div>
	        	 <%@include file="/WEB-INF/jsp/common/statistics_condition.jsp"%>
			</div>
	      	<div class="aside">
	        	<%@include file="/WEB-INF/jsp/common/left2.jsp"%>
	      	</div>
   	 	<a id="tableIndex" class="tableIndex" href="#" style="display: none"></a>
  	  </div>
  	</div>
</body>
</html>
