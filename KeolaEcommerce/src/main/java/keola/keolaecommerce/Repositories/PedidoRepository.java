package keola.keolaecommerce.Repositories;

import keola.keolaecommerce.Entities.Pedido;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends ReactiveMongoRepository<Pedido, String> {

}
