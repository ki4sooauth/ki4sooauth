package com.gooagoo.socket.cache;

import java.util.ResourceBundle;

/**
 * 基础常量信息类
 * @author zsl
 *
 */
public class BeanUtil
{
    private final static ResourceBundle mina = ResourceBundle.getBundle("mina");
    /**CRM长连接端口号**/
    public final static int CRM_LSERVER_PORT = Integer.parseInt(mina.getString("crm.lserver.port"));
    /**GOOAGOO长连接端口号**/
    public final static int GOOAGOO_LSERVER_PORT = Integer.parseInt(mina.getString("gooagoo.lserver.port"));
    /**短连接端口号**/
    public final static int SSERVER_PORT = Integer.parseInt(mina.getString("sserver.port"));
    /**超时时间**/
    public final static int LSERVER_IDLETIME = Integer.parseInt(mina.getString("lserver.ideltime"));
}
