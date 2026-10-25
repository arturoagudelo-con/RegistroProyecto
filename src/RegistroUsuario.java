import java.time.LocalDateTime;

public record RegistroUsuario(
        String idUsuario,
        String ruta,
        String estacion,
        String accion,
        LocalDateTime timestamp
) {}

