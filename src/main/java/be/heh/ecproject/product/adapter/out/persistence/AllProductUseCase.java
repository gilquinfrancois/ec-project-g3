package be.heh.ecproject.product.adapter.out.persistence;

import java.util.Map;

public interface AllProductUseCase {
    Map<String, Object> getProducts();

    Map<String, Object> getProductsWithName(String value);

    Map<String, Object> getProductsWithCategory(String category);

    Map<String, Object> getProductDetail(int productId);

}


