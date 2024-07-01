package keola.keolaecommerce.Services;

import keola.keolaecommerce.Entities.Producto;
import keola.keolaecommerce.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Flux<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Mono<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Mono<Producto> save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Mono<Producto> update(Long id, Producto producto) {
        return productoRepository.findById(id)
                .flatMap(existingProducto -> {
                    existingProducto.setNombre(producto.getNombre());
                    existingProducto.setPrecio(producto.getPrecio());
                    // Update other fields as necessary
                    return productoRepository.save(existingProducto);
                });
    }

    public Mono<Void> delete(Long id) {
        return productoRepository.deleteById(id);
    }
}
