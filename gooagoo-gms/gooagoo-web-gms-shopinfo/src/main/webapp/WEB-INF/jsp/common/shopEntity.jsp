<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div  ${not empty gmsLoginInfo.shopEntityId?'style="display: none"':'style="display: block"'}>
				<span >实体店：</span>
				   <select class="borderStyle select"  id="shopEntityId" name="shopEntityId">
				   <option value="">${shopVo.wordNames['gmsg134']}</option>
				   <c:forEach items="${entityList}" var="entity">
				   <option  value="${entity.shopEntityId}">${entity.shopEntityName}</option>
				   </c:forEach>
				 </select>
	</div>