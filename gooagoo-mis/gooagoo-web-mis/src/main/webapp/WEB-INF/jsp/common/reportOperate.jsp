<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
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
				alert(data.message);
			 	(document.parentWindow || document.defaultView).parent.closeFancyBox();
			 	(document.parentWindow || document.defaultView).parent.page(1);
			}else{
				alert(data.message);
			}
			$("#enter").attr("disabled",false);
		}
	});
}
</script>
</head>
<body>
<div class="user_message" style="width: 90%;">
	<form method="post" id="importForm" name="importForm" enctype="multipart/form-data">
		<ul>
			<li>
				<span><code>*</code>导入Excel：</span>
				<input type="file" style="width : 30%;border : 0;" class="name_input" id="importExcel" name="filename" />
			</li>
			<li class="perMsg_commit">
				<input type="submit" class="perMsg_btn" id="enter" value="确定" />
			</li>
		</ul>
	</form>
</div>
</body>
</html>