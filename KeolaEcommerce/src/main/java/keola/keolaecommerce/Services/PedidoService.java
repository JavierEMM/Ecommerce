package keola.keolaecommerce.Services;

import keola.keolaecommerce.Entities.Pedido;
import keola.keolaecommerce.Repositories.PedidoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    public Flux<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Mono<Pedido> findById(String id) {
        return pedidoRepository.findById(id);
    }

    public Mono<Pedido> save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Mono<Void> delete(String id) {
        return pedidoRepository.deleteById(id);
    }
}
