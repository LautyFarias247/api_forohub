package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        var topicos =  repository.findAll(paginacion).map(DatosRespuestaTopico::new);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> detalleTopico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);

        return  ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> publicarTopico(
            @RequestBody @Valid DatosPublicarTopico datos,
            UriComponentsBuilder uriComponentsBuilder){

        var topico = repository.save(new Topico(datos));

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosRespuestaTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos){
        Topico topico = repository.getReferenceById(id);
        topico.actualizarDatos(datos);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Null> borrarTopico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        repository.delete(topico);

        return ResponseEntity.noContent().build();
    }
}
