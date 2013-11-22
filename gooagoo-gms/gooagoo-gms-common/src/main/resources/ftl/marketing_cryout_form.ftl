<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑活动内容</title>
<#include "script_common.ftl">
<#include "script_fancybox.ftl">
<script type='text/javascript' src='${imgPath}/common/js/kindeditor/kindeditor-min.js' charset='utf-8'></script>
<link rel="stylesheet" href="${imgPath}/common/js/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${imgPath}/common/js/kindeditor/lang/zh_CN.js"></script>
<script src="${imgPath}/gms/common/js/popLB.js"></script>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/add_actPop.css" rel="stylesheet" type="text/css" />
<script src="${imgPath}/gms/active/js/activeCont.js"></script>
<script>
	$(document).ready(function(){
		var uri=$('#img').val();
		if(!isEmpty(uri)){
			listImg(uri);
		}
		initFancyBox("fancybox_list",800,600,true);
		intFancybox2();
	});
	function intFancybox2(){
		$(".fancybox_relate").fancybox({
			'width'				: 800,
			'height'			: 570,
			'padding'			: 0,
			'autoScale'			: false,
			'autoDimensions'    : true,
			'transitionIn'		: 'yes',
			'transitionOut'		: 'yes',
			'href'				: $(this).attr('href'),
			'type'				:'iframe',
			'hideOnOverlayClick': false,
			'showCloseButton'	:true,
			'changeSpeed'		:200,
			'onStart'			:function(){if(!checkIsOnly()){return false;}}
		});
	}
	function checkIsOnly(){
		if($("#textWeb").val().indexOf("<a id=\"marketingLink\"")!=-1){
			alert("只能添加一条信息！");
			return false;
		}else{
			return true;
		}
	}
	function checkValue(){
		var title = $("#cryout input[name=cryoutTitle]").val();
		var cryoutType = $("#cryout input:radio[name=cryoutType]:checked").val();
		var cont = $("#textWeb").val().replace(/<.+?>/gim,'').replace(/&nbsp;/ig,'').replace(/(^\s+)|(\s+$)/g,"")

		if (isEmpty($.trim(title))){
		   	alert("吆喝标题不能为空！");
		   	return false;
	   	}else if(title.length>32){
	   		alert("标题最多为32个字符！")
	   		return false;
	   	}
		if (isEmpty($.trim(cryoutType))){
			alert("请选择吆喝类型！");
			return false;
		}
		if (isEmpty($.trim(cont))){
			alert("请添加吆喝内容！");
			return false;
		}
		return true;
	}
	function saveCryout(){
		$("#btn").attr("disabled",true);
		
		if(checkValue()){
			var activityId=$("#cryout input[name=activityId]").val();
		    var contId = $("#contId").val();
		    if(isEmpty(contId)){
		    	methodName="add";
		    }else{
		    	methodName="update";
		    	$("#cryoutInfoId").val(contId);
		    }
		
		    var url = "${basePath }activityCont.do?method=" + methodName;
		    var data = $("#cryout").serialize()+"&channelCode=1";
		    ajaxJsonTipByData(url,data,true,"");
		    parent.$("#tab_list a").eq(1).click();
		    parent.$.fancybox.close();
		}else{
			$("#btn").attr("disabled",false);
		}
	}
 	function relateFancyBox(type){
	 	var url = "";
	 	if(type=="Goods"){
		 	url = "${basePath }relation.do?method=listRelation&selectType=&relateType=G&marketingId=${marketingId}";
	 	}else if(type=="Coupon"){
		 	url = "${basePath }relation.do?method=listRelation&selectType=&relateType=C&dataType=C&marketingId=${marketingId}";
	 	}else if(type=="Activity"){
		 	url = "${basePath }relation.do?method=listRelation&selectType=&relateType=A&marketingId=${marketingId}";
	 	}
		$("#relateFancybox").attr("href",url).click();
 	}
	function dealRelations(relations){
		$("#marketingLinkType").val(relations[0][0]);
		$("#marketingLinkId").val(relations[0][1]);
		var url = "#";
		if(relations[0][0]=='A'){
		 	url = relations[0][7];
		}else{
		 	url = relations[0][9];
		}
		var cont = "<a id='marketingLink' href='"+url+"' class='marketingLink'>"+relations[0][2]+"</a> ";
		if((editor.text().length+relations[0][2].length)<=140){
			editor.insertHtml(cont);
			listImg(relations[0][3]);
			$.fancybox.close();
		}else{
			alert("选择此信息后，编辑显示内容将超出允许输入的最大范围！")
		}
	}
 	function listFancybox(){
 		var url = "${basePath }activityCont.do?method=contList&pageIndex=1&pageSize=10&channelCode=1&marketingId=${marketingId}";
 		$("#listFancybox").attr("href",url).click();
 	}
	function selectOne(id, marketingId){
		var activityId=parent.$("#activityId").val();
		var data = "&id="+id+"&activityId="+activityId+"&channelCode=1&marketingId="+marketingId;
		var url = "${basePath }activityCont.do?method=updateContform";
		ajaxToPageByData(url,"waitRelateCont",data);
		$.fancybox.close();
	}
	function listImg(url){
		if(isEmpty(url)){
			return;
		}
		var urls = url.split(",");
		var imgList = $("#relateImgList");
		imgList.html("");
		for(var i=0;i<urls.length;i++){
			var cont = "<li><a href='javascript:void(0);'><img onclick='selectImg(this.src)' src='"+urls[i]+"' width='130' height='130' /></a></li>";
			imgList.append(cont);
		}
		imgList.css("display","");
		$("#relateImg").css("display","");
		$("#img").val(urls[0]);
		$("#relateImg").find("img").attr("src",urls[0]);
	}
	function selectImg(url){
		$("#img").val(url);
		$("#relateImg").find("img").attr("src",url);
	}
