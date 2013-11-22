<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>审核</title>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function checkArticle(cmsContentId,status){
		$(".inputBtn").attr("disabled","disabled");
		var url = "${basePath}cmsContent.do?method=check";
		var data = "&cmsContentId="+cmsContentId+ "&note="+$("#note").val()+"&publishStatus="+status;
		$.ajax({
	        type: "POST",
	        async: false,
	        url: url,
	        data: data,
	        dataType: "json",
	        success: function(ret){
	        	alert(ret.message);
	        	parent.$.fancybox.close();
	        	if(ret.success){
	        		parent.page(parent.pIndex);
	        		$('.editMenu a').each(function(){
	        			$(this).removeClass().siblings('a').removeClass();
	        		});
	        	}else{
	        		$(".savebtn").attr("disabled",false);
	            }
	        }
	  	});
	}
</script>
</head>
<body>
	<div style="height:auto; padding: 5px 25px;" >
    	<div>
	    	<div style="margin-top:10px;margin-bottom:8px">
	    		<font style="line-height: 21px; color: #5B5F60;"><strong>审核描述：</strong></font>
	    	</div>
	       	<label>
	       		<textarea id="note" name="note" onKeyUp="if(this.value.length > 100) this.value=this.value.substr(0,100)" style=" resize: none; overflow-y:auto; width: 260px; height: 90px;padding:5px" rows="" cols=""></textarea>
	       	</label>
	      	<div style="margin:10px; text-align:center;">
	      		<a href="#" onclick="checkArticle('${cmsContentId}','Y');" style="width: 80px; height: 28px;line-height: 28px; background: none repeat scroll 0 0 #42748B;" class="inputBtn blueBtn"><strong>通过</strong></a>
	      		<span style="width:10px;">&nbsp;</span>
	      		<a href="#" onclick="checkArticle('${cmsContentId}','N');" style="width: 80px; height: 28px;line-height: 28px; background: none repeat scroll 0 0 #42748B;" class="inputBtn blueBtn"><strong>不通过</strong></a>
		  	</div>
    	</div>
	</div>
</body>
</html>
