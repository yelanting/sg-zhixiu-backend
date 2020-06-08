/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午4:08:14
 * @see:
 */
package com.zhixiu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.demo.model.User;

/**
 * @author : Administrator
 * @since : 2020年6月3日 下午4:08:14
 * @see :
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public List<User> query() {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		return userList;
	}

	@GetMapping("/byUsername")
	public List<User> query2(@RequestParam String username) {
		// 打印是否接收到username
		System.out.println("username:" + username);

		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		return userList;
	}

}