</script>
</head>
<body>
<div class="add_actPopBox" style="width:96%; margin: 0 auto; padding:15px 0 0 0;">
	<#include "marketing_content_tab.ftl">
	<div style="display:none;">
		<a href="#" id="relateFancybox" class="fancybox_relate"></a>
		<a href="#" id="listFancybox" class="fancybox_list"></a>
	</div>
	<div>
    	<div class="incidentContent">
    		<form action="" id="cryout">
    			<div class="ICtop">
		    	 	<input type="hidden" id="cryoutInfoId" name="cryoutInfoId" value="${cryout.cryoutInfoId!}" />
		            <input type="hidden" id="activityId" name="activityId" value="${activityId}"  />
		           	<input type="hidden" name="marketingLinkId" id="marketingLinkId" value="${cryout.marketingLinkId!}"/>
					<input type="hidden" name="marketingLinkType" id="marketingLinkType" value="${cryout.marketingLinkType!}"/>
					<input type="hidden" name="img" id="img" value="${cryout.img!}"/>
					<input type="hidden" name="marketingId" id="marketingId" value="${marketingId}"/>
					<input type="hidden" name="contId" id="contId" value="${contId}"/>
					<input type="hidden" name="channelCode" id="channelCode" value="${channelCode}"/>
					<!--<ul>-->
					<!--	<li>-->
					<!--		<span>复制已有信息</span>-->
					<!--		<input onclick="listFancybox();" class="longInput fancybox" type="text" name="" value="点击进行选择" readonly="readonly" style="cursor: pointer; color:#a0a0a0; text-align: center;"/>-->
					<!--	</li>-->
					<!--</ul>-->
	        		<ul>
						<li><span>${shopVo.wordNames['gmsc221']}</span>
							<input class="longInput" type="text" name="cryoutTitle" value="${cryout.cryoutTitle!}" maxlength="32"/>
						</li>
						<li><span>${shopVo.wordNames['gmsc222']}</span>
							<input class="check"  type="radio" name="cryoutType" value="L" checked/>
							<label>${shopVo.wordNames['gmsc223']}</label>
							<input class="check" type="radio" name="cryoutType" value="R" <#if cryout.cryoutType??&&cryout.cryoutType=="R">checked</#if>/>
							<label>${shopVo.wordNames['gmsc224']}</label>
	                	</li>
	             	</ul>
	        	</div>  
	      		<h2 class="title">${shopVo.wordNames['gmsc213']}</h2>
	        	<div class="ICmiddle2">
		        	<div class="textarea_Yh">
		            	<textarea id="textWeb" name="textWeb" style="width: 931px; height: 150px;">${cryout.cryoutTextWeb!}</textarea>
		                <div align="right"><samp style="color: gray;">最多可输入140字符，已输入<font id="hasNum"></font>个字符，可继续输入<font id="allowNum"></font>个字符</samp></div>
		                <a href="javascript:void(0);" onclick="relateFancyBox('Goods');" class="blueBtn">${shopVo.wordNames['gmsc210']}</a>
		                <a href="javascript:void(0);" onclick="relateFancyBox('Coupon');" class="blueBtn">${shopVo.wordNames['gmsc211']}</a>
		                <a href="javascript:void(0);" onclick="relateFancyBox('Activity');" class="blueBtn">${shopVo.wordNames['gmsc212']}</a>
		            </div>
		            <ul id="relateImgList" class="imgList" style="display:none;">
		            </ul>
					<div id="imgTip" style="display:none;">${shopVo.wordNames['gmsc247']}</div>
		        </div>
		        <div id="relateImg" class="ICbottom" style="display:none;">        
		            <span class="img_wrap">
		            	<img width="130" height="130" src="${cryout.img!}" />
		            </span>
		        </div>
	        	<a href="javascript:void(0);" id="btn" class="saveSet blueBtn" onclick="saveCryout();" >${shopVo.wordNames['gmsc002']}</a>
			</form>
    </div>
</div>
</div>
<script type='text/javascript'>
	//编辑器
	var editor = KindEditor.create('#textWeb', {
		allowFileManager : true,
		afterChange : function() {
			this.sync();
			recount(this);
		},
		height : 140,
		width  : 900,
		resizeType : 0,//2或1或0，2时可以拖动改变宽度和高度，1时只能改变高度，0时不能拖动。 
		items : [ 'bold', 'italic', 'underline', 'strikethrough',
				'removeformat', '|', 'insertorderedlist',
				'insertunorderedlist', 'forecolor', 'hilitecolor',
				'fontname', 'fontsize', '|', 'link', 'unlink', 'emoticons',
				'shcode', 'quote', '|', 'about' ]
	});
	function recount(editor) {
		var maxlen = 140;
		var current = maxlen - editor.text().length;
		$('#hasNum').html(editor.text().length);
		$('#allowNum').html(current);
		$('.counter').html(current);
		clearImg();
		if(current<0 || current>maxlen) {
			contCryout = editor.text().substring(0,maxlen);
			editor.html("");
			editor.appendHtml(contCryout);
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
