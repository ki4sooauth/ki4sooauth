<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物清单编辑</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/poup.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/shopList.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/accumulate_point_shop.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/common/jquery-ui/datepicker/style/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/effect.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/shopList.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/jquery-ui/datepicker/js/jquery.ui.datepicker.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/shoppinglist/js/shoppingList_edit.js"></script>
</head>
<body class="snow_bg" STYLE='OVERFLOW:SCROLL;OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'>
<input type="hidden" name="basePath" value="${basePath }" />
<input type="hidden" name="imgPath" value="${imgPath }" />
<div class="choice_goods">
	<p class="title" style="line-height:40px">编辑清单</p>
	<div class="add_content">
    	<label>清单名称：</label><input type="text"  name="title"  value="${data.title}" maxlength="20"/><label>预计购物时间：</label><input type="text" name="preShoppingTime"  value="<fmt:formatDate value='${data.preShoppingTime}' pattern='yyyy-MM-dd' type='date'></fmt:formatDate>"  class="date" id="startDate" readonly="true"/>
     <span style="display:block;clear:both;float:left;width:300px;line-height:20px;text-indent:117px;"><lable ><font color="red"  id="error_title">&nbsp</font></lable></span><span style="width:300px;display:block;text-indent:120px;float:left;line-height:20px"><lable><font color="red" id="error_time" >&nbsp</font></lable></span>
    </div>
    <input type="hidden" name="shoppingListId" id="shoppingListId" value="${data.shoppingListId}"/>
    <div class="control">
    	<a href="#" class="btn" id="sure">确认</a><a href="#" class="btn" onclick="javascript:parent.$.fancybox.close();">取消</a>
    </div>
</div>
</body>
</html>