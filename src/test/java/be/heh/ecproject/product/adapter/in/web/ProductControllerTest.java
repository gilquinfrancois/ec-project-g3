package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.adapter.out.persistence.AllProductUseCase;
import be.heh.ecproject.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@ActiveProfiles("dev")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ProductControllerTest
{
    @LocalServerPort
    private int port;

    @MockBean
    private AllProductUseCase allProductUseCase;

    @Test
    void getAllProduct()
    {

        Product product1 = new Product(1, "Lentils - Green Le Puy", 35.77, "condiments", "consequat varius integer");
        Product product2 = new Product(2, "Uniform Linen Charge", 91.4, "fruits", "mauris lacinia sapien quis libero");
        Product product3 = new Product(3, "Wine - Beringer Founders Estate", 29.67, "condiments", "consequat dui nec nisi volutpat");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Map<String, Object> productMap = new LinkedHashMap<>();
        productMap.put("products", products);

        //Stub
        Mockito.when(allProductUseCase.getProducts()).thenReturn(productMap);

        baseURI = "http://localhost/api";
        given().
                port(port).
        when().
                get("/products").
        then().
                statusCode(200).
                body("products[1].product_name", equalTo("Uniform Linen Charge")).
                body("products.product_name", hasItems("Lentils - Green Le Puy", "Uniform Linen Charge", "Wine - Beringer Founders Estate"));

    }
}