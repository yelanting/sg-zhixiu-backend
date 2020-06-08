/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午4:07:42
 * @see:
 */
package com.zhixiu.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author : Administrator
 * @since : 2020年6月3日 下午4:07:42
 * @see :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	// 伪造测试用例
	@Autowired
	private WebApplicationContext webApplicationContext;

	// 伪造mvc
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
		        .build();
	}

	@Test
	public void whenQuerySuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user")
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
		                MockMvcResultMatchers.jsonPath("$.length()").value(2));
	}

	@Test
	public void whenQuerySuccessWithRequestParam() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/byUsername")
		        .param("username", "tom")
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
		                MockMvcResultMatchers.jsonPath("$.length()").value(2));
	}
}
