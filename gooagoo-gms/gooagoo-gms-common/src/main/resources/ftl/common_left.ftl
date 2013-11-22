<#escape x as x!>
<div class="aside">
  <div class="brand">
    <h2 class="countTitle">${STATUSNAME}</h2>
     <table width="100%" cellspacing="1" cellpadding="0" border="0" class="countTable">
      <tbody>
      <tr>
        <td width="55%" class="title">${statusNames['TOTALSTATUSNAME0']}</td>
        <td width="45%" class="num"><span class="orangeBtn borderRadius">${statusDatas['TOTALSTATUS0']}</span></td>
      </tr>
      <tr class="trBg">
        <td class="title">${statusNames['TOTALSTATUSNAME1']}</td>
        <td class="num"><span class="orangeBtn borderRadius">${statusDatas['TOTALSTATUS1']}</span></td>
      </tr>
      <tr>
        <td class="title">${statusNames['TOTALSTATUSNAME2']}</td>
        <td class="num"><span class="orangeBtn borderRadius">${statusDatas['TOTALSTATUS2']}</span></td>
      </tr>
      <tr class="trBg">
        <td class="title">${statusNames['TOTALSTATUSNAME3']}</td>
        <td class="num"><span class="orangeBtn borderRadius">${statusDatas['TOTALSTATUS3']}</span></td>
      </tr>
    </tbody></table>

  </div>
	<div class="fast_channel">
		<h2>${FASTNAME}</h2>
		<ul class="enter">
			<li class="First" onclick="window.location.href='${FASTCHANNELURL1}'"><a href="${FASTCHANNELURL1}"><p>${FASTCHANNELNAME1}</p></a></li>
			<li class="Second" onclick="window.location.href='${FASTCHANNELURL2}'"><a href="${FASTCHANNELURL2}"><p>${FASTCHANNELNAME2}</p></a></li>
		</ul>
	</div>
  	<ul id="left_menu" class="left_menu">
  		<#if menus??>
			<#list menus as item>
			<li><a href="${item.icon}" <#if menuCode??&&item.code==menuCode>class="selected"</#if>>${item.name}</a></li>
       		</#list>
		</#if>
	</ul>
</div>
</#escape>