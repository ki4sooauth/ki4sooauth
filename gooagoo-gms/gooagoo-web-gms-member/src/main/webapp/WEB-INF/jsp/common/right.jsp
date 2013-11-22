<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${imgPath}/gms/member/js/userRecord/right_data.js"></script>
<div class="user_state">
	<p class="title">${shopVo.wordNames['cpma005']}</p>
    <ul id="user_state">
    	<a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma006']}</p>
    	<h2 id="storeTheUser">0</h2>
    	</li>
        </a>
        <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma007']}</p>
    	<h2 id="storeTheMember">0</h2>
    	</li>
        </a>
        <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma008']}</p>
    	<h2 id="mobilePotentialMember">0</h2>
    	</li>
        </a>
        <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma009']}</p>
    	<h2 id="webPotentialMember">0</h2>
    	</li></a>
        <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma010']}</p>
    	<h2 id="newMembers">0</h2>
    	</li>
        </a>
        <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma011']}</p>
    	<h2 id="potentialMember">0</h2>
    	</li></a>
    	 <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma012']}</p>
    	<h2 id="webInteractiveMember">0</h2>
    	</li></a>
    	 <a href="javascript:;"><li>
        <p>${shopVo.wordNames['cpma013']}</p>
    	<h2 id="mobileInteractiveMember">0</h2>
    	</li></a>
    </ul>
    <p class="bottom_btn" id="bottom_btn">∧</p>
</div>
<script type="text/javascript">
	$(document).ready(function(){
	 	userRecordData("${basePath}");
	});
</script>