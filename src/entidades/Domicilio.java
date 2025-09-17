package entidades;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude = "localidad")  // Excluir localidad para evitar recursión infinita

public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Localidad localidad;
}