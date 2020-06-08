/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午4:41:52
 * @see:
 */
package com.zhixiu.demo.model;

/**
 * @author : Administrator
 * @since : 2020年6月3日 下午4:41:52
 * @see :
 */
public class User {
	private String username;
	private String password;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
