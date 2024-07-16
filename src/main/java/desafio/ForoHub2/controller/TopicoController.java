package desafio.ForoHub2.controller;

import desafio.ForoHub2.domain.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopico datos) {
        Topico topico = new Topico();
        topico.setTitulo(datos.getTitulo());
        topico.setMensaje(datos.getMensaje());
        // Set curso and autor
        repository.save(topico);
    }

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Topico mostrar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping
    public void actualizar(@RequestBody DatosActualizarTopico datos) {
        Topico topico = repository.findById(datos.getId()).orElseThrow();
        topico.setTitulo(datos.getTitulo());
        topico.setMensaje(datos.getMensaje());
        repository.save(topico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
