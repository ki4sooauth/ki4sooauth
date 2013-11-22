<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("leftMenuCode", "1403");
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>手机绑定</title>
<head>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<script type="text/javascript">
// function phoneBinding(){
// 	var oldPhone = $("#oldPhone").val();
// 	var newPhone = $("#newPhone").val();
// 	if(oldPhone==null || oldPhone==""){
// 		$("#message").css("display","");
// 		$("#message").text("当前手机号码不能为空");
// 		return false;
// 	}else if(newPhone==null || newPhone==""){
// 		$("#message").css("display","");
// 		$("#message").text("新手机号码不能为空");
// 		return false;
// 	}if(!checkMobile(oldPhone)){
// 		$("#message").css("display","");
// 		$("#message").text("手机号码格式不正确");
// 		return false;
// 	}else if(!checkMobile(newPhone)){
// 		$("#message").css("display","");
// 		$("#message").text("手机号码格式不正确");
// 		return false;
// 	}
	
// 	$.post("phone.do?method=bindPhone",{"oldPhone":oldPhone,"newPhone":newPhone},function(json){
// 		if(json.success){
// 			$("#message").css("display","none");
// 			$("#oldPhone").val("");
// 			$("#newPhone").val("");
// 			alert(json.message);
// 		}else{
// 			$("#message").css("display","");
// 			$("#message").text(json.message);
// 		}
		
// 	},"json");
// }

$().ready(function(){
	var oldPhone = $("#oldPhone").val();
	var newPhone = $("#newPhone").val();
    var validate=$("#phoneForm").validate({
rules:{
	oldPhone:{required:true},
	newPhone:{required:true,telphone:true},   

 },
messages:{	
	oldPhone:{required:jQuery.format("请输入当前手机号码")},
	newPhone:{required: jQuery.format("请输入新手机号码"),telphone: jQuery.format("请输入正确手机号")},
},
success: function(lable) {
	lable.text("");			 
	},
	submitHandler:function(form){
		   var options = {
				   url:'phone.do?method=bindPhone',
				   type:'post',
				   timeout: 60000,
				   dataType:'json',
				   data:{"oldPhone":oldPhone,"newPhone":newPhone},
					success: function(msg){
						if(msg.success){
							alert(msg.message);
							parent.$.fancybox.close();
// 							page(1);  
// 							location.reload();
						}else{
							alert(msg.message);
							return;
						}
					},
					error:function(){
// 						alert("${wifiinfo.wifiInfoId==null?'添加':'修改'}异常");
					}
		   };    
// 		        $("select[name='shopEntityId']").attr("disabled",false);
		        $("#phoneForm").ajaxSubmit(options); 
		        return false; 	
	}
});
});
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

            <span>手机绑定</span>
          </div>
          <div id="tableList">
             <form id="phoneForm" name="phoneForm">
        	 <ul class="desk-num-poup">
            	<li><span>当前手机号码：</span><input type="text" id="oldPhone"  name="oldPhone" maxlength="11" class="borderStyle text" /><p style="background:none;"><samp id="message" style="display:none"></samp></p></li>
                <li><span>新手机号码：</span><input type="text" id="newPhone" name="newPhone" maxlength="11"/ class="borderStyle text" ><p style="background:none;"></p></li>
                <li class="commitBtn" ><input type="submit"  class="inputBtn blueBtn"  value="保存" /></li>
            </ul>
           
       </form>
        </div>
</div>
<div style="display: none;">
  <a class="fancybox_em"></a>
</div>
</div>
</div>

     
</body>
</html>