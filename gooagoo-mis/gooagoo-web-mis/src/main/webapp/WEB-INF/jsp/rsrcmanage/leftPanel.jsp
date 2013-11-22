<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gooagoo平台管理系统</title>
</head>

<body topmargin="0" leftmargin="0">
<!--内容-左边栏-->
<div class="sidebar">
	<c:forEach var="item1" items="${mis_login_auths}" varStatus="im1">
		<c:if test="${item1.pId eq parentId}">
			<div class="ju">
				<p><a href="#">${item1.name}</a></p>
				<div class="ul">
					<c:forEach var="item2" items="${mis_login_auths}" varStatus="im2">
						<c:if test="${item2.pId eq item1.id}">
							<span onclick="showRight('${item2.url}')">${item2.name}</span>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</c:if>
   	</c:forEach>
</div>
</body>
<script type="text/javascript">
//JavaScript Document
$(function(){
	leftPanelCss();
})

//左侧面板点击样式 
function leftPanelCss(){
	$(".big_box p input").click(function(){
		var t_ch=$(this).attr("checked");
		if(t_ch=="checked"){
				$(this).parents("p").addClass("bor_p").find("a").css("color","#EB7C1D").end().prev("p").addClass("to_bor");					
			}else{					
				$(this).parents("p").removeClass("bor_p").find("a").css("color","#000").end().prev("p").removeClass("to_bor");
				}
	})
$(".big_box p:odd").css("background","#F0F0EE");
$(".menu li:last").find("a").addClass("a_bj_none");
$(".menu a").click(function(){
		$(this).addClass("a_hover").parents("li").siblings("li").find("a").removeClass("a_hover");
	});
$(".ju p").toggle(function(){
		$(this).css("background","url(${imgPath}/mis/images/p_bj-01.png)").siblings(".ul").show();
	},function(){
		$(this).css("background","url(${imgPath}/mis/images/p_bj2-01.png)").siblings(".ul").hide();
		});
$(".ul span").click(function(){
		$(".ul span").css("background","#fff");
		$(this).css("background","#D6D6D6");
	})
$(".page .in5").click(function(){
	    $(".page p").show()
	
	})
$(".div_top .in6").toggle(function(){
	  $(this).css({"bottom":"0","background":"url(url(${imgPath}/mis/images/in_bj6-01.png) no-repeat"}).parents(".div_top").css("border","none").find(".div_p").hide();
   },function(){
	   $(this).css({"bottom":"-2px","background":"url(url(${imgPath}/mis/images/in_bj5-01.png) no-repeat"}).parents(".div_top").css("border-bottom","1px #7C7C7C dashed").find(".div_p").show();
		
	})
}

function showRight(url){
	$("#frameRight",window.parent.document).attr("src",url);
}
</script>
</html>