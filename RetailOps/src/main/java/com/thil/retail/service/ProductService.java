package com.thil.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thil.retail.entity.TblProduct;
import com.thil.retail.model.Product;
import com.thil.retail.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	public void saveProduct(Product product) {	
		productRepo.save(mapToEntity(product));
	}
	
	public Product getProductByCode(String prodCode) {
		return mapToModel(productRepo.getReferenceById(prodCode));		
	}
	public List<TblProduct> getProducts(Product p) {
		return productRepo.findProductsBy(p.getProdCode(), p.getProdDesc(), p.getUnitQty(), p.getUnitPrice(), p.getUnitDesc());		
	}
	
	public void deleteProduct(Product product) {
		productRepo.delete(mapToEntity(product));
	}
	
	

	private Product mapToModel(TblProduct tblProd) {
		Product prod = new Product();
		prod.setProdCode(tblProd.getProdCode());
		prod.setProdDesc(tblProd.getProdDesc());
		prod.setUnitDesc(tblProd.getUnitDesc());
		prod.setUnitQty(tblProd.getUnitQty());
		prod.setUnitPrice(tblProd.getUnitPrice());		
		return prod;
	}
	private TblProduct mapToEntity(Product product) {
		TblProduct prod = new TblProduct();
		prod.setProdCode(product.getProdCode());
		prod.setProdDesc(product.getProdDesc());
		prod.setUnitDesc(product.getUnitDesc());
		prod.setUnitQty(product.getUnitQty());
		prod.setUnitPrice(product.getUnitPrice());
		return prod;
	}
}
