<#escape x as x!>
<div class="rightTitle">
 	<span>${shopVo.wordNames['gmsc076']}</span>
</div>
<div class="conditions_content">
	<div class="title">${shopVo.wordNames['gmsc078']}</div>
	<div class="natural_quality">
		<p>
			<span>${shopVo.wordNames['gmsc082']}</span>
			<select name="crowdId" onchange="chooseHis();">
				<option value="">--${shopVo.wordNames['gmsc058']}--</option>
				<#if crowdList??>
				<#list crowdList as temp>
					<option value="${temp.crowdId }" dir="${temp.crowdDesc}" <#if crowdId?? && (crowdId == temp.crowdId)>selected="selected"</#if>>${temp.crowdName}</option>
				</#list>
				</#if>
			</select>
			<font id="descript" style="padding: 3px; line-height:20px; color: gray;">${crowdName!}</font>
			<input type="hidden" name="crowdName" value="${crowdName!}"/>
		</p>
	</div>
</div>
<div id="history2" style="display:<#if crowdId??>'none'<#else>'block'</#if>;" >
	<#include "user_property_history.ftl">
</div>
<div class="conditions_content">
	<div class="title">
		<a href="javascript:void(0);" class="add_btn orangeBtn" onclick="getPageUserAccount();">查看详细</a>
		<a href="javascript:void(0);" class="add_btn orangeBtn" onclick="getTotalCount();" style="margin-right: 15px;">查看总数</a>
		已选人群&nbsp;&nbsp;&nbsp;&nbsp;（<samp id="totalCount">0</samp>）人
	</div>
</div>
</#escape>