package qmr.hotel.util;

import java.lang.reflect.Field;

import qmr.hotel.model.User_info;

public class GetSqlString {
	
	
	public String insertSql(Object object) throws IllegalArgumentException, IllegalAccessException{
		String sql = "insert into ";
		Class<?> c = object.getClass();
		sql += c.getSimpleName()+" ";
		Field[] fields = c.getDeclaredFields();
		if(fields.length == 1){
			sql += fields[0].getName()+" values \""+ fields[0].get(object)+"\"";
		}
		else{
			String keyString = "(";
			String valueString = "(\"";
			for(int i = 0;i<fields.length-1;i++){
				keyString += fields[i].getName()+",";
				//Object oooObject=fields[i].get(object);
				valueString += fields[i].get(object)+"\",\"";
				
			}
			keyString += fields[fields.length-1].getName()+")";
			valueString += fields[fields.length-1].get(object)+"\")";
			sql += keyString+" values "+valueString;
		}
		System.out.println(sql);
		return sql;
	}
	
	public String selectSingleSql(Object object) throws IllegalArgumentException, IllegalAccessException {
		boolean flag = false;
		String sql = "select * from ";
		sql+= object.getClass().getSimpleName()+" where ( ";
		Field[] fields = object.getClass().getDeclaredFields();
		for(int i = 0;i<fields.length-1;i++){
			if(fields[i].get(object)!=""&&fields[i].get(object)!=null){
				flag = true;
				sql+=fields[i].getName()+ " = \""+fields[i].get(object)+"\" and ";
			}
		}
		if(fields[fields.length-1].get(object)!=""&&fields[fields.length-1].get(object)!=null)
			sql+=fields[fields.length-1].getName()+" = \""+fields[fields.length-1].get(object)+" \")";
		else {
			sql = sql.substring(0, sql.length()-4);
			sql+=")";
		}
		
		if(!flag)
			sql = "select * from "+object.getClass().getSimpleName();
		
		return sql;	
	}
	
	
	
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		User_info a=new User_info();
		 a.setAuthority("1");
		 a.setPassword("d");
		 a.setUsername("b");
		System.out.println(new GetSqlString().selectSingleSql(new User_info()));
	}

}
