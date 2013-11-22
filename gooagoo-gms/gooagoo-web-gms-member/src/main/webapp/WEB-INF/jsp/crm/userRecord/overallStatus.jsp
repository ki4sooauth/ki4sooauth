<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="conditions_content" style="border:none 0;background:none;">
 	<div class="title relative"  style="border:none 0;background:none;" >
   		<div class="position_add" id="position_add" style="z-index:2;width:190px;top:52px;">
       		<b class="b1">◆</b>
           	<b class="b2">◆</b>
       		<ul style="height:200px;overflow-y:scroll;">
       		   <c:forEach items="${typeList}" var="type">
   				 <li><input type="radio" name="radio" style="cursor: pointer;" onclick="getCommonlyUserStatistics(this);"  value="${type.codeType}_${type.code}" /><span>${type.name}</span></li>
   			   </c:forEach>
            </ul>
   		</div>
   		<div class="position_add" style="z-index:2;width:190px;top:52px;right:147px;" id="self_Position">
       		<b class="b1">◆</b>
           	<b class="b2">◆</b>
       		<ul style="height:200px;overflow-y:scroll;">
       		<c:forEach items="${queryCondition}" var="condition">
   				<li><u class="del">x</u><input type="radio" value="${condition.queryId}" name="radio" onclick="getCommonlyQCStatistics(this);" /><span>${condition.queryName}</span></li>
            </c:forEach>
            </ul>
   		</div>
		<div class="stampBox">
		<div style="float:left;padding:13px 0 10px 0px" class="natural_quality">
		<p>
			<span>${shopVo.wordNames['cpmf012']}</span>
			<select  name="userAnalysis">
                    <option value="ALL_USER">全部用户</option>
					<option value="IN_STORE_USER">店内用户</option>
					<option value="IN_STORE_MEMBER">店内会员</option>
					<option value="PHONE_INTERACTION_MEMBER">店外手机互动会员</option>
					<option value="WEB_INTERACTION_USER">店外Web互动用户</option>
					<option value="WEB_INTERACTION_MEMBER">店外Web互动会员</option>
					<option value="NEW_USER">新增用户</option>
					<option value="NEW_MEMBER">新增会员</option>
            </select>
		</p>
		 </div>
		<a href="javascript:void(0);" class="add_btn orangeBtn" id="add_btn" style="width:100px;margin-left: 30px;">${shopVo.wordNames['cpmf013']}</a>
		<a href="javascript:void(0);" class="add_btn orangeBtn" id="self_add" style="width:100px;margin-left: 30px;">${shopVo.wordNames['cpmf014']}</a></div>
 </div>
</div>
<div id="parentContainer">
 <div id="container" style="min-height: 408px;"></div>
<div id="hidden" style="display: none;">
  <div class="stampBox"><a href="javascript:$('#hidden').printArea();" class="orangeBtn stampBtn">${shopVo.wordNames['cpmf089']}</a></div>
        <div class="stampTitle">报告名称：购物周期分析</div>
        <div class="stampTitleSon">
          <span class="sonL">统计人：王某</span>
          <span class="sonR">统计类型：会员</span>
        </div>
        <div class="stampTitleSon">
          <span class="sonL">统计时间：2013年5月31日</span>
          <span class="sonR">统计样本数：1000</span>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="stampTable">
          <tr>
            <td>频   率</td>
            <td>一周数次</td>
            <td>一周一次</td>
            <td>一月1-2次</td>
            <td>无规律</td>
          </tr>
          <tr>
            <td>人   数</td>
            <td>500</td>
            <td>1000</td>
            <td>1500</td>
            <td>2000</td>
          </tr>
        </table>
</div>
</div> 
<a style="display: none" class="fancybox"></a>
<a style="display: none" class="fancybox_user_list" id="fancybox_user_list"></a>
<script type="text/javascript">
var cbody=true;
var clickFlag = false;
$(document).ready(function(){
	chooseActType();
	chooseActType2();
	$("#position_add input[name='radio']").eq(0).click();
	initFancyBox("fancybox",850,650,false);
	initFancyBox("fancybox_user_list",850,650,false);
});
</script>
