<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${shopVo.wordNames['gmsg341']}</title>
<style type="text/css">
.inputButton {
    border: 0 none;
    cursor: pointer;
    font-size: 14px;
    font-weight: bold;
    height: 40px;
    line-height: 40px;
    width: 228px;
}
.clearButton{clear:both;overflow:hidden;padding:50px 0 10px; text-align:center}
</style>
</head>
<body>
<div class="print3" style="margin: 20px 20px  50px 20px;width:auto;" >
    <div class="print3_left" >
    	<p><span>${shopVo.wordNames['gmsg342']}</span><span>${tableInfo.tableNo}</span></p>
    	<p><span>${shopVo.wordNames['gmsg343']}</span><span>${tableInfo.roomName}</span>
    	</p><p><span>${shopVo.wordNames['gmsg344']}</span></p><p class="p1"  style="word-break: break-all;">["gooagoo","00","${tableInfo.shopEntityId}","${tableInfo.tableNo}","${tableInfo.roomName}"]</p>
    </div>
    <div class="print3_right" style="height: auto;padding-top:5px;text-align:center">
    	<img src='${basePath}/common.do?method=getTwoCode&content=["gooagoo","00","${tableInfo.shopEntityId}","${tableInfo.tableNo}","${tableInfo.roomName}"]&size=5'/>
    </div>
    <div class="clearButton">
      <input class="inputButton blueBtn" type="button"  value="${shopVo.wordNames['gmsg345']}" onclick="javascript:parent.$.fancybox.close();" />
    </div>
     
</div>
</body>
</html>