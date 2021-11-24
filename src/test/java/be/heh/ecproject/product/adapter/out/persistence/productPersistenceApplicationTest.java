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
@Import({productPersistenceApplication.class})
public class productPersistenceApplicationTest {
    @Autowired
    private ProductRepository productRepository;
    //@Autowired
    //private PersonPersistenceAdapter personPersistenceAdapter;
    private ProductPersistenceAdapter productPersistenceAdapter;

    /*@Container
    public GenericContainer postgres = new GenericContainer(DockerImageName.parse("postgres:13"))
            .withExposedPorts(5432,5432).withEnv("POSTGRES_PASSWORD","root");*/

    @ClassRule
    @Container
    public static PostgreSQLContainer conteneur = (PostgreSQLContainer) new PostgreSQLContainer(DockerImageName.parse("postgres:13")).
            withPassword("root").
            withDatabaseName("postgres").
            withUsername("postgres");

    @Test
    @Sql({"createTable.sql","PersonPersistenceAdapterTests.sql"})
    void getAllPersons(){
        conteneur.start();
        productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> prod;

        map = productPersistenceAdapter.getProduct();

        prod = (ArrayList<Product>)map.get("personnes");

        System.out.println(prod.get(1).getFirstName());

        assertEquals("tata1",prod.get(1).getFirstName());
        assertEquals("tutu1",prod.get(1).getLastName());
        assertEquals(21,prod.get(1).getAge());

    }
}
