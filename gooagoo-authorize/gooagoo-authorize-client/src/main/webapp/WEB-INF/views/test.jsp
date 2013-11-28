<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录测试</title>
<body>
	<form id="formlogin" method="post" onsubmit="return false;">
		<span>测试用户名</span>
		<div>
			<input type="text" name="loginname" tabindex="1">
		</div>
		<span>测试密码</span>
		<div>
			<input type="password" name="nloginpwd" tabindex="2">
		</div>
		</p>
		<label> 使用合作网站账号登录： </br> <a href="javascript:void(0)"
			onclick="window.location=&#39;http://localhost:8081/authorize/ologin&#39;+window.location.search;return false;"><img
				src="http://qzonestyle.gtimg.cn/qzone/vas/opensns/res/img/Connect_logo_3.png"
				alt="Connect_logo_3.png"></a>
		</label>
	</form>
</body>
</html>