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
    public Map<String, Object> getProductsWithName(@RequestParam String search) {
        return allProductUseCase.getProductsWithName(search);
    }

    @GetMapping("/sorting")
    public Map<String, Object> sortProducts(String value)
    {
        return  allProductUseCase.sortProducts(value);
    }

}
