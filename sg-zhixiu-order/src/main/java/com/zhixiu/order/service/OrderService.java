/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:27:54
 * @see:
 */
package com.zhixiu.order.service;

import java.util.List;

import com.zhixiu.order.model.Order;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:27:54
 * @see :
 */
public interface OrderService {
	List<Order> queryAllOrder();

	Order queryOrderByOrderId(Long id);

	Order insertOrder(Order record);

	Order updateOrder(Order record);

	Order deleteOrder(Long id);
}
