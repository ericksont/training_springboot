package br.com.ericksontavares.estudos.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ericksontavares.estudos.modelo.Topico;

public class TopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDTO> converter(List<Topico> topicos){
        return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

}
