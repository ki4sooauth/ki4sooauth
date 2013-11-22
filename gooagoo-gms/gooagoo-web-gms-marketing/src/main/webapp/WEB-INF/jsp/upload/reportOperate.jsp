<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<script type="text/javascript" src="${imgPath}/common/js/jquery.validate.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/normalCheck.js"></script>
<script type="text/javascript" src="${imgPath}/mis/js/util.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<link href="${imgPath}/mis/css/jspstyle.css" type="text/css" rel="stylesheet">
<link href="${imgPath}/gms/common/css/file.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
$(function(){
	page(1);
	importCommon();	
});

/**
 * 表单验证
 */
function importCommon(){
	$("#importForm").validate({
		rules:{
			"filename" : {
				required : true,
				accept : "xls"
			}
		},
		messages:{
			"filename" : {
				required : "请上传文件",
				accept : "文件格式不支持，请上传 2003版本的xls格式的文件"
			}
		},
		submitHandler: function(){
			enter();
			return false;
		}
	});
}

// 确认导入
function enter(){
	$("#enter").attr("disabled",true);
	$("#importForm").ajaxSubmit({
		url : "${url}",
		type : "POST",
		enctype : "multipart/form-data",
		dataType : "json",
		success : function(data){
			if(data.success){	
			//查询号段号码信息
				page(1);
				alert(data.message);
			}else{
				alert(data.message);
			}
			$("#enter").attr("disabled",false);
		}
	});
}

	function page(index){
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = "&pageIndex="+index + "&pageSize=5&couponId=${coupon_Id}";
		ajaxToPageByData("${basePath}coupon.do?method=grantInfoList","fileCont1",data);
	}

</script>
</head>
<body>
<div class="user_message" style="width: 90%;">
	<form method="post" id="importForm" name="importForm" enctype="multipart/form-data">
		<ul>
			<li>
				<span style="padding-top: 1px;"><code>*</code>导入Excel：</span>				
				<input type="file" style="width : 97;border : 0;height: 33px" class="name_input" id="importExcel" name="filename" />							
		        <input  type="submit" style="height: 30px;width: 97px" class="search orangeBtn behaviorSearch" id="enter" value="确定" />
			</li>		
		</ul>
	</form>
  <div class="rightTitle_add">
   <span>优惠凭证号段号码信息列表</span>
   </div>
	<span id="fileCont1"></span>
</div>
</body>
</html>