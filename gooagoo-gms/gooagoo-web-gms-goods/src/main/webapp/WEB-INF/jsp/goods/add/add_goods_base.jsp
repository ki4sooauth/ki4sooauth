<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<div class="title">${shopVo.wordNames['gmse042']}</div>
<div class="productBuild">
	<form method="post" id="goods_base">
		<ul>
			<li>	
				<span  class="tit_1">${shopVo.wordNames['gmse043']}</span>
				<select class="borderStyle text" onchange="changeSelect();" name="entityId" id="shopEntityId">  
				 <c:forEach items="${shopEntityList }" var="item">
				 <option value="${item.shopEntityId }">${item.shopEntityName }</option>
				 </c:forEach>
				   </select> 
			</li>
			<li><span  class="tit_1">${shopVo.wordNames['gmse004']}</span><input class="borderStyle text" type="text"
				name="goodsName" /></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse005']}</span><input class="borderStyle text"
				type="text" name="categoryLeafName" id="goods_category" readonly  onclick="relateOne('J');"  />
				<input id="categoryRootId"  type="hidden" name="categoryRootId"/>
				<input id="categoryLeafId" type="hidden" name="categoryLeafId"/>
			</li>
			<li>
				<span class="tit_1">${shopVo.wordNames['gmse006']}</span><input
				class="borderStyle text" type="text" readonly name="brandName"   id="goods_brand" onclick="relateOne('B');"/>
				<input  id="brandId" type="hidden" name="brandId"/></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse044']}</span><input class="borderStyle text"
				type="text" name="goodsSerial" value="${goodsInfo.goodsSerial }"/></li>
				<li><span class="tit_1">${shopVo.wordNames['gmse045']}</span><input
				class="borderStyle text" type="text" name="itemSerial" value="${goodsInfo.itemSerial }"/></li>
			<li>	 
			<span class="tit_1">${shopVo.wordNames['gmse047']}</span><input
				class="borderStyle text" type="text" name="price" value="${goodsInfo.price }"/>
			</li>
		</ul>
         <input id="goods_save" class="savebtnS blueBtn"  type="submit"	value="${shopVo.wordNames['gmse055']}" />
	</form>
</div>
<div id="goods_brand_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="goods_brand_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
<div id="goods_category_Content" class="menuContent" style="display:none; position: absolute;">
	<ul id="goods_category_ztree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>

<!-- 上传图片使用 -->
<div style="display:none;">
	<a href="jcroup.jsp" id="fancybox_pic" class="fancybox_pic"></a>
</div>
<input type="hidden" id="cid"/>