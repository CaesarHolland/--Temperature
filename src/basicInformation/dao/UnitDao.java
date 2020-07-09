package basicInformation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basicInformation.entity.Unit;
import tools.DB;

public class UnitDao {
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://rm-m5ew6qe9z65b54kq9qo.mysql.rds.aliyuncs.com:3306/db01";
	private static final String username = "public";
	private static final String password = "Public0011"; 
	
	private static Connection conn;
	private static PreparedStatement ps ;
	private static ResultSet rs ;
	
	public List<Unit> showUnit() throws Exception{
		List<Unit> unitList = new ArrayList<Unit>();
		String sql = "select * from unit";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			
			while(rs.next()){
				Unit unit = new Unit();
				unit.setUnitCode(rs.getInt("unitCode"));
				unit.setUnitNature(rs.getString("unitNature"));
				unit.setHelpCode(rs.getString("helpCode"));
				unit.setRegion(rs.getString("region"));
				unit.setIndustry(rs.getString("industry"));
				unit.setUnitClass(rs.getString("unitClass"));
				unit.setUnitName(rs.getString("unitName"));
				unit.setContacts(rs.getString("contacts"));
				unit.setAddress(rs.getString("address"));
				unit.setBank(rs.getString("bank"));
				unit.setAccount(rs.getString("account"));
				unit.setPhone(rs.getString("phone"));
				unit.setEmail(rs.getString("email"));
				unit.setInfo(rs.getString("info"));
				unitList.add(unit);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return unitList;
	}
	
	
	public int deleteUnit(String unitCode) throws Exception{
		String sql = "delete from unit where unitCode=?";
		int flag = 0;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,username,password);
			ps = conn.prepareStatement(sql);
			ps.setString(1, unitCode);
			flag = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return flag;
	}
	
	
	

}
