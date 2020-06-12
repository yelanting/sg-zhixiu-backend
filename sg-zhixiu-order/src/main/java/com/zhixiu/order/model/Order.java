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
	private Integer productId;

	private Integer userId;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", productId=" + productId
		        + ", userId=" + userId + "]";
	}

}
