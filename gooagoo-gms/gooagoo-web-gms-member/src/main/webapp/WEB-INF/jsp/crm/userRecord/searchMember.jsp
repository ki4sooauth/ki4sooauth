<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
.selectBox ul{width:100%;}
.selectBox ul li{width:230px;margin:0;}
</style>
<div class="rightTitle" style="margin-top: 24px">
	<span>${shopVo.wordNames['cpmb045']}</span>
</div>
<form id = "conditionForm">
    ${condition}
	<check:hasAuthority authorityID="210402"><a href="javascript:void(0)" class="blueBtn savebtn" onclick="page(1)">${shopVo.wordNames['cpmb025']}</a></check:hasAuthority> 
</form>
<div id= "table"></div>
<a style="display: none" id="relaTreeFancybox" class="fancybox_tree"></a>
<a style="display: none"  id = "relaListFancybox" class="fancybox_list"></a>
<a style="display: none"  class="fancybox_loading" href="#loading"></a>
<div style='display: none;'><div style='width:50px;height:50px' id='loading'>
<div  class='loading-small' style='margin-top:15px;'></div></div></div>
<script type="text/javascript">
	$(document).ready(function(){
		initFancyBox("fancybox",850,650,false);
		initFancyBox("fancybox_tree",240,450,false);
		initFancyBox("fancybox_list",800,600,false);
		initloading();
		initShopActionList();
		chooseActType();
		deleteAction();
	});
</script>			 