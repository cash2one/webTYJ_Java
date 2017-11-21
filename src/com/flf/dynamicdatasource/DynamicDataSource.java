package com.flf.dynamicdatasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	private Map<Object, Object> _targetDataSources;

	@Override
	protected Object determineCurrentLookupKey() {
		String dataSourceName = DBContextHolder.getDBType();
		if (dataSourceName == null) {
			dataSourceName = "dataSource";
		} else {
			this.selectDataSource(dataSourceName);
			if (dataSourceName.equals("0"))
				dataSourceName = "dataSource";
		}
		return dataSourceName;
	}

	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		this._targetDataSources = targetDataSources;
		super.setTargetDataSources(this._targetDataSources);
		afterPropertiesSet();
	}

	public void addTargetDataSource(String key, DriverManagerDataSource dataSource) {
		this._targetDataSources.put(key, dataSource);
		this.setTargetDataSources(this._targetDataSources);
	}

	public DriverManagerDataSource createDataSource(String driverClassName, String url, String username,
			String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		//dataSource.setTestWhileIdle(true);
		return dataSource;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * @param serverId
     * @describe 数据源存在时不做处理，不存在时创建新的数据源链接，并将新数据链接添加至缓存
     */
    public void selectDataSource(String companyId) {
        Object sid = DBContextHolder.getDBType();
        if ("0".equals(companyId + "")) {
            DBContextHolder.setDBType("0");
            return;
        }
        Object obj = this._targetDataSources.get(companyId);
        if (obj != null && sid.equals(companyId + "")) {
            return;
        } else {
        	DriverManagerDataSource dataSource = this.getDataSource(companyId);
            if (null != dataSource)
                this.setDataSource(companyId, dataSource);
        }
    }
 
    /**
     * @describe 查询serverId对应的数据源记录
     * @param serverId
     *  @return
     */
    public DriverManagerDataSource getDataSource(String companyId) {
        this.selectDataSource("0");
        this.determineCurrentLookupKey();
        Connection conn = null;
        HashMap<String, Object> map = null;
        try {
            conn = this.getConnection();
            PreparedStatement ps = conn
                    .prepareStatement("SELECT * FROM t_dbsource WHERE company_id = ?");
            ps.setString(1, companyId);
            ResultSet rs = ps.executeQuery();
            map = new HashMap<String, Object>();
            if (rs.next()) {
                map.put("COMPANY_ID", rs.getString("COMPANY_ID"));
                map.put("DRIVER_CLASSNAME", rs.getString("DRIVER_CLASSNAME"));
                map.put("URL", rs.getString("URL"));
                map.put("USERNAME", rs.getString("USERNAME"));
                map.put("PASSWORD", rs.getString("PASSWORD"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
        String driverClassName = map.get("DRIVER_CLASSNAME").toString();
        String url = map.get("URL").toString();
        String userName = map.get("USERNAME").toString();
        String password = map.get("PASSWORD").toString();
        DriverManagerDataSource dataSource = this.createDataSource(driverClassName,
                url, userName, password);
        return dataSource;
    }
 
    /**
     * @param serverId
     * @param dataSource
     */
    public void setDataSource(String companyId, DriverManagerDataSource dataSource) {
        this.addTargetDataSource(companyId + "", dataSource);
        DBContextHolder.setDBType(companyId + "");
    }
}
