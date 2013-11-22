<style type="text/css">
	.condition{	border: 1px solid #A5ACB2; height: 20px; line-height: 20px; margin-right: 5px; width: 110px;}
</style>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="4" style="text-align: left; padding-left: 10px;">
			<span>内容名称：</span>
			<input style="height:20px;width:315px;" name="fname" value="${fname}" id="fname"><br/><br/>
			<span>${shopVo.wordNames['gmsc137']}：</span>
			<select class="condition" id="channelType" style="margin-right: 20px;" >
				<option value="">--${shopVo.wordNames['gmsc058']}--</option>
				<option value="W" <#if channelType == 'W'>selected="selected"</#if>>${shopVo.wordNames['gmsc139']}</option>
				<option value="M" <#if channelType == 'M'>selected="selected"</#if>>${shopVo.wordNames['gmsc140']}</option>
			</select>
			<span>${shopVo.wordNames['gmsc138']}：</span>
			<select class="condition" id="cmsContentType" >
				<option value="">--${shopVo.wordNames['gmsc058']}--</option>
				<option value="C" <#if cmsContentType == 'C'>selected="selected"</#if>>${shopVo.wordNames['gmsc141']}</option>
				<option value="A" <#if cmsContentType == 'A'>selected="selected"</#if>>${shopVo.wordNames['gmsc142']}</option>
			</select>
			<div style="float: right; padding-right: 50px;">
				<input type="button" onclick="page(1)" value="${shopVo.wordNames['gmsc006']}"/>				
				<input type="button" onclick="clearCmsContentPage();" value="${shopVo.wordNames['gmsc007']}"/>
			</div>
		</td>
	</tr>
	<tr>
	  	<#if selectType=='M'>
	  		<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
		<th width="30%">${shopVo.wordNames['gmsc136']}</th>
	    <th width="13%">${shopVo.wordNames['gmsc137']}</th>
	    <th width="13%">${shopVo.wordNames['gmsc138']}</th>
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
				<td >${itemChild.cmsContentName}</td>
				<td >
	           		 <#if itemChild.channelType=='W'>${shopVo.wordNames['gmsc139']}</#if>
	           		 <#if itemChild.channelType=='M'>${shopVo.wordNames['gmsc140']}</#if>
				</td>
				<td >
	           		 <#if itemChild.cmsContentType=='C'>${shopVo.wordNames['gmsc141']}</#if>
	           		 <#if itemChild.cmsContentType=='A'>${shopVo.wordNames['gmsc142']}</#if>
				</td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="O"/>
					<input type="hidden" name="relate_data" value="${itemChild.cmsContentId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.cmsContentName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.channelType}"/>
					<input type="hidden" name="relate_data" value="${itemChild.cmsContentType}"/>
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
