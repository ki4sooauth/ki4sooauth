<%@page import="com.gooagoo.cms.utils.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gooagoo.cms.utils.Page" %>
<%
	out.println(Page.getPageContent(request,response));
%>
