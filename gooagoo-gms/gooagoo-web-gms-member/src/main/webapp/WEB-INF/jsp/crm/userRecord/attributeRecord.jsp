<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
 <div class="attributeFile">
              <div class="rightTitle">
                <span>${shopVo.wordNames['cpmf057']}</span>
              </div>
              <table border="0" cellpadding="0" cellspacing="1" class="attributeTable">
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf058']}</strong></td>
                <td width="550">${propertyRecord.accountTypeInfo.userId}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf059']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.email}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf060']}</strong></td>
                <td width="550"><input type="hidden" name="phyNo" value="${propertyRecord.accountTypeInfo.phyCardNo}">${propertyRecord.accountTypeInfo.phyCardNo}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf061']}</strong></td>
                <td width="550"><input type="hidden" name="scardNo" value="${propertyRecord.accountTypeInfo.cardNo}"/>${propertyRecord.accountTypeInfo.cardNo}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf062']}</strong></td>
                <td width="550">${propertyRecord.accountTypeInfo.mac}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf063']}</strong></td>
                <td width="550"></td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf064']}</strong></td>
                <td width="550">${propertyRecord.accountTypeInfo.mobile}</td>
              </tr>
            </table>
            <div class="rightTitle">
                <span>${shopVo.wordNames['cpmf065']}</span>
              </div>
              <table border="0" cellpadding="0" cellspacing="1" class="attributeTable">
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmb062']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.name}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf066']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.sex eq 'M' ? shopVo.wordNames['gmsb090']: propertyRecord.accountBaseInfo.sex eq 'F' ? shopVo.wordNames['gmsb091']:shopVo.wordNames['gmsb092']}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf067']}</strong></td>
                <td width="550"><fmt:formatDate value="${propertyRecord.accountBaseInfo.birthday}" pattern="yyyy-MM-dd"/></td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf068']}</strong></td>
                <td width="550">${empty propertyRecord.accountBaseInfo or propertyRecord.accountBaseInfo.age eq 0 ?'':propertyRecord.accountBaseInfo.age} ${not empty propertyRecord.accountBaseInfo&& propertyRecord.accountBaseInfo.age ne 0 ?shopVo.wordNames['cpmf090']:''}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf069']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.idTypeCn}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf070']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.idNo}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf071']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.telephone}</td>
              </tr>
              <tr>
                <td width="152"><strong>${shopVo.wordNames['cpmf072']}</strong></td>
                <td width="550">${propertyRecord.accountBaseInfo.address}</td>
              </tr>
            </table>
              <div style="display:${not empty propertyRecord.accountTypeInfo.phyCardNo?'block':'none'} " >
             <form action="" id="memberF">  
              <div class="rightTitle">
                <span>${shopVo.wordNames['cpmf073']}</span>
              </div>
            <div id="fspecisl" style="display: block;">
            <table border="0" cellpadding="0" cellspacing="1" class="attributeTable" id="memberSpecisl">
               <c:forEach items="${propertyRecord.memberFeatureInfoList}" var="feature">
	              <tr>
	                <td width="152"><strong><input type="hidden" name="featureCode" value="${feature.featureCode}">
	                <input type="hidden" name="featureName" value="${feature.featureName}">
	                ${feature.featureName}</strong></td>
	                <td width="550">
	                  <div id="${feature.featureCode}">${feature.featureValue}</div>
	                </td>
	              </tr>
              </c:forEach>
              <tr>
                <td width="152"><strong></strong></td>
                <td width="550">
                   <div id="etbtn" style="display: block;margin-left:450px" >
					<check:hasAuthority authorityID="2104010101"><input onclick="edit();" type="button" class="blueBtn" style="padding:4px 12px;border:0 none;cursor:pointer" value="${shopVo.wordNames['cpmf044']}" /></check:hasAuthority>
				   </div>
                <div id="sabtn" style="display: none;margin-left:450px" >
					<check:hasAuthority authorityID="2104010101"><input onclick="save();" type="button" class="blueBtn" style="padding:4px 12px;border:0 none;cursor:pointer" value="${shopVo.wordNames['cpmf035']}"/></check:hasAuthority>
				   </div>
				</td>
              </tr>
            </table>
            </div>
			</form>
			</div>
            </div>