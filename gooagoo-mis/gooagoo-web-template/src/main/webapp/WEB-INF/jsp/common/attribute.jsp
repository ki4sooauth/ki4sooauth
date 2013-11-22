<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.gooagoo.cache.MisConfigCache" %>
<%
request.setAttribute("imgPath", MisConfigCache.get("html_url"));
request.setAttribute("passport", MisConfigCache.get("passport_url"));
request.setAttribute("ajax", MisConfigCache.get("ajax_url"));
request.setAttribute("basePath", request.getContextPath());
%>
<script type="text/javascript">
var imgPath = "${imgPath}";
var passport = "${passport}";
var ajax = "${ajax}";
</script>