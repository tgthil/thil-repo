package com.thil.retail.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Product {
	private String prodCode;
	private String prodDesc;
	private BigDecimal unitQty;
	private BigDecimal unitPrice;
	private String unitDesc;
		
	}

