/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午4:40:29
 * @see:
 */
package com.zhixiu.pc.model;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author : Administrator
 * @since : 2020年6月3日 下午4:40:29
 * @see :
 */
public class User {

	@NotNull
	@NotBlank
	private String username;
	private String password;

	private String id;
	private Date birthday;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id="
		        + id + ", birthday=" + birthday + "]";
	}

	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public interface UserSimpleView {
	}

	public interface UserDetailView extends UserSimpleView {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
