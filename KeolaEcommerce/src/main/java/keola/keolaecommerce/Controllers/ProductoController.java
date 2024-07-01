package keola.keolaecommerce.Controllers;

import keola.keolaecommerce.Entities.Producto;
import keola.keolaecommerce.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public Flux<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Producto> getProductoById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public Mono<Producto> createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Mono<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProducto(@PathVariable Long id) {
        return productoService.delete(id);
    }
}
