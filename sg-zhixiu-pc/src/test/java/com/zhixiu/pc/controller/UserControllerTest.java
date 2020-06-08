package com.zhixiu.pc.controller;

import java.util.Date;

/**
 * @author : 孙留平
 * @since : 2020年6月3日 下午4:07:42
 * @see:
 */

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

	@Test
	public void whenQuerySuccessWithRequestBody() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/byBody")
		        .param("username", "tom").param("age", "18")
		        .param("toAge", "30").contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
		                MockMvcResultMatchers.jsonPath("$.length()").value(2));
	}

	@Test
	public void whenQuerySuccessWithPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/byPage")
		        .param("username", "tom").param("page", "3").param("size", "15")
		        .param("sort", "age,desc")
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
		                MockMvcResultMatchers.jsonPath("$.length()").value(2));
	}

	@Test
	public void whenQuerySuccessWithPathVariable() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/byPath/1")
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.username")
		                .value("sam"));
	}

	@Test
	public void whenQuerySuccessWithJsonView() throws Exception {
		System.out.println("whenQuerySuccessWithJsonView");
		String result = mockMvc
		        .perform(MockMvcRequestBuilders.get("/user/byId/1")
		                .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.username")
		                .value("sam"))
		        .andReturn().getResponse().getContentAsString();

		System.out.println("result:" + result);
	}

	@Test
	public void whenCreateUser() throws Exception {
		System.out.println("whenCreateUser:");
		String content = "{\"username\":\"tom\",\"password\":\"Admin@1234\"}";
		String result = mockMvc
		        .perform(MockMvcRequestBuilders.post("/user")
		                .contentType(MediaType.APPLICATION_JSON)
		                .content(content))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
		        .getResponse().getContentAsString();

		System.out.println("result:" + result);
	}

	@Test
	public void whenCreateUserSuccess() throws Exception {
		System.out.println("whenCreateUserSuccess:");
		Date date = new java.util.Date();
		System.out.println("datetime:" + date.getTime());
		String content = "{\"username\":\"tom\",\"password\":\"Admin@1234\",\"birthday\":"
		        + date.getTime() + "}";
		String result = mockMvc
		        .perform(MockMvcRequestBuilders.post("/user")
		                .contentType(MediaType.APPLICATION_JSON)
		                .content(content))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
		        .getResponse().getContentAsString();

		System.out.println("result:" + result);
	}

	@Test
	public void whenCreateUserWithValid() throws Exception {
		System.out.println("whenCreateUserWithValid:");
		String content = "{\"username\":null,\"password\":\"Admin@1234\"}";

		String result = mockMvc
		        .perform(MockMvcRequestBuilders.post("/user/createWithValid")
		                .contentType(MediaType.APPLICATION_JSON)
		                .content(content))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
		        .getResponse().getContentAsString();

		System.out.println("result:" + result);
	}

	@Test
	public void whenCreateUserWithValidPutMethod() throws Exception {
		System.out.println("whenCreateUserWithValidPutMethod:");
		String content = "{\"username\":\"测试用户\",\"password\":\"Admin@1234\"}";

		String result = mockMvc
		        .perform(MockMvcRequestBuilders.put("/user/modifyUser")
		                .contentType(MediaType.APPLICATION_JSON)
		                .content(content))
		        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
		        .getResponse().getContentAsString();

		System.out.println("result:" + result);
	}
}
