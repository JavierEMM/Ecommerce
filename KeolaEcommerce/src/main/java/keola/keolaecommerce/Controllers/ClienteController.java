package keola.keolaecommerce.Controllers;
import keola.keolaecommerce.Entities.Cliente;
import keola.keolaecommerce.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Flux<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Mono<Cliente> createCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public Mono<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCliente(@PathVariable Long id) {
        return clienteService.delete(id);
    }
}
