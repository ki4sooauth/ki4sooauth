<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<table id="table" class="table table-bordered" contenteditable="false">
	<!--带border table-bordered -->
	<thead>
		<tr>
			<th>序号</th>
			<th>模板名称</th>
			<th>模板描述</th>
			<th>营销渠道</th>
			<th>模板类型</th>
			<th>费用（元）</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="tbody">
		<c:if test="${not empty pm.result}"> 
		<c:forEach var="itemChild" items="${pm.result}" varStatus="xh">
		<c:if test="${(xh.count+(page_cur-1)*pm.pageSize)%2==0}">
		<tr class="success">
			<td>${xh.count+(page_cur-1)*pm.pageSize}</td> 
			<td>${itemChild.templateName}</td>
			<td>${itemChild.templateDescription}</td>
			<td>
			<c:forEach items="${channel_code }" var="channelcode">
				<c:if test="${channelcode.englishName == itemChild.channelCode}">
				${channelcode.chineseName }
				</c:if>
			</c:forEach>
			</td>
			<td>
			<c:forEach items="${template_type }" var="templatetype">
				<c:if test="${templatetype.englishName == itemChild.templateType}">
				${templatetype.chineseName }
				</c:if>
			</c:forEach>
			</td> 
			<td>
			<c:choose>
            <c:when test="${itemChild.price == 0}">免费</c:when>
            <c:otherwise>￥${itemChild.price}</c:otherwise>
            </c:choose>
			</td> 
			<td>
				<button class="btn btn-mini btn-info" onclick="yulan('${itemChild.templateId}')">预览</button>&nbsp;
				<c:choose>
					<c:when test="${isType}">
						<c:choose>
							<c:when test="${isAuth}">
								<c:forEach var="item" items="${shop_login_auths}">
									<c:if test="${item.authorityId eq tem_quote}">
										<c:if test="${itemChild.authorization=='W'&&(itemChild.userType!=loginType||itemChild.userId!=loginName)}">
						                	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','y')">引用</button>&nbsp; 
						             	</c:if>
						            </c:if>
						             <c:if test="${item.authorityId eq tem_update}">
						             	<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
							               	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','u')">编辑</button>&nbsp;                         
						             	</c:if>
									</c:if>
									<c:if test="${item.authorityId eq tem_delete}">
										<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
						             		<button class="btn btn-mini btn-info" onclick="deleteTpl('${itemChild.templateId}')" >删除</button>
										</c:if>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${mis_login_auths}">
									<c:if test="${item.id eq tem_quote}">
										<c:if test="${itemChild.authorization=='W'&&(itemChild.userType!=loginType||itemChild.userId!=loginName)}">
						                	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','y')">引用</button>&nbsp; 
						             	</c:if>
						            </c:if>
						             <c:if test="${item.id eq tem_update}">
						             	<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
							               	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','u')">编辑</button>&nbsp;                         
						             	</c:if>
									</c:if>
									<c:if test="${item.id eq tem_delete}">
										<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
						             		<button class="btn btn-mini btn-info" onclick="deleteTpl('${itemChild.templateId}')" >删除</button>
										</c:if>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:if test="${itemChild.authorization=='W'&&(itemChild.userType!=loginType || itemChild.userId!=loginName)}">
		                	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','y')">引用</button>&nbsp; 
		             	</c:if>
		             	<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">          
			               	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','u')">编辑</button>&nbsp;                         
			               	<button class="btn btn-mini btn-info" onclick="deleteTpl('${itemChild.templateId}')" >删除</button>            
		             	</c:if>
					</c:otherwise>
				</c:choose>
			</td>    
		</tr>
		</c:if>
       	<c:if test="${(xh.count+(page_cur-1)*pm.pageSize)%2!=0}">
       	<tr class="info">
			<td>${xh.count+(page_cur-1)*pm.pageSize}</td>
            <td>${itemChild.templateName}</td>
            <td>${itemChild.templateDescription}</td>
            <td>
            <c:forEach items="${channel_code }" var="channelcode">
				<c:if test="${channelcode.englishName == itemChild.channelCode}">
				${channelcode.chineseName }
				</c:if>
			</c:forEach>
            </td>
            <td>
            <c:forEach items="${template_type }" var="templatetype">
				<c:if test="${templatetype.englishName == itemChild.templateType}">
				${templatetype.chineseName }
				</c:if>
			</c:forEach>
            </td> 
            <td>
            <c:choose>
            <c:when test="${itemChild.price == 0}">免费</c:when>
            <c:otherwise>￥${itemChild.price}</c:otherwise>
            </c:choose>
            </td>
            <td>
				<button class="btn btn-mini btn-info" onclick="yulan('${itemChild.templateId}')">预览</button>&nbsp;          
             	<c:choose>
					<c:when test="${isType}">
						<c:choose>
							<c:when test="${isAuth}">
								<c:forEach var="item" items="${shop_login_auths}">
									<c:if test="${item.authorityId eq tem_quote}">
										<c:if test="${itemChild.authorization=='W'&&(itemChild.userType!=loginType||itemChild.userId!=loginName)}">
						                	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','y')">引用</button>&nbsp; 
						             	</c:if>
						            </c:if>
						            <c:if test="${item.authorityId eq tem_update}">
						             	<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
							               	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','u')">编辑</button>&nbsp;                         
						             	</c:if>
									</c:if>
									<c:if test="${item.authorityId eq tem_delete}">
										<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
						             		<button class="btn btn-mini btn-info" onclick="deleteTpl('${itemChild.templateId}')" >删除</button>
										</c:if>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${mis_login_auths}">
									<c:if test="${item.id eq tem_quote}">
										<c:if test="${itemChild.authorization=='W'&&(itemChild.userType!=loginType||itemChild.userId!=loginName)}">
						                	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','y')">引用</button>&nbsp; 
						             	</c:if>
						            </c:if>
						            <c:if test="${item.id eq tem_update}">
						             	<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
							               	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','u')">编辑</button>&nbsp;                         
						             	</c:if>
									</c:if>
									<c:if test="${item.id eq tem_delete}">
										<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">
						             		<button class="btn btn-mini btn-info" onclick="deleteTpl('${itemChild.templateId}')" >删除</button>
										</c:if>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<c:if test="${itemChild.authorization=='W'&&(itemChild.userType!=loginType||itemChild.userId!=loginName)}">
		                	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','y')">引用</button>&nbsp; 
		             	</c:if>
		             	<c:if test="${itemChild.userType==loginType&&itemChild.userId==loginName}">          
			               	<button class="btn btn-mini btn-info" onclick="toEdit('${itemChild.templateId}','${itemChild.templateType}','u')">编辑</button>&nbsp;                         
			               	<button class="btn btn-mini btn-info" onclick="deleteTpl('${itemChild.templateId}')" >删除</button>            
		             	</c:if>
					</c:otherwise>
				</c:choose>
			</td> 
		</tr>
		</c:if>  
		</c:forEach>
		<tr>	   	
			<td colspan="7">
				<%@include file="/WEB-INF/jsp/common/page.jsp"%>
			</td>
		</tr>
		</c:if>
		<c:if test="${empty pm.result}">
		<tr style="height: 30px;" class="warning">
			<td colspan="7" align="center"><strong>暂无模板信息</strong></td>
		</tr>
		</c:if>	
	</tbody>
</table>