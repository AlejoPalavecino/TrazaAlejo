package entidades;

import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude = "empresa")  // Excluir empresa para evitar recursión infinita
public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;
    private Domicilio domicilio;
    private Empresa empresa;
}