package desafio.ForoHub2.domain.topico;

import lombok.Data;

@Data
public class DatosRegistroTopico {
    private String titulo;
    private String mensaje;
    private Long cursoId;
    private Long autorId;
}
