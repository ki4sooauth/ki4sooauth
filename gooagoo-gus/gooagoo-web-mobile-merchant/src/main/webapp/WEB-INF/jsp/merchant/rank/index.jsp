<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- disable iPhone inital scale -->
<meta name="viewport" content="width=device-width; initial-scale=1.0;minimum-scale=1.0, maximum-scale=1.0">
<script src="${imgPath }/common/js/jq.mobi.min.js"></script>
<script type="text/javascript" src="${imgPath }/gus/merchant/mobile/js/position.js"></script>
<title>区域商品销量排行</title>
<style type="text/css">
html,body,address,blockquote,div,dl,form,h1,h2,h3,h4,h5,h6,ol,p,pre,table,ul,dd,dt,li,tbody,td,tfoot,th,thead,tr,button,del,ins,map,object,a,abbr,acronym,b,bdo,big,br,cite,code,dfn,em,i,img,kbd,q,samp,small,span,strong,sub,sup,tt,var,legend,fieldset,textarea
{
	margin: 0;
	padding: 0;
	font-weight:normal;
}

img,fieldset {
	border: 0;
}

/* set image max width to 100% */
img {
	max-width: 100%;
	height: auto;
	width: auto\9; /* ie8 */
}


ul,li,p,h3,h2,h1,samp,label,dl,dt,dd,sup,sub{ list-style:none outside none}
body {
	font: 12px "microsoft yahei";
	background:url(${imgPath }/gus/merchant/mobile/images/Best-selling.jpg) repeat;
}

a {
	text-decoration: none;
}




.bestSell{ margin:0 auto; border:1px solid rgba(4,0,0,0.15); background-color:#ffffff; overflow:hidden; margin-top:22px; padding-bottom:20px}
.bestSell li{ width:94%; margin:0 auto; overflow:hidden; background:url(${imgPath }/gus/merchant/mobile/images/Dashed_03.png) repeat-x 0 bottom}
.bestSell li.titleName{width:100%; margin:0;text-align:center; font-family:'microsoft yahei'; color:#474747; }
.bestSell li .font{ font-family:'宋体'; float:left; color:#646464; font-weight:bold;border-right:3px solid #474747;}
.bestSell li .color1{ color:#9d2f2f}
.bestSell li .color2{ color:#d26d1c}
.bestSell li .color3{ color:#d5a000}
.bestSell li .txt{  float:left; padding-left:2%; width:80%}
.bestSell li .txt .titleName{ color:#474747; font-family:'microsoft yahei'; clear:both}
.bestSell li .txt .personNum{ color:#737373; font-family:'microsoft yahei'; clear:both}
.bestSell li .moneyNum{ float:right; color:#2d2d2c; letter-spacing:-1px}
/************************************************************************************
smaller than 320
*************************************************************************************/
@media screen and (max-width: 479px) {
.bestSell li.titleName{font-size:20px;}

.bestSell {
	max-width: 310px;
}
.bestSell li{ padding:18px 0;}
.bestSell li .font{ font-size:40px; line-height:40px; padding-right:2%}
.bestSell li .txt .titleName{ font-size:16px;}
.bestSell li .txt .personNum{ font-size:12px;}
.bestSell li .moneyNum{ font-size:14px;}

}


@media screen and (max-width: 639px) and (min-width: 480px) {
.bestSell li.titleName{font-size:30px;}

.bestSell {
	max-width: 460px;
}
.bestSell li{ padding:18px 0;}
.bestSell li .font{ font-size:60px; line-height:60px; padding-right:2%}
.bestSell li .txt .titleName{ font-size:24px;}
.bestSell li .txt .personNum{ font-size:14px;}
.bestSell li .moneyNum{ font-size:20px;}
}

@media screen and (min-width: 640px) {
.bestSell li.titleName{font-size:40px;}
.bestSell {
	max-width: 574px;
}
.bestSell li{ padding:22px 0;}
.bestSell li .font{ font-size:80px; line-height:60px; padding-right:2%}
.bestSell li .txt .titleName{ font-size:32px;}
.bestSell li .txt .personNum{ font-size:18px;}
.bestSell li .moneyNum{ font-size:22px;}
}
</style>
</head>
<body>
<input type="hidden" name="basePath" value="${basePath }"/>
<input type="hidden" name="positionId" value="${positionId }"/>
<div id="content"><center><img src="${imgPath }/gus/merchant/mobile/images/indicator_circle_ball.gif">正在加载，请稍候...</center></div>
</body>
</html>