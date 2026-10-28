// en nuestro main que es la clase principal tenemos las siguientes librerias LocalDateTime, para fecha, ChronoUnit para conteo de minutos,
// Collectors para poder agrupar nuestros datos, IntStream para datos tipos int, luego tenemos una lista de la clase RegistroUsuario la cual se le asigna
// un alias de resgitro para poder llamar sus metodos, luego con una List.of se agrega informacion simulada para poder hacer los analisis cada uno
// con su new para una nueva linea donde tenemos en el idUsuario, ruta, estacion, accion, timestamp para poder llenar nuestros datos como es debido.


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<RegistroUsuario> registro = List.of(
                new RegistroUsuario("U1", "ruta1","Poblado","Entrada",LocalDateTime.of(2026,10,10,8,10)),
                new RegistroUsuario("U2","ruta2","La Estrella", "Salida", LocalDateTime.of(2026, 10, 10,12,15)),
                new RegistroUsuario("U3", "ruta3","Niquia", "Entrada", LocalDateTime.of(2026,10,10,13,45)),
                new RegistroUsuario("U4","ruta1", "Poblado", "Salida", LocalDateTime.of(2026,10,10,14,54)),
                new RegistroUsuario("U2","ruta3","Niquia", "Salida",LocalDateTime.of(2026,10,10,16,32)),
                new RegistroUsuario("U1","ruta3", "Niquia", "Entrada",LocalDateTime.of(2026,10,10,8,40)),
                new RegistroUsuario("U1","ruta3", "La Estrella", "Entrada",LocalDateTime.of(2026,10,10,19,40)),
                new RegistroUsuario("U3","ruta4", "Sabaneta", "Entrada",LocalDateTime.of(2026,10,10,19,40)),
                new RegistroUsuario("U4","ruta1", "Poblado", "Salida", LocalDateTime.of(2026,10,10,18,54))
                );
// en esta linea se nos pide cuantos usuarios entran por dias a casa estacion donde hacemos un Map donde debemos tener un dato tipo String para la salida del nombre de las estaciones
// el tipo Long nos sirve para el conteo de personas por estacion, lo ponemos en una variable donde le asignamos el resgistro.stream() para poder llamar
// las interfaces funcionales con operaciones intermedias y terminales para poder hacer los procesos, con el .filter hacemos una condicion donde el atributo accion
// solo debe tener en cuenta el dato Entrada, con el .collect es una operacion para hacer una lista, un conjunto o mapa, luego llamamos al Collectors.groupingBy
// para agrupar los valores clave, valor. luego le decimos que los agrupe por el atributo estacion de la clase RegistroUsuario, y por ultimo hacemos el conteo por entrada con RegistroUsuario
        Map<String,Long> ContarEstacion = registro.stream()
                .filter(s -> s.accion().equals("Entrada"))
                .collect(Collectors.groupingBy(
                        RegistroUsuario::estacion,
                        Collectors.counting()
                ));

        System.out.println("cantidad de usuario por estacion: "+ContarEstacion);
// en esta linea se nos pide que agrupemos por hora en las estaciones, por lo cual usamos un Map para poder hacer una collecion
// este nos quiere indicar que va devolver una llave y un valor donde la llave es igual a la hora y el valor de la cantidad de esa hora
// se agrupa por el dato timestamp que es la fecha completa y luego se llama con getHour a la hora para poder hacer el proceso
// luego se hace el conteo por hora y es asi como arroja dichos resultados.
        Map<Integer, Long> horaPicoFlujo = registro.stream()
                .collect(Collectors.groupingBy(
                        usuario -> usuario.timestamp().getHour(),
                        Collectors.counting()
                ));
        System.out.println("agrupacion resgistro por horas: "+ horaPicoFlujo);

       Map.Entry<Integer, Long> maxFlujo = horaPicoFlujo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
               .orElse(null);
        System.out.println("El momento de mayor flujo es el horario de : "+ maxFlujo);


       Map<String, Long> rutaMayoracceso = registro.stream()
               .collect(Collectors.groupingBy(
                       RegistroUsuario::ruta,
                       Collectors.counting()
               ));
       rutaMayoracceso.entrySet().stream()
                       .filter(entradas ->entradas.getValue() > 1)
                               .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                                       .forEach(entrada -> System.out.println("Ruta: "+ entrada.getKey() + " accesos: "+entrada.getValue()));


       Map<String, Collection<String>> estacionesVisitadas = registro.stream()
               .collect(Collectors.groupingBy(
                       RegistroUsuario::idUsuario,
                       Collectors.mapping(
                               RegistroUsuario::estacion,
                               Collectors.toCollection(LinkedHashSet::new))

               ));
                estacionesVisitadas.forEach((idUsuario, estacion) ->
                        System.out.println(idUsuario + " Estacion visitada: "+ estacion));

       var tiempoRecorrido = IntStream.range(0, registro.size()-1)
               .filter(i -> registro.get(i).idUsuario().equals(registro.get(i + 1).idUsuario()))
               .mapToObj(i -> new AbstractMap.SimpleEntry<>(
                       registro.get(i).estacion() + " -> " + registro.get(i + 1).estacion(),
                       ChronoUnit.MINUTES.between(registro.get(i).timestamp(), registro.get(i + 1).timestamp())
               ))
               .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.averagingLong(AbstractMap.SimpleEntry::getValue)));
       tiempoRecorrido.forEach((distancia, tiempo) -> System.out.println(distancia + " toma: "+ tiempo + " en minutos"));


       Map<String, Long> superarUmbral = registro.stream()
               .collect(Collectors.groupingBy(
                       RegistroUsuario::ruta,
                       Collectors.counting()
               ));
       List<String> rutaCritica = superarUmbral.entrySet().stream()
               .map(e ->{
                   String ruta = e.getKey();
                   Long ocupacion = e.getValue();

                   String umbral = (ocupacion > 2) ? "CRITICA" : "NORMAL";

                   return String.format("Ruta: %s | Ocupacion: %d | Estado: %s", ruta, ocupacion,umbral);
               })

               .toList();
       rutaCritica.forEach(System.out::println);

    }





}
