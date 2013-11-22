<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户信息统计图</title>
		<script type="text/javascript" src="${imgPath }/common/js/jquery-1.7.1.min.js"></script>
		<script src="${imgPath}/common/hightCharts/highcharts.js"></script>
        <script src="${imgPath}/common/hightCharts/modules/exporting.js"></script>
		<script type="text/javascript">
		var para = "&userType=5" ;
		$(document).ready(function (){
				
		});
		function userType(para){
			$.ajax({
				async:false,
				type:"POST",
				dataType:"json",
				url:"${basePath}userState.do?method=drawing" + para ,
				success:function(data){
					var chartVo = data[0] ;
					var chartVo1 = data[1] ;
					var chartVo2 = data[2] ;
					
					// 生成表格
					lineVo = chartVo.lineVo ;
					lineVo1 = chartVo1.lineVo ;
					lineVo2 = chartVo2.lineVo ;
					var xd = lineVo.xData ;
					var yd = lineVo.yData[0].data ;
					var yd1 = lineVo1.yData[0].data ;
					var yd2 = lineVo2.yData[0].data ;
					createLineToStore("spline",lineVo.tableName,lineVo.subTableName,lineVo.yData[0].name,lineVo1.yData[0].name,lineVo.yName,xd,yd,yd1) ;
					createLineToArea("spline",lineVo1.tableName,lineVo1.subTableName,lineVo1.yData[0].name,lineVo1.yData[0].name,lineVo1.yName,xd,yd,yd1) ;
					createLinePassStore("spline",lineVo2.tableName,lineVo2.subTableName,lineVo2.yData[0].name,lineVo2.yData[0].name,lineVo2.yName,xd,yd,yd2) ;
				}
			})
		}
		// 生成线状图（到店）
	    function createLineToStore(lineId,titleName,subTitleName,yName,yName1,yTitleName,xd,yd,yd1) {
	    	Highcharts.setOptions({
	            global: {
	                useUTC: false
	            }
	        });
	    
	        var chart;
	        $('#lineToStore').highcharts({
	            chart: {
	                type: 'spline',
	                animation: Highcharts.svg, // don't animate in old IE
	                marginRight: 10,
	                events: { 
	                    load: function() {
	    
	                        // set up the updating of the chart each second
	                        var series = this.series[0];
	                        setInterval(function() {
	                        var x = (new Date()).getTime(); // current time
	     				    $.ajax({
	     					async:false,
	     					type:"POST",
	     					dataType:"json",
	     					url:"${basePath}userState.do?method=drawing" + para,
	     					success:function(data){
	     						var chartVo = data[0] ;
	     						// 生成表格
	     						lineVo = chartVo.lineVo ;
	     						var yd = lineVo.yData[0].data ;
	     						var y = Math.random()*60 + 5;
	     						series.addPoint([x, y], true, true);
	     					}
	     				   })
	     						
	                        }, 10000);
	                    }
	                }
	            },
	            title: {
	                text: '到店次数统计'
	            },
	            xAxis: {
	                type: 'datetime',
	                tickPixelInterval: 150
	            },
	            yAxis: {
	                title: {
	                    text: 'Value'
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
	                        Highcharts.numberFormat(this.y, 2)+"人";
	                }
	            },
	            legend: {
	                enabled: false
	            },
	            exporting: {
	                enabled: false
	            },
	            series: [{
	                name: yName,
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        i;
	    
	                    for (i = 0; i <yd.length; i++) 
                        {   
	                    	
                    		data.push({
	                            x: time + (-(yd.length-i)) * 10000,
	                            y: yd[i]
	                        });
                    		
                        }
	                        
	                    return data;
	                })()
	            }]
	        });
	    }
	 // 生成线状图（区域）
	    function createLineToArea(lineId,titleName,subTitleName,yName,yName1,yTitleName,xd,yd,yd1) {
	    	Highcharts.setOptions({
	            global: {
	                useUTC: false
	            }
	        });
	    
	        var chart;
	        $('#lineToArea').highcharts({
	            chart: {
	                type: 'spline',
	                animation: Highcharts.svg, // don't animate in old IE
	                marginRight: 10,
	                events: { 
	                    load: function() {
	    
	                        // set up the updating of the chart each second
	                        var series1 = this.series[0];
	                        setInterval(function() {
	                        var x = (new Date()).getTime(); // current time
	     				    $.ajax({
	     					async:false,
	     					type:"POST",
	     					dataType:"json",
	     					url:"${basePath}userState.do?method=drawing" + para,
	     					success:function(data){
	     						var chartVo1 = data[1] ;
	     						// 生成表格
	     						lineVo1 = chartVo1.lineVo ;
	     						var yd1 = lineVo1.yData[0].data ;
	     						var y = Math.random()*60 + 5;
	     						series1.addPoint([x, y], true, true);
	     					}
	     				   })
	     						
	                        }, 10000);
	                    }
	                }
	            },
	            title: {
	                text: '区域到达人数统计'
	            },
	            xAxis: {
	                type: 'datetime',
	                tickPixelInterval: 150
	            },
	            yAxis: {
	                title: {
	                    text: 'Value'
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
	                        Highcharts.numberFormat(this.y, 2)+"人";
	                }
	            },
	            legend: {
	                enabled: false
	            },
	            exporting: {
	                enabled: false
	            },
	            series: [
	            {name: yName1,
	                data: (function() {
	                    // generate an array of random data
	                	var data = [],
                        time = (new Date()).getTime(),
                        j;
    
                    for (j = 0; j <yd1.length; j++) 
                    {   
                    	
                		data.push({
                            x: time + (-(yd1.length-j)) * 10000,
                            y: yd1[j]
                        });
                		
                    }
                        
                    return data;
	                })()
	            }
	            
	            ]
	        });
	    }
	 // 到达人数
	    function createLinePassStore(lineId,titleName,subTitleName,yName,yName1,yTitleName,xd,yd,yd2) {
	    	Highcharts.setOptions({
	            global: {
	                useUTC: false
	            }
	        });
	    
	        var chart;
	        $('#linePassStore').highcharts({
	            chart: {
	                type: 'spline',
	                animation: Highcharts.svg, // don't animate in old IE
	                marginRight: 10,
	                events: { 
	                    load: function() {
	    
	                        // set up the updating of the chart each second
	                        var series = this.series[0];
	                        setInterval(function() {
	                        var x = (new Date()).getTime(); // current time
	     				    $.ajax({
	     					async:false,
	     					type:"POST",
	     					dataType:"json",
	     					url:"${basePath}userState.do?method=drawing" + para,
	     					success:function(data){
	     						var chartVo = data[2] ;
	     						// 生成表格
	     						lineVo = chartVo.lineVo ;
	     						var yd = lineVo.yData[0].data ;
	     						var y = Math.random()*60 + 5;
	     						series.addPoint([x, y], true, true);
	     					}
	     				   })
	     						
	                        }, 10000);
	                    }
	                }
	            },
	            title: {
	                text: '到达次数统计'
	            },
	            xAxis: {
	                type: 'datetime',
	                tickPixelInterval: 150
	            },
	            yAxis: {
	                title: {
	                    text: 'Value'
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
	                        Highcharts.numberFormat(this.y, 2)+"人";
	                }
	            },
	            legend: {
	                enabled: false
	            },
	            exporting: {
	                enabled: false
	            },
	            series: [{
	                name: yName,
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        i;
	    
	                    for (i = 0; i <yd2.length; i++) 
                        {   
	                    	
                    		data.push({
	                            x: time + (-(yd2.length-i)) * 10000,
	                            y: yd2[i]
	                        });
                    		
                        }
	                        
	                    return data;
	                })()
	            }]
	        });
	    }
		//创建折线图
	    function createLineView() {
	    	new Highcharts.Chart({
	            chart: {
	                renderTo: 'line',
	                type: 'line',
	                marginRight: 130,
	                marginBottom: 25
	            },
	            title: {
	                text: '用户统计线状图',
	                x: -20 //center
	            },
	            subtitle: {
	                text: '年',
	                x: -20
	            },
	            xAxis: {
	                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
	            },
	            yAxis: {
	                title: {
	                    text: '人数（人）'
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        this.x +': '+ this.y +'°C';
	                }
	            },
	            legend: {
	                layout: 'vertical',
	                align: 'right',
	                verticalAlign: 'top',
	                x: -10,
	                y: 100,
	                borderWidth: 0
	            },
	            series: [ {
	                name: '伦敦',
	                data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
	            }]
	        });
	    }
	    //创建饼状图
	    function createPieView() {
	        new Highcharts.Chart({
	            chart: {
	                renderTo: 'pie',
	                plotBackgroundColor: null,
	                plotBorderWidth: null,
	                plotShadow: false
	            },
	            credits:{
	            	enabled:false 
	            },
	            title: {
	                text: '用户统计数据饼状图'
	            },
	            tooltip: {
	        	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
	            	percentageDecimals: 1
	            },
	            plotOptions: {
	                pie: {
	                    allowPointSelect: true,
	                    cursor: 'pointer',
	                    dataLabels: {
	                        enabled: false
	                    },
	                    showInLegend: true
	                }
	            },
	            series: [{
	                type: 'pie',
	                name: '访问人数',
	                data: [
	                    ['2008',   45.0],
	                    ['2009',       26.8],
	                    {
	                        name: '2010',
	                        y: 12.8,
	                        sliced: true,
	                        selected: true
	                    },
	                    ['2011',    8.5],
	                    ['2012',     6.2],
	                    ['2013',   0.7]
	                ]
	            }]
	        });
	    }
	  
 // 选卡事件
    function checkboxClick(obj) {
    	if(obj.checked) {
    		var checkArray = $("input:checkbox") ;
    		for(var i=0;i<checkArray.length;i++) {
    			if(checkArray[i] != obj) 
    				checkArray[i].checked = false ;
    		}
    		var para = "&userType=2" +
    				   "&timeType=" + obj.value + 
    				   "&shopId=55" +
    				   "&shopEntityId=44" +
    				   "&positionId=33" ;
        	$.ajax({
        		async:false,
        		type:"POST",
        		dataType:"json",
        		url:"${basePath}userState.do?method=drawing" + para,
        		success:function(data){
        			var chartVo = data[0] ;
        			// 生成表格
        			lineVo = chartVo.lineVo ;
        			var xd = lineVo.xData ;
        			var yd = lineVo.yData[0].data ;
        			createLine("line",lineVo.tableName,lineVo.subTableName,lineVo.yData[0].name,lineVo.yName,xd,yd) ;
        		}
        	})
    	} else {
    		obj.checked = true ;
    	}
    }
    
