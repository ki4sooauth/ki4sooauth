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
	var sType = "${sType}";
	$(function(){
		var trs = parent.$(".table_list_"+sType).find("tr");
		var tds = trs.eq(indexNum).find("td");
		var lis = $(".desk-num-poup").find("li");
		for(var i=0; i<lis.length-2; i++){
			lis.eq(i).append(tds.eq(i+1).html());
		}
	})

	function card_special(){
	 	var gradeId = "${gradeId}";
	 	var cardId = $("select[name='cardId']").val();
	 	var userId = $("input[name='userId']").val();
	 	
	 	if(cardId==""){
			alert("请选择等级！");
			return;
	 	}
	 	if($.trim(cardId)==$.trim(gradeId)){
	 		alert("用户已有此会员卡！");
	 		return false;
	 	}
	 	
	 	var data = "userId="+userId+"&cardId="+cardId+"&gradeId="+gradeId;
		$.ajax({
		  	async:false,
	     	type:"POST",
	     	dataType: 'json',
	     	data:data,
	     	url:basePath + "memberOfCard.do?method=memSpecialApproval",
	     	success:function(data){
	       		if(data.success){
	         		alert(data.message);
	         		parent.$("#applySearch").click();
	         		parent.$.fancybox.close();
	         		page(1);
	       		}else{
	         		alert(data.message);
	      	 	}		  
	    	}	 
		});	
	}
</script>
</head>
<body>
	<div style="width: 400px;">
		<ul class="desk-num-poup" style="width: 350px;">
			<li><span>${shopVo.wordNames['cpme086']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme087']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme088']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme089']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme090']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme091']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme092']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme093']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme094']}</span>&nbsp;</li>
			<li><span>${shopVo.wordNames['cpme095']}</span>&nbsp;</li>
		 	<li>
		 		<font style="line-height: 21px; color: #5B5F60;"><strong>${shopVo.wordNames['cpme103']}：</strong></font>
				<input type="hidden" name="userId" value="${userId}"/>
				<select name = "cardId">
		        	<option value="">--${shopVo.wordNames['gmsb018']}--</option>
		        	<c:forEach items="${cardList}" var="card">
		        		<option value="${card.cardId}" <c:if test="${card.cardId == gradeId}">selected="selected"</c:if>>${card.cardName}</option> 
		        	</c:forEach>   
		      	</select>
			</li>
		 	<li class="commitBtn">
		 		<check:hasAuthority authorityID="240502"><input type="button" style="width: 100px" onclick="card_special();" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsf011']}"></check:hasAuthority>&nbsp;&nbsp;&nbsp;&nbsp;
		 		<input type="button" style="width: 100px;" onclick="javascript:parent.$.fancybox.close();"  class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg217']}">
		 	</li>
		</ul>
	</div>
</body>
</html>
