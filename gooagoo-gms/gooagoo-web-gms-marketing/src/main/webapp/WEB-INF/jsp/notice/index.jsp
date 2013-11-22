<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsd102']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script>
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />
<script>
var pIndex = '${page_cur}';

$(function(){
		page(pIndex);
		initFancyBox("fancybox_noticeDetail",1030,970,true);  //弹出框（通知详细）
		initFancyBox("fancybox_detail",920,600,true);//查看发布详情
});

function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	pIndex = index;
	var noticeTitle=$("#noticeTitle").val();	
	var publishStatus=$("#publishStatus").val();
	var data = "&pageIndex="+index + "&pageSize=12&noticeTitle="+noticeTitle+"&publishStatus="+publishStatus;
	ajaxToPageByData("${basePath}/notice.do?method=list","fileCont1",data);
}

//清空模糊查询条件
function clearArgs(){
	$("#noticeTitle").val("");
	$("#publishStatus").val("");
	 page(1);
}

//通知创建页
function formNotice(id){
	var method="editIndex";
	if(isEmpty(id)){
		id="";
		method="addIndex";
	}
	window.location.href = "${basePath}/notice.do?method="+method+"&id="+id;	
}
//删除
function deleteNotice(noticeInfoId){
	if(isEmpty(noticeInfoId)){
		noticeInfoId = "";
	}
     if(confirm("确定删除通知信息吗？")){	
			var url = "${basePath }notice.do?method=delete";
			var data = "&id="+noticeInfoId;
			ajaxJsonTipByData(url,data,true);
			location.reload(); 
    }
}
//查看详细
function noticeDetail(id){
	
if(isEmpty(id)){ id=""; }

var url="${basePath }activityCont.do?method=detail&contId="+id+"&channelCode=2";

	$("#noticeDetail").attr("href",url).click();		
}

// 发布通知
function formReleaseCont(id,title,activityName,activeStartTime,activeEndTime){
	if(isEmpty(id)){
		id="";	
	}
	if(isEmpty(title)){
		title="";	
	}
	if(isEmpty(activityName)){
		activityName="";	
	}
	if(isEmpty(activeStartTime)){
		activeStartTime="";	
	}
	if(isEmpty(activeEndTime)){
		activeEndTime="";	
	}	
	var data = "&channelCode=2&contentId="+id+"&status=A&noticeTitle="+title+"&activityName="+activityName+"&activeStartTime="+activeStartTime+"&activeEndTime="+activeEndTime;
	var url = "${basePath}/notice.do?method=pulishCondition";	
	window.location.href =url+data;

}

// 查看发布详情
function searchDetail(ruleId,activityName){
	if(isEmpty(ruleId)){
		ruleId = "";
		alert("数据查询失败！");
		return;
	}
	if(isEmpty(activityName)){
		activityName = "";
	}

	var url="${basePath }rule.do?method=detail&ruleId="+ruleId+"&activityName="+activityName;;
	$("#detail").attr("href",url).click();
}
</script>
</head>
<body>
	<div style="display:none;">
		<a href="#" id="noticeDetail" class="fancybox_noticeDetail"></a>
		<a href="#" id="detail" class="fancybox_detail"></a>
	</div>	
   <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">       
      <div class="article">
      <div class="rightTitle_add">
         <check:hasAuthority authorityID='130701'>
           <a href="javascript:formNotice('');">发送通知
<%--            ${shopVo.wordNames['gmsd103']} --%>
           </a>
           </check:hasAuthority>
            <span>通知列表
<%--             ${shopVo.wordNames['gmsd104']} --%>
            </span>
               </div>
              <table width="100%" border="0" cellpadding="0" cellspacing="1" class="fileTable" style="background-color:#F8F7F7; ">
					<tr>
						<td colspan="8" style="padding-top: 20px;">					
							<div class="behaviorSearch"  style="float:left; height:40px;">
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 10px;">通知标题：</span>
							<input type="text" id="noticeTitle" class="behaviorInput"  style="margin-left: 0px;" />
				
							<span style="float: left; height: 20px; line-height: 24px; padding-left: 20px;">${shopVo.wordNames['gmsc218']}：</span>
								<select  class="behaviorInput" id="publishStatus" style="width:120px;margin-left: 0px;">			
									<option value="">-${shopVo.wordNames['gmsd088']}-</option>
									<option value="W">待审核</option>
									<option value="A">通过</option>
									<option value="B">未通过</option>
									<option value="P">已发布</option>			
								</select>
								<a href="javascript:void(0)" style="margin-left: 60px ;margin-top:-6px;" id="select" onclick="page(1)" class="search orangeBtn">${shopVo.wordNames['gmsc006']}</a>
								<a href="javascript:void(0)" style="margin-top:-6px;" onclick="clearArgs();" class="search orangeBtn">${shopVo.wordNames['gmsc007']}</a>												
							</div>
						</td>
	             	</tr>
				</table>   
                <span id="fileCont1">&nbsp;</span>
           </div>                  
     </div>
</body>
</html>