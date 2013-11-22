<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询消息日志</title>
<script type="text/javascript">
$(function(){
	page(1);
});
//分页查询
function page(index){
	if(isEmpty(index) || parseInt(index) < 1){
		index = 1;
	}
	var data = $("#searchForm").serialize() + "&pageIndex=" + index;
	ajaxToPageByData("sysLog.do?method=resultList","resultlist",data);
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
						<span>消息流水号：</span>
						<input type="text" id="uuid" name="uuid" />
					</label>
					<label class="lab1">
						<span>接口编码：</span>
						<input type="text" id="behaveCode" name="behaveCode" />
					</label>
					<label class="lab1">
						<span>消息来源：</span>
						<select id="source" name="source">
							<option value="">--请选择--</option>
							<c:forEach items="${behave_source }" var="source">
								<option value="${source.englishName }">${source.chineseName }</option>
							</c:forEach>
						</select>
					</label>
					<label class="lab1">
						<span>行为类型：</span>
						<select id="behaveType" name="behaveType">
							<option value="">--请选择--</option>
							<c:forEach items="${behave_type }" var="type">
								<option value="${type.englishName }">${type.chineseName }</option>
							</c:forEach>
						</select>
					</label>
				</p>
				<p>
					<label class="lab1">
						<span>接收起始时间：</span>
						<input id="recetimeAfter" name="recetimeAfter" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>接收结束时间：</span>
						<input id="recetimeBefore" name="recetimeBefore" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>发送起始时间：</span>
						<input id="sendtimeAfter" name="sendtimeAfter" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="cursor: pointer;" />
					</label>
					<label class="lab1">
						<span>发送结束时间：</span>
						<input id="sendtimeBefore" name="sendtimeBefore" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="cursor: pointer;" />
					</label> 
				</p>
				<p>
					<label class="lab1">
						<span>父流水号：</span>
						<input type="text" id="puuid" name="puuid" />
					</label>
					<label class="lab1">
						<span>到达服务器：</span>
						<select id="server" name="server">
							<option value="">--请选择--</option>
							<c:forEach items="${behave_source }" var="server">
								<option value="${server.englishName }">${server.chineseName }</option>
							</c:forEach>
						</select>
					</label>
				</p>
				<p class="p1">
					<input type="reset" value="重置" /><input type="button" value="查询" onclick="page(1)" />
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