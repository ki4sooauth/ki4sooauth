<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<div class="natural_quality" style="float:right">
		<p>
			<span>${shopVo.wordNames['cpmf023']}</span>
			<select name="userAnalysis" onchange="getUserAnalysis();">
               	<option value="TOTAL_UC_">总用户</option>
           		<option value="TOTAL_MC_">总会员</option>
           		<option value="VISIT_UC_">到访用户</option>
           		<option value="VISIT_UC_">到访会员</option>
           		<option value="ADD_UC_">新增用户</option>
           		<option value="ADD_MC_">新增会员</option>
            </select>
		</p>
		 <%-- <p class="title">选择查询方式</p>
		     <ul class="dateListMenu">
			 <li><span class="curr" id="D">日查询</span></li>
			 <li><span id="W" name="R">周查询</span></li>
			 <li><span id="M" name="R">月查询</span></li>
			 <li><span id="Y" name="R">年查询</span></li>
			 <div style="display: none;">
				<li class="pl"><input type="text" /></li>
				<li><samp>-</samp></li>
				<li><input type="text" /></li>
				<li><a href="javascript:void(0)">查询</a></li>
			</div>
		</ul>--%>
	</div>
	<div class="file_first" id = "histogram_box"></div>
	<div class="histogram_box" id="histogram_line" style="display: none;"></div>
	<a style="display: none" class="fancybox"></a>
<script type="text/javascript">
<!--
$(document).ready(function(){
	initFancyBox("fancybox",850,500,false);
	getUserAnalysis();
});
//-->
</script>
