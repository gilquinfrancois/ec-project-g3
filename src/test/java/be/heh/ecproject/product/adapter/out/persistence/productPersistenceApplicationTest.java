package be.heh.ecproject.product.adapter.out.persistence;
import be.heh.ecproject.product.domain.Product;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
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
}
