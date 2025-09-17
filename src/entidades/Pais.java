package entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Pais {
    private Long id;
    private String nombre;
    private Set<Provincia> provincias = new HashSet<>();

}