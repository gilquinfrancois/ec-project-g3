package be.heh.ecproject.product.adapter.out.persistence;
import be.heh.ecproject.product.domain.Product;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ActiveProfiles("dev")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({ProductPersistenceAdapter.class})
public class productPersistenceApplicationTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Sql({"productData.sql"})
    void getAllProducts(){
        ProductPersistenceAdapter productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> prod;

        map = productPersistenceAdapter.getProducts();

        prod = (ArrayList<Product>)map.get("products");

        System.out.println(prod.get(0).getProduct_name());

        assertEquals("Lentils - Green Le Puy",prod.get(0).getProduct_name());
        assertEquals("condiments",prod.get(0).getCategory());
        assertEquals(35.77,prod.get(0).getPrice());
    }

    @ParameterizedTest
    @ValueSource(strings = "tomato")
    void getProductsWithName(String value) {
        ProductPersistenceAdapter productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> prod;

        map = productPersistenceAdapter.getProducts();

        prod = (ArrayList<Product>)map.get("products");

        int id = 0;
        boolean hasName = false;

        try {
            while(!hasName || id > 1000) {
                if(prod.get(id).getProduct_name().toLowerCase().contains(value.toLowerCase())) {
                    hasName = true;
                } else {
                    id++;
                }
            }

            System.out.println(prod.get(id).getProduct_name());

            assertEquals("Tomato - Tricolor Cherry",prod.get(id).getProduct_name());
            assertEquals("viande",prod.get(id).getCategory());
            assertEquals(21.91,prod.get(id).getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ParameterizedTest
    @ValueSource(strings = "condiments")
    void getProductsWithCategory(String category) {
        ProductPersistenceAdapter productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> prod;

        map = productPersistenceAdapter.getProducts();

        prod = (ArrayList<Product>)map.get("products");

        int id = 0;
        boolean hasCategory = false;

        try {
            while(!hasCategory || id > 1000) {
                if(prod.get(id).getCategory().equalsIgnoreCase(category)) {
                    hasCategory = true;
                } else {
                    id++;
                }
            }

            System.out.println(prod.get(id).getProduct_name());

            assertEquals("Lentils - Green Le Puy",prod.get(id).getProduct_name());
            assertEquals("condiments",prod.get(id).getCategory());
            assertEquals(35.77,prod.get(id).getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @ParameterizedTest
    @ValueSource(ints = 0)
    void getProductDetail(int id) {
        ProductPersistenceAdapter productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> prod;

        map = productPersistenceAdapter.getProducts();

        prod = (ArrayList<Product>)map.get("products");

        System.out.println(prod.get(id).getProduct_name());

        assertEquals("Lentils - Green Le Puy",prod.get(id).getProduct_name());
        assertEquals("condiments",prod.get(id).getCategory());
        assertEquals(35.77,prod.get(id).getPrice());

    }
}
