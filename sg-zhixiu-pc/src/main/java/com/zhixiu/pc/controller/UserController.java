/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午4:08:14
 * @see:
 */
package com.zhixiu.pc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zhixiu.pc.model.User;
import com.zhixiu.pc.vo.UserQuery;

/**
 * @author : Administrator
 * @since : 2020年6月3日 下午4:08:14
 * @see :
 */

@RestController
@RequestMapping("/user")
@Validated
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

	@GetMapping("/byBody")
	public List<User> queryWithBody(UserQuery userQuery) {
		// 打印是否接收到username
		System.out.println("传进来的body:" + ReflectionToStringBuilder
		        .toString(userQuery, ToStringStyle.MULTI_LINE_STYLE));

		System.out.println("username:" + userQuery.getUsername());

		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		return userList;
	}

	@GetMapping("/byPage")
	public List<User> queryWithPage(UserQuery userQuery,
	        @PageableDefault Pageable pageable) {
		// 打印是否接收到username
		System.out.println("传进来的body:" + ReflectionToStringBuilder
		        .toString(userQuery, ToStringStyle.MULTI_LINE_STYLE));

		System.out.println("pageNum:" + pageable.getPageNumber());
		System.out.println("pageSize:" + pageable.getPageSize());
		System.out.println("sort:" + pageable.getSort());

		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		return userList;
	}

	@GetMapping("/byPath/{id}")
	public User queryWithPathId(@PathVariable("id") String id) {
		// 打印是否接收到username
		System.out.println("传进来的id:" + id);
		User user = new User();
		user.setUsername("sam");
		return user;
	}

	@GetMapping("/byId/{id:\\d+}")
	@JsonView(User.UserSimpleView.class)
	public User queryWithJsonView(@PathVariable("id") String id) {
		// 打印是否接收到username
		System.out.println("传进来的id:" + id);
		User user = new User();
		user.setUsername("sam");
		user.setPassword("Admin@1234");
		return user;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		// 打印是否接收到username
		System.out.println("传进来的user:" + user);
		user.setUsername("sam");
		return user;
	}

	@PostMapping("/createWithValid")
	public User createUserWithValid(@Valid @RequestBody User user,
	        BindingResult bindingResult) {

		// 打印是否接收到username
		System.out.println("createUserWithValid传进来的user:" + user);
		System.out.println("Binding Result:" + bindingResult);
		user.setUsername("sam");
		return user;
	}

	@PutMapping("/modifyUser")
	public User modifyUser(@Valid @RequestBody User user,
	        BindingResult bindingResult) {
		System.out.println("modifyUser");
		user.setUsername("sam");
		return user;
	}
}
