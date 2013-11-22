<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${imgPath}/common/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${imgPath}/common/js/jquery.form.js" type="text/javascript"></script>
<script src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script src="${imgPath}/common/jcroup/js/jquery.Jcrop.js"></script>
<link href="${imgPath}/common/jcroup/css/jquery.Jcrop.css" type="text/css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var bounds;
	var jcrop_api;
	jQuery(function($) {
		freshPic();
		initJscrop();
		initFileUpload("BtnSaveAvatar");
	});
	function initJscrop() {
		var w = $("#picture-preview").find(".preview-container").eq(0).width();
		var h = $("#picture-preview").find(".preview-container").eq(0).height();
		var r = w / h;
		$('#picture_original').Jcrop({
			onChange: showPreview,
			onSelect: showPreview,
			aspectRatio: r
		}, function() {
			jcrop_api = this;
			//用API来获得真正的图像尺寸
			bounds = this.getBounds();
		});
	}
	function freshPic(){
		var url = $("input[name=filePath]").val();
		var po = "<img id='picture_original' src='"+url+"' name='preview'  alt='原图' style='width:auto;height:auto;' />";
		$('#pane_picture_original').html(po);
		
		initPreviewPic();
	}
	function initPreviewPic(){
		var o = $('#picture_original');
		
		var prep = "<img src='"+o.attr("src")+"' name='preview'  alt='预览图' />";
		var previews = $("#picture-preview").find(".preview-container");
		for(var i=0;i < previews.size();i++){
			previews.eq(i).html(prep);
		}
		
		var w0 = previews.eq(0).width();
		var h0 = previews.eq(0).height();
		var r = w0 / h0;
		var h1 = 0;
		var w1 = 0;
		if(r>=1){
			if(h0>=o.height()){
				h1 = o.height();
				w1 = h1*r;
			}else{
				h1 = h0;
				w1 = h1*r;
			}
		}else{
			if(w0>=o.width()){
				w1 = o.width();
				h1 = w1 / r;
			}else{
				w1 = w0;
				h1 = w1 / r;
			}
		}
		var coords = {
			x:0,
			y:0,
			w:w1,
			h:h1
		}
		bounds = [o.width(),o.height()]
		showPreview(coords);
	}
	function destroy(){
		jcrop_api.destroy();
		$('#pane_picture_original').html("");
		$("#picture-preview").find("img").remove();
	}
	function showPreview(coords)
	{
		//获取坐标 x,y (起始坐标)  w,h(宽高坐标)
		$('#trim_x').val(coords.x);
		$('#trim_y').val(coords.y);
		$('#trim_w').val(coords.w);
		$('#trim_h').val(coords.h);
		var previews = $("#picture-preview").find(".preview-container");
		var boundx = bounds[0];
		var boundy = bounds[1];
		for(var i=0; i < previews.size();i++){
			var pw = previews.eq(i).width();
			var ph = previews.eq(i).height();
			var rx = pw / coords.w;
			var ry = ph / coords.h;
	
			previews.eq(i).find("img").css({
				width: Math.round(rx * boundx) + 'px',
				height: Math.round(ry * boundy) + 'px',
				marginLeft: '-' + Math.round(rx * coords.x) + 'px',
				marginTop: '-' + Math.round(ry * coords.y) + 'px'
			});
		}
	}

	function initFileUpload(id) {
		$("#"+id).submitFile({
			action : "upload.do?method=uploadFile",
			zindex : 0,
			type : "text",
			success : function(url, obj) {
				$("input[name=filePath]").val(url);
				destroy();
				freshPic();
				initJscrop();
			}
		});
	}
	
	function uploadPath(){
		var url = "upload.do?method=uploadPath";
		var data = $("#uploadForm").serialize();
	    $.ajax({
			type: "POST",
		    async: false,
		    url: url,
		    data: data,
			success: function(html){
			    (document.parentWindow || document.defaultView).parent.uploadDone(html);
			}
		});
	}
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
     	<a href="#" id="BtnSaveAvatar" style="border: medium none;display:inline-block;background:url(${imgPath}/gms/marketing/images/guifanbutton-01.png) no-repeat;text-decoration:none;color:#fff;height:28px;line-height:28px;width:70px;">上传图片</a>
     	<span style="width:10px;">&nbsp;</span>
     	<a href="#" onclick="uploadPath();" style="border: medium none;display:inline-block;background:url(${imgPath}/gms/marketing/images/guifanbutton-01.png) no-repeat;text-decoration:none;color:#fff;height:28px;line-height:28px;width:70px;">保存图片</a>
  		<form id="uploadForm" action="" style="display:;">
			x:<input type="text" id="trim_x" name="trim_x" value=0 style="width:30px;border:0;" readonly="readonly" />
			y:<input type="text" id="trim_y" name="trim_y" value=0 style="width:30px;border:0;" readonly="readonly"/>
			W:<input type="text" id="trim_w" name="trim_w" value=0 style="width:30px;border:0;" readonly="readonly" />
			H:<input type="text" id="trim_h" name="trim_h" value=0 style="width:30px;border:0;" readonly="readonly" />
			<input id ="filePath" type="hidden" name="filePath" value="${url}">
			<div id="previews" style="display:none;">
				<c:forEach var="item" items="${previews}" varStatus="xh">
				<input type="hidden" id="scale_${item.name}" name="scale_${item.name}" value="${item.width}_${item.height}" />
				</c:forEach>
			</div>
		</form>
  	</div>
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
		<div style="vertical-align:middle;display:inline-block;zoom:1;width:${item.width+26}px;height:${item.height+26}px; margin:0 5px;*+float:left;">
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
</body>
</html>