package com.thil.retail.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thil.retail.entity.TblProduct;
import com.thil.retail.model.Product;

import com.thil.retail.service.ProductService;

@RestController
@RequestMapping(value = "/retail")
public class ProductController {
	@Autowired
	Product prod;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/product/create")	
	public Product saveProduct(@RequestBody Product product) {
		System.out.println("CALLINg.... saveProduct()");		
		
		productService.saveProduct(product); 
		
		return product;
		
		
	}
	
	@GetMapping(value = "/product/sample")
	public Product helloProduct()
	{
		prod.setProdCode("AB1000");
		prod.setProdDesc("Prod desc");
		prod.setUnitPrice(new BigDecimal(100.50));
		prod.setUnitQty(new BigDecimal(1.5));
		prod.setUnitDesc("Kg");	
		
		return prod;
		//return "Hello TblProduct";
		
		
	}
	
	@GetMapping(value = "/product/list")
	public List<TblProduct>getProductList(@RequestBody Product product){
		return productService.getProducts(product);
	}
	

}
