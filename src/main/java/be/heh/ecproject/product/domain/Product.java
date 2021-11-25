package be.heh.ecproject.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Product
{
    @Getter
    private final int id;

    @Getter
    private final String nameProduct;

    @Getter
    private final double price;

    @Getter
    private final String category;

    @Getter
    private final String description;
}
