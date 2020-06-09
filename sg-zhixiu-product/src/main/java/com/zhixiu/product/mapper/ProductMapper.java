/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:36:54
 * @see:
 */
package com.zhixiu.product.mapper;

import java.util.List;

import com.zhixiu.product.model.Product;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:36:54
 * @see :
 */
public interface ProductMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Product record);

	int save(Product record);

	Product selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Product record);

	List<Product> findPage();

	List<Product> findAll();

}
