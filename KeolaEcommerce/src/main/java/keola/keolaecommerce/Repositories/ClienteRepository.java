package keola.keolaecommerce.Repositories;

import keola.keolaecommerce.Entities.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Long> {

}