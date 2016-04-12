package qmr.hotel.model;
/*
 * @param id id
 * @param authority 权限
 * 
 * */

public class User_info {
	public String authority;
	public String username;
	public String password;
	public String phonenum;
	public String idnum;
	
	public void setPhonenum(String string) {
		this.phonenum = string;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
