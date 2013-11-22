<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style type="text/css">
.marketing_histogram .mark_menu a.blueBtn {
	float: left;
	height: 25px;
	line-height: 25px;
	min-width: 100px;
	width: auto;
	padding: 0 10px;
	overflow-x: hidden;
	overflow-y: hidden;
}
</style>
<script type="text/javascript"
	src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<c:if
	test="${pageFlag eq 'activity' or pageFlag eq 'goods' or pageFlag eq 'category' or pageFlag eq 'brand' or pageFlag eq 'coupon' or pageFlag eq 'cryout'or pageFlag eq 'notice'}">
	<div class="histogram_nav">
		<a href="#" class="curr" id="*">${shopVo.wordNames['gmsb096']}</a> <a
			href="#" id="1">${shopVo.wordNames['gmsb097']}</a> <a href="#" id="3">${shopVo.wordNames['gmsb098']}</a>
	</div>
</c:if>
<div class="marketing_histogram" style="min-height: 80px;">
	<form id="statusForm">
		<div class="mark_menu">
			<input type="hidden" id="source" name='source' value="*" /> <input
				type="hidden" id="name" name="name" value="${pageFlag}" /> <input
				type="hidden" id="chartName" name="chartName" value="${parentName}" />
			<input type="hidden" id="timeTypeVal" name="timeTypeVal" value="H" />
			<input type="hidden" value="${shopId}" name="shopId" id="shopId" />
			<c:if
				test="${(pageFlag eq 'goods' or pageFlag eq 'category' or  pageFlag eq 'brand') && !isEntity}">
				<span style="padding: 0 8px;">实体店</span>
				<select id="entityId" name="entityId" onchange="changeSelect()"
					style="width: 100px;">
					<option value="">--请选择--</option>
					<c:forEach items="${entityList}" var="entity">
						<option value="${entity.shopEntityId}">${entity.shopEntityName}</option>
					</c:forEach>
				</select>
			</c:if>
			<c:if
				test="${(pageFlag eq 'goods' or pageFlag eq 'category' or  pageFlag eq 'brand') && isEntity}">
				<input type="hidden" value="${entityId}" name="entityId"
					id="entityId" />
			</c:if>
			<span style="padding: 0 8px;"> <c:if
					test="${pageFlag eq 'activity' }">
               		${shopVo.wordNames['gmsb099']}
                </c:if> <c:if test="${pageFlag eq 'goods'}">
                    ${shopVo.wordNames['gmsb017']}
                </c:if> <c:if test="${pageFlag eq 'category'}">
                    ${shopVo.wordNames['gmsb034']}
                </c:if> <c:if test="${pageFlag eq 'brand'}">
                    ${shopVo.wordNames['gmsb041']}
                </c:if> <c:if test="${pageFlag eq 'coupon'}">
                    ${shopVo.wordNames['gmsb048']}
                </c:if> <c:if test="${pageFlag eq 'tool'}">
                    ${shopVo.wordNames['gmsb070']}
                </c:if> <c:if test="${pageFlag eq 'cryout'}">
              	  	 吆喝内容 
              	</c:if> <c:if test="${pageFlag eq 'notice'}">
            	         通知内容 
            	</c:if>
			</span>
			<c:if
				test="${pageFlag eq 'activity' or pageFlag eq 'goods' or pageFlag eq 'category' or pageFlag eq 'brand' or pageFlag eq 'coupon' or pageFlag eq 'tool' or pageFlag eq 'cryout' or pageFlag eq 'notice'}">
				<input type="hidden" id="parentId" name='parentId'
					value="${parentId}" />
				<a class="blueBtn" id="parentName" onclick="selectParent();"
					href="javascript:void(0)">${empty parentName?
					shopVo.wordNames['gmsb018']:parentName}</a>
			</c:if>
		</div>
		<div class="mark_menu"
			style="display:${pageFlag eq 'tool' or pageFlag eq 'cryout' or pageFlag eq 'notice' ? 'none' :'block'}">
			<c:if
				test="${pageFlag eq 'activity' or pageFlag eq 'goods' or pageFlag eq 'category' or pageFlag eq 'brand'  or pageFlag eq 'coupon'}">
				<span style="padding: 0 8px;">${shopVo.wordNames['gmsb100']}</span>
				<select id="channelCode" name="channel" onchange="changeSelect()"
					style="width: 100px;">
					<option value="">全部</option>
					<option value="1">吆喝</option>
					<option value="2">通知</option>
					<option value="5">购好奇</option>
					<option value="6">手机服务</option>
				</select>
			</c:if>
			<c:if test="${pageFlag eq 'activity' or pageFlag eq 'goods' or pageFlag eq 'category' or pageFlag eq 'brand' or pageFlag eq 'coupon'}">
				<span style="padding: 0 8px;">
	              	  	${shopVo.wordNames['gmsb107']}
				</span>
				<input type="hidden" id="childId" name="childId" value="${childId}" />
				<a class="blueBtn" id="childName" href="javascript:void(0)"
					onclick="selectChild();">${not empty childName?
					childName:shopVo.wordNames['gmsb101']}</a>
					<a
						style="width: 100px; height: 25px; line-height: 25px; margin-left: 20px;"
						id="clearButton"
						onclick="$('#childName').html('${shopVo.wordNames['gmsb018']}');$('#childId').val('');$('#name').val('activity');"
						class="orangeBtn stampBtn" href="javascript:void(0);">清空活动内容</a>
				</c:if>
		</div>
		<div class="mark_menu">
			<span style="padding: 0 8px;">时间类型</span> <select id="timeTypeSelect"
				name="hisOrCurr" onchange="changeTimeType()" style="width: 100px;">
				<option value="C">实时数据</option>
				<option value="H">历史数据</option>
			</select> <span style="padding: 0 8px;">统计类型</span> <select class="his"
				name="timeType" onchange="changeSelect()" id="history"
				style="display: none; width: 100px;">
				<option value="A">指定年</option>
				<option value="Y">指定月</option>
				<option value="M">指定天</option>
				<option value="D">指定小时</option>
			</select> <select class="cur" name="timeType" onchange="changeSelect()"
				id="current" style="width: 100px;">
				<option value="H">当前小时</option>
				<option value="D">当天</option>
				<option value="W">当周</option>
				<option value="M">当月</option>
			</select> <input id="timeVal" name="timeVal" type="hidden" /> <input
				class="Wdate" id="time_D" type="text"
				style="width: 100px; display: none; float: left;"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd',realDateFmt:'yyyy-MM-dd',vel:'timeVal',maxDate:'temp.bsMinDate',onpicked:function(){getStatus();}});" />
			<input class="Wdate" id="time_M" type="text"
				style="width: 100px; display: none; float: left;"
				onclick="WdatePicker({dateFmt:'yyyy-MM',realDateFmt:'yyyy-MM',vel:'timeVal',maxDate:'temp.bsMinDate',onpicked:function(){getStatus();}});" />
			<input class="Wdate" id="time_Y" type="text"
				style="width: 100px; display: none; float: left;"
				onclick="WdatePicker({dateFmt:'yyyy',realDateFmt:'yyyy',vel:'timeVal',maxDate:'temp.bsMinDate',onpicked:function(){getStatus();}});" />
			<span class="his" style="display: none; padding: 0 8px;">用户类型</span>
			<select class="his" style="display: none; width: 100px;"
				name="userType" onchange="getStatus();">
				<option value="A">所有用户</option>
				<option value="M">会员</option>
				<option value="N">潜在会员</option>
			</select>
		</div>
	</form>
	<div id="obj"></div>
	<div id="hightCharts" style="display: none;"></div>
</div>
<a style="display: none;" class="entity_relate" id='entity_relate'></a>
<script type="text/javascript">
    var diff_server_time = new Date() - ${serverTime};
	$(document).ready(function(){
	 	initFancyBox("entity_relate",800,600,true);
	 	$("#timeTypeSelect").val("C");
	 	$("#source").val("*");
	 	$("#timeTypeVal").val($("select[name='timeType']:visible").val());
	 	showActivtiyContent();
	 	getStatus();
 	});
</script>