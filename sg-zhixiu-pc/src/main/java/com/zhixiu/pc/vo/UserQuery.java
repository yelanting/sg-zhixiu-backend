/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午5:33:30
 * @see:
 */
package com.zhixiu.pc.vo;

/**
 * @author : Administrator
 * @since : 2020年6月3日 下午5:33:30
 * @see :
 */
public class UserQuery {
	private String username;
	private int age;
	private int ageTo;
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserQuery [username=" + username + ", age=" + age + ", ageTo="
		        + ageTo + ", address=" + address + "]";
	}

}
