// aqui tenemos un tipo de clase llamadas record, es un tipo de contenedor, la cual es util para el procesamiento de datos
// se importa la liberia LocalDateTime para poder ingresar datos de tipo fecha como años, mes, dia, hora y minutos y asi poder hacer un buen analisis
// por consiguiente se llama la clase record la cual reemplaza los constructores en java, con sus metodos geters y seters, lo cual ayuda a economizar
// mas lineas de codigos y sus metodos ya estan instanciadas para ser llamados por una variable o clase, nuestro record se llama RegistroUsuario donde
// instanciamos nuestro atributos de tipo String y LocalDateTime donde al final se agregan {} para llamar el constructor

import java.time.LocalDateTime;

public record RegistroUsuario(
        String idUsuario,
        String ruta,
        String estacion,
        String accion,
        LocalDateTime timestamp
) {}

