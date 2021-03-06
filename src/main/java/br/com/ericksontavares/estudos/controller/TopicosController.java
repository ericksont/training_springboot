package br.com.ericksontavares.estudos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ericksontavares.estudos.controller.dto.DetalhesDoTopicoDTO;
import br.com.ericksontavares.estudos.controller.dto.TopicoDTO;
import br.com.ericksontavares.estudos.controller.form.AtualizacaoTopicoForm;
import br.com.ericksontavares.estudos.controller.form.TopicoForm;
import br.com.ericksontavares.estudos.modelo.Topico;
import br.com.ericksontavares.estudos.repository.CursoRepository;
import br.com.ericksontavares.estudos.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = repository.findAll();
            return TopicoDTO.converter(topicos);
        } else {
            List<Topico> topicos = repository.findByCursoNome(nomeCurso);
            return TopicoDTO.converter(topicos);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder){
        Topico topico = topicoForm.converter(cursoRepository);
        repository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id){
        Optional<Topico> topico = repository.findById(id);
        if(topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoTopicoDTO(topico.get()));
        } 
        
        return ResponseEntity.notFound().build();
        
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm topicoForm){
        Optional<Topico> optional = repository.findById(id);
        if(optional.isPresent()) {
            Topico topico = topicoForm.atualizar(id, repository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        } 
        
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico> optional = repository.findById(id);
        if(optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } 
        
        return ResponseEntity.notFound().build();
        
    }
    
}
