<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var indexNum = "${indexNum}";
	$(function(){
		var trs = parent.$(".table_list").find("tr");
		var tds = trs.eq(indexNum).find("td");
		var lis = $(".desk-num-poup").find("li");
		for(var i=0; i<lis.length-2; i++){
			lis.eq(i).append(tds.eq(i+1).html());
		}
	})
	function approval(id, status){
		$.fancybox.close();
		var note = $("textarea[name='note']").val();
		var url = "${basePath}memberOfCard.do?method=approvalPsyConvert";
		var data = "&applicationId="+id + "&status="+status+"&note="+note;
		ajaxJsonTipByData(url,data,true);
		parent.page(1);
	}
</script>
</head>
<body>
	<div style="width: 400px;">
		<ul class="desk-num-poup" style="width: 350px;">
			<li><span>${shopVo.wordNames['cpme061']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme062']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme063']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme064']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme065']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme066']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme067']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme069']}</span>&nbsp;</li>
		 	<li><span>审批时间</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme041']}</span>&nbsp;</li>
		 	<li class="commitBtn">
		 	   <input type="button" style="width: 100px" onclick="parent.$.fancybox.close();"  class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg300']}">
		 	</li>
		</ul>
	</div>
</body>
</html>
