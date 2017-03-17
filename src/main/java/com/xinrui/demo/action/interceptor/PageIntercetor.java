package com.xinrui.demo.action.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.xinrui.demo.bean.param.PageParam;

/**
 * 
 * @ClassName: PageIntercetor
 * @Description: Paging interceptor
 * @author:liangzhicheng
 * @date 2016-3-19 11:52:02
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageIntercetor implements Interceptor {

	private String pageSqlId = "";;

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		String id = mappedStatement.getId();
		if (id.matches(".*(" + this.pageSqlId + ")$")) {
			BoundSql boundSql = statementHandler.getBoundSql();
			String sql = boundSql.getSql();
			String countSql = "SELECT COUNT(*) FROM (" + sql + ")a";
			Connection connection = (Connection) invocation.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();
			Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
			PageParam pageParam = (PageParam) parameter.get("pageParam");
			if (rs.next()) {
				pageParam.setTotalNumber(rs.getInt(1));
			}
			String pageSql = sql + " LIMIT " + pageParam.getDbIndex() + "," + pageParam.getDbNumber();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		try {
			if (StringUtils.isEmpty(this.pageSqlId = properties.getProperty("pageSqlId"))) {
				throw new PropertyException("pageSqlId property is not found!");
			}
		} catch (PropertyException e) {
			e.printStackTrace();
		}
	}

}
