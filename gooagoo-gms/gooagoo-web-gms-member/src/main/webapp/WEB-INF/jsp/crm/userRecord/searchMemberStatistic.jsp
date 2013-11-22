<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
.selectBox ul{width:100%;}
.selectBox ul li{width:230px;margin:0;}
</style>
<form id="conditionForm">
	<div class="conditions_content">
		<div class="title">${shopVo.wordNames['gmsc078']}</div>
		<div class="natural_quality">
			<p>
				<span>${shopVo.wordNames['gmsc082']}</span> <select name="crowdId" onchange="changeCrowdValue(this);">
					<option value="">${shopVo.wordNames['gmsc058']}</option>
					<option value="ALL_USER">全部用户</option>
					<option value="IN_STORE_USER">店内用户</option>
					<option value="IN_STORE_MEMBER">店内会员</option>
					<option value="PHONE_INTERACTION_MEMBER">店外手机互动会员</option>
					<option value="WEB_INTERACTION_USER">店外Web互动用户</option>
					<option value="WEB_INTERACTION_MEMBER">店外Web互动会员</option>
					<option value="NEW_USER">新增用户</option>
					<option value="NEW_MEMBER">新增会员</option>
					<c:forEach items="${crowdList}" var="temp">
						<option value="${temp.crowdId }" dir="${temp.crowdDesc}">${temp.crowdName}</option>
					</c:forEach>
				</select><font id="descript" style="padding: 3px; color: gray;"></font><input type="hidden" name="crowdName" value="" />
			</p>
		</div>
</div>		
		${condition}
<div class="conditions_content">		
		<div class="natural_quality" style=" border-top: 1px solid #9EB3D3;">
			<p> 
			    <input type="hidden" name="chartName" id="chartName">
				<span>${shopVo.wordNames['cpmf013']}</span> <select
					name="statisticType" onfocus="$('#statMsg').html('');" onchange="getChartName(this)">
					<option value="">---${shopVo.wordNames['gmsc058']}---</option>
					<c:forEach items="${typeList}" var="type">
						<option value="${type.codeType}_${type.code}">${type.name}</option>
					</c:forEach>
				</select><label style="color: red;" id="statMsg"></label>
			</p>
		</div>
		<div class="conditionFormClear">
			<a href="javascript:void(0)" class="blueBtn commitBtn"
				onclick="searchStatistic();">${shopVo.wordNames['cpmf010']}</a> <a
				href="#editName" class="blueBtn commitBtn fancybox_save">${shopVo.wordNames['cpmf011']}</a>
		</div>
	</div>
</form>
<div id="container"></div>
<div id="hidden" style="display: none;">
	<div class="stampBox">
		<a href="javascript:$('#hidden').printArea();" class="orangeBtn stampBtn">${shopVo.wordNames['cpmf089']}</a>
	</div>
	<div class="stampTitle">报告名称：购物周期分析</div>
	<div class="stampTitleSon">
		<span class="sonL">统计人：王某</span> <span class="sonR">统计类型：会员</span>
	</div>
	<div class="stampTitleSon">
		<span class="sonL">统计时间：2013年5月31日</span> <span class="sonR">统计样本数：0</span>
	</div>
	<table width="100%" border="0" cellspacing="1" cellpadding="0"
		class="stampTable">
		<tr>
			<td>频 率</td>
			<td>一周数次</td>
			<td>一周一次</td>
			<td>一月1-2次</td>
			<td>无规律</td>
		</tr>
		<tr>
			<td>人 数</td>
			<td>500</td>
			<td>1000</td>
			<td>1500</td>
			<td>2000</td>
		</tr>
	</table>
</div>
<div style="display: none;">
	<form action="" id="editName">
		<div class="natural_quality">
			<p style="height: 50px;">
				<span>名称</span><input type="text" name="groupName"
					onfocus="$('#message').html('');" style="width: 190px"><br />
				<label id="message"
					style="color: red; clear: both; display: block; padding: 5px 0 0 72px;"></label>
			</p>
		</div>
		<a class="blueBtn savebtn"
			style="cursor: pointer; height: 30px; width: 50px; margin-top: 0px;"
			href="javascript:saveUserDefinedStatisticType();">保存</a>
	</form>
</div>
<a style="display: none" id="relaTreeFancybox" class="fancybox_tree"></a>
<a style="display: none"  id = "relaListFancybox" class="fancybox_list"></a>
<a style="display: none"  id = "fancybox_user_list" class="fancybox_user_list"></a>
<a style="display: none"  href="#loading"  class="fancybox_loading"></a>
<div style="display: none;">
   <div style="width:50px;height:50px" id="loading">
	<div  class="loading-small" style="margin-top:15px;"></div>
   </div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		initShopActionList();
		//初始化弹出层
		initFancyBox("fancybox_tree",240,450,false);
		initFancyBox("fancybox_list",800,500,false);
		initFancyBox("fancybox_user_list",850,500,false);
		initloading();
		chooseActType();
		deleteAction();
		sFlag="S";
		$(".fancybox_save").fancybox({
			'scrolling' : 'no',
			'titleShow' : false,
			'onClosed' : function() {
				$("input[name='groupName']").html("");
			},
			'onStart' : function() {
				var stype = $("select[name='statisticType']").val();
				if (isEmpty(stype)) {
					$("#statMsg").html("请选择统计类型");
					return false;
				}

			}
		});
	});
	function changeCrowdValue(obj){
	  var desc = $(obj).find("option:selected").attr("dir");
	  $("#descript").html(desc); 	
	  $("input[name='crowdName']").val($(obj).val()); 	
	}	
</script>
