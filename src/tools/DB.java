package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import basicInformation.entity.Unit;

public class DB {

	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://rm-m5ew6qe9z65b54kq9qo.mysql.rds.aliyuncs.com:3306/db01";
	private static final String username = "public";
	private static final String password = "Public0011"; 
	
	private static Connection conn;
	private static PreparedStatement ps ;
	private static ResultSet rs ;
	
	public static ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		DB.rs = rs;
	}
	
	public static Connection getConn() throws Exception {
		Class.forName(Driver);
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	
	/**
	 * 针对UserListDao对象		展示列表操作
	 * @return
	 * @throws Exception
	 */
	public static ResultSet selectList(String sql) throws Exception {
		conn = getConn();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		return rs ;
	}
	
	/**
	 * 获取User对象		通过userid连接数据库
	 * @return
	 * @throws Exception
	 */
	public static ResultSet selectUser(String sql,Integer userid) throws Exception {
		conn = getConn();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		rs = ps.executeQuery();
		return rs ;
	}
	
	/*
	 * 更新用户信息
	 */
//	public static int updUser(String[] sql ,Unit unit)  {
//		int count = 0;
//		try {
//			conn = getConn();
//			conn.setAutoCommit(false);
//			ps = conn.prepareStatement(sql[0]);
//			ps.setString(1, unit.getUnitname());
//			ps.setInt(2, unit.getUnitid());
//			
//			ps.addBatch();
//			ps.executeBatch();
//			
//			ps = conn.prepareStatement(sql[1]);
//			ps.setString(1, unit.getPower().getPowername());
//			ps.setInt(2, unit.getPower().getStatus());
//			ps.setInt(3, unit.getPower().get_select());
//			ps.setInt(4, unit.getPower().get_add());
//			ps.setInt(5, unit.getPower().get_upd());
//			ps.setInt(6, unit.getPower().get_del());
//			ps.setInt(7, unit.getPower().getPowerid());
//			
//			ps.addBatch();
//		    ps.executeBatch();
//			conn.commit();
//			
//			count = 1;
//			
//		} catch(Exception ex) {
//			ex.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} finally {
//			try {
//				close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return count ;
//	}
	
	/*
	 *删除用户信息
	 */
	
	
	/*
	 * 新增用户信息
	 */
	
	
	/*
	 * 关闭资源操作
	 */
	public static void close() throws Exception {
		if(rs != null) {
			rs.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
}
