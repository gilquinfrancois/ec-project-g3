package be.heh.ecproject.product.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class productPersistenceAdapter implements AllProductUseCase{

    private final ProductRepository productRepository;

    @Override
    public Map<String, Object> getProduct() {
        List<ProductJpaEntity> productJpaList = productRepository.findAll();
        //mapper
        List<Product> productList = new ArrayList<>();
        Map<String,Object> mapProd = new HashMap<>();

        for (ProductJpaEntity prod: productJpaList) {
            productList.add(new Product(prod.getId(),prod.getProductName(),prod.getPrice(),prod.getCategory(),prod.getDescription()));
        }
        //---
        mapProd.put("products",productList);
        return mapProd;
    }
}
