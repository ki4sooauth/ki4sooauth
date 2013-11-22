<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script>
$(document).ready(function(){
	$('#addresser_list li h3 samp a.theme_button').bind('click',function(){
		$(this).closest('samp').toggleClass('curr').end().closest('h3').next('.hide_msg_box').slideToggle().closest('li').siblings("li").find('samp').removeClass("curr").closest('h3').next('.hide_msg_box:visible').hide();
	});
});
</script>
<c:if test="${MessageInfolist != null && fn:length(MessageInfolist) > 0 }">
	<div class="addresser_list">
			<p class="title">
				<span class="name  checked_control">
				<input class="select_all" id="check_notice" name="check_notice" type="checkbox" />发件人</span>
				<span class="theme">主题内容</span>
				<span class="time">时间</span>
				<span class="control">操作</span>
			</p>
			<ul id="addresser_list" >
				<c:forEach var="messageInfo" items="${MessageInfolist}">
					<input type="hidden" name="pageIds" value="${messageInfo.pageId}"/>
					<li id="no_${messageInfo.id}">
						<h3>
							<span class="name"> <input type="checkbox" name="c_notice" value="${messageInfo.id}" onclick="removeSelectAll('check_notice')" class="addresser_listBox" />
							<label>${messageInfo.shopName}</label>
							</span>
							<samp>
								<a class="theme_button" href="javascript:void(0);">${messageInfo.title}<b class="arrowList"></b>
								</a>
							</samp>
							<span class="time"><fmt:formatDate
									value="${messageInfo.pushTime}" pattern="yyyy年MM月dd日" /></span> <span
								class="control"> <a
								href="javascript:del('${messageInfo.id}');"
								class="arrowColor btnOrange">删除</a>
							</span>
						</h3>
						<div class="hide_msg_box">
							<p class="hide_msg_box_left">
								<c:if test="${messageInfo.infoType eq 'A' || messageInfo.infoType eq 'C' || messageInfo.infoType eq 'G'}">
									<a href="${messageInfo.picHerf}" target="_blank"><img src="${messageInfo.thumbnailPic.smallImgUrl}" width="66" height="66" /></a>
								</c:if>
							</p>
							<div class="hide_msg_box_right" style="float: left;">
								${messageInfo.contentWeb}</div>
							<div class="hide_msg_boxA">
								<c:if test="${messageInfo.infoType eq 'A'}">
									<a href="javascript:shouchangA('${messageInfo.noticeId}','${messageInfo.objectId }','${messageInfo.shopId }');">收藏</a>
								</c:if>
								<c:if test="${messageInfo.infoType eq 'C'}">
									<a href="javascript:shouchangC('${messageInfo.noticeId}','${messageInfo.objectId }','${messageInfo.shopId }');">收藏</a>
								</c:if>
								<c:if test="${messageInfo.infoType eq 'G'}">
									<a href="javascript:shoplist('${messageInfo.objectId}','${messageInfo.shopName}','${messageInfo.shopId}');">加入购物清单</a>
									<a href="javascript:shouchangG('${messageInfo.noticeId}','${messageInfo.objectId }','${messageInfo.shopId }');">收藏</a>
								</c:if>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			   <div class="checked_control_del">
				   	<a href="javascript: void(0);" id="nextPage" class="btnNext">下一页</a>
			   		<a href="javascript: void(0);" id="prevPage" class="btnNext">上一页</a>
				   	<a href="javascript:dddd();">删除选中</a>
                </div>

		</div>
</c:if>
<c:if test="${MessageInfolist == null || fn:length(MessageInfolist) <= 0 }">
		<div class="sorryPrompt" align="center">
			<samp>${message}</samp>
		</div>
</c:if>