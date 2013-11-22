<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp" %>
<html>
<head>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1402");
request.setAttribute("leftMenuCode", "140201");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>${shopVo.wordNames['gmsg010']}</title>
<link href="${imgPath}/gms/shopinfo/css/shopBuild2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/shopEntity.js"></script>
<script type="text/javascript">
var basePath="${basePath}";
var province ="${entityInfo.province}";
$(document).ready(function(){
  initFancyBox("fancybox_pic",950,"98%",true);	
  initBaseInfoValidate();
  initLinkInfoValidate();
  initGpsInfoValidate();
  initInvInfoValidate();
  controlCanEdit('${shopStatus}');
  initFancyBoxHtml();
  getInvList('${entityInfo.shopEntityId}');
  getArea(document.getElementById("province"),-1);
})
</script>
</head>
<body>
   <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
      <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
        <div class="section">
          <div class="rightTitle">
            <span>${shopVo.wordNames['gmsg010']}</span>
          </div>
          <div class="conditions_content">
            <form action="" id="baseInfoForm">
            <input type="hidden" name="editFlag" value="${editFlag}"/>
            <input type="hidden" name="businessLicense" value="${entityInfo.businessLicense}"/>
            <input type="hidden" name="shopEntityId" id="shopEntityId" value="${entityInfo.shopEntityId}"/>
          	<div class="title">${shopVo.wordNames['gmsg064']}</div>
            <div class="shopBuild_fillout">
            	<div class="image_box">
                	<u><img src="<c:if test='${empty entityInfo.businessLicense}'>${imgPath}/gms/shopinfo/images/qs.jpg</c:if><c:if test='${not empty entityInfo.businessLicense}'>${entityInfo.businessLicense}</c:if>" width="300" height="210" id="imgpic"/></u><br /><br />
                    <a href="javascript:void(0);" class="blueBtn fancybox_pic" id="fancybox_pic" onclick="uploadPic();">${shopVo.wordNames['gmsg078']}</a>
                </div>
            	<ul>
                	<li><span>${shopVo.wordNames['gmsg065']}</span><input class="longInput" type="text" name="shopEntityName"  value="${entityInfo.shopEntityName}"/></li>
                    <li><span>${shopVo.wordNames['gmsg066']}</span><input class="longInput" type="text" name="enterpriseName" value="${entityInfo.enterpriseName}" maxlength="100"/></li>
                    <li><span>${shopVo.wordNames['gmsg067']}</span><input class="longInput" type="text" name="registeredNumber" value="${entityInfo.registeredNumber}" maxlength="100"/></li>
                    <li><span>${shopVo.wordNames['gmsg068']}</span><input class="longInput" type="text" name="registeredCity" value="${entityInfo.registeredCity}" maxlength="10"/></li>
                    <li><span>${shopVo.wordNames['gmsg069']}</span><input class="longInput" type="text" name="corporate" value="${entityInfo.corporate}"/></li>
                    <li><span>${shopVo.wordNames['gmsg070']}</span><input class="longInput" type="text" name="registeredCapital" value="${entityInfo.registeredCapital}" maxlength="50"/></li>
                    <li><span>${shopVo.wordNames['gmsg071']}</span><input class="longInput" type="text" name="promptinfo" value="${entityInfo.promptinfo}"/></li>
                    <li><span>${shopVo.wordNames['gmsg072']}</span><input class="date1" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="readonly" name="busnissAlotedStartTime" value="<fmt:formatDate value='${entityInfo.busnissAlotedStartTime}' pattern="yyyy-MM-dd"/>"/><b>-</b>
                    <input class="date1" type="text"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="readonly" name="busnissAlotedEndTime" value="<fmt:formatDate value='${entityInfo.busnissAlotedEndTime}' pattern="yyyy-MM-dd"/>"/></li>
                    <li><span>${shopVo.wordNames['gmsg073']}</span><input class="date1" type="text" onclick="WdatePicker({dateFmt:'HH:mm:ss'});" readonly="readonly" id="openTime" name="openTime" value="${entityInfo.openTime}"/><b>-</b>
                    <input class="date1" type="text"  onclick="WdatePicker({dateFmt:'HH:mm:ss'});" readonly="readonly" name="closeTime" id="closeTime" value="${entityInfo.closeTime}"/></li>
                    <li><span>${shopVo.wordNames['gmsg074']}</span><input class="longInput"   type="text" name="invoiceExpire" id="invoiceExpire" value="${entityInfo.invoiceExpire}"  maxlength="11"/></li>
                    <li><i>${shopVo.wordNames['gmsg075']}</i></li>
                    <li><span>${shopVo.wordNames['gmsg076']}</span><input class="longInput" type="text" id="shopRoadGuide" name="shopRoadGuide" value="${entityInfo.shopRoadGuide}"/></li>
                    <li><span>${shopVo.wordNames['gmsg077']}</span><input class="longInput" type="text" id="introduction" name="introduction" value="${entityInfo.introduction}"/></li>
                    <li><span>总店</span><!--新建  有总店--><!--修改  是总店-->
                    <c:if test="${editFlag eq 'add' }">
	                    <select  name="isGeneral" ${flag eq true?"disabled='disabled'":''} >
	                         <option value="Y" >是</option>
	                         <option value="N" ${flag eq true?"selected='selected'":''}>否</option>
	                    </select>
                    </c:if>
                     <c:if test="${editFlag eq 'update' }">
	                    <select  name="isGeneral" ${(flag eq true &&entityInfo.isGeneral eq 'N') or (shopStatus ne 'L')?"disabled='disabled'":''} >
	                         <option value="Y" ${entityInfo.isGeneral eq 'Y'?"selected='selected'":''}>是</option>
	                         <option value="N" ${entityInfo.isGeneral eq 'N'?"selected='selected'":''}>否</option>
	                    </select>
                    </c:if>
					</li>
                </ul>
                <input type="submit" id="saveShopEntity"  style="cursor: pointer;" class="savebtnS blueBtn" value="${shopVo.wordNames['gmsg079']}" />
            </div>
            </form>
            <form action="" id="linkform">
            <input type="hidden" name="editFlag" value="${editFlag}"/>
            <input  type="hidden" name="shopEntityId" value="${entityInfo.shopEntityId}"/>
            <div class="title">${shopVo.wordNames['gmsg080']}</div>
             <div class="shopBuild_fillout">
            	<ul>
                	<li><span>${shopVo.wordNames['gmsg081']}</span><input type="text" name="mobile" value="${entityInfo.mobile}" maxlength="11"/></li>
                   <li><span>${shopVo.wordNames['gmsg082']}</span><input type="text" name="phone" value="${entityInfo.phone}" maxlength="20"/></li>
                    <li><span>${shopVo.wordNames['gmsg083']}</span><input type="text" name="postCode" value="${entityInfo.postCode}" maxlength="10"/></li>
                    <li>
                    	<span>${shopVo.wordNames['gmsg084']}</span>
                    		<select name="province" onchange="getArea(this,0)" id="province">
                            	<option value="">--${shopVo.wordNames['gmsg102']}--</option>
                            </select>
                            <b>${shopVo.wordNames['gmsg085']}</b>
							<select name="city" onchange="getArea(this,1)">
                            	<option value="">--${shopVo.wordNames['gmsg102']}--</option>
                            	<c:forEach items="${listCity}" var="city">
                            	  <option value="${city.key}"  ${city.key eq entityInfo.city?"selected='selected'":""}>${city.value}</option>
                            	</c:forEach>
                            </select>
                            <b>${shopVo.wordNames['gmsg086']}</b>
                            <select name="area">
                            	<option value="">--${shopVo.wordNames['gmsg102']}--</option>
                            	<c:forEach items="${listArea}" var="area">
                            	  <option value="${area.key}" ${area.key eq entityInfo.area?"selected='selected'":""}>${area.value}</option>
                            	</c:forEach>
                            </select>
                            <b>${shopVo.wordNames['gmsg087']}</b>
                    </li>
                    <li><span>${shopVo.wordNames['gmsg088']}</span><textarea name="address">${entityInfo.address}</textarea></li>
                </ul>
                <input type="submit" style="cursor: pointer;" id="linkformBtn"  class="savebtnS blueBtn" value="${shopVo.wordNames['gmsg079']}" />
            </div>
            </form>
            <form id="gpsForm">
             <input type="hidden" name="editFlag" value="${editFlag}"/>
            <input  type="hidden" name="shopEntityId" value="${entityInfo.shopEntityId}" />
            <div class="title">${shopVo.wordNames['gmsg089']}</div>
            	<div class="shopBuild_fillout">
            	<ul>
                   <li><span>${shopVo.wordNames['gmsg090']}</span><input type="text" name="shopGpsBaidux" value="${entityInfo.shopGpsBaidux}"/>
                   <span>${shopVo.wordNames['gmsg091']}</span><input type="text" name="shopGpsGooglex" value="${entityInfo.shopGpsGooglex}"/></li>
                   <li><span>${shopVo.wordNames['gmsg092']}</span>
                   <input type="text" name="shopGpsBaiduy" value="${entityInfo.shopGpsBaiduy}" />
                   <span>${shopVo.wordNames['gmsg093']}</span><input type="text" name="shopGpsGoogley" value="${entityInfo.shopGpsGoogley}"/></li>
                 </ul>
                   <input type="submit" style="cursor: pointer;" id="gpsFormBtn"  class="savebtnS blueBtn" value="${shopVo.wordNames['gmsg079']}" />
               </div>
             </form>  
            <div class="title">
               <a href="#tableForm" class="add_btn orangeBtn fancybox_pic">${shopVo.wordNames['gmsg095']}</a>${shopVo.wordNames['gmsg094']}
            </div>
            <div id="invTableList"></div>
          </div>
          <a href="javascript:window.location.href='${basePath}/entity'" class="blueBtn savebtn">${shopVo.wordNames['gmsg101']}</a>
      </div>
     </div>
    </div>
  <!--用户状态-->
<div style="display: none">
<div class="conditions_content" id="tableForm" style="padding-bottom:0px;width:450px;">
<form id = "invFrom">
  <input  type="hidden" name="shopEntityId" value="${entityInfo.shopEntityId}"/>
  <input type ="hidden" name="invNames" id="invNames"/>
  <input type ="hidden" name="invi" id="invi" value=""/>
  <div class="title">${shopVo.wordNames['gmsg094']}</div>
     	<div class="shopBuild_fillout">
     	<ul>
           <li><span>${shopVo.wordNames['gmsg096']}</span><select name="invoiceType"><option value="">--${shopVo.wordNames['gmsg102']}--</option><option value="1">${shopVo.wordNames['gmsg098']}</option><option value="2">${shopVo.wordNames['gmsg099']}</option></select></li>
           <li><span>${shopVo.wordNames['gmsg097']}</span><input type="text" name="invoiceName" onchange="copyValue('');" /></li>
          </ul>
         <input type="submit"  style="cursor: pointer;" id="invSubmit"  class="savebtnS blueBtn" value="${shopVo.wordNames['gmsg079']}"/>
   </div>
</form>
</div>   
</div>  
</body>
</html>
