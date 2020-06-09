/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:23:59
 * @see:
 */
package com.zhixiu.product.model;

import com.zhixiu.core.model.BaseModel;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:23:59
 * @see :
 */
public class Product extends BaseModel {
	private String ename;
	private String cname;
	private Integer quantity;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [ename=" + ename + ", cname=" + cname + ", quantity="
		        + quantity + "]";
	}

}
