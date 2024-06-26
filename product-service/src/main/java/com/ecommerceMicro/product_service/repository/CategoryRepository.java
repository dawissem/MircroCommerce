package com.ecommerceMicro.product_service.repository;

import com.ecommerceMicro.product_service.model.Category;
import com.ecommerceMicro.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category,String> {

}
