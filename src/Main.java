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
                new RegistroUsuario("U3","ruta4", "Sabaneta", "Entrada",LocalDateTime.of(2026,10,10,20,40)),
                new RegistroUsuario("U4","ruta1", "Poblado", "Salida", LocalDateTime.of(2026,10,10,18,54)),
                new RegistroUsuario("U5", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 11, 6, 15)),
                new RegistroUsuario("U6", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 11, 6, 45)),
                new RegistroUsuario("U1", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 11, 7, 20)),
                new RegistroUsuario("U5", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 11, 7, 55)),
                new RegistroUsuario("U2", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 11, 8, 10)),
                new RegistroUsuario("U6", "ruta4", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 11, 8, 30)),
                new RegistroUsuario("U3", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 11, 9, 05)),
                new RegistroUsuario("U1", "ruta1", "Niquia", "Salida", LocalDateTime.of(2026, 10, 11, 10, 12)),
                new RegistroUsuario("U4", "ruta2", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 11, 11, 40)),
                new RegistroUsuario("U2", "ruta3", "Poblado", "Salida", LocalDateTime.of(2026, 10, 11, 12, 02)),
                new RegistroUsuario("U3", "ruta1", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 11, 13, 15)),
                new RegistroUsuario("U7", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 11, 14, 22)),
                new RegistroUsuario("U4", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 11, 15, 10)),
                new RegistroUsuario("U5", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 11, 16, 45)),
                new RegistroUsuario("U7", "ruta3", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 11, 17, 30)),
                new RegistroUsuario("U1", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 11, 18, 00)),
                new RegistroUsuario("U5", "ruta4", "Niquia", "Salida", LocalDateTime.of(2026, 10, 11, 19, 15)),
                new RegistroUsuario("U6", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 11, 20, 05)),
                new RegistroUsuario("U1", "ruta1", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 11, 21, 10)),
                new RegistroUsuario("U6", "ruta2", "Niquia", "Salida", LocalDateTime.of(2026, 10, 11, 22, 00)),
                new RegistroUsuario("U2", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 12, 06, 30)),
                new RegistroUsuario("U3", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 12, 07, 15)),
                new RegistroUsuario("U2", "ruta1", "Niquia", "Salida", LocalDateTime.of(2026, 10, 12, 8, 45)),
                new RegistroUsuario("U8", "ruta3", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 12, 9, 10)),
                new RegistroUsuario("U3", "ruta4", "Poblado", "Salida", LocalDateTime.of(2026, 10, 12, 10, 05)),
                new RegistroUsuario("U5", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 11, 6, 15)),
                new RegistroUsuario("U6", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 11, 6, 45)),
                new RegistroUsuario("U1", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 11, 7, 20)),
                new RegistroUsuario("U5", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 11, 7, 55)),
                new RegistroUsuario("U2", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 11, 8, 10)),
                new RegistroUsuario("U6", "ruta4", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 11, 8, 30)),
                new RegistroUsuario("U3", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 11, 9, 5)),
                new RegistroUsuario("U1", "ruta1", "Niquia", "Salida", LocalDateTime.of(2026, 10, 11, 10, 12)),
                new RegistroUsuario("U4", "ruta2", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 11, 11, 40)),
                new RegistroUsuario("U2", "ruta3", "Poblado", "Salida", LocalDateTime.of(2026, 10, 11, 12, 2)),
                new RegistroUsuario("U3", "ruta1", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 11, 13, 15)),
                new RegistroUsuario("U7", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 11, 14, 22)),
                new RegistroUsuario("U4", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 11, 15, 10)),
                new RegistroUsuario("U5", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 11, 16, 45)),
                new RegistroUsuario("U7", "ruta3", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 11, 17, 30)),
                new RegistroUsuario("U1", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 11, 18, 0)),
                new RegistroUsuario("U5", "ruta4", "Niquia", "Salida", LocalDateTime.of(2026, 10, 11, 19, 15)),
                new RegistroUsuario("U6", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 11, 20, 5)),
                new RegistroUsuario("U1", "ruta1", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 11, 21, 10)),
                new RegistroUsuario("U6", "ruta2", "Niquia", "Salida", LocalDateTime.of(2026, 10, 11, 22, 0)),
                new RegistroUsuario("U2", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 12, 6, 30)),
                new RegistroUsuario("U3", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 12, 7, 15)),
                new RegistroUsuario("U2", "ruta1", "Niquia", "Salida", LocalDateTime.of(2026, 10, 12, 8, 45)),
                new RegistroUsuario("U8", "ruta3", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 12, 9, 10)),
                new RegistroUsuario("U3", "ruta4", "Poblado", "Salida", LocalDateTime.of(2026, 10, 12, 10, 5)),
                new RegistroUsuario("U8", "ruta3", "Niquia", "Salida", LocalDateTime.of(2026, 10, 12, 10, 50)),
                new RegistroUsuario("U5", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 12, 11, 15)),
                new RegistroUsuario("U1", "ruta2", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 12, 12, 30)),
                new RegistroUsuario("U5", "ruta1", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 12, 12, 45)),
                new RegistroUsuario("U4", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 12, 13, 20)),
                new RegistroUsuario("U1", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 12, 13, 55)),
                new RegistroUsuario("U6", "ruta1", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 12, 14, 10)),
                new RegistroUsuario("U4", "ruta3", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 12, 15, 2)),
                new RegistroUsuario("U2", "ruta4", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 12, 15, 40)),
                new RegistroUsuario("U6", "ruta1", "Niquia", "Salida", LocalDateTime.of(2026, 10, 12, 16, 5)),
                new RegistroUsuario("U7", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 12, 16, 50)),
                new RegistroUsuario("U2", "ruta4", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 12, 17, 15)),
                new RegistroUsuario("U3", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 12, 18, 10)),
                new RegistroUsuario("U7", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 12, 18, 35)),
                new RegistroUsuario("U3", "ruta3", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 12, 19, 20)),
                new RegistroUsuario("U1", "ruta1", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 13, 5, 50)),
                new RegistroUsuario("U5", "ruta4", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 13, 6, 12)),
                new RegistroUsuario("U2", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 13, 6, 40)),
                new RegistroUsuario("U1", "ruta1", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 7, 18)),
                new RegistroUsuario("U5", "ruta4", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 7, 35)),
                new RegistroUsuario("U2", "ruta2", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 8, 5)),
                new RegistroUsuario("U6", "ruta3", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 13, 9, 30)),
                new RegistroUsuario("U8", "ruta1", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 13, 10, 15)),
                new RegistroUsuario("U6", "ruta3", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 11, 4)),
                new RegistroUsuario("U8", "ruta1", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 11, 55)),
                new RegistroUsuario("U2", "ruta1", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 6, 27)),
                new RegistroUsuario("U4", "ruta2", "Bello", "Entrada", LocalDateTime.of(2026, 10, 13, 6, 49)),
                new RegistroUsuario("U2", "ruta4", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 13, 6, 56)),
                new RegistroUsuario("U4", "ruta2", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 7, 18)),
                new RegistroUsuario("U4", "ruta4", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 7, 41)),
                new RegistroUsuario("U5", "ruta1", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 13, 7, 59)),
                new RegistroUsuario("U6", "ruta3", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 13, 8, 14)),
                new RegistroUsuario("U2", "ruta1", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 13, 8, 30)),
                new RegistroUsuario("U6", "ruta3", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 13, 8, 49)),
                new RegistroUsuario("U9", "ruta1", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 13, 9, 11)),
                new RegistroUsuario("U5", "ruta3", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 9, 18)),
                new RegistroUsuario("U1", "ruta2", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 13, 9, 25)),
                new RegistroUsuario("U4", "ruta1", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 13, 9, 44)),
                new RegistroUsuario("U6", "ruta2", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 9, 55)),
                new RegistroUsuario("U5", "ruta1", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 10, 17)),
                new RegistroUsuario("U4", "ruta2", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 13, 10, 30)),
                new RegistroUsuario("U9", "ruta2", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 10, 36)),
                new RegistroUsuario("U4", "ruta1", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 13, 10, 53)),
                new RegistroUsuario("U5", "ruta1", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 11, 4)),
                new RegistroUsuario("U8", "ruta4", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 11, 13)),
                new RegistroUsuario("U5", "ruta2", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 11, 36)),
                new RegistroUsuario("U7", "ruta4", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 13, 11, 45)),
                new RegistroUsuario("U9", "ruta4", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 13, 11, 53)),
                new RegistroUsuario("U3", "ruta2", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 13, 12, 17)),
                new RegistroUsuario("U2", "ruta4", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 13, 12, 38)),
                new RegistroUsuario("U5", "ruta1", "Bello", "Entrada", LocalDateTime.of(2026, 10, 13, 13, 0)),
                new RegistroUsuario("U5", "ruta3", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 13, 18)),
                new RegistroUsuario("U3", "ruta4", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 13, 39)),
                new RegistroUsuario("U3", "ruta1", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 13, 14, 4)),
                new RegistroUsuario("U9", "ruta2", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 14, 14)),
                new RegistroUsuario("U9", "ruta1", "Envigado", "Salida", LocalDateTime.of(2026, 10, 13, 14, 34)),
                new RegistroUsuario("U1", "ruta1", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 14, 46)),
                new RegistroUsuario("U1", "ruta2", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 14, 53)),
                new RegistroUsuario("U8", "ruta1", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 13, 15, 2)),
                new RegistroUsuario("U8", "ruta2", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 15, 13)),
                new RegistroUsuario("U9", "ruta2", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 15, 30)),
                new RegistroUsuario("U6", "ruta4", "Envigado", "Salida", LocalDateTime.of(2026, 10, 13, 15, 38)),
                new RegistroUsuario("U4", "ruta2", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 15, 43)),
                new RegistroUsuario("U10", "ruta2", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 15, 48)),
                new RegistroUsuario("U2", "ruta1", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 13, 15, 54)),
                new RegistroUsuario("U6", "ruta1", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 16, 7)),
                new RegistroUsuario("U8", "ruta2", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 16, 30)),
                new RegistroUsuario("U10", "ruta4", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 16, 48)),
                new RegistroUsuario("U4", "ruta1", "Poblado", "Salida", LocalDateTime.of(2026, 10, 13, 17, 4)),
                new RegistroUsuario("U7", "ruta4", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 13, 17, 29)),
                new RegistroUsuario("U2", "ruta1", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 13, 17, 37)),
                new RegistroUsuario("U4", "ruta2", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 17, 46)),
                new RegistroUsuario("U7", "ruta2", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 17, 58)),
                new RegistroUsuario("U2", "ruta4", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 13, 18, 4)),
                new RegistroUsuario("U9", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 13, 18, 14)),
                new RegistroUsuario("U7", "ruta4", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 13, 18, 31)),
                new RegistroUsuario("U1", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 13, 18, 48)),
                new RegistroUsuario("U5", "ruta4", "Niquia", "Salida", LocalDateTime.of(2026, 10, 13, 19, 10)),
                new RegistroUsuario("U8", "ruta2", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 19, 21)),
                new RegistroUsuario("U1", "ruta1", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 19, 27)),
                new RegistroUsuario("U1", "ruta4", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 19, 33)),
                new RegistroUsuario("U9", "ruta1", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 13, 19, 40)),
                new RegistroUsuario("U10", "ruta1", "Bello", "Entrada", LocalDateTime.of(2026, 10, 13, 19, 57)),
                new RegistroUsuario("U2", "ruta2", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 20, 21)),
                new RegistroUsuario("U2", "ruta4", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 20, 34)),
                new RegistroUsuario("U4", "ruta3", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 20, 51)),
                new RegistroUsuario("U3", "ruta3", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 13, 20, 58)),
                new RegistroUsuario("U1", "ruta4", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 13, 21, 5)),
                new RegistroUsuario("U9", "ruta2", "Envigado", "Salida", LocalDateTime.of(2026, 10, 13, 21, 14)),
                new RegistroUsuario("U6", "ruta1", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 13, 21, 28)),
                new RegistroUsuario("U3", "ruta4", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 13, 21, 52)),
                new RegistroUsuario("U9", "ruta1", "Bello", "Salida", LocalDateTime.of(2026, 10, 13, 22, 0)),
                new RegistroUsuario("U3", "ruta3", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 13, 22, 22)),
                new RegistroUsuario("U3", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 13, 22, 37)),
                new RegistroUsuario("U4", "ruta3", "Envigado", "Salida", LocalDateTime.of(2026, 10, 13, 22, 50)),
                new RegistroUsuario("U1", "ruta1", "Bello", "Salida", LocalDateTime.of(2026, 10, 14, 5, 3)),
                new RegistroUsuario("U1", "ruta1", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 14, 5, 28)),
                new RegistroUsuario("U5", "ruta2", "Bello", "Salida", LocalDateTime.of(2026, 10, 14, 5, 50)),
                new RegistroUsuario("U7", "ruta1", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 14, 5, 59)),
                new RegistroUsuario("U9", "ruta1", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 14, 6, 22)),
                new RegistroUsuario("U9", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 14, 6, 28)),
                new RegistroUsuario("U5", "ruta3", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 14, 6, 44)),
                new RegistroUsuario("U4", "ruta2", "Bello", "Entrada", LocalDateTime.of(2026, 10, 14, 7, 0)),
                new RegistroUsuario("U9", "ruta4", "Envigado", "Entrada", LocalDateTime.of(2026, 10, 14, 7, 12)),
                new RegistroUsuario("U3", "ruta2", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 14, 7, 22)),
                new RegistroUsuario("U6", "ruta4", "San Antonio", "Entrada", LocalDateTime.of(2026, 10, 14, 7, 35)),
                new RegistroUsuario("U3", "ruta1", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 14, 7, 55)),
                new RegistroUsuario("U4", "ruta2", "San Antonio", "Salida", LocalDateTime.of(2026, 10, 14, 8, 11)),
                new RegistroUsuario("U5", "ruta2", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 14, 8, 22)),
                new RegistroUsuario("U7", "ruta3", "Niquia", "Entrada", LocalDateTime.of(2026, 10, 14, 8, 35)),
                new RegistroUsuario("U6", "ruta4", "Bello", "Salida", LocalDateTime.of(2026, 10, 14, 8, 40)),
                new RegistroUsuario("U2", "ruta3", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 14, 8, 46)),
                new RegistroUsuario("U2", "ruta4", "Niquia", "Salida", LocalDateTime.of(2026, 10, 14, 9, 4)),
                new RegistroUsuario("U10", "ruta1", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 14, 9, 17)),
                new RegistroUsuario("U1", "ruta4", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 14, 9, 33)),
                new RegistroUsuario("U7", "ruta1", "Bello", "Salida", LocalDateTime.of(2026, 10, 14, 9, 57)),
                new RegistroUsuario("U6", "ruta1", "Bello", "Salida", LocalDateTime.of(2026, 10, 14, 10, 18)),
                new RegistroUsuario("U5", "ruta4", "Niquia", "Salida", LocalDateTime.of(2026, 10, 14, 10, 32)),
                new RegistroUsuario("U9", "ruta2", "La Estrella", "Salida", LocalDateTime.of(2026, 10, 14, 10, 49)),
                new RegistroUsuario("U3", "ruta3", "Sabaneta", "Entrada", LocalDateTime.of(2026, 10, 14, 11, 3)),
                new RegistroUsuario("U5", "ruta2", "Sabaneta", "Salida", LocalDateTime.of(2026, 10, 14, 11, 22)),
                new RegistroUsuario("U8", "ruta4", "Bello", "Entrada", LocalDateTime.of(2026, 10, 14, 11, 43)),
                new RegistroUsuario("U8", "ruta2", "Bello", "Entrada", LocalDateTime.of(2026, 10, 14, 11, 57)),
                new RegistroUsuario("U9", "ruta3", "Poblado", "Entrada", LocalDateTime.of(2026, 10, 14, 12, 11)),
                new RegistroUsuario("U4", "ruta2", "La Estrella", "Entrada", LocalDateTime.of(2026, 10, 14, 12, 17))
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
// se nos pide que hallemos el momento en que hay mayor flujo de personas es las estaciones aqui tambien tenemos la llave, valor para poder recorrer los datos
// poder agruparlos hace un Map donde le asignamos una variable, luego llamamos a la variable horaPicoFlujo lo convertimos en un set y llamamos a la interfaz stream
// con el .max analizamos el mapa y se selecciona el dato mas alto de la llave hora, hace un conteo que se vuelve el valor y nos arroja nuestro resultado.

       Map.Entry<Integer, Long> maxFlujo = horaPicoFlujo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
               .orElse(null);
        System.out.println("El momento de mayor flujo es el horario de : "+ maxFlujo);

