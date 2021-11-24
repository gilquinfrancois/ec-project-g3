package be.heh.ecproject.product.adapter.in.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

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
        //Méthode à coder pour les tests
    }
}
