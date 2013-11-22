<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpma005']}</title>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%
request.setAttribute("topMenuCode", "22");
request.setAttribute("leftMenuCode", "");
%>
<link href="${imgPath}/gms/member/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/member/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/markState.css" rel="stylesheet" type="text/css" />
<%-- <script type="text/javascript" src="${imgPath}/common/hightCharts/highcharts.js"></script> --%>
<%-- <script type="text/javascript" src="${imgPath}/common/hightCharts/modules/exporting.js"></script> --%>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/createChart.js"></script>
<script type="text/javascript" src="${imgPath}/common/highstock/highstock.js"></script>
<script type="text/javascript" src="${imgPath}/common/highstock/modules/exporting.js"></script>
<script type="text/javascript" src="${imgPath}/common/hightCharts/themes/grid2.js"></script>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/userState.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
chartFlag = "userStatus";
$(document).ready(function(){
  initFancyBox("fancybox",800,500,false);
  initFancyBox("fancybox_relate_entity",800,550,true);
  initFancyBox("fancybox_relate_area",240,450,true);
  $(".sub_nav .curr").click();
});
function dealRelations(relations){
	 if("E"==relations[0][0]){
		 $("#shopEntityId").val(relations[0][1]);
		 $("#fancybox_relate_entity").html(relations[0][2]);
		 $(".fancybox_relate_area").attr("href","${basePath}relation.do?method=treeRelation&relateType=I&entityId="+relations[0][1]);
	 }else if("position"==relations[0][0]){
		 $("#areaId").val(relations[0][1]);
		 $(".fancybox_relate_area").html(relations[0][2]);
	 }
	 switchData();
	 $.fancybox.close();
}
</script>
</head>
<body>
 <!--头部-->
     <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
     <div class="sub_nav_wrap">
    	<div class="sub_nav_height">
        	<ul class="sub_nav">
            	<check:hasAuthority authorityID="2201"><li><a href="javascript:void(0);" id='1'  class="curr">店内用户</a></li></check:hasAuthority>
                <check:hasAuthority authorityID="2202"><li><a href="javascript:void(0);" id='2' >到达用户</a></li></check:hasAuthority>
                <check:hasAuthority authorityID="2203"><li><a href="javascript:void(0);" id='3' >新增用户</a></li></check:hasAuthority>
                <check:hasAuthority authorityID="2204"><li><a href="javascript:void(0);" id='4' >手机互动用户</a></li></check:hasAuthority>
                <check:hasAuthority authorityID="2205"><li><a href="javascript:void(0);" id='5' >网站互动用户</a></li></check:hasAuthority>
            </ul>
        </div>
    </div>
   <!--内容-->
    <div class="container">
      <div class="article">
        <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
        <div class="section">
        <div class="file_nav">
            <a class="curr" href="javascript:void(0);" name="A" onclick="switchTab(this);switchData();">所有用户</a>
            <a href="javascript:void(0);" name="M"  onclick="switchTab(this);switchData();">会员</a>
            <a href="javascript:void(0);" name="N"  onclick="switchTab(this);switchData();">潜在会员</a>
        </div>
       <div class="marketing_histogram">
          <div class="mark_menu">
              <span>实体店</span>
              <input type="hidden"  value="${shopInfo.shopAndUserInfo.shopId}" id="shopId">
              <input type="hidden"  value="${shopInfo.shopAndUserInfo.userShopEntityId}"    id="shopEntityId">
              <c:if test="${not empty shopInfo.shopAndUserInfo.userShopEntityId}">"javascript:void(0)"</c:if>
              <a  id="fancybox_relate_entity" class="blueBtn fancybox_relate_entity"  href="<c:if test="${not empty shopInfo.shopAndUserInfo.userShopEntityId}">'javascript:void(0)'</c:if> <c:if test="${empty shopInfo.shopAndUserInfo.userShopEntityId}">${basePath}relation.do?method=listRelation&relateType=E&entityId=${shopInfo.shopAndUserInfo.userShopEntityId}</c:if>">选择实体店</a>
              <span>区域</span>
              <input type="hidden"  id="areaId">
              <a  class="blueBtn fancybox_relate_area" href="${basePath}relation.do?method=treeRelation&relateType=I">选择区域</a>
              <a href="javascript:clearData();" class="orangeBtn stampBtn" id="clearButton"  style="width:50px;height: 25px;line-height:25px;margin-left: 20px;">清空数据</a>
          </div>
          <div class="mark_menu" style="display: none;">
              <span>时间类型</span>
           	  <select id="data_type"  name="data_type" class="cur" onchange="switchData();">
           	    <option value="C">实时数据</option>
           	    <option value="H">历史数据</option>
	         </select>
	         <span style="display: none;">统计类型</span>
           	 <select id="time_type"  name="time_type" class="cur" onchange="switchData();" style="display: none;">
           	    <option value="A">指定年</option>
           	    <option value="D">指定小时</option>
           	    <option value="M">指定天</option>
           	    <option value="Y">指定月</option>
	         </select>
	         <span style="display: none;">时间</span>
	         <input id="timeVal" name="timeVal"  type="hidden" />
                 <input class="Wdate" id="time_D" type="text" style="display: none;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',realDateFmt:'yyyy-MM-dd',vel:'timeVal',maxDate:'temp.bsMinDate',onpicked:function(){userStatusHis();}});"/>
                 <input class="Wdate" id="time_M" type="text" style="display: none;" onclick="WdatePicker({dateFmt:'yyyy-MM',realDateFmt:'yyyy-MM',vel:'timeVal',maxDate:'temp.bsMinDate',onpicked:function(){userStatusHis();}});"/>
                 <input class="Wdate" id="time_Y" type="text" style="display: none;" onclick="WdatePicker({dateFmt:'yyyy',realDateFmt:'yyyy',vel:'timeVal',maxDate:'temp.bsMinDate',onpicked:function(){userStatusHis();}});"/>
          </div>
	        <div class="file_first" id = "pic_h" ></div>
	        <div class="file_first" id = "pic_h1" style="display: none;"></div>
		  </div>
		  </div>
          </div>
          <div class="section" style="display: none">
          <div id="table"></div>
          </div>
          </div>
  <!--用户状态-->
 <a style="display: none" class="fancybox"></a>
 <%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>
