<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%
request.setAttribute("topMenuCode", "13");
request.setAttribute("leftMenuCode", "1301");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${shopVo.wordNames['gmsd058']}</title>
<%@ include file="/WEB-INF/jsp/common/inc.jsp"%>
<%@ include file="/WEB-INF/jsp/common/fancybox.jsp"%>
<script src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<link href="${imgPath}/gms/common/css/favorableBuild.css" rel="stylesheet" type="text/css" />
<script>
 $(function(){	 
 	clearHiddImg(); //清空隐藏input优惠券图片值 
	initFancyBox1(); //弹出框(列表)
    initFancyBox("fancybox_couponPic",800,600,true); 	//图片上传
	initFancyBox("fancybox_category",800,600,true);   //弹出框品类
	ctrl(); //控制代金券、折扣券
	if(!isEmpty("${couponId}")){
		defu();
		}  //修改时还原数据   	
});
 
//全局变量 标记弹出类型
 var flag="";
 var checkType = "";
//判断弹出类型
 function judge(flag){
 	if(flag=="J"){
 		checkType = "category";
	}else if(flag=="E"){
 		checkType = "shopEntity";
	}else if(flag=="D"){
 		checkType = "vipGrade";
	}
 }

 function ctrl()
 {
	 	//控制优惠凭证号段号码 		 	
	 	$("select[name='couponMode']").click(function(){
	 		if($(this).val()==''||$(this).val()=='0'||$(this).val()=='2'){//默认模式||第三方整合模式
				$("#couponNoLi").hide();
				if(isEmpty("${couponId}")){
					$("#couponNo").val("");
					}  
				
	 		}else if($(this).val()=='1'){//开发模式
	 			$("#couponNoLi").show();
	 			//var cont ="<li><input type='text' name='couponNo' value=''/></li>";
				// $("#couponForm #couponNoUl").html(cont);	
	 	    }
	 	});
	//控制代金券还是折扣券
	 	$("select[name='couponType']").click(function(){
	 		if($(this).val()=='D'){//C-代金券，D-折扣券
				$("#couponForm input[name=couponValue]").val("");
				$("#dj").hide();
	 			$("#zk").show();
	 		}else if($(this).val()=='C'){
	 			$("#couponForm input[name=couponValue]").val("");
	 			$("#zk").hide();
	 			$("#dj").show();
	 	    }		
	 	});	
 }
 /**
       图片上传
 */
 function uploadPic(){
		var imgUrl= $("#couponImg").attr("src");
		$("#fancybox_pic").attr("href","upload.do?method=toTrimImage&src="+imgUrl+"&tsize=b_572_572&tsize=m_260_260&tsize=s_90_90").click();
	}
	function uploadDone(src){
		closeFancyBox();
		var width=$("#couponImg").width();
		var heigth=$("#couponImg").height();
		var tsize=[width,heigth];
			$("#couponUrl").val(src);
			$("#couponImg").attr("src",src);
			$("#couponImg").attr("tsize",tsize);
	}
//清空隐藏input优惠券图片值 
 function clearHiddImg(){
	 	var imgUrl= $("#couponImg").attr("src");
	 	if(imgUrl=="" || imgUrl==null){
	 		$("#couponUrl").val("");
	
	 	}
 }
	 
