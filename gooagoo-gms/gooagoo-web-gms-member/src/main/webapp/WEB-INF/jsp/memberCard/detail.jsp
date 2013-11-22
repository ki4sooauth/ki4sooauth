<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>

<div style="padding: 10px; width: 97%;">
	<div class="rightTitle_add">
		<span>${shopVo.wordNames['cpme108']}</span>
	</div>
	<div class="memberBuild" style="padding: 8px; width: 97%; height:330px; float: left;">
		<div style="float: left; width: 46%">
			<div style="height: 30px; color: gray;padding-top: 15px;"><strong>${shopVo.wordNames['cpme109']}</strong></div>
			<u><img src="${memberCard.cardUrl}" width="297" height="187" /></u>
		</div>
		<div style="float: left; width: 53%">
			<ul style="padding: 15px 0px 0px 0px;">
			  	<li style="padding-bottom: 10px;"><span>${shopVo.wordNames['gmsb135']}</span>
					${memberCard.cardName}
			    </li>
			    <c:if test="${memberCard.cardLvl=='1' || memberCard.cardLvl=='2'}">
				  	<li style="padding-bottom: 10px;"><span>${shopVo.wordNames['cpme018']}</span>
						<c:if test="${memberCard.cardType2=='2'}">是</c:if>
						<c:if test="${memberCard.cardType2=='1'}">否</c:if>
				    </li>
				  	<li style="padding-bottom: 10px;"><span>${shopVo.wordNames['cpme019']}</span>
						<c:if test="${memberCard.needApproval=='Y'}">是</c:if>
						<c:if test="${memberCard.needApproval=='N'}">否</c:if>
				    </li>
				  	<li style="padding-bottom: 10px;"><span>${shopVo.wordNames['cpme020']}</span>
					  	${memberCard.useLimited}&nbsp;日
				    </li>
				    <c:if test="${memberCard.cardLvl=='2'}">
					  	<li style="padding-bottom: 10px;"><span>${shopVo.wordNames['cpme028']}</span>
						  	${memberCard.needJifen}&nbsp;${shopVo.wordNames['cpmf129']}
					    </li>
					</c:if>
			    </c:if>
			  	<li style="padding-bottom: 10px;"><span>${shopVo.wordNames['cpme014']}</span>
					<div style="padding-left: 95px;">
						<textarea style="width:260px;height:75px; border:0 none;background:white; resize: none; overflow-y:auto" readonly="readonly">${memberCard.description}</textarea>
					</div>
			    </li>
			    <li style="padding-bottom: 10px;"><span>会员卡状态</span>
	    			<c:forEach items="${publish_status}" var="type">
			       		<c:if test="${memberCard.publishStatus==type.key}">${type.value }</c:if>
			       	</c:forEach>
			    </li>
			  	<li style="padding-bottom: 10px;"><span>审核描述：</span>
					<div style="padding-left: 95px;">
						<textarea style="width:260px;height:55px; border:0 none;background:white; resize: none; overflow-y:auto" readonly="readonly">${memberCard.auditNote}</textarea>
					</div>
			    </li>
		    </ul>
		</div>
	</div>
</div>
<div class="conserve" style="text-align: center;padding-top:350px; ">
 	<input type="submit" class="commitBtn blueBtn" value="${shopVo.wordNames['gmsb194']}" onclick="javascript:parent.$.fancybox.close();" style="border:0 none;cursor: pointer; width:150px; height: 35px;">
</div>
