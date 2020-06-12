/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:28:47
 * @see:
 */
package com.zhixiu.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.order.model.Order;
import com.zhixiu.order.service.OrderService;
import com.zhixiu.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:28:47
 * @see :
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/queryAllOrder")
	public ResponseData queryAllOrder() {
		return ResponseData.getSuccessResult(orderService.queryAllOrder());
	}

	@GetMapping("/queryOrderByOrderId")
	public ResponseData queryOrderByOrderId(@RequestParam("orderId") Long id) {
		return ResponseData
		        .getSuccessResult(orderService.queryOrderByOrderId(id));
	}

	@PostMapping("/insertOrder")
	public ResponseData insertOrder(@RequestBody Order order) {
		return ResponseData.getSuccessResult(orderService.save(order));
	}

	@PutMapping("/updateOrder")
	public ResponseData updateOrder(@RequestBody Order order) {
		return ResponseData.getSuccessResult(orderService.save(order));
	}

	@DeleteMapping("/deleteOrder")
	public ResponseData deleteOrder(@RequestParam("orderId") Long id) {
		return ResponseData.getSuccessResult(orderService.deleteOrder(id));
	}
}
