<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%
request.setAttribute("topMenuCode", "");
request.setAttribute("top2MenuCode", "1403");
request.setAttribute("leftMenuCode", "140307");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsg326']}</title>
<link type="text/css" rel="stylesheet" href="${imgPath}/gms/common/css/quickMark_list.css" media="screen"/>
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
	var url = "${basePath }/tableInfo.do?method=pageTwoDimCode";
	var data = "&pageIndex=" + pageIndex;
	$.ajax({
		type: "POST",
	    async: false,
	    url: url,
	    data: data,
		success: function(html){
			$("#" + id).html(html);
		}
	});
}


/**
 * 打印二维码
 */
function doPrint(){
	var picSize = $("input[name='picSize']").val();
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
    window.print();       
}
</script>
</head>
<body>
   <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%>
   <!--内容-->
    <div class="container">
      <div class="article">
        <div class="aside">
          <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
        </div>
        <div class="section">
          <div class="rightTitle">
            <span>${shopVo.wordNames['gmsg327']}</span>
          </div>
          <div class="qiuckMark_box">
                <div id="codeList">
                </div>
                <div class="shopping_Flip">
               <%@ include file="/WEB-INF/jsp/common/page.jsp"%>
          </div>
          <div class="rightTitle">
            <span>${shopVo.wordNames['gmsg328']}</span>
          </div>
          <div class="print_box">
          	${shopVo.wordNames['gmsg329']}<br /><br />

			<span>${shopVo.wordNames['gmsg330']}</span><input type="text" name="picSize" value="120"/><br /><br /><br />
			<a href="javascript:doPrint();" class="blueBtn">${shopVo.wordNames['gmsg331']}</a>
          </div>
      </div>
  </div>
</body>
</html>
