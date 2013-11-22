
<div class="shopping_Flip">
	<#if page_cur < page_end >
		<a href="javascript:void(0);" class="flip_downBtn blueBtn" onclick="page(${page_cur + 1 },this);">下一页</a>
	</#if>
	<div class="flip_Num_box">
		<#if page_start <= page_end>
			<#list page_start..page_end as pi>
			<a href="javascript:void(0);" <#if page_cur==pi>class="Actived"</#if>  onclick="page(${pi},this);">${pi}</a>
			</#list>
		</#if>
	</div>
	<#if page_cur != 1>
		<a href="javascript:void(0);" class="flip_downBtn blueBtn" onclick="page(${page_cur - 1 },this);">上一页</a>
	</#if>
</div>
