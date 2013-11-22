<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/common/attribute.jsp"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gooagoo平台管理系统</title>
</head>

<frameset id="frameMain" cols="170,*" border="0" frameBorder="no" frameSpacing="0">
    <frame id="frameLeft"  name="frameLeft" src="sysuser.do?method=leftPanel&flag=<%=request.getParameter("op")%>" frameBorder="0" scrolling="no" noResize>
    <frame id="frameRight" name="frameRight" src="login.do?method=welcome" frameBorder="0" scrolling="auto" noResize>
</frameset>
</html>