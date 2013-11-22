<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>${shopVo.wordNames['gmsd078']}</title>
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/gms/common/js/common.js"></script>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkCoupon(couponId,status){
	var url = "${basePath }coupon.do?method=check";
	var data = "&id="+couponId + "&note="+$("#note").val()+"&status="+status;
	ajaxJsonTipByData(url,data,true);
	(document.parentWindow || document.defaultView).parent.closeCheckFancyBox();
}
</script>
</head>
<body>
  	<div style="height:auto; padding: 5px 25px;" >
	    <div>
	    	<div style="margin-top:10px;margin-bottom:8px">
	    		<font style="line-height: 21px; color: #5B5F60;"><strong>${shopVo.wordNames['gmsd079']}：</strong></font>
	    	</div>
       <label>
       	<textarea id="note" name="note" onKeyUp="if(this.value.length > 100) this.value=this.value.substr(0,100)" style="width: 260px; height: 90px;padding:5px" rows="" cols=""></textarea>
       </label>
      <div style="margin-top:8px; text-align:center;">
      	<a href="#" onclick="checkCoupon('${coupon.couponId}','N');" style="width: 80px; height: 28px;line-height: 28px;" class="inputBtn blueBtn"><strong>${shopVo.wordNames['gmsd080']}</strong></a>
      	<span style="width:10px;">&nbsp;</span>
      	<a href="#" onclick="checkCoupon('${coupon.couponId}','Y');"  style="width: 80px; height: 28px;line-height: 28px;" class="inputBtn blueBtn"><strong>${shopVo.wordNames['gmsd081']}</strong></a>
	  </div>
    </div>
  </div>
</body>
</html>

