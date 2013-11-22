<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="conditions_content" style="border:none 0;background:none;">
 	<div class="title relative"  style="border:none 0;background:none;" >
   		<div class="position_add" id="position_add" style="z-index:2;width:190px;top:52px;">
       		<b class="b1">◆</b>
           	<b class="b2">◆</b>
       		<ul style="height:200px;overflow-y:scroll;">
   				<li><input type="radio" name="radio" onclick="familyRole();"/><span>用户家庭角色分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>用户家庭结构分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>用户消费层次分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>购物时间特征分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>店内行为涞源分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>用户品类消费特征</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>消费类别分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>用户家庭消费分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>用户家庭消费品类分析</span></li>
   				<li><input type="radio" name="radio" onclick=""/><span>购物周期分析</span></li>
            </ul>
   		</div>
   		
		<div class="stampBox">
		<div style="float:left;padding:13px 0 10px 0px" class="natural_quality">
		<p>
			<span>${shopVo.wordNames['cpmf012']}</span>
			<select  name="userAnalysis">
               	<option value="TOTAL_UC_">总用户</option>
           		<option value="TOTAL_MC_">总会员</option>
           		<option value="VISIT_UC_">到访用户</option>
           		<option value="VISIT_UC_">到访会员</option>
           		<option value="ADD_UC_">新增用户</option>
           		<option value="ADD_MC_">新增会员</option>
            </select>
		</p>
		 </div>
		<a href="javascript:void(0);" class="add_btn orangeBtn" id="add_btn" style="width:100px;margin-left: 30px;">${shopVo.wordNames['cpmf013']}</a>
				
		</div>
 </div>
</div>
<div id="parentContainer">
 <div id="container" style="min-height: 408px;"></div>
  <div class="stampBox"><a href="" class="orangeBtn stampBtn">${shopVo.wordNames['cpmf089']}</a></div>
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
<a style="display: none" class="fancybox"></a>
<script type="text/javascript">
var cbody=true;
var type="";
var name="";
var clickFlag = false;
$(document).ready(function(){
	chooseActType();
	chooseActType2();
	$("input[name='radio']").eq(0).click();
	initFancyBox("fancybox",850,550,false);
});
</script>
