<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>

<div class="title">${shopVo.wordNames['gmse042']}</div>
<div class="productBuild">
	<form method="post" id="goods_base">
		<ul>
			<li>
				<span class="tit_1">${shopVo.wordNames['gmse043']}</span>
				${shopEntityName}
			</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse004']}</span>${goodsInfo.goodsName }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse005']}</span>${goodsInfo.categoryLeafName }
				<input id="categoryRootId" value="${goodsInfo.categoryRootId }"  type="hidden" name="categoryRootId"/>
				<input id="categoryLeafId" value="${goodsInfo.categoryLeafId }" type="hidden" name="categoryLeafId"/>
				</li>
			<li>
				<span class="tit_1">${shopVo.wordNames['gmse006']}</span>${goodsInfo.brandName }
				<input  id="brandId" value="${goodsInfo.brandId }" type="hidden" name="brandId"/></li>
			<li><span class="tit_1">${shopVo.wordNames['gmse044']}</span>${goodsInfo.goodsSerial }</li>
			<li><span class="tit_1">${shopVo.wordNames['gmse045']}</span>${goodsInfo.itemSerial }</li>
			<li>
			<span class="tit_1">${shopVo.wordNames['gmse047']}</span>${goodsInfo.price }
			</li>
		</ul>
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