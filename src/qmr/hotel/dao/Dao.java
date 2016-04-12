package qmr.hotel.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.velocity.template.InsertAttributeDirective;

import qmr.hotel.model.User_info;
import qmr.hotel.util.GetSqlString;
import qmr.hotel.util.JDBCUtil;

public class Dao {
	public Connection connection;
	public GetSqlString getSqlString = new GetSqlString();
	
	public boolean insert(Object object){
		boolean flag = false;
		connection = JDBCUtil.connection();
		try {
			String sqlString = getSqlString.insertSql(object);
			//System.out.println(sqlString);
			PreparedStatement pstmt = connection.prepareStatement(sqlString);
			int a = pstmt.executeUpdate();
			if(a != 0)
				flag = true;
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//connection.close();
		return flag;
	}
	
	public List<?> select(Object object) {
		List<Object> list = new ArrayList<>();
		connection = JDBCUtil.connection();
		try {
			String sql = getSqlString.selectSingleSql(object);
			System.out.println(sql);
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			//System.out.println(rs.wasNull());
			Class<?> c = object.getClass();
			Field[] fields = c.getDeclaredFields();
			while (rs.next()) {
				Object object2 = c.newInstance();
				for(Field f:fields){
					f.set(object2, rs.getString(f.getName()));
				}
				list.add(object2);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//connection.close();
		return list;
	}
	
/*	public static void main(String[] args) {
		User_info a=new User_info();
		 a.setAuthority(1);
		 a.setPassword("qmr77713331");
		 a.setUsername("qmr7715");
		System.out.println(new Dao().insert(a)); 
	}
	*/

}
