package be.heh.ecproject.product.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements AllProductUseCase{

    @Autowired
    private final ProductRepository productRepository;



    @Override
    public Map<String, Object> getProduct() {
        List<ProductJpaEntity> productJpaList = productRepository.findAll();
        //mapper
        List<Product> productList = new ArrayList<>();
        Map<String,Object> mapProd = new HashMap<>();
        Product product;

        for (ProductJpaEntity prod: productJpaList) {
            product = new Product(prod.getId(),prod.getProduct_name(),prod.getPrice(),prod.getCategory(),prod.getDescription());
            productList.add(product);
        }
        //---
        mapProd.put("products",productList);
        return mapProd;
    }
}
