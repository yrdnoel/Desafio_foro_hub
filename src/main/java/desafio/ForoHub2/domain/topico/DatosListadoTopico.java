package desafio.ForoHub2.domain.topico;

import lombok.Data;

@Data
public class DatosListadoTopico {
    private Long id;
    private String titulo;
    private String mensaje;
    private String curso;
    private String autor;
    private String estatus;
}