</script>
	</head>
	<body>
		<!--<table width="100%">
			<tr>
				<td>
					<hr/>
					<b>统计条件：</b>
					<input type="checkbox"  onclick="checkboxClick(this)" value="Y" /> 年
					<input type="checkbox"  onclick="checkboxClick(this)" value="M"/> 月
					<input type="checkbox"  onclick="checkboxClick(this)" value="D"/> 日
					<input type="checkbox"  onclick="checkboxClick(this)" value="W"/> 周
					<input type="checkbox"  onclick="checkboxClick(this)" value="H"/> 时
				</td>
			</tr>
			 
			<tr>
				<td>
					<input type="button" onclick="createPieView()" value="生成饼状图" />
					<input type="button" onclick="createLineView()" value="生成折线状图" />
				</td>
			</tr> 
		</table>-->
		<input type="button" onclick="userType('&userType=10')" value="店内用户" />
		<input type="button" onclick="userType('&userType=11')" value="店内会员" />
		<input type="button" onclick="userType('&userType=12')" value="手机互动会员" />
		<input type="button" onclick="userType('&userType=13')" value="网店互动会员" />
		<input type="button" onclick="userType('&userType=5')" value="新增会员" />
		<hr/>
		<div id="lineToStore" style="min-width: 400px; height: 200px; margin: 0 auto"></div>
		<hr/>
		<div id="lineToArea" style="min-width: 400px; height: 200px; margin: 0 auto"></div>
		<hr/>
		<div id="linePassStore" style="min-width: 400px; height: 200px; margin: 0 auto"></div>
	</body>
</html>
