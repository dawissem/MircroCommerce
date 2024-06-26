package com.ecommerceMicro.product_service.service.admin.category;

import com.ecommerceMicro.product_service.dto.CategoryRequest;
import com.ecommerceMicro.product_service.model.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryRequest categoryRequest);

    List<Category> getAllCategories();

    void deleteCategory(String categoryId);




}
