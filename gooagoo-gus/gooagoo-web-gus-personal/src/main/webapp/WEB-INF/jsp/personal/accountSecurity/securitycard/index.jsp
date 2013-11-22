<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<script type="text/javascript" src="${imgPath }/gus/personal/js/securityCard/securityCard.js"></script>
		<form action="" name="accountForm" id="accountForm" method="post">
		<div class="bindingSuccess">
            <P class="title">设置密保卡</P>
            <div class="content">
				序列号:<input class="userName" maxlength="16" name="serialNum" id="serialNum" type="text" />
                 <span id="yanz"><br /></span>
              	<br />
			<br />
             <div class="centerD">
             	<a class="confirm" href="javascript:void(0);" id="securityCard" style="display:block;margin-left:165px">提交</a>
              </div>
          </div>
   		</div>
        <div class="tip">
             <span class="title">密保卡停止绑定的影响</span>
             <p class="content">
                    	第一种情况：您没有使用密保卡。那么密保卡下线对您不会产生任何影响。<br />
						第二种情况：您正打算开始使用密保卡。 您可以选择XXXX来代替。<br />
						第三种情况：您正在使用密保卡。您仍可以继续使用，但为了您的帐号安全，推荐您删除密保卡，使用新型密保。
              </p>
       </div>
    </form>