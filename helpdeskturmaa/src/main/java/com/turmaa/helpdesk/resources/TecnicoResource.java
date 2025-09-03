package com.turmaa.helpdesk.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.turmaa.helpdesk.domain.Tecnico;
import com.turmaa.helpdesk.domain.dtos.TecnicoDTO;
import com.turmaa.helpdesk.service.TecnicoService;


/**
 * Controlador REST para a entidade {@link com.wagner.helpdesk.domain.Tecnico}.
 * <p>
 * Esta classe define os endpoints da API para operações relacionadas aos técnicos.
 * Anotada com {@code @RestController} para indicar que é um controlador Spring que
 * lida com requisições REST, e com {@code @RequestMapping} para definir o caminho base
 * da URL para todos os seus endpoints.
 * </p>
 */
@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	/**
	 * Injeção de dependência da camada de serviço {@link TecnicoService}.
	 * O Spring cria e gerencia a instância do serviço, que contém a lógica de negócio.
	 */
	@Autowired
	private TecnicoService service;

	/**
	 * Endpoint que busca um técnico por seu ID.
	 * <p>
	 * Responde a requisições GET para a URL {@code /tecnicos/{id}}. O valor do ID
	 * é extraído da URL usando a anotação {@code @PathVariable}.
	 * </p>
	 *
	 * @param id O ID do técnico a ser encontrado, extraído do caminho da URL.
	 * @return Um {@link org.springframework.http.ResponseEntity} contendo o {@link TecnicoDTO}
	 * correspondente ao ID. Retorna um status HTTP 200 (OK) se a busca for bem-sucedida.
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {

		Tecnico obj = service.findById(id);

		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {
		List<TecnicoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDto) {
		Tecnico newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).body(new TecnicoDTO(newObj));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDto) {
		Tecnico updatedObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new TecnicoDTO(updatedObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}