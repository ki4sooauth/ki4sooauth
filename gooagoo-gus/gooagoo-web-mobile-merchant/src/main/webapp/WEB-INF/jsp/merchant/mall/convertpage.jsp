<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0;minimum-scale=1.0, maximum-scale=1.0">
<title>兑换商品</title>
<script type="text/javascript" src="${imgPath }/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath }/common/js/normalCheck.js"></script>
<script src="${imgPath }/gus/merchant/mobile/js/integralconvert.js"></script>
<link href="${imgPath }/gus/merchant/mobile/css/global.css" rel="stylesheet" type="text/css">
<link href="${imgPath }/gus/merchant/mobile/css/pop.css" rel="stylesheet" type="text/css">
<link  href="${imgPath }/gus/merchant/mobile/css/global.css" rel="stylesheet" type="text/css">
<link href="${imgPath }/gus/merchant/mobile/css/pop-media-queries.css" rel="stylesheet" type="text/css">
<style>
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
	font: 12px "黑体";
	
}

a {
	text-decoration: none;
}



.pwdChange{
	margin:0 auto;
	overflow:hidden;
	background:linear-gradient(center top , rgb(241, 241, 241) 0%, rgb(222, 223, 224) 100%);
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,rgb(241, 241, 241)), color-stop(100%,rgb(222, 223, 224)));/* Chrome,Safari4+ */
	background:-webkit-linear-gradient(center top, rgb(241, 241, 241) 0%,rgb(222, 223, 224) 100%); /* Chrome10+,Safari5.1+ */
	background:-moz-linear-gradient(center top , rgb(241, 241, 241) 0%, rgb(222, 223, 224) 100%); /* FF3.6+ */
	background: -ms-linear-gradient(center top,  rgb(241, 241, 241) 0%,rgb(222, 223, 224) 100%); /* IE10+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f1f1f1', endColorstr='#dedfe0',GradientType=0 ); /* IE6-9 */
	padding-bottom:200px;
	}
