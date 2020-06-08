/**
 * @author : 孙留平
 * @since : 2020年2月26日 上午10:40:29
 * @see:
 */
package com.zhixiu.server.service;

import com.zhixiu.server.model.SysUser;
import com.zhixiu.server.vo.RegisterBean;

/**
 * @author : Administrator
 * @since : 2020年2月26日 上午10:40:29
 * @see :
 */
public interface SysRegisterService {
	SysUser register(RegisterBean registerBean);
}
