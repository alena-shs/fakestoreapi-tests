package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetProducts {
    @Test
    @DisplayName("Get all products")
    void getAllProducts() {
        step("Send a GET request", () ->
            given()
                    .filter(withCustomTemplates())
                    .spec(Specs.requestSpec)
                    .when()
                    .get("/products")
                    .then()
                    .spec(Specs.successResponseSpec)
                    .body("id", hasSize(20)))
                    .body("category", hasItems("men's clothing", "jewelery", "electronics", "women's clothing"));
    }

    @Test
    @DisplayName("Get only 5 products")
    void getProductsLimitedList() {
        step("Send a GET request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .queryParam("limit", 5)
                        .when()
                        .get("/products")
                        .then()
                        .spec(Specs.successResponseSpec)
                        .body("id", hasSize(5)));
    }

    @Test
    @DisplayName("Get all products in category")
    void getProductsOfCategory() {
        step("Send a GET request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .when()
                        .get("/products/category/jewelery")
                        .then()
                        .spec(Specs.successResponseSpec));
    }
}
