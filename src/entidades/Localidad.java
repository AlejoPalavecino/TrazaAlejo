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

public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;
    private Set<Domicilio> domicilios = new HashSet();
}