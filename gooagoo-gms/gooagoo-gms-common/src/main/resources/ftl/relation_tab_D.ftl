<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="4" style="text-align: left; padding-left: 10px;">
			<span>会员卡名称：</span>
			<input style="height:20px;width:315px;" name="fname" value="${fname}" id="fname">
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
		<th>${shopVo.wordNames['gmsb135']}</th>
	  	<#if selectType!='M'>
	  		<th width="">${shopVo.wordNames['gmsc130']}</th>
	  	</#if>
	</tr>
	<#if pm.count!=0>
       	<#list pm.result as itemChild>
			<tr>
				<#if selectType=='M'>
					<td><input style="height: 24px;" type="checkbox" class="singleSelect"/></td>
				</#if>
				<td>${itemChild.cardName}</td>    
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="D"/>
					<input type="hidden" name="relate_data" value="${itemChild.cardId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.cardName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.cardLvl}"/>
					<input type="hidden" name="relate_data" value="${itemChild.cardUrl}"/>
				</td>
			</tr>
		</#list>
		<tr>
			<td colspan="3">
			 	<#include "common_page.ftl">
			</td>
		</tr>
	<#else>
		<tr style="height:30px;">
			<td colspan="3"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</#if>
</table>
<#if selectType=='M'>
	<div class="commitBnt">
		<a href="javascript:void(0);" onclick="selectMult(); " class="submit blueBtn">${shopVo.wordNames['gmsc129']}</a>
	</div>
</#if>
