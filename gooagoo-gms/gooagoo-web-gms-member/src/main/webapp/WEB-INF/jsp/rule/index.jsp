<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "23");
	request.setAttribute("leftMenuCode", "");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpmd001']}</title><!-- 会员发展规则 -->
<%@ include file="/WEB-INF/jsp/common/top.jsp"%> 
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var pIndex = "${page_cur}";
	var type = "${type}";
	var ruleType = "${ruleType}";

	$(function(){
		$('.left_menu li').each(function(){
			 var index = $('.left_menu li').index(this)+1;
			 if(index == type){
				 $(this).removeClass().addClass('first').siblings().removeClass();
			 }
		});
		page(1);
	});
	
	function freshFlag(flag){
		$("#flag").val(flag);
		page(1);
	}
	//分页
	function page(index){
		var status = $("#flag").val();
		if(isEmpty(status)){
			status = "";
		}
	 	if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = "&pageIndex="+index+"&publishStatus="+status+"&ruleType=${ruleType}";
		ajaxToPageByData(basePath + "rule.do?method=page","fileCont",data);
	}
	function formRule(ruleId){
		var methodName = "formU";
		if(isEmpty(ruleId)){
			ruleId = "";
			methodName = "formA";
		}
		var data = "&ruleId="+ruleId+"&ruleType=${ruleType}";
		window.location.href = basePath + "rule.do?method="+methodName+data;
	}	
	function closeCheckFancyBox(){
// 		closeFancyBox();
		location.reload();
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
			<div class="section" id="page_content">
				<div class="rightTitle_add">
					<check:hasAuthority authorityID="2301">
						<a href="javascript:void(0);" onclick="formRule('');">${shopVo.wordNames['cpmd002']}</a>
					</check:hasAuthority>
				 	<span>${shopVo.wordNames['cpmd001']}</span>
				</div>
				<div class="file_nav">
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('');" style="padding: 0 30px;">${shopVo.wordNames['cpmd003']}</a>
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('W');" style="padding: 0 30px;" class="curr">${shopVo.wordNames['cpmd004']}</a>
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('B');" style="padding: 0 30px;">${shopVo.wordNames['cpmd005']}</a>
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('A');" style="padding: 0 30px;">${shopVo.wordNames['cpmd006']}</a>
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('D');" style="padding: 0 30px;">${shopVo.wordNames['cpmd007']}</a>
		            <a href="javascript:void(0);" onclick="switchTab(this);freshFlag('P');" style="padding: 0 30px;">${shopVo.wordNames['cpmd008']}</a>
		            <input id="flag" value="W" type="hidden"/>
				</div>
				<span id="fileCont"></span>
		   	</div>
		</div>
	</div>
  	<!--用户状态-->
 	<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>
