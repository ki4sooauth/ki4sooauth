<style type="text/css">
	.condition{	border: 1px solid #A5ACB2; height: 20px; line-height: 20px; margin-right: 5px; width: 110px;}
</style>
<script>
	$(function() {
		if($("#dataType").val()!='A'){
			$("#contentType option[value='3']").remove()
			$("#contentType option[value='4']").remove()
		}
	});
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="3" style="text-align: left; padding-left: 10px;">
			<span>内容名称：</span>
			<input style="height:20px;width:315px;" name="fname" value="${fname}" id="fname"><br/><br/>
			<span>${shopVo.wordNames['gmsc135']}：</span>
			<select class="condition" id="contentType" <#if channelCode!="">disabled</#if>>
				<option value="">--${shopVo.wordNames['gmsc058']}--</option>
				<#list channels as channel>
					<option value="${channel.code}" <#if channel.code == contentType!>selected="selected"</#if>>${channel.name}</option>
				</#list>
			</select>
			<div style="float: right; padding-right: 50px;">
				<input type="button" onclick="page(1)" value="${shopVo.wordNames['gmsc006']}"/>
				<input type="button" onclick="clearActivityContentPage();" value="${shopVo.wordNames['gmsc007']}"/>
			</div>
		</td>
	</tr>
	<tr>
	  	<#if selectType=='M'>
	  		<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
		<th width="30%">${shopVo.wordNames['gmsc134']}</th>
	    <th width="13%">${shopVo.wordNames['gmsc135']}</th>
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
				<td >${itemChild.title}</td>
				<td >
	               	<#list channels as channel>
		           		 <#if itemChild.channelCode==channel.code>${channel.name}</#if>
		           	</#list>
				</td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="K"/>
					<input type="hidden" name="relate_data" value="${itemChild.id}"/>
					<input type="hidden" name="relate_data" value="${itemChild.title}"/>
					<input type="hidden" name="relate_data" value="${itemChild.contentType}"/>
					<input type="hidden" name="relate_data" value="${itemChild.channelCode}"/>
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
