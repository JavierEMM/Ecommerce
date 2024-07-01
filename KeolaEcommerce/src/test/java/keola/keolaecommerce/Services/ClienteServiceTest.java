package keola.keolaecommerce.Services;

import keola.keolaecommerce.Entities.Cliente;
import keola.keolaecommerce.Repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testFindAll() {
        when(clienteRepository.findAll()).thenReturn(Flux.just(new Cliente("John Doe", "johndoe@example.com")));
        Flux<Cliente> result = clienteService.findAll();

        StepVerifier.create(result)
                .expectNextMatches(cliente -> cliente.getNombre().equals("John Doe"))
                .verifyComplete();
    }

    @Test
    public void testSave() {
        Cliente cliente = new Cliente("Jane Doe", "janedoe@example.com");
        when(clienteRepository.save(cliente)).thenReturn(Mono.just(cliente));
        Mono<Cliente> result = clienteService.save(cliente);

        StepVerifier.create(result)
                .expectNext(cliente)
                .verifyComplete();
    }
}
