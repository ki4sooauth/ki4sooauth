 
<div class="rightTitle">
	<span>${shopVo.wordNames['gmsc077']}</span>
</div>
<div class="conditions_content">
	<div class="title">${shopVo.wordNames['gmsc081']}
		<select class="Rselect" id="curr_selectAction" name="<#if actionTypes?? && actionTypes!=''>actionType</#if>" onchange="addDelAttr(this); appendBehavior('C');initCurrentTiemScope(this.value);">
       		<option value="">--${shopVo.wordNames['gmsc058']}--</option>
   		</select>
   	</div>
   	<div class="behavior_quality currentAction" id="currentAction">
		<#include "user_behave_attribute.ftl">
   	</div>
</div>