//弹出框(会员等级、实体店列表)
function initFancyBox1(){
	$(".fancybox_list").fancybox({
		'width'				:870,
		'height'			: 550,
		'padding'			: 0,
		'autoScale'			: true,
		'autoDimensions'    : true,
		'transitionIn'		: 'yes',
		'transitionOut'		: 'yes',
		'href'				: $(this).attr('href'),
		'type'				:'iframe',
		'hideOnOverlayClick': false,
		'showCloseButton':true
	});
}
//保存数据
function saveCoupon(formUrlType){
	$(".savebtnS").attr("disabled","disabled");
	var amount = $("#couponForm input[name=amount]").val();
	var maxNumOwner = $("#couponForm input[name=maxNumOwner]").val();
	var couponType = $('#couponForm select[name=couponType] option:selected').val();
	var couponName = $("#couponForm input[name=couponName]").val();
	var publishStartTime = $("#couponForm input[name=publishStartTime]").val();
	var publishEndTime = $("#couponForm input[name=publishEndTime]").val();
	var useStartTime = $("#couponForm input[name=useStartTime]").val();
	var useEndTime = $("#couponForm input[name=useEndTime]").val();
	var couponUrl = $("#couponForm input[name=couponUrl]").val();
	var couponContent = $("#couponForm textarea[name=couponContent]").val();
	var couponValue = $("#couponForm input[name=couponValue]").val();
	var couponChannle=$('#couponForm select[name=couponChannle] option:selected').val();
	var couponMode=$('#couponForm select[name=couponMode] option:selected').val();
	
	if(isEmpty(couponName)){
    	removeDisable();
    	alert("优惠凭证名称不能为空");
    	return false;
    }
    if(isEmpty(couponType)){
    	removeDisable();
    	alert("请选择优惠凭证种类");
    	return false;
    }
    if(couponType=="C" && isEmpty(couponValue)){
    	removeDisable();
    	alert("优惠代金金额不能为空");
    	return false;
    }else if(couponType=="C" && !isEmpty(couponValue) &&!checkdouble(couponValue)){
    	removeDisable();
    	alert("优惠代金金额应输入数值");
    	return false;
    }
    if(couponType=="D" && isEmpty(couponValue)){
    	removeDisable();
    	alert("优惠折扣率不能为空");
    	return false;
    }else  if(couponType=="D" && !isEmpty(couponValue)){
    	if(!checkdouble(couponValue)){
    		removeDisable();
    		alert("优惠折扣率应输入数值");
    		return false;
    	}
    	if(parseFloat(couponValue)>=1){
    		removeDisable();
    		alert("优惠折扣率应为小于1");
    		return false;
    	}
    }
    if(isEmpty(amount)){
    	removeDisable();
    	alert("优惠凭证发放数量不能为空");
    	return false;
    }else{
    	if(!checkInt(amount)||amount<=0){
    		removeDisable();
    	   alert("优惠凭证发放数量应输入正整数"); 
    	   return false;
    	}
    }
    if(isEmpty(maxNumOwner)){
    	removeDisable();
    	alert("个人拥有数量不能为空");
    	return false;
    }else{
    	if(!checkInt(maxNumOwner)||maxNumOwner<=0){
    		removeDisable();
    	   alert("个人拥有数量应输入正整数"); 
    	   return false;
    	}
    }
    if(maxNumOwner-amount>0){
    	removeDisable();
 	   alert("优惠凭证发放数量不能小于个人拥有数量"); 
 	   return false;
    }
    var curDate="${date}";
    curDate=curDate.replace(/-/g,"/");
   
    publishStartTime=publishStartTime.replace(/-/g,"/");
    publishEndTime=publishEndTime.replace(/-/g,"/");
    
    if(isEmpty(publishStartTime)){
    	removeDisable();
    	alert("优惠凭证发行的开始日期不能为空");
    	return false;
    }
    
    if(Date.parse(curDate)-Date.parse(publishStartTime)>0){
    	removeDisable();
    	alert("优惠凭证发行开始日期不能小于当前日期");
    	return false;
    }
    
    if(isEmpty(publishEndTime)){
    	removeDisable();
    	alert("优惠凭证发行的截止日期不能为空");
    	return false;
    }
    if(Date.parse(publishStartTime)-Date.parse(publishEndTime)>0){
    	removeDisable();
    	alert("优惠凭证发行截止日期不能小于优惠凭证发行开始日期");
    	return false;
    }
    useStartTime=useStartTime.replace(/-/g,"/");
    useEndTime=useEndTime.replace(/-/g,"/");
    if(isEmpty(useStartTime)){
    	removeDisable();
    	alert("优惠凭证使用生效日期不能为空");
    	return false;
    }
    if(Date.parse(publishStartTime)-Date.parse(useStartTime)>0){
    	removeDisable();
    	alert("优惠凭证使用生效日期不能小于优惠凭证发行开始日期");
    	return false;
    }
    if(isEmpty(useEndTime)){
    	removeDisable();
    	alert("优惠凭证使用截止日期不能为空");
    	return false;
    }
    
    if(Date.parse(useStartTime)-Date.parse(useEndTime)>0){
    	removeDisable();
    	alert("优惠凭证使用截止日期不能小于优惠凭证使用生效日期");
    	return false;
    }
    if(isEmpty(couponContent)){
    	removeDisable();
    	alert("优惠详情不能为空");
    	return false;
    }
    
    if(isEmpty(couponUrl)){
    	removeDisable();
    	alert("优惠凭证图片不能为空");
    	return false;
    }
    if(isEmpty(couponChannle)){
    	removeDisable();
    	alert("请选择优惠凭证发布渠道");
    	return false;
    }
    if(isEmpty(couponMode)){
    	removeDisable();
    	alert("请选择优惠凭证模式");
    	return false;
    }
   
	var data =$("#couponForm").serialize();
    var url = "${basePath}coupon.do?method=${empty couponId ? 'create' : 'update'}" ;
	$.ajax({
		type: "POST",
		async: false,
		url:url,
		data:data,
		dataType: "json",
			success: function(data) {
				removeDisable();	
				if(data.success) {			
					alert(data.message);			
					location.replace("${basePath}coupon.do?method=index");			
				}else{
					alert(data.message);	
				}
		}
	});
}

