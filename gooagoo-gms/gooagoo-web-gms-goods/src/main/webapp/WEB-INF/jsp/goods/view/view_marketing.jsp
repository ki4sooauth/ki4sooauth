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
			<li><span class="tit_1">${shopVo.wordNames['gmse058']}</span>${marketing.vendor }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse059']}</span>
			${marketing.positionName }
				<input type="hidden" name="positionId" id="positionId" />
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse060']}</span>
			${marketing.lifeIdea }
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse065']}</span>
			${marketing.useType }
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse068']}</span> ${marketing.goodsContent }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse069']}</span> ${marketing.goodsSolution }</li>
			<li class="commitImg">
			
			<span class="tit_1">${shopVo.wordNames['gmse070']}</span>
				<div class="borderStyle areaImg" id="crossGoods">
					<input type="hidden" value="${marketing.crossGoods }" id="crossGoodsId" />
				</div></li>
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse071']}</span>
			  <input type="hidden" value="${marketing.relationGoods }" id="relationGoodsId"/>
			  
			    <div class="borderStyle areaImg"  id="relationGoods">
                  </div></li>
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse072']}</span>
			  <input type="hidden" value="${marketing.replaceGoods }" id="replaceGoodsId"/>
			  
			    <div class="borderStyle areaImg"  id="replaceGoods">
                  </div></li>
			
			<li><span class="tit_1">${shopVo.wordNames['gmse048']}</span> ${marketing.feature }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse049']}</span> ${marketing.address }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse050']}</span> ${marketing.crowd }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse051']}</span> ${marketing.useMessage }</li>
					
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse052']}</span>
				<div class="borderStyle areaImgSmall">
					<img src="${imgPath }/gms/goods/images/default_goods.png" width="140"
						height="140" id="pic_main"/>
				</div>
				</li>
			<li class="commitImg"><span class="tit_1">${shopVo.wordNames['gmse054']}</span>
				<div class="borderStyle areaImg" id="pic_sub">
					
				</div>
			</li>
		</ul>
	</form>
</div>

<div  style="display: none;">
	<a href="${basePath}/relation.do?method=listRelation&relateType=G&selectType=S&dataType=MS" id="relate_list" class="fancybox_relate"></a>
	<input type="hidden" id="cid"/>
</div>

<div id="position_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="position_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>