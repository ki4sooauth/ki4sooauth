<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发卡规则详细</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp" %>
<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${imgPath}/gms/active/js/ruleCondition.js" charset="UTF-8"></script>
<link href="${imgPath}/gms/member/css/member.css" rel="stylesheet" type="text/css" />
<style>
	font{line-height: 20px;};
</style>
<script type="text/javaScript">
	var imgPath = "${imgPath}";
	var basePath = "${basePath}";
	var cbody = true;
</script>
</head>
<body>
	<c:set var="info" value="${rule.ruleInfo}"></c:set>
	<c:set var="result" value="${rule.ruleResult}"></c:set>
	<c:set var="natural" value="${condition.historyCondition.naturalAttribute}"></c:set>
	<c:set var="hist" value="${condition.historyCondition.list}"></c:set>
	<c:set var="curr" value="${condition.actionAttribute}"></c:set>
	<c:if test="${not empty natural.accountType || not empty natural.account || not empty natural.sex || not empty natural.birthdayStart || not empty natural.birthdayEnd || not empty natural.ageStart || not empty natural.ageEnd || not empty natural.gradeName}">
		<c:set var="ziran" value="have"></c:set>
	</c:if>
	<!--内容-->
    <div class="container">
      	<div class="article" style="width: 860px;">
      		<div class="memberPoup">
				<div class="rightTitle"><span>${shopVo.wordNames['cpmd009']}</span></div>
				<div class="conditions_content">
				 	<div class="title">${shopVo.wordNames['cpmd010']}</div>
				  	<div class="behavior_quality noborder">
				    	<dl>
				        	<dd><span>${shopVo.wordNames['gmsc052']}</span><ul><li><font>${info.ruleName}</font></li></ul></dd>
				        	<c:if test="${result.ruleResultType=='1'}">
					        	<dd id="r1"><span>${shopVo.wordNames['gmsc065']}</span><font>${result.ruleResultName}</font></dd>
					        </c:if>
					        <c:if test="${not empty result.ruleDesc}">
					        	<dd><span>规则描述：</span><font>${result.ruleDesc }</font></dd>
					        </c:if>	
				     	</dl>
					</div>
				</div>
				<div class="rightTitle">
				 	<span>${shopVo.wordNames['gmsc076']}</span>
				</div>
				<div class="conditions_content">
					<div class="title">${shopVo.wordNames['gmsc078']}</div>
					<div class="natural_quality">
						<c:if test="${not empty condition.historyCondition.crowdId}">
							<p><span><font>${shopVo.wordNames['gmsc082']}</font></span><font>${condition.historyCondition.crowdName}</font></p>
						</c:if>
					</div>
					<div class="title">${shopVo.wordNames['gmsc079']}</div>
						<div class="natural_quality" style="height: auto;">
							<c:if test="${not empty ziran}">
								<ul style="width: 750px; height: 20px;">
									<c:if test="${not empty natural.accountType}">
										<li style="width: 200px;">
											<span>${shopVo.wordNames['gmsc083']}</span>
							               	<c:forEach items="${user_type}" var = "type">
									           	<c:if test="${natural.accountType==type.key}"><font>${type.value}</font></c:if>
							               	</c:forEach>
							           	</li>
									</c:if>
									<c:if test="${not empty natural.account}">
					         	 		<li style="width: 200px;"><span class="num">${shopVo.wordNames['gmsc084']}</span>&nbsp;<font>${natural.account}</font></li>
					         	 	</c:if>
					         	 	<c:if test="${not empty natural.sex}">
										<li style="width: 200px;"><span>${shopVo.wordNames['gmsc085']}</span>
											<c:forEach items="${sex}" var = "type">
									           	<c:if test="${natural.sex==type.key}"><font>${type.value}</font></c:if>
							               	</c:forEach>
										</li>
									</c:if>
									<c:if test="${not empty natural.birthdayStart}">
						         		<li style="width: 200px;"><span>${shopVo.wordNames['gmsc086']}</span><font>${natural.birthdayStart}&nbsp;${shopVo.wordNames['gmsc070']}&nbsp;${natural.birthdayEnd}</font></li>
						         	</c:if>
									<c:if test="${not empty natural.ageStart}">
						         		<li style="width: 200px;"><span>${shopVo.wordNames['gmsc087']}</span><font>${natural.ageStart}${shopVo.wordNames['gmsc088']}&nbsp;${shopVo.wordNames['gmsc070']}&nbsp;${natural.ageEnd}${shopVo.wordNames['gmsc088']}</font></li>
						         	</c:if>
		         				</ul>
		         				<!-- 获取会员特征 -->
						   		<div style="height: ${fn:length(natural.memberFeatureList)*25}">
						   			<c:if test="${not empty natural.memberFeatureList}">
										<c:forEach var="feature" items="${fmemberFeatures}" varStatus="i" >
											<c:forEach var="nfeature" items="${natural.memberFeatureList}" varStatus="i" >
												<c:if test="${nfeature.typeCode eq feature.typeCode}">
													<ul style="height: 20px; width:60px;float:left;">
											       	 	<span>${feature.typeName}</span>
											       	</ul>
											       	<ul style="height: 25px;width:160px;float:left;">
											       		<li><font>${nfeature.enumValue}</font></li>
											       	</ul>
												</c:if>
											</c:forEach>
										</c:forEach>
									</c:if>
						       	</div>
								<div style="height: 100px;">
									<ul style="height: 20px; width:60px;">
										<c:if test="${not empty natural.gradeName}">
							       	 		<span>${shopVo.wordNames['gmsc089']}</span>
							           	</c:if>
							       	</ul>
							       	<ul style="height: 50px;width:650;float:left;">
							       		<c:if test="${not empty natural.gradeName}">
								           	<c:forEach var="name" items="${fn:split(natural.gradeName, ',')}" varStatus="i" >
								           		<li><font>${name}</font></li>
								           	</c:forEach>
							           	</c:if>
							       	</ul>
						       	</div>
							</c:if>
						</div>
						<div class="title relative">
					   		<div class="position_add" id="position_add"></div>${shopVo.wordNames['gmsc080']}
						</div>
						<div class="behavior_quality" id="historyAction">
							<c:if test="${not empty hist}">
								<c:forEach var="hist" items="${condition.historyCondition.list}" > 
									<c:if test="${not empty hist}">
										<dl class="action_${hist.actionType}">
									        <dt><b class="showBtn curr"><i></i></b>
									        	<font class="history_action_name">
									        		<c:forEach items="${behave_type}" var = "type">
											           	<c:if test="${hist.actionType==type.key}"><font>${type.value}</font></c:if>
									               	</c:forEach>
					        					</font>
									        </dt>
									        <c:if test="${not empty hist.dateStart}">
										        <dd id="isShowDateScope">
										        	<span>${shopVo.wordNames['gmsc090']}</span>
										        	<ul><li><font>${hist.dateStart}&nbsp;${shopVo.wordNames['gmsc070']}&nbsp;${hist.dateEnd}</font></li></ul>
										        </dd>
									        </c:if>
								        <c:if test="${not empty hist.vipGrade}">
										<dd id="isShowVipGrade">
											<div class="bottom_box">
									            <span>${shopVo.wordNames['gmsc089']}</span>
									           	<ul class="tag">
									           		<c:set var="vipGradeIds" value="${fn:split(hist.vipGrade, ',')}"></c:set>
										           	<c:forEach var="name" items="${fn:split(hist.vipGradeName, ',')}" varStatus="i" >
								 		    			<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
										</c:if>
								        <c:if test="${not empty hist.actionSource}">
								        	<dd id="isShowActionSource"><span>${shopVo.wordNames['gmsc093']}</span>
												<c:forEach items="${info_source}" var = "type">
										           	<c:if test="${hist.actionSource==type.key}"><font>${type.value}</font></c:if>
								               	</c:forEach>
											</dd>
								        </c:if>
								        <c:if test="${not empty hist.timeMin || not empty hist.totalTimeMin}">
								        	<dd><span>${shopVo.wordNames['gmsc126']}</span></dd>
								        	<c:if test="${not empty hist.timeMin}">
								        		<font>${shopVo.wordNames['gmsc094']}：</font>
									        	<font>${hist.timeMin}<samp>-</samp>${hist.timeMax}<samp>${shopVo.wordNames['gmsc069']}</samp></font>
								        	</c:if>
								        	<c:if test="${not empty hist.totalTimeMin}">
								        		<font>${shopVo.wordNames['gmsc095']}</font>
								        		<font>${hist.totalTimeMin}<samp>-</samp>${hist.totalTimeMax}<samp>${shopVo.wordNames['gmsc069']}</samp></font>
								        	</c:if>
								      	</c:if>
								        <c:if test="${not empty hist.marketingGoodsCategoryName || not empty hist.marketingGoodsBrandName || not empty hist.marketingGoodsName}">
									       	<dd id="isShowRelation"><span>${shopVo.wordNames['gmsc096']}</span>
									       		<c:forEach items="${relation_type}" var = "type">
										           	<c:if test="${hist.relation==type.key}"><font>${type.value}</font></c:if>
								               	</c:forEach>
									    		<font color="gray" style="float: right;">${shopVo.wordNames['gmsc097']}</font>
									       	</dd>
								       	</c:if>
									    <c:if test="${not empty hist.marketingGoodsCategoryName}">
											<dd id="isShowMarketingGoodsCategory">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc098']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.marketingGoodsCategoryName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
								    	</c:if> 
						           		<c:if test="${not empty hist.marketingGoodsBrandName}">
											<dd id="isShowMarketingGoodsBrand">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc099']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.marketingGoodsBrandName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
								    	</c:if> 
						           		<c:if test="${not empty hist.marketingGoodsName}">
											<dd id="isShowMarketingGoods">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc100']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.marketingGoodsName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
							           	</c:if>
						           		<c:if test="${not empty hist.marketingActivityName}">
											<dd id="isShowMarketingAction">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc101']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.marketingActivityName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
							           	</c:if>
				           				<c:if test="${not empty hist.marketingCouponName}">
											<dd id="isShowMarketingCoupon">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc102']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.marketingCouponName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
					           			</c:if>
						           		<c:if test="${not empty hist.marketingEventName}">
											<dd id="isShowMarketingEvent">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc103']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.marketingEventName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
							           	</c:if>
						           		<c:if test="${not empty hist.serverToolsName}">
											<dd id="isShowServerTools">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc104']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.serverToolsName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
							           	</c:if>
			           					<c:if test="${not empty hist.positionName}">
											<dd id="isShowPosition">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc105']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.positionName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>
							           	</c:if>
						           		<c:if test="${not empty hist.durationMin}">
											<dd id="isShowDuration"><span>${shopVo.wordNames['gmsc116']}</span>
												${hist.durationMin}<samp>-</samp>${hist.durationMax}<samp>${shopVo.wordNames['gmsc117']}</samp>
										    </dd>
										</c:if>
						           		<c:if test="${not empty hist.consumeMoneyMin}">
											<dd id="isShowConsumeMoney"><span>${shopVo.wordNames['gmsc106']}</span>
												<ul><li><font>${shopVo.wordNames['gmsc071']}&nbsp;${hist.consumeMoneyMin}&nbsp;&nbsp;${shopVo.wordNames['gmsc072']}&nbsp;${hist.consumeMoneyMax}&nbsp;${shopVo.wordNames['gmsc067']}</font></li></ul>
										    </dd>
									    </c:if>
						           		<c:if test="${not empty hist.cmsContent}">
											<dd id="isShowVb">
												<div class="bottom_box"><span>${shopVo.wordNames['gmsc107']}</span>
										           	<ul class="tag">
											           	<c:forEach var="name" items="${fn:split(hist.cmsContentName, ',')}" varStatus="i" >
												 		    <li><font>${name}</font></li>
											           	</c:forEach>
										           	</ul>
												</div>
											</dd>										        
										</c:if>
									</dl>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
				</div>
				<div class="rightTitle">
					<span>${shopVo.wordNames['gmsc077']}</span>
				</div>
				<div class="conditions_content">
					<div class="title">${shopVo.wordNames['gmsc081']}</div>
				   	<div class="behavior_quality currentAction" id="currentAction">
						<c:if test="${not empty curr}">
							<c:set var="curr" value="${condition.actionAttribute}"></c:set>
							<c:if test="${not empty curr}">
								<dl class="current_action" id="${curr.actionType}">
							        <dt>
							        	<font class="history_action_name">
								        	<c:forEach items="${behave_type}" var = "type">
									           	<c:if test="${curr.actionType==type.key}"><font>${type.value}</font></c:if>
							               	</c:forEach>
							        	</font>
							        </dt>
							        <c:if test="${not empty curr.dateStart}">
								        <dd id="isShowDateScope"><span>${shopVo.wordNames['gmsc090']}</span>
								        	<ul><li><font>${curr.dateStart}&nbsp;${shopVo.wordNames['gmsc070']}&nbsp;${curr.dateEnd}</font></li></ul>
								        </dd>
							        </c:if>
							        <c:if test="${not empty curr.weekScope}">
							       		<dd id="isShowWeekScope"><span><font>${shopVo.wordNames['gmsc091']}</font></span>
								       		<c:forEach items="${week_type}" var = "type">
							    				<c:if test="${fn:contains(curr.weekScope, type.key)}"><samp><font>${type.value}</font></samp>&nbsp;</c:if>
								            </c:forEach>
								    	</dd>
							    	</c:if>
							        <c:if test="${not empty curr.timeStart}">
								        <dd id="isShowTimeScope"><span>${shopVo.wordNames['gmsc092']}</span>
								        	<ul><li><font>${curr.timeStart}&nbsp;${shopVo.wordNames['gmsc070']}&nbsp;${curr.timeEnd}</font></li></ul>
								        </dd>
								    </c:if>
							        <c:if test="${not empty curr.vipGradeName}">
								        <dd id="isShowVipGrade">
											<div class="bottom_box">
									            <span>${shopVo.wordNames['gmsc089']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.vipGradeName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
									</c:if>
							        <c:if test="${not empty curr.actionSource}">
							        	<dd id="isShowActionSource"><span>${shopVo.wordNames['gmsc093']}</span>
											<c:forEach items="${info_source}" var = "type">
									           	<c:if test="${curr.actionSource==type.key}"><font>${type.value}</font></c:if>
							               	</c:forEach>
										</dd>
							        </c:if>
							        <c:if test="${not empty curr.timeMin || not empty curr.totalTimeMin}">
							        	<dd><span>次数</span></dd>
							        	<c:if test="${not empty curr.timeMin}">
							        		<font>${shopVo.wordNames['gmsc094']}：</font>
								        	<font>${hist.timeMin}<samp>-</samp>${curr.timeMax}<samp>${shopVo.wordNames['gmsc069']}</samp></font>
							        	</c:if>
							        	<c:if test="${not empty curr.totalTimeMin}">
							        		<font>${shopVo.wordNames['gmsc095']}</font>
							        		<font>${curr.totalTimeMin}<samp>-</samp>${curr.totalTimeMax}<samp>${shopVo.wordNames['gmsc069']}</samp></font>
							        	</c:if>
							      	</c:if>
							        <c:if test="${not empty curr.marketingGoodsCategoryName || not empty curr.marketingGoodsBrandName || not empty curr.marketingGoodsName}">
								       	<dd id="isShowRelation"><span>${shopVo.wordNames['gmsc096']}</span>
								       		<c:forEach items="${relation_type}" var = "type">
									           	<c:if test="${curr.relation==type.key}"><font>${type.value}</font></c:if>
							               	</c:forEach>
								    		<font color="gray" style="float: right;">${shopVo.wordNames['gmsc097']}</font>
								       	</dd>
							       	</c:if>
					           		<c:if test="${not empty curr.marketingGoodsCategoryName}">
										<dd id="isShowMarketingGoodsCategory">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc098']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.marketingGoodsCategoryName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
									</c:if>
					           		<c:if test="${not empty curr.marketingGoodsBrandName}">
										<dd id="isShowMarketingGoodsBrand">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc099']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.marketingGoodsBrandName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					          		<c:if test="${not empty curr.marketingGoodsName}">
										<dd id="isShowMarketingGoods">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc100']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.marketingGoodsName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					          		<c:if test="${not empty curr.marketingActivityName}">
										<dd id="isShowMarketingAction">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc101']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.marketingActivityName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					           		<c:if test="${not empty curr.marketingCouponName}">
										<dd id="isShowMarketingCoupon">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc102']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.marketingCouponName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					           		<c:if test="${not empty curr.marketingEventName}">
										<dd id="isShowMarketingEvent">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc103']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.marketingEventName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					           		<c:if test="${not empty curr.serverToolsName}">
										<dd id="isShowServerTools">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc104']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.serverToolsName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					          		<c:if test="${not empty curr.positionName}">
										<dd id="isShowPosition">
											<div class="bottom_box"><span>${shopVo.wordNames['gmsc105']}</span>
									           	<ul class="tag">
										           	<c:forEach var="name" items="${fn:split(curr.positionName, ',')}" varStatus="i" >
												 		<li><font>${name}</font></li>
										           	</c:forEach>
									           	</ul>
											</div>
										</dd>
						           	</c:if>
					           		<c:if test="${not empty curr.durationMin}">
										<dd id="isShowDuration"><span>${shopVo.wordNames['gmsc116']}</span>
											${curr.durationMin}<samp>-</samp>${curr.durationMax}<samp>${shopVo.wordNames['gmsc117']}</samp>
									    </dd>
									</c:if>
					          		<c:if test="${not empty curr.consumeMoneyMin}">
										<dd id="isShowConsumeMoney"><span>${shopVo.wordNames['gmsc106']}</span>
											<ul><li><font>${shopVo.wordNames['gmsc071']}&nbsp;${curr.consumeMoneyMin}&nbsp;${shopVo.wordNames['gmsc072']}&nbsp;${curr.consumeMoneyMax}${shopVo.wordNames['gmsc067']}</font></li></ul>
									    </dd>
								    </c:if>
					          		<c:if test="${not empty curr.cmsContent}">
								        <<dd id="isShowVb">
										<div class="bottom_box"><span>${shopVo.wordNames['gmsc107']}</span>
								           	<ul class="tag">
									           	<c:forEach var="name" items="${fn:split(curr.cmsContentName, ',')}" varStatus="i" >
										 		    <li><font>${name}</font></li>
									           	</c:forEach>
								           	</ul>
										</div>
									</dd>
							        </c:if>
								</dl>
							</c:if>
						</c:if>
			   		</div>
				</div>
				<div class="rightTitle"><span>${shopVo.wordNames['gmsc108']}</span></div>
				<div class="conditions_content">
					<div class="title">${shopVo.wordNames['gmsc109']}</div>
				  	<div class="plan_box">
				      	<p class="top_p">
							<fmt:formatDate var="expectPublishTime" value="${info.expectPublishTime}" pattern="yyyy-MM-dd"/>
				      		<span><font style="color: #5B5F60;font-weight: bold;">${shopVo.wordNames['gmsc110']}：</font></span>
				      		<c:if test="${info.isPublishImmediately=='Y'}"><font>${shopVo.wordNames['gmsc111']}</font></c:if>
				      		<c:if test="${info.isPublishImmediately=='N'}"><font>${shopVo.wordNames['gmsc112']}　${expectPublishTime}</font></c:if>
				     	</p>
				     	<p>
				      		<span><font style="color: #5B5F60;font-weight: bold;">${shopVo.wordNames['gmsc119']}：</font></span>
				      		<font>
				      			<c:forEach items="${rule_active_type}" var = "type">
				      				<c:if test="${type.key == info.ruleActiveType }">${type.value}</c:if>
								</c:forEach>
							</font>
				     	</p>
				        <p>
			   				<fmt:formatDate var="startTime" value="${info.startTime}" pattern="yyyy-MM-dd"/>
			   				<fmt:formatDate var="endTime" value="${info.endTime}" pattern="yyyy-MM-dd"/>
					        <span><font style="color: #5B5F60;font-weight: bold;">${shopVo.wordNames['gmsc113']}：</font></span><font><span>${startTime}&nbsp;&nbsp;&nbsp;</span></font>
					        <span><font style="color: #5B5F60;font-weight: bold;">${shopVo.wordNames['gmsc114']}：</font></span><font><span>${endTime}</span></font>
					    </p>
			     	</div>
				</div>
				<a href="javascript:void(0)" class="blueBtn savebtn" onclick="parent.$.fancybox.close();" style="margin-bottom: 0px;">${shopVo.wordNames['gmsc003']}</a>
        	</div>
       	</div>
	</div>
</body>
</html>
