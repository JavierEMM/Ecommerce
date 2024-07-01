package keola.keolaecommerce.Services;

import keola.keolaecommerce.Entities.Producto;
import keola.keolaecommerce.Repositories.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    public void testFindAll() {
        when(productoRepository.findAll()).thenReturn(Flux.just(new Producto("Widget", BigDecimal.valueOf(19.99))));
        Flux<Producto> result = productoService.findAll();

        StepVerifier.create(result)
                .expectNextMatches(producto -> producto.getNombre().equals("Widget"))
                .verifyComplete();
    }

    @Test
    public void testSave() {
        Producto producto = new Producto("Gadget", BigDecimal.valueOf(29.99));
        when(productoRepository.save(producto)).thenReturn(Mono.just(producto));
        Mono<Producto> result = productoService.save(producto);

        StepVerifier.create(result)
                .expectNext(producto)
                .verifyComplete();
    }
}
