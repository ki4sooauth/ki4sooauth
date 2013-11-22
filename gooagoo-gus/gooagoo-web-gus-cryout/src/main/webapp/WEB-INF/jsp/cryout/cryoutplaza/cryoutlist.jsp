<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:choose>
<c:when test="${isSuccess && data != null && data.cryoutList != null && fn:length(data.cryoutList) > 0 }">
<div class="section">
	<div id="shoplist"></div>
	<%@ include file="/WEB-INF/jsp/cryout/cryoutplaza/morecryoutlist.jsp" %>
	<div class="ClickShow" style="display: none;"><a href="javascript: void(0);" class="ClickShowA" onclick="javascript: loadMoreConvertThingRequest();">查看更多内容</a></div>
</div>
</c:when>
<c:otherwise>
<div class="section">
	<div id="shoplist"></div>
	<div class="sorryPrompt">
	    <samp>${message }</samp>
	</div>	
</div>
</c:otherwise>
</c:choose>