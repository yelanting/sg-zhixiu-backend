/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:28:13
 * @see:
 */
package com.zhixiu.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhixiu.order.mapper.OrderMapper;
import com.zhixiu.order.model.Order;
import com.zhixiu.order.service.OrderService;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:28:13
 * @see :
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<Order> queryAllOrder() {
		return orderMapper.findAll();
	}

	@Override
	public Order queryOrderByOrderId(Long id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public Order save(Order record) {
		int result = -1;
		if (null != record.getId()) {
			result = orderMapper.updateByPrimaryKey(record);
		} else {
			result = orderMapper.insert(record);
		}

		return record;
	}

	@Override
	public Order deleteOrder(Long id) {
		Order order = queryOrderByOrderId(id);

		if (null == order) {
			return null;
		}

		int result = orderMapper.deleteByPrimaryKey(id);
		return order;

	}
}
