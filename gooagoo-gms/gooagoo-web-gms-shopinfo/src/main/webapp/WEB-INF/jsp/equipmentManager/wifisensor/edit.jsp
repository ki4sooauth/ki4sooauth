<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "14030301");
request.setAttribute("leftMenuCode", "1403030101");
%>

<title>${shopVo.wordNames['gmsg366']}</title>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js" charset="UTF-8"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate-extend.js" charset="UTF-8"></script>



<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/demo.css" type="text/css"/>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.exedit-3.5.js"></script>

<link href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.js" ></script>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.pack.js" ></script>

<script >
$(document).ready(function(){
	initFancyBox("fancybox_relate",240,450,true);
});
function relateOne(){
	var shopEntityId ="";// $("#shopEntityId").val() ;
	var url = "${basePath }/relation.do?method=treeRelation&relateType=I&entityId="+shopEntityId ;
	$("#relateFancybox").attr("href",url).click();
}

function dealRelations(relations){
	 $("#positionId").val(relations[0][1]) ;
	 $("#citySel").val(relations[0][2]) ;
	 $.fancybox.close();
}

</script>
</head>
<body>
           	         <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg366']}</span>
          </div>
</div>
           <ul class="desk-num-poup" style="height: 30px">
           <li><span>${shopVo.wordNames['gmsg352']}</span>
           <input type="hidden" id="shopId" value="${wifisensorDetail.shopId}">
           <input type="hidden" id="shopEntityId" value="${wifisensorDetail.shopEntityId}">
           <input type="hidden" id="wifiid" value="${wifisensorDetail.id}">${wifisensorDetail.deviceSn}</li>
           <li><span>${shopVo.wordNames['gmsg354']}</span><select name="status" id="status2"  class="borderStyle select">
						<option value="0" <c:if test="${wifisensorDetail.status=='0'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg356']}</option>
						<option value="1" <c:if test="${wifisensorDetail.status=='1'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg357']}</option>
						<option value="2" <c:if test="${wifisensorDetail.status=='2'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg358']}</option>
				</select></li>
				<li><span>${shopVo.wordNames['gmsg363']}</span>
					<input id="citySel" class="borderStyle text"  type="text" readonly value="${wifisensorDetail.positionName}"  onclick="relateOne();" />
					<input id="positionId" class="borderStyle text"  type="hidden" readonly value="${wifisensorDetail.positionId}"   />
				</li>
				<li class="commitBtn" >
				     <input type="button" onclick="update();" class="inputBtn blueBtn"   style="width: 150px" value="${shopVo.wordNames['gmsg364']}"  />&nbsp;&nbsp;&nbsp;&nbsp;
				     <input type="button" class="inputBtn blueBtn"  style="width: 150px" onclick="cancel()" value="${shopVo.wordNames['gmsg365']}" /></li>

           </ul>
             <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
<!-- 位置-->
<div style="display:none;">
	<a href="#" id="relateFancybox" class="fancybox_relate"></a>
</div>
</body>
	<script type="text/javascript">
	function cancel(){
		parent.$.fancybox.close();
	}
	
			//修改设备位置
			function update(){
				var id = $("#wifiid").val();
				var status= $("#status2").val();
				var positionId  =  $("#positionId").val();
				var positionName = $("#citySel").val();
				         $.ajax({
				               async:false,
				               type:"POST",
				               dataType: "json",
				               url:"${basePath}/wifisensor.do",
				            	data:{"method":"updata","deviceWifisensorId":id,"status":status,"positionId":positionId,"positionName":positionName},	   
				               success:function(data){
				        	          if(data.success==true){
				        		         alert(data.message);
				        		         parent.$.fancybox.close();
				        		         parent.page(1);
				        	           }else{
				        	     	     alert(data.message);
				        		         return false;
				        	           }
				               }
			             }); 
		}
	</script>
</html>