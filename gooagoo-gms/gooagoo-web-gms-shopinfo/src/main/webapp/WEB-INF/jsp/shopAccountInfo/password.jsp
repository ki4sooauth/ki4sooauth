<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1401");
request.setAttribute("leftMenuCode", "140102");
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${shopVo.wordNames['gmsg004']}</title>
<head>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function(){

	var oldPassword = $("#oldPassword").val();
	var newPassword = $("#newPassword").val();
	var rePassword = $("#newPasswordRe").val();
// 	var wifiInfoId=$("#wifiInfoId").val();
    var validate=$("#pwdForm").validate({
rules:{
	oldPassword:{required:true},
	newPassword:{required:true},   
	newPasswordRe:{required:true,equalTo:"#newPassword"},   

 },
messages:{	
	oldPassword:{required:jQuery.format("请输入原密码")},
	newPassword:{required: jQuery.format("请输入新密码")},
    newPasswordRe:{required:jQuery.format("请再次输入密码"),equalTo:jQuery.format("两次密码不一致")},  
},
success: function(lable) {
	lable.text("");			 
	},
	submitHandler:function(form){
		$("#idDisable").attr("disabled",true);
		   var options = {
				   url:'password.do?method=updatePwd',
				   type:'post',
				   timeout: 60000,
				   dataType:'json',
				   data:{"oldPassword":oldPassword,"newPassword":newPassword},
					success: function(msg){
						if(msg.success){
							$("#idDisable").attr("disabled",false);
							alert(msg.message);
							$("input:password").val("");
							parent.$.fancybox.close();
// 							page(1);  
// 							location.reload();
						}else{
							$("#idDisable").attr("disabled",false);
							alert(msg.message);
							return;
						}
					},
					error:function(){
// 						alert("${wifiinfo.wifiInfoId==null?'添加':'修改'}异常");
					}
		   };    
// 		        $("select[name='shopEntityId']").attr("disabled",false);
		        $("#pwdForm").ajaxSubmit(options); 
		        return false; 	
	}
});
});
$(function(){
	$('input[type=password]').mouseover(function(){
		$('input[type=password]').removeClass("budui");
		$(this).addClass("budui");
	})
})

function testPassword(){
	var newPassword = $("#newPassword").val();
	var st = AuthPasswd(newPassword);
	switch(st){
	case 0: $("#strong").attr("width","40");$("#stDes").html("弱");break;
	case -1: $("#strong").attr("width","80");$("#stDes").html("中");break;
	case 1: $("#strong").attr("width","120");$("#stDes").html("强");break;
	}
}
function AuthPasswd(string) {
	if(string.length >=6) {
		if(/[a-zA-Z]+/.test(string) && /[0-9]+/.test(string) && /\W+\D+/.test(string)) {
			return 1;
		}else if(/[a-zA-Z]+/.test(string) || /[0-9]+/.test(string) || /\W+\D+/.test(string)) {
			if(/[a-zA-Z]+/.test(string) && /[0-9]+/.test(string)) {
				return -1;
			}else if(/\[a-zA-Z]+/.test(string) && /\W+\D+/.test(string)) {
				return -1;
			}else if(/[0-9]+/.test(string) && /\W+\D+/.test(string)) {
				return -1;
			}else{
				return 0;
			}
		}
	}else{
		return 0;
	}
}

function light(dom){
	$('input[type=text]').addClass("budui");
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
            <span>${shopVo.wordNames['gmsg004']}</span>
          </div>
          <div id="tableList">
        <form action="" method="" name="pwdForm" id="pwdForm">
        	<ul class="desk-num-poup">
            	<li>
            		<span>${shopVo.wordNames['gmsg044']}</span><input type="password" id="oldPassword" name="oldPassword" class="borderStyle text"  />
            		<p id="oldMessage" style="display:none"></p>
            	</li>
                <li>
                	<span>${shopVo.wordNames['gmsg045']}</span><input type="password" id="newPassword"  name="newPassword" onchange="testPassword()" class="borderStyle text" />
                	<p id="newMessage" style="display:none"></p>
                </li>
                <li style="margin-top:5px">
                	<span>${shopVo.wordNames['gmsg046']}</span>
                	<img id="strong" src="${imgPath}/gms/shopinfo/images/Account/qd.jpg" width="0"/>
                	<b id="stDes"></b>
                </li>
                <li style="margin-top:0px">
                	<span>${shopVo.wordNames['gmsg047']}</span>
                	<input type="password" id="newPasswordRe" name="newPasswordRe" class="borderStyle text" />
                	<p id="reMessage" style="display:none"></p>
                <li class="commitBtn">
                <check:hasAuthority authorityID="140102"> 
                	<input type="submit" id="idDisable" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg043']}" style="margin:0" />
                </check:hasAuthority>
                </li>
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