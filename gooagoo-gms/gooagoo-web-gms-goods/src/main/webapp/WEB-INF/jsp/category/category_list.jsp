<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
request.setAttribute("topMenuCode", "15");
request.setAttribute("leftMenuCode", "1502");
%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmse012']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/tree-list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/upload.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/ztree_position.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/regexp.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/category.js"></script>

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
	getEntityList("${shopId}","${shopEntityId}") ;
	initFancyBox("fancybox_relate",240,450,true);
});
function relateOne(){
	var shopEntityId = $("select[name='entityId']").val() ;
	var url = "${basePath }/relation.do?method=treeRelation&relateType=I&entityId=" + shopEntityId;
	$("#relateFancybox").attr("href",url).click();
}

function dealRelations(relations){
	 $("#positionId").val(relations[0][1]) ;
	 $("#position").val(relations[0][2]) ;
	 $.fancybox.close();
}

</script>

</head>

<body>
   <!--头部-->
   <%@include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
        <%@include file="/WEB-INF/jsp/common/left.jsp"%>
        <div class="section">
          <div class="rightTitle_add">
          	<check:hasAuthority authorityID="150201">
            <a href="javascript:void(0)" onclick="showNewCate2()">${shopVo.wordNames['gmse013']}</a>
            </check:hasAuthority>
            
            <span>${shopVo.wordNames['gmse012']}</span>
          </div>
          <div style="padding-bottom:10px;color:#0873B9;font-weight:bold;height:20px;line-height:20px;"> 
          ${shopVo.wordNames['gmse014']}：
          <select style="padding:1px;border:1px solid #ccc;width:180px;vertical-align:middle;"  class="borderStyle select" onchange="changeSelect('${shopId }',this)" name="entityId" id="entity_id"></select>
          </div>
          <div class="tree-list">
            <div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
           <div class="location">
             <ul>
                <li><span>${shopVo.wordNames['gmse015']}</span><input type="hidden" name="parentCategoryId"  value="-1"/><input class="borderStyle select" type="text" name="parentCategoryName" style="background:#CECECE;" readonly  value="${shopVo.wordNames['gmse083']}"/> </li>
                <li><span>${shopVo.wordNames['gmse016']}</span><input type="hidden" name="positionId" id="positionId"/>
                <input id="position" class="borderStyle select" value="${marketing.positionName }" type="text" onclick="relateOne();" readonly name="positionName"/>
                </li>
                <li><span>${shopVo.wordNames['gmse017']}</span><input name="categoryId" class="borderStyle text" type="text" /></li>
                <li><span>${shopVo.wordNames['gmse018']}</span><input name="categoryName" class="borderStyle text" type="text" /></li>
                <li><span>${shopVo.wordNames['gmse019']}</span>
                <div class="image_box">
                	<u><img id="pic_main" src="${imgPath}/gms/common/images/qs.jpg" width="90" height="90"  style="border:1px solid #ccc;padding:3px;display:inline-block;"/></u><br /><br />
                    <a href="javascript:void(0)" onclick="uploadCategoryPic('pic_main');" class="blueBtn" style="vertical-align: top;width: 98px;height: 23px;line-height: 23px;margin-left: 95px;font-weight:bold;text-decoration:underline;">${shopVo.wordNames['gmse020']}</a>
                </div>
                <input type="hidden" name="id" value=""/></li>
                <li class="commitBtn">
                <check:hasAuthority authorityID="15020201">
                	<input type="hidden" id="canEdit" value="true" />
                	<a href="javascript:void(0)" id="updateButton" style="display: none" class="blueBtn" onclick="updateCate()">${shopVo.wordNames['gmse021']}</a>
                </check:hasAuthority>
                <check:hasAuthority authorityID="150201">
                	<input type="hidden" id="canAdd" value="true"/>
               		<a href="javascript:void(0)" id="addButton" class="blueBtn" onclick="updateCate()">${shopVo.wordNames['gmse021']}</a>
                </check:hasAuthority>
                
                <check:hasAuthority authorityID="15020202">
	                <input type="hidden" id="canDel" value="true"/>
	                <a href="javascript:void(0)" class="blueBtn" onclick="deleteCateDo('')">${shopVo.wordNames['gmse022']}</a>
                </check:hasAuthority>
                </li>
             </ul>
           </div>
          </div>
       
      </div>
    </div>
    </div>

<!-- 位置 -->
<div style="display:none;">
	<a href="#" id="relateFancybox" class="fancybox_relate"></a>
</div>
<!-- 上传图片使用 -->
<div style="display:none;">
	<a href="jcroup.jsp" id="fancybox_pic" class="fancybox_pic"></a>
</div>
<input type="hidden" id="cid"/>
</body>
</html>

