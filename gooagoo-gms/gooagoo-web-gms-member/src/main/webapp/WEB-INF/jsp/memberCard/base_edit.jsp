<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/gms/member/js/card/createBaseCard.js" charset="UTF-8"></script>
<form:form id="cardCreateForm" method="post" modelAttribute="memberCard">
	<div class="memberBuild">
		<div class="uploadImg" onclick="uploadPic('${memberCard.cardUrl}');">
			<div class="up">
				<c:if test="${empty memberCard.cardUrl}">
					<img src="${imgPath}/gms/common/images/dh_top.jpg"/>
				</c:if>
				<c:if test="${not empty memberCard.cardUrl}">
					<img src="${memberCard.cardHeadUrl}"/>
				</c:if>
			</div>
			<div class="dowm">
				<c:if test="${empty memberCard.cardUrl}">
					<img src="${imgPath}/gms/common/images/dh_bottom.jpg"/>
				</c:if>
				<c:if test="${not empty memberCard.cardUrl}">
					<img src="${memberCard.cardBodyUrl}"/>
				</c:if>
			</div>
			<input type="hidden" name="cardUrl" value="${memberCard.cardUrl}"/>
		</div>
		<div class="uploadBtn">							
			<a href="javascript:void(0);" onclick="uploadPic('${memberCard.cardUrl}');" class="uploadCommit blueBtn">${shopVo.wordNames['cpme030']}</a>
		</div>
		<ul>
		  	<li>
			  	<span>${shopVo.wordNames['cpme024']}</span>
			  	<input type="text" name="cardName" value="${memberCard.cardName}" maxlength="32" class="inputStyle" />
				<input type="hidden" name="cardId" value="${memberCard.cardId}" />
		    </li>
		   	<li>
				<span>${shopVo.wordNames['cpme025']}</span>
	        	<select name="existPhy" class="inputSelect">
	           		<option value="">--${shopVo.wordNames['gmsb018']}--</option>
					<option value="Y" <c:if test="${memberCard.cardType2=='2'}">selected="selected"</c:if>>是</option>
					<option value="N" <c:if test="${memberCard.cardType2=='1'}">selected="selected"</c:if>>否</option>
	          	</select>
			</li>
		    <li>
		     	<span>${shopVo.wordNames['cpme026']}</span>
		      	<select name="needApproval" class="inputSelect">
		      		<option value="">--${shopVo.wordNames['gmsb018']}--</option>
					<option value="Y" <c:if test="${memberCard.needApproval=='Y'}">selected="selected"</c:if>>是</option>
					<option value="N" <c:if test="${memberCard.needApproval=='N'}">selected="selected"</c:if>>否</option>
	  			</select>
			</li>
			<li>
		 		<span>${shopVo.wordNames['cpme027']}</span>
			 	<input type="text" name="useLimited"  value="${memberCard.useLimited}" class="inputSmall" />
			  	<select name="useLimitedUnit" class="inputSelectSmaill">
				  	<option value="Y">年</option>
				  	<option value="M">月</option>
				  	<option value="D" selected="selected">日</option>
			  	</select>
			</li>
			<li>
				<span>${shopVo.wordNames['cpme029']}</span>
				<textarea name="description" class="TextareaStyle" maxlength="200" style="resize: none; overflow-y:auto">${memberCard.description}</textarea>
		    </li>
		</ul>
		<div class="conserve">
			<input type="hidden" name="cardLvl" value="1"/>
	 		<input type="submit" class="commitBtn blueBtn" value="${shopVo.wordNames['cpme031']}" style="border:0 none;cursor: pointer;">
		</div>
	</div>
</form:form>
