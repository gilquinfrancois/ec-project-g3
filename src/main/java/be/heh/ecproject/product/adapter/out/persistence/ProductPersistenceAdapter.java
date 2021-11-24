package be.heh.ecproject.product.adapter.out.persistence;
        import lombok.RequiredArgsConstructor;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements AllProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Map<String, Object> getProduct() {
        List<ProductJpaEntity> productJpaList = productRepository.findAll();
        //mapper
        List<Product> productList = new ArrayList<>();
        Map<String,Object> mapProd = new HashMap<>();

        for (ProductJpaEntity prod: productJpaList) {
            productList.add(new Product(prod.id(),prod.productName(),prod.price(),prod.category()));
        }
        //---
        mapProd.put("product",productList);
        return mapProd;
    }
}
