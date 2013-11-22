<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统接口查询首页</title>
<script>
$(function(){
	page(1);
});
function page(index){
	if(isEmpty(index) || parseInt(index)<1){
		index = 1;
	}
	var data = "&pageIndex="+index;
	ajaxToPageByData("interfsys.do?method=sysUserListContent","resultlist",data);
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
						<label class="lab1"><span>接口名称：</span><input type="text"
							id="username" name="username" /></label> <label class="lab2"><span>邮箱地址：</span><input
							type="text" id="email" name="email" /></label> <label class="lab3"><span>性别：</span><select
							id="sex" name="sex"><option>--请选择--</option>
								<option value="M">男</option>
								<option value="F">女</option></select></label>
					</p>
					<p>
						<label class="lab1"><span>证件类型：</span><select id="idtype"
							name="idtype"><option>--请选择--</option>
								<option value="0">身份证</option>
								<option value="1">军官证</option>
								<option value="2">护照</option>
								<option value="3">其它</option></select></label> <label class="lab2"><span>证件号码：</span><input
							type="text" id="idno" name="idno" /></label> <label class="lab3"><span>用户状态：</span><select
							id="userstatus" name="userstatus"><option>--请选择--</option>
								<option value="0">停用</option>
								<option value="1">启用</option></select></label>
					</p>
					<p>
						 <label class="lab1"><span>所属部门：</span><input type="text"
							id="department" name="department" /></label>
					</p>
					<p class="p1">
						<input type="reset" value="重置" /><input type="button" value="查询"
							onclick="javascript:page(1);" />
					</p>
				</form>
			</div>
			<div class="div_in">
				<input type="button" class="in6" />
			</div>
		</div>
		<div>
		<div class="big_box" id="resultlist">
		</div>
	</div>
	</div>
	<div class="clear"></div>
</body>
</html>