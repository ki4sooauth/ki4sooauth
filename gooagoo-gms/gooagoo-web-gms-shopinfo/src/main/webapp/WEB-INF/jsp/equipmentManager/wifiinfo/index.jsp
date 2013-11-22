<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140302");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />

<title>${shopVo.wordNames['gmsg262']}</title>
<script type="text/javascript">
	function edit(wifiInfoId){
		var param = "";
		if(wifiInfoId!=null && wifiInfoId!=""&& wifiInfoId!=undefined){
			param="&wifiInfoId="+wifiInfoId;
		}
		$(".fancybox_em").attr("href","${basePath}/wifi.do?method=updateform"+param).click();
	}
	
	function add(){
		$(".fancybox_em").attr("href","${basePath}/wifi.do?method=addform").click();
	}
	
	$(document).ready(function(){
		initFancyBox("fancybox_em",600,550,true);
		page("1");
	})
     
 function deleteWifi(wifiInfoId) {
    	 var param = "wifiInfoId=" +wifiInfoId;
    	 if(confirm("是否将此信息删除?")){
    	 $.ajax({
    			type: "POST",
    			url: "${basePath}/wifi.do?method=delete",
    			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
    			dataType: "json",
    			data:param,
    			timeout: 60000,
    			success: function(msg){
    				if(msg.success){
    					alert(msg.message);
    					 location.reload();
    				}else{
    					alert(msg.message);
    					return;
    				}

    			},
    			error:function(){
    				alert("删除异常,请重新操作");
    			}
    		});
    	 }else return false;
    	
     }
 
 function page(pageIndex){
	    var id ="actionPage";
     var url = "${basePath }/wifi.do?method=page";
	 var data = "&pageIndex="+pageIndex;
     var shopEntityId=$("#shopEntityId").val();
     if(shopEntityId!=""&&shopEntityId!=undefined){
    	 data+="&shopEntityId="+shopEntityId;
     }
     var wifiSsid=$("#wifiSsid").val();
     if(wifiSsid!=""&&wifiSsid!=undefined){
    	 data+="&wifiSsid="+wifiSsid;
     }
	$.ajax({
		type: "POST",
	    async: false,
	    url: url,
	    dataType: 'html',
	    data: data,
		success: function(html){
			$("#" + id).html(html);
		},
		error:function(){
			alert("网络连接异常，请检查网络并重新登录");
			cToTransInfo();
		}
	});
} 
	</script>
</head>
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
<body>

    <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
         <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
         <div class="section">
          <div class="rightTitle_add">
          <check:hasAuthority authorityID="14030202"><a href="javascript:add();">${shopVo.wordNames['gmsg263']}</a></check:hasAuthority> 
            <span>${shopVo.wordNames['gmsg264']}</span>
          </div>
			<ul class="desk-num-poup" style="width: 800px">
			
				<li>
				<%@ include file="/WEB-INF/jsp/common/shopEntity.jsp"%>
				<span style="margin-left: 10px">${shopVo.wordNames['gmsg266']}：</span><input type="text"  class="borderStyle text"  style="width: 150px" id="wifiSsid" value=""/>
				</li>
				    <li class="commitBtn"><input type="submit" onclick="page(1)" class="inputBtn blueBtn" value="${shopVo.wordNames['gmsg293']}"></li>
			</ul>
          <div id="actionPage">

        </div>
</div>
<div style="display: none;">
  <a class="fancybox_em"></a>
</div>
</div>
</div>



</body>
</html>