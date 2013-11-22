<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140305");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsg301']}</title>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/tree-list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gms/goods/js/public.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/position.js"></script>

<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<link rel="stylesheet" href="${imgPath}/gms/shopinfo/css/demo.css" type="text/css"/>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.exedit-3.5.js"></script>

<link href="${imgPath}/common/fancybox/jquery.fancybox-1.3.4.css" media="screen" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.js" ></script>
<script type="text/javascript" src="${imgPath }/common/fancybox/jquery.fancybox-1.3.4.pack.js" ></script>


<script type="text/javascript">
var basePath="${basePath}";
$(document).ready(function(){
	shopEntityPosition();
	init("${gmsLoginInfo.shopId}") ;
});
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
            <check:hasAuthority authorityID="14030501"> <a href="javascript:void(0)" onclick="showNewCate2()">${shopVo.wordNames['gmsg302']}</a></check:hasAuthority>
            <check:hasAuthority authorityID="14030503"><a href="${basePath}/position.do?method=toImportPosition" style="margin-right:10px;">批量导入</a></check:hasAuthority>
            <span>${shopVo.wordNames['gmsg303']}</span>

          </div>
          <div  ${not empty gmsLoginInfo.shopEntityId?'style="display: none；height:40px"':'style="display: block；height:40px;"'}>
                <span style="line-height: 30px;color:#0873B9;font-weight: bold;">${shopVo.wordNames['gmsg304']}</span><select  id ="shopEntityId" name="shopEntityId" ${not empty loginInfo.shopEntityId?"disabled='disabled'":""} onchange="init('${gmsLoginInfo.shopId}');">
		   <option value="">${shopVo.wordNames['gmsg134']}</option>
		</select>
		</div>
          <div class="tree-list" >



<!-- <div style="float:left; width:100px; height:100px; border:2px solid #0000FF;"></div><div style="float:left; width:300px; height:100px; border-right:2px solid #0000FF; border-top:2px solid #0000FF; border-bottom:2px solid #0000FF;"></div> -->
            <div class="zTreeDemoBackground left" style="float:left; ">
				<ul id="treeDemo" class="ztree" style="margin-top: 0px;width: 230px"></ul>
			</div>
           <div class="location" style="width: 490px">
             <ul>
                <li><span>${shopVo.wordNames['gmsg305']}</span><input type="hidden" name="parentPositionId"  value="-1"/><label id="parentPositionName"></label><input type="hidden" name="parentPositionName" readonly value=""/> </li>
                <li><span>${shopVo.wordNames['gmsg306']} ${gmsLoginInfo.shopEntityId}</span>
                <input class="borderStyle select" value="" type="hidden"   name="positionId"/>
                <input class="borderStyle select" value="" type="text"   name="positionName"/>
                </li>

                <li><span>${shopVo.wordNames['gmsg307']}</span>
                <div class="div4" >
				    <textarea id="description"  style="width:355px;height:155px" name="description" maxlength="255">${position.description}</textarea>
				     </div>
				     <p class="p40">${shopVo.wordNames['gmsg308']}</p>
				     <p class="p41">
                </li>
                <li class="commitBtn">
                <check:hasAuthority authorityID="140305">
                <input type="hidden" id="canAdd" value="true"/>
                <a href="javascript:void(0);" class="blueBtn" id="addButton" onclick="updateCate()">${shopVo.wordNames['gmsg309']}</a></check:hasAuthority>
                <check:hasAuthority authorityID="1403050201">
                <input type="hidden" id="canEdit" value="true"/>
                <a href="javascript:void(0);" id="updateButton" class="blueBtn"style="display: none" onclick="updateCate()">${shopVo.wordNames['gmsg309']}</a></check:hasAuthority>
               <check:hasAuthority authorityID="1403050202">
                <input type="hidden" id="canDel" value="true"/>
                <a href="" class="blueBtn" onclick="deleteCateDo('')">${shopVo.wordNames['gmsg310']}</a></check:hasAuthority></li>
             </ul>
           </div>
          </div>
       
      </div>
    </div>
    </div>
     		<!-- 位置弹出层 -->
<div style="display:none;">
	<a href="#" class="brand_fancybox_select"></a>
</div>


</body>
</html>

