package keola.keolaecommerce.Services;

import keola.keolaecommerce.Entities.Cliente;
import keola.keolaecommerce.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Flux<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Mono<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Mono<Cliente> save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Mono<Cliente> update(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .flatMap(existingCliente -> {
                    existingCliente.setNombre(cliente.getNombre());
                    existingCliente.setEmail(cliente.getEmail());
                    // Update other fields as necessary
                    return clienteRepository.save(existingCliente);
                });
    }

    public Mono<Void> delete(Long id) {
        return clienteRepository.deleteById(id);
    }
}
