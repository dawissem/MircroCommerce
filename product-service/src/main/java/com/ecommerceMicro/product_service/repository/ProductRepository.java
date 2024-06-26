package com.ecommerceMicro.product_service.repository;

import com.ecommerceMicro.product_service.model.Category;
import com.ecommerceMicro.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Arrays;
import java.util.List;

//La classe Product
// représente un document dans MongoDB et est généralement annotée avec @Document
//Cet import inclut l'interface MongoRepository fournie par Spring Data MongoDB.
//MongoRepository est une interface générique
// qui offre des méthodes CRUD (Create, Read, Update, Delete)
// et d'autres opérations courantes pour interagir avec MongoDB.
public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByCategoryId( String categoryId);

    void deleteByCategoryId(String categoryId);

    void deleteAllByCategoryId(String categoryId);
}
