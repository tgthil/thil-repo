package com.thil.retail.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thil.retail.entity.TblProduct;

public interface ProductRepo extends JpaRepository<TblProduct, String> {

	//selecting rows by multiple OPTIONAL columns 
	@Query("select p from TblProduct p where (:prodCode is null OR p.prodCode = :prodCode) AND (:prodDesc is null OR p.prodDesc = :prodDesc) "
			+ " AND (:unitQty is null OR p.unitQty = :unitQty) AND (:unitPrice is null OR p.unitPrice = :unitPrice) "
			+ " AND (:unitDesc is null OR p.unitDesc = :unitDesc)")
	public List<TblProduct> findProductsBy(@Param("prodCode") String prodCode, @Param("prodDesc")String prodDesc, 
			@Param("unitQty") BigDecimal unitQty, @Param("unitPrice") BigDecimal unitPrice,
			@Param("unitDesc") String unitDesc);
}
