package be.heh.ecproject.product.adapter.out.persistence;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({productPersistenceAdapter.class})
public class productPersistenceApplicationTest {
    @Autowired
    private ProductRepository productRepository;
    //@Autowired
    //private PersonPersistenceAdapter personPersistenceAdapter;
    private productPersistenceAdapter productPersistenceAdapter;

    @Container
    public GenericContainer postgres = new GenericContainer(DockerImageName.parse("postgres:13"))
            .withExposedPorts(5432,5432).withEnv("POSTGRES_PASSWORD","root");

    @ClassRule
    @Container
    public static PostgreSQLContainer conteneur = (PostgreSQLContainer) new PostgreSQLContainer(DockerImageName.parse("postgres:13")).
            withPassword("root").
            withDatabaseName("postgres").
            withUsername("postgres");

    @Test
    @Sql({"createTable.sql","ProductPersistenceTest.sql"})
    void getAllProducts(){
        conteneur.start();
        productPersistenceAdapter = new productPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> prod;

        map = productPersistenceAdapter.getProduct();

        prod = (ArrayList<Product>)map.get("products");

        System.out.println(prod.get(1).getProductName());

        assertEquals("pain",prod.get(1).getProductName());
        assertEquals("feculents",prod.get(1).getCategory());
        assertEquals(2.5,prod.get(1).getPrice());

    }
}
