/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:28:13
 * @see:
 */
package com.zhixiu.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhixiu.product.mapper.ProductMapper;
import com.zhixiu.product.model.Product;
import com.zhixiu.product.service.ProductService;
import com.zhixiu.util.exception.base.BusinessValidationException;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:28:13
 * @see :
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> queryAllProduct() {
		return productMapper.findAll();
	}

	@Override
	public Product queryProductByProductId(Long id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public Product save(Product record) {
		int result = -1;
		if (null != record.getId()) {
			result = productMapper.updateByPrimaryKey(record);
		} else {
			result = productMapper.insert(record);
		}

		if (-1 == result) {
			throw new BusinessValidationException("更新或者新增产品失败");
		}

		return record;
	}

	@Override
	public Product deleteProduct(Long id) {
		Product product = queryProductByProductId(id);

		if (null == product) {
			return null;
		}

		int result = productMapper.deleteByPrimaryKey(id);
		return product;

	}

}
