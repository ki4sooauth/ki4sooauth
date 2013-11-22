<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140301");
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<title>${shopVo.wordNames['gmsg226']}</title>
<head>
<script type="text/javascript">
     function edit(lid,pid){
    	 $("#emFancybox").attr("href","${basePath}/shopLidDetail.do?method=getLidDetail&lid="+lid+"&positionId="+pid).click();
    }
  //位置标签设备管理
    function page(pageIndex){
    	    var id ="actionPage";
            var url = "${basePath }/shopLidDetail.do?method=pageLidDetail";
    	    var lid=$("#lid").val();
    		var positionName=$("#positionName").val();
    		var status=$("#status").val();
    		var shopEntityId=$("#shopEntityId").val();
    		var data = "&pageIndex="+pageIndex;
    		if(lid !="" && lid !=undefined)
    		{
    			data+="&lid="+lid;
    		}
    		if(positionName !="" && positionName !=undefined)
    		{
    			data+="&positionName="+positionName;
    		}
    		if(status !="" && status !=undefined)
    		{
    			data+="&status="+status;
    		}
    		if(shopEntityId !="" && shopEntityId !=undefined)
    		{
    			data+="&shopEntityId="+shopEntityId;
    		}
    	$.ajax({
    		type: "POST",
    	    async: false,
    	    url: url,
    	    dataType: 'html',
    	    data: data,
    		success: function(html){
//     			window.body.innerHTML=html;
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
            <span>${shopVo.wordNames['gmsg226']}</span>
          </div>
			<ul class="desk-num-poup" style="width:800px">
				<li style="margin-right: 15px">
				<%@ include file="/WEB-INF/jsp/common/shopEntity.jsp"%>
				<c:if test="${not empty gmsLoginInfo.shopEntityId}">
				<span >${shopVo.wordNames['gmsg227']}：</span><input type="text" name="lid" class="borderStyle text"  style="width: 150px" id="lid" value=""/>
				</c:if>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg228']}：</span><input type="text" class="borderStyle text" style="width: 150px" name="positionName" id="positionName"/>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg229']}：</span><select name="status" id="status" class="borderStyle select">
						<option value="">${shopVo.wordNames['gmsg241']}</option>
						<option value="Y" ${condition.status eq 'Y'?'selected=selected':''}>${shopVo.wordNames['gmsg242']}</option>
						<option value="N" ${condition.status eq 'N'?'selected=selected':''}>${shopVo.wordNames['gmsg243']}</option>
						<option value="S" ${condition.status eq 'S'?'selected=selected':''}>${shopVo.wordNames['gmsg244']}</option>
						<option value="D" ${condition.status eq 'D'?'selected=selected':''}>${shopVo.wordNames['gmsg245']}</option>
				</select></li>
					<li class="commitBtn"><input type="submit" onclick="page(1)" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg230']}"></li>
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

