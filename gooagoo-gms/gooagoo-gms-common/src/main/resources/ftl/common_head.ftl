<#escape x as x!>
<div class="header">
  <div class="header_container">
    <span class="headerLinks">
       <#if headType=='1'>
	       <a href='${authMap['1306']}'>·${shopVo.wordNames['gmsb162']}</a>
	       <a href='${authMap['1307']}'>·${shopVo.wordNames['gmsb163']}</a>
	       <a href='${authMap['14']}'>·${shopVo.wordNames['gmsa003']}</a>
	       <a href='javascript:void(0);'>·${shopVo.wordNames['gmsa004']}</a>
	       <a href='javascript:void(0);' onclick="window.open('${authMap['5']}');" class='manage'>切换至模板系统 >></a>
	       <a href='${authMap['C']}' class='manage'>切换至CMS系统 >></a>
	       <a href='${authMap['2']}' class='manage'>切换至CPM系统 >></a>
       <#elseif headType=='2'>
	       <a href='javascript:void(0);'>·${shopVo.wordNames['gmsa004']}</a>
	       <a href='${marketingUrl}' class='manage'>切换至营销管理系统 >></a>
       </#if>
    </span>
    <span class="userLoad">${shopVo.wordNames['gmsa001']}${shopVo.shopAndUserInfo.shopEmail}<a href="${shopLogout}">${shopVo.wordNames['gmsa002']}</a></span>
    <div class="A-logo">
        <span class="Mylogo"><img src="${imgPath}/gms/common/images/Mylogo.png" width="140" height="18"/></span>
        <span class="logo"><img height="64" src="${shopVo.shopAndUserInfo.shopLogo2}" /></span>
    </div>
  </div>
  <div class="nav">
     <ul id="top_menu">
     	<#if menus1??>
			<#list menus1 as item>
			<li><a href="${item.icon}" <#if menuCode1??&&item.code==menuCode1>class="selected"</#if>>${item.name}</a></li>
       		</#list>
		</#if>
     </ul>
  </div>
</div>
<#if menus2?? && (menus2?size>0)>
<div class='sub_nav_wrap'>
	<div class='sub_nav_height'>
		<ul class='sub_nav'>
			<#list menus2 as item>
			<li><a href="${item.icon}" <#if menuCode2??&&item.code==menuCode2>class="selected"</#if>>${item.name}</a></li>
			</#list>
		</ul>
	</div>
</div>
</#if>
</#escape>