package com.desafio.surittec.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.surittec.entity.ClienteEntity;
import com.desafio.surittec.repository.ClienteRepository;
import com.desafio.surittec.repository.filter.ClienteFilter;
import com.desafio.surittec.service.ClienteService;
import com.desafio.surittec.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
@Api(value = "API REST CLIENTE")
public class ClienteRestController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService service;
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(path="listaTodos")
	@ApiOperation(value = "Retorna uma lista de clientes.")
	@PreAuthorize("hasAuthority('ROLE_COMUM')")
	private ResponseEntity<?> listaClientes() {
		return new ResponseEntity<>(service.listaClientes(), HttpStatus.OK);
	}
	
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de clientes com base nos filtros.")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	private List<ClienteEntity> pesquisar(ClienteFilter clienteFilter) {
		return clienteRepository.filtrar(clienteFilter);
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Busca um cliente pelo ID")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	private ResponseEntity<?> listaClientePorId(@PathVariable(value = "id") long id) throws Exception {
		verificaSeClienteExiste(id);
		ClienteEntity cliente = service.buscaClientePorId(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra um cliente")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> cadastraCliente(@Valid @RequestBody ClienteEntity cliente) {
		return new ResponseEntity<>(service.cadastraCliente(cliente), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "{id}")
	@ApiOperation(value = "Deleta um cliente")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> deletaCliente(@PathVariable(value = "id") long id) throws Exception {		
		return new ResponseEntity<>(service.deletaCliente(id), HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Atualiza um Cliente")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> atualizaCliente(@Valid @RequestBody ClienteEntity cliente, @PathVariable(value = "id") long id) throws Exception {
		return new ResponseEntity<>(service.atualizaCliente(cliente,id),HttpStatus.OK);
	}

	private void verificaSeClienteExiste(Long id) throws Exception {
		if (service.buscaClientePorId(id) == null)
			throw new Exception("Cliente não encontrado!");
	}
}