function checkdouble(value){
	var reg2 = new RegExp("^[0-9]*$");
	var reg=/^[0-9]*\.?[0-9]*$/;
    return	(reg.test(value) ||reg2.test(value));
}

function checkInt(value){
	var reg2 = new RegExp("^[0-9]*$");
	return reg2.test(value);
}

function addFancy(flag){
	var id="";
	if(flag=="J"){
		id="category_list";
	}else if(flag=="E"){
		id="shopEntity_list";
	}else if(flag=="G"){
		id="cardLvl_list";
	}
	$("#"+id).click();
}
//返回数据 向页面输出HTML
function addIng(relateIds,relateNames,flag){
	var ids = relateIds;
	var names = relateNames;
	judge(flag);	
	for(var i=0;i<ids.length;i++){
		if(isEmpty(ids[i])){
			continue;
		}
		var cont = "<li><span>"+names[i]+"<b onclick='deleteRelate(this);'>x</b>";
		cont += "<input type='hidden' name='"+checkType+"Data' value='"+ids[i]+"'/>";
		cont += "<input type='hidden' name='"+checkType+"Names' value='"+names[i]+"'/></span></li>";		
		$("#couponForm #"+checkType+"Name").append(cont);	
	} 
	
     $.fancybox.close();
}

//点击X时  清空input
function deleteRelate(obj){
	$(obj).parent().parent().remove();
}

//修改时 还原数据
function defu(){
	var json = ${empty coupon.checkJson ? "''" : coupon.checkJson};
	if(isEmpty(json)){
		return false;
	}
	var cgNames =json.categoryNames;
	var sENames =json.shopEntityNames;
	var vGNames =json.vipGradeNames;
	var cgData =json.categoryData;
	var sEData =json.shopEntityData;
	var vGData =json.vipGradeData;
	
		if(!isEmpty(cgData)){	
			addIng(cgData,cgNames,"J");
		}
		if(!isEmpty(sEData)){		
			addIng(sEData,sENames,"E");
		}
		if(!isEmpty(vGData)){		
			addIng(vGData,vGNames,"D");
		}
														
}
//保存按钮从disable还原
function removeDisable(){
	$(".savebtnS").attr("disabled",false);
}

//弹出层返回数据
function dealRelations(relations){
	 for(var i=0;i<relations.length;i++){
		if(!isEmpty(relations[i])){
			 flag=relations[i][0];	  
			   judge(flag);//判断
			   var cont = "<li><span>"+relations[i][2]+"<b onclick='deleteRelate(this);'>x</b>";
			   cont += "<input type='hidden'  name='"+checkType+"Data' value='"+relations[i][1]+"'/>";
			   cont += "<input type='hidden'  name='"+checkType+"Names' value='"+relations[i][2]+"'/></span></li>";		
			   $("#couponForm #"+checkType+"Name").append(cont);	
		}
		  	
	 }
	 $.fancybox.close();
}

