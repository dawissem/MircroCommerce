package com.ecommerceMicro.product_service.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(value = "category")
public class Category {

    @Id
    private String categoryId;

    private String name;

    private String description;

    @DBRef // Use DBRef to reference associated products
    private List<Product> products; // List of associated products

}
