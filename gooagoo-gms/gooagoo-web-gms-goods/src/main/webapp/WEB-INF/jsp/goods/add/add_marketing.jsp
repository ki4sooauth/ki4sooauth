<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<div class="title">${shopVo.wordNames['gmse056']}</div>
<div class="productBuild marketingMsg">
	<form method="post" id="goods_marketing">
		<ul>
			<li><span  class="tit_1">${shopVo.wordNames['gmse057']}</span>
				<input  class="borderStyle text"  type="text" value="${shopEntityId }"  style="background:#CECECE;" readonly  name="shopEntityId" id="shopEntityId">  
			</li>
			<li><span  class="tit_1">${shopVo.wordNames['gmse058']}</span><input name="vendor"  style="background:#CECECE;" readonly class="borderStyle text" type="text" /></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse059']}</span>
			<input class="borderStyle text" id="position" style="background:#CECECE;"  type="text"  readonly name="positionName"/>
				<input type="hidden" name="positionId" id="positionId" />
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse060']}</span><select class="borderStyle text"  name="lifeIdea">
			<option value="1">${shopVo.wordNames['gmse061']}</option>
			<option value="2">${shopVo.wordNames['gmse062']}</option>
			<option value="3">${shopVo.wordNames['gmse063']}</option>
			<option value="4">${shopVo.wordNames['gmse064']}</option></select></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse065']}</span>
			<select class="borderStyle text"  name="useType">
			<option value="1">${shopVo.wordNames['gmse066']}</option>
			<option value="2">${shopVo.wordNames['gmse067']}</option></select></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse068']}</span>
<!--            	编辑器 -->
			 <textarea name="goodsContent" class="textWeb">${marketing.goodsContent }</textarea></li>
		
			<li><span class="tit_1">${shopVo.wordNames['gmse069']}</span> 
			
			<textarea name="goodsSolution" class="textWeb" style="width:100px ">${marketing.goodsSolution }</textarea></li>
			<li class="commitImg">
			<span class="tit_1">${shopVo.wordNames['gmse070']}</span>
				<div class="borderStyle areaImg" id="crossGoods">
					<input type="hidden"  id="crossGoodsId" />
				</div></li>
			<li><a href="javascript:void(0)" onclick="showMsg();" class="addImgbtn blueBtn" id="crossGoods_btn">${shopVo.wordNames['gmse036']}</a></li>
			<li class="commitImg"><span  class="tit_1">${shopVo.wordNames['gmse071']}</span>
			  <input type="hidden"  id="relationGoodsId"/>
			  
			    <div class="borderStyle areaImg"  id="relationGoods">
                  </div></li>
			<li><a href="javascript:void(0)" onclick="showMsg();" class="addImgbtn blueBtn" id="relationGoodsre_btn">${shopVo.wordNames['gmse036']}</a></li>
			<li class="commitImg"><span  class="tit_1">${shopVo.wordNames['gmse072']}</span>
			  <input type="hidden"  id="replaceGoodsId"/>
			  
			    <div class="borderStyle areaImg"  id="replaceGoods">
                  </div></li>
			<li><a href="javascript:void(0)" onclick="showMsg();" class="addImgbtn blueBtn" id="replaceGood_btn">${shopVo.wordNames['gmse036']}</a></li>
		</ul>
		<input type="submit" onclick="showMsg();" value="${shopVo.wordNames['gmse055']}" class="savebtnS blueBtn"/>
	</form>
</div>