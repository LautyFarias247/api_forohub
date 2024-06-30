package com.forohub.api.domain.topico;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        String curso,
        Long usuario
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getCurso(), topico.getUsuario());
    }
}
