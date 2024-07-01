package keola.keolaecommerce.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    private Long id;
    private String nombre;
    private String email;
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}
