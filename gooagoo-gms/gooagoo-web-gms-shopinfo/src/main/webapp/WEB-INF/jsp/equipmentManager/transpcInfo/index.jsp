<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140304");
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${shopVo.wordNames['gmsg286']}</title>
<head>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function edit(transpcInfoId) {
		$("#emFancybox").attr("href","${basePath}/transpcInfo.do?method=form&transpcInfoId=" + transpcInfoId).click();
	}
	
	function page(pageIndex) {
		var id = "actionPage";
		var url = "${basePath }/transpcInfo.do?method=page";
		var typeId = $("#typeId").val();
		var state = $("#state").val();
		var shopEntityId = $("#shopEntityId").val();
		var data = "&pageIndex=" + pageIndex;
		if (typeId != "" && typeId != undefined) {
			data += "&typeId=" + typeId;
		}
		if (state != "" && state != undefined) {
			data += "&state=" + state;
		}
		if (shopEntityId != "" && shopEntityId != undefined) {
			data += "&shopEntityId=" + shopEntityId;
		}
		$.ajax({
			type : "POST",
			async : false,
			url : url,
			dataType : 'html',
			data : data,
			success : function(html) {
				$("#" + id).html(html);
			},
			error : function() {
				alert("网络连接异常，请检查网络并重新登录");
				cToTransInfo();
			}
		});
	}

// 	$(function() {
// 		$(".fancybox_em").fancybox({
// 			'padding' : 0,
// 			'autoScale' : false,
// 			'transitionIn' : 'yes',
// 			'transitionOut' : 'yes',
// 			'href' : $(this).attr('href'),
// 			'type' : 'inline',
// 			'hideOnOverlayClick' : false
// 		});

// 	})
	$(document).ready(function(){
	initFancyBox("fancybox_em",600,550,true);
	page("1");
})
</script>
<style type="text/css">
.desk-num-poup {
    padding: 0px;
}

.desk-num-poup li.commitBtn {
    margin-right: 80px;
    padding-top: 0px;
    text-align: center;
}
</style>
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
            <span>${shopVo.wordNames['gmsg286']}</span>
          </div>
         
        <!--转发器设备管理-->
			<ul class="desk-num-poup" style="width: 800px">
			
				<li>
				<%@ include file="/WEB-INF/jsp/common/shopEntity.jsp"%>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg287']}</span>
<!-- 				<input type="text" -->
<%-- 					name="typeId" id="typeId"  value="${condition.typeId}" class="borderStyle text"/> --%>
					<select name="typeId" id="typeId" class="borderStyle select">
						<option value="">${shopVo.wordNames['gmsg288']}</option>
						<option value="0" >${shopVo.wordNames['gmsg289']}</option>
						<option value="1" >${shopVo.wordNames['gmsg290']}</option>
				</select>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg291']}</span><select name="state" id="state" class="borderStyle select">
						<option value="">${shopVo.wordNames['gmsg288']}</option>
						<option value="0" ${condition.state eq '0'?'selected=selected':''}>${shopVo.wordNames['gmsg281']}</option>
						<option value="1" ${condition.state eq '1'?'selected=selected':''}>${shopVo.wordNames['gmsg282']}</option>
						<option value="2" ${condition.state eq '2'?'selected=selected':''}>${shopVo.wordNames['gmsg283']}</option>
				</select>
				</li>
				    <li class="commitBtn"><input type="submit" onclick="page(1)" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg293']}"></li>
			</ul>
 <div id="actionPage">
        </div>
</div>
<div style="display: none;">
			<a href="#" id="emFancybox" class="fancybox_em"></a>
		</div>
</div>
</div>



    	
</body>
</html>
