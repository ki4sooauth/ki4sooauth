<#escape x as x!>
<div class="conditions_content">
	<div class="title">${shopVo.wordNames['gmsc079']}</div>
	<div class="natural_quality">
		<p>
			<span>${shopVo.wordNames['gmsc083']}</span>
			<select name="accountType">
               	<option value="">--${shopVo.wordNames['gmsc058']}--</option>
				<#if user_type??>
					<#list user_type?keys as key>
					<option value="${key}" <#if natural.accountType??&&key==natural.accountType>selected="selected"</#if>>${user_type[key]}</option>
	           		</#list>
				</#if>
            </select>
        	<span class="num">${shopVo.wordNames['gmsc084']}</span>
            <input type="text" name="account" value="${natural.account}" maxlength="32"/>
		</p>
		<p>
            <span>${shopVo.wordNames['gmsc085']}</span>
			<select name="sex">
          		<option value="">--${shopVo.wordNames['gmsc058']}--</option>
				<#if sex??>
					<#list sex?keys as key>
					<option value="${key}" <#if natural.sex??&&key==natural.sex>selected="selected"</#if>>${sex[key]}</option>
	           		</#list>
				</#if>
  			</select>
         	<span>${shopVo.wordNames['gmsc087']}</span>
         	<input type="text" class="age" name="ageStart" value="<#if natural.ageStart??>${natural.ageStart?string("0")}</#if>" onblur="compareNum('age',this)"/><samp>-</samp>
         	<input type="text" class="age" name="ageEnd" value="<#if natural.ageEnd??>${natural.ageEnd?string("0")}</#if>" onblur="compareNum('age',this)"/><samp>${shopVo.wordNames['gmsc088']}</samp>
        </p>
		<p>
         	<span>${shopVo.wordNames['gmsc086']}</span>
         	<input type="text" class="date" name="birthdayStart" id="b1" value="${natural.birthdayStart}" 
         		onclick="WdatePicker({dateFmt:'MM-dd',maxDate:'#F{$dp.$D(\'b2\')}'});" readonly="readonly" onblur="compareTime('birthday',this);" /><samp>-</samp>
         	<input type="text" class="date" name="birthdayEnd" id="b2" value="${natural.birthdayEnd}" 
         		onclick="WdatePicker({dateFmt:'MM-dd',minDate:'#F{$dp.$D(\'b1\')||\'01-01\'}'});" readonly="readonly" onblur="compareTime('birthday',this);" />
       	</p>
   		<!-- 获取会员特征 -->
   		<div class="bottom_box" style="padding-bottom: 0px;">
   			<ul style="width: 700px;">
   				<#if fmemberFeatures??>
   					<#list fmemberFeatures as feature>
   						<li>
   							<span>${feature.typeName}</span>
							<select name="feature">
               					<option value="">--${shopVo.wordNames['gmsc058']}--</option>
               					<#list feature.valuelist as fvalue>
							  		<option value="${feature.typeCode}_${fvalue}" <#list natural.memberFeatureList as temp><#if feature.typeCode==temp.typeCode && fvalue==temp.enumValue>selected="selected"</#if></#list>>${fvalue}</option>
						  		</#list>
							</select> 
   						</li>
   					</#list>
   				</#if>
   			</ul>
   		</div>
       	<div class="bottom_box" id="grade">
       		<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','D');" class="add" >${shopVo.wordNames['gmsc001']}</a>
           	<input type="hidden" name="grade" value="${natural.grade}"/>
      		<span>${shopVo.wordNames['gmsc089']}</span>
			<ul class="tag">
				<#if natural.grade??&&natural.grade!="">
	           		<#assign gradeNames = natural.gradeName?split(',')>   
	           		<#list natural.grade?split(',') as item>
		           		<li>
							<span>${gradeNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
						</li>
		           	</#list>
           		</#if>
           	</ul>
			<font style="color: gray; line-height: 20px; float:right; display:none;">此项与实时行为中的“会员等级”不能同时选择</font>
   		</div>
	</div>
	<div class="title relative">
   		<div class="position_add" id="position_add">
       		<b class="b1">◆</b>
           	<b class="b2">◆</b>
       		<ul>
            </ul>
   		</div>
		<a href="javascript:void(0);" class="add_btn orangeBtn" id="add_btn">${shopVo.wordNames['gmsc001']}</a>${shopVo.wordNames['gmsc080']}
	</div>
	<input type="hidden" name="actionTypes" value="${actionTypes }" />
	<div class="behavior_quality" id="historyAction">
		<#include "user_behave_attribute.ftl">
	</div>
</div>
</#escape>
