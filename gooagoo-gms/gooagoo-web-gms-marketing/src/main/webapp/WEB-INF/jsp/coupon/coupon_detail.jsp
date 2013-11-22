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
<script src="${imgPath}/common/js/ajaxSubmitFile-1.0.min.js"></script>
<script type="text/javascript" src="${imgPath}/common/My97DatePicker/WdatePicker.js"></script>
<link href="${imgPath}/gms/common/css/favorableBuild.css" rel="stylesheet" type="text/css" />
<script>
 $(function(){
	
	 ctrl(); //控制代金券、折扣券
	if(!isEmpty("${couponId}")){defu();}  //修改时还原数据   	
 	clearHiddImg(); //清空隐藏input优惠券图片值 
 	if("${coupon.couponMode}"=='2'){
 		page(1);
 	}
	
});
 //第三方整合模式号段号码列表
	function page(index){
		if(isEmpty(index) || parseInt(index)<1){
			index = 1;
		}
		pIndex = index;
		var data = "&pageIndex="+index + "&pageSize=5&couponId=${coupon_Id}";
		ajaxToPageByData("${basePath}coupon.do?method=grantInfoList","fileCont1",data);
	}
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
//控制代金券还是折扣券
 function ctrl()
 {
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
		var cont = "<li><span>"+names[i];
		cont += "<input type='hidden' name='"+checkType+"Data' value='"+ids[i]+"'/>";
		cont += "<input type='hidden' name='"+checkType+"Names' value='"+names[i]+"'/></span></li>";		
		$("#couponForm #"+checkType+"Name").append(cont);	
	} 
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
</script>
</head>
<body>
   <!--内容-->
    <div class="container" style="padding:30px">
        <div class="section">
          <div class="rightTitle"><span>优惠凭证详细</span></div>
          <div class="conditions_content">
          	<div class="title">${shopVo.wordNames['gmsd059']}</div>
            <div class="shopBuild_fillout">      
            <form id="couponForm" action="${basePath }/coupon.do?method=${empty couponId ? 'create' : 'update'}" method="post" enctype ="multipart/form-data">         
            <input type="hidden" name="couponId" value="${coupon.couponId}"/>
			<input type="hidden" name="couponUrl" id="couponUrl"  value="${coupon.couponUrl}"/>
            	<div class="image_box">
                	<u style="width:180px;height:180px;">
<img id="couponImg" src="${empty coupon.couponUrl ? imgPath : ''}${empty coupon.couponUrl ? '/gms/common/images/qs180180.jpg' : coupon.couponUrl}" width="180" height="180" onclick="uploadPic();" /></u><br /><br />
                </div>
            	<ul>
                	<li><span >${shopVo.wordNames['gmsd063']}</span>${coupon.couponName}</li>
		        	<li>
		        		<span id="type">${shopVo.wordNames['gmsd064']}</span>
		             ${coupon.couponType=='C' ? "代金券" : "折扣券" }		        	
		       		</li>
		       		<li>
		        	  <span id="dj" style="display:${(coupon.couponType!='D' && coupon.couponType!='2') ? '' : 'none' }">${shopVo.wordNames['gmsd065']}</span>
		        	  <span id="zk" style="display:${coupon.couponType=='D' ? '' : 'none' }">${shopVo.wordNames['gmsd066']}</span>
		        		${coupon.couponValue}
		        	</li>
                   <li><span>${shopVo.wordNames['gmsd076']}</span>		                    
			        	${coupon.couponChannle=='0' ? "积分商城" : "" }
			            ${coupon.couponChannle=='1' ? "收藏广场" : "" }     
			            ${coupon.couponChannle=='2' ? "精确投放" : "" }                                
                    </li>
                     <li><span>优惠凭证模式</span>		               
			        ${coupon.couponMode=='0' ? "平台默认模式" : "" } 
			        ${coupon.couponMode=='1' ? "开放模式" : "" }      
			        ${coupon.couponMode=='2' ? "第三方整合模式" : "" }         
                    </li>
                    <li id="couponNoLi" style="display:${coupon.couponMode=='1' ? 'block' : 'none' }"><span>优惠凭证号段号码</span>                                        
                    ${coupon.couponNo}             
                      </li>                
                    <li><span >${shopVo.wordNames['gmsd067']}</span>${coupon.amount}</li>
                    <li><span >${shopVo.wordNames['gmsd068']}</span>${coupon.maxNumOwner}</li>
                    <li >
			        	<span >${shopVo.wordNames['gmsd069']}</span>
			        	<fmt:formatDate value="${coupon.publishStartTime}" type="both" pattern="yyyy-MM-dd" />
				       至
                       <fmt:formatDate value="${coupon.publishEndTime}" type="both" pattern="yyyy-MM-dd" />
			        </li>
			        <li >
			        	<span >${shopVo.wordNames['gmsd070']}</span>
			        	<fmt:formatDate  value="${coupon.useStartTime}" type="both" pattern="yyyy-MM-dd"/>
				        至
			        	<fmt:formatDate  value="${coupon.useEndTime}" type="both" pattern="yyyy-MM-dd" />
			        </li>                                                          
                    <li>
                    	<dl class="behavior_quality">
                        	 <dd>
                            <div class="bottom_box">
                               
                                <span >${shopVo.wordNames['gmsd072']}</span>                           
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
                                <span>${shopVo.wordNames['gmsd074']}</span>                              
                                <ul id="vipGradeName" class="tag">
                                </ul>
                            </div>
                		</dd>
                        </dl>
                    </li>                 
                    <li><span>${shopVo.wordNames['gmsd075']}</span><textarea maxlength='500' style="resize: none; overflow-y:auto;" readonly="readonly" name="couponContent">${coupon.couponContent}</textarea></li>
  
                </ul>
                </form>
            </div>
            <div style="display:${coupon.couponMode=='2'?'block': 'none'} ">      
             	<div class="title">优惠凭证号段号码列表</div>
             	<div id="fileCont1"></div>
             	</div>
          </div>         
      </div>
    </div>
</body>
</html>
