package com.thil.retail.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product", schema = "db_retail")
public class TblProduct {
	@Id
	@Column(name = "prod_code")
	private String prodCode;
	@Column(name="prod_desc")
	private String prodDesc;
	@Column(name="unit_qty")
	private BigDecimal unitQty;
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	@Column(name = "unit_desc")
	private String unitDesc;

}
