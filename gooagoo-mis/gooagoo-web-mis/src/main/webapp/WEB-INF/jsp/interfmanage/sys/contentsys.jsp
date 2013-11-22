<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<script type="text/javascript" src="${imgPath}/mis/js/search.js"></script>
<script type="text/javascript">
var pIndex = '${page_cur}';
var curSize = '${fn:length(pm.result)}';
$(document).ready(function(){
	initFancyBox("fancybox_activity1",610,500,true);
	initFancyBox("fancybox_activity2",610,320,true);
});
</script>
<div style="display:none;">
	<a href="#" id="sysuserFancybox1" class="fancybox_activity1" ></a>
	<a href="#" id="sysuserFancybox2" class="fancybox_activity2" ></a>
</div>
<div class="div_but">
				<input type="button" value="编辑" onclick="javascript:edit();" />
				<input type="button" value="删除" onclick="javascript:del();" />
			</div>

			<div class="list_box_search">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="searchForm" border="1">
					<tr bgcolor="red">
						<th width="20">编号</th>
						<th><input type="checkbox" name="Seleted_all"
							style="margin-right: 3px;"  />勾选</th>
						<th>姓名</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>邮箱地址</th>
						<th>用户状态</th>
						<th>证件类型</th>
						<th>证件号码</th>
						<th>所属部门</th>
						<th>是否删除</th>
						<th>创建时间</th>
					</tr>
					
					<c:forEach var="item" items="${pm.result }" varStatus="im" >
						<tr>
							<td>${im.count }</td>
							<td><input type="checkbox" name="single" value="${item.userId }"  /></td>
							<td>${item.name }</td>
							<c:if test="${item.sex == 'M'}"><td>男</td></c:if>
							<c:if test="${item.sex == 'F' }"><td>女</td></c:if>
							<td>${item.birthday }</td>
							<td>${item.userId }</td>
							<c:if test="${item.status == 0}"><td>停用</td></c:if>
							<c:if test="${item.status == 1}"><td>启用</td></c:if>
							<td>${item.idType }</td>
							<td>${item.idNo }</td>
							<td>${item.department }</td>
							<c:if test="${item.isDel == 'Y'}"><td>已删除</td></c:if>
							<c:if test="${item.isDel == 'N'}"><td>未删除</td></c:if>
							<td>${item.createTime }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		<!--分页-->
		<div class="lasl" id="Pagination" style="border:0;">
			<%@ include file="/WEB-INF/jsp/common/page.jsp"%>
    	</div>
<script type="text/javascript">
		//编辑 
		function edit(){
			if("" == ids || ids == null){
				alert("请选择要编辑的用户！");
				return;
			}
			if(checkOnly()){
				showUpdateJsp(ids);
			}
		}
		//删除
		function del(){
			if("" == ids || ids == null){
				alert("请选择要删除的用户！");
				return;
			} else{
				if(confirm("确定删除选中信息？")){
					var url = "sysuser.do?method=delSysUser";
					var data = "&id=" + ids;
					var ret = ajaxJsonVoByData(url,data);
					alert(ret);
					page(pIndex);
				}
			}
		}
		
		//选择一条数据进行操作 
		function checkOnly(){
			var arrayMemberId = null;
			if(ids != null){
				arrayMemberId = ids.split(",");
				if((arrayMemberId.length - 1) > 1){
					alert("只能选择一个用户进行操作！");
					page(1);
	 				return false;
				} return true;
			} return false;
		}
		
		function showRoleList(userId){
			var url = "sysuser.do?method=allotRole&id="+userId;
			$("#sysuserFancybox2").attr("href",url).click();
		}
		
		function showUpdateJsp(userId){
			var url = "sysuser.do?method=showModifySysUser&id="+ userId;
			$("#sysuserFancybox1").attr("href",url).click();
		}
</script>