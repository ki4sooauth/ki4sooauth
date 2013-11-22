<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "24");
request.setAttribute("leftMenuCode", "2404");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['cpme004']}</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var index = 1;
	$(function(){
 		page(1);
	});
	function page(index){
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		var searchKey = $.trim($("#searchKey").val());
		var data = "&pageIndex="+index+"&name="+searchKey;
		ajaxToPageByData(basePath + "memberOfCard.do?method=upgradeList","fileCont",data);
	}
	function approval(id, status){
		var url = basePath + "memberOfCard.do?method=integralUpgrade&id="+id;
		var data = "&applicationId="+id;
		ajaxJsonTipByData(url,data,true);
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
           			<span>${shopVo.wordNames['cpme004']}</span>
          		</div>
          		<table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable">
					<tr>
						<td colspan="11" class="behaviorSearch">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['cpme072']}：</span>
							<input type="text" id="searchKey" class="behaviorInput" style="margin: 0px;"/>
							<a href="javascript:void(0);" onclick="page(1);" class="search orangeBtn">${shopVo.wordNames['cpme036']}</a>
						</td>
					</tr>
				</table>
          		<span id="fileCont"></span>
			</div>
		</div>
	</div>
	<!--用户状态-->
 	<%@ include file="/WEB-INF/jsp/common/right.jsp"%>
</body>
</html>