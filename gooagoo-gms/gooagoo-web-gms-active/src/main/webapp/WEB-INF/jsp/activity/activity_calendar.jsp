<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<link href='${imgPath}/gms/common/css/fullcalendar.css' rel='stylesheet' />
<link href='${imgPath}/gms/common/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='${imgPath}/gms/common/js/jquery-ui-1.10.2.custom.min.js'></script>
<script src='${imgPath}/gms/common/js/fullcalendar.min.js'></script>

<script>
// $(document).ready(function() {
// 	var fc = ${fullCalendar};
// });
function initCalendar(fc){
	if(isEmpty(fc)){
		return ;
	}
	$('#calendar').fullCalendar({
		monthNames: fc.monthNames,  
		monthNamesShort: fc.monthNamesShort,  
		dayNames: fc.dayNames,  
		dayNamesShort: fc.dayNamesShort,  
		today: fc.today,  
		buttonText: fc.buttonText,
		contentHeight: 200,
		timeFormat:"yyyy-MM-dd",
		titleFormat:{
		    month: fc.titleFormat.month
		},
		dayRender: function( date, cell ) {
			var d = $.fullCalendar.formatDate(date,'yyyy-MM-dd');
			var event = $("#calendar").fullCalendar("clientEvents",date);
			if(event!=null && event.length>0){
				return;
			}
			var t = getActivityNum(fc.data,d);
			if(t==0){
				return;
			}
			var calEvent = {
					id: date,
					start: date,
					title: t+""
			};
			var copiedEventObject = $.extend({}, calEvent);
			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
		},
		eventClick: function(calEvent, jsEvent, view) {
			var d = $.fullCalendar.formatDate(calEvent.start,'yyyy-MM-dd');
			$("#activityTime").val(d);
			page(1);
		},
		eventMouseover: function(calEvent, jsEvent, view) {
			var d = $.fullCalendar.formatDate(calEvent.start,'yyyy-MM-dd');
			var c = getActivityDayDes(fc.data,d);
			if(c==""){
				return;
			}
			$("#tipConent").html(c);
			$("#tipConent").css("display","block").css("left",jsEvent.pageX+15).css("top",jsEvent.pageY+15);
		},
		eventMouseout:function( event, jsEvent, view ) {
			$("#tipConent").html("");
			$("#tipConent").css("display","none");
		},
		editable: false,//是否可拖拽
		events: fc.events
	});
}
function getActivityNum(activityList,thisDay){
	var counter=0;
	for(var i in activityList)
	{
		var beginTime = activityList[i].start;
		var end_time = activityList[i].end;
		if(thisDay >= beginTime && thisDay <= end_time)
		{
			counter++;
		}
	}
	return counter;
}
function getActivityDayDes(activityList,thisDay){
	var counter=0;
	var content="";
	for(var i in activityList)
	{
		var beginTime = activityList[i].start;
		var end_time = activityList[i].end;
		if(thisDay >= beginTime && thisDay <= end_time)
		{
			counter++;
			content += "活动"+counter+"："+activityList[i].name+"<br/>";
		}
	}
	return content;
}
</script>
<style>
 	#calendar {
	 	width: 980px; 
	 	margin: 0 auto;
	 	margin-top: 5px; 
	 	text-align: center; 
	 	font-size: 14px; 
	 	font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif; 
 	} 
	.fc-event-inner{
/* 		background-color: #AEACAC; */
		cursor:pointer;
	}
	.fc-event {
    	border: 1px solid #9EB3D2;
    }
	.fc-day-header {
	    color: #666666;
	    font-family: Arial;
	    height: 35px;
	    line-height: 35px;
	}
	.fc-week {
	    height: 30px;
	    line-height: 30px;
	}
	.fc-border-separate tr.fc-last th {
	    background: none repeat scroll 0 0 #EEEEEE;
	    border-top-color: #EEEEEE;
	    border-top-width: 5px;
	}
	
	.fc-border-separate tr.fc-last td {
	    border-bottom-color: #EEEEEE;
	    border-bottom-width: 5px;
	}
	.fc-border-separate th.fc-first, .fc-border-separate td.fc-first {
	    border-left-color: #EEEEEE;
	    border-left-width: 5px;
	}
	.fc-border-separate th.fc-last, .fc-border-separate td.fc-last {
	    border-right-color: #EEEEEE;
	    border-right-width: 5px;
	}
</style>
<!-- </head> -->
<!-- <body> -->
<div id="tipConent" style="position:absolute;z-index:999;background-color:#EEEEEE;border:1px solid #AAAAAA; border-radius:3px;display:none;padding:10px;"></div>
<div id='calendar'></div>
<!-- </body> -->
<!-- </html> -->