// se nos pide que analicemos las rutas con mayor acceso aqui de nuevo volvemos a implementar un tipo Map donde nos devolvera un tipo String y otro tipo int, hacemos la interfaz con stream
// luego hacemos una agrupacion por ruta con .collect donde usamos el metodo para contar por cada ruta su registo,
// luego volvemos a llamar a la variable rutaMayoracceso con un metodo entrySet el cual nos devolvria un conjunto de los datos , filtramos por el atributo entrada
// para luego hacer un un recorrido y que me ordene los datos de mayor a menor por el campo valor luego para mostrar el resultado aplicamos un forEach para recorrer los datos y presentarlos en orden.
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
// en esta se esta analizando sobre cuanto se puede demorar una persona de una estacion a otra por lo cual el analisis es mas comple
// donde instaciamos metodos de tipo int ya que el resultado es de tipo entero se usa la funcion rango para hallar la longitud de los resgistros, luego se filtra por el
// el id usuario para que nos de las estaciones los metodos .get sirve para extraer un dato en especifico
// luego con metodos de tipo fecha extraemos los minutos del atributo timestamp se toma un conteo entre los registros de la fecha, la hora y los minutos
// luego agrupamos los datos por la llave y luego por la clave, donde la llave me va a dar la estacion y el valor la cantidad de minutos
// luego con el forEach hacemos un recorrido para poder imprimir cada dato por parte su llave y su valor.
       var tiempoRecorrido = IntStream.range(0, registro.size()-1)
               .filter(i -> registro.get(i).idUsuario().equals(registro.get(i + 1).idUsuario()))
               .mapToObj(i -> new AbstractMap.SimpleEntry<>(
                       registro.get(i).estacion() + " -> " + registro.get(i + 1).estacion(),
                       ChronoUnit.MINUTES.between(registro.get(i).timestamp(), registro.get(i + 1).timestamp())
               ))
               .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.averagingLong(AbstractMap.SimpleEntry::getValue)));
       tiempoRecorrido.forEach((distancia, tiempo) -> System.out.println(distancia + " toma: "+ tiempo + " en minutos"));

// en estas lineas estamos analizando con datos simulados cuando una ruta tiene un maximo de ocupacion, aqui volvemos usar el Map para poder procesar nuestros valores
// de tipo String y Long para tener el resultado de los datos que queremos mostrar, usamos una agrupacion del metodo Collectors para agrupar por cada ruta y luego que nos haga un conteo
// luego uso esa misma variable superarUmbral para generar una lista, por lo cual se envuelve en un entryset es un tipo de conjuntos luego declaramos variables String para la ruta
// Long para la cantidad de ocupacion, hacemos un proceso logico donde si es mayor a 2 debemos decir que es critica y si no normal, luego con un tipo format imprimimos los resultados.

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
