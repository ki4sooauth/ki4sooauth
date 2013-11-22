<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询管理员</title>
<script type="text/javascript">
var varPageIndex = 1;
$(function(){
	refresh();
});
//分页查询 
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	varPageIndex = index;
	var data = $("#searchForm").serialize() +"&pageIndex="+index;
	ajaxToPageByData("sysuser.do?method=sysUserListContent","resultlist",data);
}
//刷新 
function refresh(){
	page(varPageIndex);
}
</script>
</head>

<body>
<!--内容-右边栏-->
<div class="content_right">
	<div class="div_top">
		<div class="div_p">
			<form id="searchForm" name="searchForm">
				<p>
					<label class="lab1">
						<span>姓名：</span>
						<input type="text" id="name" name="name" />
					</label>
					<label class="lab1">
						<span>邮箱地址：</span>
						<input type="text" id="userId" name="userId" />
					</label>
					<label class="lab1">
						<span>证件号码：</span>
						<input type="text" id="idNo" name="idNo" />
					</label>
				</p>
				<p>
					<label class="lab1">
						<span>性别：</span>
						<select id="sex" name="sex">
							<option value="">--请选择--</option>
							<option value="M">男</option>
							<option value="F">女</option>
						</select>
					</label>
					<label class="lab1">
						<span>证件类型：</span>
						<select id="idType" name="idType">
							<option value="">--请选择--</option>
							<option value="00">身份证</option>
							<option value="01">护照</option>
							<option value="02">军官证</option>
							<option value="03">其他</option>
						</select>
					</label>
					<label class="lab1">
						<span>用户状态：</span>
						<select id="status" name="status">
							<option value="">--请选择--</option>
							<option value="0">停用</option>
							<option value="1">启用</option>
						</select>
					</label>
				</p>
				<input type="hidden" id="department" name="department" value="" />
				<p class="p1">
					<input type="reset" value="重置" />
					<input type="button" value="查询" onclick="page(1)" />
				</p>
			</form>
		</div>
		<!-- 收放查询域的小箭头 -->
		<div class="div_in">
			<input type="button" class="in6" />
		</div>
	</div>
	<!-- 空白表单 -->
	<div>
		<div class="big_box" id="resultlist" >
		</div>
	</div>
</div>
<div class="clear"></div>
</body>
</html>