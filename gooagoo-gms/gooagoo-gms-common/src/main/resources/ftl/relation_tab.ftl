<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common-check.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/relate.js"></script>
<script type="text/javascript" src="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.js"></script>
<link href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/member/css/voucher_list.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.fileTable td{
		height: 10px;
	}
</style>
<script type="text/javascript">
	$(function(){
		initTab();
	});
</script>
<div class="voucher_list" style="width: 95%;">
<input type="hidden" value="${tabType}" name="tabType" id="tabType" />
<input type="hidden" value="${selectType}" name="selectType" id="selectType" /> 
<input type="hidden" value="${dataType}" name="dataType" id="dataType" /> 
<input type="hidden" value="" name="relateType" id="relateType" /> 
<input type="hidden" value="${activityId}" name="activityId" id="activityId" /> 
<input type="hidden" value="${entityId}" name="entityId" id="entityId" /> 
<input type="hidden" value="${channelCode}" name="channelCode" id="channelCode" /> 
<input type="hidden" value="${callback}" name="callback" id="callback" /> 
<input type="hidden" value="${marketingId}" name="marketingId" id="marketingId" /> 
	<div class="file_nav" id="relationTabs">
		<#list  tabMap?keys as tabkey>
			<a id="tab_${tabkey}" onclick="selectTab('${tabkey}');" href="javascript:void(0);">${tabMap[tabkey]}</a>
		</#list>
	</div>
	<div id="waitRelateCont"></div>
</div>