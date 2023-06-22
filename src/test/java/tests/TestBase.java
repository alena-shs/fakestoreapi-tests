package tests;

import config.ProjectConfiguration;
import models.CartBody;
import models.ProductBody;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Configuration.baseUrl;
import static tests.TestData.*;

public class TestBase {
    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();
    CartBody cartBody = new CartBody();
    CartBody.ListProductsData product = new CartBody.ListProductsData();
    ProductBody addProductBody = new ProductBody();
    ProductBody updateProductBody = new ProductBody();

    @BeforeAll
    static void beforeAll() {
        projectConfiguration.configure();
    }

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
