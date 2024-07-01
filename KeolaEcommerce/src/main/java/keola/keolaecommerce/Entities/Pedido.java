package keola.keolaecommerce.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import java.util.List;

@Data
@Document(collection = "pedidos")
@Getter
@Setter
public class Pedido {
    @Id
    private String id;

    private Cliente cliente;

    private List<Producto> productos;

    private BigDecimal total;
}