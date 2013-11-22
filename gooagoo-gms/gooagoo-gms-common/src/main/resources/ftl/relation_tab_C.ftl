<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="7" style="text-align: left; padding-left: 10px;">
			<span>${shopVo.wordNames['gmsd063']}</span>
			<input style="height:20px;width:315px;" name="fname" value="${fname}" id="fname">
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
		<th width="30%">${shopVo.wordNames['gmsd063']}</th>
	    <th width="10%">发布渠道</th>
	    <th width="13%">${shopVo.wordNames['gmsb056']}</th>
	    <th width="13%">${shopVo.wordNames['gmsb061']}</th>
       	<th width="13%">${shopVo.wordNames['gmsb062']}</th>
	  	<th width="13%">${shopVo.wordNames['gmsb063']}</th>
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
				<td>${itemChild.couponName}</td>
				<td>
	                  <#if itemChild.couponChannle=='0'>积分商城</#if>
		              <#if itemChild.couponChannle=='1'>收藏广场</#if>
		              <#if itemChild.couponChannle=='2'>精确投放</#if>    
              	</td>
				<td><#if itemChild.couponType=='C'>${shopVo.wordNames['gmsb128']}<#else>${shopVo.wordNames['gmsb129']}</#if></td>
				<td>${itemChild.couponValue}</td>
				<td>${itemChild.useStartTime?string("yyyy-MM-dd")}</td>
				<td>${itemChild.useEndTime?string("yyyy-MM-dd")}</td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="C"/>
					<input type="hidden" name="relate_data" value="${itemChild.couponId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.couponName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.couponUrl}"/>
					<input type="hidden" name="relate_data" value="${itemChild.mobileVisitUrl}"/>
					<input type="hidden" name="relate_data" value="${itemChild.couponValue}"/>
					<input type="hidden" name="relate_data" value="${itemChild.couponType}"/>
					<input type="hidden" name="relate_data" value="${itemChild.useStartTime?string("yyyy-MM-dd")}"/>
					<input type="hidden" name="relate_data" value="${itemChild.useEndTime?string("yyyy-MM-dd")}"/>
					<input type="hidden" name="relate_data" value="${itemChild.webVisitUrl}"/>
				</td>
			</tr>
		</#list>
		<tr>
			<td colspan="7">
			 	<#include "common_page.ftl">
			</td>
		</tr>
	<#else>
		<tr style="height:30px;">
			<td colspan="7"><strong>${shopVo.wordNames['gmsc008']}</strong></td>
		</tr>
	</#if>
</table>
<#if selectType=='M'>
	<div class="commitBnt">
		<a href="javascript:void(0);" onclick="selectMult(); " class="submit blueBtn">${shopVo.wordNames['gmsc129']}</a>
	</div>
</#if>
