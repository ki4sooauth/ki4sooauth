<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140303");
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<title>${shopVo.wordNames['gmsg351']}</title>
<head>
<script type="text/javascript">
     function edit(id,pid){
    	 $("#emFancybox").attr("href","${basePath}/wifisensor.do?method=detail&id="+id+"&positionId="+pid).click();
    }
  //位置标签设备管理
    function page(pageIndex){
    	    var id ="actionPage";
            var url = "${basePath }/wifisensor.do?method=page";
    	    var deviceSn=$("#deviceSn").val();
    		var positionName=$("#positionName").val();
    		var status=$("#status").val();
    		var data = "&pageIndex="+pageIndex;
    		if(deviceSn !="" && deviceSn !=undefined)
    		{
    			data+="&deviceSn="+deviceSn;
    		}
    		if(positionName !="" && positionName !=undefined)
    		{
    			data+="&positionName="+positionName;
    		}
    		if(status !="" && status !=undefined)
    		{
    			data+="&status="+status;
    		}
    		 var shopEntityId=$("#shopEntityId").val();
    	     if(shopEntityId!=""&&shopEntityId!=undefined){
    	    	 data+="&shopEntityId="+shopEntityId;
    	     }
    	$.ajax({
    		type: "POST",
    	    async: false,
    	    url: url,
    	    dataType: 'html',
    	    data: data,
    		success: function(html){
    			$("#"+id).html(html);
    		},
    		error:function(){
    			alert("网络连接异常，请检查网络并重新登录");
    			cToLID();
    		}
    	});
    }
  
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
            <span>${shopVo.wordNames['gmsg351']}</span>
          </div>
			<ul class="desk-num-poup" style="width:800px">
				<li style="margin-right: 15px">
				<%@ include file="/WEB-INF/jsp/common/shopEntity.jsp"%>
				<c:if test="${not empty gmsLoginInfo.shopEntityId}">
				<span>${shopVo.wordNames['gmsg352']}：</span>
					<input type="text" name="deviceSn" class="borderStyle text"  style="width: 150px" id="deviceSn" value=""/>
				</c:if>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg353']}：</span>
					<input type="text" class="borderStyle text" style="width: 150px" name="positionName" id="positionName"/>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg354']}：</span>
					<select name="status" id="status" class="borderStyle select">
							<option value="">${shopVo.wordNames['gmsg355']}</option>
							<option value="0" ${condition.status eq '0'?'selected=selected':''}>${shopVo.wordNames['gmsg356']}</option>
							<option value="1" ${condition.status eq '1'?'selected=selected':''}>${shopVo.wordNames['gmsg357']}</option>
							<option value="2" ${condition.status eq '2'?'selected=selected':''}>${shopVo.wordNames['gmsg358']}</option>
					</select>
				</li>
					<li class="commitBtn"><input type="submit" onclick="page(1)" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg359']}"></li>
			</ul>
<div style="display: none;">
	<a href="#" id="emFancybox" class="fancybox_em"></a>
</div>
 <div id="actionPage">
        </div>
</div>

</div>
</div>

    	
</body>
</html>

