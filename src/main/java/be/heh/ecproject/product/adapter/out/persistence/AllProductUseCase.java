package be.heh.ecproject.product.adapter.out.persistence;

import java.util.Map;

public interface AllProductUseCase {
    Map<String, Object> getProducts();
    Map<String, Object> sortProducts(String value);
}


