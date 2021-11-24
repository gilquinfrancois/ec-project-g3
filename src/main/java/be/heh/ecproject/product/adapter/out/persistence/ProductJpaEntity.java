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
    private Long id;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private String category;

    @Column(name = "productName")
    private String productName;

    @Column(name = "description")
    private String description;
}