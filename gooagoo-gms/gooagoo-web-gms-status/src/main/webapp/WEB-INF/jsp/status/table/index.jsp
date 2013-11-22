<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsb195']}</title>
<%
request.setAttribute("topMenuCode", "11");
request.setAttribute("leftMenuCode", "1109");
%>
 <%@include file="/WEB-INF/jsp/common/top.jsp"%>
 <script type="text/javascript" src="${imgPath}/gms/status/js/status.js"></script>
 <script type="text/javascript">
  var cbody=true;
  var basePath = '${basePath}'; 
  var chart;
  var xCodes;
  $(document).ready(function(){
	  	initActivityCalendar();

	  initFancyBox("fancybox_relate",850,550,true);
	  initFancyBox("fancybox_table",800,550,true);
	  sumTableType();
  });
  function selectEntity(){
	  var url = "${basePath }relation.do?method=listRelation&relateType=E&dataType=";
	  $("#fancybox_relate").attr("href",url).click();
   }
  function detailTable(tableTypeCode){
	  var shopEntityId = $("#shopEntityId").val();
	  if(isEmpty(shopEntityId)||isEmpty(tableTypeCode)){
			return ;
	  }
	  var url = "${basePath }table.do?method=tableDetail&tableTypeCode="+tableTypeCode+"&shopEntityId="+shopEntityId;
	  $("#fancybox_table").attr("href",url).click();
   }
  function dealRelations(relations){
	 $("#shopEntityId").val(relations[0][1]);
	 $("#entityName").html(relations[0][2]);
	 sumTableType();
	 $.fancybox.close();
  }
  function sumTableType(){
	var shopEntityId = $("#shopEntityId").val();
	if(isEmpty(shopEntityId)){
		return ;
	}
	var data="&method=sumMarketingTableByType&shopEntityId="+shopEntityId;
	$.ajax({
		async : false,
		type : "POST",
		dataType : "json",
		data:data,
		url : basePath + "table.do",
		success : function(data) {
		 if(!isEmpty(data)){
			 xCodes = data.xCode;
			 createChart(data);
		 }
		}
	});
  }
  function getXCode(index){
	  if(index<0||isEmpty(xCodes)||xCodes.length<index+1){
		  return "";
	  }
	  return xCodes[index];
  }
  function createChart(obj) {
    chart = new Highcharts.Chart({
            chart: {
                renderTo: 'hightCharts',
                type: 'column'
            },
            credits:{
            	enabled:false 
            },
            exporting :{
                enabled:false	
            },
            title: {
                text: obj.tableName
            },
            xAxis: {
                categories: obj.xData
            },
            yAxis: {
                min: 0,
                title: {
                    text: obj.yName
                }
            },
            tooltip: {
                formatter: function() {
                    return ''+
                        this.series.name +': '+ this.y +' ('+ Math.round(this.percentage) +'%)';
                }
            },
            plotOptions: {
                column: {
                    stacking: 'percent'
                },
				series : {
					cursor : 'pointer',
					point : {
						events : {
							click : function() {
								var code = getXCode(this.x);
								detailTable(code);
							}
						}
					}
				}
            },
            series: obj.yDataVos
        });
  }
  function closeFancybox(){
	  $.fancybox.close();
  }
 </script>
</head>
<body>
   <!--头部-->
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
   <div style="display:none;">
   <a id="fancybox_relate" class="fancybox_relate" href="#"></a>
   <a id="fancybox_table" class="fancybox_table" href="#"></a>
   </div>
    <div class="container">
      <div class="article">
      	<div class="date_box">
			<%@include file="/WEB-INF/jsp/common/datepicker.jsp"%>
        </div>
        <div class="section">
            <div class="rightTitle">
             <span>${shopVo.wordNames['gmsb195']}</span>
            </div>
         	<div class="marketing_histogram">
                <div class="mark_menu">
                    <span>${shopVo.wordNames['gmsb196']}</span>
                    <input type="hidden" id="shopEntityId" value="${shopEntityId}" />
                    <a style="min-width: 100px; width: auto;" id="entityName" ${entityNum!='1' ? 'onclick=\"selectEntity();\"' : ''} class="blueBtn" href="javascript:void(0);" name='entity'>${empty entityName ? shopVo.wordNames['gmsb197']: entityName}</a>
                 </div>
                <div id="obj">
                </div>
                 <div id="hightCharts">
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
