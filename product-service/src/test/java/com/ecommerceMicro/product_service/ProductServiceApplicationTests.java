package com.ecommerceMicro.product_service;

import com.ecommerceMicro.product_service.dto.ProductRequest;
import com.ecommerceMicro.product_service.model.Product;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
        //classe thika pour tester els methodes
class ProductServiceApplicationTests {

   @ServiceConnection


    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.14-rc0-focal");


   @LocalServerPort
    private Integer port;

   @BeforeEach
    void setUp() {
       RestAssured.baseURI ="http://localhost";
       RestAssured.port = port ;

   }
    static {
       mongoDBContainer.start();
    }


    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();

        RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id",Matchers.notNullValue())
                .body("name",Matchers.equalTo(productRequest.name()))
                .body("description",Matchers.equalTo(productRequest.description()))
                .body("price",Matchers.is(productRequest.price().intValueExact()))
                .body("categoryId",Matchers.equalTo(productRequest.categoryId()));
    }


    private ProductRequest getProductRequest() {
       return new ProductRequest("null","iphone13", "last model of name",BigDecimal.valueOf(1200),"1");
    }



}


