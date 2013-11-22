<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>模板系统</title> 
<script>
var pIndex="${page_cur}"
$(function() {
	page(pIndex);
});

function queryChannelCode(){
	var cont = "";
	var type = $("#templateType").val();
	if("M" == type){
		cont = "<option value=\"\" selected=\"selected\">--请选择--</option>"+
			"<option value=\"Q\">购好奇</option>" +
			"<option value=\"M\">手机服务</option>" +
			"<option value=\"S\">内容模板</option>";
	}else if("W" == type){
		cont = "<option value=\"\" selected=\"selected\">--请选择--</option>"+
			"<option value=\"E\">邮件</option>" +
			"<option value=\"S\">内容模板</option>";
	}else{
		cont = "<option value=\"\" selected=\"selected\">--请选择--</option>"
	}
	$("#channelCode").html(cont);
}

</script>
</head>
<body style="min-height: 361px; cursor: auto;">
<c:choose>
<c:when test="${isType}">
	<c:choose>
	<c:when test="${isAuth}">
		<c:forEach var="item" items="${shop_login_auths}">
		<c:if test="${item.authorityId eq tem_list}">
			<c:set var="role" value="yes" />
		</c:if>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach var="item" items="${mis_login_auths}">
		<c:if test="${item.id eq tem_list}">
			<c:set var="role" value="yes" />
		</c:if>
		</c:forEach>
	</c:otherwise>
	</c:choose>
</c:when>
<c:otherwise>
	<c:set var="role" value="yes" />
</c:otherwise>
</c:choose>
<c:if test="${'yes' eq role }">
	<!--头部-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="brand">模板系统<span class="label">BETA</span></a>
				<div class="nav-collapse collapse">
					<ul class="nav" id="menu-layoutit">
						<li class="divider-vertical"></li>
						<li>
							<c:choose>
								<c:when test="${isType}">
								<c:choose>
									<c:when test="${isAuth}">
										<c:forEach var="item" items="${shop_login_auths}">
											<c:if test="${item.authorityId eq tem_phone}">
												<div class="btn-group">
													<button type="button" id="new_w" class="btn btn-primary" onclick="toInsert('M');">
														<i class="icon-edit icon-white"></i>新增手机模板
													</button>
												</div>
											</c:if>
											<c:if test="${item.authorityId eq tem_web}">
												<div class="btn-group">
													<button type="button" id="new_m" class="btn btn-primary" onclick="toInsert('W');">
														<i class="icon-edit icon-white"></i>新增网站模板
													</button>
												</div>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${mis_login_auths}">
											<c:if test="${item.id eq tem_phone}">
												<div class="btn-group">
													<button type="button" id="new_w" class="btn btn-primary" onclick="toInsert('M');">
														<i class="icon-edit icon-white"></i>新增手机模板
													</button>
												</div>
											</c:if>
											<c:if test="${item.id eq tem_web}">
												<div class="btn-group">
													<button type="button" id="new_m" class="btn btn-primary" onclick="toInsert('W');">
														<i class="icon-edit icon-white"></i>新增网站模板
													</button>
												</div>
											</c:if>
										</c:forEach>
									</c:otherwise>
								</c:choose>
								</c:when>
								<c:otherwise>
									<div class="btn-group">
										<button type="button" id="new_w" class="btn btn-primary" onclick="toInsert('M');">
											<i class="icon-edit icon-white"></i>新增手机模板
										</button>
									</div>
									<div class="btn-group">
										<button type="button" id="new_m" class="btn btn-primary" onclick="toInsert('W');">
											<i class="icon-edit icon-white"></i>新增网站模板
										</button>
									</div>
								</c:otherwise>
							</c:choose>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<!--侧边栏菜单-->
			<div class="sidebar-nav">
			<div style="margin-left: 10px">
			  <div style="height: 70px"></div>      
                                                            模板名称:
                   <input id="templateName" class="input-medium " type="text" style="width: 150px;height:30px;"/><br/>
                                                             模板类型:
                   <select id="templateType" style="width: 150px;" onchange="queryChannelCode();">
	                  <option value="" selected="selected">--请选择--</option>
	                  <c:forEach items="${template_type }" var="templatetype">
	                  	<option value="${templatetype.englishName }">${templatetype.chineseName }</option>
	                  </c:forEach>
                  </select><br/>
                                                            营销渠道:
                   <select id="channelCode" style="width: 150px;">
                   	<option value="" selected="selected">--请选择--</option>
                   	<c:forEach items="${channel_code }" var="channelcode">
                   		<option value="${channelcode.englishName }">${channelcode.chineseName }</option>
					</c:forEach>
                   	</select><br/>
                                                       授权方式:
                    <select id="authorization" style="width: 150px;">
	                  <option value="" selected="selected">--请选择--</option>
	                  <option value="W">可修改</option>
	                  <option value="R">仅限使用</option>
                  </select><br/>
                                                          模板费用:<br/>
                    <input id="minPrice" class="input-medium " type="text" style="width: 70px;height: 30px"/>          
                    <b>-</b>
                    <input id="maxPrice" class="input-medium " type="text" style="width: 70px;height: 30px"/>                     
                     <div style="height: 30px"></div>   
                    <input onclick="page(1);" class="input-medium search-query btn-primary" type="button" value="查询"/>
                    <input onclick="clealCondition();" class="input-medium search-query btn-primary" type="button" value="清空"/>
			  </div>
		  </div>
	  </div>
	</div>
	<!--内容-->
	<div class="demo ui-sortable" style="min-height: 0px;">
		<div class="box box-element ui-draggable" style="margin-right: 10px;margin-left:10px">
			<div class="view" >
				<div class="page-header">
					<h2>
						<small>模板列表</small>
					</h2>
				</div>
				<div id="cont"></div>	
			</div>
		</div>
	</div>
</c:if>
</body>
</html>