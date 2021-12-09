package be.heh.ecproject.product.adapter.out.persistence;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMMAND_DATA")
@Data
public class CommandJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "commandId")
    private int commandId;

    @Column(name = "userId")
    private int userId;

    @Type(type="type-array")
    @Column(name = "productId")
    private List<Integer> productId;

}
