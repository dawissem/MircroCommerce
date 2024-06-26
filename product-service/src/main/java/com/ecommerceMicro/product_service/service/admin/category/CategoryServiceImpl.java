package com.ecommerceMicro.product_service.service.admin.category;

import com.ecommerceMicro.product_service.dto.CategoryRequest;
import com.ecommerceMicro.product_service.model.Category;
import com.ecommerceMicro.product_service.repository.CategoryRepository;
import com.ecommerceMicro.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    public Category createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description());
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public void deleteCategory(String categoryId) {
        // First delete all products associated with the category
        productRepository.deleteAllByCategoryId(categoryId);
        // Then delete the category itself
        categoryRepository.deleteById(categoryId);
    }


}