<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsd101']}</title>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="relateFancybox" class="fancybox_relate"></a>
	</div>
		<div class="rightTitle_add">
        	<span >编辑吆喝</span>       
        	 <a href="javascript:window.location.href='${basePath}cryout'">返回列表</a>
		</div>	                 
	<div>
    	<div class="incidentContent">
    		<form action="" id="cryout" method="post">
    			<div class="ICtop">
	    	 	<input type="hidden" id="cryoutInfoId" name="cryoutInfoId" value="${cryout.cryoutInfoId}" />
	           	<input type="hidden" id="cryoutType" name="cryoutType" value="${cryout.cryoutType}"  />
	           	<input type="hidden" id="activityName" name="activityName" value="${cryout.activityName}" />
	           	<input type="hidden" id="activeStartTime" name="activeStartTime" value="<fmt:formatDate value="${cryout.activeStartTime}" type="both" pattern="yyyy-MM-dd" />" />
				<input type="hidden" id="activeEndTime" name="activeEndTime" value="<fmt:formatDate value="${cryout.activeEndTime}" type="both" pattern="yyyy-MM-dd" />" />
				<input type="hidden" id="activityId" name="activityId" value="${cryout.activityId}"  />
	           	<input name="marketingLinkId" id="marketingLinkId" type="hidden" value="${cryout.marketingLinkId}"/>
				<input name="marketingLinkType" id="marketingLinkType" type="hidden" value="${cryout.marketingLinkType}"/>
				<input name="img" id="img" type="hidden" value="${cryout.img}"/>
        		<ul>
					<li><span>${shopVo.wordNames['gmsc221']}</span>
						<input class="longInput" type="text" name="cryoutTitle" value="${cryout.cryoutTitle}"/>
					</li>
					<li><span>${shopVo.wordNames['gmsc222']}</span>
						<input class="check" id="radio"  type="radio" name="cryoutTypes" value="L" ${cryout.cryoutType=="L" ? "checked" : ""} ${empty cryout.cryoutInfoId ? "checked" : ""} />
						<label>${shopVo.wordNames['gmsc223']}</label>
						<input class="check" type="radio" name="cryoutTypes" value="R" ${cryout.cryoutType=="R" ? "checked" : ""}/>
						<label>${shopVo.wordNames['gmsc224']}</label>
                	</li>
             	</ul>
        	</div>  
               <h2 class="title">${shopVo.wordNames['gmsc213']}</h2>	      	
	        	<div class="ICmiddle2">
		        	<div class="textarea_Yh">
		            	<textarea id="textWeb" name="textWeb" style="width: 931px; height: 150px;">${cryout.cryoutTextWeb}</textarea>
		                <a href="javascript:void(0);" onclick="relateFancyBox('Goods');" class="blueBtn">${shopVo.wordNames['gmsc210']}</a>
		                <a href="javascript:void(0);" onclick="relateFancyBox('Coupon');" class="blueBtn">${shopVo.wordNames['gmsc211']}</a>
		                <a href="javascript:void(0);" onclick="relateFancyBox('Activity');" class="blueBtn">${shopVo.wordNames['gmsc212']}</a>
		            </div>
		            <ul id="relateImgList" class="imgList" style="display:none;">
		<%--                 <li><a href="#"><img src="${imgPath}/gms/common/images/actpop.jpg" width="130" height="130" /></a></li> --%>
		            </ul>
					<div id="imgTip" style="display:none;">${shopVo.wordNames['gmsc247']}</div>
		        </div>
		        <div id="relateImg" class="ICbottom" style="display:none;">        
		            <span class="img_wrap">
		            	<img width="130" height="130" src="${cryout.img}" />
		            </span>
		        </div>
	        	<a href="javascript:void(0);" id="btn" class="saveSet blueBtn" onclick="saveCryout();" style="margin-right: 450px;margin-top: 50px">保存</a>	&emsp;	
	        	<check:hasAuthority authorityID='13060204'>        
	        	<a href="javascript:void(0);" id="btn" class="saveSet blueBtn" onclick="saveCryout('release');" style="margin-right: 200px;margin-top: -55px" >发布</a>
			    </check:hasAuthority>
			</form>
    </div>
</div>
<script type='text/javascript'>
	//编辑器
	var editor = KindEditor.create('#textWeb', {
		allowFileManager : true,
		afterChange : function() {
			this.sync();
			recount();
		},
		height : 140,
		resizeType : 0,//2或1或0，2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。 
		items : [ 'bold', 'italic', 'underline', 'strikethrough',
				'removeformat', '|', 'insertorderedlist',
				'insertunorderedlist', 'forecolor', 'hilitecolor',
				'fontname', 'fontsize', '|', 'link', 'unlink', 'emoticons',
				'shcode', 'quote', '|', 'about' ]
	});
	function recount() {
		var maxlen = 140;
		var current = maxlen - $('#textWeb').val().length;
		$('.counter').html(current);
		clearImg();
		if(current<1 || current>maxlen) {
			$('.counter').css('color', '#D40D12');
			$('input.sub_btn').attr('disabled', 'disabled');
		}else{
			$('input.sub_btn').removeAttr('disabled');
		}
		if(current < 10){
			$('.counter').css('color', '#D40D12');
		}else if (current < 20){
			$('.counter').css('color', '#5C0002');
		}else{
			$('.counter').css('color', '#cccccc');
		}
	}
	//关联内容删除链接的活动、商品、优惠凭证时，清空关联图片
	function clearImg(){
		if($("#textWeb").val().indexOf("<a id=\"marketingLink\"")==-1){
			$("#relateImgList").html("").css("display","none");
			$("#relateImg").css("display","none").find("img").attr("src","");
			$("#marketingLinkId").val("");
			$("#marketingLinkType").val("");
		}
	}
</script>
</body>
</html>
