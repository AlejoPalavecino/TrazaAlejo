package entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@SuperBuilder
public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;
}