package be.heh.ecproject.product.adapter.out.persistence;
        import lombok.Data;

        import javax.persistence.*;
        import java.util.UUID;

@Entity
@Table(name = "productName")
@Data
public class ProductJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private String price;

    @Column(name = "category")
    private String category;

    @Column(name = "productName")
    private String productName;
}