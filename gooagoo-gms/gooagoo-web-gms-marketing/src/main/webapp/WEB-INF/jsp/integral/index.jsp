<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1302");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${empty shopVo.wordNames['gmsd011'] ? '积分兑换管理' : shopVo.wordNames['gmsd011']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<script>
var pIndex = '${page_cur}';
$(function(){
	page(pIndex);
});
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	pIndex=index;
	var startConvert=$("#start").val();
	var endConvert=$("#end").val();
	var convertType=$("#convertType").val();
	var data = "&pageIndex="+index + "&pageSize=12&startConvert="+startConvert+"&endConvert="+endConvert+"&convertType="+convertType;
	ajaxToPageByData( "${basePath}/integral.do?method=list","fileCont1",data);
}
//积分兑换编辑页
function formIntegral(shopIntegralId){
	var mName="updateform";
	if(isEmpty(shopIntegralId)){
		shopIntegralId = "";
		mName="addform";
	}
	window.location.href = "${basePath}/integral.do?method="+mName+"&integralId="+shopIntegralId;
}
function deleteIntegral(shopIntegralId){
	if(confirm("确定删除积分兑换信息？")){
		var url = "${basePath}/integral.do?method=delete";
		var data = "&id="+shopIntegralId;
		$.ajax({
			type: "POST",
			async: false,
			url: url,
			data: data,
			success: function(ret){
				if(ret == '1'){
					alert("操作失败");	
				}else{
					page(1);
				}
			}
		});
	}
}
function ToIntegralDeliveRById(id){
	window.location.href="${basePath }integralDeliver.do?method=index&shopIntegralId="+id;
}
//清空查询条件
function clearArgs(){
	$("#start").val("");
	$("#end").val("");
	$("#convertType").val("");
	page(1);
}
</script>
</head>
<body>
 <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">       
      <div class="article">
	 <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
  			<div class="section">
        <div class="rightTitle_add">
           <check:hasAuthority authorityID='130201'>
           <a href="javascript:formIntegral('');">${empty shopVo.wordNames['gmsd030'] ? '添加积分兑换信息' : shopVo.wordNames['gmsd030']}</a>
            </check:hasAuthority>
            <span>${empty shopVo.wordNames['gmsd029'] ? '积分兑换信息列表' : shopVo.wordNames['gmsd029']}</span>
        </div>    
              <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" style="background-color:#F8F7F7; ">
					<tr>
						<td colspan="8" style="padding-top: 20px;">
							<div class="behaviorSearch"  style="float:left; height:40px;">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">${shopVo.wordNames['gmsd034']}：</span>
							<input type="text" id="start" class="behaviorInput"  style="margin-left: 0px;width: 100px" />
							<span style="float: left;padding-left: 30px;width: 0px"><strong>-</strong></span>
							<input type="text" id="end" class="behaviorInput"  style="width: 100px;" />
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['gmsd035']}：</span>
								<select  class="behaviorInput" id="convertType" style="width:120px;margin-left: 0px;">			
									<option value="">-${shopVo.wordNames['gmsd088']}-</option>
									<option value="G">${shopVo.wordNames['gmse001']}</option>
									<option value="C">${shopVo.wordNames['gmsd082']}</option>		
								</select>
								<a href="javascript:void(0)" style="margin-left: 35px ;margin-top:-6px;" id="select" onclick="page(1)" class="search orangeBtn" style="margin-left: 35px;">${shopVo.wordNames['gmsc006']}</a>
								<a href="javascript:void(0)" style="margin-top:-6px;" onclick="clearArgs();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>												
							</div>
						</td>
	             	</tr>
				</table>        
          <span id="fileCont1">&nbsp;</span>
        </div>
     </div>
 </div>
</body>
</html>
