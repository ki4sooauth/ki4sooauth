<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${imgPath}/common/jcroup/css/jquery.Jcrop.css" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${imgPath}/common/js/jquery.form.js"></script>
<script src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script src="${imgPath}/common/jcroup/js/jquery.Jcrop.js"></script>
<script src="${imgPath}/common/js/upload.js"></script>
<link href="${imgPath}/gms/common/css/BTopBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gms/common/css/image_alter.css" rel="stylesheet" type="text/css" />
<%-- <script type="text/javascript" src="${imgPath}/gms/common/js/public.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
<style type="text/css">
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
</head>
<script type="text/javascript">
	jQuery(function($) {
		freshPic();
		initJscrop_db();
		initFileUpload_db("BtnSaveAvatar",'${basePath}');
	});
	function initJscrop_db() {
		var w = $("#picture-preview").find(".preview-container").eq(0).width();
		var h = $("#picture-preview").find(".preview-container").eq(0).height();
		var r = w / h;
		$('#picture_original').Jcrop({
			onChange: showPreview_db,
			onSelect: showPreview_db,
			aspectRatio: r
		}, function() {
			jcrop_api = this;
			var sl = getSelectArea(jcrop_api.getBounds()[0],jcrop_api.getBounds()[1],w,h);
			this.setSelect(sl);
			freshJcropCss();
		});
	}
	function showPreview_db(coords)
	{
		//获取坐标 x,y (起始坐标)  w,h(宽高坐标)
		$('#trim_x').val(coords.x);
		$('#trim_y').val(coords.y);
		$('#trim_w').val(coords.w);
		$('#trim_h').val(coords.h);
		var previews = $("#picture-preview").find(".preview-container");
		var boundx = jcrop_api.getBounds()[0];
		var boundy = jcrop_api.getBounds()[1];
		
		var pw = previews.eq(0).width();
		var ph = previews.eq(0).height();
		var rx = pw / coords.w;
		var ry = ph / coords.h;
		previews.eq(0).find("img").css({
			width: Math.round(rx * boundx) + 'px',
			height: Math.round(ry * boundy) + 'px',
			marginLeft: '-' + Math.round(rx * coords.x) + 'px',
			marginTop: '-' + Math.round(ry * coords.y) + 'px'
		});
		
		var ph_t = previews.eq(1).height();
		previews.eq(1).find("img").css({
			width: Math.round(rx * boundx) + 'px',
			height: Math.round(ry * boundy) + 'px',
			marginLeft: '-' + Math.round(rx * coords.x) + 'px',
			marginTop: '-' + Math.round(ry * coords.y) + 'px'
		});
		
		previews.eq(2).find("img").css({
			width: Math.round(rx * boundx) + 'px',
			height: Math.round(ry * boundy) + 'px',
			marginLeft: '-' + Math.round(rx * coords.x) + 'px',
			marginTop: '-' + Math.round(ry * coords.y+ph_t) + 'px'
		});
	}
	function initFileUpload_db(id,basePath) {
		$("#"+id).submitFile({
			action : basePath+"upload.do?method=uploadFile",
			zindex : 0,
			type : "text",
			success : function(url, obj) {
				$("input[name=filePath]").val(url);
				destroy();
				freshPic();
				initJscrop_db();
			}
		});
	}
</script>
<script>
function freshJcropCss(){
	 $('.jcrop-holder').css({'margin-left':'auto','margin-right':'auto'});
}
</script>
<body>

<form id="uploadForm" action="" style="display:;">
	<input type="hidden" id="trim_x" name="trim_x" value=0 style="width:30px;border:0;" readonly="readonly" />
	<input type="hidden" id="trim_y" name="trim_y" value=0 style="width:30px;border:0;" readonly="readonly"/>
	<input type="hidden" id="trim_w" name="trim_w" value=0 style="width:30px;border:0;" readonly="readonly" />
	<input type="hidden" id="trim_h" name="trim_h" value=0 style="width:30px;border:0;" readonly="readonly" />
	<c:if test="${!empty url}">
		<input id ="filePath" type="hidden" name="filePath" value="${url}">
	</c:if>
	<c:if test="${empty url}">
		<input id ="filePath" type="hidden" name="filePath" value="${imgPath}/gms/common/images/default2.jpg">
	</c:if>
	<input id ="divided_h" type="hidden" name="divided_h" value="128">
	<div id="previews" style="display:none;">
		<input type="hidden" id="width" name="width" value="640" />
		<input type="hidden" id="height" name="height" value="400" />
	</div>
</form>
<div class="alter_boxpop" style="width:880px;">
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
		
			<div style="vertical-align:middle;display:inline-block;zoom:1;width:666px;height:426px; margin:5px 5px;*+float:left;">
			<div class="picture-pane" style="margin:5px;">
				<div title="preview"  class="preview-container" style="overflow: hidden;width:640px;height:400px">
				</div>
			</div>
			<div style="width:640px;height:30px;">640 * 400</div>
			</div>
		
			<div style="vertical-align:middle;display:inline-block;zoom:1;width:666px;height:154px; margin:5px 5px;*+float:left;">
			<div class="picture-pane" style="margin:5px;">
				<div title="preview"  class="preview-container" style="overflow: hidden;width:640px;height:128px">
				</div>
			</div>
			<div style="width:640px;height:30px;">640 * 128</div>
			</div>
			
			<div style="vertical-align:middle;display:inline-block;zoom:1;width:666px;height:298px; margin:5px 5px;*+float:left;">
			<div class="picture-pane" style="margin:5px;">
				<div title="preview"  class="preview-container" style="overflow: hidden;width:640px;height:272px">
				</div>
			</div>
			<div style="width:640px;height:30px;">640 * 272</div>
			</div>
			
			<div style="height:15px;">&nbsp;</div>
		</div>
	</div>
   <a href="javascript:void(0);" onclick="uploadPath('${basePath}');" class="confirm_btn blueBtn">确认</a>
</div>
</body>
</html>