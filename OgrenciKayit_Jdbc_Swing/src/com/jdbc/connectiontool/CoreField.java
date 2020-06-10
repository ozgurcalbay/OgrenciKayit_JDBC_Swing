package com.jdbc.connectiontool;

public class CoreField {

	private String userName = "oibs";
	private String password = "oibs";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

}
