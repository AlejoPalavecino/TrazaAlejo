import entidades.*;
import repositorios.InMemoryRepository;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("EJERCICIO TRAZA 1 - ALEJO PALAVECINO - 3K10");
        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();

        Pais Arg = Pais.builder()
                .id(1L)
                .nombre("Argentina")
                .build();

        Provincia BuenosAires = Provincia.builder()
                .id(1L)
                .nombre("Buenos Aires")
                .pais(Arg)
                .build();
        Localidad CABA = Localidad.builder()
                .provincia(BuenosAires)
                .id(1L)
                .nombre("CABA")
                .build();
        Domicilio domicilio1 = Domicilio.builder()
                .localidad(CABA)
                .calle("CalleFalsa")
                .numero(123)
                .id(1L)
                .build();
        Localidad LaPlata = Localidad.builder()
                .nombre("La Plata")
                .provincia(BuenosAires)
                .id(2L)
                .build();
        Domicilio domicilio2 = Domicilio.builder()
                .id(2L)
                .calle("SiempreViva")
                .numero(142)
                .localidad(LaPlata)
                .build();
        Provincia Cordoba = Provincia.builder()
                .id(2L)
                .nombre("Cordoba")
                .pais(Arg)
                .build();
        Localidad CordobaCapital = Localidad.builder()
                .id(3L)
                .nombre("Cordoba Capital")
                .provincia(Cordoba)
                .build();
        Domicilio domicilio3 = Domicilio.builder()
                .id(3L)
                .calle("KAVA")
                .numero(332)
                .localidad(CordobaCapital)
                .build();
        Localidad VillaCarlosPaz = Localidad.builder()
                .id(3L)
                .nombre("Villa Carlos Paz")
                .provincia(Cordoba)
                .build();
        Domicilio domicilio4 = Domicilio.builder()
                .id(3L)
                .calle("Paraguay")
                .numero(221)
                .localidad(VillaCarlosPaz)
                .build();
        Sucursal s1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 1")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio1)
                .build();

        Sucursal s2 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio2)
                .build();

        Sucursal s3 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 3")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio3)
                .build();

        Sucursal s4 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 4")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio4)
                .build();

        Empresa e1 = Empresa.builder()
                .nombre("Empresa 1")
                .razonSocial("Razon Social 1")
                .cuil(12345678901L)
                .sucursales(new HashSet<>(Set.of(s1, s2)))
                .build();
        Empresa e2 = Empresa.builder()
                .nombre("Empresa 2")
                .razonSocial("Razon Social 2")
                .cuil(12345662812L)
                .sucursales(new HashSet<>(Set.of(s3, s4)))
                .build();

        // Asignar empresa a sucursales
        s1.setEmpresa(e1);
        s2.setEmpresa(e1);
        s3.setEmpresa(e2);
        s4.setEmpresa(e2);

        // Guardar empresas en el repositorio
        empresaRepository.save(e1);
        empresaRepository.save(e2);

        System.out.println("---LAS EMPRESAS SON---");
        List<Empresa> todasempresas =empresaRepository.findAll();
        todasempresas.forEach(System.out::println);


        Optional<Empresa> empresaEncontrada = empresaRepository.findById(1L);
        empresaEncontrada.ifPresent(e -> System.out.println("Empresa encontrada por ID 1: " + e));


        List<Empresa> empresasPorNombre = empresaRepository.genericFindByField("nombre", "Empresa 1");
        System.out.println("Empresas con nombre 'Empresa 1':");
        empresasPorNombre.forEach(System.out::println);


        Empresa empresaActualizada = Empresa.builder()
                .id(1L)
                .nombre("Empresa 1 Actualizada")
                .razonSocial("Razon Social 1 Actualizada")
                .cuil(12345678901L)
                .sucursales(e1.getSucursales())
                .build();

        empresaRepository.genericUpdate(1L, empresaActualizada);
        Optional<Empresa> empresaVerificada = empresaRepository.findById(1L);
        empresaVerificada.ifPresent(e -> System.out.println("Empresa después de la actualización: " + e));


        empresaRepository.genericDelete(1L);
        Optional<Empresa> empresaEliminada = empresaRepository.findById(1L);
        if (empresaEliminada.isEmpty()) {
            System.out.println("La empresa con ID 1 ha sido eliminada.");
        }


        System.out.println("Todas las empresas después de la eliminación:");
        List<Empresa> empresasRestantes = empresaRepository.findAll();
        empresasRestantes.forEach(System.out::println);
        System.out.println("--------------Mostrar las sucursales de una empresa determinada");


        Optional<Empresa> empresa = empresaRepository.findById(2L);
        if (empresa.isPresent()) {
            System.out.println("Sucursales de la empresa con ID "  + ":");
            Set<Sucursal> sucursales = empresa.get().getSucursales();
            sucursales.forEach(System.out::println);
        } else {
            System.out.println("Empresa con ID " + " no encontrada.");
        }

    }
}