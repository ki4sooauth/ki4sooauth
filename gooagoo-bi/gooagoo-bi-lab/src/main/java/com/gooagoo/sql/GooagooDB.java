package com.gooagoo.sql;

/**
 * 例:
 String sql = "select * from gooagoo_user.user_info";
 UserInfo userInfos = GooagooDB.querySingle(sql, UserInfo.class);
 System.out.println(userInfos.getCreateTime());
 sql一定要带上库名，否则无法匹配数据源
 实体类中在字段上加上@Column("数据库列名")注解。表名
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 数据访问工具类,注意写sql的时候一定要带上数据库名
 * 例如select * from gooagoo_user.user_info
 * @author 王宇
 *
 */
public class GooagooDB
{
    private static Logger log = Logger.getLogger("gooagoo_db");
    private boolean autoCommit = true;
    ConnectionManager manager = null;

    private Map<String, Connection> conns = new HashMap<String, Connection>();

    public GooagooDB()
    {
        manager = ConnectionManager.getInstance();
    }

    private synchronized Connection getConnection(String db)
    {
        if (!conns.containsKey(db))
        {
            conns.put(db, manager.getConnection(db));
        }
        Connection conn = conns.get(db);
        return conn;
    }

    private void close()
    {
        for (String key : conns.keySet())
        {
            try
            {
                conns.get(key).close();
            }
            catch (Exception e)
            {
                // TODO: handle exception
            }
        }
    }

    public <T> List<T> queryList(String sql, Class<T> clazz)
    {
        List<T> list = null;
        try
        {
            log.info("sql:" + sql);

            String db = manager.matching(sql);
            Connection conn = manager.getConnection(db);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            list = DaoEntityTools.setListValue(rs, clazz);
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            log.error("queryList", e);
        }
        return list;
    }

    public <T> List<T> queryList(PreparedStatement preparedStatement, Class<T> clazz)
    {
        List<T> list = null;
        try
        {
            log.info("sql:" + preparedStatement.getSql() + " parameters:" + preparedStatement.getParameters());
            String db = manager.matching(preparedStatement.getSql());
            Connection conn = manager.getConnection(db);
            java.sql.PreparedStatement statement = conn.prepareStatement(preparedStatement.getSql());
            for (int i = 0; i < preparedStatement.getParameters().size(); i++)
            {
                statement.setObject(i + 1, preparedStatement.getParameters().get(i));
            }
            ResultSet rs = statement.executeQuery();
            list = DaoEntityTools.setListValue(rs, clazz);
            statement.close();
            conn.close();
        }
        catch (Exception e)
        {
            log.error("queryList", e);
        }
        return list;
    }

    public <T> T querySingle(String sql, Class<T> clazz)
    {
        T obj = null;
        try
        {
            log.info("sql:" + sql);
            String db = manager.matching(sql);
            Connection conn = manager.getConnection(db);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            {
                obj = DaoEntityTools.setValue(rs, clazz);
            }
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            log.error("querySingle", e);
        }
        return obj;
    }

    public <T> T querySingle(PreparedStatement preparedStatement, Class<T> clazz)
    {
        T obj = null;
        try
        {
            String db = manager.matching(preparedStatement.getSql());
            Connection conn = manager.getConnection(db);
            java.sql.PreparedStatement statement = conn.prepareStatement(preparedStatement.getSql());
            for (int i = 0; i < preparedStatement.getParameters().size(); i++)
            {
                statement.setObject(i + 1, preparedStatement.getParameters().get(i));
            }
            log.info("sql:" + preparedStatement.getSql() + " parameters:" + preparedStatement.getParameters());
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                obj = DaoEntityTools.setValue(rs, clazz);
            }
            statement.close();
            conn.close();
        }
        catch (Exception e)
        {
            log.error("querySingle", e);
        }
        return obj;
    }

    public int execute(String sql)
    {
        int row = 0;
        try
        {
            log.info("sql:" + sql);
            String db = manager.matching(sql);
            Connection conn = manager.getConnection(db);
            Statement st = conn.createStatement();
            row = st.executeUpdate(sql);
            st.close();
            conn.close();
        }
        catch (Exception e)
        {
            log.error("execute", e);
        }
        return row;
    }

    public int execute(PreparedStatement preparedStatement)
    {
        int row = 0;
        try
        {
            log.info("sql:" + preparedStatement.getSql() + " parameters:" + preparedStatement.getParameters());
            String db = manager.matching(preparedStatement.getSql());
            Connection conn = manager.getConnection(db);
            java.sql.PreparedStatement statement = conn.prepareStatement(preparedStatement.getSql());
            for (int i = 0; i < preparedStatement.getParameters().size(); i++)
            {
                statement.setObject(i + 1, preparedStatement.getParameters().get(i));
            }
            row = statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch (Exception e)
        {
            log.error("execute", e);
        }
        return row;
    }
}
