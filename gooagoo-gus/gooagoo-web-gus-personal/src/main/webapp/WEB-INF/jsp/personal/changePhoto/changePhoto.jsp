<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<link rel="stylesheet" href="${imgPath}/common/jcroup/css/jquery.Jcrop.css" type="text/css" />
<link rel="stylesheet" href="${imgPath}/gus/personal/css/jcroup.css" type="text/css" />
<script src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script src="${imgPath}/common/jcroup/js/jquery.Jcrop.js"></script>
<script src="${imgPath}/gus/personal/js/upload.js"></script>
<script>var userLogo = "${loginuserkey.personalProfile.headPic }";</script>
<input type="hidden" name="imgPath" value="${imgPath}" />
<input type="hidden" name="basePath" value="${basePath}" />
<div class="pim_wrap">
	<div style="padding-bottom: 1px; overflow: hidden; height: 100%;">
		<p class="title">
			<strong>修改头像</strong>
		</p>
		<div style="width: 500px; margin: 0 auto;">
			<div class="picture-contarner" id="picture-div"
				style="float: left; width: 300px; height: 300px;">
				<div
					style="display: inline-block; margin-left: 0; margin-right: 300; width: 300px; height: 300px;">
					<div class="picture-pane" id="pane_picture_original"
						style="width: 300px; height: 300px;">
						<img src="" id="picture_original"
							style="width: 300px; height: 300px;" alt="original" />
					</div>
				</div>
			</div>
			<div class="picture-contarner" id="picture-preview"
				style="float: left; clear: none;">
				<div style="clear: both; overflow: hidden; *+ padding: 0 0 0 100px">
					<c:forEach var="item" items="${previews}" varStatus="xh">
						<c:if test="${xh.count == 1 }">
							<div
								style="vertical-align:middle;display:inline-block;zoom:1;width:${item.width }px;height:${item.height }px; margin:0 5px;*+float:left;">
								<div class="picture-pane">
									<div title="preview" class="preview-container"
										style="overflow: hidden;width:${item.width}px;height:${item.height}px">
									</div>
								</div>
								<div style="width:${item.width}px;">${item.width} *
									${item.height}</div>
							</div>
						</c:if>
						<c:if test="${xh.count == 2 }">
							<div
								style="vertical-align:middle;display:inline-block;zoom:1;width:${item.width }px;height:${item.height }px; margin:0 5px;*+float:left;">
								<div class="picture-pane">
									<div title="preview" class="preview-container"
										style="overflow: hidden;width:${item.width}px;height:${item.height}px">
									</div>
								</div>
								<div style="width:${item.width}px;">${item.width} *
									${item.height}</div>
							</div>
						</c:if>
					</c:forEach>
					<div style="height: 15px;">&nbsp;</div>
				</div>
			</div>
		</div>
		<div class="preview_image_box" style="clear: both;">
			<div style="margin: 10px 0; text-align: center;">
				<a href="javascript:void(0)" id="BtnSaveAvatar"
					style="border: medium none;display:inline-block;background:#d51111;text-decoration:none;color:#fff;height:28px;line-height:28px;width:78px;">上传头像</a>
				<span style="width: 10px;">&nbsp;</span>
				<c:choose>
					<c:when test="${fn:indexOf(url, 'deflogo.png') > -1 }">
						<a id="updatePic" href="javascript:void(0)"
							style="border: medium none;display:none;background:#d51111;text-decoration:none;color:#fff;height:28px;line-height:28px;width:70px;">修改头像fdsfsdfsdf</a>
					</c:when>
					<c:otherwise>
						<a id="updatePic" href="javascript:void(0)"
							style="border: medium none;display:inline-block;background:#d51111;text-decoration:none;color:#fff;height:28px;line-height:28px;width:70px;">修改头像</a>
					</c:otherwise>
				</c:choose>
				<form id="uploadForm" action="" style="display: none;">
					<input type="hidden" id="tuseSameFile" name="useSameFile"
						value="AN" /> x:<input type="text" id="trim_x" name="trim_x"
						value=0 style="width: 30px; border: 0;" readonly="readonly" /> y:<input
						type="text" id="trim_y" name="trim_y" value=0
						style="width: 30px; border: 0;" readonly="readonly" /> W:<input
						type="text" id="trim_w" name="trim_w" value=0
						style="width: 30px; border: 0;" readonly="readonly" /> H:<input
						type="text" id="trim_h" name="trim_h" value=0
						style="width: 30px; border: 0;" readonly="readonly" />
					<c:choose>
						<c:when test="${fn:indexOf(url, 'deflogo.png') > -1 }">
							<input id="filePath" type="hidden" name="filePath" value="${url }">
						</c:when>
						<c:otherwise>
							<input id="filePath" type="hidden" name="filePath" value="${fn:substringBefore(url, '_n') }${fn:substringAfter(url, '_n') }">
						</c:otherwise>
					</c:choose>
					<div id="previews" style="display: none;">
						<c:forEach var="item" items="${previews}" varStatus="xh">
							<input type="hidden" id="scale_${item.name}" name="scale_${item.name}" value="${item.width}_${item.height}" />
						</c:forEach>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
