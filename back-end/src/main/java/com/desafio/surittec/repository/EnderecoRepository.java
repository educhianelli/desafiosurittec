package com.desafio.surittec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.surittec.entity.EnderecoEntity;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

	EnderecoEntity findById(long id);
}

