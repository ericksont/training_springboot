package br.com.ericksontavares.estudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ericksontavares.estudos.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nomeCurso);
    
}
