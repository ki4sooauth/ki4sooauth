<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${!empty data}">
	<input type="hidden" name="acount" value="${count}"/>
 	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="MycTable">
                  <tr>
                    <th width="7%"><input type="checkbox"  name="Allselect" id="chk_all_activity" onclick="allSelect(id,'favoriteActivity','Singleselect_activity')"/><label>全选</label></th>
                    <th width="33%">名称</th>
                    <th width="30%">活动商家</th>
                    <th width="15%">活动时间</th>
                    <th width="15%">收藏时间</th>
                  </tr>
                  <c:forEach items="${data}"  var="list">
                  <tr  id="favoriteActivity"  class="favoriteActivity_tr">
                    <td align="center"><input type="checkbox"  name="Singleselect_activity"  value="${list.favoriteId}" onclick="parent.removeSelectAll('chk_all_activity')"/></td>
                    <td>
                      <u><a href="${list.activityUrl}" target="_blank"><img src="${list.image.smallImgUrl}" width="66" height="66" style="display:block"></a></u>
                      <p  align="center" style="margin-top:25px">${list.activityName}</p>
                   </td>
                    <td align="center">${list.shopName}</td>
                    <td align="center">${list.activityStartTime}<br/>至<br/>${list.activityEndTime}</td>
                    <td align="center"><fmt:formatDate value="${list.favoriteTime }" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
                </tr>
          </c:forEach>
    </table>
    <a href="javascript:void(0);" class="btnOrange"  onclick="del_activity()">删除选中</a>                
	<div class="section">
	 <%@ include file="/WEB-INF/jsp/favorite/page/page_activity.jsp"%>
	</div>   
</c:if>
<c:if test="${empty data}">       
	<div class="sorryPrompt" id="activity_sorry">
		<samp>${message }</samp>
	</div>
</c:if>
<c:if test="${!empty guess_recommendationActivityList }">
<!-- 	<div class="collection_hot"> -->
		<div class="guessLike">猜您喜欢</div>
		<ul class="guessBox">
			<c:forEach items="${guess_recommendationActivityList}" var="list">
				<li><a href="${list.activityVisitUrl}" target="_blank"><img src="${list.activityImage.middleImgUrl}" width="180" height="180" /></a>
					<p class="msg">${list.activityName}</p>
				</li>
			</c:forEach>
		</ul>
<!-- 	</div> -->
</c:if>
            