package be.heh.ecproject.product.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("prod")
@Configuration
@EnableJpaRepositories
public class persistenceAdapterConfiguration {
    @Autowired
    private ProductRepository productRepository;
    @Bean
    AllProductUseCase getAllPersonUseCase(){
        return new productPersistenceAdapter(productRepository);
    }
}
