<script>
	function tabContent(channelCode){
		$("#activityContTabForm").html("");
		$("#activityContTabForm").append("<input type='hidden' name='channelCode' value='"+channelCode+"'/>");
		$("#activityContTabForm").append("<input type='hidden' name='method' value='addContform'/>");
		$("#activityContTabForm").append("<input type='hidden' name='activityId' value='${activityId}'/>");
		$("#activityContTabForm").append("<input type='hidden' name='contId' value='${contId}'/>");
		
		$("#activityContTabForm").submit();
	}
</script>
<div style="display:none">
	<form id="activityContTabForm" action="${basePath }activityCont.do" method="post"></form>
</div>
<div class="rightTitle">
    <span>${shopVo.wordNames['gmsc209']}</span>
</div>
<div class="top_menu" style="padding: 20px 0 10px 20px;">
	<ul>
		<!-- 渠道 -->
		<#if channels??>
			<#list channels as itemChild>
    		<li class="li">
    			<a id="channel_${itemChild.code}" <#if operateType="A">onclick="tabContent('${itemChild.code}');"</#if> href="javascript:void(0);" <#if itemChild.code==channelCode>class="curr"</#if> >${itemChild.name}</a>
    		</li>
    		</#list>
    	</#if>
    </ul>
</div>
<div class="rightTitle">
	<span>${channelName}内容</span>
</div>