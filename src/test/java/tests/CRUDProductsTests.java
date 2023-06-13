package tests;

import io.qameta.allure.*;
import models.ProductBody;
import models.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static tests.TestData.*;

@Epic("API Fakestore")
@Story("CRUD for products")
@Owner("Alena Shomanova")
public class CRUDProductsTests {
    @Test
    @DisplayName("Correct addition of a new product")
    @Description("POST /products")
    void addProduct() {
        ProductBody addProductBody = new ProductBody();
        addProductBody.setTitle(defaultProductTitle);
        addProductBody.setPrice(defaultPrice);
        addProductBody.setDescription(defaultDescription);
        addProductBody.setImage(defaultImageLink);
        addProductBody.setCategory(defaultCategory);

        ProductResponse addProductResponse = step("Send a POST request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .body(addProductBody)
                        .when()
                        .post("/products")
                        .then()
                        .spec(Specs.successResponseSpec)
                        .extract().as(ProductResponse.class));
        step("Verify that the created product's title is correct", () ->
                assertThat(addProductResponse.getTitle()).isEqualTo(addProductBody.getTitle()));
        step("Verify that the created product's price is correct", () ->
                assertThat(addProductResponse.getPrice()).isEqualTo(addProductBody.getPrice()));
        step("Verify that the created product's description is correct", () ->
                assertThat(addProductResponse.getDescription()).isEqualTo(addProductBody.getDescription()));
        step("Verify that the created product's image is correct", () ->
                assertThat(addProductResponse.getImage()).isEqualTo(addProductBody.getImage()));
        step("Verify that the created product's category is correct", () ->
                assertThat(addProductResponse.getPrice()).isEqualTo(addProductBody.getPrice()));
    }

    @Test
    @DisplayName("Get the list of all products in the database")
    @Description("GET /products")
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
    @DisplayName("Correct updating of a chosen product")
    @Description("PUT /products/1")
    void updateProduct() {
        ProductBody updateProductBody = new ProductBody();
        updateProductBody.setTitle(defaultProductTitle);
        updateProductBody.setPrice(defaultPrice);
        updateProductBody.setDescription(defaultDescription);
        updateProductBody.setImage(defaultImageLink);
        updateProductBody.setCategory(defaultCategory);

        ProductResponse updateProductResponse = step("Send a PUT request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .body(updateProductBody)
                        .when()
                        .put("/products/" + defaultIdForProducts)
                        .then()
                        .spec(Specs.successResponseSpec)
                        .extract().as(ProductResponse.class));
        step("Verify that the updated product's title is correct", () ->
                assertThat(updateProductResponse.getId()).isEqualTo(defaultIdForProducts));
        step("Verify that the updated product's title is correct", () ->
                assertThat(updateProductResponse.getTitle()).isEqualTo(updateProductBody.getTitle()));
        step("Verify that the updated product's price is correct", () ->
                assertThat(updateProductResponse.getPrice()).isEqualTo(updateProductBody.getPrice()));
        step("Verify that the updated product's description is correct", () ->
                assertThat(updateProductResponse.getDescription()).isEqualTo(updateProductBody.getDescription()));
        step("Verify that the updated product's image is correct", () ->
                assertThat(updateProductResponse.getImage()).isEqualTo(updateProductBody.getImage()));
        step("Verify that the updated product's category is correct", () ->
                assertThat(updateProductResponse.getPrice()).isEqualTo(updateProductBody.getPrice()));
    }

    @Test
    @DisplayName("Correct deletion of a chosen product")
    @Description("DELETE /products/1")
    void deleteProduct() {
        ProductResponse productToDelete = step("Send a GET request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .when()
                        .get("/products/" + defaultIdForProducts)
                        .then()
                        .spec(Specs.successResponseSpec)
                        .extract().as(ProductResponse.class));
        ProductResponse deletedProduct = step("Send a DELETE request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .when()
                        .delete("/products/" + defaultIdForProducts)
                        .then()
                        .spec(Specs.successResponseSpec).extract().as(ProductResponse.class));
        step("Verify that the deleted product's title is correct", () ->
                assertThat(deletedProduct.getId()).isEqualTo(defaultIdForProducts));
        step("Verify that the deleted product's title is correct", () ->
                assertThat(deletedProduct.getTitle()).isEqualTo(productToDelete.getTitle()));
        step("Verify that the deleted product's price is correct", () ->
                assertThat(deletedProduct.getPrice()).isEqualTo(productToDelete.getPrice()));
        step("Verify that the deleted product's description is correct", () ->
                assertThat(deletedProduct.getDescription()).isEqualTo(productToDelete.getDescription()));
        step("Verify that the deleted product's image is correct", () ->
                assertThat(deletedProduct.getImage()).isEqualTo(productToDelete.getImage()));
        step("Verify that the deleted product's category is correct", () ->
                assertThat(deletedProduct.getPrice()).isEqualTo(productToDelete.getPrice()));
    }
}
