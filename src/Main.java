import java.util.List;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<RegistroUsuario> registro = List.of(
                new RegistroUsuario("U1", "ruta1","Poblado","Entrada",LocalDateTime.of(2026,10,10,8,10)),
                new RegistroUsuario("U2","ruta2","La Estrella", "Salida", LocalDateTime.of(2026, 10, 10,12,15)),
                new RegistroUsuario("U3", "ruta3","Niquia", "Entrada", LocalDateTime.of(2026,10,10,13,45)),
                new RegistroUsuario("U4","ruta1", "Poblado", "Salida", LocalDateTime.of(2026,10,10,14,54)),
                new RegistroUsuario("U2","ruta2","La Estrella", "Salida",LocalDateTime.of(2026,10,10,16,32)),
                new RegistroUsuario("U1","ruta3", "Niquia", "Entrada",LocalDateTime.of(2026,10,10,8,40))
        );

        Map<String,Long> ContarEstacion = registro.stream()
                .collect(Collectors.groupingBy(
                        RegistroUsuario::estacion,
                        Collectors.counting()
                ));

        System.out.println("cantidad de usuario por estacion: "+ContarEstacion);

        Map<Integer, Long> horaPicoFlujo = registro.stream()
                .collect(Collectors.groupingBy(
                        usuario -> usuario.timestamp().getHour(),
                        Collectors.counting()
                ));
        System.out.println("agrupacion resgistro por horas: "+ horaPicoFlujo);

       Map.Entry<Integer, Long> maxFlujo = horaPicoFlujo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
               .orElse(null);
        System.out.println("El momento de mayor flujo es: "+ maxFlujo);
    }
}
