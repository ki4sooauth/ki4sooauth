<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ page session="false"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/hasAuthority.tld" prefix="check"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Highcharts Example</title>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.get("${basePath}statistics.do?method=graph&content=123", function(data) {
			 alert(data);
			 eval("$('#container').highcharts("+data+")");
		});
	});
</script>
</head>
<body>
	<script src="http://img.gooagoo.com/common/hightCharts/highcharts.js"></script>
	<script
		src="http://img.gooagoo.com/common/hightCharts/modules/exporting.js"></script>

	<div id="container"
		style="min-width: 400px; height: 400px; margin: 0 auto"></div>
</body>
</html>
