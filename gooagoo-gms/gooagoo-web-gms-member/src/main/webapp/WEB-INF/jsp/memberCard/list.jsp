<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<ul>
	<c:forEach var="temp" items="${list}">
		<li>
			<u><img src="${temp.cardUrl}" width="188" height="117" /></u>
		  	<div class="controlTxt">
				<span style="width: 85px;">${temp.cardName}</span>
		    	<check:hasAuthority authorityID="24010202">
		    		<a href="javascript:void(0);" class="handle del btnFloat" onclick="del('${temp.cardId}')" title="${shopVo.wordNames['gmsc014']}" ></a>
    			</check:hasAuthority>
		    	<check:hasAuthority authorityID="24010203">
		    		<a href="javascript:void(0);" class="handle detailMark btnFloat" onclick="detail('${temp.cardId}','${temp.cardLvl}');" title="${shopVo.wordNames['gmsc015']}" style="margin-top: 5px;"></a>
	    		</check:hasAuthority>
				<c:if test="${temp.publishStatus=='A' }">
			    	<check:hasAuthority authorityID="24010202">
			    		<a href="javascript:void(0);" class="handle issue btnFloat" onclick="publish('${temp.cardId}');" title="${shopVo.wordNames['gmsc017']}" ></a>
		    		</check:hasAuthority>
	    		</c:if>
				<c:if test="${temp.publishStatus=='W' }">
			    	<check:hasAuthority authorityID="24010202">
			    		<a href="javascript:void(0);" class="handle book btnFloat" onclick="checkForm('${temp.cardId}');" title="${shopVo.wordNames['gmsc016']}" ></a>
		    		</check:hasAuthority>
				</c:if>
				<c:if test="${temp.publishStatus=='W' || temp.publishStatus=='B'}">
			    	<check:hasAuthority authorityID="24010201">
			    		<a href="javascript:void(0);" class="handle pencil btnFloat" onclick="edit('${temp.cardId}','${temp.cardLvl}');" title="${shopVo.wordNames['gmsc013']}" ></a>
		    		</check:hasAuthority>
		    	</c:if>
			</div>
		</li>
	</c:forEach>
</ul>
<div style="display:none;">
	<a href="#" id="detail" class="fancybox_detail"></a>
	<a href="#" id="check" class="fancybox_check"></a>
</div>
<script type="text/javascript">
	initFancyBox("fancybox_detail", 800, 460, true);
	initFancyBox("fancybox_check", 324, 200, true);
	
	//删除会员卡
	function del(id) {
		$.ajax({
			url : "memberCard.do?method=cardHasGive",
			cache : false,
			type : "POST",
			dataType : "json",
			data : "cardId=" + id,
			success : function(msg) {
				if (!msg.success) {
					alert("会员卡已发放，禁止删除");
					return false;
				}else{
					if (confirm("确定要删除？")){
						var url = basePath + "memberCard.do?method=delete";
						var data =  "cardId=" + id;
						ajaxJsonTipByData(url,data,true);
					}
				}
				window.location.href = basePath + "memberCard.do?method=index";
			}
		});
	}
	//编辑会员卡
	function edit(id, cardType) {
 		window.location.href = basePath + "memberCard.do?method=create&cardId="+id+"&cardType2="+cardType;
	}
	//查看会员卡详细信息
	function detail(cardId, cardType){
		if(isEmpty(cardId)){
			cardId = "";
		}
		var url = basePath + "memberCard.do?method=getMemberCard&cardId="+cardId;
		$("#detail").attr("href",url).click();
	}
	//审核会员卡页面
	function checkForm(cardId){
		if(isEmpty(cardId)){
			cardId = "";
		}
		var url = basePath + "memberCard.do?method=checkForm&cardId="+cardId;
		$("#check").attr("href",url).click();
	}
	//发布会员卡信息
	function publish(cardId){
		if(confirm("确定发布会员卡信息？")){
			var url = basePath + "memberCard.do?method=publish";
			var data = "&cardId=" + cardId;
			ajaxJsonTipByData(url,data,true);
			window.location.href = basePath + "memberCard.do?method=index";
		}
	}
</script>