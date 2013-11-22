<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}common/js/normalCheck.js"></script>
<script type="text/javascript">
	var indexNum = "${indexNum}";
	$(function(){
		var trs = parent.$(".table_list").find("tr");
		var tds = trs.eq(indexNum).find("td");
		var lis = $(".desk-num-poup").find("li");
		for(var i=0; i<lis.length-3; i++){
			lis.eq(i).append("<font>"+tds.eq(i+1).html()+"</font>");
		}
	})
	function integral_special(){
	 	var integralId = "${integralId}";
	 	var userId = $("input[name='userId']").val();
	 	var integralNumber = $("input[name='integralNumber']").val();
		var note = $("textarea[name='note']").val();
 		var useableIntegral = $(".desk-num-poup").find("li").eq(6).find("font").html();
	 	if(isEmpty($.trim(integralNumber))){
			alert("请填写特批积分值！");
			return;
	 	}else if(!checkInt(integralNumber)){
	 		alert("请输入正确的整数！");
	 		return;
	 	}else if(parseInt(useableIntegral)+parseInt(integralNumber)<0){
	 		alert("特批减少的积分必须大于用户当前可用积分");
	 		return;
	 	}
	 	
		var url = "${basePath}memberOfCard.do?method=iSApprove";
	 	var data = "&userId="+userId+"&integralNumber="+integralNumber+"&integralId="+integralId+"&note="+note;
	 	ajaxJsonTipByData(url,data,true);
	 	parent.page(1);
 		parent.$.fancybox.close();
	}
	function checkIsInt(obj){
		var value = obj.value();
		if(!checkInt(integralNumber)){
			return false;
		}
	}
	
</script>
</head>
<body>
	<div style="width: 400px;">
		<ul class="desk-num-poup" style="width: 350px;">
			<li><span>${shopVo.wordNames['cpme098']}</span>&nbsp;</li>
	      	<li><span>${shopVo.wordNames['cpme099']}</span>&nbsp;</li>
	       	<li><span>${shopVo.wordNames['cpme100']}</span>&nbsp;</li>
	      	<li><span>${shopVo.wordNames['cpme101']}</span>&nbsp;</li>
	      	<li><span>${shopVo.wordNames['cpme102']}</span>&nbsp;</li>
	    	<li><span>${shopVo.wordNames['cpme103']}</span>&nbsp;</li>
	    	<li><span>${shopVo.wordNames['cpme104']}</span>&nbsp;</li>
	      	<li><span>${shopVo.wordNames['cpme105']}</span>&nbsp;</li>
	    	<li><span>${shopVo.wordNames['cpme052']}</span>&nbsp;</li>
	    	<li><span>${shopVo.wordNames['cpme106']}</span>&nbsp;</li>
	    	<li><span>${shopVo.wordNames['cpme107']}</span>&nbsp;</li>
			<li>
		 		<font style="line-height: 21px; color: #5B5F60;"><strong>${shopVo.wordNames['cpme041']}：</strong></font>
		 		<textarea name="note" onKeyUp="if(this.value.length > 100) this.value=this.value.substr(0,100)" style="resize: none; overflow-y:auto;width: 322px; height: 90px;padding:10px" rows="" cols="" ></textarea>
		 	</li>
		 	<li>
		 		<font style="line-height: 21px; color: #5B5F60;"><strong>${shopVo.wordNames['gmsc060']}：</strong></font>
				<input type="hidden" name="userId" value="${userId}"/>
				<input type="hidden" name="integralId" value="${integralId}"/>
				<input type="text" name="integralNumber" onkeyup="value=value.replace(/[^(\-\d)]/g,'')" style="height: 21px; width: 160px;"/>
			</li>
		 	<li class="commitBtn">
		 		<check:hasAuthority authorityID="2406"><input type="button" style="width: 100px" onclick="integral_special();" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsf011']}"></check:hasAuthority>&nbsp;&nbsp;&nbsp;&nbsp;
		 		<input type="button" style="width: 100px;" onclick="javascript:parent.$.fancybox.close();" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg217']}">
		 	</li>
		</ul>
	</div>
</body>
</html>
