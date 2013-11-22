<#escape x as x!>
<div class="rightTitle"><span>${shopVo.wordNames['gmsc108']}</span></div>
<div class="conditions_content">
	<div class="title">${shopVo.wordNames['gmsc109']}</div>
  	<div class="plan_box">
      	<p class="top_p">
      		<span>${shopVo.wordNames['gmsc110']}：</span>
      		<input type="radio" class="radio" name="isPublishImmediately" value="Y" <#if info.isPublishImmediately=='Y'>checked="checked"</#if>/><span>${shopVo.wordNames['gmsc111']}</span>
      		<input type="radio" class="radio" name="isPublishImmediately" value="N" <#if info.isPublishImmediately=='N'>checked="checked"</#if>/><span>${shopVo.wordNames['gmsc112']}</span>
			<input type="text" class="date" name="expectPublishTime" value="<#if info.expectPublishTime??>${info.expectPublishTime?string("yyyy-MM-dd HH:mm:ss")}</#if>" 
			onclick=<#noparse>"WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:#{%m+30}:%s',maxDate:'#{%y+1}-%M-%d %H:%m:%s'});"</#noparse> readonly="readonly" style="width: 140px;display:<#if info.isPublishImmediately=='N'>block<#else>none</#if>;" />
     	</p>
     	<p>
     		<span>${shopVo.wordNames['gmsc119']}：</span>
     		<select name="ruleActiveType" style="border: 1px solid #A5ACB2; height: 20px; margin-right: 5px; width: 110px;">
     			<option value="" >--${shopVo.wordNames['gmsc058']}--</option>
				<#if rule_active_type??>
					<#list rule_active_type?keys as key>
					<option value="${key}" <#if info.ruleActiveType??&&key==info.ruleActiveType?string>selected="selected"</#if> title="<#if key=="0">shopVo.wordNames['gmsc123']<#elseif key=="1">shopVo.wordNames['gmsc124']<#elseif key=="2">shopVo.wordNames['gmsc125']</#if>">${rule_active_type[key]}</option>
	           		</#list>
				</#if>
     		</select>
     	</p>
        <p>
	        <span>${shopVo.wordNames['gmsc113']}</span>
	        <input class="date" name="startTime" id="d1" value="${startTime}"
	        	onclick="WdatePicker({minDate:'${wpMinDate}',maxDate:'#F{$dp.$D(\'d2\')||\'${eTime}\'}'})" />
	        <span>${shopVo.wordNames['gmsc114']}</span>
	        <input class="date" name="endTime" id="d2" value="${endTime}"
	        	onclick="WdatePicker({minDate:'#F{$dp.$D(\'d1\')||\'${wpMinDate}\'}',maxDate:'${eTime}'})"/>
	    </p>
 	</div>
</div>
</#escape>