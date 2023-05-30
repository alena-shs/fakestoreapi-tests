package tests;

import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import java.util.ArrayList;
import java.util.List;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static tests.TestData.*;

public class CRUDCartsTests {
    @Test
    @DisplayName("Add a new product into a cart")
    void addCart() {
        CartBody cartBody = new CartBody();

        CartBody.ListProductsData product = new CartBody.ListProductsData();
        product.setProductId(10);
        product.setQuantity(2);
        List<CartBody.ListProductsData> listProducts = new ArrayList<>();
        listProducts.add(product);

        cartBody.setUserId(defaultUserIdForCarts);
        cartBody.setDate(defaultDate);
        cartBody.setProducts(listProducts);

        CartResponse cartAddResponse = step("Send a POST request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .body(cartBody)
                        .when()
                        .post("/carts")
                        .then()
                        .spec(Specs.successResponseSpec)
                        .extract().as(CartResponse.class));
        step("Verify that the target cart's user ID is correct", () ->
                assertThat(cartAddResponse.getUserId()).isEqualTo(cartBody.getUserId()));
        step("Verify that the target cart's date is correct", () ->
                assertThat(cartAddResponse.getDate()).isEqualTo(cartBody.getDate()));
        step("Verify that the target cart's products are correct", () ->
                assertThat(cartAddResponse.getProducts()).isEqualTo(cartBody.getProducts()));
    }

    @Test
    @DisplayName("Get all carts")
    void getAllCarts() {
        step("Send a GET request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .when()
                        .get("/carts")
                        .then()
                        .spec(Specs.successResponseSpec)
                        .body("id", hasSize(7)));
    }

    @Test
    @DisplayName("Update a user's cart")
    void updateProductsInCart() {
        CartBody cartBody = new CartBody();

        CartBody.ListProductsData product = new CartBody.ListProductsData();
        product.setProductId(10);
        product.setQuantity(3);
        List<CartBody.ListProductsData> listProducts = new ArrayList<>();
        listProducts.add(product);

        cartBody.setUserId(defaultUserIdForCarts);
        cartBody.setDate(defaultDate);
        cartBody.setProducts(listProducts);

        CartResponse updatedCartResponse =
                step("Send a POST request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .body(cartBody)
                        .when()
                        .put("/carts/"+defaultCartId)
                        .then()
                        .spec(Specs.successResponseSpec)
                        .extract().as(CartResponse.class));
        step("Verify that the updated cart's ID is correct", () ->
                assertThat(updatedCartResponse.getId()).isEqualTo(defaultCartId));
        step("Verify that the updated cart's user ID is correct", () ->
                assertThat(updatedCartResponse.getUserId()).isEqualTo(cartBody.getUserId()));
        step("Verify that the updated cart's date is correct", () ->
                assertThat(updatedCartResponse.getDate()).isEqualTo(cartBody.getDate()));
        step("Verify that the updated cart's products are correct", () ->
                assertThat(updatedCartResponse.getProducts()).isEqualTo(cartBody.getProducts()));
    }

    @Test
    @DisplayName("Delete a cart")
    void deleteCart() {
        CartResponse deletedCartResponse = step("Send a DELETE request", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.requestSpec)
                        .when()
                        .delete("/carts/"+ defaultCartId)
                        .then()
                        .spec(Specs.successResponseSpec)
                        .extract().as(CartResponse.class));
        step("Verify that the updated cart's ID is correct", () ->
                assertThat(deletedCartResponse.getId()).isEqualTo(defaultCartId));
    }

}