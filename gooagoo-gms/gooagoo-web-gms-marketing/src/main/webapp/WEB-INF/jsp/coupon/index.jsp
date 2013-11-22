<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1301");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${empty shopVo.wordNames['gmsd010'] ? '优惠凭证管理' : shopVo.wordNames['gmsd010']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<link href="${imgPath}/gms/common/css/goodsList.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<script>
var pIndex = '${page_cur}';
		var cType = 0;
		var  flag = "";
		$(function(){
			page(pIndex);
			initFancyBox("fancybox_coupon",330,200,true);
		    initFancyBox("fancybox_excel",550,450,true); 	//导入excel
			initFancyBox("fancybox_detail",920,600,true);
			initFancyBox("fancybox_preview",1100,1100,true);
		});
		
		function page(index){
			var flag = $("#flag").val();
			var spanId="";
			if(isEmpty(flag)){
				flag = "shop";
			}
			if(isEmpty(index) || parseInt(index)<1){
				index = 1;
			}
			if(flag=="shop"){
				cType = 0;
				spanId="fileCont1";				
			}else if(flag=="system"){
				cType = 1;
				spanId="fileCont2";		
			}			
			pIndex = index;
			var couponName=$("#couponName").val();
			var couponType=$("#couponType").val();
			var status=$("#status").val();
			var couponChannle=$("#couponChannle").val();
			var couponMode=$("#couponMode").val();
			var data = "&pageIndex="+index+"&pageSize=5"+"&cType="+cType+"&couponName="+couponName;
			if(cType=="0"){
	data=data+"&couponType="+couponType+"&couponChannle="+couponChannle+"&couponMode="+couponMode+"&status="+status;
			}
			ajaxToPageByData("${basePath }coupon.do?method=list",spanId,data);
		}
		
		function freshFlag(flag){
			$("#flag").val(flag);
			page(pIndex);
		}
		
		
		function formCheckCoupon(couponId){
			var url = "${basePath }coupon.do?method=formCheck&id="+couponId;
			$("#couponFancybox").attr("href",url).click();
		}
		//发布
		function releaseCoupon(couponId){
			var url = "${basePath }coupon.do?method=release";
			var data = "&id="+couponId;
			ajaxJsonTipByData(url,data,true);
			page(pIndex);
		}
		function closeCheckFancyBox(){
			closeFancyBox();
			page(pIndex);
		}
		//进入创建页面
		function formCoupon(){
			window.location.href = "${basePath}/coupon.do?method=addform";
		}
			
		//编辑优惠凭证
		function updateCoupon(couponId){
			var data = "&id="+couponId;
			window.location.href = "${basePath }coupon.do?method=updateform"+data;
		}

		//删除优惠凭证（逻辑删除）
		function deleteCoupon(couponId){
			if(confirm("确定删除优惠凭证？")){
				var url = "${basePath }coupon.do?method=delete";
				var data = "&id="+couponId;
				ajaxJsonTipByData(url,data,true);
				page(pIndex);
			}
		}
					

		function detail(id){
			var url="coupon.do?method=detail&id="+id;
			$("#couponDetailFancybox").attr("href",url).click();
			
		}
		function preview(url){
			window.open(url);
		}
		function clearArgs(){
	        $("#couponName").val("");
			$("#couponType").val("");
			$("#status").val("");
			$("#couponChannle").val("");
			$("#couponMode").val("");
			page(pIndex);
		}	

		 /**
		  * 导入Excel
		  * @param
		  */
		 function importExcel(id){
			 	var subUrl="${basePath}coupon.do?method=importExcel";
		 		var url = "${basePath}reportOperate.do?method=importExcelPage&url="+subUrl+"&couponId="+id;
		 		$("#fancybox_excel").attr("href",url).click();
		 }
	</script>
</head>
<body>

