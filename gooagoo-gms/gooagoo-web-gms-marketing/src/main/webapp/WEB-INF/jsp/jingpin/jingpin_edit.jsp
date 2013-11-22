<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1303");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>${shopVo.wordNames['gmsd092']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<link href="${imgPath}/gms/common/css/pointBuild.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(function(){
	initFancyBox();
	if(isEmpty("${jingpin.jingpinId}")){clearData();}
	
});
function getCurDate(){
	return "${date}";
}
// formUrlType 为1表示创建，为0表示修改
function saveShopIntegral(formUrlType){
	$(".blueBtn").attr("disabled","disabled");
	var goodsId = $("#jingpinForm input[name=goodsId]").val();
	var jingpinTypeId = $("#jingpinForm select[name=jingpinTypeId]").val();
	
    if(isEmpty(goodsId)){
    	removeDisable();
    	alert("请选择推荐"+"${empty shopVo.wordNames['gmse001']?'商品':shopVo.wordNames['gmse001']}");
    	return false;
    }
    if(isEmpty(jingpinTypeId)){
    	removeDisable();
    	alert("请选择精品推荐类型");
    	return false;
    }
    var data=$("#jingpinForm").serialize();
    var url = "${basePath }jingpin.do?method=${empty jingpin.jingpinId ? 'create':'update'}";
    $.ajax({
    	async:false,
		type:"POST",
		url:url ,
		data:data,
		dataType:"json",
		success: function(data) {
			if(data.success) {
				removeDisable();
				alert(data.message);
					location.replace("${basePath}/jingpin.do?method=index"); 			
				
			} else {
				removeDisable();
				alert(data.message);
			}
		}
    });
}
function checkInt(value){
	var reg2 = new RegExp("^[0-9]*$");
	return reg2.test(value);
}

function initFancyBox(){
	$(".fancybox_relate").fancybox({
		'width'				: 800,
		'height'			: 550,
		'padding'			: 0,
		'autoScale'			: true,
		'autoDimensions'    : true,
		'transitionIn'		: 'yes',
		'transitionOut'		: 'yes',
		'href'				: $(this).attr('href'),
		'type'				:'iframe',
		'hideOnOverlayClick': false,
		'showCloseButton':true
	});
}
function addRelate(){
	$("#relate_list").click();
}
function dealRelations(relations){
	$("#jingpinForm #convertName").val(relations[0][2]);
	$("#jingpinForm input[name=goodsId]").val(relations[0][1]);
	var url=relations[0][3];
	if(isEmpty(url)){
		$('#img').hide();
	}else{
		$('#img').attr("src",relations[0][3]);
		$('#img').show();
	}
	 $.fancybox.close();
}
//保存按钮从disable还原
function removeDisable(){
	$(".blueBtn").attr("disabled",false);
}
//添加也刷新后需清空原有数据
function clearData(){
	$("#jingpinForm #convertName").val("");
	$("#jingpinForm input[name=goodsId]").val("");
	$('#img').attr("src","${imgPath}/gms/common/images/default1.jpg");
}
</script>
</head>
<body>
   <!--头部-->
<%@ include file="/WEB-INF/jsp/common/head.jsp"%> 
<div style="display:none;">
	<a href="${basePath }relation.do?method=listRelation&selectType=&relateType=G" id="relate_list" class="fancybox_relate"></a>
</div>
   <!--内容-->
    <div class="container">
      <div class="article">               
<%@ include file="/WEB-INF/jsp/common/left.jsp"%> 
        <div class="section">        
          	<div class="rightTitle">
    			 <span>${empty jingpin.jingpinId ? shopVo.wordNames['gmsd093']:shopVo.wordNames['gmsd094']}</span>
     		</div> 
          <iframe id="hiddenIframe" name="hiddenIframe" style="display:none;"></iframe>
          <div class="point_build"> 
           <form id="jingpinForm" name="jingpinForm" target="hiddenIframe" method="post">
            <input type="hidden" name="goodsId" value="${jingpin.goodsId}" />
            <input type="hidden" name="shopId" value="${shopId}" />
            <input type="hidden" name="jingpinId" value="${jingpin.jingpinId}" />
	            <ul>
		            <li>
		            <span>${shopVo.wordNames['gmsd095']}</span>
		            <select name="jingpinTypeId" id="jingpinTypeId" style="width:210px;height:22px;">
			        	<c:forEach var="item" items="${types}" varStatus="xh">
			        	<option value="${item.goodsTypeId }" ${item.goodsTypeId==jingpin.jingpinTypeId ? "selected" : ""}>${item.goodsTypeName}</option>
			        	</c:forEach>
			        </select>
			        </li>
		             <li>
		             <span>${shopVo.wordNames['gmsd096']}</span>
		             <button onclick="addRelate();" class="blueBtn selectImgBtn" name="save">${shopVo.wordNames['gmsd088']}</button><br /><br />
		             <input style="min-height:0px;" readonly="readonly" class="textArea" id="convertName" name="convertName" value="${jingpin.goodsName}"/>
		             <img id="img" src="${jingpin.imgUrl}"  class="textArea"/>
		             </li>
		             <li class="commitBnt">
		               <a href="javascript:void(0);" onclick="saveShopIntegral(${empty jingpin.jingpinId ? 1:0 });" name="save" class="submit blueBtn">${shopVo.wordNames['gmsd077']}</a>
		             </li> 
	            </ul>
            </form>
          </div>
       </div>
      </div>
   </div>
</body>
</html>
