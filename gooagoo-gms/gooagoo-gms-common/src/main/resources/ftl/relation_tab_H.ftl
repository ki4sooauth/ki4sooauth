<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<#if selectType=='M'>
		  	<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
        <th width="20%">${shopVo.wordNames['gmsb145']}</th>
	  	<th width="20%">${shopVo.wordNames['gmsb146']}</th>
	  	<th width="20%">${shopVo.wordNames['gmsb147']}</th>
	  	<#if selectType!='M'>
	  		<th width="13%">${shopVo.wordNames['gmsc130']}</th>
	  	</#if>
	</tr>
	<#if pm.count!=0>
		<#list pm.result as itemChild>
			<tr>
				<#if selectType=='M'>
					<td><input style="height: 24px;" type="checkbox" class="singleSelect"/></td>
				</#if>
				<td>${itemChild.eventName}</td>
				<td>${(itemChild.channelName)!}</td>
				<td>${itemChild.eventTarget}</td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="H"/>
					<input type="hidden" name="relate_data" value="${itemChild.eventId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.eventName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.eventTarget}"/>
				</td>
			</tr>
		</#list>
		<tr>
			<td colspan="4">
			 	<#include "common_page.ftl">
			</td>
		</tr>
	<#else>
		<tr style="height:30px;">
			<td colspan="6"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</#if>
</table>
<#if selectType=='M'>
	<div class="commitBnt">
		<a href="javascript:void(0);" onclick="selectMult(); " class="submit blueBtn">${shopVo.wordNames['gmsc129']}</a>
	</div>
</#if>