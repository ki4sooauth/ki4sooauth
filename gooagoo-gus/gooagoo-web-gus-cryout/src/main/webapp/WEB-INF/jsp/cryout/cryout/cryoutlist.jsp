<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:choose>
<c:when test="${isSuccess && data != null }">
<div class="section">
	<input type="hidden" name="cryoutType" value="${data.cryoutType }"/>
	<c:choose>
	<c:when test="${data.cryoutType == 2 }">
	<div class="sorryPrompt">
	    <samp>抱歉，您还没有新吆喝</samp>
	</div>
	<c:if test="${data.cryoutList != null && fn:length(data.cryoutList) > 0 }">
	<div class="collection_hot">
		<div class="tab-arrow2">
          	<b></b>
        </div>
		<div class="NavAll">
			<span><label>他们在说</label></span>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/cryout/cryout/morecryoutlist.jsp"%>
	</c:if>
	</c:when>
	<c:otherwise>
	<%@ include file="/WEB-INF/jsp/cryout/cryout/morecryoutlist.jsp"%>
	<div class="ClickShow" style="display: none;"><a href="javascript: void(0);" class="ClickShowA" onclick="javascript: loadMoreConvertThingRequest();">查看更多内容</a></div>
	</c:otherwise>
	</c:choose>
</div>
</c:when>
<c:otherwise>
<div class="section">
	<div class="sorryPrompt">
	    <samp>${message }</samp>
	</div>	
</div>
</c:otherwise>
</c:choose>