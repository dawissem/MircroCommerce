package com.ecommerceMicro.product_service.service.admin.product;

import com.ecommerceMicro.product_service.dto.ProductRequest;
import com.ecommerceMicro.product_service.dto.ProductResponse;
import com.ecommerceMicro.product_service.model.Product;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductWithCategory(String productId);

    List<ProductResponse> getProductsByCategory(String categoryId);
}
