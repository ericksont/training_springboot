package br.com.ericksontavares.estudos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ericksontavares.estudos.modelo.Curso;
import br.com.ericksontavares.estudos.modelo.Topico;
import br.com.ericksontavares.estudos.repository.CursoRepository;



public class TopicoForm {

    @NotNull @NotEmpty @Length(min=5)
    private String titulo;
    @NotNull @NotEmpty @Length(min=10)
    private String mensagem;
    @NotNull @NotEmpty @Length(min=5)
    private String nomeCurso;

    public Topico converter(CursoRepository repository){
        Curso curso = repository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return this.nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

}