.pwdChange .pwdName{ color:#000000; width:30%; display:inline-block; float:left}
.pwdChange .passDiv{ padding:0 0 0 5%; overflow:hidden}
.pwdChange .passInput{ background-color:#ffffff; width:62%;}
.regionSelectArea{background-color:#ffffff; width:62%; padding:8px 0}
.selectDiv{background-color:#ffffff; width:62%; display:inline-block; position:relative}
.selectDiv .regionSelect{ padding:0; margin:0; background:transparent;-webkit-appearance: none; width:100%; border:0 none; position:absolute; left:0; top:0}
.pwdChange .passInput:focus,.selectDiv .regionSelect:focus,.regionSelectArea{ outline:none}
.selectDiv .markBtn{ position:absolute;right:10px;top:47%;
width: 0;
height: 0;
font-size:0;  
border-left: 8px solid transparent;
border-right: 8px solid transparent;
_border-left: 8px solid white;
_border-right: 8px solid white;
border-top: 8px solid #a1a1a1;
overflow:hidden;
}
.pwdChange .errorTxt{color:#ED1C24; text-align:left}
.pwdChange .commitControl{ text-align:center;}
.pwdChange .commitControl .commitBtn{ cursor:pointer; color:#7F7F7F;font-family:'黑体';
    background:linear-gradient(center top , #f9f9f9 0%, #cacaca 100%);
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#f9f9f9), color-stop(100%,#cacaca));/* Chrome,Safari4+ */
	background:-webkit-linear-gradient(center top, #f9f9f9 0%,#cacaca 100%); /* Chrome10+,Safari5.1+ */
	background:-moz-linear-gradient(center top , #f9f9f9 0%,#cacaca 100%); /* FF3.6+ */
	background: -ms-linear-gradient(center top,  #f9f9f9 0%,#cacaca 100%); /* IE10+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f9f9f9', endColorstr='#cacaca',GradientType=0 ); /* IE6-9 */
}
.histroyAddress{font-size:32px;line-height:40px;border-top:2px dashed #9FA0A0;margin-top:10px;padding-top:15px;padding-bottom:10px;}
.histroyAddress .confirm{display:block;margin:0 auto;color:#2B3990;width:176px;height:58px;text-align:center;font-size:29px;line-height:58px;border-radius:9px;margin-top:20px;
 background:linear-gradient(center top , #efefef 0%, #dcdddd 100%);
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0%,#efefef), color-stop(100%,#dcdddd));/* Chrome,Safari4+ */
	background:-webkit-linear-gradient(center top, #efefef 0%,#dcdddd 100%); /* Chrome10+,Safari5.1+ */
	background:-moz-linear-gradient(center top , #efefef 0%,#dcdddd 100%); /* FF3.6+ */
	background: -ms-linear-gradient(center top,  #efefef 0%,#dcdddd 100%); /* IE10+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#efefef', endColorstr='#dcdddd',GradientType=0 ); /* IE6-9 */
}
.histroyAddress li{height:50px;line-height:50px;padding-left:5%;}
.histroyAddress p{padding-left:5%;}
.histroyAddress li input{margin:0;padding:0;float:left;margin-top:19px;margin-right:10px;}
.histroyAddress li.curr{background:rgba(0,0,0,0.2)}
.pwdChange .passlabel{width:62%;display:inline-block}

/************************************************************************************
smaller than 320
*************************************************************************************/
@media screen and (max-width: 479px) {

.pwdChange {
	min-width: 320px;
}
.pwdChange .pwdName{  font-size:16px; height:34px; line-height:34px;}
.pwdChange .passDiv{ margin-top:16px;}
.pwdChange .passInput,.selectDiv{ font-size:20px; border-radius:10px; border:2px solid #939598; text-indent:18px; height:34px; line-height:34px;}
.pwdChange .passlabel{ font-size:20px;  text-indent:18px; line-height:34px;}
.regionSelectArea{font-size:20px; border-radius:10px; border:2px solid #939598; text-indent:18px; height:60px;}
.selectDiv .regionSelect{height:34px; line-height:34px;font-size:20px;text-indent:18px;}
.pwdChange .errorTxt{font-size:16px; line-height:22px; margin-top:10px;}
.pwdChange .commitControl{ margin-top:30px;}
.pwdChange .commitControl .commitBtn{font-size:24px; border:2px solid #979797; border-radius:16px; width:180px; height:50px;}

.histroyAddress{font-size:16px;line-height:30px;border-top:2px dashed #9FA0A0;margin-top:15px;padding-top:10px;}
.histroyAddress .confirm{color:#2B3990;width:80px;height:24px;font-size:14px;line-height:24px;border-radius:4px;margin-top:10px;}
.histroyAddress ul{}
.histroyAddress li{height:35px;line-height:35px;padding:5%;}
.histroyAddress li input{margin-top:11px;margin-right:4px;}
}


@media screen and (max-width: 639px) and (min-width: 480px) {
.pwdChange {
	min-width: 480px;
}
.pwdChange .pwdName{  font-size:26px;height:50px; line-height:50px;}
.pwdChange .passDiv{ margin-top:20px;}
.pwdChange .passInput,.selectDiv{ font-size:22px; border-radius:12px; border:2px solid #939598; text-indent:22px; height:50px; line-height:50px;}
.pwdChange .passlabel{font-size:22px;  text-indent:22px; line-height:50px;}
.regionSelectArea{ font-size:22px; border-radius:12px; border:2px solid #939598; text-indent:22px; height:80px;}
.selectDiv .regionSelect{height:50px; line-height:50px; font-size:22px;text-indent:22px;}
.pwdChange .errorTxt{   font-size:22px; line-height:27px; margin-top:17px;}
.pwdChange .commitControl{ margin-top:38px;}
.pwdChange .commitControl .commitBtn{font-size:32px; border:2px solid #979797; border-radius:18px; width:230px; height:60px;}

.histroyAddress{font-size:26px;line-height:40px;border-top:2px dashed #9FA0A0;margin-top:25px;padding-top:20px;}
.histroyAddress .confirm{color:#2B3990;width:100px;height:35px;font-size:18px;line-height:35px;border-radius:6px;margin-top:10px;}
.histroyAddress li{height:45px;line-height:45px;}
.histroyAddress li input{margin-top:17px;margin-right:5px;}
}

@media screen and (min-width: 640px) {
.pwdChange {
	max-width: 640px;
}
.pwdChange .pwdName{  font-size:32px;height:60px; line-height:60px;}
.pwdChange .passDiv{ margin-top:22px;}
.pwdChange .passInput,.selectDiv{ font-size:26px; border-radius:14px;border:2px solid #939598; text-indent:24px; height:60px; line-height:60px;}
.pwdChange .passlabel{ font-size:26px;  text-indent:24px; line-height:60px;}
.regionSelectArea{font-size:26px; border-radius:14px;border:2px solid #939598; text-indent:24px; height:100px;}
.selectDiv .regionSelect{height:60px; line-height:60px;font-size:26px;text-indent:24px;}
.pwdChange .errorTxt{ font-size:24px; line-height:29px; margin-top:19px;}
.pwdChange .commitControl{ margin-top:41px;}
.pwdChange .commitControl .commitBtn{font-size:34px; border:2px solid #979797; border-radius:20px; width:244px; height:70px;}

.histroyAddress{font-size:32px;line-height:40px;border-top:2px dashed #9FA0A0;margin-top:30px;padding-top:20px;}
.histroyAddress .confirm{color:#2B3990;width:176px;height:58px;font-size:29px;line-height:58px;border-radius:9px;margin-top:20px;}
.histroyAddress li{height:50px;line-height:50px;}
.histroyAddress li input{margin-top:19px;margin-right:10px;}
}

</style>
</head>
<body>
<input type="hidden" id="basePath" name="basePath" value="${basePath }" />
<input type="hidden" id="shopIntegralId" name="shopIntegralId" value="${shopIntegralId }" />
<input type="hidden" id="shopId" name="shopId" value="${shopId }" />
<form id="frmConvertThing" action="" method="post">
	<div class="pwdChange">
		<div style="" id="show1">
			<div class="passDiv">
				<span class="pwdName">收货人姓名:</span>
				<input type="text" name="consigneeName" id="consigneeName" maxlength="25" class="passInput" placeholder="请输入用户名">
				<div class="errorTxt" id="namemessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">手机号码:</span>
				<input type="tel" class="passInput" name="phone" id="phone" maxlength="11" style="ime-mode:disabled;" onpaste="javascript: return false;" onkeyup="javascript: return ValidateNumber(this,value);" onblur="javascript: return ValidateNumber(this,value);" placeholder="请输入手机号码">
				<div class="errorTxt" id="mobilemessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">电话号码:</span>
				<input type="tel" class="passInput" name="telephone" id="telephone" placeholder="请输入电话号码">
				<div class="errorTxt" id="phonemessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">邮政编码:</span>
				<input type="text" class="passInput" value="" name="postCode" id="postCode" maxlength="6" style="ime-mode:disabled;" onpaste="javascript: return false;" onkeyup="javascript: return ValidateNumber(this,value);" onblur="javascript: return ValidateNumber(this,value);" placeholder="请输入邮政编码">
				<div class="errorTxt" id="postcodemessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">省份:</span>
				<span class="selectDiv">
					<div class="markBtn"></div>
					<select class="regionSelect" id="province" name="province" onchange="javascript: Cityaaa($('#province').val());">
						<option id="pr" value="">--请选择--</option>
						<c:forEach var="province" items="${provincelist}">
				        	<option value="${province.provinceId}">${province.provinceName}</option>
	                	</c:forEach>
			        	</select>
			   	</span>
				<div class="errorTxt" id="ppmessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">城市:</span>
				<span class="selectDiv">
			      	<div class="markBtn"></div>
			     	<select class="regionSelect" id="city" name="city" onchange="javascript: Area($('#city').val());">
			        	<option id="cc" value="">--请选择--</option>
			      	</select>
			   	</span>
			  	<div class="errorTxt" id="ccmessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">区县:</span>
				<span class="selectDiv">
		          	<div class="markBtn"></div>
		      		<select class="regionSelect" id="area" name="area">
		          		<option id="aa" value="">--请选择--</option>
		       		</select>
				</span>
				<div class="errorTxt" id="aamessage"></div>
			</div>
			<div class="passDiv">
				<span class="pwdName">详细地址:</span>
				<textarea class="regionSelectArea" name="address" id="address" maxlength="50"></textarea>
				<div class="errorTxt" id="addressmessage"></div>
			</div>
			<input type="hidden" class="passInput" name="isDefault" id="isDefault" value="N">
		</div>
		<div class="histroyAddress">
			<p>历史收货地址：</p>
			<input type="hidden" name="consigneeId" id="consigneeId" value="">
			<ul>
				<li class="curr">
					<input type="checkbox" value="" onclick="chanageAddress('',this)" id="addconsignee" name="addresshistory" checked>使用新地址
					<div style="display:none"></div>
				</li>
				<c:forEach items="${consigneelist}" var="consignee">
				<li>
	        		<input type="checkbox" onclick="chanageAddress('${consignee.consigneeId}',this)" name="addresshistory" value="${consignee.consigneeId}">${consignee.address}
	        		<div style="display:none">
	        			<div class="passDiv">
							<span class="pwdName">收货人姓名:</span>
							<span class="passlabel">${consignee.consigneeName }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">手机号码:</span>
							<span class="passlabel">${consignee.phone }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">电话号码:</span>
							<span class="passlabel">${consignee.telephone }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">邮政编码:</span>
							<span class="passlabel">${consignee.postCode }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">省份:</span>
							<span class="passlabel">${consignee.provinceName }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">城市:</span>
							<span class="passlabel">${consignee.cityName }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">区县:</span>
							<span class="passlabel">${consignee.areaName }</span>
						</div>
						<div class="passDiv">
							<span class="pwdName">详细地址:</span>
							<span class="passlabel">${consignee.address }</span>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>
			<div class="commitControl">
				<input id="ok" type="button" class="commitBtn" value="兑换">
			</div>
		</div>
	</div>
</form>
</body>
</html>