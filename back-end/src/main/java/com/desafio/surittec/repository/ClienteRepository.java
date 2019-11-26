package com.desafio.surittec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.desafio.surittec.entity.ClienteEntity;
import com.desafio.surittec.repository.cliente.ClienteRepositoryQuery;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> , ClienteRepositoryQuery{

	public List<ClienteEntity> findByNomeContaining(@Param("nome")String nome);
}
