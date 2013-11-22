<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
	request.setAttribute("topMenuCode", "13");
	request.setAttribute("leftMenuCode", "1302");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>积分兑换明细</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<script>
$(function(){
	page(1);
});
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	var data = "&pageIndex="+index + "&pageSize=12&shopIntegralId=${shopIntegralId}";
	ajaxToPageByData( "${basePath}/integralDeliver.do?method=list","fileCont1",data);
}
</script>
</head>
<body>
<!-- 头部 --> 
 <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
    <!--内容-->
    <div class="container">       
      <div class="article">
	 <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
  			<div class="section">	
        <div class="rightTitle_add">
            <span>积分兑换明细</span>
        </div>               
          <span id="fileCont1">&nbsp;</span>
        </div>
     </div>
 </div>
</body>
</html>