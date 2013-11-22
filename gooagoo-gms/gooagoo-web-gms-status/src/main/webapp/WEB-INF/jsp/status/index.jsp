<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%
	request.setAttribute("topMenuCode", "11");
	request.setAttribute("leftMenuCode", "1101");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsb009']}</title>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/member/css/file.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/status/js/InStoreStatus.js"></script>
<script type="text/javascript" src="${imgPath}/gms/status/js/status.js"></script>
<script type="text/javascript">
	var cbody=true;
  	var basePath="${basePath}";
  	$(document).ready(function(){
	  	initActivityCalendar();
	  	pageFlag="inStore"
	  	init();
	  	fillSelect();
	  	userType();
	  	initFancyBox("tableIndex",850,650,true);
	});
</script>
</head>
<body>
   <!--头部-->
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
     <div class="sub_nav_wrap">
    	<div class="sub_nav_height">
        	<ul class="sub_nav">
            	<li><a href="javascript:void(0);" id='1' class="curr">${shopVo.wordNames['gmsb077']}</a></li>
                <li><a href="javascript:void(0);" id='2' >${shopVo.wordNames['gmsb002']}</a></li>
                <li><a href="javascript:void(0);" id='5' >${shopVo.wordNames['gmsb005']}</a></li>
                <li><a href="javascript:void(0);" id='3' >${shopVo.wordNames['gmsb003']}</a></li>
                <li><a href="javascript:void(0);" id='8' >${shopVo.wordNames['gmsb078']}</a></li>
                <li><a href="javascript:void(0);" id='4' >${shopVo.wordNames['gmsb079']}</a></li>
                <li><a href="javascript:void(0);" id='6' >${shopVo.wordNames['gmsb080']}</a></li>
            <!--<li><a href="javascript:void(0);" id='7' >新增用户</a></li> -->
            </ul>
        </div>
	</div>
   	<!--内容-->
    <div class="container">
      	<div class="article">
      		<div class="date_box">
        		<%@include file="/WEB-INF/jsp/common/datepicker.jsp"%>
        	</div>
        	<div class="section">
	        	<div class="file_nav">
	           	 	<a class="curr" href="javascript:void(0);" name="rel" onclick="switchTab(this);fillSelect();userType($('#statisticType').val());">${shopVo.wordNames['gmsb081']}</a>
	            	<a href="javascript:void(0);" name="his" onclick="switchTab(this);fillSelect();userStatusHis();">${shopVo.wordNames['gmsb082']}</a>
	            	<div class="natural_quality" style="float:right;padding:13px 0 10px 0px">
					    <p>
							<span>${shopVo.wordNames['gmsb083']}</span>
							<select name="statisticType" id="statisticType" style="width: 250px;">
				            </select>
					  	</p>
					 </div>
				</div>
	          	<div class="file_first" id = "pic_h" ></div>
	          	<div style="margin-left: 685px"></div>
	         	<div id="table"></div>
			</div>
		  <div class="section" style="display: none">
           <div id="table2"></div>
          </div>
	      	<div class="aside">
	        	<%@include file="/WEB-INF/jsp/common/left2.jsp"%>
	      	</div>
		</div>
	</div>
  	<a id="tableIndex" class="tableIndex" style="display: none"></a>
</body>
</html>
