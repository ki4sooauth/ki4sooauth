<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="${imgPath}/gms/common/css/datepicker-ui.css" />
<script type="text/javascript" src="${imgPath}/gms/common/js/datepicker-zh-CN.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/datepicker-ui.js"></script>

<div class="DatePicker"></div>
<div class="dateActivityList"></div>
<script type="text/javascript">
    /**
	* 日期控件
	* activityList:JSON数据，其中日期不能为英文格式
	*/
	function datePickerCalendar(activityList){
    	// 对象不能为空,不能为null,不能未定义且必须是对象
    	if(typeof(activityList) != "undefined" && activityList != "" && activityList != null && typeof(activityList) == "object"){
    		var flag = true;
    	}else{
    		var flag = false;
    	}
		var curYear = new Date().getFullYear();
		$(".DatePicker").datepicker({
			yearRange: curYear+':'+curYear,
			showButtonPanel: true,// 添加今天按钮
			prevText: "上个月", 
			nextText: "下个月", 
			currentText: "<font color='red'><strong>今天</strong></font>", 
			monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"], 
			monthNamesShort: ["一","二","三","四","五","六","七","八","九","十","十一","十二"], 
			dayNames: ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
			dayNamesShort: ["周日","周一","周二","周三","周四","周五","周六"],
			dayNamesMin: ["<font color='#F27783'>日</font>","<font color='#707070'>一</font>",
			              "<font color='#707070'>二</font>","<font color='#707070'>三</font>",
			              "<font color='#707070'>四</font>","<font color='#707070'>五</font>",
			              "<font color='#F27783'>六</font>"],
			weekHeader: "周",
			dateFormat: "yy-mm-dd",
			firstDay: 1,
			isRTL: false,
			showMonthAfterYear: true,
			yearSuffix: "年",
			beforeShowDay: function(date)
			{
				var thisDay = date.getTime();
				var counter = 0;
				var content = "\n";
				if(flag){
					for(var i in activityList)
					{
						var beginTime = getDate((activityList[i].startTimeStr == null?"":activityList[i].startTimeStr).split(" ")[0]).getTime();
						var end_time = getDate((activityList[i].endTimeStr == null?"":activityList[i].endTimeStr).split(" ")[0]).getTime();
						if(thisDay >= beginTime && thisDay <= end_time)
						{
							counter++;
							content = content +"活动"+counter+"："+activityList[i].activityName+"\n";
							continue;
						}
					}
				}
				if(counter > 0)
				{
					var addtionCls = 'activity_count_has';
					return [true, 'hasActivity '+addtionCls, '点击查看活动详细列表'+content];
				}
				else
				{
					return [false, 'noActivity', '没有活动'];
				}
			},
			onSelect: function(text, instance)
			{
				var arr = text.split('-');
				var year = arr[0], month = arr[1], day = arr[2];
				var thisDay = new Date(year, month-1, day, 0, 0, 0);
// 				var dialogTitle = text+'的活动内容';
// 				var curDateActivityList = [];
// 				var dialogHeight = 40;
				for(var i in activityList)
				{
					var beginTime = getDate((activityList[i].startTimeStr == null?"":activityList[i].startTimeStr).split(" ")[0]).getTime();
					var end_time = getDate((activityList[i].endTimeStr == null?"":activityList[i].endTimeStr).split(" ")[0]).getTime();
					if(thisDay >= beginTime && thisDay <= end_time)
					{
						
						window.location.href="${webLink}/activity.do?method=index&activityTime="+year+"-"+month+"-"+day;
// 						curDateActivityList.push("<a title='点击查看详情' href='javascript:void(0);' >" + activityList[i].activityName + "</a>&nbsp;&nbsp;<span style='color:#888;'>主题:" + activityList[i].title + "</span><br />");
// 						dialogHeight += 35;
					}
				}
// 				$(".dateActivityList").html(curDateActivityList.join('')).dialog({title:dialogTitle, height:dialogHeight});
// 				$(".dateActivityList").dialog("open");
				return false;
		    }
		});
	}
	/**
	* 字符串转日期格式，strDate要转为日期格式的字符串（英文格式无效）
	* 日期格式：yyyy-MM-dd HH:mm:ss
	*/
	function getDate(strDate) {
		var strDate = strDate.replace(/[/.]/g,"-");
		var array = strDate.replace(/\d+(?=-[^-]+$)/, function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g);
		var date = new Date(array[0], array[1], array[2], 0, 0, 0);
        return date;
    }
</script>
<style type="text/css">
	.ui-datepicker {/*227行*/
		width: 17.5em;
		/*height: 19em;*/
		padding: .3em .3em 0;
		display: none;
		color:#555555;
	}
	.ui-state-error,
	.ui-widget-content .ui-state-error,
	.ui-widget-header .ui-state-error {/*883行*/
		border: 1px solid #cd0a0a;
		background: #fef1ec url(images/ui-bg_glass_95_fef1ec_1x400.png) 50% 50% repeat-x;
		color: #cd0a0a;
	}
	.ui-widget-header .ui-icon {/*935行*/
		background-image: url(${imgPath}/gms/common/images/ui-icons_222222_256x240.png);
	}
	.ui-state-default .ui-icon {/*938行*/
		background-image: url(${imgPath}/gms/commonimages/ui-icons_888888_256x240.png);
	}
	.ui-state-hover .ui-icon,
	.ui-state-focus .ui-icon {/*941行*/
		background-image: url(${imgPath}/gms/common/images/ui-icons_454545_256x240.png);
	}
	.ui-state-disabled, .ui-widget-content .ui-state-disabled, .ui-widget-header .ui-state-disabled {
	    background-image: none;
	    opacity: 0.50;
	}
</style>