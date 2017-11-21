package com.flf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseSpaceUtil {

	private static final String driver = "com.mysql.jdbc.Driver"; //数据库驱动
	//连接数据库的URL地址
	private static final String url="jdbc:mysql://localhost:3306/home_jiajia?useUnicode=true&characterEncoding=UTF-8"; 
	private static final String username="root";//数据库的用户名
	private static final String password="123456";//数据库的密码
    
	private static Connection conn=null;
	
	//静态代码块负责加载驱动
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	public static double getDateBaseSpace(String str){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseSpaceUtil.getConnection();
			String sql = "SELECT ROUND(SUM(DATA_LENGTH/1024/1024),2) AS DATA FROM information_schema.tables WHERE table_schema=?;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, str);
			rs = stmt.executeQuery();
			if(rs.next()){
				return Double.parseDouble(rs.getString(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = DatabaseSpaceUtil.getConnection();
		   if(conn!=null)
		   {
			   System.out.println("数据库连接正常！");
		   }
		   else
		   {
			   System.out.println("数据库连接异常！");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		String database = "home_jiajia";
		double result = DatabaseSpaceUtil.getDateBaseSpace(database);
		System.out.println("数据库空间大小为："+result+"MB");
		
	}

}
