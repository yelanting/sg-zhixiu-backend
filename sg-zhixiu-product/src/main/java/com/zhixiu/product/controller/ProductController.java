/**
 * @author : 孙留平
 * @since : 2020年6月9日 上午12:28:47
 * @see:
 */
package com.zhixiu.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.product.service.ProductService;
import com.zhixiu.product.vo.ProductVO;
import com.zhixiu.util.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2020年6月9日 上午12:28:47
 * @see :
 */
@RestController
@RequestMapping(value = "/product", method = { RequestMethod.GET,
        RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/queryAllProduct")
	public ResponseData queryAllProduct() {
		return ResponseData.getSuccessResult(productService.queryAllProduct());
	}

	@GetMapping("/queryProductByProductId")
	public ResponseData queryProductByProductId(
	        @RequestParam("productId") Long id) {
		return ResponseData
		        .getSuccessResult(productService.queryProductByProductId(id));
	}

	@PostMapping("/insertProduct")
	public ResponseData insertProduct(@RequestBody ProductVO product) {
		return ResponseData.getSuccessResult(productService.save(product));
	}

	@PutMapping("/updateProduct")
	public ResponseData updateProduct(@RequestBody ProductVO product) {
		return ResponseData.getSuccessResult(productService.save(product));
	}

	@DeleteMapping("/deleteProduct")
	public ResponseData deleteProduct(@RequestParam("productId") Long id) {
		return ResponseData.getSuccessResult(productService.deleteProduct(id));
	}
}
