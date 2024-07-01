package keola.keolaecommerce.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Table("productos")
@Getter
@Setter
@NoArgsConstructor
public class Producto {
    @Id
    private Long id;
    private String nombre;
    private BigDecimal precio;
    public Producto(String nombre,BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
