package be.heh.ecproject.product.adapter.out.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COMMAND_DATA")
@Data
public class CommandJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "commandId")
    private int commandId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "productId")
    private String productId;

    @Column(name = "email")
    private String email;

}
