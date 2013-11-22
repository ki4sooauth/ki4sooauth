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
	var basePath = "${basePath}";

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
		var url = basePath + "memberOfCard.do?method=approvalAppCard";
		var data = "&applicationId="+id + "&status="+status+"&note="+note;
		ajaxJsonTipByData(url,data,true);
		parent.page(1);
	}
</script>
</head>
<body>
	<div style="width: 400px;">
		<ul class="desk-num-poup" style="width: 350px;">
			<li><span>${shopVo.wordNames['cpme045']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme046']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme047']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme048']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme049']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme050']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme051']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme052']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme053']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme054']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme057']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme058']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme055']}</span>&nbsp;</li>
		 	<li><span>${shopVo.wordNames['cpme056']}</span>&nbsp;</li>
		 	<li>
		 		<font style="line-height: 21px; color: #5B5F60;"><strong>${shopVo.wordNames['cpme041']}</strong></font>
		 		<textarea name="note" onKeyUp="if(this.value.length > 100) this.value=this.value.substr(0,100)" style="width: 322px; height: 90px;padding:10px" rows="" cols="" ></textarea>
		 	</li>
		 	<li class="commitBtn">
		 		<check:hasAuthority authorityID="240202"><input type="button" style="width: 100px" onclick="approval('${id}','Y');"  class="inputBtn blueBtn" value="${shopVo.wordNames['cpme042']}"></check:hasAuthority>&nbsp;&nbsp;&nbsp;&nbsp;
		 		<check:hasAuthority authorityID="240202"><input type="button" style="width: 100px;" onclick="approval('${id}','N');"  class="inputBtn blueBtn" value="${shopVo.wordNames['cpme043']}"></check:hasAuthority>
		 	</li>
		</ul>
	</div>
</body>
</html>
