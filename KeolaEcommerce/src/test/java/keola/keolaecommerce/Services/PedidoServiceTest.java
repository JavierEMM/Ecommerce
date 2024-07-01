package keola.keolaecommerce.Services;

import keola.keolaecommerce.Entities.Pedido;
import keola.keolaecommerce.Repositories.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    public void testFindAll() {
        when(pedidoRepository.findAll()).thenReturn(Flux.just(new Pedido()));
        Flux<Pedido> result = pedidoService.findAll();

        StepVerifier.create(result)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void testFindById() {
        String id = "1";
        when(pedidoRepository.findById(id)).thenReturn(Mono.just(new Pedido()));
        Mono<Pedido> result = pedidoService.findById(id);

        StepVerifier.create(result)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void testSave() {
        Pedido pedido = new Pedido();
        when(pedidoRepository.save(pedido)).thenReturn(Mono.just(pedido));
        Mono<Pedido> result = pedidoService.save(pedido);

        StepVerifier.create(result)
                .expectNext(pedido)
                .verifyComplete();
    }

    @Test
    public void testDelete() {
        String id = "1";
        when(pedidoRepository.deleteById(id)).thenReturn(Mono.empty());
        Mono<Void> result = pedidoService.delete(id);

        StepVerifier.create(result)
                .verifyComplete();
        verify(pedidoRepository).deleteById(id);
    }
}
