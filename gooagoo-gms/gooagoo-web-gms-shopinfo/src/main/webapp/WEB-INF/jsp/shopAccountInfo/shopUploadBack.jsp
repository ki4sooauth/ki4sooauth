<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${imgPath}/js/jquery-1.7.2.js"></script>
<script>
$(function(){
	(document.parentWindow || document.defaultView).parent.shopResults("${pathUrl}","${imgUrl_big}","${imgUrl_middle}","${imgUrl_small}");
})

</script>
</head>
<body>

</body>
</html>