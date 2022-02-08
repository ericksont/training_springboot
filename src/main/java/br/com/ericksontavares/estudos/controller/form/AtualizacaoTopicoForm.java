package br.com.ericksontavares.estudos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ericksontavares.estudos.modelo.Topico;
import br.com.ericksontavares.estudos.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
    
    @NotNull @NotEmpty @Length(min=5)
    private String titulo;
    @NotNull @NotEmpty @Length(min=10)
    private String mensagem;
    
    /*public Topico converter(CursoRepository repository){
        return new Topico(titulo, mensagem);
    }*/

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

    public Topico atualizar(Long id, TopicoRepository repository){
        Topico topico = repository.getById(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }

}
