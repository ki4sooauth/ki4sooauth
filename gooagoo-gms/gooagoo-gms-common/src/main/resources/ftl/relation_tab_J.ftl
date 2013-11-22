<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="6" style="text-align: left; padding-left: 10px;">
			<span>${shopVo.wordNames['gmse017']}：</span>
			<input id="fcategoryLeafId" value="${fcategoryLeafId}" style="height:20px;width:170px; margin-right: 20px;">		
			<span>${shopVo.wordNames['gmse018']}：</span>
			<input id="fcategoryLeafName" value="${fcategoryLeafName}" style="height:20px;width:170px;" >		
			<div style="float: right; padding-right: 50px;">
				<input type="button" onclick="page(1)" value="${shopVo.wordNames['gmsc006']}"/>				
				<input type="button" onclick="clearCategoryPage();" value="${shopVo.wordNames['gmsc007']}"/>
			</div>
		</td>
	</tr>	
	<tr>
	  	<#if selectType=='M'>
	  		<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
	  	<th>${shopVo.wordNames['gmse017']}</th>
	  	<th>${shopVo.wordNames['gmse018']}</th>
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
				<td>${itemChild.categoryId}</td>
				<td>${itemChild.categoryName}</td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="J"/>
					<input type="hidden" name="relate_data" value="${itemChild.categoryId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.categoryName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.id}"/>
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