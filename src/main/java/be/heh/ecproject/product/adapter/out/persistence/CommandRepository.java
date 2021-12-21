package be.heh.ecproject.product.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface CommandRepository extends JpaRepository<CommandJpaEntity,Long> {

}

