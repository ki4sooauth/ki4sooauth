<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
	<input type="hidden" name="imgPath" value="${imgPath}" />
	<input type="hidden" name="basePath" value="${basePath}" />
	<input type="hidden" name="success" value="true" />
	<input type="hidden" name="m" value="aa" />
  			<div class="BandingBox">
            	<p class="title">手机绑定</p>
                <div class="mobile">
						<div class="succeed">
                        		<span class="pictureBand"><samp>恭喜您，手机验证成功！</samp><br />
                         您可以<a href="javascript:void(0)" onclick="account()">继续绑定</a>或者<a href="javascript:void(0);" onclick="getPersoanl()">返回首页</a>。</span>               	
                        </div>
                </div>
            </div>