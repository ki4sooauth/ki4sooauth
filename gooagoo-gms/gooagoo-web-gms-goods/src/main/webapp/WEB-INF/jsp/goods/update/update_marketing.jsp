<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<div class="title">${shopVo.wordNames['gmse056']}</div>
<div class="productBuild marketingMsg">
	<form method="post" id="goods_marketing">
		<ul>
			<li>
				<input type="hidden" value="${shopEntityId }"   name="shopEntityId" id="entityId">  
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse058']}</span><input name="vendor" value="${marketing.vendor }" class="borderStyle text" type="text" /></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse059']}</span>
			<input class="borderStyle text" id="position" value="${marketing.positionName }" type="text" onclick="relateOne('I') ;" readonly class="in1" name="positionName"/>
				<input type="hidden" name="positionId" id="positionId" />
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse060']}</span><select class="borderStyle text"  name="lifeIdea">
			<option <c:if test="${marketing.lifeIdea=='1'}">selected</c:if> value="1">${shopVo.wordNames['gmse061']}</option>
			<option <c:if test="${marketing.lifeIdea=='2'}">selected</c:if>  value="2">${shopVo.wordNames['gmse062']}</option>
			<option <c:if test="${marketing.lifeIdea=='3'}">selected</c:if>  value="3">${shopVo.wordNames['gmse063']}</option>
			<option <c:if test="${marketing.lifeIdea=='4'}">selected</c:if>  value="4">${shopVo.wordNames['gmse064']}</option></select></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse065']}</span>
			<select class="borderStyle text"  name="useType">
			<option <c:if test="${marketing.useType=='1'}">selected</c:if>  value="1">${shopVo.wordNames['gmse066']}</option>
			<option <c:if test="${marketing.useType=='2'}">selected</c:if>   value="2">${shopVo.wordNames['gmse067']}</option>
			</select></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse068']}</span>
<!--            	编辑器 -->
			 <textarea name="goodsContent" class="textWeb">${marketing.goodsContent }</textarea></li>
		
			<li><span class="tit_1">${shopVo.wordNames['gmse069']}</span> 
			
			<textarea name="goodsSolution" class="textWeb" style="width:100px ">${marketing.goodsSolution }</textarea></li>
			
			<li class="commitImg">
			
			<span class="tit_1">${shopVo.wordNames['gmse070']}</span>
				<div class="borderStyle areaImg" id="crossGoods">
					<input type="hidden" value="${marketing.crossGoods }" id="crossGoodsId" />
				</div></li>
			<li><a href="javascript:void(0)" class="addImgbtn blueBtn" id="crossGoods_btn">${shopVo.wordNames['gmse036']}</a></li>
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse071']}</span>
			  <input type="hidden" value="${marketing.relationGoods }" id="relationGoodsId"/>
			  
			    <div class="borderStyle areaImg"  id="relationGoods">
                  </div></li>
			<li><a href="javascript:void(0)" class="addImgbtn blueBtn" id="relationGoodsre_btn">${shopVo.wordNames['gmse036']}</a></li>
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse072']}</span>
			  <input type="hidden" value="${marketing.replaceGoods }" id="replaceGoodsId"/>
			  
			    <div class="borderStyle areaImg"  id="replaceGoods">
                  </div></li>
			<li><a href="javascript:void(0)" class="addImgbtn blueBtn" id="replaceGoods_btn">${shopVo.wordNames['gmse036']}</a></li>
			
			<li><span class="tit_1">${shopVo.wordNames['gmse048']}</span> <textarea class="borderStyle area"
					name="feature">${marketing.feature }</textarea></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse049']}</span> <textarea class="borderStyle area"
					name="address">${marketing.address }</textarea></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse050']}</span> <textarea class="borderStyle area"
					name="crowd">${marketing.crowd }</textarea></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse051']}</span> <textarea class="borderStyle area"
					name="useMessage">${marketing.useMessage }</textarea></li>
					
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse052']}</span>
				<div class="borderStyle areaImgSmall">
					<img src="${imgPath }/gms/goods/images/default_goods.png" width="140"
						height="140" id="pic_main"/>
				</div></li>
				
			<li>
			<a href="#" class="commitImgbtn blueBtn" onclick="uploadPic('pic_main');">${shopVo.wordNames['gmse053']}</a>
			</li>
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse054']}</span>
				<div class="borderStyle areaImg" id="pic_sub">
					
				</div>
			</li>
			<li><a href="#" class="addImgbtn blueBtn"  onclick="uploadPic('pic_sub');">${shopVo.wordNames['gmse036']}</a></li>
			
		</ul>
		
		
		<input id="marketing_save" type="submit" value="${shopVo.wordNames['gmse055']}" class="savebtnS blueBtn"/>
	</form>
</div>

<div  style="display: none;">
	<a href="${basePath}/relation.do?method=listRelation&relateType=G&selectType=S&dataType=MS" id="relate_list" class="fancybox_relate"></a>
	<input type="hidden" id="cid"/>
</div>

<div id="position_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="position_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>