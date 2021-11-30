package be.heh.ecproject.product.adapter.out.persistence;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class ProductJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "description")
    private String description;
}