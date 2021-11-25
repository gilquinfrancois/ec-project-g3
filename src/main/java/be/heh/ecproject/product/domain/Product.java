package be.heh.ecproject.product.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
public class Product {

    @Getter
    private final int id;
    @Getter
    private final String product_name;
    @Getter
    private final double price;
    @Getter
    private final String category;
    @Getter
    private final String description;
}