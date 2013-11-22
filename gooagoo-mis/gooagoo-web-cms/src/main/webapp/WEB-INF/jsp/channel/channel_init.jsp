<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始化页面</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<style>
	.initialize{text-align:center;line-height:20px;padding:200px 0;font-size:14px;}
	.initialize .btn_i{display:block;margin:0 auto;margin-bottom:20px;background:#42748b;color:#fff;width:176px;height:39px;line-height:39px;text-align:center;font-size:14px;}
</style>
<script type="text/javascript">
	function channelInit(){
		$.ajax({
	        type: "POST",
	        async: false,
	        url: "${basePath}cmsContent.do?method=initRoot",
	        dataType: "json",
	        success: function(ret){
            	alert(ret.message);
	        	if(ret.success){
	    			window.location.reload(); 
	            }else{
	        		$(".savebtn").attr("disabled",false);
	            }
	        }
	  	});
	}
</script>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/WEB-INF/jsp/common/head.jsp"%>
	<!-- 主体 -->
	<div class="middle_box">
		<!-- 内容 -->	
		<div class="M_right" style="float: right;">
       		<div class="control_box">
           		<div class="selectCard">
            		<a class="curr" href="#">栏目</a>
            	</div>
       		</div>
    	  	<div class="content">
          		<div class="initialize">
            		<a class="btn_i" href="#" onclick="channelInit();">初始化数据</a>
                    CMS系统未初始化，请点击上方按钮<br />进行栏目初始化
            	</div>
			</div>
    	</div>
		<!-- 左菜单 -->
		<div class="M_left">
			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
		</div>
	</div>
</body>
</html>