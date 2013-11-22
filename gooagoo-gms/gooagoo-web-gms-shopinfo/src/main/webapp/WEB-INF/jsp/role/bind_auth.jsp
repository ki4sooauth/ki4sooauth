<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${shopVo.wordNames['gmsg221']}</title>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<link href="${imgPath}/gms/shopinfo/css/desk-num-poup.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${imgPath}/common/ztree/css/zTreeStyle/demo.css" type="text/css"/>
<script type="text/javascript" src="${imgPath}/common/ztree/js/jquery.ztree.exedit-3.5.js"></script>
</head>
<body>
<!--操作弹出框-->
      	  <div class="section">
          <div class="rightTitle_add title_d">
            <span>${shopVo.wordNames['gmsg221']}</span>
          </div>
</div>
<div id="editIndex" class="pop" style="width:320px;height:480px;overflow-y: hidden;overflow-x: hidden">
<!--       <div class="pop5"> -->
           <div class="pop5_nei">
             <div class="pop5_big">
<!--                   <div class="content_wrap" id="tree"><div> -->
<!-- 		             <ul id="treeDemo" class="ztree"></ul> -->
<!-- 	              </div> -->
<!--                  </div> -->
                 
                 <div class="zTreeDemoBackground left" style="float:left; " ></div>
				<ul id="treeDemo" class="ztree" style="margin-top: 0px;width: 310px;height: 400px"></ul>
			</div>
			</div>
			   <ul class="desk-num-poup" style="width:310px; padding-top: 0px;padding-left:6px;">
             <li class="commitBtn">
               <input type="button" value="${shopVo.wordNames['gmsg217']}" class="inputBtn blueBtn" style="width: 100px" onclick="javascript:parent.$.fancybox.close();" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" style="width: 100px" value="${shopVo.wordNames['gmsg222']}" id="idDisable" class="inputBtn blueBtn" onclick="update()"/>
             </li>
             </ul>
<!--              </div> -->
          
            </div>
 <a class="fancybox_pic" id="fancybox_pic" style="display: none"></a> 
</body>
	<script type="text/javascript">
	var ownAuth=${auth};
		<!--
		   var setting = {
				check: {enable: true,chkStyle: "checkbox"},
				 data: {
					simpleData: {enable: true
					}
				 }
			};
			//加载位置
			function  showParent(){
				var datas;
			      $.ajax({
				        async:false,
				        type:"POST",
				        dataType: 'json',
				        url:"${basePath}/shopRole.do?method=authorityList",
				        success:function(data){
				        	datas=data;
				       }
			      }) 
			      return datas;
			}
			var zNodes = showParent();//接收json
			var code;		
			function setCheck() {
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
			$(document).ready(function(){
				 setCheck();
				 $.each(ownAuth,function(){
					checkDefault(this);
				 });
				 
			});
			
			function checkDefault(pid){
			  var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			  var node = treeObj.getNodeByParam("id",pid, null);
			  if(node!=null && node!=undefined){
				treeObj.checkNode(node,true,false,false)
			  	openNode(treeObj,node);
			  }
			} 
			function openNode(treeObj,node){
			  if(node!=null){
				 treeObj.expandNode(node, true, false, false);
				 openNode(treeObj,node.getParentNode());
			  }else{
				 return;
			  }
			}
			
			//修改角色权限信息
			function update(){
				var roleId = "${roleId}";
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
				var nodes = treeObj.getCheckedNodes(true);
				var data = "method=updateAuthority&roleId="+roleId;
				$.each(nodes,function(){
					data+="&authority="+this.id;
				});
				$("#idDisable").attr("disabled",true);
		         $.ajax({
		               async:false,
		               type:"POST",
		               dataType: "json",
		               url:"${basePath}/shopRole.do",
		               data:data,	   
		               success:function(data){
		        	          if(data.success==true){
		        	        	  $("#idDisable").attr("disabled",false);
		        		         alert(data.message);
		        		         parent.$.fancybox.close();
		        		         page(1);
		        	           }else{
		        	        	   $("#idDisable").attr("disabled",false);
		        	     	     alert(data.message);
		        		         return false;
		        	           }
		               },
						error:function(){
							$("#idDisable").attr("disabled",false);
						}
	             }); 
		}
	</script>
</html>