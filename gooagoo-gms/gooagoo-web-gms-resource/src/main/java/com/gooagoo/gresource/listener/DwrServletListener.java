package com.gooagoo.gresource.listener;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.proxy.dwr.Util;
import org.springframework.util.CollectionUtils;

public class DwrServletListener implements ServletRequestListener {

	private boolean taskIsRun = true;
	private Timer timer = null;

	@Override
	public void requestDestroyed(ServletRequestEvent req) {
		HttpServletRequest request = (HttpServletRequest) req.getServletRequest();
		ServletContext servletContext = req.getServletContext();
		String uriStr = request.getRequestURI();
		String queryStr = request.getQueryString();
		final ServerContext serverContext = ServerContextFactory.get(servletContext);
		if (uriStr.endsWith("auction.do") && "method=auction".equals(queryStr)) {
			Object obj = request.getAttribute("auctionResult");
			if (obj!=null && (Boolean)obj) {
				timer.cancel();
				timer = new Timer();
				taskIsRun = false;
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						pushMsg(serverContext);
					}
				}, 58 * 1000);
			}
		}
	}

	@Override
	public void requestInitialized(ServletRequestEvent req) {
		HttpServletRequest request = (HttpServletRequest) req.getServletRequest();
		ServletContext servletContext = req.getServletContext();
		String uriStr = request.getRequestURI();
		final ServerContext serverContext = ServerContextFactory.get(servletContext);
		if (uriStr.endsWith("/dwr/call/plainpoll/ReverseAjax.dwr")) {
			if (taskIsRun) {
				taskIsRun = false;
				timer = new Timer();
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						pushMsg(serverContext);
					}
				}, 1000 * 58);
			}
		}

	}

	private void pushMsg(ServerContext serverContext) {
		@SuppressWarnings("unchecked")
		Collection<ScriptSession> scriptSessions = serverContext.getAllScriptSessions();
		if (!CollectionUtils.isEmpty(scriptSessions)) {
			Util util = new Util(scriptSessions);
			util.addFunctionCall("updateInfo", "listener", "listener","");
		}
		taskIsRun = true;
	}
}
