/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:25:41
 * @see:
 */
package com.zhixiu.order.model;

import com.zhixiu.core.model.BaseModel;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:25:41
 * @see :
 */
public class Order extends BaseModel {
	private Integer number;
	private Integer product_id;

	private Integer user_id;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", product_id=" + product_id
		        + ", user_id=" + user_id + "]";
	}

}
