<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/pss_manage.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="pss_inform_list" style="width:auto;">
	<div class="content">
        <p class="title">实体店详情</p>
        <ul>
            <li><strong>实体店名称：</strong><span>${entityInfo.shopEntityName}</span></li>
            <li><strong>企业全称：</strong><span>${entityInfo.enterpriseName}</span></li>
            <li><strong>商家名称：</strong><span>${entityInfo.shopName}</span></li>
            <li><strong>注册号：</strong><span>${entityInfo.registeredNumber}</span></li>
            <li><strong>注册城市：</strong><span>${entityInfo.registeredCity}</span></li>
            <li><strong>法人代表：</strong><span>${entityInfo.corporate}</span></li>
            <li><strong>注册资本：</strong><span>${entityInfo.registeredCapital}</span></li>
            <li><strong>消费提示：</strong><span>${entityInfo.promptinfo}</span></li>
            <li><strong>手机号码：</strong><span>${entityInfo.mobile}</span></li>
            <li><strong>联系电话：</strong><span>${entityInfo.phone}</span></li>
            <li><strong>邮政编码：</strong><span>${entityInfo.postCode}</span></li>
            <li><strong>省、市、区：</strong><span>${entityInfo.province}${entityInfo.city}${entityInfo.area}</span></li>
            <li><strong>详细地址：</strong><span>${entityInfo.address}</span></li>
            <li><strong>开发票时间：</strong><span>账单开出${entityInfo.invoiceExpire}日内，凭账单到付款台开局发票</span></li>
            <li><strong>营业期限:</strong><span>${entityInfo.busnissAlotedStartTime}～${entityInfo.busnissAlotedEndTime}</span></li>
            <li><strong>营业时间:</strong><span>${entityInfo.openTime}到${entityInfo.closeTime}</span></li>
            <li><strong>营业执照</strong><span><a href="#">${entityInfo.businessLicense}</a></span></li>
            <li><strong>交通指南：</strong><span>${entityInfo.shopRoadGuide}</span></li>
            <li><strong>店铺介绍：</strong><span> ${entityInfo.introduction}</span></li>
        </ul>
        <p class="coord"><strong>GPS百度的X坐标：</strong><span>${entityInfo.shopGpsBaidux}</span><strong>GPS百度的Y坐标：</strong><span>${entityInfo.shopGpsBaiduy}</span></p>
        <p class="coord"><strong>GPS百度的X坐标：</strong><span>${entityInfo.shopGpsGooglex}</span><strong>GPS百度的Y坐标：</strong><span>${entityInfo.shopGpsGoogley}</span></p>
        <p class="coord"><strong>个人发票项目名称：</strong><span>${entityInfo.name1}</span><strong>公司发票项目名称：</strong><span>${entityInfo.name2}</span></p>
	</div>
    <div class="control">
    	<a href="#" onclick="ajaxToPage('${basePath}/shopEntity.do?method=form&shopEntityId=${entityInfo.shopEntityId}','actionPage');">编辑</a><a href="#" onclick="cToShopEntityInfo();">返回</a>
    </div>
</div>
</body>
</html>
