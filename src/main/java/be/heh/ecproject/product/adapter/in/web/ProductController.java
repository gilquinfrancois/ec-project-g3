package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.adapter.out.persistence.AllProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/sorting")
    public Map<String, Object> sortProducts(String value)
    {
        return  allProductUseCase.sortProducts(value);
    }
}
