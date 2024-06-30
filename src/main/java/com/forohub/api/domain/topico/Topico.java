package com.forohub.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Long usuario;
    private String curso;

    public Topico(DatosPublicarTopico datos){
        this.curso = datos.curso();
        this.usuario = datos.usuario();
        this.fecha = LocalDateTime.now();
        this.mensaje = datos.mensaje();
        this.titulo = datos.titulo();
    }

    public void actualizarDatos(DatosActualizarTopico datos) {
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if(datos.curso() != null){
            this.curso = datos.curso();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Long getUsuario() {
        return usuario;
    }

    public String getCurso() {
        return curso;
    }
}

