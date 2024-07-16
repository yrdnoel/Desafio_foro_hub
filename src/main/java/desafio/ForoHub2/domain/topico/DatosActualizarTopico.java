package desafio.ForoHub2.domain.topico;

import lombok.Data;

@Data
public class DatosActualizarTopico {
    private Long id;
    private String titulo;
    private String mensaje;
}
