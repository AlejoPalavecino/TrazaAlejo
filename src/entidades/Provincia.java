package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@SuperBuilder
public class Provincia {
    private Long id;
    private String nombre;
    private Set<Localidad> localidades = new HashSet<>();
    private Pais pais;

}
