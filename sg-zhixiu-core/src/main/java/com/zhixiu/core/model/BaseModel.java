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

	private String createBy;

	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	private Date createTime;

	private String updateBy;
	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	private Date updateTime;

	private String sortField;

	private String order;

	private String mobile;

	private String description;

	private Boolean delFlag;

	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateUser() {
		return updateBy;
	}

	public void setUpdateUser(String updateBy) {
		this.updateBy = updateBy;
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
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@DateTimeFormat(pattern = CalendarUtil.DEFAULT_FORMAT_WHOLE)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", createBy=" + createBy
		        + ", createTime=" + createTime + ", updateBy=" + updateBy
		        + ", updateTime=" + updateTime + ", sortField=" + sortField
		        + ", order=" + order + ", mobile=" + mobile + ", description="
		        + description + ", delFlag=" + delFlag + ", remarks=" + remarks
		        + "]";
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
