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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${empty shopVo.wordNames['gmsd012'] ? '精品推荐管理' : shopVo.wordNames['gmsd012']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<script>
var pIndex = '${page_cur}';

$(function(){
		page(pIndex);
});
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	pIndex = index;
	var data = "&pageIndex="+index + "&pageSize=12";
	
	ajaxToPageByData("${basePath}/jingpin.do?method=list","fileCont1",data);
}

//精品推荐编辑页
function formJingpin(jingpinId){
	var mName="updateform";
	if(isEmpty(jingpinId)){
		jingpinId = "";
		mName="addform";
	}
	window.location.href = "${basePath}/jingpin.do?method="+mName+"&id="+jingpinId;
	
}
//删除
function deleteJingpin(jingpinId){
	if(isEmpty(jingpinId)){
		jingpinId = "";
	}
     if(confirm("确定删除精品信息吗？")){
			
			var url = "${basePath }jingpin.do?method=delete";
			var data = "&id="+jingpinId;
			ajaxJsonTipByData(url,data,true);
			location.reload(); 
		}
	
	
}
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
  		
        <div class="rightTitle_add">       
         <check:hasAuthority authorityID='130301'>
           <a href="javascript:formJingpin('');">${empty shopVo.wordNames['gmsd040'] ? '添加精品推荐信息' : shopVo.wordNames['gmsd040']}</a>
           </check:hasAuthority>
            <span>${empty shopVo.wordNames['gmsd039'] ? '精品推荐信息列表' : shopVo.wordNames['gmsd039']}</span>
        </div>            
          <span id="fileCont1">&nbsp;</span>
        </div>
        </div>
 </div>
</body>
</html>
