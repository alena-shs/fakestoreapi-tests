package tests;

import models.CartBody;
import models.ProductBody;

import java.util.ArrayList;
import java.util.List;

import static tests.TestData.*;

public class TestBase {
    CartBody cartBody = new CartBody();
    CartBody.ListProductsData product = new CartBody.ListProductsData();
    ProductBody addProductBody = new ProductBody();
    ProductBody updateProductBody = new ProductBody();

    public void prepareCartBody(int id, int quantity) {
        product.setProductId(id);
        product.setQuantity(quantity);
        List<CartBody.ListProductsData> listProducts = new ArrayList<>();
        listProducts.add(product);

        cartBody.setUserId(defaultUserIdForCarts);
        cartBody.setDate(defaultDate);
        cartBody.setProducts(listProducts);
    }

    public void prepareProductBody() {
        addProductBody.setTitle(defaultProductTitle);
        addProductBody.setPrice(defaultPrice);
        addProductBody.setDescription(defaultDescription);
        addProductBody.setImage(defaultImageLink);
        addProductBody.setCategory(defaultCategory);
    }
}
