package com.desafio.surittec.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.surittec.entity.ClienteEntity;
import com.desafio.surittec.entity.EnderecoEntity;
import com.desafio.surittec.entity.TelefoneEntity;
import com.desafio.surittec.repository.ClienteRepository;
import com.desafio.surittec.repository.EmailRepository;
import com.desafio.surittec.repository.EnderecoRepository;
import com.desafio.surittec.repository.TelefoneRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Transactional
	public ClienteEntity cadastraCliente(@RequestBody ClienteEntity cliente) {
		ClienteEntity clientePersist = repository.save(cliente);
		clientePersist.getEndereco().setCliente(clientePersist);
		clientePersist.getTelefones().forEach(t -> t.setCliente(clientePersist));
		clientePersist.getEmails().forEach(e -> e.setCliente(clientePersist));
		enderecoRepository.save(clientePersist.getEndereco());
		telefoneRepository.saveAll(clientePersist.getTelefones());
		emailRepository.saveAll(clientePersist.getEmails());
		return clientePersist;
	}
	
	public ClienteEntity deletaCliente(Long id) throws ObjectNotFoundException {
		ClienteEntity c = buscaClientePorId(id);
		repository.deleteById(id);
		return c;
		
	}
	
	public ClienteEntity atualizaCliente(ClienteEntity clienteEntity,Long id) throws ObjectNotFoundException {
		ClienteEntity cliente= buscaClientePorId(id);
		if(cliente == null) {
			throw new EmptyResultDataAccessException(1);
		}
		cliente.setNome(clienteEntity.getNome());
		cliente.setCpf(clienteEntity.getCpf());
		/*
		for (EnderecoEntity e : clienteEntity.getEnderecos()) {
			e.setCliente(cliente);
			cliente.getEnderecos().add(e);
		}
		
		for (TelefoneEntity t : clienteEntity.getTelefones()) {
			t.setCliente(cliente);
			cliente.getTelefones().add(t);
		}
		cliente.setTelefones(clienteEntity.getTelefones());
		*/
		cliente = repository.save(cliente);
		
		//enderecoRepository.saveAll(cliente.getEnderecos());
		//telefoneRepository.saveAll(cliente.getTelefones());
		
		return cliente;
	}

	
	public List<ClienteEntity>buscaClienteLikeNome(String nome){
		List<ClienteEntity> clientes = repository.findByNomeContaining(nome);
		return clientes;
	}
	public List<ClienteEntity> listaClientes() {
		List<ClienteEntity> listaCliente  = repository.findAll();
		return listaCliente;
	}
	
	public ClienteEntity buscaClientePorId(long id) throws ObjectNotFoundException {
		Optional<ClienteEntity> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente: " + id + "não encontrado!" ));
	}
	
	
	
	
	
	
	
}
