<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140307");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsg331']}</title>
<link type="text/css" rel="stylesheet" href="${imgPath}/gms/common/css/quickMark_list.css" media="screen"/>
<script type="text/javascript" src="${imgPath}/gms/shopinfo/js/jquery.PrintArea.js"></script>
<style type="text/css">
.qiuckMark_box{border: 0px}
.printa {
    display: block;
    font-weight: bold;
    height: 36px;
    line-height: 36px;
    margin: 0 auto;
    width: 183px;

    background: none repeat scroll 0 0 #0873B9;
    color: #FFFFFF;
    display: inline-block;
    text-align: center;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	page(1);
});

/**
 * 请求分页操作
 * @param pageIndex
 * @param URL
 */
function page(pageIndex){
	var id ="codeList";
	var codeName='${codeName}';
	var pageSize='${pageSize}';
	var shopEntityId='${shopEntityId}';
	if(shopEntityId==""&&shopEntityId==undefined){
		shopEntityId="";
	}
	var flag='${flag}';
	//餐桌
	if(flag=='140404'){
		var url = "${basePath }/qrCode.do?method=pageTwoDimCode";
	}
	//商品
	if(flag=='140401'){
		var url = "${basePath }/qrCode.do?method=twoDimGoods";
	}
	//优惠凭证
	if(flag=='140402'){
		var url = "${basePath }/qrCode.do?method=twoDimCoupon";
	}
	//活动
	if(flag=='140403'){
		var url = "${basePath }/qrCode.do?method=twoDimActivty";
	}
	var data = "&pageIndex=" + pageIndex+"&codeName="+codeName+"&pageSize="+pageSize+"&shopEntityId="+shopEntityId;
	$.ajax({
		type: "POST",
	    async: false,
	    url: url,
	    data: data,
		success: function(html){
			$("#" + id).html(html);
		}
	});
	printSetup();
}


/**
 * 打印二维码
 */
function printSetup(){
	var picSize = '${picSize}';
	if(!/^[1-9][0-9]*$/.test(picSize)){
		$("input[name='picSize']").focus();
		alert("请输入正确二维码尺寸");
		return;
	}
	picSize = Number(picSize);
	var printInfoObject = document.getElementById("codeList");
	if(picSize != 120){
		$(printInfoObject).find("img").each(function(index){
		 $(this).attr("width",picSize);
		 $(this).attr("height",picSize);
		});
	}
    var printHtml = printInfoObject.innerHTML;
    //window.document.body.innerHTML = printHtml;
//     window.print();       
}
function doPrint(){
// 	window.print();
	$("#printArea").printArea();
}
</script>
</head>
<body>
<center>
<!--         <div class="section"> -->
<!--           <div class="rightTitle"> -->
<%--             <span>${shopVo.wordNames['gmsg327']}</span> --%>
<!--           </div> -->
          <div class="qiuckMark_box">
                <div id="codeList" style="width: 1000px;">
                </div>
   
      </div>
<!--   </div> -->
  </center>
</body>
</html>
