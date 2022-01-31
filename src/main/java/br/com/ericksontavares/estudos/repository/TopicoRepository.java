package br.com.ericksontavares.estudos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ericksontavares.estudos.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByCursoNome(String nomeCurso);
    
}
