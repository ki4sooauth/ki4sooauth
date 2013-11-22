<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<html>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("topMenuCode", "14030101");
request.setAttribute("leftMenuCode", "1403010101");
%>

<head>
<title></title>
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
            <span>${shopVo.wordNames['gmsg247']}</span>
          </div>
</div>
           <ul class="desk-num-poup" style="height: 30px">
           <li><span>${shopVo.wordNames['gmsg227']}</span>
           <input type="hidden" id="shopId" value="${lidDetail.shopId}">
           <input type="hidden" id="shopEntityId" value="${lidDetail.shopEntityId}">
           <input type="hidden" value="${lidDetail.lid}">${lidDetail.lid}</li>
           <li><span>${shopVo.wordNames['gmsg229']}</span><select name="status" id="status2"  class="borderStyle select">
						<option value="Y" <c:if test="${lidDetail.status=='Y'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg242']}</option>
						<option value="N" <c:if test="${lidDetail.status=='N'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg243']}</option>
						<option value="S" <c:if test="${lidDetail.status=='S'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg244']}</option>
						<option value="D" <c:if test="${lidDetail.status=='D'}">selected="selected"</c:if>>${shopVo.wordNames['gmsg245']}</option>
				</select></li>
								<li><span>${shopVo.wordNames['gmsg236']}</span>
					<input id="ppx" class="borderStyle text"  type="text"  value="${lidDetail.px}"   />
				</li>
								<li><span>${shopVo.wordNames['gmsg237']}</span>
					<input id="ppy" class="borderStyle text"  type="text"  value="${lidDetail.py}"   />
				</li>
				<li><span>${shopVo.wordNames['gmsg238']}</span>
					<input id="citySel" class="borderStyle text"  type="text" readonly value="${lidDetail.positionName}"  onclick="relateOne();" />
					<input id="positionId" class="borderStyle text"  type="hidden" readonly value="${lidDetail.positionId}"   />
				</li>
				<li class="commitBtn" >
				     <input type="button" id="idDisable" onclick="update();" class="inputBtn blueBtn"   style="width: 150px" value="${shopVo.wordNames['gmsg260']}"  />&nbsp;&nbsp;&nbsp;&nbsp;
				     <input type="button" class="inputBtn blueBtn"  style="width: 150px" onclick="cancel()" value="${shopVo.wordNames['gmsg240']}" /></li>

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
				var lid = "${lidDetail.lid}";
				var status= $("#status2").val();
// 				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
// 				var nodes = treeObj.getCheckedNodes(true);
				var positionId  =  $("#positionId").val();
				var positionName = $("#citySel").val();
				var ppx  =  $("#ppx").val();
				var ppy = $("#ppy").val();
// 				if(nodes.length>0){
				$("#idDisable").attr("disabled",true);
				         $.ajax({
				               async:false,
				               type:"POST",
				               dataType: "json",
				               url:"${basePath}/shopLidDetail.do",
				            	data:{"method":"updateLidDetail","lid":lid,"status":status,"positionId":positionId,"positionName":positionName,"px":ppx,"py":ppy},	   
				               success:function(data){
				        	          if(data.success==true){
				        	        	  $("#idDisable").attr("disabled",false);
				        		         alert(data.message);
				        		         parent.$.fancybox.close();
				        		         parent.page(1);
				        	           }else{
				        	        	   $("#idDisable").attr("disabled",false);
				        	     	     alert(data.message);
				        		         return false;
				        	           }
				               },
				               error:function(){
									$("#idDisable").attr("disabled",false);
								}
				               
			             }); 
// 				}else{
// 					  alert("请选择位置信息");
// 					  return false;
// 				}
		}
	</script>
</html>