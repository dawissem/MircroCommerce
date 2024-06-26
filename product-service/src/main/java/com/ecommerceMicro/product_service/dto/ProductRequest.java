package com.ecommerceMicro.product_service.dto;

import com.ecommerceMicro.product_service.model.Category;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, BigDecimal price, String categoryId) {


}
