<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Gooagoo帐号安全登录</title>
<link
	href="http://pub.idqqimg.com/qconn/widget/pc/login/qlogin_v2.css?t=20130604"
	rel="stylesheet">
</head>
<body>
	<div class="lay_top">
		<div class="lay_top_inner" style="width: 688px;">

			<div class="lat_top_other">
				<a href="http://connect.qq.com/toc/auth_manager?from=auth"
					id="auth_manager_link" target="_blank" title="登录授权管理">授权管理</a>
			</div>
		</div>
	</div>
	<div id="combine_page" style="width: 688px;">
		<div class="page_login combine_page_children float_left border_right">
			<div class="lay_login_form">

				<iframe frameborder="0" id="ptlogin_iframe" name="ptlogin_iframe"
					src="http://localhost:8081/authorize/login" width="370"
					height="316"
					style="width: 370px; height: 316px; visibility: visible;"></iframe>

			</div>
		</div>
		<div class="page_accredit combine_page_children float_left">
			<div class="lay_main" id="lay_main">
				<div class="lay_accredit_con">

					<p class="app_site_wording">
						<a class="accredit_site" id="accredit_site_link"
							href="http://www.baidu.com/" target="_blank">测试商城</a>将获得以下权限：
					</p>
					<div class="accredit_info" id="accredit_info" style="height: 64px;">
						<ul class="accredit_info_op">
							<li class="select_all_li"><input type="checkbox"
								id="select_all" class="checkbox oauth_checkbox_all"
								hidefocus="true" checked="checked"> <label
								class="oauth_item_title" for="select_all">全选</label></li>
							<li><input name="api_choose" hidefocus="true"
								type="checkbox" class="checkbox oauth_checkbox" id="item_1010"
								value="1010" title="默认授权 不可更改" checked="" disabled=""> <label
								for="item_1010" class="oauth_item_title">访问你的详细资料</label></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>