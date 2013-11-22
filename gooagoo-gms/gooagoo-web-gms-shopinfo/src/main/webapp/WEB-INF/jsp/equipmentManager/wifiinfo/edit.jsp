<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%> 
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "14030201");
request.setAttribute("leftMenuCode", "1403020101");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<!-- 表单校验 -->
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate-extend.js" charset="UTF-8"></script>
<title>${shopVo.wordNames['gmsg251']}</title>
<script type="text/javascript">
$().ready(function(){
	var wifiInfoId=$("#wifiInfoId").val();
    var validate=$("#wform").validate({
rules:{
	wifiSsid:{required:true},
    wifiMac:{required:true,mac:true},   
    shopEntityId:{required:true},   
    wifiPassword:{required:true},	  
    confirm_password:{required:true,equalTo:"#wifiPassword"}
 },
messages:{	
	wifiSsid:{required:jQuery.format("请输入Wifi的名称")},
    wifiMac:{required: jQuery.format("请输入正确的16进制mac地址"),mac:jQuery.format("请填写正确的mac地址")},
	shopEntityId:{required: jQuery.format("所属实体店不能为空")},
    wifiPassword:{required:jQuery.format("请输入口令")}, 
    confirm_password:{required:jQuery.format("请输入口令"),equalTo:jQuery.format("两次口令不一致")},  
},
success: function(lable) {
	lable.text("");			 
	},
	submitHandler:function(form){
		$("#idDisable").attr("disabled",true);
		   var options = {
				   url:'${basePath}/wifi.do?method=saveOrUpdate&wifiId='+wifiInfoId,
				   type:'post',
				   timeout: 60000,
				   dataType:'json',
					success: function(msg){
						$("#idDisable").attr("disabled",false);
						if(msg.success){
							alert(msg.message);
							parent.$.fancybox.close();
							parent.page(1);  
// 							location.reload();
						}else{
							alert(msg.message);
							return;
						}
					},
					error:function(){
						$("#idDisable").attr("disabled",false);
						alert("${wifiinfo.wifiInfoId==null?'添加':'修改'}异常");
					}
		   };    
		        $("select[name='shopEntityId']").attr("disabled",false);
		        $("#wform").ajaxSubmit(options); 
		        return false; 	
	}
});
});
// function page(pageIndex){
// 	var data ={"pageIndex":pageIndex,"pageSize":10};
// 	var url="${basePath}/wifi.do?method=page";
// 	ajaxToPageByData(url, "index", data);
// }
function ajaxToPageByData(url, id, data){
	$.ajax({
		type: "POST",
	    async: false,
	    url: url,
	    data: data,
		success: function(html){
			$("#" + id).html(html);
		}
	});
}
</script>

</head>
<body>
<!--商家wifi管理弹出框-->
 <form name="wform" id="wform" method="post">
     <input type="hidden" name="wifiInfoId" value="${wifiInfo.wifiInfoId}"/>
          	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg254']}${wifiInfo.wifiInfoId==null?shopVo.wordNames['gmsg252']:shopVo.wordNames['gmsg253']}</span>
          </div>
</div>
<%--      <h1>Wifi信息${wifiInfo.wifiInfoId==null?'添加':'编辑'}：</h1> --%>
     <ul class="desk-num-poup">
     <li><span>${shopVo.wordNames['gmsg255']}</span><input type="text" name="wifiSsid" class="borderStyle text" value="${wifiInfo.wifiSsid}" maxlength="32"/></li>
     <li><span>${shopVo.wordNames['gmsg256']}</span><input type="text"  name="wifiMac" class="borderStyle text" value="${wifiInfo.wifiMac}" maxlength="20"/></li>
     <li>
	   <span>${shopVo.wordNames['gmsg257']}</span>
		<select style="width:110px;" class="borderStyle select" name="shopEntityId" ${not empty loginInfo.shopEntityId?"disabled='disabled'":""}>
		   <option value="">${shopVo.wordNames['gmsg134']}</option>
		   <c:forEach items="${entityList}" var="entity">
		   <option ${wifiInfo.shopEntityId eq entity.shopEntityId?"selected=selected":""}  ${loginInfo.shopEntityId eq entity.shopEntityId?"selected=selected":""} value="${entity.shopEntityId}">${entity.shopEntityName}</option>
		   </c:forEach>
		</select>
	 </li>
     <li><span>${shopVo.wordNames['gmsg258']}</span><input type="text"  class="borderStyle text" name="wifiPassword" id="wifiPassword" value="${wifiInfo.wifiPassword}" maxlength="30"/></li>
     <li><span>${shopVo.wordNames['gmsg259']}</span><input type="text" name="confirm_password" value="${wifiInfo.wifiPassword}" maxlength="30"/></li>
     <li class="commitBtn" >
     <input type="submit" class="inputBtn blueBtn" id="idDisable"  style="width: 150px" value="${shopVo.wordNames['gmsg260']}"  />&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="inputBtn blueBtn"  style="width: 150px;" onclick="cancel()" value="${shopVo.wordNames['gmsg240']}" />
     </li>
     </ul>
     
     <input type="hidden" name="wifiInfoId" id="wifiInfoId" value="${wifiInfo.wifiInfoId}">
 </form>
<script type="text/javascript">
function cancel(){
	parent.$.fancybox.close();
}
</script>
</body>
</html>