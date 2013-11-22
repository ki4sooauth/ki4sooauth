<#if behaveList??>
<#escape x as x!>
<#list behaveList as behaveObj>
	<#assign behaveType = behaveObj.actionType>
	<#assign ruleConfig = configList[behaveObj_index]>

	<dl class="action_${behaveType }">
		<dt>
			<b class="showBtn curr"><i></i></b>
			<b class="deletebtn">x</b>
			<#list behave_type?keys as key><#if key==behaveType>${behave_type[key]}</#if></#list>
		</dt>
		<#if ruleConfig.isShowDateScope=='Y' >
		    <dd>
		    	<span>${shopVo.wordNames['gmsc090']}</span>
		    	<input type="text" class="date" name="${conditionType}_${behaveType}_dateStart" value="${behaveObj.dateStart}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="readonly" onchange="compareTime('date',this);"/><samp>-</samp>
		    	<input type="text" class="date" name="${conditionType}_${behaveType}_dateEnd" value="${behaveObj.dateEnd}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="readonly" onchange="compareTime('date',this);"/>
		    </dd>
	    </#if>
		<#if ruleConfig.isShowWeekScope=='Y' && conditionType=='C'>
		    <dd id="isShowWeekScope">
		    	<span>${shopVo.wordNames['gmsc091']}</span>
		    	<input type="checkbox" class="checktype" value="" id="checkAll" onclick="checkedWeekAll(this);"/><samp>${shopVo.wordNames['gmsc115']}</samp>&nbsp;
				<#list week_type?keys as key>
		        	<input type="checkbox" class="checktype" value="${key}" onclick="selectWeek(this);" <#if behaveObj.weekScope??&&behaveObj.weekScope?contains(key)>checked="checked"</#if>/><samp>${week_type[key]}</samp>&nbsp;
		        </#list>
		  		<input type="hidden" class="checktype" name="${conditionType}_${behaveType}_weekScope" value="${behaveObj.weekScope}"/>
		  	</dd>
	    </#if>
		<#if ruleConfig.isShowTimeScope=='Y' && conditionType=='C'>
		    <dd id="isShowTimeScope">
		    	<span>${shopVo.wordNames['gmsc092']}</span>
		       	<input type="text" class="date" name="${conditionType}_${behaveType}_timeStart" value="${behaveObj.timeStart}" onclick="WdatePicker({dateFmt:'HH:mm'});" readonly="readonly" onblur="compareTime('time',this);"/><samp>-</samp>
		       	<input type="text" class="date" name="${conditionType}_${behaveType}_timeEnd" value="${behaveObj.timeEnd}" onclick="WdatePicker({dateFmt:'HH:mm'});" readonly="readonly" onblur="compareTime('time',this);"/>
		    </dd>
	    </#if>
		<#if ruleConfig.isShowVipGrade=='Y' && conditionType=='C'>
			<dd id="isShowVipGrade">
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','D');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_vipGrade" value="${behaveObj.vipGrade}"/>
		            <span>${shopVo.wordNames['gmsc089']}</span>
		           	<ul class="tag">
						<#if behaveObj.vipGrade??&&behaveObj.vipGrade!="">
			           		<#assign vipGradeNames = behaveObj.vipGradeName?split(',')>   
			           		<#list behaveObj.vipGrade?split(',') as item>
				           		<li>
									<span>${vipGradeNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
					<font style="color: gray; line-height: 20px; float:right; display:none;">此项与自然属性中的“会员等级”不能同时选择</font>
	           	</div>
	       	</dd>
	    </#if>
		<#if ruleConfig.isShowActionSource=='Y'>
		    <dd>
		    	<span>${shopVo.wordNames['gmsc093']}</span>
		    	<select name="${conditionType}_${behaveType}_actionSource">
		    		<option value="">--${shopVo.wordNames['gmsc058']}--</option>
		    		<#list info_source?keys as key>
		     			<option value="${key}" <#if behaveObj.actionSource??&&behaveObj.actionSource==key>selected="selected"</#if>>${info_source[key]}</option>
		         	</#list>
		    	</select>
		    </dd>
	    </#if>
		<#if (ruleConfig.isShowTime=='Y' || ruleConfig.isShowTotalTime=='Y') && conditionType=='H'>
		    <dd id="isShowTimeOrTotalTime">
				<span>${shopVo.wordNames['gmsc126']}</span>
		    	<input type="radio" class="time0" name="${conditionType}_${behaveType}_cichu" <#if behaveObj.timeMin?? || behaveObj.timeMax??>checked="checked"</#if>/>
		    	<samp>${shopVo.wordNames['gmsc094']}</samp>
		    	<div class="time" style="display: <#if behaveObj.timeMin??>block<#else>none</#if>;">
			    	<input class="age" type="text" name="${conditionType}_${behaveType}_timeMin" value="<#if behaveObj.timeMin??>${behaveObj.timeMin?string("0")}</#if>" onblur="compareNum('time',this);showCishuOrDuration('${conditionType}_${behaveType}',this);"/><samp>-</samp>
			    	<input class="age" type="text" name="${conditionType}_${behaveType}_timeMax" value="<#if behaveObj.timeMax??>${behaveObj.timeMax?string("0")}</#if>" onblur="compareNum('time',this);showCishuOrDuration('${conditionType}_${behaveType}',this);"/><samp>${shopVo.wordNames['gmsc069']}</samp>
		    	</div>
		    	<input type="radio" class="time1" name="${conditionType}_${behaveType}_cichu" <#if behaveObj.totalTimeMin?? || behaveObj.totalTimeMax??>checked="checked"</#if> style="margin-left: 10px;"/>
		    	<samp>${shopVo.wordNames['gmsc095']}</samp>
		    	<div class="totalTime" style="display: <#if behaveObj.totalTimeMin??>block<#else>none</#if>;">
			       	<input class="age" type="text" name="${conditionType}_${behaveType}_totalTimeMin" value="<#if behaveObj.totalTimeMin??>${behaveObj.totalTimeMin?string("0")}</#if>" onblur="compareNum('totalTime',this);showCishuOrDuration('${conditionType}_${behaveType}',this);"/><samp>-</samp>
			      	<input class="age" type="text" name="${conditionType}_${behaveType}_totalTimeMax" value="<#if behaveObj.totalTimeMax??>${behaveObj.totalTimeMax?string("0")}</#if>" onblur="compareNum('totalTime',this);showCishuOrDuration('${conditionType}_${behaveType}',this);"/><samp>${shopVo.wordNames['gmsc069']}</samp>
		   		</div>
	   	   		<#if (ruleConfig.isShowTime=='Y' || ruleConfig.isShowTotalTime=='Y') && ruleConfig.isShowDuration=='Y' >
		   			<font style="color: gray; line-height: 20px;padding-right:20px;float:right;">${shopVo.wordNames['gmsc131']}</font>
		   		</#if>
		   	</dd>
	    </#if>
		<#if ruleConfig.isShowMarketingGoodsCategory=='Y' || ruleConfig.isShowMarketingGoodsBrand=='Y' || ruleConfig.isShowMarketingGoods=='Y' ><!-- 是否展示关系 -->
		    <dd>
		    	<span>${shopVo.wordNames['gmsc096']}</span>
		    	<select name="${conditionType}_${behaveType}_relation">
					<#list relation_type?keys as key>
			       		<option value="${key}" <#if behaveObj.relation??&&behaveObj.relation==key>selected="selected"</#if>>${relation_type[key]}</option>
			        </#list>
		     	</select>
		   		<font style="color: gray; line-height: 20px;">${shopVo.wordNames['gmsc097']}</font>
		    </dd>
	    </#if>
		<#if ruleConfig.isShowMarketingGoodsCategory=='Y'>
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','J');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_marketingGoodsCategory" value="${behaveObj.marketingGoodsCategory}"/>
			        <span>${shopVo.wordNames['gmsc098']}</span>
			        <ul class="tag">
						<#if behaveObj.marketingGoodsCategory??&&behaveObj.marketingGoodsCategory!="">
			           		<#assign marketingGoodsCategoryNames = behaveObj.marketingGoodsCategoryName?split(',')>   
			           		<#list behaveObj.marketingGoodsCategory?split(',') as item>
				           		<li>
									<span>${marketingGoodsCategoryNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
			        </ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowMarketingGoodsBrand=='Y' >
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','B');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_marketingGoodsBrand" value="${behaveObj.marketingGoodsBrand}"/>
		            <span>${shopVo.wordNames['gmsc099']}</span>
		           	<ul class="tag">
						<#if behaveObj.marketingGoodsBrand??&&behaveObj.marketingGoodsBrand!="">
			           		<#assign marketingGoodsBrandNames = behaveObj.marketingGoodsBrandName?split(',')>   
			           		<#list behaveObj.marketingGoodsBrand?split(',') as item>
				           		<li>
									<span>${marketingGoodsBrandNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowMarketingGoods=='Y' >
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','G');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_marketingGoods" value="${behaveObj.marketingGoods}"/>
		            <span>${shopVo.wordNames['gmsc100']}</span>
		           	<ul class="tag">
						<#if behaveObj.marketingGoods??&&behaveObj.marketingGoods!="">
			           		<#assign marketingGoodsNames = behaveObj.marketingGoodsName?split(',')>   
			           		<#list behaveObj.marketingGoods?split(',') as item>
				           		<li>
									<span>${marketingGoodsNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowMarketingAction=='Y' >
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','A');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_marketingActivity" value="${behaveObj.marketingActivity}"/>
		            <span>${shopVo.wordNames['gmsc101']}</span>
		           	<ul class="tag">
						<#if behaveObj.marketingActivity??&&behaveObj.marketingActivity!="">
			           		<#assign marketingActivityNames = behaveObj.marketingActivityName?split(',')>   
			           		<#list behaveObj.marketingActivity?split(',') as item>
				           		<li>
									<span>${marketingActivityNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowMarketingCoupon=='Y' >
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','C');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_marketingCoupon" value="${behaveObj.marketingCoupon}"/>
		            <span>${shopVo.wordNames['gmsc102']}</span>
		           	<ul class="tag">
			           	<#if behaveObj.marketingCoupon??&&behaveObj.marketingCoupon!="">
			           		<#assign marketingCouponNames = behaveObj.marketingCouponName?split(',')>   
			           		<#list behaveObj.marketingCoupon?split(',') as item>
				           		<li>
									<span>${marketingCouponNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowMarketingEvent=='Y' >
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','K');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_marketingEvent" value="${behaveObj.marketingEvent}"/>
		            <span>${shopVo.wordNames['gmsc132']}</span>
		           	<ul class="tag">
			           	<#if behaveObj.marketingEvent??&&behaveObj.marketingEvent!="">
			           		<#assign marketingEventNames = behaveObj.marketingEventName?split(',')>   
			           		<#list behaveObj.marketingEvent?split(',') as item>
				           		<li>
									<span>${marketingEventNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowServerTools=='Y'>
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'tree','M','F');" class="add selDateType" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_serverTools" value="${behaveObj.serverTools}"/>
		            <span>${shopVo.wordNames['gmsc104']}</span>
		           	<ul class="tag">
			           	<#if behaveObj.serverTools??&&behaveObj.serverTools!="">
			           		<#assign serverToolsNames = behaveObj.serverToolsName?split(',')>   
			           		<#list behaveObj.serverTools?split(',') as item>
				           		<li>
									<span>${serverToolsNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowPosition=='Y'>
			<dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'tree','M','I');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_position" value="${behaveObj.position}"/>
		            <span>${shopVo.wordNames['gmsc105']}</span>
		           	<ul class="tag">
			           	<#if behaveObj.position??&&behaveObj.position!="">
			           		<#assign positionNames = behaveObj.positionName?split(',')>   
			           		<#list behaveObj.position?split(',') as item>
				           		<li>
									<span>${positionNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
			</dd>
	    </#if>
		<#if ruleConfig.isShowDuration=='Y' >
			<dd id="isShowDuration">
				<span>${shopVo.wordNames['gmsc116']}</span>
		    	<input class="age" type="text" name="${conditionType}_${behaveType}_durationMin" value="<#if behaveObj.durationMin??>${behaveObj.durationMin?string("0")}</#if>" onblur="showCishuOrDuration('${conditionType}_${behaveType}',this);" maxlength="10"/><samp>-</samp>
		   		<input class="age" type="text" name="${conditionType}_${behaveType}_durationMax" value="<#if behaveObj.durationMax??>${behaveObj.durationMax?string("0")}</#if>" onblur="showCishuOrDuration('${conditionType}_${behaveType}',this);" maxlength="10"/><samp>${shopVo.wordNames['gmsc128']}</samp>
	   	   		<#if conditionType=='C' && (ruleConfig.isShowTime=='Y' || ruleConfig.isShowTotalTime=='Y')>
		   			<font style="color: gray; line-height: 20px;padding-right:20px;float:right;">${shopVo.wordNames['gmsc131']}</font>
		   		</#if>
		   	</dd>
	    </#if>
		<#if ruleConfig.isShowConsumeMoney=='Y'>
			<dd><span>${shopVo.wordNames['gmsc106']}</span>
		    	<input type="text" name="${conditionType}_${behaveType}_consumeMoneyMin" value="<#if behaveObj.consumeMoneyMin??>${behaveObj.consumeMoneyMin?string("0.######")}</#if>" maxlength="16" onblur="compareNum('consumeMoney',this)" onkeyup="clearNoNum(this);" style="width: 100px;"/><samp>-</samp>
		   		<input type="text" name="${conditionType}_${behaveType}_consumeMoneyMax" value="<#if behaveObj.consumeMoneyMax??>${behaveObj.consumeMoneyMax?string("0.######")}</#if>" maxlength="16" onblur="compareNum('consumeMoney',this)" onkeyup="clearNoNum(this);" style="width: 100px;"/>
		   		<font style="line-height: 20px;">${shopVo.wordNames['gmsc067']}</font>
		    <dd>
	    </#if>
		<#if ruleConfig.isShowVb=='Y'>
		    <dd>
				<div class="bottom_box">
					<a href="javascript:void(0);" onclick="relateFancybox(this,'list','M','O');" class="add" >${shopVo.wordNames['gmsc001']}</a>
					<input type="hidden" name="${conditionType}_${behaveType}_cmsContent" value="${behaveObj.cmsContent}"/>
		    		<span>${shopVo.wordNames['gmsc133']}</span>
		           	<ul class="tag">
			           	<#if behaveObj.cmsContent??&&behaveObj.cmsContent!="">
			           		<#assign cmsContentNames = behaveObj.cmsContentName?split(',')>   
			           		<#list behaveObj.cmsContent?split(',') as item>
				           		<li>
									<span>${cmsContentNames[item_index]}<b onclick="deleteRela(this)">x</b><input type="hidden" value="${item}"></span>
								</li>
				           	</#list>
		           		</#if>
		           	</ul>
				</div>
		    </dd>
	    </#if>
	</dl>
</#list>
</#escape>
</#if>