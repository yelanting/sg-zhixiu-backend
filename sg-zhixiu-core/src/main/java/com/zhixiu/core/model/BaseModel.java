/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:20:43
 * @see:
 */
package com.zhixiu.core.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.zhixiu.util.core.CalendarUtil;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:20:43
 * @see :
 */
public class BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String createUser;

	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	private Date createDate;

	private String updateUser;
	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	private Date updateDate;

	private String sortField;

	private String order;

	private String mobile;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getOrder() {
		return order;
	}

	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
