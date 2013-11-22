<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:if test="${data != null && fn:length(data) > 0 }">
	<input type="hidden" name="count" value="${count}"/>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <th scope="col" width="15%">收货人姓名</th>
                <th scope="col" width="15%">所在地区</th>
                <th scope="col" width="20%">详细地址</th>
                <th scope="col" width="10%">邮编</th>
                <th scope="col" width="15%">电话/手机</th>
                <th scope="col" width="10%">设置</th>
                <th scope="col" width="" class="lastTh">操作</th>
            </tr>
            <c:forEach items="${data}" var="place" varStatus="status">
            <tr class="addressList">
                <td class="nameTd">${place.consigneeName}</td>
                <td>${place.provinceName}</td>
                <td>${place.address}</td>
                <td>${place.postCode}</td>
                <td>
                	<c:choose>
                		<c:when test="${place.phone eq '' || place.phone eq null}">
                			${place.telephone1}${place.telephone2}${place.telephone3}
                		</c:when>
                		<c:otherwise>
                			${place.phone}
                		</c:otherwise>
                	</c:choose>
                </td>
                <td class="setDefault">
                	<c:choose>
                		<c:when test="${place.isDefault eq 'Y'}">
		                	<span class="curr" >默认地址</span>
                		</c:when>
                		<c:otherwise>
                			<span onclick="setDefaultAddress('${place.consigneeId}',this);">设为默认</span>
                		</c:otherwise>
                	</c:choose>
                </td>
                <td class="editControl">
                <a href="javascript:void(0)" class="editBtn">修改</a><span>|</span>
                <a href="javascript:void(0)" onclick="deleteAddress('${place.consigneeId}',this)">删除</a></td>
            </tr>
            <tr class="editBox">
                <td colspan="7">
                <div class="fromWarp">
                  <form name="updateAddressForm" method="post">
                   	<input type="hidden" name="province" value="${place.provinceId}"/>
					<input type="hidden" name="city" value="${place.cityId}"/>
					<input type="hidden" name="area" value="${place.areaId}"/>
                   	<input type="hidden" name="provinceName" value="${place.provinceName}"/>
					<input type="hidden" name="cityName" value="${place.cityName}"/>
					<input type="hidden" name="areaName" value="${place.areaName}"/>
					<input type="hidden" name="isDefault" value="${place.isDefault}"/>
                   	<ul>
                       <li>
                       	<span>收货人姓名：</span>
                       	<input value="${place.consigneeName}" maxlength="20" name="consigneeName" type="text" />
                       	<span>所在地区：</span>
						   	<select name="province2" onchange="javascript: provinceChoose2(this);">
							   	<option value="">--请选择省--</option>
                           		<c:forEach var="province" items="${provincelist}">
                           			<c:choose>
                           			<c:when test="${place.provinceId == province.provinceId }">
                           			<option value="${province.provinceId }" selected="selected">${province.provinceName}</option>
                           			</c:when>
                           			<c:otherwise>
                           			<option value="${province.provinceId }">${province.provinceName}</option>
                           			</c:otherwise>
                           			</c:choose>
                           		</c:forEach>
							</select>
                           <select name="cityId2" onchange="javascript: cityChoose2(this);"></select>
	                       <select name="areaId2" onchange="javascript: areaChoose2(this);"></select>
                       </li>
                       <li>
                           <span>手机号码：</span>
                           <input value="${place.phone}" name="phone" maxlength="11" type="text" />
                           <input value="${place.consigneeId}" name="consigneeId" type="hidden" />
                           <span>电话号码：</span>
                           <input class="numInput" maxlength="4" type="text" name="telephone1" value="${place.telephone1}"/>
                           <samp>-</samp><input class="numInput2" maxlength="8" type="text" name="telephone2" value="${place.telephone2}"/>
                           <samp>-</samp><input class="numInput" type="text" maxlength="4" name="telephone3" value="${place.telephone3}"/>
                       </li>
                       <li><span>邮政编码：</span>
                       	   <input value="${place.postCode}" name="postCode" type="text" maxlength="6" style="ime-mode:disabled;" onkeyup="javascript: return ValidateNumbers(this,value);" onblur="javascript: return ValidateNumbers(this,value);"/>
                           <span>详细地址：</span>
                           <textarea name="address" maxlength="100">${place.address}</textarea>
                       </li>
                       </ul>
					<div class="saveControl">
                       	<input type="button" class="controlBtn" value="取消" />
                       	<input type="button" onclick="javascript: save('${status.count }');" value="保存" />
<!--                        	<input type="reset" value="恢复" onclick="recover(this)"/> -->
                    </div>                               
                  </form>
                 </div>
               </td>
           </tr>
           </c:forEach>
      </table>
	<%@include file="/WEB-INF/jsp/common/page.jsp"%>
</c:if>
<c:if test="${data == null || fn:length(data) <= 0 }">
		<div class="sorryPrompt" align="center">
			<samp>${message}</samp>
		</div>
</c:if>