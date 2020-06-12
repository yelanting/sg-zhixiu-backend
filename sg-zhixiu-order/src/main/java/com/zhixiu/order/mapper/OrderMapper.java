/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:36:54
 * @see:
 */
package com.zhixiu.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhixiu.order.model.Order;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:36:54
 * @see :
 */
@Mapper
public interface OrderMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Order record);

	Order selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Order record);

	List<Order> findPage();

	List<Order> findAll();

}
