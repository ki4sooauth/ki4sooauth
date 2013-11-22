<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page isELIgnored="false" %>
<div class="concen31" >
     <div class="concen32">
     <a href="javascript:void(0)">
        <img src="${goodsInfo.goodsImg}" width="75" height="75" />
        <u class="productBuild-del" onclick="delGoods(this)"></u>
	    <input type="hidden" value="${goodsInfo.goodsId}" class="goodsIdClass">
     </a>
   </div>
</div>
  
<script type="text/javascript">

function delGoods(obj) {
	$(obj).parent().remove() ;
}
</script>











