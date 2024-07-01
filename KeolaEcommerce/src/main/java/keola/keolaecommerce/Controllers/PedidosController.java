package keola.keolaecommerce.Controllers;

import keola.keolaecommerce.Entities.Pedido;
import keola.keolaecommerce.Services.PedidoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidosController {
    private final PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public Flux<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Pedido> getPedidoById(@PathVariable String id) {
        return pedidoService.findById(id);
    }

    @PostMapping
    public Mono<Pedido> createPedido(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePedido(@PathVariable String id) {
        return pedidoService.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<Pedido> updatePedido(@PathVariable String id, @RequestBody Pedido pedido) {
        return pedidoService.findById(id)
                .flatMap(existingPedido -> {
                    existingPedido.setCliente(pedido.getCliente());
                    existingPedido.setProductos(pedido.getProductos());
                    existingPedido.setTotal(pedido.getTotal());
                    return pedidoService.save(existingPedido);
                });
    }
}