package com.ecommerceMicro.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder de Lombok est un moyen puissant et pratique pour simplifier
// la création d'objets complexes en Java,
// rendant le code plus propre et plus maintenable
@Builder
//l'annotation @Document est utilisée dans le contexte des applications
// utilisant Spring Data MongoDB
//L'attribut value de l'annotation
// @Document spécifie le nom de la collection MongoDB à laquelle la classe est mappée
@Document(value = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    // Reference to the category ID
    private String categoryId; // Or you can name it category instead of categoryId



}
