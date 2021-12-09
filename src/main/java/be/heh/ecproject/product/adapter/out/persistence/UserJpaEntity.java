package be.heh.ecproject.product.adapter.out.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_DATA")
@Data
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

}
