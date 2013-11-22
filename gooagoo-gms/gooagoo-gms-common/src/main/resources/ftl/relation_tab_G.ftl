<script>
	$(function(){
		initFancyBox("fancybox_category",800,500,true);
		initFancyBox("fancybox_brand",800,500,true);
	});
	function relateOne(relateType){
		var entityId = "${entityId!}" ;
		if(isEmpty(entityId)){
		entityId=$("select[name='shopEntityId']").val();
		}
		var url = "" ;
		// 品类
		if(relateType == "J") {
		    url = "${basePath }/relation.do?method=listRelation&relateType=" + relateType + "&entityId=" + entityId;
			$("#relateCategory").attr("href",url).click();
		} 
		// 品牌
		else if(relateType == "B") {
		    url = "${basePath }/relation.do?method=listRelation&selectType=S&relateType=" + relateType + "&entityId=" + entityId;
			$("#relateBrand").attr("href",url).click();
		}
	}
	//选中回调函数
	function dealRelations(relations){
		 if(relations[0][0] == "J" ){
			$("#fcategoryLeafId").val(relations[0][1]) ;
			$("#fcategoryLeafName").val(relations[0][2]) ;
			$("#categoryRootId").val(relations[0][3]) ;
		}
		// 品牌
		else if(relations[0][0] == "B"){
			$("#fbrandId").val(relations[0][1]) ;
			$("#fbrandName").val(relations[0][2]) ;
		}
		
		$.fancybox.close();
	}
</script>
<style type="text/css">
	.condition{	border: 1px solid #A5ACB2; height: 20px; line-height: 20px; margin-right: 5px; width: 110px;}
</style>
<!-- 品类 -->
<div style="display:none;">
	<a href="#" id="relateCategory" class="fancybox_category"></a>
</div>
<!-- 品牌 -->
<div style="display:none;">
	<a href="#" id="relateBrand" class="fancybox_brand"></a>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
	<tr>
		<td colspan="6" style="text-align: left; padding-left: 10px;">
			<#if shopVo.shopAndUserInfo.userShopEntityId!??||shopVo.shopAndUserInfo.userShopEntityId=="">
		  		<span id="entityDiv">${shopVo.wordNames['gmse014']}：</span>     
		       	<select class="condition" id="shopEntityId" name="shopEntityId" onchange="page(1);" style="margin-right: 20px;" <#if entityId!="">disabled</#if>>
					<#if shopEntityList??>
						<#list shopEntityList as itemChild>
							<option value="${itemChild.shopEntityId}" <#if itemChild.shopEntityId == shopEntityId!>selected="selected"</#if>>${itemChild.shopEntityName}</option>
						</#list>   
					</#if>
				</select>   
			</#if>
			<span>${shopVo.wordNames['gmsb020']}：
			<input id="fname" name="fname" value="${fname}" style="height:20px;width:120px;" ><br/><br/>	
			<span>${shopVo.wordNames['gmse005']}：</span>	
			<input type="text" onclick="relateOne('J');" id="fcategoryLeafName" name="categoryLeafName" value="${fcategoryLeafName}" style="height:20px;width:120px;margin-right: 20px;" readonly />
			<input type="hidden" id="categoryRootId" name="categoryRootId"/>
			<input type="hidden" id="fcategoryLeafId" name="goodsCategoryLeaf" value="${fcategoryLeafId}"/>
			<span>${shopVo.wordNames['gmse006']}：</span>
			<input type="text" id="fbrandName" value="${fbrandName}" onclick="relateOne('B');" style="height:20px;width:120px;" />
		    <input type="hidden" id="fbrandId" name="goodsBrand" value="${fbrandId}"/> 			
			<div style="float: right; padding-right: 50px;">
				<input type="button" onclick="page(1)" value="${shopVo.wordNames['gmsc006']}"/>				
				<input type="button" onclick="clearGoodsPage();" value="${shopVo.wordNames['gmsc007']}"/>
			</div>
		</td>
	</tr>	
	<tr>
		<#if selectType=='M'>
		  	<th width="5%"><input type="checkbox" onclick="checkAllBox(this);" /></th>
		</#if>
	  	<th>${shopVo.wordNames['gmsb020']}</th>
	  	<th width="20%">${shopVo.wordNames['gmsb021']}</th>
	  	<th width="20%">${shopVo.wordNames['gmsb022']}</th>
	  	<th width="13%">${shopVo.wordNames['gmsb027']}</th>
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
				<td>${itemChild.goodsName}</td>
				<td>${itemChild.categoryLeafName}</td>
				<td>${itemChild.brandName}</td>
				<td>${itemChild.price}</td>
				<#if selectType!='M'>
					<td><a href="javascript:void(0);" onclick="selectOne(this);" class="selected">${shopVo.wordNames['gmsc208']}</a></td>
				</#if>
				<td style="display:none;">
					<input type="hidden" name="relate_data" value="G"/>
					<input type="hidden" name="relate_data" value="${itemChild.goodsId}"/>
					<input type="hidden" name="relate_data" value="${itemChild.goodsName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.goodsImg!}"/>
					<input type="hidden" name="relate_data" value="${itemChild.mobileVisitUrl}"/>
					<input type="hidden" name="relate_data" value="${itemChild.price}"/>
					<input type="hidden" name="relate_data" value="${itemChild.brandName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.categoryLeafName}"/>
					<input type="hidden" name="relate_data" value="${itemChild.itemSerial}"/>
					<input type="hidden" name="relate_data" value="${itemChild.webVisitUrl}"/>
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
		<a href="javascript:void(0);" onclick="selectMult(); " class="submit blueBtn">${shopVo.wordNames['gmsc129']}</a>
	</div>
</#if>