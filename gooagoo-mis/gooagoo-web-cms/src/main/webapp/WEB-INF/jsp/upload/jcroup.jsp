<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	request.setAttribute("basePath", "");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${imgPath}/common/jcroup/css/jquery.Jcrop.css" type="text/css" />
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/image_alter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js"></script>
<script src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script src="${imgPath}/common/jcroup/js/jquery.Jcrop.js"></script>
<script src="${imgPath}/common/js/upload.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
</head>
<script type="text/javascript">
	var jcrop_api;
	jQuery(function($) {
		freshPic();
		initJscrop();
		initFileUpload("BtnSaveAvatar",'${basePath}');
	});
	
</script>
<style type="text/css">

/* 应用这些风格只有当#预览面板一直放置在Jcrop小部件 */
.picture-pane {
  display: inline-block;
  
/*   position: absolute; */
  z-index: 2000;
  top: 10px;
  right: -280px;
  padding: 6px;
  border: 1px solid #bbbbbb;
  background-color: white;

  -webkit-border-radius: 6px;
  -moz-border-radius: 6px;
  border-radius: 6px;

  -webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
  box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
}

.picture-contarner{
	clear:both;
	overflow:hidden;
	padding:5px 10px;
	text-align:center
}
</style>
<body>

<div>
	<div style="margin:10px 0; text-align:center;">
  		<form id="uploadForm" action="" style="display:none;">
			x:<input type="text" id="trim_x" name="trim_x" value=0 style="width:30px;border:0;" readonly="readonly" />
			y:<input type="text" id="trim_y" name="trim_y" value=0 style="width:30px;border:0;" readonly="readonly"/>
			W:<input type="text" id="trim_w" name="trim_w" value=0 style="width:30px;border:0;" readonly="readonly" />
			H:<input type="text" id="trim_h" name="trim_h" value=0 style="width:30px;border:0;" readonly="readonly" />
			<input id ="filePath" type="hidden" name="filePath" value="${empty url ? imgPath : ''}${empty url ? '/gms/common/images/default1.jpg' : url}">
			<div id="previews" style="display:none;">
				<c:forEach var="item" items="${previews}" varStatus="xh">
				<input type="hidden" id="scale_${item.name}" name="scale_${item.name}" value="${item.width}_${item.height}" />
				</c:forEach>
			</div>
		</form>
  	</div>
</div>
<div class="alter_boxpop" style="width:auto;">
	<div class="alterBoxTop">
		<a id="BtnSaveAvatar" href="javascript:void(0);" class="blueBtn">上传图片</a>
	    仅支持jpg、gif、png图片文件，且文件小于5M
	</div>
	<div class="picture-contarner" id="picture-div">
		<div style="display:inline-block;margin-left:auto;margin-right:auto;width:auto;">
			<div class="picture-pane" id="pane_picture_original">
				<img src="" id="picture_original" alt="original" style="width:auto;height:auto;" />
			</div>
		</div>
	</div>
	<div class="picture-contarner" id="picture-preview">
		<div style="clear:both;overflow:hidden;*+padding:0 0 0 100px">
		<c:forEach var="item" items="${previews}" varStatus="xh">
			<div style="vertical-align:middle;display:inline-block;zoom:1;width:${item.width+26}px;height:${item.height+26}px; margin:5px 5px;*+float:left;">
			<div class="picture-pane" style="margin:5px;">
				<div title="preview"  class="preview-container" style="overflow: hidden;width:${item.width}px;height:${item.height}px">
				
				</div>
			</div>
			<div style="width:${item.width}px;">${item.width} * ${item.height}</div>
			</div>
		</c:forEach>
		<div style="height:15px;">&nbsp;</div>
		</div>
	</div>
	<a href="javascript:void(0);" onclick="uploadPath('${basePath}');" class="confirm_btn blueBtn">确认</a>
</div>
</body>
</html>