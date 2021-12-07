package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.adapter.out.persistence.AllProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api", produces = "application/json")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class ProductController
{
    private final AllProductUseCase allProductUseCase;

    @GetMapping("/products")
    public Map<String, Object> getProducts()
    {
        return allProductUseCase.getProducts();
    }

    @GetMapping("/searchName")
    public Map<String, Object> getProductsWithName(@RequestParam String productName) {
        return allProductUseCase.getProductsWithName(productName);
    }

    @GetMapping("/searchCategory")
    public Map<String, Object> getProductsWithCategory(@RequestParam String category) {
        return allProductUseCase.getProductsWithCategory(category);
    }

    @GetMapping("/productDetail")
    public Map<String, Object> getProductDetail(@RequestParam int productId) {
        return allProductUseCase.getProductDetail(productId);
    }
}
