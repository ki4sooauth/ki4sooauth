<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<#if selectType=='M'>
		  	<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
        <th width="5%">${shopVo.wordNames['gmsg273']}</th>
		<th width="6%">${shopVo.wordNames['gmsg274']}</th>
		<th width="7%">${shopVo.wordNames['gmsg275']}</th>
		<th width="10%">${shopVo.wordNames['gmsg276']}</th>
		<th width="15%">${shopVo.wordNames['gmsg277']}</th>
		<th width="6%">${shopVo.wordNames['gmsg278']}</th>
	  	<#if selectType!='M'>
	  		<th width="7%">${shopVo.wordNames['gmsc130']}</th>
	  	</#if>
	</tr>
	<#if pm.count!=0>
		<#list pm.result as itemChild>
			<tr>
				<#if selectType=='M'>
					<td><input style="height: 24px;" type="checkbox" class="singleSelect"/></td>
				</#if>
				<td>${itemChild_index+1}</td>
				<td><input type="hidden" value="${itemChild.deviceType}"/>${itemChild.typeNameCh}</td>
				<td>${itemChild.deviceSn}</td>
				<td>${itemChild.deviceMac}</td>
				<td>${itemChild.installDate?string("yyyy年MM月dd日")}</td>
				<td><#if itemChild.status=="0">${shopVo.wordNames['gmsg281']}<#elseif itemChild.status=="1">${shopVo.wordNames['gmsg282']}<#else>${shopVo.wordNames['gmsg283']}</#if></td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="L"/>
					<input type="hidden" name="relate_data" value="${itemChild.deviceType}"/>
					<input type="hidden" name="relate_data" value="${itemChild.deviceMac}"/>
				</td>
			</tr>
		</#list>
		<tr>
			<td colspan="8">
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
