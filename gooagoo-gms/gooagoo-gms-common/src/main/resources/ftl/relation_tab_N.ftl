<table width="750px" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="6" style="text-align: left; padding-left: 10px;">
			<span>${shopVo.wordNames['gmsb159']}</span>
			<input style="height:20px;width:315px;" name="fname" value="${fname}" id="fname"/>
			<div style="float: right; padding-right: 50px;">
				<input type="button" onclick="page(1)" value="${shopVo.wordNames['gmsc006']}"/>				
				<input type="button" onclick="clearCondition();" value="${shopVo.wordNames['gmsc007']}"/>
			</div>
		</td>
	</tr>
	<tr>
		<#if selectType=='M'>
		  	<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
		<th width="5%">${shopVo.wordNames['gmsb158']}</th>
	   	<th width="41%">${shopVo.wordNames['gmsb159']}</th>
	  	<#if selectType!='M'>
	  		<th width="13%">${shopVo.wordNames['gmsb161']}</th>
	  	</#if>
	</tr>
	<#if pm.count!=0>
		<#list pm.result as itemChild>
			<tr>
				<#if selectType=='M'>
				<td><input style="height: 24px;" type="checkbox" class="singleSelect"/></td>
				</#if>
				<td>${itemChild_index + 1}</td>        
                <td><span>${itemChild.noticeTitle}</span></td>
				<#if selectType!='M'>
				<td>
					<a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsb171']}</a>
				</td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="N"/>	
					<input type="hidden" name="relate_data" value="${itemChild.noticeInfoId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.noticeTitle}"/>							
				</td>
			</tr>
		</#list>
		<tr>
			<td colspan="6">
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
		<a href="javascript:void(0);" onclick="selectMult(); " class="submit blueBtn">${shopVo.wordNames['gmsb173']}</a>
	</div>
</#if>