<div style="display:none;">
	<a href="#" id="fancybox_excel" class="fancybox_excel"></a>
	<a href="#" id="couponFancybox" class="fancybox_coupon"></a>
	<a href="#" id="couponDetailFancybox" class="fancybox_detail"></a>
	<a href="#" id="couponPreviewFancybox" class="fancybox_preview"></a>
</div>
	<!-- 头部 --> 
	 <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
 <!--内容-->
    <div class="container" style="overflow:hidden;height:100%;">  
		<div class="article">
	 <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
  			<div class="section">
        <div class="rightTitle_add">
           <check:hasAuthority authorityID='130101'>
			<a href="javascript:formCoupon('');">${empty shopVo.wordNames['gmsd015'] ? '添加优惠凭证' : shopVo.wordNames['gmsd015']}</a>	
           </check:hasAuthority>
            <span>${empty shopVo.wordNames['gmsd014'] ? '优惠凭证信息列表' : shopVo.wordNames['gmsd014']}</span>
            <input id="flag" value="" type="hidden"/>
        </div>
 		 <div class="file_nav">
 		 	<div class="firsd">
			<a href="javascript:void(0)" onclick="freshFlag('shop');" class="curr">${empty shopVo.wordNames['gmsd016'] ? '商家创建' : shopVo.wordNames['gmsd016']}</a>
			<a href="javascript:void(0)" onclick="freshFlag('system');">${empty shopVo.wordNames['gmsd017'] ? '系统生成' : shopVo.wordNames['gmsd017']}</a>
   	         </div>
 		 </div>
 		          <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
					<tr>
						<td colspan="8" style="padding-top: 20px;">
						<div class="behaviorSearch"  style="float:left; height:35px;">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">优惠凭证名称：</span>
	                        <input type="text" id="couponName" class="behaviorInput" onclick="relateActive();" style="cursor:pointer; margin-left: 0px;width: 150px;height: 18px" />	
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">优惠凭证类型：</span>
							 <select  class="behaviorInput" id="couponType" style="width:150px;margin-left: 0px;">								
			        	       <option value="" >-${shopVo.wordNames['gmsd088']}-</option>
			        	       <option value="C" >代金券</option>
			                   <option value="D" >折扣券</option>       
			                </select>
								
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">状态：</span>
							 <select  class="behaviorInput" id="status" style="width:150px;margin-left: 0px;">			
									<option value="">-${shopVo.wordNames['gmsd088']}-</option>
									<option value="W">待审核</option>
									<option value="A">通过</option>
									<option value="B">未通过</option>
									<option value="P">已发布</option>			
								</select>
							</div>
							<div class="behaviorSearch"  style="float:left; height:40px;">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">&emsp;&emsp;发布渠道：</span>
						     <select class="behaviorInput" id="couponChannle" style="width:150px;margin-left: 0px;">									       
				                <option  value="" ${coupon.couponChannle=='' ? "selected" : "" } >-${shopVo.wordNames['gmsd088']}-</option>   
					        	<option  value="0" >积分商城</option>
					            <option  value="1" >收藏广场</option>       
					            <option  value="2" >精确投放</option>       
				          </select> 
						 <span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">优惠凭证模式：</span>
						<select  class="behaviorInput" id="couponMode" style="width:150px;margin-left: 0px;">						
			                <option  value="" >-${shopVo.wordNames['gmsd088']}-</option> 	      
				        	<option  value="0">平台默认模式</option>
				            <option  value="1">开放模式</option>       
				            <option  value="2">第三方整合模式</option>       
			          </select>
								<a href="javascript:void(0)" style="margin-left: 35px ;margin-top:-6px;" id="select" onclick="page(1)" class="search orangeBtn" style="margin-left: 35px;">${shopVo.wordNames['gmsc006']}</a>
								<a href="javascript:void(0)" style="margin-top:-6px;" onclick="clearArgs();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>												
							</div>
						</td>
	             	</tr>
				</table>          
          <span id="fileCont1">&nbsp;</span>
          <span id="fileCont2">&nbsp;</span>
        </div>
	</div>
</div>
</body>
</html>
