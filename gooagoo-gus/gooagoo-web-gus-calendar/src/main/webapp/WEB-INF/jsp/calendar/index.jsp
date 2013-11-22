<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消费日历</title>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<link href="${imgPath}/gus/common/css/topBottom.css" rel="stylesheet" type="text/css" />
<link href="${imgPath}/gus/common/css/calendarPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${imgPath}/common/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${imgPath}/gus/common/js/datePage.js"></script>
<script type="text/javascript" src="${imgPath}/gus/calendar/js/show.js"></script>
</head>

<body>
	<input type="hidden" name="basePath" value="${basePath }"/>
	<input type="hidden" name="imgPath" value="${imgPath }"/>
	<input type="hidden" id="yy" value="${year}"/>
	<input type="hidden" id="mm" value="${month}"/>
	<input type="hidden" id="y" value=""/>
	<input type="hidden" id="m" value=""/>
   <!--头部-->
   <%@ include file="/WEB-INF/jsp/common/header.jsp"%>
    <!--内容-->
  <div class="container">
    <div class="article">
      <h1>消费日历</h1>
         <div class="dateTablewarp">
              <div class="dateBox">
                    <div class="changeDate">
                        <a href="javascript:void(0);" onclick="jiaM()"><span class="nextMonth"></span></a>
                        <div class="month select_date">
                        	<p id="month"></p>
                            <dl>
                            	<c:forEach begin="1" end="12" step="1" varStatus="status">
                            		<dd><a href="javascript:void(0)" onclick="onMonth('${status.index}')">${status.index}月</a></dd>
                                </c:forEach>
                            </dl>
                        </div>
                        <a href="javascript:void(0);" onclick="jianM()"><span class="prevMonth"></span></a>
                        <a href="javascript:void(0);" onclick="jiaY()"><span class="nextYear"></span></a>
                        <div class="year select_date">
                        	<p id="year"></p>
                            <dl>
                                <c:forEach begin="2011" end="2050" step="1" varStatus="status">
                            		<dd><a href="javascript:void(0)" onclick="onYear('${status.index}')">${status.index}年</a></dd>
                                </c:forEach>
                            </dl>
                        </div>
                        <a href="javascript:void(0);" onclick="jianY()"><span class="prevYear"></span></a>
                    </div>
                    <div class="dateTable">
                    	<p class="day">
                         <span>星期日</span><span>星期一</span><span>星期二</span><span>星期三</span><span>星期四</span><span>星期五</span><span>星期六</span>
                        </p>
                        <span id="calendarPic"></span>
                        <div id="calendar"></div>
                    </div>
              </div>
              <div class="dateParticulars" id="messagelist">
              	<c:set var="currentTimes" value="${fn:split(fn:substring(currentTime, 0 , 10), '-') }"></c:set>
              	<input type="hidden" id="currentDay" name="currentDay" value="${currentTimes[2] }"/>
              	<div class="title"><samp><span class="span1"></span><span class="span2"></span><span class="span3"></span></samp></p>${currentTimes[0] }年${currentTimes[1] }月${currentTimes[2] }日&nbsp;星期<c:if test="${week==1}">一</c:if><c:if test="${week==2}">二</c:if><c:if test="${week==3}">三</c:if><c:if test="${week==4}">四</c:if><c:if test="${week==5}">五</c:if><c:if test="${week==6}">六</c:if><c:if test="${week==7}">日</c:if>
              	</div>
                <div class="shopingBill">
                	<div class="ListTitle"><span class="span3"></span>购物记录</div>
                    <div class="box">
                    	<span id="showPicB" class="loading-calendar"></span>
                        <div class="boxIn" id="billList_show"></div>
                    </div>
                </div>
                <div class="actList">
                	<div class="ListTitle"><span class="span2"></span>当日活动</div>
                    <div class="box">
                    	<span id="showPicA" class="loading-calendar"></span>
                        <div class="boxIn" id="active_show"></div>
                    </div>
                </div>
                <div class="shopingSaveMsg">
                	<div class="ListTitle"><span class="span1"></span>购物清单</div>
                    <div class="box">
                    	<span id="showPicS" class="loading-calendar"></span>
                        <div class="boxIn" id="shop_show"></div>
                    </div>
                </div>
              </div>
              <div class="clear"></div>
        </div>
    </div>
  </div>
  <!--底部-->
 <c:import url="${imgPath}/gus/common/html/footer.html" charEncoding="UTF-8"></c:import>
</body>
</html>
