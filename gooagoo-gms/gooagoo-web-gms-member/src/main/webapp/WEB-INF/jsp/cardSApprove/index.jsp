<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "24");
request.setAttribute("leftMenuCode", "2405");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpme005']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var pIndex = 1;
	function initFancybox(){
		$(".fancybox").fancybox({
			'padding'			: 0,
			'autoScale'			: false,
			'autoDimensions'    : true,
			'transitionIn'		: 'yes',
			'transitionOut'		: 'yes',
			'href'				: $(this).attr('href'),
			'type'				:'inline',
			'hideOnOverlayClick': false,
			'showCloseButton'	: true,
			'changeSpeed'		:200
		});
	}
	$(function(){
		freshFlag("S");
	});
	function freshFlag(flag){
		$("#flag").val(flag);
		if(flag=="S"){
			$("#searchKey").val("");
			$("#fileCont2").attr("style","display:none");
			$("#fileCont1").attr("style","display:block");
		}else if(flag=="G"){
			$("input[name='mobile']").val("");
			$("input[name='email']").val("");
			$("#fileCont1").attr("style","display:none");
			$("#fileCont2").attr("style","display:block");
		}
		page(1);
	}
	function page(index){
		var flag = $("#flag").val();
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		if(flag=="S"){
			var searchKey = $("#searchKey").val();
			var data = "&pageIndex="+index+"&name="+searchKey;
 			ajaxToPageByData(basePath + "memberOfCard.do?method=memSpecialList", "table_content", data);
		}else if(flag=="G"){
			var mobile = $("input[name='mobile']").val();
			var email = $("input[name='email']").val();
		    var data=(mobile!=""?"&mobile="+mobile:'')+(email!=''?"&email="+email:'');
			ajaxToPageByData(basePath + "memberOfCard.do?method=specialUserInfo", "table_content", data);
		    }
	}
	
	function doSearch(){
		var mobile = $("input[name='mobile']").val();
		var email = $("input[name='email']").val();
		if(isEmpty($.trim(mobile)) && isEmpty($.trim(email))){
			alert("请至少输入一个查询条件");
			return;
		}
		page(1);
	}
	
	function checkPhoneValue(){
		var mobile = $("input[name='mobile']").val();
		if(!isEmpty($.trim(mobile))){
			if(!(checkPhone(mobile) || checkMobile(mobile))){
				$("#lablePh").html("电话格式输入错误!");
				return false;
			}else{
				$("#lablePh").html("");
			}
		}else{
			$("#lablePh").html("");
		}
		return true;
	}
	function checkEmailValue(){
		var email = $("input[name='email']").val();
		if(!isEmpty($.trim(email))){
			if(!checkEmail(email)){
				$("#lableEm").html("电子邮箱格式输入错误!");
				return false;
			}else{
				$("#lableEm").html("");
			}
		}else{
			$("#lableEm").html("");
		}
		return true;
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
		            <span>${shopVo.wordNames['cpme005']}</span>
	          	</div>
	          	<div class="file_nav">
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('S');" class="curr">${shopVo.wordNames['cpme085']}</a>
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('G');">${shopVo.wordNames['cpme096']}</a>
		             <input id="flag" value="S" type="hidden"/>
	          	</div>
	          	<div id="fileCont1"  style="display: none">
		          	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" >
						<tr>
							<td colspan="11" class="behaviorSearch">
								<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['cpme087']}：</span>
								<input type="text" id="searchKey" class="behaviorInput" style="margin: 0px;"/>
								<a href="javascript:void(0)" onclick="page(1)" class="search orangeBtn ">${shopVo.wordNames['cpme036']}</a>
							</td>
						</tr>
					</table>
	          	</div>
	          	<div id="fileCont2"  style="display: none">
			        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
						<tr>
					       	<td width="95px">${shopVo.wordNames['cpmf064']}：</td>
					           <td class="behaviorSearch">
					           <input class="behaviorInput" type="text" name="mobile" style="padding-left: 5px;" />
					           <lable style="float:left; color: red; padding: 3px 10px;" id="lablePh"></lable>
					           </td>
					 	    </tr>
						<tr>
					       	<td width="95px">${shopVo.wordNames['gmsg037']}：</td>
					         	<td class="behaviorSearch">
								<input class="behaviorInput" type="text" name="email" style="padding-left: 5px;" />
								<lable style="float:left; color: red; padding: 3px 10px;" id="lableEm"></lable>
								<a href="javascript:doSearch();" class="search orangeBtn" style="float: right; margin-right: 100px;">${shopVo.wordNames['cpme036']}</a>
							</td>
					 	</tr>           
					</table>
				</div>
				<div id="table_content">
				</div>
	        </div>
        </div>
	</div>
  	<!--用户状态-->
 	<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>
