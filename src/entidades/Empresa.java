package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude = "sucursales")  // Excluir sucursales para evitar recursión infinita

public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<Sucursal> sucursales = new HashSet<>();
}
