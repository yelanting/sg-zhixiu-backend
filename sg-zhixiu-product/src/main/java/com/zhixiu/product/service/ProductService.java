/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:27:54
 * @see:
 */
package com.zhixiu.product.service;

import java.util.List;

import com.zhixiu.product.model.Product;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:27:54
 * @see :
 */
public interface ProductService {
	List<Product> queryAllProduct();

	Product queryProductByProductId(Long id);

	Product save(Product record);

	Product deleteProduct(Long id);
}