</script>
</head>

<body>
   <!--头部-->
    <%@ include file="/WEB-INF/jsp/common/head.jsp"%> 
    <div style="display:none;">
	 <a href="#" id="fancybox_pic" class="fancybox_couponPic"></a>
    </div>
	<div style="display:none;">
	 <a href="${basePath }/relation.do?method=listRelation&selectType=M&relateType=J" id="category_list" class="fancybox_category"></a>
	</div>
	<div style="display:none;">
	 <a href="${basePath }/relation.do?method=listRelation&selectType=M&relateType=E" id="shopEntity_list" class="fancybox_list"></a>
	</div>
	<div style="display:none;">
	 <a href="${basePath }/relation.do?method=listRelation&selectType=M&relateType=D" id="cardLvl_list" class="fancybox_list"></a>
	</div>
   <!--内容-->
    <div class="container">
      <div class="article">
<%@ include file="/WEB-INF/jsp/common/left.jsp"%> 
        <div class="section">
          <div class="rightTitle"><span>${empty coupon.couponId ? shopVo.wordNames['gmsd060']:shopVo.wordNames['gmsd061']}</span></div>
          <div class="conditions_content">
          	<div class="title">${shopVo.wordNames['gmsd059']}</div>
            <div class="shopBuild_fillout">      
            <form id="couponForm" action="${basePath }/coupon.do?method=${empty couponId ? 'create' : 'update'}" method="post" enctype ="multipart/form-data">         
            <input type="hidden" name="couponId" value="${coupon.couponId}"/>
			<input type="hidden" name="couponUrl" id="couponUrl"  value="${coupon.couponUrl}"/>
            <input type="hidden" class="longInput" name="couponSource" value="${coupon.couponSource}"/>	
            	<div class="image_box">
                	<u style="width:180px;height:180px;">
          <img id="couponImg" src="${empty coupon.couponUrl ? imgPath : ''}${empty coupon.couponUrl ? '/gms/common/images/qs180180.jpg' : coupon.couponUrl}" width="180" height="180" onclick="uploadPic();" /></u><br /><br />
                    <a href="javascript:uploadPic();" class="blueBtn">${shopVo.wordNames['gmsd062']}</a>
                </div>
            	<ul>
                	<li><span >${shopVo.wordNames['gmsd063']}</span><input type="text" class="longInput" name="couponName" value="${coupon.couponName}"/>               	
                	</li>
		        	<li >
		        		<span id="type">${shopVo.wordNames['gmsd064']}</span>
		             <select name="couponType">
	        	       <option value="" ${coupon.couponType=='' ? "selected" : "" } >-${shopVo.wordNames['gmsd088']}-</option>
	        	       <option value="C" ${coupon.couponType=='C' ? "selected" : "" } >代金券</option>
	                   <option value="D" ${coupon.couponType=='D' ? "selected" : "" } >折扣券</option>       
	                </select>			        	
		       		</li>
		       	 <li>
		        	  <span id="dj" style="display:${(coupon.couponType!='D' && coupon.couponType!='2') ? '' : 'none' }">${shopVo.wordNames['gmsd065']}</span>
		        	  <span id="zk" style="display:${coupon.couponType=='D' ? '' : 'none' }">${shopVo.wordNames['gmsd066']}</span>
		        		<input type="text"  name="couponValue" value="${coupon.couponValue}"/>
		        	</li>
                      <li><span>${shopVo.wordNames['gmsd076']}</span>
		               <select name="couponChannle" >	
		                <option  value="" ${coupon.couponChannle=='' ? "selected" : "" } >-${shopVo.wordNames['gmsd088']}-</option>   
			        	<option  value="0" ${coupon.couponChannle=='0' ? "selected" : "" } >积分商城</option>
			            <option  value="1" ${coupon.couponChannle=='1' ? "selected" : "" } >收藏广场</option>       
			            <option  value="2" ${coupon.couponChannle=='2' ? "selected" : "" } >精确投放</option>       
			          </select>                   
                    </li>
                    <li><span>优惠凭证模式</span>
		               <select name="couponMode" >
		                <option  value="" ${coupon.couponMode=='' ? "selected" : "" } >-${shopVo.wordNames['gmsd088']}-</option> 	      
			        	<option  value="0" ${coupon.couponMode=='0' ? "selected" : "" } >平台默认模式</option>
			            <option  value="1" ${coupon.couponMode=='1' ? "selected" : "" } >开放模式</option>       
			            <option  value="2" ${coupon.couponMode=='2' ? "selected" : "" } >第三方整合模式</option>       
			          </select>  		                           
                    </li>                                
                   <li id="couponNoLi" style="display:${coupon.couponMode=='1' ? 'block' : 'none' }"><span>优惠凭证号段号码</span>                                        
                  <input type="text" id="couponNo" name="couponNo" value="${coupon.couponNo}"/>              
                      </li>    
                    <li><span >${shopVo.wordNames['gmsd067']}</span><input type="text" name="amount" value="${coupon.amount}"/></li>
                    <li><span >${shopVo.wordNames['gmsd068']}</span><input type="text" name="maxNumOwner" value="${coupon.maxNumOwner}"/></li>
                    <li>
			        	<span>${shopVo.wordNames['gmsd069']}</span>
			        	<input type="text" class="date" name="publishStartTime" value="<fmt:formatDate value="${coupon.publishStartTime}" type="both" pattern="yyyy-MM-dd" />" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
				       <b>-</b>
				        <input type="text" class="date" name="publishEndTime" value="<fmt:formatDate value="${coupon.publishEndTime}" type="both" pattern="yyyy-MM-dd" />" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			        </li>
			        <li >
			        	<span >${shopVo.wordNames['gmsd070']}</span>
			        	<input type="text" class="date" name="useStartTime" value="<fmt:formatDate  value="${coupon.useStartTime}" type="both" pattern="yyyy-MM-dd" />" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
				        <b>-</b>
			        	<input type="text" class="date" name="useEndTime" value="<fmt:formatDate  value="${coupon.useEndTime}" type="both" pattern="yyyy-MM-dd" />" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			        </li>                                                          
                    <li>
                    	<dl class="behavior_quality">
                        	 <dd>
                            <div class="bottom_box">
                                <a href="javascript:addFancy('J');" class="add">${shopVo.wordNames['gmsd071']}</a>
                                <span>${shopVo.wordNames['gmsd072']}</span>                           
                                <ul id="categoryName" class="tag">
                                </ul>
                            </div>
                		</dd>
                        </dl>
                    </li>
                    <li >
                    	<dl class="behavior_quality">
                        	 <dd>
                            <div class="bottom_box">
                                <a href="javascript:addFancy('E');" class="add">${shopVo.wordNames['gmsd071']}</a>
                             <span>${shopVo.wordNames['gmsd073']}</span>                           
                                <ul id="shopEntityName" class="tag">
                                </ul>
                            </div>
                		</dd>
                        </dl>
                    </li>
                     <li >
                    	<dl class="behavior_quality">
                        	 <dd>
                            <div class="bottom_box">
                                <a href="javascript:addFancy('G');" class="add">${shopVo.wordNames['gmsd071']}</a>
                                <span>${shopVo.wordNames['gmsd074']}</span>                              
                                <ul id="vipGradeName" class="tag">
                                </ul>
                            </div>
                		</dd>
                        </dl>
                    </li>  
                    <li><span>${shopVo.wordNames['gmsd075']}</span><textarea maxlength='500' style="resize: none; overflow-y:auto;" name="couponContent">${coupon.couponContent}</textarea></li>

                </ul>
                <a href="javascript:void(0)" class="savebtnS blueBtn" onclick="saveCoupon(${empty coupon.couponId ? 1 : 0});">${shopVo.wordNames['gmsd077']}</a>
                </form>
            </div>
          </div>
      </div>
    </div>
    </div>
</body>
</html>
