<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板系统</title>
<link href="${imgPath}/template/css/bootstrap-combined.min.css" rel="stylesheet">
<script type="text/javascript" src="${imgPath}/template/js/jquery.js"></script>
<script type="text/javascript" src="${imgPath}/template/js/templateJs.js"></script>
<script type="text/javascript" src="${imgPath}/template/js/ajax.js"></script>
<script type="text/javascript" src="${imgPath}/template/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//初始化编辑器
	loadHtml('${template_type}');
	if('${temp_id}' != ''){
		//如果有模板id则加载模板内容
		initTemplate('${temp_id}','${type}');
	}else{
		alert('新建空白模板。');
		clearDemoDiv();
		$("#templateInfo").html('${cont}');
	}
	initQuerys();//初始化查询条件（商品）
});
</script>
</head>
<body style="min-height: 660px; cursor: auto;" class="edit">
	<!-- 头div -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<div class="nav-collapse collapse">
					<ul class="nav" id="menu-layoutit">
						<li>
							<div class="btn-group" data-toggle="buttons-radio">
								<button type="button" id="edit" class="btn btn-primary active">
									<i class="icon-edit icon-white"></i>编辑
								</button>
								<button type="button" class="btn btn-primary" id="sourcepreview">
									<i class="icon-eye-open icon-white"></i>预览
								</button>
								<button class="btn btn-primary" href="#" role="button" data-toggle="modal" data-target="#shareModal">
									<i class="icon-share icon-white"></i>保存
								</button>
								<button class="btn btn-primary" href="javascript:void(0)" onclick="window.history.go(-1);">
									<i class="icon-home icon-white" style="background-position:-216px -24px"></i>返回
								</button>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 头div e-->
	<div class="container-fluid" id="loadHtml"></div>
</body>
</html>