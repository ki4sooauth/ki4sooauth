<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "14030401");
request.setAttribute("leftMenuCode", "1403040101");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<title>${shopVo.wordNames['gmsg294']}</title>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<!-- 表单校验 -->
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate-extend.js" charset="UTF-8"></script>
<script type="text/javascript">
$(document).ready(function(){
    var validate=$("#tform").validate({
rules:{
	place:{required:true},
	//state:{ddlRequired:true},   
	remark:{required:true}
 },
messages:{
	place:{required:jQuery.format("请输入位置描述")},
	//state:{required: jQuery.format("请选择")},
	remark:{required:jQuery.format("请输入设备备注")}
},
success: function(lable) {
	lable.text("");			 
},
	submitHandler:function(form){
		$("#idDisable").attr("disabled",true);
		   var options = {
				   url:'${basePath}/transpcInfo.do?method=update',
				   type:'post',
				   dataType: 'json',
				   timeout: 60000,
					success: function(data){
						$("#idDisable").attr("disabled",false);
						if(data.success){
							alert(data.message);
							parent.$.fancybox.close();
							parent.page(1);
						}else{
							alert(data.message);
							return;
						}
						
					},
					error:function(){
						$("#idDisable").attr("disabled",false);
						alert("修改异常");
					}
			}
       $("#tform").ajaxSubmit(options); 
       return false; 	
	}
});
});
function cancel(){
	parent.$.fancybox.close();
}
</script>
</head>
<body>

 <form name="tform" id="tform" method="post">

     <input type="hidden" value="${transpcInfo.deviceTransponderId}" name="deviceTransponderId">
 <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg295']}</span>
          </div>
</div>
     <ul class="desk-num-poup">
     <li><span>${shopVo.wordNames['gmsg296']}</span>${transpcInfo.deviceMac}</li>
     <li><span>${shopVo.wordNames['gmsg297']}</span><input type="hidden" value="${transpcInfo.deviceType}">${transpcInfo.typeNameCh}</li>
     <li><span>${shopVo.wordNames['gmsg278']}：</span>
	     <select name="status" id="status2"  class="borderStyle select">
	     <c:forEach items="${deviceStatus}" var="t">
				<option  value="${t.key}" ${transpcInfo.status eq t.key?"selected='selected'":""}>${t.value}</option>
		 </c:forEach>
		</select>
	 </li>      
     <li><span>${shopVo.wordNames['gmsg298']}</span><textarea name="note" id="remark" style="width:300px;height:155px" maxlength="255">${transpcInfo.note }</textarea></li>
     <li class="commitBtn" >
     <input type="submit" class="inputBtn blueBtn" id="idDisable"  style="background: none repeat scroll 0 0 #0873B9;width: 150px" value="${shopVo.wordNames['gmsg260']}"  />&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="inputBtn blueBtn"  style="background: none repeat scroll 0 0 #0873B9;width: 150px" onclick="cancel()" value="${shopVo.wordNames['gmsg240']}" />
     <input type="hidden" value="${info.deviceTransponderId}" name="deviceTransponderId"></li>
     </ul>

  </form>

</body>
</html>