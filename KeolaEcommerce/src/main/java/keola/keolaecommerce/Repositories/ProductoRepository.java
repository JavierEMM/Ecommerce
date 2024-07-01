package keola.keolaecommerce.Repositories;

import keola.keolaecommerce.Entities.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {

}
